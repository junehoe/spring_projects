<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Dashboard</title>
  </head>
  <body>
    <a href="/songs/new">Add New</a> | <a href="/songs/top">Top Songs</a>
    <form method="POST" action="/search">
      <input type="text" name="artist">
      <input type="submit" value="Search Artist">
    </form>
    <table>
      <thead>
        <td>Name</td>
        <td>Artist</td>
        <td>Rating</td>
        <td>Actions</td>
      </thead>
      <c:forEach items="${songs}" var="song">
      <tbody>
        <td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
        <td><c:out value="${song.artist}"/></td>
        <td><c:out value="${song.rating}"/></td>
        <td><a href="/songs/delete/${song.id}">Delete</a></td>
      </tbody>
      </c:forEach>
    </table>
  </body>
</html>
