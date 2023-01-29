<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Account</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<a href="${pageContext.request.contextPath }/admin/account-create"
					class="btn btn-success">Add New Account</a>
			</div>
			<div class="col-lg-12 account" style="padding-top: 20px">
				<div class="table-responsive">
					<table class="tablemanager table">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Phone</th>
								<th>Username</th>
								<th>Email</th>
								<th>Role</th>
								<th>Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listAccount }" var="item">
								<tr>
									<td class="prova">${item.accountConfigCollection[0].firstname }</td>
									<td class="prova">${item.accountConfigCollection[0].lastname }</td>
									<td class="prova">${item.accountConfigCollection[0].phone }</td>
									<td class="prova">${item.username }</td>
									<td class="prova">${item.email }</td>
									<td class="prova">${item.roles }</td>
									<td><c:if test="${item.roles.contains('ADMIN') == true}">
											<button type="button" class="btn btn-danger">None</button>
										</c:if> <c:if test="${item.roles.contains('ADMIN') == false}">
											<c:if test="${item.status == 0 }">
												<button type="button"
													class="account__button--changeStatus btn btn-success"
													data-id="${item.accountID }">Disable</button>
											</c:if>
											<c:if test="${item.status == 1 }">
												<button type="button"
													class="account__button--changeStatus btn btn-warning"
													data-id="${item.accountID }">Enable</button>
											</c:if>
										</c:if></td>
									<td class="prova"><a
										href="${pageContext.request.contextPath }/admin/account-edit?id=${item.accountID}"
										class="btn btn-primary">Edit</a></td>
									<td class="prova"><c:if test="${item.status == 0 }">
											<button class="account__button_deleteAccount btn btn-danger"
												data-id="${item.accountID}">Delete</button>
										</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/tableManager.js"/>"></script>
	<script src="<c:url value="/resources/tablePag.js"/>"></script>
	<!--//container-fluid-->
</div>
<!--//app-content-->