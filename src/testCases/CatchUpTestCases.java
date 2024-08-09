package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import screens.ChatScreen;
import utility.Constant;
import utility.Log;
import utility.ReadPropertyFile;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CatchUpTestCases {
	private static AndroidDriver driver;
	
	static ReadPropertyFile property = PageFactory.initElements(driver, ReadPropertyFile.class);
	 static AppiumDriverLocalService appiumService;

	Log log = new Log();
	
	static String extentReportFile;
	static ExtentReports extent;
	static String extentReportImage;
	static ExtentTest extentTest;
	static String date = Constant.DateTimeFormat();
	 //define an Excel Work Book
	  HSSFWorkbook workbook;
	  //define an Excel Work sheet
	  HSSFSheet sheet;
	  //define a test result data object
	Map<String, Object[]> testresultdata;
	
	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"extentReportFile"+date+"."+"html";
		extentReportImage = property.getExtentReportImg()+"extentReportImage"+date+"."+"png";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("CatchUp");
//		appiumService = AppiumDriverLocalService.buildDefaultService();
//		appiumService.start();
		
		 //Browser Initialization
		 Constant.AppSetting();
		 driver = Constant.getDriver();
		
	}
	 
	@BeforeTest
	public void Before() throws Exception{
//		DOMConfigurator.configure("log4j.xml");
		//create a new work book
		workbook = new HSSFWorkbook();
		//create a new work sheet
		sheet = workbook.createSheet("Catch Up");
		testresultdata = new LinkedHashMap<String, Object[]>();
		//add test result excel file column header
		// write the header in the first row
		testresultdata.put("1", new Object[] {"S.No", "Scenario", "Expected Result","Pass/Fail"});
	}
	
