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
				<a href="${pageContext.request.contextPath }/admin/add-brandcar"
					class="btn btn-success">Add New Brand Car</a>
			</div>
			<div class="col-lg-12 account" style="padding-top: 20px">
				<div class="table-responsive">
					<table class="tablemanager table">
						<thead>
							<tr>
								<th>Company Name</th>
								<th>Brand Name</th>
								<th>Country</th>
								<th>Home Page</th>
								<th>Phone</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listBrandCar }" var="item">
								<tr>

									<td class="prova">${item.companyName }</td>
									<td class="prova">${item.brandName }</td>
									<td class="prova">${item.country }</td>
									<td class="prova">${item.homePage }</td>
									<td class="prova">${item.phone }</td>
									<td><a
										href="${pageContext.request.contextPath }/admin/edit-brandcar/${item.brandID}">Edit</a></td>
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