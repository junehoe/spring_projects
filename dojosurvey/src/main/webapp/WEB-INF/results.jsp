<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dojo Survey</title>
  </head>
  <body>
    <div id="wrapper">
      <h1>Submitted Info:</h1>
      <h4>Name: <c:out value="${name}"/></h4>
      <h4>Location: <c:out value="${location}"/></h4>
      <h4>Language: <c:out value="${language}"/></h4>
      <h4>Comment: <c:out value="${comment}"/></h4>
      <a href="/">Go Back</a>
    </div>
  </body>
</html>
