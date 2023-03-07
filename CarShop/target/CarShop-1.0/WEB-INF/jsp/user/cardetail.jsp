<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Page Header Start -->
<div class="container-fluid page-header mb-5 p-0"
	style="background-image: url(img/carousel-bg-2.jpg);">
	<div class="container-fluid page-header-inner py-5">
		<div class="container text-center">
			<h1 class="display-3 text-white mb-3 animated slideInDown">Car</h1>
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb justify-content-center text-uppercase">
					<li class="breadcrumb-item"><a href="#">Home</a></li>
					<li class="breadcrumb-item"><a href="#">Pages</a></li>
					<li class="breadcrumb-item text-white active" aria-current="page">CAR</li>
				</ol>
			</nav>
		</div>
	</div>
</div>
<!-- Page Header End -->
<img src="${car.imageCarCollection[0].image1 }" width="100px" class="img-thumbnail" />
<img src="${car.imageCarCollection[0].image2 }" width="100px" class="img-thumbnail" />
<img src="${car.imageCarCollection[0].image3 }" width="100px" class="img-thumbnail" />
<img src="${car.imageCarCollection[0].image4 }" width="100px" class="img-thumbnail" />
<img src="${car.imageCarCollection[0].image5 }" width="100px" class="img-thumbnail" />
<!-- Service Start -->
<div class="container-xxl service py-5">
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<table>
					<tr>
						<td>CarName -</td>
						<td>${car.productName}</td>
					</tr>
					<tr>
						<td>TypeCar -</td>
						<td>${car.typeID.typeName}</td>
					</tr>
					<tr>
						<td>Branch -</td>
						<td>${car.brandID.brandName}</td>
					</tr>
				</table>
			</div>
			<div class="col-lg-6">
				<div id="demo" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1"></li>
						<li data-target="#demo" data-slide-to="2"></li>
					</ul>
					<!-- The slideshow -->
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="${car.imageCarCollection[0].image1}" alt="Los Angeles">
						</div>
						<div class="carousel-item">
							<img src="${car.imageCarCollection[0].image2}" alt="Los Angeles">
						</div>
						<div class="carousel-item">
							<img src="${car.imageCarCollection[0].image3}" alt="Los Angeles">
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="carousel-control-prev" href="#demo" data-slide="prev">
						<span class="carousel-control-prev-icon"></span>
					</a> <a class="carousel-control-next" href="#demo" data-slide="next">
						<span class="carousel-control-next-icon"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Service End -->

