<%@page import="dto.ShowDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
    .center{
                position:absolute;
                top:20%;
                left:30%;
                width:500px;
                height:300px;
            }
</style>
<script>
function submitLogic(btnNo) {
	if (btnNo == 8) {
		document.mainForm.EBTN.value = "8";// pay
	}
	// 遷移ロジック
	document.mainForm.submit();
}
</script>
</head>
<body>
   <div class="center">

    <table  cellpadding="5px" cellspacing="0">
    <%
        List<ShowDto> showList = (List<ShowDto>)session.getAttribute("showList");
    	for(ShowDto dto : showList) {
    %>

        <tr>
            <td></td>
            <td>
             <input class="text" type="text" name="name" value="<%=request.getParameter("soul_name")%>"/>
            </td>

             <% if (ShowDto.getPayFlg()!= "1") {%>
             <td>
             <input id ="newText" style="display:none;" class="text" type="text" id="text1" value="<%=ShowDto.getPayBeforeText()%>"/>
            </td>

            <td><input type="button" onclick="submitLogic(8)" value="$"/></td>

            <%  }else {%>
            <td>
             <input style="display:none;" class="text" type="text" id="text1" value="<%=ShowDto.getPayAfterText()%>"/>
            </td>

            <td></td>
            <%} %>
        </tr>
        <%} %>

    </table>
</div>
<form action="show" method="post">
    <input type="submit" value="show" />


</form>

</body>
</html>