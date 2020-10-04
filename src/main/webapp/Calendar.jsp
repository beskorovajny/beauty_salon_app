<%--
  Created by IntelliJ IDEA.
  User: besko
  Date: 10/4/2020
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout title="Events">
    <ol class="breadcrumb">
        <li><a href="/java-calendar-demo/Calendars?selected-user=${selectedUser}">All Calendars</a></li>
        <li class="active">Current Calendar</li>
    </ol>
    <div class="panel panel-default">
        <div class="panel-heading">Date Range</div>
        <div class="panel-body">
            <form class="form-inline">
                <input type="hidden" name="selectedUser" value="${selectedUser}">
                <input type="hidden" name="calId" value="${calId}">
                <div class="form-group">
                    <label >Start</label>
                    <input type="date" name="start" class="form-control" value="${start}">
                </div>
                <div class="form-group">
                    <label >End</label>
                    <input type="date" name="end" class="form-control" value="${end}">
                </div>
                <button type="submit" class="btn btn-default">Update View</button>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">Events</div>
        <table class="table">
            <tr>
                <th>Subject</th>
                <th>Start</th>
                <th>End</th>
                <th>Location</th>
                <th></th>
            </tr>
            <c:if test="${not empty events}">
                <c:forEach var="event" items="${events}">
                    <tr>
                        <td><a href="/java-calendar-demo/EventDetail?selectedUser=${selectedUser}&eventId=${event.getId()}">${event.getSubject()}</a></td>
                        <td>${event.getStart().getDateTime()} (${event.getStart().getTimeZone()})</td>
                        <td>${event.getEnd().getDateTime()} (${event.getEnd().getTimeZone()})</td>
                        <td>${event.getLocation().getDisplayName()}</td>
                        <td>
                            <form class="form-inline" method="post">
                                <input type="hidden" name="event-op" value="delete">
                                <input type="hidden" name="selected-user" value="${selectedUser}">
                                <input type="hidden" name="calId" value="${calId}">
                                <input type="hidden" name="start" value="${start}">
                                <input type="hidden" name="end" value="${end}">
                                <input type="hidden" name="event-id" value="${event.getId()}">
                                <button type="submit" class="btn btn-default">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</t:layout>