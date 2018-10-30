<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html">
<title>Forum - dodaj nowy temat</title>
</head>
<body>
	<form method="post">
		<p>Wprowadź tytuł tematu:</p>
		<input type="text" name="tytul" maxlength="255">
		<p>Wprowadź treść tematu:</p>
		<textarea name="tresc" rows="9" cols="40"></textarea>
		<br /> <input type="submit" value="Dodaj" />
	</form>

</body>
</html>