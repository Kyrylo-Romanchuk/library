<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel title="New language" errorMessage="${error}">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${base}/languages/add">
            <input type="hidden" name="id" value="${language.getId()}">
            <div class="container col-md-6">
                <div class="form-group text-center">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" class="form-control"
                           placeholder="Enter name"
                           value="${language.getName()}">
                    <tag:errorOnPage errorName="name"/>
                    <label for="shortName">Short name</label>
                    <input type="text" id="shortName" name="shortName" class="form-control"
                           placeholder="Enter short name"
                           value="${language.getShortName()}">
                    <tag:errorOnPage errorName="shortName"/>
                </div>
            </div>

            <tag:actionSave/>
        </form>
    </div>
</tag:pageModel>