package com.cloudSerenityHotel.controller.rent.vehicle.management;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.cloudSerenityHotel.bean.rent.CarModelBean;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int carId = Integer.parseInt(request.getParameter("carId"));
		String description = request.getParameter("description");
		String carSize = request.getParameter("carSize");
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Timestamp timestamp = Timestamp.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		model.updateModel(description, carSize, timestamp, carId);

		CarModelBean goCarOne = model.CarselectModelOneById(carId);

		request.setAttribute("goCarOne", goCarOne);
		request.getRequestDispatcher("/static/rent/jsp/CarModelOne.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
