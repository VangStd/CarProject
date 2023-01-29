<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Edit Account</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<form:form action="" method="post" modelAttribute="accEdit">
					<form:hidden path="accountID" />
					<form:hidden path="password" />
					<form:hidden path="status" />
					<div class="row">
						<div class="col">
							<label for="email" class="form-label">Firstname:</label> <input
								type="text" value="${accEdit.accountConfigCollection[0].firstname }"
								class="form-control" readonly="true" />
						</div>
						<div class="col">
							<label for="email" class="form-label">Lastname:</label> <input
								type="text" value="${accEdit.accountConfigCollection[0].lastname }"
								class="form-control" readonly="true" />
						</div>
					</div>
					<div class="mb-3 mt-3">
						<label for="email" class="form-label">Phone:</label> <input
							type="text" value="${accEdit.accountConfigCollection[0].phone }"
							class="form-control" readonly="true" />
					</div>
					<div
						class="d-md-flex justify-content-start align-items-center mb-4 py-2">

						<h6 class="mb-0 me-4">Roles:</h6>
						<br>
						<form:select path="roles">
							<c:forEach items="${listRoles }" var="item">
								<c:choose>
									<c:when test="${item.contains(accEdit.roles)==true }">
										<form:option value="${item }" checked="true">${item }</form:option>
									</c:when>
									<c:when test="${item.contains(accEdit.roles)==false }">
										<form:option value="${item }">${item }</form:option>
									</c:when>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Email:</label>
						<form:input path="email" cssClass="form-control" readonly="true" />
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Username:</label>
						<form:input path="username" cssClass="form-control"
							readonly="true" />
					</div>
					<div class="mb-3">
						<label for="pwd" class="form-label">Password:</label>
						<form:password path="confirmpass" cssClass="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Upgrade</button>
				</form:form>
			</div>
		</div>
	</div>

	<!--//container-fluid-->
</div>
<!--//app-content-->