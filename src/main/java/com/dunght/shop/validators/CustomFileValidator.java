package com.dunght.shop.validators;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dunght.shop.utils.Constants;

@Component
public class CustomFileValidator {
	/**
	 * @param file
	 *            Check type image. The image's type has to map 4 types those
	 *            are jpg, jpeg, png, gif.
	 * @return true if correct else not correct.
	 */
	public boolean checkTypeImage(MultipartFile file) {
		String fileContentType = file.getContentType();
		if (Constants.FileType.contentImageTypes.contains(fileContentType)) {
			return true;
		}
		return false;
	}
}
