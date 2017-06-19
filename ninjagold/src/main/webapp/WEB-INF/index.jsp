<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ninja Gold</title>
  </head>
  <body>
    <div id="wrapper">
      <h4>Your Gold: <textarea placeholder=<%= session.getAttribute("gold") %> disabled></textarea></h4>
      <div class="location">
        <h1>Farm</h1>
        <h3>(earns 10-20 gold)</h3>
        <form method="POST" action="/process">
          <input type="hidden" name="location" value="farm">
          <input type="submit" value="Find Gold!">
        </form>
      </div>
      <div class="location">
        <h1>Cave</h1>
        <h3>(earns 5-10 gold)</h3>
        <form method="POST" action="/process">
          <input type="hidden" name="location" value="cave">
          <input type="submit" value="Find Gold!">
        </form>
      </div>
      <div class="location">
        <h1>House</h1>
        <h3>(earns 2-5 gold)</h3>
        <form method="POST" action="/process">
          <input type="hidden" name="location" value="house">
          <input type="submit" value="Find Gold!">
        </form>
      </div>
      <div class="location">
        <h1>Casino</h1>
        <h3>(earns/takes 0-50 gold)</h3>
        <form method="POST" action="/process">
          <input type="hidden" name="location" value="casino">
          <input type="submit" value="Find Gold!">
        </form>
      </div>
      <div class="activities">
        <h4>Activities:</h4>
        <c:forEach items="${results}" var="t">
          <textfield>
            <p><c:out value="${t}"/></p>
          </textfield>
        </c:forEach>
      </div>
    </div>
  </body>
</html>
