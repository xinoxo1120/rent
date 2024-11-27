package com.cloudSerenityHotel.controller.rent.picture.management;

import java.io.IOException;
import java.util.List;

import com.cloudSerenityHotel.bean.rent.ImagesBean;
import com.cloudSerenityHotel.dao.rent.impl.ImagesDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rent/car-model/images-all")
public class GetImageAll extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ImagesDao images = new ImagesDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int carId = Integer.parseInt(request.getParameter("carId"));

		List<ImagesBean> image = images.imageAll(carId);

		request.setAttribute("image", image);
		request.setAttribute("carId", carId);
		request.getRequestDispatcher("/static/rent/images/image.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
