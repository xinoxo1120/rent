package com.cloudSerenityHotel.dao.rent.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cloudSerenityHotel.bean.rent.ImagesBean;
import com.cloudSerenityHotel.utils.JDBCUtils;

public class ImagesDao {

	/**
	 * 透過carID新增、
	 * 
	 * @param images
	 */
	public void insertImages(ImagesBean images) {
		ImagesBean image = images;

		String sql = """
					INSERT INTO Images (car_id, is_primary, car_image_url)
					VALUES (?, ?, ?)
				""";

		try (Connection conn = JDBCUtils.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, image.getCarId());
			stmt.setInt(2, image.getIsPrimary());
			stmt.setString(3, image.getImageUrl());
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 透過carId、imageId 確認要刪除的照片
	 * 
	 * @param carId
	 * @param imageId
	 */
	public void deleteImages(int carId, int imageId) {
		String sql = """
				DELETE FROM images
				WHERE images = ?,
					  carid = ?
				""";
		try (Connection conn = JDBCUtils.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, carId);
			stmt.setInt(2, imageId);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通過carID修改 並且確認isPrimary 修改為主圖
	 * 
	 * @param images
	 */
	public void updateImages(ImagesBean images) {
		ImagesBean image = images;
		String sql = """
					UPDATE images SET isPrimary = ?
				""";
		try (Connection conn = JDBCUtils.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, image.getIsPrimary());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String imageOne(int carId) {
		String sql = """
					SELECT
						car_image_url as imageUrl
					FROM images
					WHERE car_id = ? AND is_primary = 1
				""";

		String image = null;
		ResultSet rs = null;
		try (Connection conn = JDBCUtils.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, carId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				image = rs.getString("imageUrl");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, null, rs);
		}

		return image;
	}

	// 通過carId尋找所有圖片
	/**
	 * 會在單筆查詢中新增，因此尋找該車型(carId)的圖片
	 * 
	 * @param carId
	 * @return
	 */
	public List<ImagesBean> imageAll(int carId) {
		String sql = """
					SELECT
							image_id as imageId,
							car_id as carId,
							is_primary as isPrimary,
							car_image_url as imageUrl
					FROM images
					WHERE  car_id = ?
				""";
		ArrayList<ImagesBean> images = null;
		try (Connection conn = JDBCUtils.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, carId);
			ResultSet rs = stmt.executeQuery();
			images = new ArrayList<ImagesBean>();
			ImagesBean image = null;
			while (rs.next()) {
				image = new ImagesBean();
				image.setImageId(rs.getInt("imageId"));
				image.setCarId(rs.getInt("carId"));
				image.setIsPrimary(rs.getInt("isPrimary"));
				image.setImageUrl(rs.getString("imageUrl"));
				images.add(image);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return images;
	}

}
