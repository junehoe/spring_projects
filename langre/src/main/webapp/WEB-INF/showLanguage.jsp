<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Show Language</title>
  </head>
  <body>
    <a href="/languages">Dashboard</a>
    <br>
    <p><c:out value="${language.name}"/></p>
    <p><c:out value="${language.creator}"/></p>
    <p><c:out value="${language.currentVersion}"/></p>
    <p><a href="/languages/update/${language.id}">Edit</a></p>
    <p><a href="/languages/delete/${language.id}">Delete</a></p>
  </body>
</html>
