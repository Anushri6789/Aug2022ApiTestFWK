package com.test.helpers;

import com.test.constants.Endpoints;
import com.test.models.LoginObjectPOJO;
import com.test.utils.Utils;

public class ReusableMethods {
	
	public static String getBaseUri() {
		String baseURI= Utils.getConfigProperty(getBaseUri());
		return baseURI;
	}
	
 }

