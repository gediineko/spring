<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <form class="form" action="/admin/role/updateRole" method="post" id="roleForm${role.id}">
                    <input type="hidden" name="_method" value="${mode.equals('Create') ? 'POST' : 'PUT'}">
                    <input type="hidden" name="roleId" value='${role.id}'>

                    <label for="roleName">Type in name of new Role:</label>
                    <input id="roleName" name="roleName" type="text" class="form-control" placeholder="Role Name"
                           value="${role.name}">

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" form="roleForm${role.id}">${mode.equals('Edit') ? 'Save Changes' : 'Submit'}</button>
            </div>
        </div>
    </div>
</div>