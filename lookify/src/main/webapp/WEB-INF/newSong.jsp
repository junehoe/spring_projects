<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>New Song</title>
  </head>
  <body>
    <form:form method="POST" action="/songs/new" modelAttribute="song">
      <form:label path="name">Name
      <form:errors path="name"/>
      <form:input path="name"/></form:label>
      <form:label path="artist">Artist
      <form:errors path="artist"/>
      <form:input path="artist"/></form:label>
      <form:label path="rating">Rating
      <form:select path="rating">
        <form:options items="${ratings}"></form:options>
      </form:select></form:label>
      <input type="submit" value="Add Song"/>
    </form:form>
  </body>
</html>
