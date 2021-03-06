<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                <c:if test="${mode.equals('Create')}">
                    <spring:message code="contactmodal.create" text="Create Contact" var="modeLabel"/>
                </c:if>
                <c:if test="${mode.equals('Update')}">
                    <spring:message code="contactmodal.update" text="Update Contact" var="modeLabel"/>
                </c:if>
                <h4 class="modal-title" id="contactModalTitle${contact.id}">
                    ${modeLabel}
                </h4>
            </div>
            <div class="modal-body">
                <form class="form" action="/user/profile/contact" method="post" id="contactForm${contact.id}">
                    <input type="hidden" name="_method" value="${mode.equals('Create') ? 'POST' : 'PUT'}">
                    <input type="hidden" name="userProfileId" value='${user.id}'>
                    <input type="hidden" name="id" value='${contact.id}'>

                    <div class="form-group">
                        <label for="contactType" class="control-label req">
                            <spring:message code="user.profile.contactType" text="Type"/>
                        </label>
                        <select name="contactType" id="contactType" class="form-control" required>
                            <option value="">
                                <spring:message code="contactmodal.selectOne" text="Select One"/>
                            </option>
                            <option value="Mobile Number" ${contact.contactType.equals('Mobile Number') ? 'selected' : ''}>Mobile Number</option>
                            <option value="Land Line"  ${contact.contactType.equals('Land Line') ? 'selected' : ''}>Land Line</option>
                            <option value="Email"  ${contact.contactType.equals('Email') ? 'selected' : ''}>Email</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="contactInfo" class="control-label req">
                            <spring:message code="user.profile.contactInfo" text="Info" var="contactInfo"/>
                            ${contactInfo}
                        </label>
                        <input type="text" id="contactInfo" name="contactInfo" class="form-control"
                               required value="${contact.contactInfo}"
                                placeholder="${contactInfo}">
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    <spring:message code="common.close" text="Close"/>
                </button>
                <button type="submit" class="btn btn-primary" form="contactForm${contact.id}">
                    <spring:message code="common.submit" text="Submit"/>
                </button>
            </div>
        </div>
    </div>
</div>