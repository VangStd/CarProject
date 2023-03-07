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
								<th>Type Name</th>
								<th>Type Decription</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listTypeCar }" var="item">
								<tr>

									<td class="prova">${item.typeName }</td>
									<td class="prova">${item.typeDescription }</td>
									<td><a
										href="${pageContext.request.contextPath }/admin/edit-typecar/${item.typeID}"
										class="btn btn-primary">Edit</a></td>
									<td>
										<button type="button" class="typecar__button__deleteTypeCar btn btn-danger"
											data-id="${item.typeID}">Delete</button>
									</td>
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