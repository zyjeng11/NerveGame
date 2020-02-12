
<%@page contentType="text/html" pageEncoding="UTF-8"
	import="java.util.*,bean.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question editer</title>
	<style>
	table {
		margin: 20px;
	}
	</style>
</head>

<body>

	<table align='center' border='1' cellspacing='0'>
		<tr>
			<td>id</td>
			<td>question</td>
			<td>answer1</td>
			<td>answer2</td>
			<td>answer3</td>
			<td>answer4</td>
			<td>answer5</td>
			<td>answer6</td>
			<td>answer7</td>
			<td>delete</td>
			<td>edit</td>

		</tr>
		<c:forEach items="${questions}" var="q" varStatus="st">
			<tr>
				<td>${q.id}</td>
				<td>${q.question}</td>
				<td>${q.answer1}</td>
				<td>${q.answer2}</td>
				<td>${q.answer3}</td>
				<td>${q.answer4}</td>
				<td>${q.answer5}</td>
				<td>${q.answer6}</td>
				<td>${q.answer7}</td>
				<td><a href="delete?id=${q.id}">delete</a></td>
				<td><a href="updateQuestion.jsp?id=${q.id}">edit</a></td>
				<td><a href="up?id=${q.id}">up</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="11" align="center"><a href="addQuestion.html">add</a>
			</td>
		</tr>
	</table>


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
