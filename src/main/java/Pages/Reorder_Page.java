package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SRSproject.SRSproject.BasePage;

public class Reorder_Page extends BasePage {

	WebDriverWait wait;
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//a[@class='action upload-csv']") WebElement Uploadcsv;
	@FindBy(xpath="//input[@id='file-upload']") WebElement File;
	@FindBy(xpath="//span[text()='Upload File']") WebElement Uploadfile_btn;
	
	@FindBy(xpath="//div[@class='field product-part']") List<WebElement> LineItem_PartNo;
	
//	@FindBy(xpath="//div[@class='pad-title']")  WebElement Reorder_Name;
	@FindBy(xpath="//input[@class='input-text editable-title reorder-pad-name active']") WebElement Reorder_Name; 
	@FindBy(xpath="(//button[@title='Save & Close'])[1]") WebElement Save_btn;
	
	@FindBy(xpath="//div[@id='swal2-content']") WebElement Notification;
	@FindBy(xpath="//button[@class='swal2-close']") WebElement close_btn;
	@FindBy(xpath="//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/a[1]") WebElement CreateNew_Pad;
	
	@FindBy(xpath="(//input[@id='id-items0sku'])[1]") WebElement Product_input;
	
	@FindBy(xpath="(//div[@class='action'])[1]") WebElement First_List_View;
	
	@FindBy(xpath="(//button[@title='Add All Items To Cart'])[1]") WebElement Add_All_Items_btn;
	
	@FindBy(xpath = "//div[contains(text(),'Items have been successfully added to your Cart')]") WebElement Success_msg;
	
	@FindBy(css = "body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-header > button") WebElement Pop_close;
	@FindBy(css ="body > div.modals-wrapper > aside.modal-popup.message-modal-container._show > div.modal-inner-wrap > header > button") WebElement close;
	
	
	public Reorder_Page(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public MyAccountPage Fileupload() throws InterruptedException
	
{
		
	
		 Thread.sleep(5000);
		 Uploadcsv.click();
		Thread.sleep(3000);
		
		File.sendKeys(prop.getProperty("valid_csvfile"));

		
		
		Thread.sleep(3000);
		
		Uploadfile_btn.click();
		return new MyAccountPage(driver);
	
}
	
	public MyAccountPage Invalid_Fileupload() throws InterruptedException
	
	{
			
		
			 Thread.sleep(5000);
			 Uploadcsv.click();
			Thread.sleep(3000);
			
			File.sendKeys(prop.getProperty("Invalid_csvfile"));

			
			
			Thread.sleep(3000);
			
			Uploadfile_btn.click();
			return new MyAccountPage(driver);
		
	}
	
	public ArrayList<String> GetLineItme() throws InterruptedException
	
{
		 
		 
		List<WebElement> list1= LineItem_PartNo;
		ArrayList<String> a1= new ArrayList<String>();
		for (WebElement option:list1)
		{
			String text= option.getText();
			
			a1.add(text);
			
		}
		return a1;
}
	
public  WebElement ReorderNameField() 
	
	{
	
  return Reorder_Name;
	}

	
	public  WebElement Save_button() 
	
	{
		return Save_btn;
	}
	
public String  ItemsNotAdded_Notification() 
	
	{
		return Notification.getText();
	}

public  void close_button_click() 

{
close_btn.click();
}

public  WebElement Create_New_ReorderPad() 

{
	return CreateNew_Pad;
}

public  void EnterProduct() throws InterruptedException 

{
	 Product_input.sendKeys(prop.getProperty("KeywordSearch"));

		Thread.sleep(5000);
		WebElement Item=driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[1]/div[2]/form/div[4]/fieldset/div[2]/div/ul[1]/li[1]/a"));
		 WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.visibilityOf(Item));
			Item.click();
		Thread.sleep(1000);
	
}

public  void View_Click() 

{
	First_List_View.click();
}

public  WebElement Add_All_Items() 

{
	return Add_All_Items_btn;
}

public  String Items_addtocart_msg() throws InterruptedException 

{
	
	return Success_msg.getText();
	
}

public  WebElement PopUp_Closebutton() 

{
	return Pop_close;
}

public  WebElement Closebutton() 

{
	return close;
}

	
	

}
