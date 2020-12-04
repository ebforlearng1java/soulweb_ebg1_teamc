<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function submitLogic(btnNo) {
	if (btnNo == 3) {
		document.mainForm.EBTN.value = "3";// 重置
	}else if (btnNo == 4) {
		document.mainForm.EBTN.value = "4";// 登録/修正
	}
	// 遷移ロジック
	document.mainForm.submit();
}
</script>
<style type="text/css">
    .center{
                position:absolute;
                top:20%;
                left:40%;
                width:500px;
                height:300px;
            }
</style>
</head>
<body>
<%
if (request.getAttribute("msg") == null) {
	request.setAttribute("msg", "");
}
%>



	<form name="mainForm" action="Register" method="post">


		<h1>

			<span>Register</span>
		</h1>


		<div class="center">

		<br> <span><%=request.getAttribute("msg")%></span> <br>


        <table border="2" bordercolor="#0099ff" cellpadding="10px" cellspacing="0">
        <tr>
            <th colspan="3">&#60SOUL&#62</th>
        </tr>
        <tr>
            <td><font color="#FF0000">*</font>Soul名：</td>
            <td>
                <input  type="text" name="NAME" placeholder="--名前入力してください--"/>
            </td>
        </tr>
         <tr>
            <td><font color="#FF0000">*</font>性別：</td>
            <td>
                <input type="radio" name="SEX" value="nan" checked="checked"/>男
                <input type="radio" name="SEX" value="nv" />女
            </td>
        </tr>
<tr>
            <td><font color="#FF0000">*</font>年齢：</td>
            <td>
                <select name="YEAR">
                    <option value="">-</option>
                    <option value="1960">1960</option>
                    <option value="1961">1961</option>
                    <option value="1962">1962</option>
                    <option value="1963">1963</option>
                    <option value="1964">1964</option>
                    <option value="1965">1965</option>
                    <option value="1966">1966</option>
                    <option value="1967">1967</option>
                    <option value="1968">1968</option>
                    <option value="1969">1969</option>
                    <option value="1970">1970</option>
                    <option value="1971">1971</option>
                    <option value="1972">1972</option>
                    <option value="1973">1973</option>
                    <option value="1974">1974</option>
                    <option value="1975">1975</option>
                    <option value="1976">1976</option>
                    <option value="1977">1977</option>
                    <option value="1978">1978</option>
                    <option value="1979">1979</option>
                    <option value="1980">1980</option>
                    <option value="1981">1981</option>
                    <option value="1982">1982</option>
                    <option value="1983">1983</option>
                    <option value="1984">1984</option>
                    <option value="1985">1985</option>
                    <option value="1986">1986</option>
                    <option value="1987">1987</option>
                    <option value="1988">1988</option>
                    <option value="1989">1989</option>
                    <option value="1990">1990</option>
                    <option value="1991">1991</option>
                    <option value="1992">1992</option>
                    <option value="1993">1993</option>
                    <option value="1994">1994</option>
                    <option value="1995">1995</option>
                    <option value="1996">1996</option>
                    <option value="1997">1997</option>
                    <option value="1998">1998</option>
                    <option value="1999">1999</option>
                    <option value="2000">2000</option>
                    <option value="2001">2001</option>
                    <option value="2002">2002</option>
                    <option value="2003">2003</option>
                    <option value="2004">2004</option>
                    <option value="2005">2005</option>
                    <option value="2006">2006</option>
                    <option value="2007">2007</option>
                    <option value="2008">2008</option>
                    <option value="2009">2009</option>
                    <option value="2010">2010</option>
                    <option value="2011">2011</option>
                    <option value="2012">2012</option>
                    <option value="2013">2013</option>
                    <option value="2014">2014</option>
                    <option value="2015">2015</option>
                    <option value="2016">2016</option>
                    <option value="2017">2017</option>
                    <option value="2018">2018</option>
                    <option value="2019">2019</option>
                    <option value="2020">2020</option>
                </select> 年
                <select name="MONTH">
                    <option value="">-</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
            </select> 月
            <select name="DAY">
                    <option value="">-</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>
              </select>　日
            </td>
        </tr>
        <tr>
            <td>星座：</td>
            <td>
               <select name="STAR">
                     <option value="">-</option>
                    <option value="牡羊座">牡羊座</option>
                    <option value="牡牛座">牡牛座</option>
                    <option value="双子座">双子座</option>
                    <option value="蟹座">蟹座</option>
                    <option value="獅子座">獅子座</option>
                    <option value="乙女座">乙女座</option>
                    <option value="天秤座">天秤座</option>
                    <option value="蠍座">蠍座</option>
                    <option value="射手座">射手座</option>
                    <option value="山羊座">山羊座</option>
                    <option value="水瓶座">水瓶座</option>
                    <option value="魚座">魚座</option>
                      </select>
            </td>
        </tr>
        <tr>
            <td>都市</td>
            <td>
                <select name="CITY">
                        <option value="">選択してください</option>
                        <option value="Tokyo">Tokyo</option>
                        <option value="New York">New York</option>
                        <option value="Beijing">Beijing</option>
                        <option value="Hawii">Hawii</option>
                        <option value="Okinawa">Okinawa</option>
                        <option value="Hibarigaoka">Hibarigaoka</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>趣味：</td>
            <td>
                <input type="checkbox" name="HOBBY1" value="音楽"/>音楽
                <input type="checkbox" name="HOBBY2" value="絵画"/>絵画
                <input type="checkbox" name="HOBBY3" value="読書"/>読書
               <br>
                <input type="checkbox" name="HOBBY4" value="ジョギング">ジョギング
                <input type="checkbox" name="HOBBY5" value="ゲーム">ゲーム
                <input type="checkbox" name="HOBBY6" value="映画">映画
            </td>
        </tr>
        <tr>
            <td><font color="#FF0000">*</font>Soul Mail：</td>
            <td>
                <input type="text" name="MAIL">
            </td>
        </tr>
         <tr>
            <td><font color="#FF0000">*</font>Soul PW：</td>
            <td>
                <input type="password" name="PW">
            </td>
        </tr>
        <tr>
            <th colspan="3">
           <!--     <a href="http://localhost:63342/python%20文件/注册结果.html" > <input type="button" name="submit" value="提交" /></a>
                <input type="reset" name="reset" value="重置" />
                <input type="button" value="登録/修正"style="border:#008000">
             <a href="login.jsp">   <button type='button' style='background-color:green'>登録/修正</button></a>-->
             <input id="eBtn" name="EBTN" type="hidden" value="<%=request.getAttribute("EBTN")%>" />
             <button type="button" onclick="submitLogic(3)" style='background-color:green'>重置</button>
   			 <button type="button" onclick="submitLogic(4)" style='background-color:green'>登録/修正</button>

            </th>
        </tr>
    </table>
    </div>
	</form>
</body>
</html>