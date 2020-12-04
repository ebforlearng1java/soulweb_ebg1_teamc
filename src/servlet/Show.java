package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmn.DBConnection;
import dto.FindLogicDTO;
import dto.ShowDto;

public class Show extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// ログインユーザに関する情報セッションを取得
		HttpSession session = request.getSession(true);
		String sessionLoginUserID = session.getAttribute("userid").toString();
		String LoginUserBirthday = (String) session.getAttribute("sessionLoginUserBIRTHDAY");
		String LoginUserStar = (String) session.getAttribute("sessionLoginUserSTAR");
		String LoginUserCity = (String) session.getAttribute("sessionLoginUserCITY");
		String LoginUserHobby1 = (String) session.getAttribute("sessionLoginUserHOBBY1");
		String LoginUserHobby2 = (String) session.getAttribute("sessionLoginUserHOBBY2");
		String LoginUserHobby3 = (String) session.getAttribute("sessionLoginUserHOBBY3");
		String LoginUserHobby4 = (String) session.getAttribute("sessionLoginUserHOBBY4");
		String LoginUserHobby5 = (String) session.getAttribute("sessionLoginUserHOBBY5");
		String LoginUserHobby6 = (String) session.getAttribute("sessionLoginUserHOBBY6");

		// 同生年月日　or 同興味　or　同星座　or 同場所のユーザListセッションを取得する
		ArrayList<FindLogicDTO> findedList = (ArrayList<FindLogicDTO>) session.getAttribute("findlist");

		HashMap<String, String> payStatus = new HashMap<String, String>();
		try {
			payStatus = showLogic(sessionLoginUserID);
		} catch (SQLException e) {
			//自動生成された catch ブロック
			e.printStackTrace();
		}

		// showListを設定する
		ArrayList<ShowDto> showList = new ArrayList<ShowDto>();
		ShowDto showDto = new ShowDto();


		for (int i = 0; i < findedList.size(); i++) {
			showDto = showList.get(i);
			// イベントボタン
			String eBtn = request.getParameter("EBTN");
			// 名称
			showDto.setSoul_name(findedList.get(i).getSoul_name());
			// payボタンを押下した場合
			if ("8".equals(eBtn)) {
				String sql7 = "INSERT INTO soul_paystatus_t (soul_userid , soul_target_userid) " +
						findedList.get(i).getSoul_userid() + "," + sessionLoginUserID +
						");";
				ResultSet resultSet7;
				try {
					resultSet7 = DBConnection.getDBConnection().executeQuery(sql7);
					resultSet7.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				payStatus.put(findedList.get(i).getSoul_userid(), "1");
			}

			if (!"1".equals(payStatus.get(findedList.get(i).getSoul_userid()))) {
				// 非会員表示文字
				StringBuffer payBeforeTextSB = new StringBuffer();
				// 同生年月日
				if (LoginUserBirthday.equals(findedList.get(i).getBirthday())) {
					payBeforeTextSB.append("同生年月日");
				}
				// 同星座
				if (LoginUserStar.equals(findedList.get(i).getStar())) {
					payBeforeTextSB.append("、同場所");
				}
				// 同場所
				if (LoginUserCity.equals(findedList.get(i).getCity())) {
					payBeforeTextSB.append("、同場所");
				}
				// 同趣味
				if (LoginUserHobby1.equals(findedList.get(i).getHobby1())
						|| LoginUserHobby2.equals(findedList.get(i).getHobby2())
						|| LoginUserHobby3.equals(findedList.get(i).getHobby3())
						|| LoginUserHobby4.equals(findedList.get(i).getHobby4())
						|| LoginUserHobby5.equals(findedList.get(i).getHobby5())
						|| LoginUserHobby6.equals(findedList.get(i).getHobby6())) {
					payBeforeTextSB.append("、同趣味");
				}
				String payBeforeText = payBeforeTextSB.toString();
				showDto.setPayBeforeText(payBeforeText);
				showDto.setPayFlg("0");
			} else {
				showDto.setPayAfterText(findedList.get(i).getSoul_login_mail());
				showDto.setPayFlg("1");
			}
			showList.add(showDto);

		}
		//　自画面遷移
		response.sendRedirect("/find.jsp");
	}

	public HashMap<String, String> showLogic(String sessionLoginUserID) throws SQLException {

		// 戻り値を設定する
		HashMap<String, String> result = new HashMap<String, String>();

		// soul_paystatus_t情報を取得する
		String sql6 = "SELECT * from soul_paystatus_t where soul_target_userid  = '" +
				sessionLoginUserID + "';";

		ResultSet resultSet6 = DBConnection.getDBConnection().executeQuery(sql6);
		while (resultSet6.next()) {
			result.put(resultSet6.getString("soul_userid"), "1");
		}

		resultSet6.close();
		DBConnection.dbConClose();

		return result;

	}

}