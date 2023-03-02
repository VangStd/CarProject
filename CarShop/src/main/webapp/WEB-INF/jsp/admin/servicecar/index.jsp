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
				<a href="${pageContext.request.contextPath }/admin/add-servicecar"
					class="btn btn-success">Add New TypeCar</a>
			</div>
			<div class="col-lg-12 account" style="padding-top: 20px">
				<div class="table-responsive">
					<table class="tablemanager table">
						<thead>
							<tr>
								<th>Service Name</th>
								<th>Price</th>
								<th>Service Decription</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listServiceCar }" var="item">
								<tr>

									<td class="prova">${item.serviceName }</td>
									<td class="prova">${item.price }</td>
									<td class="prova">${item.serviceDescription }</td>
									<td><a
										href="${pageContext.request.contextPath }/admin/edit-servicecar/${item.serviceID}"><i
											class='fas fa-edit' style='color: red'></i></a></td>
									<td><button type="button"
											class="servicecar__button__deleteServiceCar"
											data-id="${item.serviceID}">
											<i class='fas fa-trash' style='color: red'></i>
										</button></td>
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