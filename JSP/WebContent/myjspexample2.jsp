<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB Programming Test</title>
<style>
input{
	width:50px;
	height:50px;
}
.output{
	height: 50px;
	background: #e9e9e9;
	font-size:24px;
	font-weight: bold;
	text-align: right;
	padding:0px 5px;
}
</style>
</head>
<body>

<%!
//url에 num1과 num2를 입력받아야 결과 출력가능 ex)http://localhost:8090/JSP/myjspexample1.jsp?num1=2&num2=3
	public int multiple(PageContext p){
	int a = Integer.valueOf(p.getRequest().getParameter("num1"));
	int b = Integer.valueOf(p.getRequest().getParameter("num2"));
	return a*b;
	}
	%>
	<div>
		<form action = "" method="get">
			<table>
			  <tr>
			  	<td class="output" colspan="4"><%=multiple(pageContext) %></td>
			  </tr>
			  <tr>
			  	<td><input type="submit" name="operator" value="CE"/></td>
			  	<td><input type="submit" name="operator" value="C"/></td>
			  	<td><input type="submit" name="operator" value="BS"/></td>
			  	<td><input type="submit" name="operator" value="/"/></td>
			  </tr>
			  <tr>
			  	<td><input type="submit" name="value" value="7"/></td>
			  	<td><input type="submit" name="value" value="8"/></td>
			  	<td><input type="submit" name="value" value="9"/></td>
			  	<td><input type="submit" name="operator" value="*"/></td>
			  </tr>
			  <tr>
			  	<td><input type="submit" name="value" value="4"/></td>
			  	<td><input type="submit" name="value" value="5"/></td>
			  	<td><input type="submit" name="value" value="6"/></td>
			  	<td><input type="submit" name="operator" value="-"/></td>
			  </tr>
			  <tr>
			  	<td><input type="submit" name="value" value="1"/></td>
			  	<td><input type="submit" name="value" value="2"/></td>
			  	<td><input type="submit" name="value" value="3"/></td>
			  	<td><input type="submit" name="operator" value="+"/></td>
			  </tr>
			  <tr>
			  	<td></td>
			  	<td><input type="submit" name="value" value="0"/></td>
			  	<td><input type="submit" name="dot" value="."/></td>
			  	<td><input type="submit" name="operator" value="="/></td>
			  </tr>
			</table>		
			
		</form>
	</div>
</body>
</html>