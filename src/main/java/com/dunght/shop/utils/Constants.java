package com.dunght.shop.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static class Environment {
		public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
		public static final String SPRING_PROFILE_TEST = "test";
		public static final String SPRING_PROFILE_PRODUCTION = "prod";
	}

	public static class FileType {
		public static final List<String> contentImageTypes = Arrays.asList("image/png", "image/jpeg", "image/jpg",
				"image/gif");
	}
}
