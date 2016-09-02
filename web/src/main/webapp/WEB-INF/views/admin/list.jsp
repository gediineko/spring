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
            <button class="btn btn-default pull-right" data-toggle="modal" data-target="#adminModal">
                <spring:message code="admin.list.addAdmin" text="Add Admin"/>
            </button>
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
                                <span class="dropdown">
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

        <!-- Admin Modal -->
        <div class="modal fade" id="adminModal" tabindex="-1" aria-labelledby="adminModalTitle">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="model-header">
                        <button type="button" class="close" aria-labelledby="close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <label for="roleNameInput">
                            <spring:message code="user.profile.roleLabel" text="Role" var="roleLbl"/>
                            ${roleLbl}
                        </label>
                        <input type="text" class="form-control" id="roleNameInput" placeholder="${roleLbl}" required/>
                        <span class="dropdown">

                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:main>