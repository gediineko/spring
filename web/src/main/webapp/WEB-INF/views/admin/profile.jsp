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
                        <spring:message code="common.update" text="Update"/>
                        <i class="fa fa-pencil-square-o"></i>
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

    <!-- Person Contact -->
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
                                                <form:form action="/user/profile/role/delete" method="delete">
                                                <input type="hidden" name="userAccountId" value="${userAccount.id}">
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

</t:main>