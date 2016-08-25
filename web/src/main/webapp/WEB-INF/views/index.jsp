<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main title="Log-In/Sign-up">-->
<!doctype html>
<html lang="en">
<head>
	<title>Log-In/Sign-up</title>
	<link rel="stylesheet" href="/webapp/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/webapp/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/webapp/css/custom.css"/>
</head>
<body>
    <form class="form-control">
        <div>
            <label for="username">UserName</label>
            <input id="username" placeholder="Username"/>
            <label for="password">Password</label>
            <input id="password" placeholder="Password"/>
            <button type="submit">Submit</button>
        </div>
    </form>
    <script src="/webapp/js/jquery-3.1.0.min.js"></script>
	<script src="/webapp/js/bootstrap.min.js"></script>
</body>
<!-- </t:main> -->