//	@Test
	public void test001_LoginWithRegisteredUser(){
		Log.startTestCase("Login with registered user");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Login with registered user",
				"Verify Login with registered user");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.login(0);
			if(flag == true){
				Constant.log.info("test001_LoginWithRegisteredUser: Login  with registered user test case is successful");
				extentTest.log(LogStatus.PASS, "Login with registered user Successful");
				testresultdata.put("2", new Object[] {1d, "Login", "Login with registered user is successful","Pass"});
			}else{
				System.err.println("test001_LoginWithRegisteredUser: Login with registered user test case failed ");
				Constant.captureScreen_Negative("Login with registered user");
				extentTest.log(LogStatus.FAIL, "Login with registered user failed");
				testresultdata.put("2", new Object[] {1d, "Login with registered user", "Login with registered user failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Login with registered user");
	}
	
	@Test
	public void test002_sendTextMsg_Group(){
		Log.startTestCase("send text message in group");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("send text message in group",
				"Verify if send text message is sent in group chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.sendTextMsg_GroupChat(1);
			if(flag == true){
				Constant.log.info("test002_sendTextMsg_Group: Send text message to group chat is successful");
				extentTest.log(LogStatus.PASS, "sending text message to group chat successful");
				testresultdata.put("3", new Object[] {2d, "send text message in group", "sending text message to group chat successful","Pass"});
			}else{
				System.err.println("test002_sendTextMsg_Group: Send text message to group chat failed");
				Constant.captureScreen_Negative("send text message in group");
				extentTest.log(LogStatus.FAIL, "Send text message to group chat failed");
				testresultdata.put("3", new Object[] {2d, "send text message in group", "Send text message to group chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("send text message in group");
	}
	
	@Test
	public void test003_sendTextMsg_Personal(){
		Log.startTestCase("send text message in Personal");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("send text message in Personal",
				"Verify if send text message is sent in Personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.sendTextMsg_PersonalChat(2);
			if(flag == true){
				Constant.log.info("test003_sendTextMsg_Personal: Send text message to Personal chat is successful");
				extentTest.log(LogStatus.PASS, "sending text message to Personal chat successful");
				testresultdata.put("4", new Object[] {3d, "send text message in Personal chat", "sending text message to Personal chat successful","Pass"});
			}else{
				System.err.println("test003_sendTextMsg_Personal: Send text message to Personal chat failed");
				Constant.captureScreen_Negative("send text message in Personal");
				extentTest.log(LogStatus.FAIL, "Send text message to Personal chat failed");
				testresultdata.put("4", new Object[] {3d, "send text message in Personal", "Send text message to Personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("send text message in Personal");
	}
	
	@Test
	public void test004_sendTextMsg_PersonalContact(){
		Log.startTestCase("send text message to personal chat selecting contact");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("send text message to Personal chat selection contact",
				"Verify if send text message is sent in Personal chat by selecting contact");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.sendTextMsg_PersonalChat_Selectingcontact(3);
			if(flag == true){
				Constant.log.info("test004_sendTextMsg_PersonalContact: Send text message to Personal chat by selecting contact is successful");
				extentTest.log(LogStatus.PASS, "sending text message to Personal chat by selecting contact successful");
				testresultdata.put("5", new Object[] {4d, "send text message to Personal chat selection contact", "sending text message to Personal chat by selecting contact successful","Pass"});
			}else{
				System.err.println("test004_sendTextMsg_PersonalContact: Send text message to Personal chat by selecting contact failed");
				Constant.captureScreen_Negative("send text message in Personal by selecting contact");
				extentTest.log(LogStatus.FAIL, "Send text message to Personal chat by selecting contact failed");
				testresultdata.put("5", new Object[] {4d, "send text message to Personal chat selecting contact", "Send text message to Personal chat by selecting contact failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("send text message in Personal by selecting contact");
	}
	
//	@Test
	public void test005_profileScreenValidation(){
		Log.startTestCase("Profile screen validation");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Profile screen validation",
				"Verify profile screen validation");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.viewContactDetails(4);
			if(flag == true){
				Constant.log.info("test005_profileScreenValidation: Profile screen validation of personal chat is successful");
				extentTest.log(LogStatus.PASS, "Profile screen validation of personal chat is successful");
				testresultdata.put("6", new Object[] {5d, "Profile screen validation", "Profile screen validation of personal chat is successful","Pass"});
			}else{
				System.err.println("test005_profileScreenValidation: Profile screen validation of personal chat failed");
				Constant.captureScreen_Negative("Profile screen validation");
				extentTest.log(LogStatus.FAIL, "Profile screen validation of personal chat failed");
				testresultdata.put("6", new Object[] {5d, "Profile screen validation", "Profile screen validation of personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Profile screen validation");
	}
	
	@Test
	public void test006_sendEmoticonsNText_Personal(){
		Log.startTestCase("Send emoticons and text to Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Send emoticons and text to Personal chat",
				"Verify if able to send emoticons and text to personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.sendEmojiNTextMsg_Personal(5);
			if(flag == true){
				Constant.log.info("test006_sendEmoticonsNText_Personal: Sending emoticons and text to personal chat is successful");
				extentTest.log(LogStatus.PASS, "Sending emoticons and text to personal chat is successful");
				testresultdata.put("7", new Object[] {6d, "Send emoticons and text to Personal chat", "Sending emoticons and text to personal chat is successful","Pass"});
			}else{
				System.err.println("test006_sendEmoticonsNText_Personal: Sending emoticons and text to personal chat failed");
				Constant.captureScreen_Negative("Send emoticons and text to Personal chat");
				extentTest.log(LogStatus.FAIL, "Sending emoticons and text to personal chat failed");
				testresultdata.put("7", new Object[] {6d, "Send emoticons and text to Personal chat", "Sending emoticons and text to personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Send emoticons and text to Personal chat");
	}
	
	@Test
	public void test007_sendImage_Personal(){
		Log.startTestCase("Send image to Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Send image to Personal chat",
				"Verify if able to send image to personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.attachImage_Personal(6);
			if(flag == true){
				Constant.log.info("test007_sendImage_Personal: Send image to personal chat is successful");
				extentTest.log(LogStatus.PASS, "Send image to personal chat is successful");
				testresultdata.put("8", new Object[] {7d, "Send image to Personal chat", "Send image to personal chat is successful","Pass"});
			}else{
				System.err.println("test007_sendImage_Personal: Send image to personal chat failed");
				Constant.captureScreen_Negative("Send image to Personal chat");
				extentTest.log(LogStatus.FAIL, "Send image to personal chat failed");
				testresultdata.put("8", new Object[] {7d, "Send image to Personal chat", "Send image to personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Send image to Personal chat");
	}

	@Test
	public void test008_sendVideo_Personal(){
		Log.startTestCase("Send Video to Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Send Video to Personal chat",
				"Verify if video can be sent to personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.attachvideo_Personal(9);
			if(flag == true){
				Constant.log.info("test008_sendVideo_Personal: Send Video to personal chat is successful");
				extentTest.log(LogStatus.PASS, "Send Video to personal chat is successful");
				testresultdata.put("9", new Object[] {8d, "Send Video to Personal chat", "Send Video to personal chat is successful","Pass"});
			}else{
				System.err.println("test008_sendVideo_Personal: Send Video to personal chat failed");
				Constant.captureScreen_Negative("Send Video to Personal chat");
				extentTest.log(LogStatus.FAIL, "Send Video to personal chat failed");
				testresultdata.put("9", new Object[] {8d, "Send Video to Personal chat", "Send Video to personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Send Video to Personal chat");
	}
	
	@Test
	public void test009_sendDocument_Personal(){
		Log.startTestCase("Send Document to Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Send Document to Personal chat",
				"Verify if Document can be sent to personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.attachDocuments_Personal(8);
			if(flag == true){
				Constant.log.info("test009_sendDocument_Personal: Send Document to personal chat is successful");
				extentTest.log(LogStatus.PASS, "Send Document to personal chat is successful");
				testresultdata.put("10", new Object[] {9d, "Send Document to Personal chat", "Send Document to personal chat is successful","Pass"});
			}else{
				System.err.println("test009_sendDocument_Personal: Send Document to personal chat failed");
				Constant.captureScreen_Negative("Send Document to Personal chat");
				extentTest.log(LogStatus.FAIL, "Send Document to personal chat failed");
				testresultdata.put("10", new Object[] {9d, "Send Document to Personal chat", "Send Document to personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Send Document to Personal chat");
	}
	
	@Test
	public void test010_sendAudio_Personal(){
		Log.startTestCase("Send Audio to Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Send Audio to Personal chat",
				"Verify if Audio can be sent to personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.sendAudio_Personal(9);
			if(flag == true){
				Constant.log.info("test010_sendAudio_Personal: Send Audio to personal chat is successful");
				extentTest.log(LogStatus.PASS, "Send Audio to personal chat is successful");
				testresultdata.put("11", new Object[] {10d, "Send Audio to Personal chat", "Send Audio to personal chat is successful","Pass"});
			}else{
				System.err.println("test010_sendAudio_Personal: Send Audio to personal chat failed");
				Constant.captureScreen_Negative("Send Audio to Personal chat");
				extentTest.log(LogStatus.FAIL, "Send Audio to personal chat failed");
				testresultdata.put("11", new Object[] {10d, "Send Audio to Personal chat", "Send Audio to personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Send Audio to Personal chat");
	}
	
	@Test
	public void test011_ValidateCancelInAudio(){
		Log.startTestCase("Validate cancel in Audio");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Validate cancel in Audio",
				"Verify cancel button while sending audio");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.validateCancelAudioAttach(10);
			if(flag == true){
				Constant.log.info("test011_ValidateCancelInAudio: Cancel sending audio test case is successful");
				extentTest.log(LogStatus.PASS, "Cancel sending audio test case is successful");
				testresultdata.put("12", new Object[] {11d, "Validate cancel in Audio", "Cancel sending audio test case is successful","Pass"});
			}else{
				System.err.println("test011_ValidateCancelInAudio: Cancel sending audio test case failed");
				Constant.captureScreen_Negative("Validate cancel in Audio");
				extentTest.log(LogStatus.FAIL, "Cancel sending audio test case failed");
				testresultdata.put("12", new Object[] {11d, "Validate cancel in Audio", "Cancel sending audio test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Validate cancel in Audio");
	}
	
	@Test
	public void test012_CreateTask_Personal(){
		Log.startTestCase("Create task in Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Create task in Personal chat",
				"Verify task is created in personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.createTask_Personal(11);
			if(flag == true){
				Constant.log.info("test012_CreateTask_Personal: Create task in personal chat test case is successful");
				extentTest.log(LogStatus.PASS, "Create task in personal chat test case is successful");
				testresultdata.put("13", new Object[] {12d, "Create task in Personal chat", "Create task in personal chat test case is successful","Pass"});
			}else{
				System.err.println("test012_CreateTask_Personal: Create task in personal chat test case failed");
				Constant.captureScreen_Negative("Create task in Personal chat");
				extentTest.log(LogStatus.FAIL, "Create task in personal chat test case failed");
				testresultdata.put("13", new Object[] {12d, "Create task in Personal chat", "Create task in personal chat test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Create task in Personal chat");
	}
	
	@Test
	public void test013_UpdateTargetDate_PersonalChat(){
		Log.startTestCase("Update task target date in Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Update task target date in Personal chat",
				"Verify task target date is updated personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.updateTaskTargetDate(12);
			if(flag == true){
				Constant.log.info("test013_UpdateTargetDate_PersonalChat: Update task target date in personal chat test case is successful");
				extentTest.log(LogStatus.PASS, "Update task target date in personal chat test case is successful");
				testresultdata.put("14", new Object[] {13d, "Update task target date in Personal chat", "Update task target date in personal chat test case is successful","Pass"});
			}else{
				System.err.println("test013_UpdateTargetDate_PersonalChat: Update task target date in personal chat test case failed");
				Constant.captureScreen_Negative("Update task target date in Personal chat");
				extentTest.log(LogStatus.FAIL, "Update task target date in personal chat test case failed");
				testresultdata.put("14", new Object[] {13d, "Update task target date in Personal chat", "Update task target date in personal chat test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Update task target date in Personal chat");
	}
	
	@Test
	public void test014_UpdateTargetStatus_PersonalChat(){
		Log.startTestCase("Update task Status in Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Update task Status in Personal chat",
				"Verify task Status is updated personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.updateTaskStatusToComplete(13);
			boolean flag1 = chatScreen.updateTaskStatusToPending(13);
			if(flag == true && flag1 == true){
				Constant.log.info("test014_UpdateTargetStatus_PersonalChat: Update task Status in personal chat test case is successful");
				extentTest.log(LogStatus.PASS, "Update task Status in personal chat test case is successful");
				testresultdata.put("15", new Object[] {14d, "Update task Status in Personal chat", "Update task Status in personal chat test case is successful","Pass"});
			}else{
				System.err.println("test014_UpdateTargetStatus_PersonalChat: Update task Status in personal chat test case failed");
				Constant.captureScreen_Negative("Update task Status in Personal chat");
				extentTest.log(LogStatus.FAIL, "Update task Status in personal chat test case failed");
				testresultdata.put("15", new Object[] {14d, "Update task Status in Personal chat", "Update task Status in personal chat test case failed","Fail"});
			}
			Assert.assertTrue(flag == true && flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Update task Status in Personal chat");
	}
	
	@Test
	public void test015_AddTaskNValidateTaskTab_Personal(){
		Log.startTestCase("Add task and validate in tasks tab");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Add task and validate in tasks tab",
				"Verify added task is available in Tasks tab");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.addTaskNValidateTaskTab(14);
			if(flag == true){
				Constant.log.info("test015_AddTaskNValidateTaskTab_Personal: Add task and validate in tasks tab test case is successful");
				extentTest.log(LogStatus.PASS, " Add task and validate in tasks tab test case is successful");
				testresultdata.put("16", new Object[] {15d, "Add task and validate in tasks tab", " Add task and validate in tasks tab test case is successful","Pass"});
			}else{
				System.err.println("test015_AddTaskNValidateTaskTab_Personal:  Add task and validate in tasks tab test case failed");
				Constant.captureScreen_Negative("Add task and validate in tasks tab");
				extentTest.log(LogStatus.FAIL, "Add task and validate in tasks tab test case failed");
				testresultdata.put("16", new Object[] {15d, "Add task and validate in tasks tab", " Add task and validate in tasks tab test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Add task and validate in tasks tab");
	}
	
	@Test
	public void test016_UpdateTaskDateTaskTab(){
		Log.startTestCase("Update task target date in Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Update task target date in Personal chat",
				"Verify task target date is updated personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.UpdateTargetDtTaskTab();
			if(flag == true){
				Constant.log.info("test016_UpdateTaskNValidateTaskTab_Personal: Update task target date in personal chat test case is successful");
				extentTest.log(LogStatus.PASS, "Update task target date in personal chat test case is successful");
				testresultdata.put("17", new Object[] {16d, "Update task target date in Personal chat", "Update task target date in personal chat test case is successful","Pass"});
			}else{
				System.err.println("test016_UpdateTaskNValidateTaskTab_Personal: Update task target date in personal chat test case failed");
				Constant.captureScreen_Negative("Update task target date in Personal chat");
				extentTest.log(LogStatus.FAIL, "Update task target date in personal chat test case failed");
				testresultdata.put("17", new Object[] {16d, "Update task target date in Personal chat", "Update task target date in personal chat test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Update task target date in Personal chat");
	}
	
	@Test
	public void test017_DeleteAllMsgs_Personal(){
		Log.startTestCase("Delete all types of messages in Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Delete all types of messages in Personal chat",
				"Verify if all message types can be deleted in personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.deleteMsg(16);
			if(flag == true){
				Constant.log.info("test017_DeleteAllMsgs_Personal: Delete all types of messages in personal chat test case is successful");
				extentTest.log(LogStatus.PASS, "Delete all types of messages in personal chat test case is successful");
				testresultdata.put("18", new Object[] {17d, "Delete all types of messages in Personal chat", "Delete all types of messages in personal chat test case is successful","Pass"});
			}else{
				System.err.println("test017_DeleteAllMsgs_Personal: Delete all types of messages in personal chat test case failed");
				Constant.captureScreen_Negative("Delete all types of messages in Personal chat");
				extentTest.log(LogStatus.FAIL, "Delete all types of messages in personal chat test case failed");
				testresultdata.put("18", new Object[] {17d, "Delete all types of messages in Personal chat", "Delete all types of messages in personal chat test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Delete all types of messages in Personal chat");
	}
	
	@Test
	public void test018_ReplyToAllMsgsAsText_Personal(){
		Log.startTestCase("Reply to all types of messages in Personal chat as text message");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Reply to all types of messages in Personal chat as text message",
				"Verify if all types messages can be replyed as text message in personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.replyToAllMessages_text(17);
			if(flag == true){
				Constant.log.info("test018_ReplyToAllMsgsAsText_Personal: Reply to all types of messages in Personal chat as text message test case is successful");
				extentTest.log(LogStatus.PASS, "Reply to all types of messages in Personal chat as text message test case is successful");
				testresultdata.put("19", new Object[] {18d, "Reply to all types of messages in Personal chat as text", "Reply to all types of messages in Personal chat as text message test case is successful","Pass"});
			}else{
				System.err.println("test018_ReplyToAllMsgsAsText_Personal: Reply to all types of messages in Personal chat as text message test case failed");
				Constant.captureScreen_Negative("Reply to all types of messages in Personal chat as text message");
				extentTest.log(LogStatus.FAIL, "Reply to all types of messages in Personal chat as text message test case failed");
				testresultdata.put("19", new Object[] {18d, "Reply to all types of messages in Personal chat as text message", "Reply to all types of messages in Personal chat as text message test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Delete all types of messages in Personal chat");
	}
	
	@Test
	public void test019_ReplyToAllMsgsAsImage_Personal(){
		Log.startTestCase("Reply to all types of messages in Personal chat as Image");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Reply to all types of messages in Personal chat as Image",
				"Verify if all types messages can be replyed as Image in personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.replyToAllMessages_image(18);
			if(flag == true){
				Constant.log.info("test018_ReplyToAllMsgsAsImage_Personal: Reply to all types of messages in Personal chat as Image test case is successful");
				extentTest.log(LogStatus.PASS, "Reply to all types of messages in Personal chat as Image test case is successful");
				testresultdata.put("20", new Object[] {19d, "Reply to all types of messages in Personal chat as Image", "Reply to all types of messages in Personal chat as Image test case is successful","Pass"});
			}else{
				System.err.println("test018_ReplyToAllMsgsAsText_Personal: Reply to all types of messages in Personal chat as Image test case failed");
				Constant.captureScreen_Negative("Reply to all types of messages in Personal chat as Image");
				extentTest.log(LogStatus.FAIL, "Reply to all types of messages in Personal chat as Image test case failed");
				testresultdata.put("20", new Object[] {19d, "Reply to all types of messages in Personal chat as Image", "Reply to all types of messages in Personal chat as Image test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reply to all types of messages in Personal chat as Image");
	}
	
	@Test
	public void test020_ReplyToAllMsgsAsDocument_Personal(){
		Log.startTestCase("Reply to all types of messages in Personal chat as Document");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Reply to all types of messages in Personal chat as Document",
				"Verify if all types messages can be replyed as Document in personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.replyToAllMessages_Document(19);
			if(flag == true){
				Constant.log.info("test020_ReplyToAllMsgsAsDocument_Personal: Reply to all types of messages in Personal chat as Document test case is successful");
				extentTest.log(LogStatus.PASS, "Reply to all types of messages in Personal chat as Document test case is successful");
				testresultdata.put("21", new Object[] {20d, "Reply to all types of messages in Personal chat as Document", "Reply to all types of messages in Personal chat as Document test case is successful","Pass"});
			}else{
				System.err.println("test020_ReplyToAllMsgsAsDocument_Personal: Reply to all types of messages in Personal chat as Document test case failed");
				Constant.captureScreen_Negative("Reply to all types of messages in Personal chat as Document");
				extentTest.log(LogStatus.FAIL, "Reply to all types of messages in Personal chat as Document test case failed");
				testresultdata.put("21", new Object[] {20d, "Reply to all types of messages in Personal chat as Document", "Reply to all types of messages in Personal chat as Document test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reply to all types of messages in Personal chat as Document");
	}
	
	@Test
	public void test021_ReplyToAllMsgsAsVideo_Personal(){
		Log.startTestCase("Reply to all types of messages in Personal chat as video");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Reply to all types of messages in Personal chat as video",
				"Verify if all types messages can be replyed as video in personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.replyToAllMessages_Video(20);
			if(flag == true){
				Constant.log.info("test021_ReplyToAllMsgsAsVideo_Personal: Reply to all types of messages in Personal chat as video test case is successful");
				extentTest.log(LogStatus.PASS, "Reply to all types of messages in Personal chat as video test case is successful");
				testresultdata.put("22", new Object[] {21d, "Reply to all types of messages in Personal chat as video", "Reply to all types of messages in Personal chat as video test case is successful","Pass"});
			}else{
				System.err.println("test021_ReplyToAllMsgsAsVideo_Personal: Reply to all types of messages in Personal chat as video test case failed");
				Constant.captureScreen_Negative("Reply to all types of messages in Personal chat as video");
				extentTest.log(LogStatus.FAIL, "Reply to all types of messages in Personal chat as video test case failed");
				testresultdata.put("22", new Object[] {21d, "Reply to all types of messages in Personal chat as video", "Reply to all types of messages in Personal chat as video test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reply to all types of messages in Personal chat as video");
	}
	/*
	@Test
	public void test022_ReplyToAllMsgsAsAudio_Personal(){
		Log.startTestCase("Reply to all types of messages in Personal chat as Audio");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Reply to all types of messages in Personal chat as Audio",
				"Verify if all types messages can be replyed as Audio in personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.replyToAllMessages_Audio(20);
			if(flag == true){
				Constant.log.info("test022_ReplyToAllMsgsAsAudio_Personal: Reply to all types of messages in Personal chat as Audio test case is successful");
				extentTest.log(LogStatus.PASS, "Reply to all types of messages in Personal chat as Audio test case is successful");
				testresultdata.put("23", new Object[] {22d, "Reply to all types of messages in Personal chat as Audio", "Reply to all types of messages in Personal chat as Audio test case is successful","Pass"});
			}else{
				System.err.println("test022_ReplyToAllMsgsAsAudio_Personal: Reply to all types of messages in Personal chat as Audio test case failed");
				Constant.captureScreen_Negative("Reply to all types of messages in Personal chat as Audio");
				extentTest.log(LogStatus.FAIL, "Reply to all types of messages in Personal chat as Audio test case failed");
				testresultdata.put("23", new Object[] {22d, "Reply to all types of messages in Personal chat as Audio", "Reply to all types of messages in Personal chat as Audio test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reply to all types of messages in Personal chat as Audio");
	}
	
	@Test
	public void test023_sendRecordedAudio_Personal(){
		Log.startTestCase("Send Recorded Audio to Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Send Recorded Audio to Personal chat",
				"Verify if Recorded Audio can be sent to personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.sendRecordAudio_Personal(9);
			if(flag == true){
				Constant.log.info("test023_sendRecordedAudio_Personal: Send Recorded Audio to personal chat is successful");
				extentTest.log(LogStatus.PASS, "Send Recorded Audio to personal chat is successful");
				testresultdata.put("24", new Object[] {23d, "Send Recorded Audio to Personal chat", "Send Audio to personal chat is successful","Pass"});
			}else{
				System.err.println("test023_sendRecordedAudio_Personal: Send Recorded Audio to personal chat failed");
				Constant.captureScreen_Negative("Send Recorded Audio to Personal chat");
				extentTest.log(LogStatus.FAIL, "Send Recorded Audio to personal chat failed");
				testresultdata.put("24", new Object[] {23d, "Send Audio to Personal chat", "Send Recorded Audio to personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Send Recorded Audio to Personal chat");
	}
	
	@Test
	public void test024_ReplyToAllMsgsAsRecordedAudio_Personal(){
		Log.startTestCase("Reply to all types of messages in Personal chat as Recorded Audio");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Reply to all types of messages in Personal chat as Recorded Audio",
				"Verify if all types messages can be replyed as Recorded Audio in personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.replyToAllMessages_RecordedAudio(23);
			if(flag == true){
				Constant.log.info("test022_ReplyToAllMsgsAsAudio_Personal: Reply to all types of messages in Personal chat as Recorded Audio test case is successful");
				extentTest.log(LogStatus.PASS, "Reply to all types of messages in Personal chat as Recorded Audio test case is successful");
				testresultdata.put("25", new Object[] {24d, "Reply to all types of messages in Personal chat as Recorded Audio", "Reply to all types of messages in Personal chat as Recorded Audio test case is successful","Pass"});
			}else{
				System.err.println("test022_ReplyToAllMsgsAsAudio_Personal: Reply to all types of messages in Personal chat as Recorded Audio test case failed");
				Constant.captureScreen_Negative("Reply to all types of messages in Personal chat as Recorded Audio");
				extentTest.log(LogStatus.FAIL, "Reply to all types of messages in Personal chat as Recorded Audio test case failed");
				testresultdata.put("25", new Object[] {24d, "Reply to all types of messages in Personal chat as Recorded Audio", "Reply to all types of messages in Personal chat as Recorded Audio test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reply to all types of messages in Personal chat as Recorded Audio");
	}
	*/
	@Test
	public void test025_ValidateCancelInRecordedAudio(){
		Log.startTestCase("Validate cancel in Recorded Audio");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Validate cancel in Recorded Audio",
				"Verify cancel button while Recordedsending audio");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.validateCancelInRecording(24);
			if(flag == true){
				Constant.log.info("test025_ValidateCancelInRecordedAudio: Cancel sending Recorded audio test case is successful");
				extentTest.log(LogStatus.PASS, "Cancel sending Recorded audio test case is successful");
				testresultdata.put("26", new Object[] {25d, "Validate cancel in Recorded Audio", "Cancel sending Recorded audio test case is successful","Pass"});
			}else{
				System.err.println("test025_ValidateCancelInRecordedAudio: Cancel sending Recorded audio test case failed");
				Constant.captureScreen_Negative("Validate cancel in Recorded Audio");
				extentTest.log(LogStatus.FAIL, "Cancel sending Recorded audio test case failed");
				testresultdata.put("26", new Object[] {25d, "Validate cancel in Recorded Audio", "Cancel sending Recorded audio test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Validate cancel in Recorded Audio");
	}
	
	@Test
	public void test026_CopyNPasteTextMsg(){
		Log.startTestCase("Copy and paste text message");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Copy and paste text message",
				"Verify text message can be copied and pasted in another chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.copyNPasteTxtMsg_Personal(25);
			if(flag == true){
				Constant.log.info("test026_CopyNPasteTextMsg: Copy and paste text message test case is successful");
				extentTest.log(LogStatus.PASS, "Copy and paste text message test case is successful");
				testresultdata.put("27", new Object[] {26d, "Copy and paste text message", "Copy and paste text message test case is successful","Pass"});
			}else{
				System.err.println("test026_CopyNPasteTextMsg: Copy and paste text message test case failed");
				Constant.captureScreen_Negative("Copy and paste text message");
				extentTest.log(LogStatus.FAIL, "Copy and paste text message test case failed");
				testresultdata.put("27", new Object[] {26d, "Copy and paste text message", "Copy and paste text message test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Copy and paste text message");
	}
	
//	@Test
	public void test027_SendCapturedImage_Personal(){
		Log.startTestCase("Send Captured image to Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Send Captured image to Personal chat",
				"Verify if able to send Captured image to personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.clickPickNSend_Personal(26);
			if(flag == true){
				Constant.log.info("test027_SendCapturedImage_Personal: Send Captured image to personal chat is successful");
				extentTest.log(LogStatus.PASS, "Send Captured image to personal chat is successful");
				testresultdata.put("28", new Object[] {27d, "Send Captured image to Personal chat", "Send image to personal chat is successful","Pass"});
			}else{
				System.err.println("test027_SendCapturedImage_Personal: Send Captured image to personal chat failed");
				Constant.captureScreen_Negative("Send Captured image to Personal chat");
				extentTest.log(LogStatus.FAIL, "Send Captured image to personal chat failed");
				testresultdata.put("28", new Object[] {27d, "Send Captured image to Personal chat", "Send Captured image to personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Send Captured image to Personal chat");
	}
	
	@Test
	public void test028_UpdateProfileName(){
		Log.startTestCase("update profile name");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("update profile name",
				"Verify if profile name is updated");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.updateProfileName();
			if(flag == true){
				Constant.log.info("test028_UpdateProfileName: Update profile name test case is successful");
				extentTest.log(LogStatus.PASS, "Update profile name test case is successful");
				testresultdata.put("29", new Object[] {28d, "update profile name", "Update profile name test case is successful","Pass"});
			}else{
				System.err.println("test028_UpdateProfileName: Update profile name test case failed");
				Constant.captureScreen_Negative("update profile name");
				extentTest.log(LogStatus.FAIL, "Update profile name test case failed");
				testresultdata.put("29", new Object[] {28d, "update profile name", "Update profile name test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("update profile name");
	}
	
	@Test
	public void test029_validateCancelBtnProfileName(){
		Log.startTestCase("Cancel button in Profile name update");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Cancel button in Profile name update",
				"Validate cancel button in profile name updated");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.validateCancelBtnProfileName();
			if(flag == true){
				Constant.log.info("test029_validateCancelBtnProfileName: validate cancel button in profile name update test case is successful");
				extentTest.log(LogStatus.PASS, "Update profile name test case is successful");
				testresultdata.put("30", new Object[] {29d, "Cancel button in Profile name update", "validate cancel button in profile name update test case is successful","Pass"});
			}else{
				System.err.println("test029_validateCancelBtnProfileName: validate cancel button in profile name update test case failed");
				Constant.captureScreen_Negative("Cancel button in Profile name update");
				extentTest.log(LogStatus.FAIL, "validate cancel button in profile name update test case failed");
				testresultdata.put("30", new Object[] {29d, "Cancel button in Profile name update", "validate cancel button in profile name update test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel button in Profile name update");
	}
	
	@Test
	public void test030_EmptyProfileNameUpdate(){
		Log.startTestCase("Empty Profile Name Update");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Empty Profile Name Update",
				"validate Profile Name Not Updated As Empty");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.EmptyProfileName();
			if(flag == true){
				Constant.log.info("test030_EmptyProfileNameUpdate: validate if empty profile name is not updated test case is successful");
				extentTest.log(LogStatus.PASS, "validate if empty profile name is not updated test case is successful");
				testresultdata.put("31", new Object[] {30d, "Empty Profile Name Update", "validate if empty profile name is not updated test case is successful","Pass"});
			}else{
				System.err.println("test030_EmptyProfileNameUpdate: validate if empty profile name is not updated test case failed");
				Constant.captureScreen_Negative("Empty Profile Name Update");
				extentTest.log(LogStatus.FAIL, "validate if empty profile name is not updated test case failed");
				testresultdata.put("31", new Object[] {30d, "Empty Profile Name Update", "validate if empty profile name is not updated test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Empty Profile Name Update");
	}
	
//	@Test
	public void test031_UpdateProfilePic_Camera(){
		Log.startTestCase("Update Profile pic with camera");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Update Profile pic with camera",
				"Validate profile pic update with camera");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.updateProfilePic_Camera();
			if(flag == true){
				Constant.log.info("test031_UpdateProfilePic_Camera: Validate profile pic update with camera test case is successful");
				extentTest.log(LogStatus.PASS, "Validate profile pic update with camera test case is successful");
				testresultdata.put("32", new Object[] {31d, "Update Profile pic with camera", "Validate profile pic update with camera test case is successful","Pass"});
			}else{
				System.err.println("test031_UpdateProfilePic_Camera: Validate profile pic update with camera test case failed");
				Constant.captureScreen_Negative("Update Profile pic with camera");
				extentTest.log(LogStatus.FAIL, "Validate profile pic update with camera test case failed");
				testresultdata.put("32", new Object[] {31d, "Update Profile pic with camera", "Validate profile pic update with camera test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Update Profile pic with camera");
	}
	
	@Test
	public void test032_UpdateProfilePic_Gallery(){
		Log.startTestCase("Update Profile pic with Gallery");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Update Profile pic with Gallery",
				"Validate profile pic update with Gallery");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.updateProfilePic_Gallery();
			if(flag == true){
				Constant.log.info("test032_UpdateProfilePic_Gallery: Validate profile pic update with Gallery test case is successful");
				extentTest.log(LogStatus.PASS, "Validate profile pic update with Gallery test case is successful");
				testresultdata.put("33", new Object[] {32d, "Update Profile pic with Gallery", "Validate profile pic update with Gallery test case is successful","Pass"});
			}else{
				System.err.println("test032_UpdateProfilePic_Gallery: Validate profile pic update with Gallery test case failed");
				Constant.captureScreen_Negative("Update Profile pic with Gallery");
				extentTest.log(LogStatus.FAIL, "Validate profile pic update with Gallery test case failed");
				testresultdata.put("33", new Object[] {32d, "Update Profile pic with Gallery", "Validate profile pic update with Gallery test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Update Profile pic with Gallery");
	}
	
	@Test
	public void test033_DeleteProfilePic(){
		Log.startTestCase("Delete Profile Pic");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Delete Profile pic",
				"Validate if profile pic can be deleted");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.deleteProfilePic();
			if(flag == true){
				Constant.log.info("test033_DeleteProfilePic: Validate profile pic can be deleted test case is successful");
				extentTest.log(LogStatus.PASS, "Validate profile pic can be deleted test case is successful");
				testresultdata.put("34", new Object[] {33d, "Delete Profile pic", "Validate profile pic can be deleted test case is successful","Pass"});
			}else{
				System.err.println("test033_DeleteProfilePic: Validate profile pic can be deleted test case failed");
				Constant.captureScreen_Negative("Delete Profile pic");
				extentTest.log(LogStatus.FAIL, "Validate profile pic can be deleted test case failed");
				testresultdata.put("34", new Object[] {33d, "Delete Profile pic", "Validate profile pic can be deleted test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Delete Profile pic");
	}
	
	@Test
	public void test034_sendEmoticons_Personal(){
		Log.startTestCase("Send emoticons to Personal chat");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Send emoticons to Personal chat",
				"Verify if able to send emoticons to personal chat");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.sendEmojiMessage_Personal(33);
			if(flag == true){
				Constant.log.info("test034_sendEmoticons_Personal: Sending emoticons to personal chat is successful");
				extentTest.log(LogStatus.PASS, "Sending emoticons to personal chat is successful");
				testresultdata.put("35", new Object[] {34d, "Send emoticons to Personal chat", "Sending emoticons to personal chat is successful","Pass"});
			}else{
				System.err.println("test034_sendEmoticons_Personal: Sending emoticons to personal chat failed");
				Constant.captureScreen_Negative("Send emoticons to Personal chat");
				extentTest.log(LogStatus.FAIL, "Sending emoticons to personal chat failed");
				testresultdata.put("35", new Object[] {34d, "Send emoticons to Personal chat", "Sending emoticons to personal chat failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Send emoticons to Personal chat");
	}
	
	@Test
	public void test035_CancelBtn_ProfilePic(){
		Log.startTestCase("Cancel button in Profile pic");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Cancel button in Profile pic",
				"Verify if cancel button in profile pic setting screen");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.cancelBtnProfilePic();
			if(flag == true){
				Constant.log.info("test035_CancelBtn_ProfilePci: Validate Cancel button in profile pic screen is successful");
				extentTest.log(LogStatus.PASS, "Validate Cancel button in profile pic screen is successful");
				testresultdata.put("36", new Object[] {35d, "Send emoticons to Personal chat", "Validate Cancel button in profile pic screen is successful","Pass"});
			}else{
				System.err.println("test035_CancelBtn_ProfilePci: Sending emoticons to personal chat failed");
				Constant.captureScreen_Negative("Cancel button in Profile pic");
				extentTest.log(LogStatus.FAIL, "Validate Cancel button in profile pic screen failed");
				testresultdata.put("36", new Object[] {35d, "Cancel button in Profile pic", "Validate Cancel button in profile pic screen failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel button in Profile pic");
	}
	
	@Test
	public void test036_CreateGroup_Contacts(){
		Log.startTestCase("Create group from contacts");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Create group from contacts",
				"Verify if group is created from contacts list");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.createGroupFromContacts(35);
			if(flag == true){
				Constant.log.info("test036_CreateGroup_Contacts: Group creation from contacts list test case is successful");
				extentTest.log(LogStatus.PASS, "Group creation from contacts list test case is successful");
				testresultdata.put("37", new Object[] {36d, "Create group from contacts", "Group creation from contacts list test case is successful","Pass"});
			}else{
				System.err.println("test036_CreateGroup_Contacts: Group creation from contacts list test case failed");
				Constant.captureScreen_Negative("Cancel button in Profile pic");
				extentTest.log(LogStatus.FAIL, "Group creation from contacts list test case screen failed");
				testresultdata.put("37", new Object[] {36d, "Create group from contacts", "Group creation from contacts list test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Create group from contacts");
	}
	
	@Test
	public void test037_CreateGroup_Settings(){
		Log.startTestCase("Create group near settings");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Create group near settings",
				"Verify if group is created from settings");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.createGroupFromSettings(36);
			if(flag == true){
				Constant.log.info("test037_CreateGroup_Settings: Group creation from settings test case is successful");
				extentTest.log(LogStatus.PASS, "Group creation from settings test case is successful");
				testresultdata.put("38", new Object[] {37d, "Create group near settings", "Group creation from settings test case is successful","Pass"});
			}else{
				System.err.println("test037_CreateGroup_Settings: Group creation from settings test case failed");
				Constant.captureScreen_Negative("Create group near settings");
				extentTest.log(LogStatus.FAIL, "Group creation from settings test case failed");
				testresultdata.put("38", new Object[] {37d, "Create group near settingsp", "Group creation from settings test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Create group near settings");
	}
	
	@Test
	public void test038_ValidateEmptyDesc(){
		Log.startTestCase("Validate Empty group description");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Validate Empty group description",
				"Verify if group is not created without group description");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.emptyGrpDesc(37);
			if(flag == true){
				Constant.log.info("test038_ValidateEmptyDesc: Group not created with empty group description test case is successful");
				extentTest.log(LogStatus.PASS, "Group not created with empty group description test case is successful");
				testresultdata.put("39", new Object[] {38d, "Validate Empty group description", "Group not created with empty group description test case is successful","Pass"});
			}else{
				System.err.println("test038_ValidateEmptyDesc: Group not created with empty group description test case failed");
				Constant.captureScreen_Negative("Validate Empty group description");
				extentTest.log(LogStatus.FAIL, "Group not created with empty group description test case failed");
				testresultdata.put("39", new Object[] {38d, "Validate Empty group description", "Group not created with empty group description test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Validate Empty group description");
	}
	
	@Test
	public void test039_CreateGrpWithPic_Gallery(){
		Log.startTestCase("Create group with profile pic from gallery");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Create group with profile pic from gallery",
				"Verify if group is created with profile pic from gallery");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.createGrpWithProfilePic_Gallery(38);
			if(flag == true){
				Constant.log.info("test039_CreateGrpWithPic_Gallery: Group created with profile pic from gallery test case is successful");
				extentTest.log(LogStatus.PASS, "Group created with profile pic from gallery test case is successful");
				testresultdata.put("40", new Object[] {39d, "Create group with profile pic from gallery", "Group created with profile pic from gallery test case is successful","Pass"});
			}else{
				System.err.println("test039_CreateGrpWithPic_Gallery: Group created with profile pic from gallery test case failed");
				Constant.captureScreen_Negative("Create group with profile pic from gallery");
				extentTest.log(LogStatus.FAIL, "Group created with profile pic from gallery test case failed");
				testresultdata.put("40", new Object[] {39d, "Create group with profile pic from gallery", "Group created with profile pic from gallery test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Create group with profile pic from gallery");
	}
	
//	@Test
	public void test040_CreateGrpWithPic_Camera(){
		Log.startTestCase("Create group with profile pic from camera");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Create group with profile pic from camera",
				"Verify if group is created with profile pic from camera");
		extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.createGrpWithProfilePic_Camera(39);
			if(flag == true){
				Constant.log.info("test040_CreateGrpWithPic_Camera: Group created with profile pic from camera test case is successful");
				extentTest.log(LogStatus.PASS, "Group created with profile pic from camera test case is successful");
				testresultdata.put("41", new Object[] {40d, "Create group with profile pic from camera", "Group created with profile pic from camera test case is successful","Pass"});
			}else{
				System.err.println("test040_CreateGrpWithPic_Camera: Group created with profile pic from camera test case failed");
				Constant.captureScreen_Negative("Create group with profile pic from camera");
				extentTest.log(LogStatus.FAIL, "Group created with profile pic from camera test case failed");
				testresultdata.put("41", new Object[] {40d, "Create group with profile pic from camera", "Group created with profile pic from camera test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Create group with profile pic from camera");
	}
	
	@Test
	public void test041_CancelValidationInGrpPic(){
		Log.startTestCase("Cancel validation in group pic");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Cancel validation in group pic",
				"Verify cancel validation in group pic popup");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.cancelValidation_GrpPic(40);
			if(flag == true){
				Constant.log.info("test041_CancelValidationInGrpPic: Cancel validation in group pic pop up test case is successful");
				extentTest.log(LogStatus.PASS, "Cancel validation in group pic pop up test case is successful");
				testresultdata.put("42", new Object[] {41d, "Cancel validation in group pic", "Cancel validation in group pic pop up test case is successful","Pass"});
			}else{
				System.err.println("test041_CancelValidationInGrpPic: Cancel validation in group pic pop up test case failed");
				Constant.captureScreen_Negative("Cancel validation in group pic");
				extentTest.log(LogStatus.FAIL, "Cancel validation in group pic pop up test case failed");
				testresultdata.put("42", new Object[] {41d, "Cancel validation in group pic", "Cancel validation in group pic pop up test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel validation in group pic");
	}
	
	@Test
	public void test042_ValidateGrpParticipantList(){
		Log.startTestCase("Group participant List");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Group participant List",
				"Validate participant list in created group");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.viewGrpParticipantContact(41);
			if(flag == true){
				Constant.log.info("test042_ValidateGrpParticipantList: Participant list in group validation test case is successful");
				extentTest.log(LogStatus.PASS, "Participant list in group validation test case is successful");
				testresultdata.put("43", new Object[] {42d, "Group participant List", "Participant list in group validation test case is successful","Pass"});
			}else{
				System.err.println("test042_ValidateGrpParticipantList: Participant list in group validation test case failed");
				Constant.captureScreen_Negative("Group participant List");
				extentTest.log(LogStatus.FAIL, "Participant list in group validation test case failed");
				testresultdata.put("43", new Object[] {42d, "Group participant List", "Participant list in group validation test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Group participant List");
	}
	
	@Test
	public void test043_VerifySettingComponents(){
		Log.startTestCase("Setting screen component");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Setting screen component",
				"Validate settings screen component");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.settingsComponentVerify();
			if(flag == true){
				Constant.log.info("test043_VerifySettingComponents: Components verfication in settings test case is successful");
				extentTest.log(LogStatus.PASS, "Components verfication in settings test case is successful");
				testresultdata.put("44", new Object[] {43d, "Setting screen component", "Components verfication in settings test case is successful","Pass"});
			}else{
				System.err.println("test043_VerifySettingComponents: Components verfication in settings test case failed");
				Constant.captureScreen_Negative("Setting screen component");
				extentTest.log(LogStatus.FAIL, "Components verfication in settings test case failed");
				testresultdata.put("44", new Object[] {43d, "Setting screen component", "Components verfication in settings test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Setting screen component");
	}
	
	@Test
	public void test044_VerifyFontSize(){
		Log.startTestCase("Font size options validation");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Font size options validation",
				"Validate font size options ");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.fontSizeVerify();
			if(flag == true){
				Constant.log.info("test044_VerifyFontSize: Font size options validation test case is successful");
				extentTest.log(LogStatus.PASS, "Font size options validation test case is successful");
				testresultdata.put("45", new Object[] {44d, "Font size options validation", "Font size options validation test case is successful","Pass"});
			}else{
				System.err.println("test044_VerifyFontSize: Font size options validation test case failed");
				Constant.captureScreen_Negative("Font size options validation");
				extentTest.log(LogStatus.FAIL, "Font size options validation test case failed");
				testresultdata.put("45", new Object[] {44d, "Font size options validation", "Font size options validation test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Font size options validation");
	}
	
	@Test
	public void test045_SendInviteMessage(){
		Log.startTestCase("Invite message send");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Invite message send",
				"Validate if invite message is sent");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.inviteFriendVerify(44);
			if(flag == true){
				Constant.log.info("test045_SendInviteMessage: Invite message send test case is successful");
				extentTest.log(LogStatus.PASS, "Invite message send test case is successful");
				testresultdata.put("46", new Object[] {45d, "Invite message send", "Invite message send test case is successful","Pass"});
			}else{
				System.err.println("test045_SendInviteMessage: Invite message send test case failed");
				Constant.captureScreen_Negative("Invite message send");
				extentTest.log(LogStatus.FAIL, "Invite message send test case failed");
				testresultdata.put("46", new Object[] {45d, "Invite message send", "Invite message send test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Invite message send");
	} 
	
	@Test
	public void test046_HelpOptionComponentsVerify(){
		Log.startTestCase("Help components Verify");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Help components Verify",
				"Validate if invite message is sent");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.helpComponentVerify();
			if(flag == true){
				Constant.log.info("test046_HelpOptionComponentsVerify: Help option components verification test case is successful");
				extentTest.log(LogStatus.PASS, "Help option components verification test case is successful");
				testresultdata.put("47", new Object[] {46d, "Help components Verify", "Help option components verification test case is successful","Pass"});
			}else{
				System.err.println("test046_HelpOptionComponentsVerify: Help option components verification test case failed");
				Constant.captureScreen_Negative("Help components Verify");
				extentTest.log(LogStatus.FAIL, "Help option components verification test case failed");
				testresultdata.put("47", new Object[] {46d, "Help components Verify", "Help option components verification test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Help components Verify");
	} 
	
	@Test
	public void test047_ChatBackupBtnVerify(){
		Log.startTestCase("Chat Backup button Verify");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Chat Backup button Verify",
				"Validate if chat backup button is available");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.chatBackUpBtnVerify();
			if(flag == true){
				Constant.log.info("test047_ChatBackupBtnVerify: Chat back up button availablity verification test case is successful");
				extentTest.log(LogStatus.PASS, "Chat back up button availablity verification test case is successful");
				testresultdata.put("48", new Object[] {47d, "Chat Backup button Verify", "Chat back up button availablity verification test case is successful","Pass"});
			}else{
				System.err.println("test047_ChatBackupBtnVerify: Chat back up button availablity verification test case failed");
				Constant.captureScreen_Negative("Chat Backup button Verify");
				extentTest.log(LogStatus.FAIL, "Chat back up button availablity verification test case failed");
				testresultdata.put("48", new Object[] {47d, "Chat Backup button Verify", "Chat back up button availablity verification test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Chat Backup button Verify");
	} 
	
	@Test
	public void test048_BackUpFilePathValidation(){
		Log.startTestCase("Back up file path validation");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Back up file path validation",
				"Validate if chat backup button is available");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.verifyBackUPBtn();
			if(flag == true){
				Constant.log.info("test048_BackUpFilePathValidation: Back up file path validation test case is successful");
				extentTest.log(LogStatus.PASS, "Back up file path validation test case is successful");
				testresultdata.put("48", new Object[] {47d, "Back up file path validation", "Back up file path validation test case is successful","Pass"});
			}else{
				System.err.println("test048_BackUpFilePathValidation: Back up file path validation test case failed");
				Constant.captureScreen_Negative("Back up file path validation");
				extentTest.log(LogStatus.FAIL, "Back up file path validation test case failed");
				testresultdata.put("48", new Object[] {47d, "Back up file path validation", "Back up file path validation test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Back up file path validation");
	} 
	
	@Test
	public void test049_ErrorPopupInvalidBackupFile(){
		Log.startTestCase("Error pop up for invalid backup file");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Error pop up for invalid backup file",
				"Validate if error pop up is displayed when invalid backup file is selected");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			ChatScreen chatScreen = new ChatScreen(driver);
			boolean flag = chatScreen.WarningMSg_invalidBackupFile(48);
			if(flag == true){
				Constant.log.info("test049_ErrorPopupInvalidBackupFile: Warning pop up validation when invalid backup file selected test case is successful");
				extentTest.log(LogStatus.PASS, "Warning pop up validation when invalid backup file selected test case is successful");
				testresultdata.put("48", new Object[] {47d, "Error pop up for invalid backup file", "Warning pop up validation when invalid backup file selected test case is successful","Pass"});
			}else{
				System.err.println("test049_ErrorPopupInvalidBackupFile: Warning pop up validation when invalid backup file selected test case failed");
				Constant.captureScreen_Negative("Error pop up for invalid backup file");
				extentTest.log(LogStatus.FAIL, "Warning pop up validation when invalid backup file selected test case failed");
				testresultdata.put("48", new Object[] {47d, "Error pop up for invalid backup file", "Warning pop up validation when invalid backup file selected test case failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Error pop up for invalid backup file");
	} 
	
	 @AfterTest
		public void After(){
//		 	nurseScreen.logout();
		 	 //write excel file and file name is TestResult.xls 
	        Set<String> keyset = testresultdata.keySet();
	        int rownum = 0;
	        for (String key : keyset) {
	            Row row = sheet.createRow(rownum++);
	            Object [] objArr = testresultdata.get(key);
	            int cellnum = 0;
	            for (Object obj : objArr) {
	                Cell cell = row.createCell(cellnum++);
	                if(obj instanceof Date) 
	                    cell.setCellValue((Date)obj);
	                else if(obj instanceof Boolean)
	                    cell.setCellValue((Boolean)obj);
	                else if(obj instanceof String)
	                    cell.setCellValue((String)obj);
	                else if(obj instanceof Double)
	                    cell.setCellValue((Double)obj);
	            }
	        }
	        try {
	            FileOutputStream out =new FileOutputStream(new File("CatchUp.xls"));
	            workbook.write(out);
	            out.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    
		}
		
		@AfterClass
		public static void AfterClass() throws Exception{
			driver.quit();
			extentTest.log(LogStatus.INFO, "Browser closed");
			// close report.  
			extent.endTest(extentTest);
			// writing everything to document.
	    	extent.flush();
//	    	appiumService.stop();
		}
}
