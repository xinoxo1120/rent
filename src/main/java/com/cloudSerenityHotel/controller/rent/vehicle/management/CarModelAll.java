package com.cloudSerenityHotel.controller.rent.vehicle.management;

import java.io.IOException;
import java.util.List;

import com.cloudSerenityHotel.bean.rent.CarModelBean;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CarModelBean> cars = model.getAllCarModel();

		request.setAttribute("cars", cars);
		request.getRequestDispatcher("/static/rent/jsp/modelGetAll.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
