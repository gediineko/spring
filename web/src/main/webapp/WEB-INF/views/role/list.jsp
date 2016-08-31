<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:main title="Role List">
    <div class="col-md-6 col-md-offset-3">
        <h1 class="text-center">
            <spring:message code="role.list.label" text="Role List"/>
        </h1>
        <br><br>
        <div class="row">
            <button class="btn btn-primary pull-right">
                <spring:message code="user.profile.addRole" text="Add Role"/>
            </button>
        </div>
        <br>
        <div class="row">
            <table class=" table table-condensed table-bordered">
                <thead>
                    <tr>
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
                    <tr>
                        <td>
                            <!-- add role list -->
                        </td>
                        <td>

                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</t:main>
