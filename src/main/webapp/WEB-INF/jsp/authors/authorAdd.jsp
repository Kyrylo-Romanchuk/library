<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tag:pageModel title="New author" errorMessage="${error}" datePicker="true">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${base}/authors/add">
            <div class="container col-md-6">
                <div class="form-group text-center">
                    <label for="firstName">First name</label>
                    <input type="text" id="firstName" name="firstName" class="form-control"
                           placeholder="Enter first name"
                           autofocus=""
                           value="${author.getFirstName()}">
                    <tag:errorOnPage errorName="firstName"/>
                    <label for="lastName">Last name</label>
                    <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Enter last name"
                           autofocus=""
                           value="${author.getLastName()}">
                    <tag:errorOnPage errorName="lastName"/>
                    <label for="birthDay">Birthday</label>
                    <input id="birthDay" name="birthDay" class="form-control date-picker" placeholder="dd/MM/yyyy"
                           autofocus=""
                           value="<fmt:formatDate value="${author.getBirthDay()}" pattern="MM/dd/yyyy"/>">
                    <tag:errorOnPage errorName="birthDay"/>
                    <label for="dieDay">Die day</label>
                    <input id="dieDay" name="dieDay" class="form-control date-picker" placeholder="dd/MM/yyyy"
                           autofocus=""
                           value="<fmt:formatDate value="${author.getDieDay()}" pattern="MM/dd/yyyy"/>">
                    <label for="biography">Biography</label>
                    <textarea id="biography" name="biography" class="form-control"
                              placeholder="Enter biography"
                              autofocus="" rows="5">${author.getBiography()}</textarea>
                    <tag:errorOnPage errorName="biography"/>
                </div>
            </div>

            <div class="text-center">
                <button class="btn btn-lg btn-primary" type="submit">Add author</button>
            </div>
        </form>
    </div>
</tag:pageModel>