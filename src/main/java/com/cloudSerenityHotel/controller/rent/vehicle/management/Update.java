package com.cloudSerenityHotel.controller.rent.vehicle.management;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.cloudSerenityHotel.bean.rent.CarModelBean;
import com.cloudSerenityHotel.controller.rent.utils.ImageShow;
import com.cloudSerenityHotel.dao.rent.impl.CarModelImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rent/car-model/update")
public class Update extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CarModelImpl model = new CarModelImpl();
	ImageShow imageShow = new ImageShow();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int carId = Integer.parseInt(request.getParameter("carId"));
		String description = request.getParameter("description");
		String carSize = request.getParameter("carSize");
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		model.updateModel(description, carSize, timestamp, carId);

		CarModelBean car = model.CarselectModelOneById(carId);

		request.setAttribute("carId", car.getCarId());
		request.setAttribute("carModel", car.getCarModel());
		request.setAttribute("description", car.getDescription());
		request.setAttribute("brand", car.getBrand());
		request.setAttribute("fuelEfficiency", car.getFuelEfficiency());
		request.setAttribute("seatingCapacity", car.getSeatingCapacity());
		request.setAttribute("totalVehicles", car.getTotalVehicles());
		request.setAttribute("availableVehicles", car.getAvailableVehicles());
		request.setAttribute("carType", car.getCarType());
		request.setAttribute("carSize", car.getCarSize());

		Timestamp createdTimestamp = car.getCreatedAt();
		Timestamp updatedTimestamp = car.getUpdatedAt();
		String createdAt = DateTimeFormatter.ofPattern(CarModelOne.DATE_TIME_FORMATTER)
				.format(createdTimestamp.toLocalDateTime());
		String updatedAt = DateTimeFormatter.ofPattern(CarModelOne.DATE_TIME_FORMATTER)
				.format(updatedTimestamp.toLocalDateTime());
		request.setAttribute("createdAt", createdAt);
		request.setAttribute("updatedAt", updatedAt);

		List<String> images = imageShow.showimageAll(carId);
		request.setAttribute("images", images);

		request.getRequestDispatcher("/static/rent/jsp/getCarOne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
