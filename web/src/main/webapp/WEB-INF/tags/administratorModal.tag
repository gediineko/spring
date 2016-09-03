<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@tag description="Admin modal Template" pageEncoding="UTF-8" %>
<%@attribute name="admin" type="com.exist.model.dto.UserAccountDto" %>
<%@attribute name="mode" required="true" %>
<div class="modal fade" id="adminModal${admin.id}" tabindex="-1" role="dialog"
     aria-labelledby="adminModalTitle${admin.id}">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <c:if test="${mode.equals('Create')}">
                    <spring:message code="adminModal.mode.create" text="Create " var="modeLabel"/>
                </c:if>
                <c:if test="${mode.equals('Update')}">
                    <spring:message code="adminModal.mode.update" text="Update " var="modeLabel"/>
                </c:if>
                <h4 class="modal-title" id="adminModalTitle${admin.id}">
                    ${modeLabel} <spring:message code="adminModal.admin" text="Administrator"/>
                </h4>
            </div>
            <div class="modal-body">
                <form class="form" action="/admin/addUpdateAdmin" method="post" id="adminForm${admin.id}">
                    <input type="hidden" name="_method" value="${mode.equals('Create') ? 'POST' : 'PUT'}">
                    <input type="hidden" name="id" value='${admin.id}'>

                    <div class="form-group">
                        <label class="req" for="roles">
                            <spring:message code="user.profile.roleLabel" text="Role"/>
                        </label>
                        <select name="roles" id="roles" class="form-control" required>
                            <option value="">
                                <spring:message code="roleModal.selectOne" text="Select one"/>
                            </option>
                            <c:forEach var="role" items="${roleList}">
                                <option value="${role}"></option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label class="req" for="username">Username</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username"
                            value="${admin.username}"
                               <c:if test="${mode.equals('Update')}">
                               readonly="readonly"
                            </c:if> required/>
                    </div>

                    <div class="form-group">
                        <label class="req" for="newPassword">Password</label>
                        <input type="text" class="form-control" id="newPassword" name="newPassword" placeholder="Password"
                            required/>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    <spring:message code="common.close" text="Close"/>
                </button>
                <button type="submit" class="btn btn-primary" form="adminForm${admin.id}">
                    <spring:message code="common.submit" text="submit"/>
                </button>
            </div>
        </div>
    </div>
</div>