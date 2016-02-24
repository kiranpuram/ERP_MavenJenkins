package ERP;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Inventory extends Helper
{
  @Test(enabled = true)
  public void test01() throws Exception 
  {
	  chk_loginBtn();
  }
  @Test(enabled = true)
  public void test02() 
  {
	  chk_Links();
  }
  @Test(enabled = true)
  public void test03() 
  {
	  String str = "userLogin";
	  chk_TxtBox_Btns(str);
  }
  @Test(enabled = true)
  public void test04() 
  {
	  chk_Dropdown();
  }
  @Test(enabled = false)
  public void test05() throws Exception 
  {
	  String str = "newAccount";
	  chk_TxtBox_Btns(str);
  }
  @Test(enabled = false)
  public void test06() throws Exception
  {
	  create_NewAct();
  }
  @Test(enabled = true)
  public void test07() throws Exception
  {
	  login();
  }
  @Test(enabled = true)
  public void test08() throws Exception
  {
	 chk_LinksDB();
  }
  @Test(enabled = false)
  public void test09() throws Exception
  {
	 chk_LinksInv();
  }
  @Test(enabled = false)
  public void test10() throws Exception
  {
	  chk_LinksIM();
  }
  @Test(enabled = false)
  public void test11() throws Exception
  {
	  chk_Ajax();
  }
  @Test(enabled = false)
  public void test12() throws Exception
  {
	  save_Item();
  }
  @Test(enabled = false)
  public void test13() throws Exception
  {
	  driver.findElement(By.xpath(".//*[@id='topbar']/div/div[2]/div[1]/div/button")).click();
	  window_Handler();
	  System.out.println("in Inventory" + driver.getWindowHandle());
  }
  @Test(enabled = true)
  public void test14() throws Exception
  {
	  String str = "pic";
	  takeScreenShot(str);
  }
}
