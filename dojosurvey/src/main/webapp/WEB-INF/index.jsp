<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dojo Survey</title>
  </head>
  <body>
    <div id="wrapper">
      <form method="POST" action="/result">
        <p>Your Name: <input type="text" name="name"></p>
        <p>
          Dojo Location: <select name="location">
            <option value="Burbank">Burbank</option>
            <option value="Seoul">Seoul</option>
            <option value="Fontana">Fontana</option>
            <option value="Chicago">Chicago</option>
          </select>
        </p>
        <p>
          Favorite Language: <select name="language">
            <option value="JavaScript">JavaScript</option>
            <option value="Java">Java</option>
            <option value="Ruby">Ruby</option>
            <option value="Python">Python</option>
          </select>
        </p>
        <p>Comment (optional): <textarea name="comment"></textarea></p>
        <input type="submit" value="Submit">
      </form>
    </div>
  </body>
</html>
