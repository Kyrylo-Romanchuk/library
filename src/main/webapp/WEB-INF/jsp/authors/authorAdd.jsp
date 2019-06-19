<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tag:pageModel title="New author" errorMessage="${error}">
    <div class="text-center">
        <form class="justify-content-center" method="post" action="${pageContext.request.contextPath}/authors/add">
            <div class="container col-md-5">
                <div class="form-group text-center">
                    <label for="id">id</label>
                    <input type="text" id="id" name="id" class="form-control"
                           placeholder="Enter id"
                           required=""
                           autofocus="">
                    <label for="firstName">First name</label>
                    <input type="text" id="firstName" name="firstName" class="form-control"
                           placeholder="Enter first name"
                           required=""
                           autofocus="">
                    <label for="lastName">Last name</label>
                    <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Enter last name"
                           required=""
                           autofocus="">
                    <label for="biography">Biography</label>
                    <input type="text" id="biography" name="biography" class="form-control"
                           placeholder="Enter biography"
                           required="" autofocus="">
                    <label for="birthDay">Birthday</label>
                    <input type="text" id="birthDay" name="birthDay" class="form-control" placeholder="Enter birthday"
                           required=""
                           autofocus="">
                    <label for="dieDay">Die day</label>
                    <input type="text" id="dieDay" name="dieDay" class="form-control" placeholder="Enter die day"
                           required=""
                           autofocus="">
                </div>
            </div>

            <div class="text-center">
                <button class="btn btn-lg btn-primary" type="submit">Add author</button>
            </div>
        </form>
    </div>
</tag:pageModel>