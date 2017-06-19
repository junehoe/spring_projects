<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Secret Code</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
    <div id="wrapper">
      <p class="red"><c:out value="${error}"/></p>
      <h3>What is the code?</h3>
      <form method="POST" action="/check">
        <input type="text" name="code"><br>
        <input type="submit" value="Try Code">
      </form>
    </div>
  </body>
</html>
