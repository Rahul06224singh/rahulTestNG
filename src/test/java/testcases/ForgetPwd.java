package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;

public class ForgetPwd extends Hook
{
	@Test
	public void forget()
	{
		signin.click();
		help.click();
		forgetpwdlink.click();
		forgettxtbox.sendKeys("aaaaa");
		logger.log(Status.PASS, MarkupHelper.createLabel( " forget pwd  ", ExtentColor.GREEN));

	}

}
