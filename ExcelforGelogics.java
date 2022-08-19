package org.geo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sample.BaseClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.sl.Ce;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelforGelogics extends BaseClass {
//public static void main(String[] args) throws IOException, InterruptedException {

	String ExcelPath ="C:\\Users\\torav\\MavenExample\\ExcelSheets\\Username_pwd.xlsx";
	String sheet_name="userid";
	String sheet_name1="CandidateDetails";
	String sheet_name2="AdmissionDetails";
	@BeforeTest
	public void gelogics() throws InterruptedException, IOException {

		chromeDriver();
		getURL("https://gelogics.in/");
		maximizeBrowser();

		WebElement login = driver.findElement(By.id("login"));
		WebElement pwd = driver.findElement(By.id("typepass"));
		WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-outline-primary fadeIn third']"));

		
				
		String stringCellValue = readfromexcel(ExcelPath,sheet_name,"Username");
		//System.out.println("Value of the cell"+stringCellValue);
		keyvalue(login, stringCellValue);
		Thread.sleep(2000);
		String stringCellValue2 = readfromexcel(ExcelPath,sheet_name,"Password");
		keyvalue(pwd, stringCellValue2);
		Thread.sleep(2000);

		
		submit.click();
		Thread.sleep(2000);
	
	}
	
	@Test(priority=1)
		public void login() throws IOException {
				
		boolean product = driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
		System.out.println("*******Dashboard*******");
		display(product);
		
		
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		boolean courses = driver.findElement(By.xpath("//a[text()='Courses']")).isDisplayed();
		System.out.println("********Courses*******");
		display(courses);
		driver.findElement(By.xpath("//a[text()='Courses']")).click();
		
		
		boolean mbbs = driver.findElement(By.xpath("//a[text()='MBBS']")).isDisplayed();
		System.out.println("*****MBBS******");
		display(mbbs);
		driver.findElement(By.xpath("//a[text()='MBBS']")).click();
		
		System.out.println("********New Student********");
		boolean newstudent = driver.findElement(By.xpath("//button[@class='btn btn-primary mb-2']")).isDisplayed();
		display(newstudent);
		driver.findElement(By.xpath("//button[@class='btn btn-primary mb-2']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
		@Test(priority=2)
	public void student() throws IOException, InterruptedException {
			
		driver.findElement(By.xpath("(//div[@class='modal-content'])[3]"));
		WebElement name = driver.findElement(By.id("add_name"));
		
		WebElement initial = driver.findElement(By.id("add_initial"));
		
		WebElement expansion = driver.findElement(By.id("add_initial_expansion"));
		
		WebElement fathersname = driver.findElement(By.id("add_father_name"));
		Thread.sleep(2000);
		
		WebElement dob = driver.findElement(By.id("add_date_of_birth"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		Thread.sleep(1000);
		WebElement mothersname = driver.findElement(By.id("add_mother_name"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		Select gender = new Select(driver.findElement(By.id("gender")));
		Thread.sleep(1500);
		
		Select nationality = new Select(driver.findElement(By.id("add_nationality")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		Select religion = new Select(driver.findElement(By.id("add_religion")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebElement bloodgroup = driver.findElement(By.id("add_blood_group"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebElement studentcode = driver.findElement(By.id("add_student_code"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebElement caste = driver.findElement(By.id("add_caste"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		
		WebElement academicyear = driver.findElement(By.id("add_academic_year"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		Select willing=new Select(driver.findElement(By.id("add_willing_to_donate_blood")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		Select community =new Select(driver.findElement(By.id("add_community")));
		
		Select vaccihep=new Select(driver.findElement(By.id("hepatitis")));
				
		Select vaccicovid=new Select(driver.findElement(By.id("covid")));
		
		keyvalue(name, readfromexcel(ExcelPath,sheet_name1,"Name"));
		
		
		keyvalue(initial, readfromexcel(ExcelPath,sheet_name1,"Initial"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		keyvalue(expansion, readfromexcel(ExcelPath,sheet_name1,"Expansion of Initial"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		keyvalue(fathersname, readfromexcel(ExcelPath,sheet_name1,"Father's Name"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(dob, readfromexcel(ExcelPath,sheet_name1,"DOB"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(mothersname, readfromexcel(ExcelPath,sheet_name1,"Mother's Name"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		gender.selectByValue(readfromexcel(ExcelPath,sheet_name1,"Gender"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		nationality.selectByValue(readfromexcel(ExcelPath,sheet_name1,"Nationality"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		religion.selectByValue(readfromexcel(ExcelPath,sheet_name1,"Religion"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(bloodgroup, readfromexcel(ExcelPath,sheet_name1,"Blood Group"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(studentcode, readfromexcel(ExcelPath,sheet_name1,"Student Code"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(caste, readfromexcel(ExcelPath,sheet_name1,"Caste"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		keyvalue(academicyear, readfromexcel(ExcelPath,sheet_name1,"Academic Year"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		willing.selectByValue(readfromexcel(ExcelPath,sheet_name1,"Willing to donate blood"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		community.selectByValue(readfromexcel(ExcelPath,sheet_name1,"Community"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		vaccihep.selectByValue(readfromexcel(ExcelPath,sheet_name1,"Are you Vaccinated for Hepatitis B"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		vaccicovid.selectByValue(readfromexcel(ExcelPath,sheet_name1,"Are you Vaccinated for COVID"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement rank = driver.findElement(By.id("add_rank"));
		WebElement arnumber = driver.findElement(By.id("add_ar_no"));
		WebElement totalmark = driver.findElement(By.id("add_total_mark"));
		WebElement neetrollnumber = driver.findElement(By.id("add_neet_roll_no"));
		WebElement ranknumber = driver.findElement(By.id("add_rank_no"));
		WebElement neetmark = driver.findElement(By.id("add_neet_mark"));
		WebElement coursecommencement = driver.findElement(By.id("add_course_commencement"));
		WebElement dateofadmission = driver.findElement(By.id("add_date_of_admission"));
		WebElement dateofallotment = driver.findElement(By.id("add_date_of_allotment"));
		Select category=new Select(driver.findElement(By.id("add_selected_category")));
		Select admissiontype=new Select(driver.findElement(By.id("add_admission_type")));
		WebElement registrationnumber=driver.findElement(By.id("add_reg_no"));
		Select admissionquota=new Select(driver.findElement(By.id("add_admission_quota")));
		Select willingforcounselling=new Select(driver.findElement(By.id("add_willing_for_counciling")));
		
		keyvalue(rank,readfromexcel(ExcelPath,sheet_name2,"rank"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(arnumber,readfromexcel(ExcelPath,sheet_name2,"ArNumber"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(totalmark,readfromexcel(ExcelPath,sheet_name2,"TotalMark"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(neetrollnumber,readfromexcel(ExcelPath,sheet_name2,"NeetRollNumber"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(ranknumber,readfromexcel(ExcelPath,sheet_name2,"RankNumber"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(neetmark,readfromexcel(ExcelPath,sheet_name2,"NeetMark"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		keyvalue(coursecommencement,readfromexcel(ExcelPath,sheet_name2,"CourseCommencement"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		keyvalue(dateofadmission,readfromexcel(ExcelPath,sheet_name2,"Date of Admission"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		keyvalue(dateofallotment,readfromexcel(ExcelPath,sheet_name2,"Date of Allotment"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String admissiondetails9=(readfromexcel(ExcelPath,sheet_name2,"Category"));
		category.selectByValue(admissiondetails9);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		admissiontype.selectByValue(readfromexcel(ExcelPath,sheet_name2,"AdmissionType"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		keyvalue(registrationnumber,readfromexcel(ExcelPath,sheet_name2,"RegistrationNumber"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		admissionquota.selectByValue(readfromexcel(ExcelPath,sheet_name2,"AdmissionQuota"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		willingforcounselling.selectByValue(readfromexcel(ExcelPath,sheet_name2,"WillingforCounselling"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		
    }
		
		
		
//		@AfterTest
//		public void browser() {
//		closeBrowser();
//		
//		
//		}
}
		
				
		
		



