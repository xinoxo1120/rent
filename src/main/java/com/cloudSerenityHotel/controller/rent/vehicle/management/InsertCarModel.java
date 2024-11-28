package com.cloudSerenityHotel.controller.rent.vehicle.management;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.cloudSerenityHotel.bean.rent.CarModelBean;
import com.cloudSerenityHotel.bean.rent.CarModelImage;
import com.cloudSerenityHotel.controller.rent.utils.BaseValidationUtil;
import com.cloudSerenityHotel.controller.rent.utils.ImageShow;
import com.cloudSerenityHotel.dao.rent.impl.CarModelImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rent/car-model/insert")
public class InsertCarModel extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CarModelImpl model = new CarModelImpl();
	ImageShow imageShow = new ImageShow();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carInsert(request, response);
	}

	protected void carInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String carModel = BaseValidationUtil.checkValueIfNullFillDefault(request, "carModel");
		String description = BaseValidationUtil.checkValueIfNullFillDefault(request, "description");
		String brand = BaseValidationUtil.checkValueIfNullFillDefault(request, "brand");
		BigDecimal fuelEfficiency = new BigDecimal(
				BaseValidationUtil.checkValueIfNullFillDefault(request, "fuelEfficiency", BigDecimal.class));
		int seatingCapacity = Integer
				.parseInt(BaseValidationUtil.checkValueIfNullFillDefault(request, "seatingCapacity", int.class));
		String carType = BaseValidationUtil.checkValueIfNullFillDefault(request, "carType");
		String carSize = BaseValidationUtil.checkValueIfNullFillDefault(request, "carSize");

		CarModelBean car = new CarModelBean();

		car.setCarModel(carModel);
		car.setDescription(description);
		car.setBrand(brand);
		car.setFuelEfficiency(fuelEfficiency);
		car.setSeatingCapacity(seatingCapacity);
		car.setCarType(carType);
		car.setCarSize(carSize);
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		car.setCreatedAt(timestamp);
		car.setUpdatedAt(timestamp);

		model.insertCarModel(car);
		List<CarModelBean> cars = model.getAllCarModel();
		List<CarModelImage> cars2 = new ArrayList<CarModelImage>();
		for (CarModelBean carModelBean : cars) {
			CarModelImage carModelBean2 = new CarModelImage();
			carModelBean2.setCarId(carModelBean.getCarId());
			carModelBean2.setCarModel(carModelBean.getCarModel());
			carModelBean2.setBrand(carModelBean.getBrand());
			carModelBean2.setImage(imageShow.showImageOne(carModelBean.getCarId()));
			cars2.add(carModelBean2);
		}

		request.setAttribute("cars", cars2);

		request.getRequestDispatcher("/static/rent/jsp/getCarModelAll.jsp").forward(request, response);
	}

}
