<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:main title="Home">
    ADMIN Dashboard
    <sec:authentication property="principal.authorities" />
</t:main>