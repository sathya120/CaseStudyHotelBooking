package pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import base.TestBase;

public class LoginPage extends TestBase{	
	
	@FindBy(name="userName") WebElement username;
	@FindBy(name="userPwd") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement loginBtn;
	@FindBy(id="txtFirstName") WebElement FirstName;
	@FindBy(id="txtLastName") WebElement LastName;
	@FindBy(id="txtEmail") WebElement Email;
	@FindBy(id="txtPhone") WebElement PhoneNo;
	@FindBy(xpath="//td/textarea") WebElement address;
	@FindBy(name="city") WebElement City;
	@FindBy(name="state") WebElement State;
	@FindBy(id="txtCardholderName") WebElement CardHolderName;
	@FindBy(id="txtDebit") WebElement CardNumber;
	@FindBy(id="txtCvv") WebElement CVV;
	@FindBy(id="txtMonth") WebElement ExpMonth;
	@FindBy(id="txtYear") WebElement ExpYear;
	@FindBy(id="btnPayment") WebElement ConfirmBookingBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void loginBtn() {
		loginBtn.click();		
	}
	
	public void EnterUsername() {
		//username.sendKeys(prop.getProperty("username"));	
		username.sendKeys("admin");
	}
	
	public void EnterPassword() {
		//password.sendKeys(prop.getProperty("password"));
		password.sendKeys("admin");
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}

	public void ConfirmBookingButton() {
		ConfirmBookingBtn.click();		
	}
	
	public void EnterFName() {
		//FirstName.sendKeys(prop.getProperty("fname"));
		FirstName.sendKeys("Sathya");
	}
		
	public void EnterLName() {
		//LastName.sendKeys(prop.getProperty("lname"));
		LastName.sendKeys("Murthy");
	}
	
	public void EnterAdress(){
		//address.sendKeys(prop.getProperty("address"));
		address.sendKeys("TCS Chennai");
	}
	
	public void SelectCity(){
		Select x =new Select(City);
		x.selectByValue("Bangalore");		
	}
		
	public void SelectState() {
		Select y =new Select(State);
		y.selectByIndex(2);
	}
	public void EnterCardHolderName() {
		//CardHolderName.sendKeys(prop.getProperty("cardName"));	
		CardHolderName.sendKeys("Sathya N");
	}
	public void EnterCardNumber() {
		//CardNumber.sendKeys(prop.getProperty("cardNumber"));
		CardNumber.sendKeys("8765985647893456");
	}
	public void EnterCVV() {
		//CVV.sendKeys(prop.getProperty("cvv"));
		CVV.sendKeys("123");
	}
	public void EnterExpMonth() {
		//ExpMonth.sendKeys(prop.getProperty("expirationMonth"));
		ExpMonth.sendKeys("3");
	}
	public void EnterExpYear() {
		//ExpYear.sendKeys(prop.getProperty("expirationYear"));	
		ExpYear.sendKeys("12");
	}
	
}