<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.time.LocalDate"%>
<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Request</h3>
				</center>
			</div>
			<div class="col-lg-12 account" style="padding-top: 20px">
				<div class="table-responsive">
					<table class="tablemanager table">
						<thead>
							<tr>
								<th>Booking Date</th>
								<th>Order Date</th>
								<th>Note</th>
								<th>Username</th>
								<th>Email</th>
								<th>ServiceName</th>
								<th>Price</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tech.processBookingServiceCollection }"
								var="item">
								<tr>
									<td class="prova">${item.orderService.bookDate}</td>
									<td class="prova">${item.orderService.orderDate}</td>
									<td class="prova">${item.orderService.note}</td>
									<td class="prova">${item.orderService.customerID.username}</td>
									<td class="prova">${item.orderService.emailOnInvoice}</td>
									<td class="prova">${item.orderService.orderServiceDetailCollection[0].serviceID.serviceName}</td>
									<td class="prova">${item.orderService.orderServiceDetailCollection[0].price}</td>
									<td class="prova">${item.orderService.status}</td>
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