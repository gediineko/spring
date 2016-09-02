<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<t:main title="Person List">
    <h1 class="text-center">
        <spring:message code="user.list.label" text="Person Details List"/>
    </h1>

    <!-- menus -->
    <div class="row pull-right">
        <div class="col-md-4">
            <button class="btn btn-default dropdown-toggle" type="button" id="sortDropDown"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                <spring:message code="user.list.sort.button" text="Sort"/>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="sortDropDown">
                <li>
                    <a href="/user?sort=gwa&dir=asc">
                        <spring:message code="user.list.sortByGwaAsc" text="by Gwa: ASC"/>
                    </a>
                </li>
                <li>
                    <a href="/user?sort=gwa&dir=desc">
                        <spring:message code="user.list.sortByGwaDesc" text="by Gwa: DESC"/>
                    </a>
                </li>
                <li role="separator" class="divider"></li>
                <li>
                    <a href="/user/?sort=dateHired&dir=asc">
                        <spring:message code="user.list.sortByDateHiredAsc" text="by Date Hired: ASC"/>
                    </a>
                </li>
                <li>
                    <a href="/user/?sort=dateHired&dir=desc">
                        <spring:message code="user.list.sortByDateHiredDesc" text="by Date Hired: DESC"/>
                    </a>
                </li>
                <li role="separator" class="divider"></li>
                <li>
                    <a href="/user/?sort=lastName&dir=asc">
                        <spring:message code="user.list.sortByLastNameAsc" text="by Last Name: ASC"/>
                    </a>
                </li>
                <li>
                    <a href="/user/?sort=lastName&dir=desc">
                        <spring:message code="user.list.sortByLastNameDesc" text="by Last Name: DESC"/>
                    </a>
                </li>
            </ul>
        </div>
        <div class="col-md-4">
            <button class="btn btn-default dropdown-toggle" type="button" id="createToggle"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                <spring:message code="user.list.newPerson.button" text="New Person"/>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="sortDropDown">
                <li>
                    <a href="/user/create">
                        <spring:message code="user.list.create.button" text="Create Person"/>
                    </a>
                </li>
                <li role="separator" class="divider"></li>
                <li>
                    <form action="/admin/user/upload" method="post" enctype="multipart/form-data">
                        <input type="file" name="file" onchange="this.form.submit()" class="form-control">
                    </form>
                </li>

            </ul>
        </div>
    </div>
    <br>
    <br>
    <!-- PERSON TABLE LIST -->
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th>
                    <spring:message code="user.list.id" text="ID"/>
                </th>
                <th>
                    <spring:message code="user.list.username" text="Username"/>
                </th>
                <th>
                    <spring:message code="user.profile.name" text="Name"/>
                </th>
                <th>
                    <spring:message code="user.profile.address" text="Address"/>
                </th>
                <th>
                    <spring:message code="user.profile.birthDate" text="Birth Date"/>
                </th>
                <th>
                    <spring:message code="user.profile.gwa" text="GWA"/>
                </th>
                <th>
                    <spring:message code="user.profile.currentlyEmployed" text="Currently Employed"/>
                </th>
                <th>
                    <spring:message code="user.profile.dateHired" text="Date Hired"/>
                </th>
                <th>
                    <spring:message code="common.actions" text="Actions"/>
                </th>
            </tr>
            </thead>

            <tbody>
            <c:if test="${userList.isEmpty()}">
                <tr>
                    <td> class="text-center" colspan="8">
                        <spring:message code="message.person.noPersonFound" text="No Person Found."/>
                    </td>
                </tr>
            </c:if>

            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.name}</td>
                    <td>${user.address}</td>
                    <td>
                        <fmt:formatDate value="${user.birthDate}" var="birthDate" pattern="yyyy-MM-dd"/>
                            ${birthDate}
                    </td>
                    <td>${user.gwa}</td>
                    <td>${user.currentlyEmployed ? 'Yes' : 'No'}</td>
                    <td>
                        <fmt:formatDate value="${user.dateHired}" var="dateHired" pattern="yyyy-MM-dd"/>
                            ${dateHired}
                    </td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button"
                                    id="dropdownMenu${user.id}"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                Actions
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu${user.id}">
                                <li><a href="/user/profile/${user.id}">View Person</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/user/update/${user.id}">Edit Person Details</a></li>
                                <li><a href="/user/update/contactRole/${user.id}">Edit Contacts & Roles</a></li>
                                <li role="separator" class="divider"></li>
                                <li>
                                    <form action="/user/delete" method="post"
                                          id="deleteForm${role.id}">
                                        <input type="hidden" name="personId" value="${user.id}">
                                        <button class="btn btn-link" type="submit">Delete</button>
                                    </form>
                                </li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</t:main>