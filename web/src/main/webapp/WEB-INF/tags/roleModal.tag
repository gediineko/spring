<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@tag description="Role modal Template" pageEncoding="UTF-8" %>
<%@attribute name="roleId"  %>
<%@attribute name="roleName"  %>
<%@attribute name="mode" required="true" %>
<div class="modal fade" id="roleModal${roleId}" tabindex="-1" role="dialog" aria-labelledby="roleModalTitle${roleId}">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="roleModalTitle${roleId}">${mode} Role</h4>
            </div>
            <div class="modal-body">
                <form class="form" action="${mode.equals('Create') ? '/role/addRole' : '/role/updateRole'}" method="post" id="roleForm${roleId}">
                    <input type="hidden" name="roleId" value='${roleId}'>

                    <label for="roleName">Type in name of new Role:</label>
                    <input id="roleName" name="roleName" type="text" class="form-control" placeholder="Role Name"
                           value="${roleName}">

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" form="roleForm${roleId}">${mode.equals('Edit') ? 'Save Changes' : 'Submit'}</button>
            </div>
        </div>
    </div>
</div>