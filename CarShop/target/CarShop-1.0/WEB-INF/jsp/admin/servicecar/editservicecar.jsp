<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Edit Service Car</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<form:form action="" method="post" modelAttribute="servicecar">
					<form:hidden path="serviceID" />
					<input type="hidden" name="oldNameService" value="${servicecar.serviceName }" />
					<div class="mb-3 mt-3">
						<label for="email" class="form-label">Service Name:</label>
						<form:input path="serviceName" cssClass="form-control" />
						<form:errors path="serviceName" id="errAdmin"></form:errors>
					</div>
					<div class="mb-3 mt-3">
						<label for="email" class="form-label">Service Price:</label>
						<form:input path="price" cssClass="form-control" type="number"
							min="1" />
						<form:errors path="price" id="errAdmin"></form:errors>
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Service Description:</label>
						<form:input path="serviceDescription" cssClass="form-control" />
						<form:errors path="serviceDescription" id="errAdmin"></form:errors>
					</div>
					<button type="submit" class="btn btn-primary">Upgrade</button>
				</form:form>
			</div>
		</div>
	</div>

	<!--//container-fluid-->
</div>
<!--//app-content-->