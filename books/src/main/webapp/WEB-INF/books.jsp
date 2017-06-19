<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Books Practice</title>
  </head>
  <body>
    <table>
      <c:forEach items="${books}" var="book" varStatus="loop">
      <tr>
        <td><c:out value="${book.title}"/></td>
        <td><c:out value="${book.description}"/></td>
        <td><c:out value="${book.language}"/></td>
        <td><c:out value="${book.numberOfPages}"/></td>
        <td><a href="/books/delete/${loop.index}">Delete</a></td>
      </tr>
      </c:forEach>
    </table>
  </body>
</html>
