package com.cloudSerenityHotel.controller.rent.vehicle.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cloudSerenityHotel.bean.rent.CarModelBean;
import com.cloudSerenityHotel.bean.rent.CarModelImage;
import com.cloudSerenityHotel.controller.rent.utils.ImageShow;
import com.cloudSerenityHotel.dao.rent.impl.CarModelImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rent/car-model/query-all")
public class CarModelAll extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CarModelImpl model = new CarModelImpl();
	ImageShow imageShow = new ImageShow();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
