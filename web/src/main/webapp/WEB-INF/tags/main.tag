<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">
                    Home
                </a>
            </div>


        </div>
    </nav>

    <div class="container" id="main-container">
        <jsp:doBody/>
    </div>

    <script src="/js/jquery-3.1.0.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</body>