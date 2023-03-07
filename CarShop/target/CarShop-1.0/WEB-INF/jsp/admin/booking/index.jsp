<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>TypeCar</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<a href="${pageContext.request.contextPath }/admin/add-typecar"
					class="btn btn-success">Add New TypeCar</a>
			</div>
			<div class="col-lg-12 account" style="padding-top: 20px">
				<div class="table-responsive">
					<table class="tablemanager table">
						<thead>
							<tr>
								<th>Username</th>
								<th>Phone Booking</th>
								<th>Email Booking</th>
								<th>Order Date</th>
								<th>Date Booking</th>
								<th>Service</th>
								<th>Note</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listBooking }" var="item">
								<tr>
									<td class="prova">${item.customerID.username }</td>
									<td class="prova">${item.phoneOnInvoice }</td>
									<td class="prova">${item.emailOnInvoice }</td>
									<td class="prova">${item.orderDate }</td>
									<td class="prova">${item.bookDate }</td>
									<td class="prova">${item.orderServiceDetailCollection[0].serviceID.serviceName }</td>
									<td class="prova">${item.note }</td>
									<td class="prova">${item.status}</td>
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