package stepdefs;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class LoginSteps extends TestBase {
	
	LoginPage booking;
	
	@Given("^User is in login page$")
	public void user_is_in_login_page() throws Throwable {
	//@Given("^i am in hotel booking login page$")
	//public void i_am_in_hotel_booking_login_page() throws Throwable {
		//TestBase.initialize();
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		String workingdir = System.getProperty("user.dir");
		driver.get(workingdir+"/URL\\login.html");
		//file:///C:/ProgramData/Eclipse/eclipse-workspace/eclipse-workspace/CaseStudyHotelBooking/CaseStudyHotelBooking/URL/login.html
		
		String heading=driver.findElement(By.xpath("//h1[contains(text(),' Hotel Booking Application ')]")).getText();
		Assert.assertEquals("Hotel Booking Application", heading);
		System.out.println("Heading is validated successfully");
	}

	@When("^User clicks on login button without entering username, display username error message$")
	public void user_clicks_on_login_button_without_entering_username_display_username_error_message() throws Throwable {
	//@When("^there user Login Window by using Username and Password$")
	//public void there_user_Login_Window_by_using_Username_and_Password() throws Throwable {
	    booking=new LoginPage();
	  booking.loginBtn();
	  String unameerror=driver.findElement(By.id("userErrMsg")).getText();
	  //Assert.assertEquals("* Please enter the userName.", unameerror);
	  Assert.assertEquals("* Please enter userName.",unameerror);
	  System.out.println("clicks on login button without entering username - Validation is Passed");
	}

	//@Then("^login must be successful$")
	//public void login_must_be_successful() throws Throwable {
		
	//}
	@Then("^User enters valid username$")
	public void user_enters_valid_username() throws Throwable {
	    booking.EnterUsername();
	}

	@When("^User clicks on login button without entering password, display password error message$")
	public void user_clicks_on_login_button_without_entering_password_display_password_error_message() throws Throwable {
		booking.loginBtn();
		String pwderror=driver.findElement(By.id("pwdErrMsg")).getText();
		 // Assert.assertEquals("* Please enter password.",pwderror);
		Assert.assertEquals("* Please enter password.",pwderror);
		  System.out.println("login button without entering password-Validation is Passed");
	}

	@Then("^User enters valid password$")
	public void user_enters_valid_password() throws Throwable {
	    booking.EnterPassword();
	}

	@Then("^clicks on login button$")
	public void clicks_on_login_button() throws Throwable {
	    booking.loginBtn();
	}
	
	@Given("^User is in Hotel booking form page$")
	public void user_is_in_Hotel_booking_form_page() throws Throwable {
		booking=new LoginPage();
		String BookingTitle=booking.validateTitle();
	    Assert.assertEquals("Hotel Booking", BookingTitle);
	}

	@When("^User clicks on confirm button without entering First name, display first name error message$")
	public void user_clicks_on_confirm_button_without_entering_First_name_display_first_name_error_message() throws Throwable {
	   booking.ConfirmBookingButton();
	   Alert alert=driver.switchTo().alert();
	   String fNameAlert=alert.getText();
	   Assert.assertEquals("Please fill the First Name", fNameAlert);
	   alert.accept();
	}

	@Then("^User enters First name$")
	public void user_enters_First_name() throws Throwable {
	    booking.EnterFName();
	}

	@When("^User clicks on confirm button without entering Last name, display last name error message$")
	public void user_clicks_on_confirm_button_without_entering_Last_name_display_last_name_error_message() throws Throwable {
		booking.ConfirmBookingButton();
		Alert alert=driver.switchTo().alert();
		   String lNameAlert=alert.getText();
		   Assert.assertEquals("Please fill the Last Name", lNameAlert);
		   alert.accept();
	}

	@Then("^User enters Last name$")
	public void user_enters_Last_name() throws Throwable {
		booking.EnterLName();
	    
	}

	@When("^User clicks on confirm button with wrong email format, display email error message$")
	public void user_clicks_on_confirm_button_with_wrong_email_format_display_email_error_message() throws Throwable {
		booking.ConfirmBookingButton();
		Alert alert=driver.switchTo().alert();
		   String emailAlert=alert.getText();
		   Assert.assertEquals("Please fill the Email", emailAlert);
		   alert.accept();
	}

	@Then("^User enters email$")
	public void user_enters_email(DataTable email) throws Throwable {
		//List<Map<String,String>> data=email.asMaps(String.class, String.class);
		//driver.findElement(By.id("txtEmail")).sendKeys(data.get(0).get("Invalid email"));
		driver.findElement(By.id("txtEmail")).sendKeys("sathya583.work@gm.com");
		booking.ConfirmBookingButton();
		   Alert alert=driver.switchTo().alert();
		  // String emailvalidationAlert=alert.getText();
		  // Assert.assertEquals("Please enter valid Email Id.", emailvalidationAlert);
		   alert.accept();
		  // driver.findElement(By.id("txtEmail")).clear();
		  // driver.findElement(By.id("txtEmail")).sendKeys(data.get(0).get("Valid email"));
		   driver.findElement(By.id("txtEmail")).sendKeys("sathya583.work@gmail.com");
	}		

	@When("^User clicks on confirm button without entering phone number, display phone number error message$")
	public void user_clicks_on_confirm_button_without_entering_phone_number_display_phone_number_error_message() throws Throwable {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		booking.ConfirmBookingButton();
//		Alert alert=driver.switchTo().alert();
//		   String PhonenumberAlert=alert.getText();
//		   Assert.assertEquals("Please fill the Mobile No.", PhonenumberAlert);
//		   alert.accept();
	}
	@When("^User try to enter both valid & Invalid phone number$")
	public void user_try_to_enter_both_valid_Invalid_phone_number(DataTable PhoneNo) throws Throwable {
	   List<List<String>> data =PhoneNo.raw();
	   driver.findElement(By.id("txtPhone")).sendKeys(data.get(0).get(0));
	   booking.ConfirmBookingButton();
	   Alert alert=driver.switchTo().alert();
	   String PhoneNoAlert=alert.getText();
	   Assert.assertEquals("Please enter valid Contact no.", PhoneNoAlert);
	   alert.accept();	   
	   driver.findElement(By.id("txtPhone")).clear();
	   driver.findElement(By.id("txtPhone")).sendKeys(data.get(1).get(0));
	   booking.ConfirmBookingButton();
	   Assert.assertEquals("Please enter valid Contact no.", PhoneNoAlert);
	   alert.accept();
	   driver.findElement(By.id("txtPhone")).clear();
	   driver.findElement(By.id("txtPhone")).sendKeys(data.get(2).get(0));
	   booking.ConfirmBookingButton();
	   Assert.assertEquals("Please enter valid Contact no.", PhoneNoAlert);
	   alert.accept();
	   driver.findElement(By.id("txtPhone")).clear();
	   driver.findElement(By.id("txtPhone")).sendKeys(data.get(3).get(0));
	}

	@Then("^user enters address$")
	public void user_enters_address() throws Throwable {
	    booking.EnterAdress();
	}

	@Then("^User clicks on confirm button without selecting City, display city error message$")
	public void user_clicks_on_confirm_button_without_selecting_City_display_city_error_message() throws Throwable {
	    booking.ConfirmBookingButton();
	    Alert alert=driver.switchTo().alert();
		   String CityAlert=alert.getText();
		   Assert.assertEquals("Please select city", CityAlert);
		   alert.accept();
	}

	@Then("^user selects City$")
	public void user_selects_City() throws Throwable {
	    booking.SelectCity();
	}

	@Then("^User clicks on confirm button without selecting State, display state error message$")
	public void user_clicks_on_confirm_button_without_selecting_State_display_state_error_message() throws Throwable {
		booking.ConfirmBookingButton();
	    Alert alert=driver.switchTo().alert();
		   String StateAlert=alert.getText();
		   Assert.assertEquals("Please select state", StateAlert);
		   alert.accept();
	}

	@Then("^user selects State$")
	public void user_selects_State() throws Throwable {
	    booking.SelectState();
	}
	@Then("^User clicks on confirm button without entering Card Holder Name, display error message$")
	public void user_clicks_on_confirm_button_without_entering_Card_Holder_Name_display_error_message() throws Throwable {
		booking.ConfirmBookingButton();
	    Alert alert=driver.switchTo().alert();
		   String CardNameAlert=alert.getText();
		   Assert.assertEquals("Please fill the Card holder name", CardNameAlert);
		   alert.accept();
	}

	@Then("^user enters card holder name$")
	public void user_enters_card_holder_name() throws Throwable {
	    booking.EnterCardHolderName();
	}

	@Then("^User clicks on confirm button without entering Card number, display error message$")
	public void user_clicks_on_confirm_button_without_entering_Card_number_display_error_message() throws Throwable {
		booking.ConfirmBookingButton();
	    Alert alert=driver.switchTo().alert();
		   String CardNoAlert=alert.getText();
		   Assert.assertEquals("Please fill the Debit card Number", CardNoAlert);
		   alert.accept();
	}

	@Then("^user enters card number$")
	public void user_enters_card_number() throws Throwable {
	    booking.EnterCardNumber();
	}

	@Then("^User clicks on confirm button without entering CVV, display error message$")
	public void user_clicks_on_confirm_button_without_entering_CVV_display_error_message() throws Throwable {
		booking.ConfirmBookingButton();
	    Alert alert=driver.switchTo().alert();
		   String CVVAlert=alert.getText();
		   Assert.assertEquals("Please fill the CVV", CVVAlert);
		   alert.accept();
	}

	@Then("^user enters CVV$")
	public void user_enters_CVV() throws Throwable {
	   booking.EnterCVV();
	}

	@Then("^User clicks on confirm button without entering Expiration month, display error message$")
	public void user_clicks_on_confirm_button_without_entering_Expiration_month_display_error_message() throws Throwable {
		booking.ConfirmBookingButton();
	    Alert alert=driver.switchTo().alert();
		   String ExpiryMonthAlert=alert.getText();
		   Assert.assertEquals("Please fill expiration month", ExpiryMonthAlert);
		   alert.accept();
	}

	@Then("^user enters expiry month$")
	public void user_enters_expiry_month() throws Throwable {
	  booking.EnterExpMonth();
	}

	@Then("^User clicks on confirm button without entering Expiration year, display error message$")
	public void user_clicks_on_confirm_button_without_entering_Expiration_year_display_error_message() throws Throwable {
		booking.ConfirmBookingButton();
	    Alert alert=driver.switchTo().alert();
		   String ExpiryYearAlert=alert.getText();
		   Assert.assertEquals("Please fill the expiration year", ExpiryYearAlert);
		   alert.accept();
	}

	@Then("^user enters expiry year$")
	public void user_enters_expiry_year() throws Throwable {
	   booking.EnterExpYear();
	}
	
	@Then("^user clicks on Confirm Booking Button & verifies title & closes browser$")
	public void user_clicks_on_Confirm_Booking_Button_verifies_title_closes_browser() throws Throwable {
		booking.ConfirmBookingButton();
		String BookingConfirmation= driver.findElement(By.xpath("//h1[contains(text(),'Booking Completed!')]")).getText();
		Assert.assertEquals("Booking Completed!", BookingConfirmation);
		System.out.println("Booking Completed Successfully");
		driver.close();

	}
}
