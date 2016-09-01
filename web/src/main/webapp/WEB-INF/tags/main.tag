<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@tag description="Main Template" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><%= title %>
    </title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/css/custom.css"/>
</head>

<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand"
                    <sec:authorize access="hasAuthority('ADMIN')">
                        href="/admin"
                    </sec:authorize>
                    <sec:authorize access="hasAuthority('USER')">
                        href="/#"
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        href="/"
                    </sec:authorize>
            >
                Gedii
            </a>
        </div>
        <sec:authorize access="hasAuthority('ADMIN')">
            <ul class="nav navbar-nav">

                <li
                        <c:if test="${fn:startsWith(requestScope.get('javax.servlet.forward.request_uri'), '/user/role')}">
                            class="active"
                        </c:if>
                >
                    <a href="/user/role">
                        <spring:message code="common.roleManagement" text="Role Management"/>
                    </a>
                </li>

                <li
                        <c:if test="${fn:startsWith(requestScope.get('javax.servlet.forward.request_uri'), '/user')}">
                            class="active"
                        </c:if>
                        >
                    <a href="/role">
                        <spring:message code="common.personManagement" text="Person Management"/>
                    </a>
                </li>

                <li
                        <c:if test="${fn:startsWith(requestScope.get('javax.servlet.forward.request_uri'), '/admin/list')}">
                            class="active"
                        </c:if>
                        >
                    <a href="/admin/list">
                        <spring:message code="common.adminManagement" text="Admin Management"/>
                    </a>
                </li>
            </ul>

        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/logout">
                        <spring:message code="common.logOut" text="Log-out"/>
                    </a>
                </li>
            </ul>
        </sec:authorize>
    </div>
</nav>

<div class="container" id="main-container">
    <jsp:doBody/>
</div>

<footer class="footer">
    <div class="container">
        <ul class="nav navbar-nav pull-right">
            <li class="dropup">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true">
                    <i class="fa fa-globe"></i>
                    <spring:message code="common.language" text="Language"/>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="${requestScope.get('javax.servlet.forward.request_uri')}?lang=en">English</a></li>
                    <li><a href="${requestScope.get('javax.servlet.forward.request_uri')}?lang=ph">Filipino</a></li>
                </ul>
            </li>
        </ul>
    </div>
</footer>

<script src="/js/jquery-3.1.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>