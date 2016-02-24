package ERP;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DataDrivenScript extends Helper
{
  
@Test
  public void ReadXL_DataDriven() throws Exception
  {
	  String str;
	  FileInputStream fis = new FileInputStream("C:\\workspace\\TestTriangle\\NewdataERP.xls");
	  Workbook wb = Workbook.getWorkbook(fis);
	  Sheet s = wb.getSheet("DataDriven");
	  
	  FileOutputStream fos = new FileOutputStream("C:\\Users\\keveen\\Desktop\\ERPresults\\Results.xls");
	  WritableWorkbook wb1 = Workbook.createWorkbook(fos);
	  WritableSheet s1 = wb1.createSheet("result",0);
	  for(int c=3,r=0;c<s.getColumns();c++,r++)
	  {
	  for(int i=1;i<s.getRows();i++)
		  {
			  try
			  {
			  if(s.getCell(2,i).getContents().equalsIgnoreCase("link"))
			  {
				  driver.findElement(By.linkText(s.getCell(0,i).getContents())).click();
			  }
			  else if((s.getCell(2,i).getContents().equalsIgnoreCase("button")) ||(s.getCell(2,i).getContents().equalsIgnoreCase("radiobutton"))) 
			  {
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
				  window_Handler();
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("dropdown"))
			  {
				  new Select(driver.findElement(By.id(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(c,i).getContents());
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("text"))
			  {
				  driver.findElement(By.name(s.getCell(0,i).getContents())).clear();
				  driver.findElement(By.name(s.getCell(0,i).getContents())).sendKeys(s.getCell(c,i).getContents());
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("wait"))
			  {
				  Thread.sleep(3000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("close"))
			  {
				  driver.close();
				  window_Handler();
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("dropdown_menu"))
			  {
				  WebElement element = driver.findElement(By.xpath(s.getCell(0,i).getContents()));
				  Actions action = new Actions(driver);
				  action.moveToElement(element).build().perform();
				  driver.findElement(By.xpath(".//*[@id='navbar']/ul[1]/li/div/div/ul/li[8]/a")).click();
			  }
			  str = "Pass";
			} catch (Exception e) {
		       str = "Fail";           
		      }
			  Label res = new Label(r,i,str);
			  s1.addCell(res);
		 }
	  }
	  wb1.write();
	  wb1.close();
  }
}
