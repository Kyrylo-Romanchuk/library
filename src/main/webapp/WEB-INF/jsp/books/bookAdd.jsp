<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel title="New book" errorMessage="${error}">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${base}/books/add">
            <input type="hidden" name="id" value="${book.getId()}">
            <div class="container col-md-5">
                <div class="form-group text-center">

                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#mainInfoTab">Main</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#genresTab">Genres</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#descriptionTab">Description</a>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <div class="tab-pane fade in active show" id="mainInfoTab">
                            <label for="bookName">Book name</label>
                            <input type="text" id="bookName" name="bookName" class="form-control"
                                   placeholder="Enter book name"
                                   value="${book.getName()}">
                            <tag:errorOnPage errorName="name"/>

                            <label for="bookYear">Book year</label>
                            <input type="text" id="bookYear" name="bookYear" class="form-control"
                                   placeholder="Enter book year"
                                   value="${book.getYear()}">
                            <tag:errorOnPage errorName="year"/>

                            <label for="bookAuthor">Book author</label>
                            <select class="form-select-button form-control" id="bookAuthor" name="bookAuthor">
                                <c:forEach var="author" items="${authors}">
                                    <c:if test="${book.getAuthor().getId() == author.getId()}">
                                        <option selected value=${author.getId()}>${author.getFullName()}</option>
                                    </c:if>
                                    <c:if test="${book.getAuthor().getId() != author.getId()}">
                                        <option value=${author.getId()}>${author.getFullName()}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                            <tag:errorOnPage errorName="author"/>

                            <label for="bookLanguage">Book language</label>
                            <select class="form-select-button form-control" id="bookLanguage" name="bookLanguage">
                                <c:forEach var="language" items="${languages}">
                                    <c:if test="${book.getLanguage().getId() == language.getId()}">
                                        <option selected value=${language.getId()}>${language.getName()}</option>
                                    </c:if>
                                    <c:if test="${book.getLanguage().getId() != language.getId()}">
                                        <option value=${language.getId()}>${language.getName()}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                            <tag:errorOnPage errorName="language"/>

                        </div>

                        <div class="tab-pane fade" id="genresTab">
                            <label for="genres">Genres</label>
                            <div class="form-check text-left">
                                <c:forEach var="genre" items="${genres}">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <c:if test="${book.getGenreById(genre.getId()).getId() == genre.getId()}">
                                                <input id="genres" name="genres"
                                                       type="checkbox" class="form-check-input"
                                                       value="${genre.getId()}" checked>${genre.getName()}
                                            </c:if>

                                            <c:if test="${book.getGenreById(genre.getId()).getId() != genre.getId()}">
                                                <input id="genres" name="genres"
                                                       type="checkbox" class="form-check-input"
                                                       value="${genre.getId()}">${genre.getName()}
                                            </c:if>
                                        </label>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <div class="tab-pane fade" id="descriptionTab">
                            <label for="bookInfo">Book info</label>
                            <textarea id="bookInfo" name="bookInfo" class="form-control"
                                      placeholder="Enter book info"
                                      rows="8"
                                      value="${book.getInfo()}"></textarea>
                            <tag:errorOnPage errorName="info"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="text-center">
                <button class="btn btn-lg btn-primary" type="submit">Save</button>
            </div>
        </form>
    </div>
</tag:pageModel>
