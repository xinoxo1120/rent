package com.cloudSerenityHotel.bean.rent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagesBean {

	private int imageId;
	private int carId;
	private int isPrimary;
	private String imageUrl;
	
	
}
