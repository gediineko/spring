<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:main title="Admin List">
    <div class="col-md-6 col-md-offset-3">
        <div class="row text-center">
            <h1>
                <spring:message code="admin.list.label" text="Administrator List"/>
            </h1>
        </div>
        <div class="row">
            <button class="btn btn-default pull-right">
                <spring:message code="admin.list.addAdmin" text="Add Admin"/>
            </button>
        </div>
        <div class="row">
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>
                            <spring:message code="common.actions" text="Actions"/>
                        </th>
                    </tr>
                </thead>

                <tbody>
                    <c:if test="${adminList.isEmpty()}">
                        <tr>
                            <td class="text-center" colspan="2"></td>
                        </tr>
                    </c:if>
                    <c:forEach var="admin" items="${adminList}">
                        <tr>
                            <td>${admin.username}</td>
                        </tr>
                        <tr>
                            <td>
                                <span class="dropdown pull-right">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            id="dropDownMenuAdmin${admin.id}"
                                            data-toggle="dropdown"
                                            aria-haspopup="true"
                                            aria-expanded="true">
                                            <spring:message code="common.actions" text="Actions"/>
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropDownMenuAdmin${admin.id}">
                                        <li>
                                            <button class="btn btn-link">
                                                <spring:message code="common.update" text="Update"/>
                                            </button>
                                        </li>
                                        <li>
                                            <button class="btn btn-link">
                                                <spring:message code="common.delete" text="Delete"/>
                                            </button>
                                        </li>
                                    </ul>
                                </span>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</t:main>