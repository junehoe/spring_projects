<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>New Ninja</title>
  </head>
  <body>
    <form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
      <form:label path="dojo">Dojo:
      <form:select path="dojo">
        <form:options items="${dojos}" itemValue="id" itemLabel="name"></form:options>
      </form:select></form:label>
      <form:label path="firstName">First Name:
      <form:errors path="firstName"/>
      <form:input path="firstName"/></form:label>
      <form:label path="lastName">Last Name:
      <form:errors path="lastName"/>
      <form:input path="lastName"/></form:label>
      <form:label path="age">Age:
      <form:errors path="age"/>
      <form:input type="number" path="age"/></form:label>
      <input type="submit" value="Create"/>
    </form:form>
  </body>
</html>
