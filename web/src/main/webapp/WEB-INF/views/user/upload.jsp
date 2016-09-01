<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:main title="Upload">
    <a href="/template/template.csv" download>Download template</a>
    <form action="/admin" method="post" enctype="multipart/form-data">
        <input type="file" name="file" id="file" class="form-control">
        <button type="submit">Submit</button>
    </form>
</t:main>