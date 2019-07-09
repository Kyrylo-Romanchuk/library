<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel title="New language" errorMessage="${error}">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${pageContext.request.contextPath}/languages/add">
            <div class="container col-md-6">
                <div class="form-group text-center">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" class="form-control"
                           placeholder="Enter name"
                           autofocus=""
                           value="${language.getName()}">
                    <tag:errorOnPage errorName="Name"/>
                    <label for="shortName">Short name</label>
                    <input type="text" id="shortName" name="shortName" class="form-control" placeholder="Enter short name"
                           autofocus=""
                           value="${language.getShortName()}">
                    <tag:errorOnPage errorName="shortName"/>
                </div>
            </div>

            <div class="text-center">
                <button class="btn btn-lg btn-primary" type="submit">Add language</button>
            </div>
        </form>
    </div>
</tag:pageModel>