package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmn.DBConnection;
import dto.FindLogicDTO;

public class Find extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(true);
		String eBtn = request.getParameter("EBTN"); // イベントボタン
		// SOULボタンを押下した場合
		if ("5".equals(eBtn)) {
		// セッション情報.ログインユーザID　でユーザ情報を取得する

        String sessionLoginUserID = session.getAttribute("userid").toString();

		// 同生年月日　or 同興味　or　同星座　or 同場所のユーザListを取得する
        ArrayList<FindLogicDTO> findedList = new ArrayList<FindLogicDTO>();
		try {
			findedList = findLogic(sessionLoginUserID,request,response);
		} catch (SQLException e) {
			//自動生成された catch ブロック
			e.printStackTrace();
		}

		// 取得結果は0件の場合
		if (findedList.size() == 0) {

			// メッセージを設定
			request.setAttribute("msg", "検索結果が0件です");
			// 自画面へ遷移
			request.getRequestDispatcher("/find.jsp").forward(request, response);
		// ０件以外の場合、show画面へ遷移
		} else {

			// Findリストをsessionへ格納する
			session.setAttribute("findlist", findedList);

			// show画面へ遷移
			response.sendRedirect("/show.jsp");
		}
		// ログオフボタンを押下した場合
		} else if ("6".equals(eBtn)) {

			// register画面へ遷移
			response.sendRedirect("/register.jsp");

		}else if ("7".equals(eBtn)){

			session.removeAttribute("userid");
			session.invalidate();
		}
	}

	public ArrayList<FindLogicDTO> findLogic(String sessionLoginUserID,HttpServletRequest request, HttpServletResponse response) throws SQLException {


		// ログインユーザ情報を取得する
		String sql4 = "SELECT * from soul_userinfo_t where SOUL_USERID = '" +
				sessionLoginUserID + "'";
		// ログインユーザ情報を検索する
		ResultSet resultSet4 = DBConnection.getDBConnection().executeQuery(sql4);

		// ログインユーザの情報をセッションに設定する
		HttpSession session = request.getSession(true);
		String sessionLoginUserNAME = resultSet4.getString("soul_name");
		String sessionLoginUserSEX = resultSet4.getString("soul_sex");
		String sessionLoginUserBIRTHDAY = resultSet4.getString("birthday");
		String sessionLoginUserSTAR = resultSet4.getString("star");
		String sessionLoginUserCITY = resultSet4.getString("city");
		String sessionLoginUserHOBBY1 = resultSet4.getString("hobby1");
		String sessionLoginUserHOBBY2 = resultSet4.getString("hobby2");
		String sessionLoginUserHOBBY3 = resultSet4.getString("hobby3");
		String sessionLoginUserHOBBY4 = resultSet4.getString("hobby4");
		String sessionLoginUserHOBBY5 = resultSet4.getString("hobby5");
		String sessionLoginUserHOBBY6 = resultSet4.getString("hobby6");
		session.setAttribute("sessionLoginUserNAME", sessionLoginUserNAME);
		session.setAttribute("sessionLoginUserSEX", sessionLoginUserSEX);
		session.setAttribute("sessionLoginUserBIRTHDAY", sessionLoginUserBIRTHDAY);
		session.setAttribute("sessionLoginUserSTAR", sessionLoginUserSTAR);
		session.setAttribute("sessionLoginUserCITY", sessionLoginUserCITY);
		session.setAttribute("sessionLoginUserHOBBY1", sessionLoginUserHOBBY1);
		session.setAttribute("sessionLoginUserHOBBY2", sessionLoginUserHOBBY2);
		session.setAttribute("sessionLoginUserHOBBY3", sessionLoginUserHOBBY3);
		session.setAttribute("sessionLoginUserHOBBY4", sessionLoginUserHOBBY4);
		session.setAttribute("sessionLoginUserHOBBY5", sessionLoginUserHOBBY5);
		session.setAttribute("sessionLoginUserHOBBY6", sessionLoginUserHOBBY6);
		// 戻り値リスト
		ArrayList<FindLogicDTO> resultList = new ArrayList<FindLogicDTO>();

		// Ｆｉｎｄロジック
		String sql5 = "SELECT  T2.soul_login_mail as mail,"
				+ "T1.soul_userid as id,"
				+ "T1.soul_name as name,"
				+ "T1.birthday,"
				+ "T1.star,"
				+ "T1.city,"
				+ "T1.hobby1,"
				+ "T1.hobby2,"
				+ "T1.hobby3,"
				+ "T1.hobby4,"
				+ "T1.hobby5,"
				+ "T1.hobby6 "
				+ "FROM soul_userinfo_t T1 INNER join  soul_login_t T2 "
				+ "where T1.soul_userid = T2.soul_userid "
				+ "and "
				+ "T1.birthday" + "= '" + sessionLoginUserBIRTHDAY + "' or"
				+ "T1.star = '" + sessionLoginUserSTAR + "' or"
				+ "T1.city = '" + sessionLoginUserCITY + "' or"
				+ "hobby1 = '" + sessionLoginUserHOBBY1 + "' or "
				+ "hobby2 = '" + sessionLoginUserHOBBY2 + "'  or "
				+ "hobby3 = '" + sessionLoginUserHOBBY3 + "'  or "
				+ "hobby4 = '" + sessionLoginUserHOBBY4 + "'  or"
				+ "hobby5 = '" + sessionLoginUserHOBBY5 + "'  or"
				+ "hobby6 = '" + sessionLoginUserHOBBY6 + "' ;";

		// 同生年月日　or 同興味　or　同星座　or 同場所のユーザを取得する
		ResultSet resultSet5 = DBConnection.getDBConnection().executeQuery(sql5);

		// 同生年月日　or 同興味　or　同星座　or 同場所のユーザリストを取得する
		while (resultSet5.next()) {

			FindLogicDTO dto = new FindLogicDTO();
			// ユーザ番号
			dto.setSoul_userid(resultSet5.getString("id"));
			// 名称
			dto.setSoul_name(resultSet5.getString("name"));
			// 生年月日
			dto.setBirthday(resultSet5.getString("birthday"));
			// 星座
			dto.setStar(resultSet5.getString("star"));
			// 都市
			dto.setCity(resultSet5.getString("city"));
			// 趣味１
			dto.setHobby1(resultSet5.getString("hobby1"));
			// 趣味２
			dto.setHobby2(resultSet5.getString("hobby2"));
			// 趣味３
			dto.setHobby3(resultSet5.getString("hobby3"));
			// 趣味４
			dto.setHobby4(resultSet5.getString("hobby4"));
			// 趣味５
			dto.setHobby5(resultSet5.getString("hobby5"));
			// 趣味６
			dto.setHobby6(resultSet5.getString("hobby6"));
			// メール
			dto.setSoul_login_mail(resultSet5.getString("mail"));

			resultList.add(dto);
		}


		resultSet5.close();
		DBConnection.dbConClose();

		return resultList;

	}

}
