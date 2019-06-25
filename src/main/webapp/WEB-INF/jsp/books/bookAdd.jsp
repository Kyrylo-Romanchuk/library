<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageValidationResult" value="${validationResult}" scope="page"></c:set>

<tag:pageModel title="New book" errorMessage="${error}">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${pageContext.request.contextPath}/books/add">
            <div class="container col-md-5">
                <div class="form-group text-center">
                    <label for="bookName">Book name</label>
                    <input type="text" id="bookName" name="bookName" class="form-control"
                           placeholder="Enter book name"
                           autofocus="">
                    <c:if test="${pageValidationResult != null && pageValidationResult.getResultByKey('name') != null}">
                        <div class="alert alert-danger" role="alert">
                                ${pageValidationResult.getResultByKey('name')}
                        </div>
                    </c:if>
                    <label for="bookYear">Book year</label>
                    <input type="text" id="bookYear" name="bookYear" class="form-control" placeholder="Enter book year"
                           autofocus="">
                    <c:if test="${pageValidationResult != null && pageValidationResult.getResultByKey('year') != null}">
                        <div class="alert alert-danger" role="alert">
                                ${pageValidationResult.getResultByKey('year')}
                        </div>
                    </c:if>
                    <label for="bookAuthor">Book author</label>
                    <select class="form-select-button form-control" id="bookAuthor" name="bookAuthor">
                        <c:forEach var="author" items="${authors}">
                            <option value=${author.getId()}>${author.getFullName()}</option>
                        </c:forEach>
                    </select>
                    <c:if test="${pageValidationResult != null && pageValidationResult.getResultByKey('author') != null}">
                        <div class="alert alert-danger" role="alert">
                                ${pageValidationResult.getResultByKey('author')}
                        </div>
                    </c:if>
                    <label for="bookInfo">Book info</label>
                    <input type="text" id="bookInfo" name="bookInfo" class="form-control" placeholder="Enter book info"
                           autofocus="">
                    <c:if test="${pageValidationResult != null && pageValidationResult.getResultByKey('info') != null}">
                        <div class="alert alert-danger" role="alert">
                                ${pageValidationResult.getResultByKey('info')}
                        </div>
                    </c:if>
                    <label for="bookLanguage">Book language</label>
                    <select class="form-select-button form-control" id="bookLanguage" name="bookLanguage">
                        <c:forEach var="book" items="${languages}">
                            <option value=${book}>${book}</option>
                        </c:forEach>
                    </select>
                    <c:if test="${pageValidationResult != null && pageValidationResult.getResultByKey('language') != null}">
                        <div class="alert alert-danger" role="alert">
                                ${pageValidationResult.getResultByKey('language')}
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
