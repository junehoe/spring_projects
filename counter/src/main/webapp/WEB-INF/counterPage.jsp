<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>You have visited localhost:8080 <c:out value="${sessionCounter}"/> times!</h1><br>
<a href="/">Test another visit?</a><br>
<a href="/reset">Reset counter</a>
