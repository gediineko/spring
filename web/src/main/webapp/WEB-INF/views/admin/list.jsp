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
        <br>
        <div class="row">
            <a href="/admin/create" class="btn btn-default pull-right">
                <spring:message code="admin.list.addAdmin" text="Add Admin"/>
            </a>
        </div>
        <br>
        <div class="row">
            <table class="table table-condensed table-bordered">
                <thead>
                <tr>
                    <th colspan="3">Username</th>
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
                        <td colspan="3">${admin.username}</td>
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
                                            <a href="/admin/profile/${admin.id}">
                                                <spring:message code="common.view" text="View"/>
                                            </a>
                                        </li>
                                        <li>
                                            <form action="/admin" method="post"
                                                  id="deleteForm${admin.id}">
                                                <input type="hidden" name="_method"
                                                       value="delete">
                                                <input type="hidden" name="userAccountId" value="${admin.id}">
                                                <button class="btn btn-link" type="submit">
                                                    <spring:message code="common.delete" text="Delete"/>
                                                </button>
                                            </form>

                                        </li>
                                    </ul>
                                </span>
                        </td>
                    </tr>
                    <t:administratorModal mode="Update" admin="${admin}"/>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Admin Modal -->
        <t:administratorModal mode="Create"/>
    </div>
</t:main>