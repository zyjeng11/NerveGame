
<%@page contentType="text/html" pageEncoding="UTF-8"
	import="java.util.*,bean.*,java.sql.*,dao.QuestionDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update question</title>
<style>
	table {
		margin: 20px;
	}
</style>
</head>

<body>
	<form action="edit" method="post">
		<%
			int id = Integer.parseInt(request.getParameter("id"));
			Question q = new QuestionDAO().getQuestionById(id);
		%>
		<span>題目:</span>
		<textarea name="question" cols="40" rows="3"><%=q.question%></textarea>
		<br> <span>答案:</span><input type="text" name="answer1"
			value="<%=q.answer1%>"><br> <span>答案:</span><input
			type="text" name="answer2" value="<%=q.answer2%>"><br> <span>答案:</span><input
			type="text" name="answer3" value="<%=q.answer3%>"><br> <span>答案:</span><input
			type="text" name="answer4" value="<%=q.answer4%>"><br> <span>答案:</span><input
			type="text" name="answer5" value="<%=q.answer5%>"><br> <span>答案:</span><input
			type="text" name="answer6" value="<%=q.answer6%>"><br> <span>答案:</span><input
			type="text" name="answer7" value="<%=q.answer7%>"> <input
			type="hidden" name="id" value="<%=id%>"> <input type="submit"
			value="submit" name="submit">
	</form>
	<table border="1">
		<tr>
			<td>A</td>
			<td>B</td>
			<td>C</td>
			<td>D</td>
			<td>E</td>
			<td>F</td>
			<td>G</td>
			<td>H</td>
			<td>I</td>
			<td>J</td>
			<td>K</td>
		</tr>
		<tr>
			<td>皮膚</td>
			<td>鼻子</td>
			<td>眼睛</td>
			<td>耳朵</td>
			<td>感覺神經元</td>
			<td>脊髓</td>
			<td>大腦</td>
			<td>運動神經元</td>
			<td>肌肉</td>
			<td>唾腺</td>
			<td>腦幹</td>
		</tr>
	</table>
</body>
</html>
