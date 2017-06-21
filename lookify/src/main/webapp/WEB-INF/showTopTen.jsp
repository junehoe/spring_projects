<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Top 10 Songs</title>
  </head>
  <body>
    <a href="/dashboard">Dashboard</a>
    <h2>Top Ten Songs:</h2>
    <c:forEach items="${topTen}" var="song">
    <p><c:out value="${song.rating}"/> - <a href="/songs/${song.id}"><c:out value="${song.name}"/></a> - <c:out value="${song.artist}"/></p>
    </c:forEach>
  </body>
</html>
