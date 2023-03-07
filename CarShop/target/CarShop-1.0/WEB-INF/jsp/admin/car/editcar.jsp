<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Edit Car</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<form:form action="" method="post" modelAttribute="car"
					enctype="multipart/form-data">
					<form:hidden path="id" />
					<form:hidden path="image" />
					<form:hidden path="dateBuy"/>
					<form:hidden path="carID.carID" />
					<form:hidden path="carID.quantityOnInVoice" />
					${car.dateBuy }
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Product Name:</label>
							<form:input path="carID.productName" cssClass="form-control" />
							<form:errors path="carID.productName" id="errAdmin"></form:errors>
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Feature:</label>
							<form:input path="feature" cssClass="form-control" />
							<form:errors path="feature" id="errAdmin"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Seat:</label>
							<form:input path="carID.seat" cssClass="form-control"
								type="number" />
							<form:errors path="carID.seat" id="errAdmin"></form:errors>
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Color:</label>
							<form:input path="color" cssClass="form-control" />
							<form:errors path="color" id="errAdmin"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="mb-3 col-lg-6">
							<label for="pwd" class="form-label">Type Name:</label>
							<form:select path="carID.typecarid" cssClass="form-control">
								<c:forEach items="${listType }" var="itemType">
									<c:if test="${addTypeCar == itemType.typeName }">
										<option label="${itemType.typeName }"
											value="${itemType.typeID }" selected="selected"></option>
									</c:if>
									<c:if test="${addTypeCar != itemType.typeName }">
										<option label="${itemType.typeName }"
											value="${itemType.typeID }"></option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="mb-3 col-lg-6">
							<label for="pwd" class="form-label">Brand Name:</label>
							<form:select path="carID.brandcarid" cssClass="form-control">
								<c:forEach items="${listBrand }" var="itemBrand">
									<c:if test="${addBrandCar == itemBrand.brandName }">
										<option label="${itemBrand.brandName }"
											value="${itemBrand.brandID }" selected="selected"></option>
									</c:if>
									<c:if test="${addBrandCar != itemBrand.brandName }">
										<option label="${itemBrand.brandName }"
											value="${itemBrand.brandID }"></option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Fuel:</label>
							<form:select path="fuel" cssClass="form-control">
								<c:forEach items="${listFuel }" var="itemFuel">
									<c:if test="${addFuel == itemFuel }">
										<option value="${itemFuel }" selected="selected">${itemFuel }</option>
									</c:if>
									<c:if test="${addFuel != itemFuel }">
										<option value="${itemFuel }">${itemFuel }</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Tranmission:</label>
							<form:select path="tranmission" cssClass="form-control">
								<c:forEach items="${listTranmission }" var="itemTranmission">
									<c:if test="${addTranmission == itemTranmission }">
										<option value="${itemTranmission }" selected="selected">${itemTranmission }</option>
									</c:if>
									<c:if test="${addTranmission != itemTranmission }">
										<option value="${itemTranmission }">${itemTranmission }</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Price / hour:</label>
							<form:input path="carID.price" cssClass="form-control"
								type="number" required="required" />
							<form:errors path="carID.price" id="errAdmin"></form:errors>
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">License Plates:</label>
							<form:input path="carID.licensePlates" cssClass="form-control" />
							<form:errors path="carID.licensePlates" id="errAdmin"></form:errors>
						</div>
					</div>
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Image:</label> <input
								type="file" name="imgCar" class="form-control">
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Image:</label> <img alt=""
								src="${car.image }" class="img-thumbnail" width="300px">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Upgrade</button>
				</form:form>
			</div>
		</div>
	</div>

	<!--//container-fluid-->
</div>
<!--//app-content-->