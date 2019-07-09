<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="errorName" %>

<c:if test="${validationResult.hasError(errorName)}">
    <div class="alert alert-danger" role="alert">
            ${validationResult.getError(errorName)}
    </div>
</c:if>