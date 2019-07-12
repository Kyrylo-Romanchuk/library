<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel title="New genre" errorMessage="${error}">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${base}/genres/add">
            <input type="hidden" name="id" value="${genre.getId()}">
            <div class="container col-md-6">
                <div class="form-group text-center">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" class="form-control"
                           placeholder="Enter name"
                           value="${genre.getName()}">
                    <tag:errorOnPage errorName="name"/>
                </div>
            </div>

            <tag:actionSave/>
        </form>
    </div>
</tag:pageModel>