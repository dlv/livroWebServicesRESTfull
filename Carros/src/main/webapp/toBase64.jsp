<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File to base64</title>
</head>
<body>
	<pre>
Converter uma arquivo em Base64
<form enctype="multipart/form-data"
			action="<%=request.getContextPath()%>/rest/carros/toBase64"
			method="POST">
	<!-- O tipo "file" cria o botão Browse para escolher o arquivo -->
	<input name="file" type="file" />
	<!-- Botão de submit -->
	<input type="submit" value="Enviar arquivo" />
</form>
</pre>
</body>
</html>