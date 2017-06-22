<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Dojo Page</title>
  </head>
  <body>
    <h1><c:out value="${dojo.name}"/></h1>
    <table>
      <thead>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Age</td>
      </thead>
      <c:forEach items="${dojo.ninjas}" var="ninja">
      <tbody>
        <td><c:out value="${ninja.firstName}"/></td>
        <td><c:out value="${ninja.lastName}"/></td>
        <td><c:out value="${ninja.age}"/></td>
      </tbody>
      </c:forEach>
    </table>
  </body>
</html>
