package com.dunght.shop.utils;

import org.springframework.stereotype.Component;

/**
 * @author DungHo
 *
 */
@Component
public class Utils {
	
	/**
	 * @param linkImage
	 * That mean of the function is get publicId from link image avatar on cloudinary
	 * @return publicId 
	 *
	 */
	public String getPublicIdImageCloudinary(String linkImage) {
		String publicIdImage;
		String getNameImage = linkImage;
		String getImage = getNameImage.substring(getNameImage.lastIndexOf("/") + 1);
		publicIdImage = getImage.substring(0, getImage.indexOf("."));

		return publicIdImage;
	}
}
