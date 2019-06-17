<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
</head>
<body class="text-center">
<form class="justify-content-center" method="post" action="addNewBook">
    <div class="text-center">
        <h1>Add new book</h1>
    </div>
    <div class="container col-md-5">
        <div class="form-group text-center">
            <label for="bookName">Book name</label>
            <input type="text" id="bookName" name="bookName" class="form-control" placeholder="Enter book name"
                   required=""
                   autofocus="">
            <label for="bookYear">Book year</label>
            <input type="text" id="bookYear" name="bookYear" class="form-control" placeholder="Enter book year"
                   required=""
                   autofocus="">
            <label for="bookAuthor">Book author</label>
            <input type="text" id="bookAuthor" name="bookAuthor" class="form-control" placeholder="Enter book author"
                   required="" autofocus="">
            <label for="bookInfo">Book info</label>
            <input type="text" id="bookInfo" name="bookInfo" class="form-control" placeholder="Enter book info"
                   required=""
                   autofocus="">
            <label for="language">Book language</label>
            <select class="form-select-button form-control" id="language" name="language">
<%--                custom-select form-control--%>
                <option value="">...</option>
                <c:forEach var="book" items="${languages}">
                    <option value="book">${book}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="text-center">
        <button class="btn btn-lg btn-primary" type="submit">Add book</button>
    </div>
</form>
</body>
</html>