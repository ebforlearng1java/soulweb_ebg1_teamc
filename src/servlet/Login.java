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

public class Login extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// 画面入力内容の取得
		String userName = request.getParameter("USERNAME");
		String password = request.getParameter("PASSWORD");
		String eBtn = request.getParameter("EBTN"); // イベントボタン

		System.out.println(userName + ":" + password);
		HttpSession session = request.getSession(true);

		// ユーザ有無フラグを取得
	    String userFlg = "";
		// イベントボタンが"2"の場合、新規登録画面へ遷移
		if ("2".equals(eBtn)) {
			response.sendRedirect("/register.jsp");

		// イベントボタンが"1"の場合、ログイン処理を実施する
		} else {

			try {

				userFlg = loginLogic(userName, password,request,response);

			} catch (SQLException e) {
				try {
					DBConnection.dbConClose();
				} catch (SQLException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			// ユーザ有無の判断
			if ("1".equals(userFlg)) {
				// sessionへユーザＩＤを設定する
				// TODO
		        session.setAttribute("userid", userName);

				// 既に登録済みの場合、FIND画面へ遷移
				response.sendRedirect("/find.jsp");
			} else {
				// エラーメッセージを設定
				request.setAttribute("errormsg", "ユーザ存在しません");
				// 登録されない場合、自画面へ遷移
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		// sessionへユーザ有無の判断フラグを設定する
		 session.setAttribute("userUmFlg" , userFlg);
	}

	public String loginLogic(String user, String pw, HttpServletRequest request,
			HttpServletResponse response) throws SQLException {

		// 戻り値 "1" ユーザ登録済み
		//        "2" ユーザ存在しない
		String rtn = "";
		String sql = "SELECT * FROM soul_login_t "
				+ "where soul_login_mail = '" + user + "'"
				+ " AND soul_pw = '" + pw + "'";

		// soul_login_t ヘ検索
		ResultSet resultSet = DBConnection.getDBConnection().executeQuery(sql);

		if (resultSet.next()) {
			rtn = "1";
		} else {
			rtn = "2";
		}
		resultSet.close();
		DBConnection.dbConClose();

		return rtn;

	}

}