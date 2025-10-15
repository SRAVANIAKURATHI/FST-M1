package Examples;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class FirstTest {
AppiumDriver driver;
WebDriverWait wait;

@BeforeClass
public void setUp() throws MalformedURLException, URISyntaxException
{
	File apkFile=new File("src/test/resources/Calculator.apk");
	UiAutomator2Options caps=new UiAutomator2Options();
	caps.setPlatformName("android");
	caps.setAutomationName("UiAutomator2");
	caps.setApp(apkFile.getAbsolutePath());
	
	caps.noReset();
	URL serverUrl=new URI("http://localhost:4723").toURL();
	driver=new AndroidDriver(serverUrl, caps);
}

@Test
public void testMethod() {
	
}

@AfterClass
public void tearDown() {
	driver.quit();
}
}
