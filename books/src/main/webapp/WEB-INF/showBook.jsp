<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Show Book</title>
  </head>
  <body>
    <p><c:out value="${book.title}"/></p>
    <p><c:out value="${book.description}"/></p>
    <p><c:out value="${book.language}"/></p>
    <p><c:out value="${book.numberOfPages}"/></p>
  </body>
</html>
