<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Add Brand Car</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<form:form action="" method="post" modelAttribute="brandcar">
					<div class="mb-3 mt-3">
						<label for="email" class="form-label">Company Name:</label>
						<form:input path="companyName" cssClass="form-control" />
						<form:errors path="companyName" id="errAdmin"></form:errors>
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Brand Name:</label>
						<form:input path="brandName" cssClass="form-control" />
						<form:errors path="brandName" id="errAdmin"></form:errors>
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Country:</label>
						<form:input path="country" cssClass="form-control" />
						<form:errors path="country" id="errAdmin"></form:errors>
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Home Page:</label>
						<form:input path="homePage" cssClass="form-control" />
						<form:errors path="homePage" id="errAdmin"></form:errors>
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Phone:</label>
						<form:input path="phone" cssClass="form-control" />
						<form:errors path="phone" id="errAdmin"></form:errors>
					</div>
					<button type="submit" class="btn btn-primary">Add</button>
				</form:form>
			</div>
		</div>
	</div>

	<!--//container-fluid-->
</div>
<!--//app-content-->