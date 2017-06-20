<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Edit Language</title>
  </head>
  <body>
    <a href="/languages/delete/${id}">Delete</a> | <a href="/languages">Dashboard</a>
    <br>
    <form:form method="POST" action="/languages/update/${id}" modelAttribute="language">
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
