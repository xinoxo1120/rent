<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/CloudSerenityHotel/static/rent/css/CarModelOne.css">
    <link rel="stylesheet" href="../car_models/js/model.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.0/css/all.min.css"
        integrity="sha512-9xKTRVabjVeZmc+GUW8GgSmcREDunMM+Dt/GrzchfN8tkwHizc5RP4Ok/MXFFy5rIjJjzhndFScTceq5e6GvVQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>雲澄租車系統</title>
</head>

<body>
    <nav>
        車型管理
    </nav>
    <div class="content">
        <div class="container">
            <div class="photo-container">
            </div>
            <div class="button-container">
                <button><i class="fa-solid fa-pen-to-square"></i></button>
                <button><i class="fa-solid fa-trash"></i></button>
            </div>
            <div class="car-info">
                <div>
                    <p class="car-model-title">車型</p>
                    <p class="car-model-name">${goCarOne.carModel}</p>
                    <i class="fa-solid fa-car-side"></i>

                </div>
            </div>

            <div>
                <table id="recordTable">
                    <thead>
                        <tr>
                            <th>訂單編號</th>
                            <th>車型</th>
                            <th>顧客姓名</th>
                            <th>租借日期</th>

                        </tr>
                    </thead>
                    <tbody>
                        <!-- 表格內容將通過 JavaScript 動態插入 -->
                    </tbody>
                </table>
            </div>


            <div>
                <canvas id="myChart"></canvas>
            </div>
            <div class="operate">
                <div class="description-box">
                   ${goCarOne.description}
                </div>
            </div>
            <div class="footer-info-container">
                <div class="footer-info-block">
                    <h3>編號</h3>
                    <p>${goCarOne.carId}</p>
                </div>
                <div class="footer-info-block">
                    <h3>品牌</h3>
                    <p>${goCarOne.brand}</p>
                </div>
                <div class="footer-info-block">
                    <h3>油耗</h3>
                    <p>${goCarOne.fuelEfficiency}</p>
                </div>
                <div class="footer-info-block">
                    <h3>類型</h3>
                    <p>${goCarOne.carType}</p>
                </div>
                <div class="footer-info-block">
                    <h3>尺寸</h3>
                    <p>${goCarOne.carSize}</p>
                </div>
                <div class="footer-info-block">
                    <h3>人數</h3>
                    <p>${goCarOne.seatingCapacity}</p>
                </div>
                <div class="footer-info-block">
                    <h3>創建時間</h3>
                    <p>${goCarOne.createdAt}</p>
                </div>
                <div class="footer-info-block">
                    <h3>更新時間</h3>
                    <p>${goCarOne.updatedAt}</p>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <script>
        const chartElement = document.getElementById('myChart');
        const data = {
            labels: [
                '星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期日',
            ],
            datasets: [{
                label: '本週租借數',
                data: [160, 130, 140, 160, 170, 200, 180],
            }]
        };
        new Chart(chartElement, {
            type: 'line',
            data: data,
        });
    </script>
</body>

</html>