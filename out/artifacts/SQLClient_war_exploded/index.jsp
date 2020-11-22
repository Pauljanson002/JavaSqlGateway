<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sqlStatement == null}">
  <c:set var="sqlStatement" value="select * from clients" />
</c:if>

<div class="container">
  <h1> The SQL Gateway</h1>
  <h6>Enter an SQL statement and click Execute button</h6>
  <form action="sqlGateway" method="POST">
    <p>
      SQL statement
    </p>
    <textarea name="sqlStatement" cols="60" rows="8">
      ${sqlStatement}
    </textarea>
    <input type="submit" value="Execute">
  </form>
  <p>
    <b>SQL result</b>
    ${sqlResult}
  </p>
</div>
</body>
</html>