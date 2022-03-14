<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>webarticles</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped table-dark table-responsive-lg">
    <tr>
        <td><h2 class="h2">Magasin virtuel</h2></td>
        <c:forEach items="${actions}" var="action">
            <td>|</td>
            <td><a class="btn btn btn-primary btn-sm mb-3" href="<c:out value="${action.href}" />"><c:out value="${action.lien}"/></a></td>
        </c:forEach>
    </tr>
</table>
</body>
</html>