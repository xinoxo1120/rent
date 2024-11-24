<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/CloudSerenityHotel/static/rent/css/revise.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css"
	integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>雲澄租車系統</title>
</head>

<body>

	<form method="post"
		action="/CloudSerenityHotel/rent/car-model/query-all">
		<h1 class="page-title  move-right">車型管理</h1>
		<table>
			<tbody>
				<!-- 車型名稱、品牌、油耗量等欄位 -->
				<tr>

					<td><label for="model">車型名稱</label></td>
					<td>${insertCar.carModel}</td>

					<td><label for="brand">品牌</label></td>
					<td>${insertCar.brand}</td>

					<td><label for="fuelEfficiency">油耗量</label></td>
					<td>${insertCar.fuelEfficiency}</td>
				</tr>

				<!-- 車輛尺寸、車輛類型、乘車人數等欄位 -->
				<tr>
					<td><label for="carSize">車輛尺寸</label></td>
					<td>${insertCar.carSize}</td>

					<td><label for="carType">車輛類型</label></td>
					<td>${insertCar.carType}</td>

					<td><label for="seatingCapacity">乘車人數</label></td>
					<td>${insertCar.seatingCapacity}</td>
				</tr>
				<tr>
					<td><label for="description">車輛描述</label></td>
					<td>${insertCar.description}</td>
				</tr>

			</tbody>
		</table>


		<button type="submit">確認</button>

	</form>
</body>