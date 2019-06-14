<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<table id="books" class="table table-sm table-striped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Year</th>
        <th>Author</th>
        <th>Info</th>
        <th>Language</th>
    </thead>

    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.getName()}</td>
            <td>${book.getYear()}</td>
            <td>${book.getAuthor()}</td>
            <td>${book.getInfo()}</td>
            <td>${book.getLanguage()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
