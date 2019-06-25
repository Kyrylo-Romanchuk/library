<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageValidationResult" value="${validationResult}" scope="page"></c:set>

<tag:pageModel title="New author" errorMessage="${error}" datePicker="true">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${pageContext.request.contextPath}/authors/add">
            <div class="container col-md-5">
                <div class="form-group text-center">
                    <label for="firstName">First name</label>
                    <input type="text" id="firstName" name="firstName" class="form-control"
                           placeholder="Enter first name"
                           autofocus="">
                    <c:if test="${pageValidationResult != null && pageValidationResult.getResultByKey('firstName') != null}">
                        <div class="alert alert-danger" role="alert">
                                ${pageValidationResult.getResultByKey('firstName')}
                        </div>
                    </c:if>
                    <label for="lastName">Last name</label>
                    <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Enter last name"
                           autofocus="">
                    <c:if test="${pageValidationResult != null && pageValidationResult.getResultByKey('lastName') != null}">
                        <div class="alert alert-danger" role="alert">
                                ${pageValidationResult.getResultByKey('lastName')}
                        </div>
                    </c:if>
                    <label for="birthDay">Birthday</label>
                    <input id="birthDay" name="birthDay" class="form-control date-picker" placeholder="dd/MM/yyyy"
                           autofocus="">
                    <c:if test="${pageValidationResult != null && pageValidationResult.getResultByKey('birthDay') != null}">
                        <div class="alert alert-danger" role="alert">
                                ${pageValidationResult.getResultByKey('birthDay')}
                        </div>
                    </c:if>
                    <label for="dieDay">Die day</label>
                    <input id="dieDay" name="dieDay" class="form-control date-picker" placeholder="dd/MM/yyyy"
                           autofocus="">
                    <label for="biography">Biography</label>
                    <textarea id="biography" name="biography" class="form-control"
                              placeholder="Enter biography"
                              autofocus="" rows="5"></textarea>
                    <c:if test="${pageValidationResult != null && pageValidationResult.getResultByKey('biography') != null}">
                        <div class="alert alert-danger" role="alert">
                                ${pageValidationResult.getResultByKey('biography')}
                        </div>
                    </c:if>
                </div>
            </div>

            <div class="text-center">
                <button class="btn btn-lg btn-primary" type="submit">Add author</button>
            </div>
        </form>
    </div>
</tag:pageModel>