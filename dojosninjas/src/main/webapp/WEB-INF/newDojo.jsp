<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>New Dojo</title>
  </head>
  <body>
    <form:form method="POST" action="/dojos/new" modelAttribute="dojo">
      <form:label path="name">Name:
      <form:errors path="name"/>
      <form:input path="name"/></form:label>
      <input type="submit" value="Create"/>
    </form:form>
  </body>
</html>
