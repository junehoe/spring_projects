<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>New Book</title>
  </head>
  <body>
    <form:form method="POST" action="/books/new" modelAttribute="book">
      <form:label path="title">Title
      <form:errors path="title"/>
      <form:input path="title"/></form:label>
      <form:label path="description">Description
      <form:errors path="description"/>
      <form:input path="description"/></form:label>
      <form:label path="language">Language
      <form:errors path="language"/>
      <form:input path="language"/></form:label>
      <form:label path="numberOfPages">Pages
      <form:errors path="numberOfPages"/>
      <form:input path="numberOfPages"/></form:label>
      <input type="submit" value="Submit"/>
    </form:form>
  </body>
</html>
