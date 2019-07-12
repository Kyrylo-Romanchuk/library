<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tag:pageModel title="Authors list" dataTable="authors">
    <table id="authors" class="table table-striped">
        <thead>
        <tr>
            <th>Full name</th>
            <th>Biography</th>
            <th>Birthday</th>
            <th>Die day</th>
            <th class="text-right">Actions</th>
        </tr>
        </thead>

        <c:forEach var="author" items="${authors}">
            <tr>
                <td>${author.getFullName()}</td>
                <td>${author.getBiography()}</td>
                <td><fmt:formatDate value="${author.getBirthDay()}" pattern="MM/dd/yyyy"/></td>
                <td><fmt:formatDate value="${author.getDieDay()}" pattern="MM/dd/yyyy"/></td>
                <td class="text-right">
                    <div class="btn-group">
                        <tag:actionButton method="post" url="${base}/authors/delete"
                                          id="${author.getId()}">delete</tag:actionButton>
                        <tag:actionButton method="get" url="${base}/authors/edit"
                                          id="${author.getId()}">edit</tag:actionButton>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div id="authors-menu">
        <button class="btn navbar-light" data-toggle="dropdown" style="padding: .2rem;">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="dropdown-menu dropdown-menu-right">
            <a class="dropdown-item" href="${base}/authors/add">Add</a>
        </div>
    </div>
</tag:pageModel>
