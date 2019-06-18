<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:pageModel>
    <div class="text-center">
    <form class="justify-content-center" method="post" action="${pageContext.request.contextPath}/books/add">
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
                <input type="text" id="bookAuthor" name="bookAuthor" class="form-control"
                       placeholder="Enter book author"
                       required="" autofocus="">
                <label for="bookInfo">Book info</label>
                <input type="text" id="bookInfo" name="bookInfo" class="form-control" placeholder="Enter book info"
                       required=""
                       autofocus="">
                <label for="bookLanguage">Book language</label>
                <select class="form-select-button form-control" id="bookLanguage" name="bookLanguage">
                    <c:forEach var="book" items="${languages}">
                        <option value=${book}>${book}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="text-center">
            <button class="btn btn-lg btn-primary" type="submit">Add book</button>
        </div>
    </form>
    </div>
</tag:pageModel>
