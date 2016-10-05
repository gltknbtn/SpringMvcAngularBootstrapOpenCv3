<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row-fluid">
    <div class="jumbotron">
        <h1><spring:message code='project.exception'/></h1>

        <p class="lead">status: ${status}</p>
        <p class="lead">reason: ${reason}</p>
        <p class="lead">exception: ${exception}</p>
    </div>
</div>