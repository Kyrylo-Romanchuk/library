<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel title="New book" errorMessage="${error}">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${pageContext.request.contextPath}/books/add">
            <div class="container col-md-5">
                <div class="form-group text-center">
                    <label for="bookName">Book name</label>
                    <input type="text" id="bookName" name="bookName" class="form-control"
                           placeholder="Enter book name"
                           autofocus=""
                           value="${book.getName()}">
                    <c:if test="${validationResult.hasError('name')}">
                        <div class="alert alert-danger" role="alert">
                                ${validationResult.getError('name')}
                        </div>
                    </c:if>
                    <label for="bookYear">Book year</label>
                    <input type="text" id="bookYear" name="bookYear" class="form-control" placeholder="Enter book year"
                           autofocus=""
                           value="${book.getYear()}">
                    <c:if test="${validationResult.hasError('year')}">
                        <div class="alert alert-danger" role="alert">
                                ${validationResult.getError('year')}
                        </div>
                    </c:if>
                    <label for="bookAuthor">Book author</label>
                    <select class="form-select-button form-control" id="bookAuthor" name="bookAuthor">
                        <c:if test="${book != null}">
                            <c:set var="bookAuthor" value="${book.getAuthor()}" scope="page"></c:set>
                            <option selected value=${bookAuthor.getId()}>${bookAuthor.getFullName()}</option>
                        </c:if>
                        <c:forEach var="author" items="${authors}">
                            <option value=${author.getId()}>${author.getFullName()}</option>
                        </c:forEach>
                    </select>
                    <c:if test="${validationResult.hasError('author')}">
                        <div class="alert alert-danger" role="alert">
                                ${validationResult.getError('author')}
                        </div>
                    </c:if>
                    <label for="bookInfo">Book info</label>
                    <input type="text" id="bookInfo" name="bookInfo" class="form-control" placeholder="Enter book info"
                           autofocus=""
                           value="${book.getInfo()}">
                    <c:if test="${validationResult.hasError('info')}">
                        <div class="alert alert-danger" role="alert">
                                ${validationResult.getError('info')}
                        </div>
                    </c:if>
                    <label for="bookLanguage">Book language</label>
                    <select class="form-select-button form-control" id="bookLanguage" name="bookLanguage">
                        <c:if test="${book != null}">
                            <option selected value=${book.getLanguage()}>${book.getLanguage()}</option>
                        </c:if>
                        <c:forEach var="language" items="${languages}">
                            <option value=${language}>${language}</option>
                        </c:forEach>
                    </select>
                    <c:if test="${validationResult.hasError('language')}">
                        <div class="alert alert-danger" role="alert">
                                ${validationResult.getError('language')}
                        </div>
                    </c:if>
                </div>
            </div>

            <div class="text-center">
                <button class="btn btn-lg btn-primary" type="submit">Add book</button>
            </div>
        </form>
    </div>
</tag:pageModel>
