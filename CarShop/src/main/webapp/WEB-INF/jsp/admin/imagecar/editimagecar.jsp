<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="app-content pt-3 p-md-3 p-lg-4">
	<div class="container-xl">
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h3>Edit Image Car</h3>
				</center>
			</div>
			<div class="col-lg-12">
				<form:form action="" method="post" modelAttribute="imagecar" enctype="multipart/form-data">
				<form:hidden path="carID.carID"/>
				<form:hidden path="imageDefault"/>
				<form:hidden path="image1"/>
				<form:hidden path="image2"/>
				<form:hidden path="image3"/>
				<form:hidden path="image4"/>
				<form:hidden path="image5"/>
				<form:hidden path="id"/>
					<div class="mb-3 mt-3">
						<label for="email" class="form-label">Car Name:</label> <input
							type="text" value="${imagecar.carID.productName }"
							class="form-control" readonly="readonly">
					</div>
					${imagecar.image1 }
					<img alt="" src="${imagecar.image1 }">
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="" class="form-label">OldImage 1:</label> <img
								alt="" src="${imagecar.image1}" class="img-thumbnail"
								width="200px">
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Feature:</label> <input
								type="file" name="img1" class="form-control">
						</div>
					</div>
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">OldImage 1:</label> <img
								alt="" src="${imagecar.image2}" class="img-thumbnail"
								width="200px">
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Feature:</label> <input
								type="file" name="img2" class="form-control">
						</div>
					</div>
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">OldImage 1:</label> <img
								alt="" src="${imagecar.image3}" class="img-thumbnail"
								width="200px">
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Feature:</label> <input
								type="file" name="img3" class="form-control">
						</div>
					</div>
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">OldImage 1:</label> <img
								alt="" src="${imagecar.image4}" class="img-thumbnail"
								width="200px">
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Feature:</label> <input
								type="file" name="img4" class="form-control">
						</div>
					</div>
					<div class="row">
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">OldImage 1:</label> <img
								alt="" src="${imagecar.image5}" class="img-thumbnail"
								width="200px">
						</div>
						<div class="mb-3 mt-3 col-lg-6">
							<label for="email" class="form-label">Feature:</label> <input
								type="file" name="img5" class="form-control">
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