package com.cloudSerenityHotel.controller.rent.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.cloudSerenityHotel.bean.rent.ImagesBean;
import com.cloudSerenityHotel.dao.rent.impl.ImagesDao;

public class ImageShow {

	ImagesDao imagesDao = new ImagesDao();

	public List<String> showimageAll(int carId) {

		List<String> list = new ArrayList<>();

		List<ImagesBean> imageAll = imagesDao.imageAll(carId);

		for (int i = 0; i < imageAll.size(); i++) {
			ImagesBean imagesBean = imageAll.get(i);
			String imageUrl = imagesBean.getImageUrl();
			File image = new File(imageUrl);
			byte[] imageByte = new byte[(int) image.length()];
			try (FileInputStream fileInputStream = new FileInputStream(image);) {
				fileInputStream.read(imageByte);
				list.add(Base64.getEncoder().encodeToString(imageByte));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;
	}


	public String showImageOne(int carId) {
		String imageUrl = imagesDao.imageOne(carId);
		if (imageUrl != null) {
			File image = new File(imageUrl);
			byte[] imageByte = new byte[(int) image.length()];
			try (FileInputStream fileInputStream = new FileInputStream(image);) {
				fileInputStream.read(imageByte);
				return Base64.getEncoder().encodeToString(imageByte);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "";
	}
}
