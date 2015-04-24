package com.kangdainfo.common.view.test;

import com.kangdainfo.common.util.Common;

public class TestEncode {

	public static void main(String[] args) {
		
		//String pwd = "kds123";
		//pwd = "張宇華KDS123";
		//System.out.println(Common.getDigestString(pwd, "SHA-1"));
		
		System.out.println(Common.getRandomPassword(10));
		System.out.println(Common.getRandomDigit(0,8));

	}

}
