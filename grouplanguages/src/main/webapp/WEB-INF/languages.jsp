<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Group Languages</title>
  </head>
  <body>
    <table>
      <c:forEach items="${languages}" var="language" varStatus="loop">
      <tr>
        <td><a href="/languages/${loop.index}"><c:out value="${language.name}"/></a></td>
        <td><c:out value="${language.creator}"/></td>
        <td><c:out value="${language.currentVersion}"/></td>
        <td><a href="/languages/update/${loop.index}">Edit</a> | <a href="/languages/delete/${loop.index}">Delete</a></td>
      </tr>
      </c:forEach>
    </table>
    <br>
		<form:form method="POST" action="/languages/new" modelAttribute="language">
      <form:label path="name">Name
      <form:errors path="name"/>
      <form:input path="name"/></form:label>
      <form:label path="creator">Creator
      <form:errors path="creator"/>
      <form:input path="creator"/></form:label>
      <form:label path="currentVersion">Current Version
      <form:errors path="currentVersion"/>
      <form:input path="currentVersion"/></form:label>
      <input type="submit" value="Submit"/>
    </form:form>
  </body>
</html>
