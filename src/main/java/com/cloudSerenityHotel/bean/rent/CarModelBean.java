package com.cloudSerenityHotel.bean.rent;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelBean {

	private int carId; // 編號
	private String carModel; // 車型名稱
	private String description; // 描述
	private String brand; // 品牌
	private BigDecimal fuelEfficiency; // 油耗
	private int seatingCapacity; // 乘載人數
	private int totalVehicles; // 車輛總數
	private int availableVehicles; // 可用數量
	private Timestamp createdAt; // 創建時間
	private Timestamp updatedAt; // 更新時間
	private String carType; // 車輛類型
	private String carSize; // 車型尺寸
}
