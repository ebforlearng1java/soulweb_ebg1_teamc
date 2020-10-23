<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>< SOUL ></h1>
	<Form action="Login">


		<table style="width: 100%">

			<tr>
				<td>＊</td>
				<td>ＳＯＵＬ名：</td>
				<td colspan="4"><input type="text"></td>
			</tr>
			<tr>
				<td>＊</td>
				<td>PW：</td>
				<td colspan="4"><input type="text"></td>
			</tr>
		</table>

		<input type="submit" value="登録">

		<%
		int i = 1;
		if (i == 0) {
		%>
		<input type="submit" value="取り消し">
		<%
			}
		%>


	</Form>

</body>
</html>