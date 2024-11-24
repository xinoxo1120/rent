<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*,com.cloudSerenityHotel.bean.rent.CarModelBean"%>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>雲澄飯店租車系統</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/CloudSerenityHotel/static/rent/overview/css/styles.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="/CloudSerenityHotel/static/rent/overview/css/revise.css">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css"
	integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
	<jsp:useBean id="car" scope="request"
		class="com.cloudSerenityHotel.bean.rent.CarModelBean" />
	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<nav class="display-4 fw-bolder">租車系統</nav>
				<p class="lead fw-normal text-white-50 mb-0"></p>
			</div>
		</div>
	</header>
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->

								<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
								<c:forEach var="car" items="${cars}">
									<h5 class="fw-bolder">${car.carModel}</h5>
									<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
										<div class="text-center">
											<button class="fas fa-pen-to-square"
												onclick="update(${car.carId})"></button>
											<button class="fa-solid fa-trash"
												onclick="deleteEmp(${car.carId})"></button>
										</div>
									</div>
								</c:forEach>


							</div>
						</div>
						<!-- Product actions-->

					</div>
					<div class="button-container">
						<button class="fas fa-plus" onclick="insert()"></button>
					</div>
				</div>
				<!-- Sale badge-->
				<!-- <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale
                        </div> -->

				<!-- Footer-->
				<footer class="py-5 bg-dark">
					<div class="container">
						<p class="m-0 text-center text-white">Copyright &copy; Cloud
							Serenity Hotel</p>
					</div>
				</footer>
				<!-- Bootstrap core JS-->
				<script
					src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
				<!-- Core theme JS-->
				<script src="js/scripts.js">
				
				</script>
				<script>
				function update(carId) {
				    
					  window.location.href = "/CloudSerenityHotel/rent/car-model/go-update-by-id?carId=" + carId;
				 }
				 
				 function deleteEmp(carId) {
				     
				     window.location.href = "/CloudSerenityHotel/rent/car-model/go-delete-by-id?carId=" + carId;
				 }
				 
				 function insert() {
				     
				     window.location.href = "/CloudSerenityHotel/static/rent/html/insertCarModel.html";
				 }
				</script>
</body>

</html>