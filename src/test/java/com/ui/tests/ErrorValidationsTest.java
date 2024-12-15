package com.ui.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	
	
	@Test
	public void verifyLoginWithInvaliData() {
		
		landingPage.loginWithUserIdPassWord("sudarshankillekar1998@gmail.com","998@Sudarshan98");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorToastMessage());
	}
	
	
	
}
