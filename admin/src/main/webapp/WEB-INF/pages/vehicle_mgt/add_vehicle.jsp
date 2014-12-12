<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper_basic>

    <jsp:attribute name="page_body">

        <div class="container">

            <form:form  class="form-horizontal" commandName="vehicle" role="form" action="add" method="post">

                <div class="form-group">
                    <label for="input-name" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="input-name" path="name" placeholder="Name"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-details" class="col-sm-2 control-label">Details</label>
                    <div class="col-sm-10">
                        <form:textarea class="form-control" id="input-details" path="details" placeholder="Details" rows="3"></form:textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input-vehicle-group" class="col-sm-2 control-label">Group</label>
                    <div class="col-sm-10">
                        <form:select class="form-control" id="input-vehicle-group" path="vehicleGroupId">
                            <c:forEach items="${vehicleGroups}" var="grp" varStatus="status">
                                <option value="${grp.id}">${grp.name}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary btn-default">Add</button>
                    </div>
                </div>

            </form:form>

        </div> <!-- /container -->

    </jsp:attribute>

</t:wrapper_basic>