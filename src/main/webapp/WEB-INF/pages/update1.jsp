<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
welcome to Register page
<div>
<form method="post">
Room NO:<input type="text" name="roomno" value=${roomno} />
<br/>
Floor NO: <input type="text" name="floor" value=${floor}  />
<br/>
Room Type:<input type="text" name="rtype" value=${rtype} />
<br/>
Category: <input type="text" name="category" value=${category} />
<br/>
<button>Submit</button>
</form>

</div>
</body>
</html>