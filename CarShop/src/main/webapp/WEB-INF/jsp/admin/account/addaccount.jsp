<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Add Account</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<form:form action="" method="post" modelAttribute="acc">
					<div class="row">
						<div class="col">
							<label for="email" class="form-label">Firstname:</label>
							<form:input path="firstname" cssClass="form-control" />
							<form:errors path="firstname" id="errAdmin"></form:errors>
						</div>
						<div class="col">
							<label for="email" class="form-label">Lastname:</label>
							<form:input path="lastname" cssClass="form-control" />
							<form:errors path="lastname" id="errAdmin"></form:errors>
						</div>
					</div>
					<div class="mb-3 mt-3">
						<label for="email" class="form-label">Phone:</label>
						<form:input path="phone" cssClass="form-control" />
						<form:errors path="phone" id="errAdmin"></form:errors>
					</div>
					<div
						class="d-md-flex justify-content-start align-items-center mb-4 py-2">

						<h6 class="mb-0 me-4">Gender:</h6>
						<br>
						<div class="form-check form-check-inline mb-0 me-4">
							<form:radiobutton path="sex" value="0" name="inlineRadioOptions"
								id="femaleGender" checked="true" />
							<label class="form-check-label" for="femaleGender">Female</label>
						</div>

						<div class="form-check form-check-inline mb-0 me-4">
							<form:radiobutton path="sex" value="1" name="inlineRadioOptions"
								id="femaleGender" />
							<label class="form-check-label" for="maleGender">Male</label>
						</div>

						<div class="form-check form-check-inline mb-0">
							<form:radiobutton path="sex" value="2" name="inlineRadioOptions"
								id="femaleGender" />
							<label class="form-check-label" for="otherGender">Other</label>
						</div>

					</div>
					<div
						class="d-md-flex justify-content-start align-items-center mb-4 py-2">

						<h6 class="mb-0 me-4">Roles:</h6>
						<br>
						<div class="form-check form-check-inline mb-0 me-4">
							<form:radiobutton path="accountID.roles" value="ROLE_USER" name="inlineRadioOptions"
								id="femaleGender" checked="true" />
							<label class="form-check-label" for="femaleGender">USER</label>
						</div>

						<div class="form-check form-check-inline mb-0 me-4">
							<form:radiobutton path="accountID.roles" value="ROLE_POST" name="inlineRadioOptions"
								id="femaleGender" />
							<label class="form-check-label" for="maleGender">POST</label>
						</div>

						<div class="form-check form-check-inline mb-0">
							<form:radiobutton path="accountID.roles" value="ROLE_STAFF" name="inlineRadioOptions"
								id="femaleGender" />
							<label class="form-check-label" for="otherGender">STAFF</label>
						</div>

					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Email:</label>
						<form:input path="accountID.email" cssClass="form-control" />
						<form:errors path="accountID.email" id="errAdmin"></form:errors>
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Username:</label>
						<form:input path="accountID.username" cssClass="form-control" />
						<form:errors path="accountID.username" id="errAdmin"></form:errors>
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Password:</label>
						<form:password path="accountID.password" cssClass="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Add</button>
				</form:form>
			</div>
		</div>
	</div>

	<!--//container-fluid-->
</div>
<!--//app-content-->