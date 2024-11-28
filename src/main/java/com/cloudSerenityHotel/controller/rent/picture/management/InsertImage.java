package com.cloudSerenityHotel.controller.rent.picture.management;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import com.cloudSerenityHotel.bean.rent.ImagesBean;
import com.cloudSerenityHotel.controller.rent.utils.ImageShow;
import com.cloudSerenityHotel.dao.rent.impl.ImagesDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rent/car-model/insert-image")
public class InsertImage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String SAVE_PATH = "C:\\Users\\user\\Desktop\\image\\";

	ImagesDao images = new ImagesDao();
	public static final String DATE_TIME_FORMATTER = "yyyy-MM-dd hh:mm";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ImagesBean imagesBean = new ImagesBean();
		ImageShow imageShow = new ImageShow();
		int carId = Integer.parseInt(request.getParameter("carId"));

		for (int i = 1; i <= 5; i++) {
			String imageStr = request.getParameter("images" + i);
			if (imageStr == null) {
				break;
			}
			int isPrimary;
			if (i == 1) {
				isPrimary = 1;
			} else {
				isPrimary = 0;
			}
			int index = imageStr.indexOf(",") + 1;
			String image = imageStr.substring(index);
			byte[] byteArr = Base64.getDecoder().decode(image);

			String uuid = UUID.randomUUID().toString();
			String imageUrl = SAVE_PATH + uuid;

			try (OutputStream outputStream = new FileOutputStream(new File(imageUrl))) {
				outputStream.write(byteArr);
			}

			imagesBean.setCarId(carId);
			imagesBean.setIsPrimary(isPrimary);
			imagesBean.setImageUrl(imageUrl);

			images.insertImages(imagesBean);
		}


		List<String> images = imageShow.showimageAll(carId);
		request.setAttribute("images", images);

		request.getRequestDispatcher("/rent/car-model/update").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
