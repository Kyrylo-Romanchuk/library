<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:pageModel dataTable="books">
        <table id="books" class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Year</th>
                <th>Author</th>
                <th>Info</th>
                <th>Language</th>
            </tr>
            </thead>

            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.getName()}</td>
                    <td>${book.getYear()}</td>
                    <td>${book.getAuthor()}</td>
                    <td>${book.getInfo()}</td>
                    <td>${book.getLanguage()}</td>
                </tr>
            </c:forEach>
        </table>
</tag:pageModel>

