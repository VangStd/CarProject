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
								<th>Change Technician</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tech.processBookingServiceCollection }"
								var="item">
								<c:if test="${item.orderService.status.equals('None') }">
									<tr>
										<td class="prova">${item.orderService.bookDate}</td>
										<td class="prova">${item.orderService.orderDate}</td>
										<td class="prova">${item.orderService.note}</td>
										<td class="prova">${item.orderService.customerID.username}</td>
										<td class="prova">${item.orderService.orderServiceDetailCollection[0].serviceID.serviceName}</td>
										<td class="prova">${item.orderService.orderServiceDetailCollection[0].price}</td>
										<td class="prova"><c:if
												test="${LocalDate.parse(item.orderService.orderDate).equals(LocalDate.now()) }">
												<button type="button" class="status__button__changeStatus"
													value="Processing" data-id="${item.orderService.orderID }">Processing</button>
											</c:if> <c:if
												test="${!LocalDate.parse(item.orderService.orderDate).equals(LocalDate.now()) }">
												Wait
											</c:if></td>
										<td>
											<div>
												<select class="request__select__changeTech">
													<c:forEach items="${listTech }" var="itemC">
														<c:if test="${!username.equals(itemC.username) }">
															<option value="${itemC.accountID }">${itemC.username }</option>
														</c:if>
													</c:forEach>
												</select>
												<button class="request__button__changeTech"
													data-id="${item.orderService.orderID}">Send
													request</button>
											</div>
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