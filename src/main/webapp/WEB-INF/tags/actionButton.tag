<%@ attribute name="url" %>
<%@ attribute name="method" %>
<%@ attribute name="id" %>

<form method="${method}" action="${url}">
    <input type="hidden" name="id" value="${id}">
    <button class="btn btn-sm btn-dark">
        <jsp:doBody/>
    </button>
</form>