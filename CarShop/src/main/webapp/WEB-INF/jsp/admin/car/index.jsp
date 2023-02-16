<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Car</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<a href="${pageContext.request.contextPath }/admin/add-car"
					class="btn btn-success">Add New Car</a>
			</div>
			<div class="col-lg-12 account" style="padding-top: 20px">
				<div class="table-responsive">
					<table class="tablemanager table table-borderless">
						<thead>
							<tr>
								<th>Name</th>
								<th>Type Car</th>
								<th>Brand Car</th>
								<th>Seat</th>
								<th>Image</th>
								<th>Price/hour</th>
								<th>Status</th>
								<th>View More</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listCar }" var="item">
								<tr>

									<td class="prova">${item.productName }</td>
									<td class="prova">${item.typeID.typeName }</td>
									<td class="prova">${item.brandID.brandName }</td>
									<td class="prova">${item.seat }</td>
									<td class="prova"><a href="${pageContext.request.contextPath}/admin/edit-imagecar/${item.carID}"><img
											src="${item.carDetailCollection[0].image }"
											class="img-thumbnail" width="100px" /></a></td>
									<td class="prova">${item.price }$</td>
									<td class="prova"><c:if test="${item.status ==1 }">
									      Available
									</c:if> <c:if test="${item.status != 1 }">
									      Unavailable
									</c:if></td>
									<td class="prova"><button type="button"
											class="car__button__viewmorecar" data-id="${item.carID }">
											<i class='fas fa-eye'></i>
										</button></td>
									<td><a
										href="${pageContext.request.contextPath}/admin/edit-car/${item.carDetailCollection[0].id}"><i
											class='fas fa-edit' style='color: red'></i></a></td>
									<td><button type="button" class="car__button__deleteCar"
											data-id="${item.carDetailCollection[0].id}">
											<i class='fas fa-trash' style='color: red'></i>
										</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div id="myModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="textViewMoreID">Modal Header</h4>
						</div>
						<div class="modal-body">
							<p id="textViewMore"></p>
							<p id="textViewMoreColor"></p>
							<p id="textViewMoreDateBuy"></p>
							<p id="textViewMoreFuel"></p>
							<p id="textViewMoreTranmission"></p>
							<p id="textViewMoreFeature"></p>
						</div>
						<div class="modal-footer"></div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/tableManager.js"/>"></script>
	<script src="<c:url value="/resources/tablePag.js"/>"></script>
	<!--//container-fluid-->
</div>
<!--//app-content-->