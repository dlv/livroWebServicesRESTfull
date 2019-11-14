<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/rest/carros" method="POST"
		enctype="multipart/form-data">
		<input type="file" name="file" id="file" /><br /><br />
		<input type="submit" name="submit" value="Enviar arquivo" />
	</form>
</body>
</html>