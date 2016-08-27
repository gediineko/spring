<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                    <sec:authorize access="hasRole('ADMIN')">
                        href="/admin"
                    </sec:authorize>
                    <sec:authorize access="hasRole('USER')">
                        href="/profile"
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        href="/"
                    </sec:authorize>
            >
                Gedii
            </a>
        </div>
        <sec:authorize access="isAuthenticated()">
            <ul class="nav navbar-nav">
                <sec:authorize access="hasRole('ADMIN')">
                    <li
                            <c:if test="${fn:startsWith(requestScope.get('javax.servlet.forward.request_uri'), '/admin/person') }">
                                class="active"
                            </c:if>
                    >
                        <a href="/user/dashboard">Person Management</a>
                    </li>

                    <li
                            <c:if test="${fn:startsWith(requestScope.get('javax.servlet.forward.request_uri'), '/admin/role')}">
                                class="active"
                            </c:if>
                    >
                        <a href="/admin/dashboard">Role Management</a>
                    </li>

                    <li
                            <c:if test="${fn.startsWith(requestScope.get('javax.servlet.forward.request_uri'), '/logout')}">
                                class="active pull-right"
                            </c:if>
                    >
                        <a href="/logout">Log out</a>
                    </li>
                </sec:authorize>
            </ul>
        </sec:authorize>
    </div>
</nav>

<div class="container" id="main-container">
    <jsp:doBody/>
</div>

<script src="/js/jquery-3.1.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>