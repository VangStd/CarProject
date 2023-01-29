<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="<c:url value="/resources/css/signuppage.css"/>"
	rel="stylesheet" />
<section class="h-100 bg-dark">
	<div class="container py-5 h-100">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<div class="col">
				<div class="card card-registration my-4">
					<div class="row g-0">
						<div class="col-xl-6 d-none d-xl-block">
							<img
								src="https://toperp.vn/web/image/22644-1151a7f6/phan-mem-quan-ly-o-to.png"
								alt="Sample photo" class="img-fluid"
								style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
						</div>
						<div class="col-xl-6">
							<form:form action="${pageContext.request.contextPath }/signup"
								method="post" modelAttribute="acc">
								<div class="card-body p-md-5 text-black">
									<h3 class="mb-5 text-uppercase">Student registration form</h3>
									<div class="row">
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<form:input path="firstname"
													class="form-control form-control-lg" />
												<label class="form-label" for="form3Example1m">First
													name</label>
											</div>
											<span> <form:errors path="firstname" id="errForm"></form:errors>
											</span>
										</div>
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<form:input path="lastname"
													class="form-control form-control-lg" />
												<label class="form-label" for="form3Example1n">Last
													name</label>
											</div>
											<span> <form:errors path="lastname" id="errForm"></form:errors>
											</span>
										</div>
									</div>
									<div class="form-outline mb-4">
										<form:input path="address"
											class="form-control form-control-lg" />
										<label class="form-label" for="form3Example8">Address</label>
									</div>

									<div
										class="d-md-flex justify-content-start align-items-center mb-4 py-2">

										<h6 class="mb-0 me-4">Gender:</h6>

										<div class="form-check form-check-inline mb-0 me-4">
											<form:radiobutton path="sex" value="0"
												name="inlineRadioOptions" id="femaleGender" />
											<label class="form-check-label" for="femaleGender">Female</label>
										</div>

										<div class="form-check form-check-inline mb-0 me-4">
											<form:radiobutton path="sex" value="1"
												name="inlineRadioOptions" id="femaleGender" />
											<label class="form-check-label" for="maleGender">Male</label>
										</div>

										<div class="form-check form-check-inline mb-0">
											<form:radiobutton path="sex" value="2"
												name="inlineRadioOptions" id="femaleGender" />
											<label class="form-check-label" for="otherGender">Other</label>
										</div>

									</div>

									<div class="form-outline mb-4">
										<form:input path="phone" class="form-control form-control-lg" />
										<label class="form-label" for="form3Example90">Phone</label><br/> <span>
											<form:errors path="phone" id="errForm"></form:errors>
										</span>
									</div>
									<div class="form-outline mb-4">
										<form:input path="accountID.email"
											class="form-control form-control-lg" />
										<label class="form-label" for="form3Example97">Email
											ID</label><br/> <span> <form:errors path="accountID.email"
												id="errForm"></form:errors>
										</span>
									</div>

									<div class="form-outline mb-4">
										<form:input path="accountID.username"
											class="form-control form-control-lg" />
										<label class="form-label" for="form3Example97">User
											name</label><br/> <span> <form:errors path="accountID.username"
												id="errForm"></form:errors>
										</span>
									</div>
									<div class="row">
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<form:password path="accountID.password"
													class="form-control form-control-lg" />
												<label class="form-label" for="form3Example1m">Password</label>
											</div>
											<span> <form:errors path="accountID.password"
													id="errForm"></form:errors>
											</span>
										</div>
										<div class="col-md-6 mb-4">
											<div class="form-outline">
												<form:password path="accountID.confirmpass"
													class="form-control form-control-lg" />
												<label class="form-label" for="form3Example1n">Confirm
													Password</label>
											</div>
											<span> <form:errors path="accountID.confirmpass"
													id="errForm"></form:errors>
											</span>
										</div>
									</div>

									<div class="d-flex justify-content-end pt-3">
										<button type="submit" class="btn btn-warning btn-lg ms-2">SignUp</button>
									</div>

								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>