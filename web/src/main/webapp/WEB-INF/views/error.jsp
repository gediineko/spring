<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:main title="Error">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 col-xs-6 col-xs-offset-3">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <div class="text-center">
                        <i class="fa fa-times-circle fa-10x"></i>
                    </div>
                    <p class="text-center"><strong>${message}</strong></p>
                </div>
                <div class="panel-body">
                    <a href="#" onclick="window.history.back()">
                        <i class="fa fa-arrow-circle-left"></i> <spring:message code="message.previousPage" text="Go back to the last page"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</t:main>