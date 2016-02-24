package ERP;

//import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

public class Helper
{
  WebDriver driver;
  String firstWindow ;
  String secondWindow;
 
  public void takeScreenShot(String str) throws Exception{
		/*DateFormat df=new SimpleDateFormat("yyyy_MMM_dd hh_mm_ss");
		Date d=new Date();
		String time=df.format(d);
		System.out.println(time);*/
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:\\worksppaceNew\\str.png"));
		//FileUtils.copyFile(f, new File("D:\\Workspace\\"+str+time+".png"));	
  }
  public void chk_loginBtn() throws Exception
  {
	
	  //System.out.println("hello");
     
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div[2]/div[1]/div/button")).isDisplayed();
      // System.out.println(x);
      driver.findElement(By.xpath(".//*[@id='topbar']/div/div[2]/div[1]/div/button")).click();
     // Thread.sleep(1000);
 
  }  
	
  public void chk_Links()
	{
	  
      try {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		  System.out.println("checking links----->");
		  for(int i=0; i<links.size();i++)
		  {
			  if(!links.get(i).getText().equalsIgnoreCase(""))
			  {
			  if(links.get(i).getAttribute("class").equalsIgnoreCase("ui-tabs-anchor"))
			  {
				  System.out.println(links.get(i).getText());
				 // Thread.sleep(2000);
				  links.get(i).click();
			  }
			  }
		  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
           
    }
	
	public void chk_TxtBox_Btns(String linkName)
	{
		System.out.println("checking textbox & buttons------>");
		
		  List<WebElement> elements = driver.findElements(By.tagName("input"));
		  for(int i=0;i<elements.size();i++)
		  {
			  System.out.println(elements.get(i).getAttribute("name"));
			String str = elements.get(i).getAttribute("value");
			if(linkName.equalsIgnoreCase("userLogin"))
			 {
		      if(str.equalsIgnoreCase("demouser") || str.equalsIgnoreCase("Log in"))
		         System.out.println(elements.get(i).getAttribute("name"));
		     }else if(linkName.equalsIgnoreCase("newAccount"))
	           {
	    		if(str.equalsIgnoreCase("") || str.equalsIgnoreCase("Create Account"))
	    		System.out.println(elements.get(i).getAttribute("name"));
	    	   }
	      }
	}
	public void chk_Dropdown()
	{
		System.out.println("checking Dropdowns----->");
		List<WebElement> sel = driver.findElements(By.tagName("select"));
		for(int i=0;i<sel.size();i++)
			System.out.println(sel.get(i).getAttribute("name"));
	}
	
	public void create_NewAct() throws Exception 
	{
		FileInputStream fis = new FileInputStream(".\\data.xls");
		Workbook w = Workbook.getWorkbook(fis);
		Sheet s = w.getSheet("NewAct");
		System.out.println("no of rows : "+s.getRows());
		//driver.findElement(By.xpath(".//*[@id='topbar']/div/div/div[3]/div[1]/div/button")).click();
		//driver.findElement(By.xpath(".//*[@id='ui-id-2']")).click();
		//Thread.sleep(3000);
		 driver.findElement(By.xpath(".//*[@id='topbar']/div/div[2]/div[1]/div/button")).click();
		 System.out.println("clicked on Login");
		// Thread.sleep(2000);
		driver.findElement(By.id("ui-id-2")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='ui-id-2']")).sendKeys("Puram");
		for(int i=0;i<s.getRows();i++)
		{
			driver.findElement(By.xpath(s.getCell(0,i).getContents())).sendKeys(s.getCell(1,i).getContents());
		}
		driver.findElement(By.xpath(".//*[@id='user_header']/ul/li[8]/input")).click();
	}
		
   public void login() throws Exception 
   {
	   
	   driver.findElement(By.xpath(".//*[@id='topbar']/div/div[2]/div[1]/div/button")).click();
	   driver.findElement(By.xpath(".//*[@id='user_login']/ul/li[4]/input")).click();
	   //System.out.println(driver.findElement(By.xpath(".//*[@id='tabsHeader']/div")).getText());
	   driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/k/a/i")).click();
	   
	   System.out.println("clicked on inventory");
	   
	   Thread.sleep(3000);
	  
	   //System.out.println(driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul")).getText());
	   driver.findElement(By.xpath(".//*[@id='path_by_module']/div/div[2]/ul/li[1]/a")).click();
	   Thread.sleep(3000);
	   System.out.println("clicked on item master");
	   
		   
   }
	   
   public void chk_LinksDB() throws Exception
   {
	  List<WebElement> list = driver.findElements(By.tagName("a"));
	   System.out.println(list.size());
	   String arr[] = new String[list.size()];
	   int k=0;
	   for(int j=50;j<list.size();j++)
	   {
		   if(!list.get(j).getText().equalsIgnoreCase("")) 
		   {   
			   arr[k] = list.get(j).getText();
			   System.out.println(arr[k]);
		       k++;
		   }
	   }
	   System.out.println("printing the array---------->>");
	   
	   for(int i=0;i<k;i++)
	   {
		  System.out.println("array Element " +i+ ":"+ arr[i]);
		  driver.findElement(By.linkText(arr[i])).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='header_top_quick_nav']/ul/li[4]/a/i")).click();
		  Thread.sleep(2000); 
	   }
   }
 	public void chk_LinksInv() throws Exception
 	{
 		 driver.findElement(By.xpath(".//*[@id='dashborad_menu']/li[1]/k/a/i")).click();
	     Thread.sleep(2000);
	     List<WebElement> list = driver.findElements(By.tagName("a"));
	     String arr[] = new String[list.size()];
	     int k=0;
	     for(int i=0;i<list.size();i++)
	      {
	         if(!list.get(i).getText().equalsIgnoreCase(""))
	         {
	    	   arr[k] = list.get(i).getText();
	    	   k++;
	         }
	      }
	       for(int j=25;j<k;j++)
	       {
	    	  
	    	   if(!arr[j].equalsIgnoreCase("    On Hand"))
	    	   {
	    		   //System.out.println(arr[j]);
	    	     driver.findElement(By.linkText(arr[j])).click();
			     //Thread.sleep(1000);
			     driver.findElement(By.xpath(".//*[@id='structure']/ul/li[3]/a")).click();
			   //Thread.sleep(1000);
	    	   }
	       }
 	}
 	public void chk_LinksIM()
 	{
 	
   	List<WebElement> str = driver.findElement(By.xpath(".//*[@id='item']")).findElements(By.tagName("a"));
 	String arr[] = new String[str.size()];
 	int k=0;
 	for(int j=0;j<str.size();j++)
 	{
 		if(!str.get(j).getText().equalsIgnoreCase(""))
 		{
 		arr[k]= str.get(j).getText();
 		System.out.println(arr[k]);
 		k++;
 		}
  	}
 
   	for(int i =0;i<k;i++)
    	{
   			if(driver.findElement(By.linkText(arr[i])).getAttribute("class").equalsIgnoreCase("ui-tabs-anchor"))
   		      driver.findElement(By.linkText(arr[i])).click();
   				//System.out.println(driver.findElement(by.)arr[i]);
 	    }
 	}
 	public void chk_Ajax() throws Exception
 	{
 		try {
			driver.findElement(By.xpath(".//*[@id='item_number']")).click();
			System.out.println(driver.findElement(By.xpath(".//*[@id='tabsHeader-1']/ul/li[3]/i")).isDisplayed());
			Thread.sleep(1000);
			// To check special characters other than -,_.
			driver.findElement(By.xpath(".//*[@id='item_number']")).sendKeys("[[");
			driver.switchTo().alert().accept();
			driver.findElement(By.xpath(".//*[@id='item_number']")).clear();
			
			driver.findElement(By.xpath(".//*[@id='item_number']")).sendKeys("ma");
			Thread.sleep(1000);
			String str = driver.findElement(By.xpath("html/body/ul")).getText();
			System.out.println(str);
			String arr[] = str.split("\n");
			System.out.println(arr.length);
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i].equalsIgnoreCase("MAKE_001"))
				{
					driver.findElement(By.xpath(".//*[@id='item_number']")).clear();
					driver.findElement(By.xpath(".//*[@id='item_number']")).sendKeys(arr[i]);
			    }  
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	//	Thread.sleep(1000);
 	}
 	public void save_Item() throws Exception
		{
 		   WebElement dropdown = driver.findElement(By.xpath(".//*[@id='org_id']"));
			Select sel1 = new Select(dropdown);
			sel1.selectByVisibleText("MAS");
			
			driver.findElement(By.xpath(".//*[@id='item_id']")).click();
			driver.findElement(By.xpath(".//*[@id='tabsHeader-1']/ul/li[2]/i")).click();
			window_Handler();
			driver.findElement(By.xpath(".//*[@id='search_submit_btn']")).click();
			driver.findElement(By.xpath(".//*[@id='tabsLine-0']/table/tbody/tr[2]/td[2]/a")).click();
			driver.switchTo().window(firstWindow);
			driver.findElement(By.xpath(".//*[@id='item_description']")).clear();
			driver.findElement(By.xpath(".//*[@id='item_description']")).sendKeys("Gulo TV ---->>Appended");
			
			WebElement d = driver.findElement(By.id("item_type"));
			Select sel2 = new Select(d);
			sel2.selectByVisibleText("Equipment");
			
			Select sel3 = new Select(driver.findElement(By.id("uom_id")));
			sel3.selectByVisibleText("HR");
			
			Select sel4 = new Select(driver.findElement(By.id("item_status")));
			sel4.selectByVisibleText("Active");
			
			driver.findElement(By.name("product_line_percentage[]")).sendKeys("80%");
			
			driver.findElement(By.xpath("html/body/div[3]/div[3]/div[2]/div/form/div[2]/div/ul/li[5]/a")).click();
			
			new Select(driver.findElement(By.id("make_buy"))).selectByVisibleText("BUY");
			
			driver.findElement(By.xpath(".//*[@id='save']")).click();
		}
 	public void window_Handler() throws Exception
 	{
 		Set<String> windows = driver.getWindowHandles();
 		System.out.println(windows.size());
 		Iterator<String> it = windows.iterator();
 		System.out.println(firstWindow = it.next());
 
 		if(windows.size()>1)
 		{
 			secondWindow =it.next();
 			driver.switchTo().window(secondWindow);
 		}
 		else
 		{
 			driver.switchTo().window(firstWindow);
 		}
 	}
  @BeforeTest
  public void beforeTest()
  {
	  driver = new FirefoxDriver();
	  driver.get("http://inoerp.org/extensions/user/user_login.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	//  driver.quit();
  }

}
