<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除車型資料</title>
</head>
<body>
<form action="/CloudSerenityHotel/rent/car-model/update" method="post" id="Update-form">
    <div class="center">
        <h2><input type="text" disabled  name="carModel" value="${carModel}"></h2>
        <input type="hidden" name="carModel" value="${carModel}"/></td>
        <div class="cen">
            <table class="bordered-table">
                <tr>
                    <th>編號</th>
                    <td><td><input type="text" disabled  name="carId" value="${carId}"></td>
                    <input type="hidden" name="carId" value="${carId}"/></td>
                </tr>
                <tr>
                    <th>品牌</th>
                    <td><input type="text" disabled  name="brand" value="${brand}"></td>
                     <input type="hidden" name="brand" value="${brand}"/></td>
                </tr>
                <tr>
                    <th>油耗</th>
                    <td><input type="text" disabled  name="fuelEfficiency" value="${fuelEfficiency}"></td>
                 <input type="hidden" name="fuelEfficiency" value="${fuelEfficiency}"/></td>
                </tr>
                <tr>
                    <th>乘載人數</th>
                    <td><input type="text" disabled  name="seatingCapacity" value="${seatingCapacity}"></td>
                 <input type="hidden" name="seatingCapacity" value="${seatingCapacity}"/></td>
                </tr>
                <tr>
                    <th>車輛總數</th>
                    <td><input type="text" disabled  name="totalVehicles" value="${totalVehicles}"></td>
                 <input type="hidden" name="totalVehicles" value="${totalVehicles}"/></td>
                </tr>
                <tr>
                    <th>可用數量</th>
                    <td><input type="text" disabled  name="availableVehicles" value="${availableVehicles}"></td>
                 <input type="hidden" name="availableVehicles" value="${availableVehicles}"/></td>
                </tr>
                <tr>
                    <th>車輛尺寸</th>
                    <td><input type="text" disabled  name="carSize" value="${carSize}"></td>
                 <input type="hidden" name="carSize" value="${carSize}"/></td>
                </tr>
                <tr>
                    <th>車輛類型</th>
                    <td><input type="text"   name="carType" value="${carType}"></td>
                </tr>
                 <tr>
                    <th>車型介紹</th>
                    <td><textarea  name="description" rows="4" cols="50">${description}</textarea> 
                </tr>
                
                <input type="hidden" name="updatedAt" value="${updatedAt}"/></td>
            </table>

        </div>
        <div class="container">
           <!-- <button>修改</button> -->
             <input type="submit" value="提交修改">
        </div>
    </div>
   </form>
</html>