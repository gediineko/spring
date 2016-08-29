<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:main title="Home">
    ADMIN Dashboard <a href="/template/template.csv" download>Download template</a>
    <form action="/admin" method="post" enctype="multipart/form-data">
        <input type="file" name="file" id="file" class="form-control">
        <button type="submit">Submit</button>
    </form>
</t:main>