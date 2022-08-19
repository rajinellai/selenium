package org.geo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Studentdetails {
	
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://gelogics.in/");
	driver.manage().window().maximize();
	
	//login.sendKeys("catvmc14");

	//pwd.sendKeys("Tvmc@123");
	
File f = new File("C:\\Users\\torav\\MavenExample\\ExcelSheets\\username and pwd.xlsx");
FileInputStream fi = new FileInputStream(f);
Workbook wb = new XSSFWorkbook(fi);
Sheet sheet = wb.getSheet("userid");

int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	
	
	 int col_num = -1;
	 
        for(int i=1; i <=rowcount; i++)
        {
        	 Row row = sheet.getRow(i);
        	 for (int j = 0; j < row.getLastCellNum(); j++) {
        		 Cell cell = row.getCell(j);
        		 cell.setCellType(cell.CELL_TYPE_STRING);
        		 System.out.println(cell.getStringCellValue());
			}
 
        	System.out.println();
        }
       
        WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary fadeIn third']"));
    	submit.click();
    	
    	driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
    	driver.findElement(By.xpath("//a[text()='Courses']")).click();
    	driver.findElement(By.xpath("//a[text()='MBBS']")).click();
    	driver.findElement(By.xpath("//button[@class='btn btn-primary mb-2']")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
    	driver.findElement(By.xpath("(//div[@class='modal-content'])[3]"));
    	driver.findElement(By.id("add_name")).sendKeys("raji");
    		

}
	
}


