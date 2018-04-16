package com.dunght.shop.cloudinary;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.Transformation;

/**
 * @author DungHo
 *
 */
@Component
public class CloudinaryConfig {
	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryConfig(@Value("${cloudinary.apikey}") String key, @Value("${cloudinary.apisecret}") String secret,
			@Value("${cloudinary.cloudname}") String cloud) {
		cloudinary = Singleton.getCloudinary();
		cloudinary.config.cloudName = cloud;
		cloudinary.config.apiSecret = secret;
		cloudinary.config.apiKey = key;
	}

	/**
	 * @param file
	 * @param options
	 * @return upload an image to cloud and return path that image on clould.
	 * @throws Exception
	 */
	public Map<?, ?> upload(Object file, Map<?, ?> options) throws Exception {
		return cloudinary.uploader().upload(file, options);
	}

	public String createUrl(String name, int width, int height, String action) throws Exception {
		return cloudinary.url()
				.transformation(new Transformation().width(width).height(height).border("2px_solid_black").crop(action))
				.imageTag(name);
	}

	/**
	 * @param publicId
	 * @param options that is publicId of image on cloud
	 * @Action Remove that image on cloud
	 * @throws Exception
	 */
	public void destroy(String publicId, Map<?, ?> options) throws Exception {
		 cloudinary.uploader().destroy(publicId, options);
	}
}
