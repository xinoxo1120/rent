package com.cloudSerenityHotel.dao.rent.impl;

import java.sql.Timestamp;
import java.util.List;

import com.cloudSerenityHotel.bean.rent.CarModelBean;

public interface CarModelDao {

	/**
	 * 獲取所有車型
	 * @return 所有車型資料
	 */
	List<CarModelBean> getAllCarModel();
	
	/**
	 * 查詢單筆車型資料
	 * 
	 * @param carModelBean
	 * @return SQL影響的資料表行數
	 */
	
	CarModelBean CarselectModelOneById(int carId);// ..
	
	int insertCarModel(CarModelBean carModel);

	int deleteModelById(int carId);

	int updateModel(String description, String carSize, Timestamp timestamp, int carId);
}
