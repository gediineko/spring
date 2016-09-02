<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:main title="Role List">
    <div class="col-md-6 col-md-offset-3">
        <h1 class="text-center">
            <spring:message code="role.list.label" text="Role List"/>
        </h1>
        <br><br>

        <div class="row">
            <button class="btn btn-default pull-right" href="#" data-toggle="modal"
                data-target="#roleModal">
                <spring:message code="user.profile.addRole" text="Add Role"/>
            </button>
        </div>
        <br>

        <div class="row">
            <table class=" table table-condensed table-bordered">
                <thead>
                <tr>
                    <th>
                        <spring:message code="user.list.id" text="ID"/>
                    </th>
                    <th>
                        <spring:message code="user.profile.roleLabel" text="Role"/>
                    </th>
                    <th>
                        <spring:message code="common.actions" text="Actions"/>
                    </th>
                </tr>
                </thead>

                <tbody>
                <c:if test="${roleList.isEmpty()}">
                    <tr>
                        <td class="text-center" colspan="2">
                            <spring:message code="message.role.noRolesFound" text="No Roles Found"/>
                        </td>
                    </tr>
                </c:if>
                <c:forEach var="role" items="${roleList}">
                    <tr>
                        <td>${role.id}</td>
                        <td>${role.name}</td>
                        <td class="tdActions">
                                <span class="dropdown pull-right">
                                        <button class="btn btn-default dropdown-toggle" type="button"
                                                id="dropDownMenuRole${role.id}"
                                                data-toggle="dropdown"
                                                aria-haspopup="true"
                                                aria-expanded="true">
                                            <spring:message code="common.actions" text="Actions"/>
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropDownMenuRole${role.id}">
                                            <li>
                                                <button class="btn btn-link" href="#" data-toggle="modal"
                                                    data-target="#roleModal${role.id}">
                                                <spring:message code="common.update" text="Update"/>
                                                    </button>
                                            </li>
                                            <li>
                                                <form:form action="/user/role/delete" method="delete">
                                                    <input type="hidden" name="roleId" value="${role.id}">
                                                    <button class="btn btn-link" type="submit">
                                                        <spring:message code="common.delete" text="Delete"/>
                                                    </button>
                                                </form:form>
                                            </li>
                                        </ul>
                                </span>
                        </td>
                    </tr>
                    <t:roleModal mode="Update" role="${role}"/>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <t:roleModal mode="Create"/>
</t:main>
