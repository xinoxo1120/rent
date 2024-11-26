<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css"
	integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />



<link rel="stylesheet"
	href="/CloudSerenityHotel/static/rent/css/getCarOne.css">
<title>雲澄飯店租車系統</title>

</head>

<body>

	<nav id="sidebar">

		<img src="/CloudSerenityHotel/static/rent/cloud.png" alt="Logo"
			class="sidebar-img">

		<div class="scrollbar">
			<ul>
				<li><a href="/CloudSerenityHotel/static/rent/html/home.html"><i class="fa-solid fa-house"></i><span>首頁</span></a></li>
				<li><a href="/CloudSerenityHotel/rent/car-model/query-all"><i
						class="fa-solid fa-car-side"></i><span>車型管理</span></a></li>
				<li><i class="fa-solid fa-car"></i><span>車輛管理</span></li>
				<li><i class="fa-solid fa-box-archive"></i><span>訂單紀錄</span></li>
			</ul>
		</div>
	</nav>

	<article>

		<div class="image-container">
			<img src="/1-gogoro-2.jpg" alt="描述圖片" class="image">
		</div>
		<h3>${carModel}</h3>

		<div class="car-description">
			<h4>車型介紹</h4>
			<p>${description}</p>

		</div>

		<div class="button-container">
			<i class="fa-solid fa-pen-to-square edit-btn"
				onclick="updateById(${carId})"></i> <i
				class="fa-solid fa-trash delete-btn" onclick="deleteById(${carId})"></i>
		</div>

		<div class="footer-info-wrapper">
			<div class="footer-info-block">
				<h4>編號</h4>
				<p>${carId}</p>
			</div>
			<div class="footer-info-block">
				<h4>品牌</h4>
				<p>${brand}</p>
			</div>
			<div class="footer-info-block">
				<h4>油耗</h4>
				<p>${fuelEfficiency}km/L</p>
			</div>
			<div class="footer-info-block">
				<h4>類型</h4>
				<p>${carType}</p>
			</div>
			<div class="footer-info-block">
				<h4>尺寸</h4>
				<p>${carSize}</p>
			</div>
			<div class="footer-info-block">
				<h4>人數</h4>
				<p>${seatingCapacity}</p>
			</div>
			<div class="footer-info-block">
				<h4>創建時間</h4>
				<p>${createdAt}</p>
			</div>
			<div class="footer-info-block">
				<h4>更新時間</h4>
				<p>${updatedAt}</p>
			</div>
		</div>

	</article>


	<script>
			function updateById(carId) {  
       		   window.location.href = "/CloudSerenityHotel/rent/car-model/go-update-by-id?carId=" + carId;
    		}
			
			function deleteById(carId) {
				 window.location.href = "/CloudSerenityHotel/rent/car-model/go-delete-by-id?carId=" + carId;
			}
	</script>


</body>

</html>