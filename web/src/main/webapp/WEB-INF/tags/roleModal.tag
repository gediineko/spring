<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@tag description="Role modal Template" pageEncoding="UTF-8" %>
<%@attribute name="role" type="com.exist.model.dto.RoleDto" %>
<%@attribute name="mode" required="true" %>
<div class="modal fade" id="roleModal${role.id}" tabindex="-1" role="dialog" aria-labelledby="roleModalTitle${roleId}">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="roleModalTitle${role.id}">${mode} Role</h4>
            </div>
            <div class="modal-body">
                <form class="form" action="/role/addUpdateRole" method="post" id="roleForm${role.id}">
                    <input type="hidden" name="_method" value="${mode.equals('Create') ? 'POST' : 'PUT'}">
                    <input type="hidden" name="roleId" value='${role.id}'>

                    <div class="form-group">
                        <label for="roleType">
                            <spring:message code="roleModal.roleType" text="Role Type"/>
                        </label>
                        <select name="roleType" id="roleType" class="form-control">
                            <option value="">
                                <spring:message code="roleModal.selectOne" text="Select one"/>
                            </option>
                            <c:forEach var="roleType" items="${roleTypeList}">
                                <option value="${roleType}">${roleType.desc}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <label for="roleName">
                        <spring:message code="roleModal.roleName" text="Role Name" var="roleNameLbl"/>
                        ${roleNameLbl}
                    </label>
                    <input id="roleName" name="name" type="text" class="form-control" placeholder="${roleNameLbl}"
                           value="${role.name}">

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    <spring:message code="common.close" text="Close"/>
                </button>
                <button type="submit" class="btn btn-primary" form="roleForm${role.id}">
                    <spring:message code="common.submit" text="submit"/>
                </button>
            </div>
        </div>
    </div>
</div>