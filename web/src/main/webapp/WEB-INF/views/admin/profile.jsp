<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:main title="Home">
    <form:form action="/admin" method="${createMode ? 'POST' : 'PUT'}" modelAttribute="userAccount">
        <form:hidden path="id"/>

        <div class="text-center">
            <h1>
                <spring:message code="profile.header" text="Personal Information"/>
            </h1>
        </div>


        <div class="text-center">
            <c:if test="${readonly == true}">
                <div>
                    <a href="/admin/update/${userAccount.id}">
                        <i class="fa fa-pencil-square-o"></i>
                        <spring:message code="common.updateDetails" text="Update Details"/>
                    </a>
                    |
                    <a href="/admin/update/role/${userAccount.id}">
                        <i class="fa fa-briefcase"></i>
                        <spring:message code="common.updateRole" text="Update Roles"/>
                    </a>
                </div>
            </c:if>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <form:label path="username">Username</form:label>
                <form:input path="username" cssClass="form-control" placeholder="Username" readonly="${!createMode}"/>
            </div>
            <div class="form-group col-md-6">
                <form:label path="newPassword">Password</form:label>
                <form:input path="newPassword" cssClass="form-control" readonly="${!createMode and readonly}"
                            placeholder="Password" type="password"/>
            </div>
        </div>
        <c:if test="${createMode}">
            <div class="row">
                <div class="form-group col-md-6">
                    <form:label path="username">Initial Role</form:label>
                    <select name="initialRole" class="form-control">
                        <c:forEach items="${adminRoleList}" var="role">
                            <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </c:if>
        <br><br>
        <c:if test="${readonly == false}">
            <div class="row">
                <div class="col-md-2 col-md-offset-5">
                    <button class="btn btn-primary btn-block" type="submit">Submit</button>
                </div>
            </div>
        </c:if>

    </form:form>


    <c:if test="${readonly}">
        <div class="row">

            <!-- Person Role -->
            <div class="col-md-6">
                <div>
                    <h3>
                        <spring:message code="user.profile.roleLabel" text="Role"/>
                        <spring:message code="user.profile.addRole" text="Add Role" var="addRoleLbl"/>
                        <button class="btn btn-primary pull-right <c:if test="${hidden}">hidden</c:if>"
                                data-toggle="modal"
                                data-target="#roleModal">
                                ${addRoleLbl}
                        </button>
                    </h3>
                </div>
                <br>

                <div>
                    <table class="table table-condensed table-bordered">
                        <thead>
                        <tr>
                            <th><spring:message code="user.profile.roleLabel" text="Role Title"/></th>
                            <th class="thAction <c:if test="${hidden}">hidden</c:if>">
                                <spring:message code="common.actions" text="Actions"/>
                            </th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:if test="${userAccount.roles.isEmpty()}">
                            <tr>
                                <td class="text-center" colspan="2">
                                    <spring:message code="message.role.personHasNoRole" text="Person has no Roles."/>
                                </td>
                            </tr>
                        </c:if>
                        <c:forEach var="role" items="${userAccount.roles}">
                            <tr>
                                <td>${role.name}</td>
                                <td class="tdActions <c:if test="${hidden}">hidden</c:if>">
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
                                                <form:form action="/admin/role/remove" method="delete">
                                                <input type="hidden" name="userId" value="${userAccount.id}">
                                                <input type="hidden" name="roleId" value="${role.id}">
                                                <button class="btn btn-link" type="submit">
                                                        <spring:message code="common.delete" text="Delete"/>
                                                    </form:form>
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
        </div>


    </c:if>

    <!-- Role Modal -->
    <div class="modal fade" id="roleModal" tabindex="-1" role="dialog" aria-labelledby="roleModalTitle">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="roleModalTitle">
                        <spring:message code="roleModal.mode.create" text="Add a"/> Role
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form" action="/admin/role/add" method="post" id="addRoleForm">
                        <input type="hidden" name="_method"
                               value="put">
                        <input type="hidden" name="userId" value='${userAccount.id}'>
                        <div class="form-group">
                            <label class="control-label" for="role">Role</label>
                            <select name="roleId" id="role" class="form-control" required>
                                <option value="">
                                    <spring:message code="roleModal.selectOne" text="Select One"/>
                                </option>
                                <c:forEach var="role" items='${roleList}'>
                                    <option value="${role.id}">${role.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <spring:message code="common.close" text="Close"/>
                    </button>
                    <button type="submit" class="btn btn-primary" form="addRoleForm">
                        <spring:message code="common.submit" text="Submit"/>
                    </button>
                </div>
            </div>
        </div>
    </div>

</t:main>