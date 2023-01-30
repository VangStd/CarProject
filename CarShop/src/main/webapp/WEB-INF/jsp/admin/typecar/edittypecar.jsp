<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Edit TypeCar</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<form:form action="" method="post" modelAttribute="typecar">
					<form:hidden path="typeID" />
					<div class="mb-3 mt-3">
						<label for="email" class="form-label">TypeName:</label>
						<form:input path="typeName" cssClass="form-control" />
						<input type="hidden" value="${typecar.typeName}"
							name="typename_temp">
						<form:errors path="typeName" id="errAdmin"></form:errors>
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">TypeDescription:</label>
						<form:input path="typeDescription" cssClass="form-control" />
						<form:errors path="typeDescription" id="errAdmin"></form:errors>
					</div>
					<button type="submit" class="btn btn-primary">Edit</button>
				</form:form>
			</div>
		</div>
	</div>

	<!--//container-fluid-->
</div>
<!--//app-content-->