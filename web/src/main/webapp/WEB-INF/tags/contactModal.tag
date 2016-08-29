<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@tag description="Contact modal Template" pageEncoding="UTF-8" %>
<%@attribute name="user" type="com.exist.model.dto.UserProfileDto"  %>
<%@attribute name="contact" type="com.exist.model.dto.ContactDto"  %>
<%@attribute name="mode" required="true" %>
<div class="modal fade" id="contactModal${contact.id}" tabindex="-1" role="dialog" aria-labelledby="contactModalTitle${contact.id}">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="contactModalTitle${contact.id}">${mode} Contact</h4>
            </div>
            <div class="modal-body">
                <form class="form" action="/user/profile/contact" method="post" id="contactForm${contact.id}">
                    <input type="hidden" name="_method" value="${mode.equals('Create') ? 'POST' : 'PUT'}">
                    <input type="hidden" name="userProfileId" value='${user.id}'>
                    <input type="hidden" name="id" value='${contact.id}'>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div class="form-group">
                        <label for="contactType" class="control-label req">Contact Type</label>
                        <select name="contactType" id="contactType" class="form-control" required>
                            <option value="">Select One</option>
                            <option value="Mobile Number" ${contact.contactType.equals('Mobile Number') ? 'selected' : ''}>Mobile Number</option>
                            <option value="Land Line"  ${contact.contactType.equals('Land Line') ? 'selected' : ''}>Land Line</option>
                            <option value="Email"  ${contact.contactType.equals('Email') ? 'selected' : ''}>Email</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="contactInfo" class="control-label req">Contact Info</label>
                        <input type="text" id="contactInfo" name="contactInfo" class="form-control" required value="${contact.contactInfo}">
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" form="contactForm${contact.id}">${mode.equals('Edit') ? 'Save Changes' : 'Submit'}</button>
            </div>
        </div>
    </div>
</div>