<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:main title="Home">
    <form:form action="/user" method="${createMode ? 'POST' : 'PUT'}" modelAttribute="userProfile">
        <form:hidden path="id" />

        <div class="text-center">
            <h1><spring:message code="profile.header" text="My Profile"/></h1>
        </div>

        <div class="row">
            <div class="col-md-6">
                <h3><spring:message code="user.profile.name" text="Name"/> </h3>

                <spring:message code="user.profile.title" text="Title" var="titleLbl"/>
                <form:label path="name.title">${titleLbl}</form:label>
                <form:input path="name.title" cssClass="form-control" readonly="${readonly}" placeholder="${titleLbl}"/>

                <spring:message code="user.profile.firstName" text="First Name" var="firstNameLbl"/>
                <form:label path="name.firstName">${firstNameLbl}</form:label>
                <form:input path="name.firstName" cssClass="form-control" readonly="${readonly}" placeholder="${firstNameLbl}"/>

                <spring:message code="user.profile.middleName" text="Middle Name" var="middleNameLbl"/>
                <form:label path="name.middleName">${middleNameLbl}</form:label>
                <form:input path="name.middleName" cssClass="form-control" readonly="${readonly}" placeholder="${middleNameLbl}"/>

                <spring:message code="user.profile.lastName" text="Last Name" var="lastNameLbl"/>
                <form:label path="name.lastName">${lastNameLbl}</form:label>
                <form:input path="name.lastName" cssClass="form-control" readonly="${readonly}" placeholder="${lastNameLbl}"/>

                <spring:message code="user.profile.suffix" text="Suffix" var="suffixLbl"/>
                <form:label path="name.suffix">${suffixLbl}</form:label>
                <form:input path="name.suffix" cssClass="form-control" readonly="${readonly}" placeholder="${suffixLbl}"/>
            </div>
        </div>

    </form:form>

</t:main>