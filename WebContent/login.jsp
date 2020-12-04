<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
         * {
				margin: 0px;
			}
			#content {
				margin: 150px auto;
				width: 100%;
				height: 460px;
				border: 1px transparent solid;
				background-color: #21D4FD;
				background-image: linear-gradient(243deg, #21D4FD 0%, #B721FF 100%);
				background-image: -webkit-linear-gradient(243deg, #21D4FD 0%, #B721FF 100%);
				background-image: -moz-linear-gradient(243deg, #21D4FD 0%, #B721FF 100%);
				background-image: -o-linear-gradient(243deg, #21D4FD 0%, #B721FF 100%);
			}
			#box {
				margin: 50px auto;
				width: 30%;
				height: 280px;
				background-color: #eee;
				text-align: center;
				border-radius: 15px;
				border: 2px #fff solid;
				box-shadow: 10px 10px 5px #000000;
			}
			.title {
				line-height: 58px;
				margin-top: 20px;
				font-size: 36px;
				color: #000;
				height: 58px;
			}
			#box:hover {
				border: 2px #fff solid;
			}
			.input {
				margin-top: 20px;
			}
			input {
				margin-top: 5px;
				outline-style: none;
				border: 1px solid #ccc;
				border-radius: 3px;
				padding: 13px 14px;
				width: 16%;
				font-size: 14px;
				font-weight: 700;
				font-family: "Microsoft soft";
			}
			button {
				margin-top: 20px;
				border: none;
				color: #000;
				padding: 15px 32px;
				text-align: center;
				text-decoration: none;
				display: inline-block;
				font-size: 16px;
				border-radius: 15px;
				background-color: #CCCCCC;
			}
			button:hover{
				background-color: #B721FF;
				color: #fff;
			}
		</style>
<script>
function submitLogic(btnNo) {
	if (btnNo == 1) {
		document.mainForm.EBTN.value = "1";// ログイン
	}else if (btnNo == 2) {
		document.mainForm.EBTN.value = "2";// 新規登録
	}
	// 遷移ロジック
	document.mainForm.submit();
}
</script>
</head>
<body>
<%
if (request.getAttribute("errormsg") == null) {
	request.setAttribute("errormsg", "");
}
if (request.getAttribute("USERNAME") == null) {
	request.setAttribute("USERNAME", "");
}
if (request.getAttribute("PASSWORD") == null) {
	request.setAttribute("PASSWORD", "");
}
%>

<form name="mainForm"  action="Login"  method="post">
	<span><%=request.getAttribute("errormsg")%></span>
	<br>
	<br>

	<span>Ｍail：</span>
	<input id="username" name="USERNAME" type="text" size="20" value="<%=request.getAttribute("USERNAME")%>" />
    <br>

	<span>P W ：</span>
	<input id="password" name="PASSWORD" type="password" size="21" value="<%=request.getAttribute("PASSWORD")%>" />
	<br>
	<input id="eBtn" name="EBTN" type="hidden" value="<%=request.getAttribute("EBTN")%>" />

	<button type="button" onclick="submitLogic(1)">ログイン</button>
    <button type="button" onclick="submitLogic(2)">新規登録</button>

    <br>

</form>

</body>
</html>
