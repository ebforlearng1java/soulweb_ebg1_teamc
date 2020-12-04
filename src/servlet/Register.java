package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmn.DBConnection;

public class Register extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(true);
		// ユーザ有無フラグを取得
		String userFlg = (String) session.getAttribute("userUmFlg");
		// イベントボタン
		String eBtn = request.getParameter("EBTN");
		String userId = (String) session.getAttribute("userid");
		String soulName = "";
		String soulSex = "";
		String birthday = "";
		String star = "";
		String city = "";
		String hobby1 = "";
		String hobby2 = "";
		String hobby3 = "";
		String hobby4 = "";
		String hobby5 = "";
		String hobby6 = "";
		String soulLoginMail = "";
		String password = "";
		if ("1".equals(userFlg)) {
			soulName = (String) session.getAttribute("sessionLoginUserNAME");
			soulSex = (String) session.getAttribute("sessionLoginUserSEX");
			birthday = (String) session.getAttribute("sessionLoginUserBIRTHDAY");
			star = (String) session.getAttribute("sessionLoginUserSTAR");
			city = (String) session.getAttribute("sessionLoginUserCITY");
			hobby1 = (String) session.getAttribute("sessionLoginUserHOBBY1");
			hobby2 = (String) session.getAttribute("sessionLoginUserHOBBY2");
			hobby3 = (String) session.getAttribute("sessionLoginUserHOBBY3");
			hobby4 = (String) session.getAttribute("sessionLoginUserHOBBY4");
			hobby5 = (String) session.getAttribute("sessionLoginUserHOBBY5");
			hobby6 = (String) session.getAttribute("sessionLoginUserHOBBY6");

		} else {
			// 画面から入力内容を取得
			soulName = request.getParameter("USERNAME");
			soulSex = request.getParameter("SEX");
			String year = request.getParameter("YEAR");
			String month = request.getParameter("MONTH");
			String day = request.getParameter("DAY");
			StringBuffer birthdaySB = new StringBuffer();
			birthdaySB.append(year).append(month).append(day);
			birthday = birthdaySB.toString();
			star = request.getParameter("STAR");
			city = request.getParameter("CITY");
			hobby1 = request.getParameter("HOBBY1");
			hobby2 = request.getParameter("HOBBY2");
			hobby3 = request.getParameter("HOBBY3");
			hobby4 = request.getParameter("HOBBY4");
			hobby5 = request.getParameter("HOBBY5");
			hobby6 = request.getParameter("HOBBY6");
			soulLoginMail = request.getParameter("MAIL");
			password = request.getParameter("PASSWORD");
		}

		// 処理区分フラグを設定する（１：新規登録；２：更新）
		Integer KubnFlg = 0;
		String JyKyFlg = "0";
		// 新規登録を実施する
		if (eBtn == "4") {
			try {
				KubnFlg = 1;
				JyKyFlg = registerLogic(userId, soulName, soulSex, birthday, star, city, hobby1, hobby2, hobby3, hobby4,
						hobby5, hobby6, soulLoginMail,
						password, KubnFlg);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			// 更新を実施する
		} else {
			try {
				KubnFlg = 2;
				JyKyFlg = registerLogic(userId, soulName, soulSex, birthday, star, city, hobby1, hobby2, hobby3, hobby4,
						hobby5, hobby6, soulLoginMail,
						password, KubnFlg);

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}

		// 処理状況の判断
		if ("1".equals(JyKyFlg)) {

			// メッセージを設定
			request.setAttribute("msg", "ユーザを成功に登録しました。");
			// 自画面へ遷移
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		} else if ("2".equals(JyKyFlg)) {
			// メッセージを設定
			request.setAttribute("msg", "ユーザを成功に更新しました。");
			// 自画面へ遷移
			request.getRequestDispatcher("/find.jsp").forward(request, response);
		} else {
			// メッセージを設定
			request.setAttribute("msg", "エラーが発生します。");
			// 自画面へ遷移
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}

		// 重置を実施する
		if (eBtn == "3") {
			// 新規登録の場合
			if (!"1".equals(userFlg)) {
				soulName = "";
				soulSex = "";
				birthday = "";
				star = "";
				city = "";
				hobby1 = "";
				hobby2 = "";
				hobby3 = "";
				hobby4 = "";
				hobby5 = "";
				hobby6 = "";
				soulLoginMail = "";
				password = "";
				// 更新の場合
			} else {
				star = "";
				city = "";
				hobby1 = "";
				hobby2 = "";
				hobby3 = "";
				hobby4 = "";
				hobby5 = "";
				hobby6 = "";

			}
		}

	}

	public String registerLogic(String userId, String soulName, String soulSex,
			String birthday, String star, String city,
			String hobby1, String hobby2, String hobby3, String hobby4, String hobby5, String hobby6,
			String soulLoginMail, String password, Integer KubnFlg) throws SQLException {

		// 戻り値 "1" ユーザ新規登録成功
		//        "2" ユーザ更新成功
		//        "3" ユーザ登録・更新失敗
		String rtn = "";
		// 登録
		if (KubnFlg == 1) {
			StringBuffer sql1SB = new StringBuffer();
			sql1SB.append("INSERT INTO soul_login_t (soul_userid, soul_login_mail, soul_pw)")
					.append("VALUES ((SELECT max(soul_userid) + 1 from soul_login_t),")
					.append(soulLoginMail).append(",")
					.append(password).append(");");
			String sql1 = sql1SB.toString();
			StringBuffer sql2SB = new StringBuffer();
			sql2SB.append(
					"INSERT INTO soul_userinfo_t (soul_userid, soul_name, soul_sex, birthday, star, city, hobby1,hobby2,hobby3,hobby4,hobby5,hobby6)")
					.append("VALUES ((SELECT max(soul_userid) + 1 from soul_login_t),")
					.append(soulName).append(",")
					.append(soulSex).append(",")
					.append(birthday).append(",")
					.append(star).append(",")
					.append(city).append(",")
					.append(hobby1).append(",")
					.append(hobby2).append(",")
					.append(hobby3).append(",")
					.append(hobby4).append(",")
					.append(hobby5).append(",")
					.append(hobby6).append(");");
			String sql2 = sql2SB.toString();
			// soul_login_t ヘ登録
			ResultSet resultSet1 = DBConnection.getDBConnection().executeQuery(sql1);
			// soul_userinfo_tへ登録
			ResultSet resultSet2 = DBConnection.getDBConnection().executeQuery(sql2);

			if (resultSet1.next() && resultSet2.next()) {
				rtn = "1";
			} else {
				rtn = "3";
			}

			resultSet1.close();
			resultSet2.close();

		}
		// 更新
		if (KubnFlg == 2) {
			StringBuffer sql3SB = new StringBuffer();
			sql3SB.append("UPDATE soul_userinfo_t SET star= '")
					.append(star).append("' ,city = '")
					.append(city).append("' ,hobby1 = '")
					.append(hobby1)
					.append("' ,hobby2 = '")
					.append(hobby2)
					.append("' ,hobby3 = '")
					.append(hobby3)
					.append("' ,hobby4 = '")
					.append(hobby4)
					.append("' ,hobby5 = '")
					.append(hobby5)
					.append("' ,hobby6 = '")
					.append(hobby6)
					.append( "WHERE soul_userid = '")
					.append(userId)
					.append("';");
			String sql3 = sql3SB.toString();
			// soul_userinfo_tへ更新
			ResultSet resultSet3 = DBConnection.getDBConnection().executeQuery(sql3);

			if (resultSet3.next()) {
				rtn = "2";
			} else {
				rtn = "3";
			}

			resultSet3.close();

		}

		DBConnection.dbConClose();

		return rtn;

	}
}