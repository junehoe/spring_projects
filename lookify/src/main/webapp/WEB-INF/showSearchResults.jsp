<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Search Results</title>
  </head>
  <body>
    <a href="/dashboard">Dashboard</a>
    <form method="POST" action="/search">
      <input type="text" name="artist">
      <input type="submit" value="Search Artist">
    </form>
    <h4>Songs by artist: <c:out value="${artist}"/></h4>
    <table>
      <thead>
        <td>Name</td>
        <td>Rating</td>
        <td>Actions</td>
      </thead>
      <c:forEach items="${searchResults}" var="song">
      <tbody>
        <td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
        <td><c:out value="${song.rating}"/></td>
        <td><a href="/songs/delete/${song.id}">Delete</a></td>
      </tbody>
      </c:forEach>
    </table>
  </body>
</html>
