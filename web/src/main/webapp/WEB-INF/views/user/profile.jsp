<%@ page import="com.exist.model.dto.ContactDto" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:main title="Home">
    <form:form action="/user" method="${createMode ? 'POST' : 'PUT'}" modelAttribute="userProfile">
        <form:hidden path="id"/>

        <div class="text-center">
            <h1><spring:message code="profile.header" text="My Profile"/></h1>
        </div>

        <div class="row">
            <div class="col-md-6">
                <h3><spring:message code="user.profile.name" text="Name"/></h3>

                <div class="form-group">
                    <spring:message code="user.profile.title" text="Title" var="titleLbl"/>
                    <form:label path="name.title">${titleLbl}</form:label>
                    <form:input path="name.title" cssClass="form-control" readonly="${readonly}"
                                placeholder="${titleLbl}"/>
                </div>

                <div class="form-group">
                    <spring:message code="user.profile.firstName" text="First Name" var="firstNameLbl"/>
                    <form:label path="name.firstName" cssClass="req">${firstNameLbl}</form:label>
                    <form:input path="name.firstName" cssClass="form-control" readonly="${readonly}"
                                placeholder="${firstNameLbl}" required="required"/>
                </div>

                <div class="form-group">
                    <spring:message code="user.profile.middleName" text="Middle Name" var="middleNameLbl"/>
                    <form:label path="name.middleName">${middleNameLbl}</form:label>
                    <form:input path="name.middleName" cssClass="form-control" readonly="${readonly}"
                                placeholder="${middleNameLbl}"/>
                </div>

                <div class="form-group">
                    <spring:message code="user.profile.lastName" text="Last Name" var="lastNameLbl"/>
                    <form:label path="name.lastName" cssClass="req">${lastNameLbl}</form:label>
                    <form:input path="name.lastName" cssClass="form-control" readonly="${readonly}"
                                placeholder="${lastNameLbl}" required="required"/>
                </div>

                <div class="form-group">
                    <spring:message code="user.profile.suffix" text="Suffix" var="suffixLbl"/>
                    <form:label path="name.suffix">${suffixLbl}</form:label>
                    <form:input path="name.suffix" cssClass="form-control" readonly="${readonly}"
                                placeholder="${suffixLbl}"/>
                </div>

                <div class="form-group">
                    <spring:message code="user.profile.birthDate" text="Birth Date" var="birthDateLbl"/>
                    <h3 class="req">${birthDateLbl}</h3>
                    <form:input path="birthDate" cssClass="form-control" readonly="${readonly}"
                                placeholder="yyyy-mm-dd" required="required"/>
                </div>
            </div>

            <div class="col-md-6">
                <h3><spring:message code="user.profile.address" text="Address"/></h3>
                <div class="row">
                    <div class="form-group col-md-6">
                        <spring:message code="user.profile.streetNumber" text="Street Number" var="streetNumberLbl"/>
                        <form:label path="address.streetNumber">${streetNumberLbl}</form:label>
                        <form:input path="address.streetNumber" cssClass="form-control" readonly="${readonly}"
                                    placeholder="${streetNumberLbl}"/>
                    </div>
                    <div class="form-group col-md-6">
                        <spring:message code="user.profile.barangay" text="Barangay" var="barangayLbl"/>
                        <form:label path="address.barangay">${barangayLbl}</form:label>
                        <form:input path="address.barangay" cssClass="form-control" readonly="${readonly}"
                                    placeholder="${barangayLbl}"/>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-6">
                        <spring:message code="user.profile.city" text="City" var="cityLbl"/>
                        <form:label path="address.city" cssClass="req">${cityLbl}</form:label>
                        <form:input path="address.city" cssClass="form-control" readonly="${readonly}"
                                    placeholder="${cityLbl}" required="required"/>
                    </div>
                    <div class="form-group col-md-6">
                        <spring:message code="user.profile.zipCode" text="Zip Code" var="zipCodeLbl"/>
                        <form:label path="address.zipCode">${zipCodeLbl}</form:label>
                        <form:input path="address.zipCode" cssClass="form-control" readonly="${readonly}"
                                    placeholder="${zipCodeLbl}"/>
                    </div>
                </div>

                <h3><spring:message code="user.profile.otherInfo" text="Other Information"/></h3>

                <div class="form-group">
                    <spring:message code="user.profile.gwa" text="GWA" var="gwaLbl"/>
                    <form:label path="gwa">${gwaLbl}</form:label>
                    <form:input path="gwa" cssClass="form-control" readonly="${readonly}" placeholder="${gwaLbl}"/>
                </div>

                <div class="form-group">
                    <label class="req"><spring:message code="user.profile.currentlyEmployed"
                                                       text="Currently Employed"/></label>

                    <div class="radio row">
                        <div class="col-md-12">
                            <label class="col-md-3">
                                <form:radiobutton path="currentlyEmployed" disabled="${readonly}" value="true"/>
                                <spring:message code="common.yes" text="Yes"/>
                            </label>

                            <label class="col-md-3">
                                <form:radiobutton path="currentlyEmployed" disabled="${readonly}" value="false"/>
                                <spring:message code="common.no" text="No"/>
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <spring:message code="user.profile.dateHired" text="Date Hired" var="dateHiredLbl"/>
                    <label>${dateHiredLbl}</label>
                    <form:input path="dateHired" cssClass="form-control" readonly="${readonly}"
                                placeholder="yyyy-mm-dd"/>
                </div>
            </div>
        </div>
    </form:form>

    <!-- Person Contact -->
    <c:if test="${readonly}">
        <div class="row">
            <div class="col-md-6">
                <div>
                    <h3>
                        <spring:message code="user.profile.contactLabel" text="Contact"/>
                        <spring:message code="user.profile.addContact" text="Add Contact" var="addContactLbl"/>
                        <button class="btn btn-primary pull-right <c:if test="${hidden}">hidden</c:if>"
                                data-toggle="modal"
                                data-target="#contactModal">
                                ${addContactLbl}
                        </button>
                    </h3>
                </div>

                <div>
                    <table class="table table-condensed table-bordered">
                        <thead>
                        <tr>
                            <th><spring:message code="user.profile.contactType" text="Type"/></th>
                            <th><spring:message code="user.profile.contactInfo" text="Info"/></th>
                            <th class="thActions <c:if test="${hidden}">hidden</c:if>">
                                <spring:message code="common.actions" text="Actions"/>
                            </th>
                        </tr>
                        </thead>
                        <br>
                        <tbody>
                        <c:if test="${userProfile.contactInfo.isEmpty()}">
                            <tr>
                                <td colspan="3" class="text-center"><spring:message
                                        code="message.contact.personHasNoContacts"
                                        text="Person has no contacts."/></td>
                            </tr>
                        </c:if>
                        <c:forEach var="contact" items="${userProfile.contactInfo}">
                            <tr>
                                <td>${contact.contactType}</td>
                                <td>${contact.contactInfo}</td>
                                <td class="tdActions <c:if test="${hidden}">hidden</c:if>">
                                    <span class="dropdown">
                                        <button class="btn btn-default btn-block dropdown-toggle"
                                                type="button" id="dropDownMenuContact${contact.id}"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                <spring:message code="common.actions" text="Actions"/>
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuContact${contact.id}">
                                            <li>
                                                <button class="btn btn-link" href="#" data-toggle="modal"
                                                        data-target="#contactModal${contact.id}">
                                                    <spring:message code="common.update" text="Update"/>
                                                </button>
                                            </li>
                                            <li>
                                                <form:form action="/user/profile/contact/delete" method="delete">
                                                    <input type="hidden" name="userProfileId" value="${userProfile.id}">
                                                    <input type="hidden" name="contactId" value="${contact.id}">
                                                    <button class="btn btn-link" type="submit">
                                                            <spring:message code="common.delete" text="Delete"/>
                                                    </button>
                                                </form:form>
                                            </li>
                                        </ul>
                                    </span>
                                </td>
                            </tr>
                            <t:contactModal mode="Update" contact="${contact}" user="${userProfile}"/>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

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
                        <c:if test="${userProfile.roles.isEmpty()}">
                            <tr>
                                <td class="text-center" colspan="2">
                                    <spring:message code="message.contact.personHasNoRole" text="Person has no Roles."/>
                                </td>
                            </tr>
                        </c:if>
                        <c:forEach var="role" items="${userProfile.roles}">
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
                                                    <input type="hidden" name="userProfileId" value="${userProfile.id}">
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
    <t:contactModal mode="Create" user="${userProfile}"/>

</t:main>