<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel title="New genre" errorMessage="${error}">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${base}/genres/add">
            <div class="container col-md-6">
                <div class="form-group text-center">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" class="form-control"
                           placeholder="Enter name"
                           autofocus=""
                           value="${genre.getName()}">
                    <tag:errorOnPage errorName="name"/>
                </div>
            </div>

            <div class="text-center">
                <button class="btn btn-lg btn-primary" type="submit">Add genre</button>
            </div>
        </form>
    </div>
</tag:pageModel>