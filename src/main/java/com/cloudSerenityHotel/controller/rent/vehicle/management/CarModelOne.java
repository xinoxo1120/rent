package com.cloudSerenityHotel.controller.rent.vehicle.management;

import java.io.IOException;

import com.cloudSerenityHotel.bean.rent.CarModelBean;
import com.cloudSerenityHotel.dao.rent.impl.CarModelImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rent/car-model/car-model-one")
public class CarModelOne extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CarModelImpl model = new CarModelImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int carId = Integer.parseInt(request.getParameter("carId"));
		CarModelBean car = model.CarselectModelOneById(carId);
		request.setAttribute("carId", car.getCarId());
		request.setAttribute("carModel", car.getCarModel());
		request.setAttribute("description", car.getDescription());
		request.setAttribute("brand", car.getBrand());
		request.setAttribute("fuelEfficiency", car.getFuelEfficiency());
		request.setAttribute("seatingCapacity", car.getSeatingCapacity());
		request.setAttribute("totalVehicles", car.getTotalVehicles());
		request.setAttribute("availableVehicles", car.getAvailableVehicles());
		request.setAttribute("createdAt", car.getCreatedAt());
		request.setAttribute("updatedAt", car.getUpdatedAt());
		request.setAttribute("carType", car.getCarType());
		request.setAttribute("carSize", car.getCarSize());
		request.getRequestDispatcher("/static/rent/jsp/CarModelOne.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
