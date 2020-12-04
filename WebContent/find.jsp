<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find</title>
<style type="text/css">
* {
	margin: 0px;
}

.center {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 200px;
	height: 30px;
}

.rig {
	width: 310px;
	height: 30px;
	top: 0px;
	right: 0px;
	position: absolute;
}
</style>
<script >
	function submitLogic(btnNo) {
		if (btnNo == 5) {
			document.mainForm.EBTN.value = "5";
		} else if (btnNo == 6) {
			document.mainForm.EBTN.value = "6";
		} else if (btnNo == 7) {
			document.mainForm.EBTN.value = "7";
		}
		// 遷移ロジック
		document.mainForm.submit();
	}
</script>
</head>
<body>
	<%
		if (request.getAttribute("msg") == null) {
		request.setAttribute("msg", "");
	}
	%>
	<form action="Find" method="post">
		<a href="register.jsp">
			<button type='button' onclick="submitLogic(5)"
				style='background-color: green; position: absolute; top: 0px; right: 0px;font size="12px"'>
				<font size="12px">基本情報修正</font>
			</button>
		</a>
		<div class="center">
			<br> <span><%=request.getAttribute("msg")%></span><br> <input
				type="submit" onclick="submitLogic(6)"
				style="height: 50px; width: 120px; background-color: green; font-size: 30px"
				value="SOUL" id='soulbtn' onclick="find()" />
		</div>
		<button type='button' onclick="submitLogic(7)"
			style="background-color: green; width: 66px; position: fixed; bottom: 20px; right: 25px; font-size: 0; line-height: 0; z-index: 100;">
			<font size="12px">ログオフ</font>
		</button>


	</form>
</body>
</html>