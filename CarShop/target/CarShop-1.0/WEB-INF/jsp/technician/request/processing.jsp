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
								<th>ServiceName</th>
								<th>Price</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tech.processBookingServiceCollection }"
								var="item">
								<c:if test="${item.orderService.status.equals('Processing') }">
									<tr>
										<td class="prova">${item.orderService.bookDate}</td>
										<td class="prova">${item.orderService.orderDate}</td>
										<td class="prova">${item.orderService.note}</td>
										<td class="prova">${item.orderService.customerID.username}</td>
										<td class="prova">${item.orderService.orderServiceDetailCollection[0].serviceID.serviceName}</td>
										<td class="prova">${item.orderService.orderServiceDetailCollection[0].price}</td>
										<td class="prova">
											<button type="button" class="status__button__changeStatus"
												value="Completed" data-id="${item.orderService.orderID }">Completed</button>
										</td>
									</tr>
								</c:if>

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