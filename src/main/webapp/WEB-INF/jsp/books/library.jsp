<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel dataTable="books" title="Library">
    <table id="books" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Year</th>
            <th>Author</th>
            <th>Info</th>
            <th>Language</th>
            <th>Genres</th>
        </tr>
        </thead>

        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.getName()}</td>
                <td>${book.getYear()}</td>
<%--                to do change when will be add bookDto (getFullName())--%>
                <td>${book.getAuthor().getFirstName()}</td>
                <td>${book.getInfo()}</td>
                <td>${book.getLanguage().getName()}</td>
                <td>${book.getGenresString()}</td>
            </tr>
        </c:forEach>
    </table>
    <div id="books-menu">
        <button class="btn navbar-light" data-toggle="dropdown" style="padding: .2rem;">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="dropdown-menu dropdown-menu-right" >
            <a class="dropdown-item" href="${base}/books/add">Add</a>
        </div>
    </div>
</tag:pageModel>

