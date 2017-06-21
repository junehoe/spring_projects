<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Song Details</title>
  </head>
  <body>
    <a href="/dashboard">Dashboard</a>
    <p>Name: <c:out value="${song.name}"/></p>
    <p>Artist: <c:out value="${song.artist}"/></p>
    <p>Rating (1-10): <c:out value="${song.rating}"/></p>
    <a href="/songs/delete/${song.id}">Delete</a>
  </body>
</html>
