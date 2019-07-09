<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tag:pageModel title="Languages" dataTable="languages">
    <table id="languages" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Short name</th>
        </tr>
        </thead>

        <c:forEach var="language" items="${languages}">
            <tr>
                <td>${language.getName()}</td>
                <td>${language.getShortName()}</td>
            </tr>
        </c:forEach>
    </table>
    <div id="languages-menu">
        <button class="btn navbar-light" data-toggle="dropdown" style="padding: .2rem;">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="dropdown-menu dropdown-menu-right" >
            <a class="dropdown-item" href="${base}/languages/add">Add</a>
        </div>
    </div>
</tag:pageModel>
