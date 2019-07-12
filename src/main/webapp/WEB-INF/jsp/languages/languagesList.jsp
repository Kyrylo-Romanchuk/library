<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel title="Languages" dataTable="languages">
    <table id="languages" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Short name</th>
            <th class="text-right w-25">Actions</th>
        </tr>
        </thead>

        <c:forEach var="genre" items="${languages}">
            <tr>
                <td>${genre.getName()}</td>
                <td>${genre.getShortName()}</td>
                <td class="text-right">
                    <div class="btn-group">
                        <tag:actionButton method="post" url="${base}/languages/delete"
                                          id="${genre.getId()}">delete</tag:actionButton>
                        <tag:actionButton method="get" url="${base}/languages/edit"
                                          id="${genre.getId()}">edit</tag:actionButton>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div id="languages-menu">
        <button class="btn navbar-light" data-toggle="dropdown" style="padding: .2rem;">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="dropdown-menu dropdown-menu-right">
            <a class="dropdown-item" href="${base}/languages/add">Add</a>
        </div>
    </div>
</tag:pageModel>
