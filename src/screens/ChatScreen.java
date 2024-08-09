package screens;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import utility.AbstractScreen;
import utility.Constant;
import utility.ExcelUtils;
import utility.ReadPropertyFile;

public class ChatScreen extends AbstractScreen{
	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);

	@AndroidFindBy(id="com.schnell.taskassist:id/phoneNumberText")
	public WebElement enterPhoneNum;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/registrationSendOTP")
	public WebElement verifyPhoneNum;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/registrationOtpText")
	public WebElement enterOTP;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/registrationLoginBtn")
	public WebElement loginBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/profilePhotoIcon")
	public WebElement photoIcon;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/emojiconEditText")
	public WebElement profileNameEdit;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/profileNextBtn")
	public WebElement profileNextBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/titleToolbar")
	public WebElement catchUpTitle;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/chatMessageEditText")
	public WebElement editTextMsg;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/sendBtnImageView")
	public WebElement sendTextMsg;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/createChatFloatingBtn")
	public WebElement chatContactsBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/profilePictureToolbar")
	public WebElement profilePicBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/titleToolbar")
	public WebElement profileChatTitle;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/phoneNumberTextView")
	public WebElement profilePhoneNumText;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/chatIconImageView")
	public WebElement chatIconProfile;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/attachmentIconImageView")
	public WebElement attachmentBTn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/galleryIcon")
	public WebElement galleryIcon;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/userSelectedImageCaption")
	public WebElement imageCaptionTxt;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/addImageFloatingBtn")
	public WebElement sendImageBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/chatAttachmentImageView")
	public WebElement attachedImage;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/tasksIcon")
	public WebElement videoAttachment;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/documentIcon")
	public WebElement documentIcon;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/fileNameTextView")
	public List<WebElement> attachedFileName;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/audioIcon")
	public WebElement audioIcon;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/okButton")
	public WebElement audioOkBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/cancelButton")
	public WebElement audioCancelBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/userFullName")
	public List<WebElement> ChatsList;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/menu_task")
	public WebElement taskIcon;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/task_name")
	public List<WebElement> taskList;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/filterIconImageView")
	public WebElement filterIcon;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/taskSwitchImageView")
	public WebElement taskSwitchBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/menu_delete")
	public WebElement deleteMsg;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/menu_reply")
	public WebElement replyBtn;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/closeReplyIconText']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")
	public WebElement replyMsgTextView;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/audioRecordImageView")
	public WebElement audioRecordBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/slideToCancelTextView")
	public WebElement cancelRecordingBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/cameraIconImageView")
	public WebElement cameraIconChatScreen;
	
	@AndroidFindBy(id="com.android.gallery3d:id/shutter_button_photo")
	public WebElement clickPhotoBtn;
	
	@AndroidFindBy(id="com.android.gallery3d:id/btn_done")
	public WebElement clickDoneBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/action_options")
	public WebElement optionsInChatDash;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Settings']")
	public WebElement settingHeading;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/userNameSettings")
	public WebElement userNameInSettings;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/editProfileNameImageView")
	public WebElement editProfileNameBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/profileNameEditText")
	public WebElement editProfileNameTxt;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/okBtn")
	public WebElement okBtnUpdateProfileName;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/cancelBtn")
	public WebElement cancelBtnUpdateProfileName;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/cameraViewIcon")
	public WebElement cameraIconProfileSettings;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/profileNameEditProfilePage")
	public WebElement profileNameEdit_settings;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/cameraIcon")
	public WebElement cameraIcon_setting;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/crop_image_menu_crop")
	public WebElement cropImage;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/deleteIcon")
	public WebElement deleteIcon;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/photoAttachmentCancelButton")
	public WebElement cancelBtnProfilePic;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='New group']")
	public WebElement newGroup;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/groupNameEditText")
	public WebElement groupNameEditTxt;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/createGroupFloatingBtn")
	public WebElement createGrpBtn;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement backArrow;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/action_search")
	public WebElement searchIcon;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/search_src_text")
	public WebElement searchTextField;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/dateHeaderTextView")
	public WebElement dayBotMessage;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/alertTitleTextView")
	public WebElement alertBotMsg;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/groupProfilePhotoImageView")
	public WebElement grpProfilePic;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/groupNameLabel")
	public WebElement noOfParticipants;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='View Contact']")
	public WebElement viewContact;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Collapse']")
	public WebElement back_Collapse;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/search_close_btn")
	public WebElement closeSearchBtn;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/contactName")
	public List<WebElement> participantList;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/userProfilePictureSettings")
	public WebElement profilePicIcon_Settings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Account']")
	public WebElement accountOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Chats']")
	public WebElement chatOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Invite a friend']")
	public WebElement inviteOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Help']")
	public WebElement helpOption;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/fontSizeName")
	public WebElement fontSize;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Font Size']")
	public WebElement fontSizePopUP;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/smallFont")
	public WebElement smallFont;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/mediumFont")
	public WebElement mediumFont;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/largeFont")
	public WebElement largeFont;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/cancelTextView")
	public WebElement cancel_FontSizePopup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Messaging']")
	public WebElement messagingOption_Invite;
	
	@AndroidFindBy(id="com.android.messaging:id/compose_message_text")
	public WebElement composeMsgTxt_Invite;
	
	@AndroidFindBy(id="com.android.messaging:id/send_message_button")
	public WebElement sendMsgBtn_Invite;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='FAQ']")
	public WebElement faq_Help;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Contact us']")
	public WebElement contactUs_Help;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Terms and Privacy Policy']")
	public WebElement privacyPolicy_Help;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='App info']")
	public WebElement appInfo_Help;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/chatBackUp")
	public WebElement chatBackUPOption;
	
	@AndroidFindBy(id="com.schnell.taskassist:id/chatBackUpView")
	public WebElement chatBackUPBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Settings']")
	public WebElement mobSettings;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='Apps']")
	public WebElement allAppIcon;
	
	@AndroidFindBy(id="com.android.launcher3:id/search_button")
	public WebElement allAppSearchIcon;
	
	@AndroidFindBy(id="com.android.launcher3:id/search_box_input")
	public WebElement allAppSearchField;
	
	@AndroidFindBy(id="com.android.settings:id/search")
	public WebElement settingsSearchIcon;
	
	@AndroidFindBy(id="android:id/search_src_text")
	public WebElement settingsSearchField;
	
	@AndroidFindBy(id="com.android.documentsui:id/menu_sort")
	public WebElement menuSortOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Backup Restore']")
	public WebElement backUPPopup;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='No']")
	public WebElement no_backUPPopup;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='YES']")
	public WebElement yes_backUPPopup;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	public WebElement allowPermission;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Backup failed']")
	public WebElement backUpFailedPopup;
	
	@AndroidFindBy(id="android:id/message")
	public WebElement popUpMsg;
	
	String sDate = Constant.DateTimeFormat();
	String sTime = Constant.CurrentTimeFormat();
	
	public ChatScreen(AndroidDriver driver){
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public boolean login(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sMobileNumber = xls.get(rowNo).get("Mobile number");
		String sOTP = xls.get(rowNo).get("OTP");
		try{
			if(enterPhoneNum.isDisplayed()){
				enterPhoneNum.sendKeys(sMobileNumber);
				verifyPhoneNum.click();
//				driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_DOWN);
//				Thread.sleep(2000);
//				driver.pressKeyCode(AndroidKeyCode.KEYCODE_TAB);
//				Thread.sleep(2000);
//				driver.pressKeyCode(AndroidKeyCode.ENTER);
				Thread.sleep(Constant.Min_Sleep);
				if(enterOTP.isDisplayed()){
					enterOTP.sendKeys(sOTP);
					loginBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					if(!profileNameEdit.getText().isEmpty()){
						profileNextBtn.click();
						if(backUPPopup.isDisplayed()){
							no_backUPPopup.click();
						}
						allowPermission.click();
						if(catchUpTitle.isDisplayed()){
							flag = true;
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Login into the catch up app failed "+e);
		}
		return flag;
	}
	
	public void selectChat(String sGroupName) throws InterruptedException{
		searchIcon.click();
		searchTextField.sendKeys(sGroupName);
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sGroupName+"')]")).click();
		/*for(int i=0;i<ChatsList.size();i++){
			if(!ChatsList.get(i).getText().contains(sGroupName)){
				if(i == 4){
					Constant.swipingVertical_Down();
				}
			}else{
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sGroupName+"')]")).click();
				break;
			}
		}*/
	}
	
	public boolean sendTextMessage(){
		boolean flag = false;
		try{
			editTextMsg.sendKeys("test text message "+sDate);
			Thread.sleep(Constant.Min_Sleep);
			sendTextMsg.click();
			String sCurrent = Constant.CurrentTimeFormat();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]")).isDisplayed() && 
					driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to send text message "+e);
		}
		return flag;
		
	}
	
	public boolean sendTextMsg_GroupChat(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sGroupName = xls.get(rowNo).get("Group Name");
		try{
			selectChat(sGroupName);
			if(profileChatTitle.getText().contains(sGroupName)){
				flag = sendTextMessage();
				Thread.sleep(Constant.Min_Sleep);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Text message sent to group chat failed "+e);
		}
		return flag;
	}
	
	public boolean sendTextMsg_PersonalChat(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				flag = sendTextMessage();
				Thread.sleep(Constant.Min_Sleep);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Text message sent to personal chat failed "+e);
		}
		return flag;
	}
	
	public boolean sendTextMsg_PersonalChat_Selectingcontact(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				flag = sendTextMessage();
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Text message sent to personal chat selecting contact failed " +e);
		}
		return flag;
	}
	
	public boolean viewContactDetails(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String sNumber = null;
		try{
			chatContactsBtn.click();
			searchIcon.click();
			searchTextField.sendKeys(sUserName);
			sNumber = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sUserName+"')]/following::android.widget.TextView[@resource-id='com.schnell.taskassist:id/secondRowTextView'][1]")).getText();
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sUserName+"')]")).click();
			if(profileChatTitle.getText().contains(sUserName)){
				profileChatTitle.click();
				Constant.swipingVertical_Down();
				if(profilePhoneNumText.getText().contains(sNumber)){
					chatIconProfile.click();
					if(profileChatTitle.getText().contains(sUserName)){
						flag = true;
					}
					profilePicBtn.click();
				}
			}
		}catch(Exception e){
			System.err.println("Failed to view contact details "+e);
		}
		return flag;
	}
	
	public boolean sendEmojiNTextMsg(){
		boolean flag = false;
		try{
			editTextMsg.sendKeys("test emoticons message \ud83d\ude04 \ud83d\ude03 \ud83d\ude02 \ud83d\ude01 \ud83d\ude05 \ud83d\ude06"
					+ "\ud83d\ude07 \ud83d\ude08 \ud83d\ude09"+sDate);
			Thread.sleep(Constant.Min_Sleep);
			sendTextMsg.click();
			String sCurrent = Constant.CurrentTimeFormat();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]")).isDisplayed() && 
					driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to send text with emoji "+e);
		}
		return flag;
	}
	
	public boolean sendEmojiMsg(){
		boolean flag = false;
		try{
			editTextMsg.sendKeys("\ud83d\ude04 \ud83d\ude03 \ud83d\ude02 \ud83d\ude01 \ud83d\ude05 \ud83d\ude06"
					+ "\ud83d\ude07 \ud83d\ude08 \ud83d\ude09");
			Thread.sleep(Constant.Min_Sleep);
			sendTextMsg.click();
			String sCurrent = Constant.CurrentTimeFormat();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to send text with emoji "+e);
		}
		return flag;
	}
	
	public boolean sendEmojiNTextMsg_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				flag = sendEmojiNTextMsg();
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Sending emoji messages failed "+e);
		}
		return flag;
	}
	
	public boolean sendEmojiMessage_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				flag = sendEmojiMsg();
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Sending emoji messages failed "+e);
		}
		return flag;
	}
	
	public boolean attachImage(){
		boolean flag = false;
		try{
			attachmentBTn.click();
			galleryIcon.click();
			Thread.sleep(2000);
			new TouchAction(driver).press(52, 100).waitAction().release().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains("Open from")){
				new TouchAction(driver).press(137, 313).waitAction().release().perform();
				
			}
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Download')][@index='0']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Total Due pop up.png')][@index='0']")).click();
			imageCaptionTxt.sendKeys("testing image attachment \ud83d\ude04 \ud83d\ude03 "+sDate);
			sendImageBtn.click();
			String sCurrent = Constant.CurrentTimeFormat();
			Thread.sleep(Constant.Max_Sleep);
			if(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]/preceding::android.widget.RelativeLayout/android.widget.ImageView[1]")).isDisplayed() && 
					driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to attach image "+e);
		}
		return flag;
	}
	
	public boolean attachImage_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				flag = attachImage();
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Sending image to personal chat failed "+e);
		}
		return flag;
	}
	
	public boolean attachVideo(){
		boolean flag = false;
		try{
			attachmentBTn.click();
			videoAttachment.click();
			Thread.sleep(Constant.Min_Sleep);
			new TouchAction(driver).press(52, 100).waitAction().release().perform();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains("Open from")){
				new TouchAction(driver).press(137, 313).waitAction().release().perform();
			}
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Download')][@index='0']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'SampleVideo')][@index='0']")).click();
			Thread.sleep(Constant.Min_Sleep);
			imageCaptionTxt.sendKeys("testing video attachment \ud83d\ude04 \ud83d\ude03 "+sDate);
			sendImageBtn.click();
			String sCurrent = Constant.CurrentTimeFormat();
			Thread.sleep(Constant.Medium_Sleep);
			if(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]/preceding::android.widget.RelativeLayout/android.widget.ImageView[1]")).isDisplayed() && 
					driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to attach video "+e);
		}
		return flag;
	}
	
	public boolean attachvideo_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				flag = attachVideo();
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Sending video to personal chat failed "+e);
		}
		return flag;
	}
	
	public boolean attachDocument(String[] sDocType){
		boolean flag = false;
		try{
			for(int i=0;i<sDocType.length;i++){
				attachmentBTn.click();
				documentIcon.click();
				Thread.sleep(2000);
				new TouchAction(driver).press(52, 100).waitAction().release().perform();
				Thread.sleep(2000);
				if(driver.getPageSource().contains("Open from")){
					new TouchAction(driver).press(137, 313).waitAction().release().perform();
				}
				Thread.sleep(Constant.Min_Sleep);
				String sDocName = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDocType[i]+"')][@index='0']")).getText();
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDocType[i]+"')][@index='0']")).click();
				String sCurrent = Constant.CurrentTimeFormat();
				Thread.sleep(Constant.Medium_Sleep);
				if(sDocName.contains(attachedFileName.get(attachedFileName.size()-1).getText()) && 
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]")).isDisplayed()){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to attach document "+e);
		}
		return flag;
	}
	
	public boolean attachDocuments_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				Thread.sleep(2000);
				String[] sDocType = {"pdf", "xlsx", "xls", "docx", "doc"};
				flag = attachDocument(sDocType);
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Document attachment failed "+e);
		}
		return flag;
	}
	
	public boolean attachAudio(){
		boolean flag = false;
		try{
			attachmentBTn.click();
			audioIcon.click();
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Flaxen')][@index='0']")).click();
//			new TouchAction(driver).press(PointOption.point(615, 1030)).waitAction().release().perform();
			audioOkBtn.click();
			String sCurrent = Constant.CurrentTimeFormat();
			Thread.sleep(Constant.Medium_Sleep);
			if(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]/preceding::android.widget.SeekBar[1]")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Failed to attach video "+e);
		}
		return flag;
	}
	
	public boolean sendAudio_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				flag = attachAudio();
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Audio attachment failed "+e);
		}
		return flag;
	}
	
	public boolean validateCancelAudioAttach(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				attachmentBTn.click();
				audioIcon.click();
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Flaxen')][@index='0']")).click();
//				new TouchAction(driver).press(PointOption.point(615, 1030)).waitAction().release().perform();
				audioCancelBtn.click();
				if(!driver.getPageSource().contains(sTime)){
					flag = true;
				}
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Audio attachment failed "+e);
		}
		return flag;
	}
	
	public boolean createTask_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String sTaskName = null;
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				sendTextMessage();
				Thread.sleep(2000);
				new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]"))).perform();
				taskIcon.click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<taskList.size();i++){
					if(!taskList.get(i).getText().contains(sDate)){
						if(i == 4){
							i = i-4;
							Constant.swipingVertical_Down();
							continue;
						}
					}else{
						sTaskName = taskList.get(i).getText();
						break;
					}
				}
				Constant.swipingHorizontal_LR();
				String sBotMessage = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,"+sDate+") and @resource-id='com.schnell.taskassist:id/alertTitleTextView']")).getText();
				if(sBotMessage.contains("test text message "+sDate+":\nYou created new Task")
						&& sTaskName.contains("test text message "+sDate+"")){
					flag = true;
				}
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Failed to create task in personal chat "+e);
		}
		return flag;
	}
	
	public boolean updateTaskTargetDate(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String sTaskName = null,sNoOfDays = null,sChangedDate = null,sActualDate = null;
		String[] sTargetDate = {"1 Day","1 Week","1 Month"};
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				for(int j=0;j<sTargetDate.length;j++){
					switch(sTargetDate[j]){
						case "1 Month":
							sNoOfDays = Constant.lastDateOfMonth();
							break;
						case "1 Week":
							sNoOfDays = "7";
							break;
						case "1 Day":
							sNoOfDays = "1";
							break;
						
					}
					new TouchAction(driver).press(470, 430).waitAction().moveTo(23, 419).release().perform();
					sTaskName = taskList.get(0).getText();
					driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sTaskName+"')]/following::android.widget.TextView[@resource-id='com.schnell.taskassist:id/taskDueDateTextView'][1]")).click();
					sActualDate = Constant.NextDate(sNoOfDays);
					driver.findElement(By.xpath("//android.widget.TextView[contains( @text,'"+sTargetDate[j]+"')]")).click();
					Thread.sleep(Constant.Min_Sleep);
					for(int i=0;i<taskList.size();i++){
						if(!taskList.get(i).getText().contains(sTaskName)){
							if(i == 4){
								i = i-4;
								Constant.swipingVertical_Down();
								continue;
							}
						}else{
							sChangedDate = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sTaskName+"')]/following::android.widget.TextView[@resource-id='com.schnell.taskassist:id/taskDueDateTextView']")).getText();
							break;
							}
						}
						String sBotDate = new SimpleDateFormat("MMM dd, yyyy").format(Date.parse(sActualDate));
						Constant.swipingHorizontal_LR();
						Thread.sleep(Constant.Min_Sleep);
						int sIndex = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")).size();
						String sBotMessage = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='"+(sIndex-1)+"']/android.widget.TextView[contains(@text,'"+sTaskName+":\nTarget date is changed to ' ) and @resource-id='com.schnell.taskassist:id/alertTitleTextView'][1]")).getText();
						if(sBotMessage.contains(""+sTaskName+":\nTarget date is changed to '"+sBotDate+"' by You")){
							flag = true;
						}else{
							flag = false;
							break;
						}
				}
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Failed to update target date "+e);
		}
		return flag;
	}
	
	public boolean updateTaskStatusToComplete(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String sTaskName = null;
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				new TouchAction(driver).press(470, 430).waitAction().moveTo(23, 419).release().perform();
				sTaskName = taskList.get(0).getText();
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sTaskName+"')]/following::android.widget.ImageButton[1]")).click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.swipingHorizontal_LR();
				Thread.sleep(Constant.Min_Sleep);
				int sIndex = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")).size();
				String sBotMessage = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='"+(sIndex-1)+"']/android.widget.TextView[contains(@text,'"+sTaskName+"') and @resource-id='com.schnell.taskassist:id/alertTitleTextView'][1]")).getText();
				if(sBotMessage.contains(""+sTaskName+":\nTask has been completed by You")){
					flag = true;
				}
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Failed to update task status to complete "+e);
		}
		return flag;
	}
	
	public boolean updateTaskStatusToPending(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String sTaskName = null;
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				new TouchAction(driver).press(470, 430).waitAction().moveTo(23, 419).release().perform();
				filterIcon.click();
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Completed')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				sTaskName = taskList.get(0).getText();
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sTaskName+"')]/following::android.widget.ImageButton[1]")).click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.swipingHorizontal_LR();
				Thread.sleep(Constant.Min_Sleep);
				int sIndex = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")).size();
				String sBotMessage = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='"+(sIndex-1)+"']/android.widget.TextView[contains(@text,'"+sTaskName+"') and @resource-id='com.schnell.taskassist:id/alertTitleTextView'][1]")).getText();
				if(sBotMessage.contains(""+sTaskName+":\nTask has been reopened by You")){
					flag = true;
				}
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Failed to update task status to pending "+e);
		}
		return flag;
	}
	
	public boolean addTaskNValidateTaskTab(int iRowNo){
		boolean flag = false;
		try{
			createTask_Personal(iRowNo);
			back_Collapse.click();
			new TouchAction(driver).press(470, 487).waitAction().moveTo(7, 485).release().perform();
			Thread.sleep(Constant.Min_Sleep);
			taskSwitchBtn.click();
			for(int i=0;i<taskList.size();i++){
				if(!taskList.get(i).getText().contains(sDate)){
					if(i == 4){
						i = i-5;
						Constant.swipingVertical_Down();
						continue;
					}
				}else{
					flag = true;
					break;
					}
				}
			Constant.swipingHorizontal_LR();
		}catch(Exception e){
			System.err.println("Added task is not available in the task tab "+e);
		}
		return flag;
	}
	
	public boolean UpdateTargetDtTaskTab(){
		boolean flag = false;
		String sTaskName = null,sChangedDate = null,sActDate = null,sNoOfDays = null,sActualDate = null;
		String[] sTargetDate = {"1 Day","1 Week","1 Month"};
		try{
			Constant.swipingHorizontal_RL();
			Thread.sleep(Constant.Min_Sleep);
			taskSwitchBtn.click();
			for(int j=0;j<sTargetDate.length;j++){
				switch(sTargetDate[j]){
					case "1 Day":
						sNoOfDays = "1";
						break;
					case "1 Week":
						sNoOfDays = "7";
						break;
					case "1 Month":
						sNoOfDays = Constant.lastDateOfMonth();
						break;
				}
				sTaskName = taskList.get(1).getText();
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sTaskName+"')]/following::android.widget.TextView[@resource-id='com.schnell.taskassist:id/taskDueDateTextView']")).click();
				sActualDate = Constant.NextDate(sNoOfDays);
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sTargetDate[j]+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				for(int i=0;i<taskList.size();i++){
					if(!taskList.get(i).getText().contains(sTaskName)){
						if(i == 4){
							i = i-4;
							Constant.swipingVertical_Down();
							continue;
						}
					}else{
						sChangedDate = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sTaskName+"')]/following::android.widget.TextView[@resource-id='com.schnell.taskassist:id/taskDueDateTextView']")).getText();
						break;
					}
				}
				sActDate = new SimpleDateFormat("MMM dd, yyyy").format(Date.parse(sActualDate));
				if(sActDate.equals(sChangedDate)){
					flag = true;
				}else{
					flag = false;
					break;
				}
			}
			Constant.swipingHorizontal_LR();
		}catch(Exception e){
			System.err.println("Failed to update target date from task tab "+e);
		}
		return flag;
	}
	
	public boolean deleteMsg(int iRowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(iRowNo).get("User name");
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				sendTextMessage();
				new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]"))).perform();
				deleteMsg.click();
				driver.findElement(By.id("android:id/button1")).click();
				Thread.sleep(Constant.Min_Sleep);
				if(!driver.getPageSource().contains(sDate)){
					sendEmojiNTextMsg();
					new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]"))).perform();
					deleteMsg.click();
					driver.findElement(By.id("android:id/button1")).click();
					Thread.sleep(Constant.Min_Sleep);
					if(!driver.getPageSource().contains(sDate)){
						attachImage();
						new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]"))).perform();
						deleteMsg.click();
						driver.findElement(By.id("android:id/button1")).click();
						Thread.sleep(Constant.Min_Sleep);
						if(!driver.getPageSource().contains(sDate)){
							attachVideo();
							new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]"))).perform();
							deleteMsg.click();
							driver.findElement(By.id("android:id/button1")).click();
							Thread.sleep(Constant.Min_Sleep);
							if(!driver.getPageSource().contains(sDate)){
								String[] sDocName = {"pdf"};
								attachDocument(sDocName);
								new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat()+"')]"))).perform();
								deleteMsg.click();
								driver.findElement(By.id("android:id/button1")).click();
								Thread.sleep(Constant.Min_Sleep);
								if(!driver.getPageSource().contains(Constant.CurrentTimeFormat())){
									attachAudio();
									new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]"))).perform();
									deleteMsg.click();
									driver.findElement(By.id("android:id/button1")).click();
									Thread.sleep(Constant.Min_Sleep);
									if(!driver.getPageSource().contains(Constant.CurrentTimeFormat().substring(0,4))){
										flag = true;
									}
								}
							}
						}
					}
				}
				profilePicBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to delete message "+e);
		}
		return flag;
	}

	public boolean replyToAllMessages_text(int iRowNo) throws Exception{
		boolean flag = false, flag1,flag2, flag3, flag4, flag5, flag6, flag7;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(iRowNo).get("User name");
		String sReplyText;
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				//send text msg
				sendTextMessage();
				new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test text message "+sDate+"')]"))).perform();
				replyBtn.click();
				sReplyText = replyMsgTextView.getText();
				if(sReplyText.contains(sDate)){
					//reply as text msg
					flag1 = sendTextMessage();
					if(flag1 == true){
						//send emoticons
						sendEmojiNTextMsg();
						new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test emoticons message \ud83d\ude04 \ud83d\ude03 \ud83d\ude02 \ud83d\ude01 \ud83d\ude05 \ud83d\ude06"
								+ "\ud83d\ude07 \ud83d\ude08 \ud83d\ude09"+sDate+"')]"))).perform();
						replyBtn.click();
						sReplyText = replyMsgTextView.getText();
						if(sReplyText.contains(sDate)){
//							//reply to emoticons
							flag2 = sendTextMessage();
							if(flag2 == true){
								//send image
								attachImage();
								new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing image attachment')]"))).perform();
								replyBtn.click();
								sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
								if(sReplyText.contains(sDate)){
									//reply to image
									flag3 = sendTextMessage();
									if(flag3 == true){
									//send video
										attachVideo();
										Thread.sleep(Constant.Medium_Sleep);
										new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing video attachment')]"))).perform();
										replyBtn.click();
										sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
										if(sReplyText.contains(sDate)){
											//reply to video
											flag4 = sendTextMessage();
											if(flag4 == true){
												//send document
												String[] sDocType = {"pdf"};
												attachDocument(sDocType);
												Thread.sleep(Constant.Medium_Sleep);
												new TouchAction(driver).longPress(driver.findElement(By.id("com.schnell.taskassist:id/fileNameTextView"))).perform();
												replyBtn.click();
												sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/closeReplyIconText']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
												if(sReplyText.contains("Document")){
													//reply to document
													flag5 = sendTextMessage();
													if(flag5 == true){
														//send audio
														attachAudio();
														Thread.sleep(Constant.Min_Sleep);
														new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
														replyBtn.click();
														sReplyText = replyMsgTextView.getText();
														if(sReplyText.contains("Audio")){
															//reply to audio
															flag6 = sendTextMessage();
															if(flag6 == true){
																//send recorded audio
//																recordAudio();
//																Thread.sleep(Constant.Min_Sleep);
//																new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
//																replyBtn.click();
//																sReplyText = replyMsgTextView.getText();
//																if(sReplyText.contains("Audio")){
//																	//reply to recorded audio
//																	flag7 = sendTextMessage();
//																	if(flag7 == true){
																		flag = true;
//																	}
//																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					profilePicBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					}
				}
			}catch(Exception e){
				System.err.println("Failed to delete message "+e);
			}
			return flag;
		}
	
	public boolean replyToAllMessages_image(int iRowNo) throws Exception{
		boolean flag = false,flag1,flag2, flag3, flag4, flag5, flag6, flag7;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(iRowNo).get("User name");
		String sReplyText;
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				//send text msg
				sendTextMessage();
				new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test text message "+sDate+"')]"))).perform();
				replyBtn.click();
				sReplyText = replyMsgTextView.getText();
				if(sReplyText.contains(sDate)){
					//reply as image
					flag1 = attachImage();
					if(flag1 == true){
						//send emoticons
						sendEmojiNTextMsg();
						new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test emoticons message \ud83d\ude04 \ud83d\ude03 \ud83d\ude02 \ud83d\ude01 \ud83d\ude05 \ud83d\ude06"
								+ "\ud83d\ude07 \ud83d\ude08 \ud83d\ude09"+sDate+"')]"))).perform();
						replyBtn.click();
						sReplyText = replyMsgTextView.getText();
						if(sReplyText.contains(sDate)){
							//reply to emoticons
							flag2 = attachImage();
							if(flag2 == true){
								//send image
								attachImage();
								new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing image attachment')]"))).perform();
								replyBtn.click();
								sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
								if(sReplyText.contains(sDate)){
									//reply to image
									flag3 = attachImage();
									if(flag3 == true){
									//send video
										attachVideo();
										Thread.sleep(Constant.Max_Sleep);
										Thread.sleep(Constant.Min_Sleep);
										new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing video attachment')]"))).perform();
										replyBtn.click();
										sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
										if(sReplyText.contains(sDate)){
											//reply to video
											flag4 = attachImage();
											if(flag4 == true){
												//send document
												String[] sDocType = {"pdf"};
												attachDocument(sDocType);
												Thread.sleep(Constant.Medium_Sleep);
												new TouchAction(driver).longPress(driver.findElement(By.id("com.schnell.taskassist:id/fileNameTextView"))).perform();
												replyBtn.click();
												sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/closeReplyIconText']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
												if(sReplyText.contains("Document")){
													//reply to document
													flag5 = attachImage();
													if(flag5 == true){
														//send audio
														attachAudio();
														new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
														replyBtn.click();
														sReplyText = replyMsgTextView.getText();
														if(sReplyText.contains("Audio")){
															//reply to audio
															flag6 = attachImage();
															if(flag6 == true){
																//send recorded audio
//																recordAudio();
//																new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
//																replyBtn.click();
//																sReplyText = replyMsgTextView.getText();
//																if(sReplyText.contains("Audio")){
//																	//reply to recorded audio
//																	flag7 = attachImage();
//																	if(flag7 == true){
																		flag = true;
//																	}
//																}
															}
														}
													
													}
												}
											}
										}
									}
								}
							}
						}
					}
					profilePicBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					}
				}
			}catch(Exception e){
				System.err.println("Failed to delete message "+e);
			}
			return flag;
		}
	
	public boolean replyToAllMessages_Document(int iRowNo) throws Exception{
		boolean flag = false,flag1,flag2, flag3, flag4, flag5, flag6, flag7;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(iRowNo).get("User name");
		String sReplyText;
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				//send text msg
				sendTextMessage();
				new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test text message "+sDate+"')]"))).perform();
				replyBtn.click();
				sReplyText = replyMsgTextView.getText();
				if(sReplyText.contains(sDate)){
					//reply as Document
					String[] sDocType = {"pdf"};
					flag1 = attachDocument(sDocType);
					if(flag1 == true){
						//send emoticons
						sendEmojiNTextMsg();
						new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test emoticons message \ud83d\ude04 \ud83d\ude03 \ud83d\ude02 \ud83d\ude01 \ud83d\ude05 \ud83d\ude06"
								+ "\ud83d\ude07 \ud83d\ude08 \ud83d\ude09"+sDate+"')]"))).perform();
						replyBtn.click();
						sReplyText = replyMsgTextView.getText();
						if(sReplyText.contains(sDate)){
							//reply to Document
							flag2 = attachDocument(sDocType);
							if(flag2 == true){
								//send image
								attachImage();
								Thread.sleep(Constant.Medium_Sleep);
								new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing image attachment')]"))).perform();
								replyBtn.click();
								sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
								if(sReplyText.contains(sDate)){
									//reply to image
									flag3 = attachDocument(sDocType);
									if(flag3 == true){
									//send video
										attachVideo();
										Thread.sleep(Constant.Max_Sleep);
										Thread.sleep(Constant.Medium_Sleep);
										new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing video attachment')]"))).perform();
										replyBtn.click();
										sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/closeReplyIconImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
										if(sReplyText.contains(sDate)){
											//reply to video
											flag4 = attachDocument(sDocType);
											Thread.sleep(Constant.Min_Sleep);
											if(flag4 == true){
												//select document
												new TouchAction(driver).longPress(driver.findElement(By.id("com.schnell.taskassist:id/fileNameTextView"))).perform();
												replyBtn.click();
												sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/closeReplyIconText']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
												if(sReplyText.contains("Document")){
													//reply to Document
													flag5 = attachDocument(sDocType);
													if(flag5 == true){
														//send audio
														attachAudio();
														new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
														replyBtn.click();
														sReplyText = replyMsgTextView.getText();
														if(sReplyText.contains("Audio")){
															//reply to audio
															flag6 = attachDocument(sDocType);
															if(flag6 == true){
																//send recorded audio
//																recordAudio();
//																new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
//																replyBtn.click();
//																sReplyText = replyMsgTextView.getText();
//																if(sReplyText.contains("Audio")){
//																	//reply to recorded audio
//																	flag7 = attachDocument(sDocType);
//																	if(flag7 == true){
																		flag = true;
//																	}
//																}
															}
														}
													
													}
												}
											}
										}
									}
								}
							}
						}
					}
					profilePicBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					}
				}
			}catch(Exception e){
				System.err.println("Failed to delete message "+e);
			}
			return flag;
		}
	
	public boolean replyToAllMessages_Video(int iRowNo) throws Exception{
		boolean flag = false,flag1,flag2, flag3, flag4, flag5, flag6, flag7;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(iRowNo).get("User name");
		String sReplyText, sDocName, sTime;
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				//send text msg
				sendTextMessage();
				new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test text message "+sDate+"')]"))).perform();
				replyBtn.click();
				sReplyText = replyMsgTextView.getText();
				if(sReplyText.contains(sDate)){
					//reply as Document
					flag1 = attachVideo();
					if(flag1 == true){
						//send emoticons
						sendEmojiNTextMsg();
						new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test emoticons message \ud83d\ude04 \ud83d\ude03 \ud83d\ude02 \ud83d\ude01 \ud83d\ude05 \ud83d\ude06"
										+ "\ud83d\ude07 \ud83d\ude08 \ud83d\ude09"+sDate+"')]"))).perform();
						replyBtn.click();
						sReplyText = replyMsgTextView.getText();
						if(sReplyText.contains(sDate)){
							//reply to Document
							flag2 = attachVideo();
							if(flag2 == true){
								//send image
								attachImage();
								Thread.sleep(Constant.Min_Sleep);
								new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing image attachment')]"))).perform();
								replyBtn.click();
								sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
								if(sReplyText.contains(sDate)){
									//reply to image
									flag3 = attachVideo();
									Thread.sleep(Constant.Medium_Sleep);
									if(flag3 == true){
									//send video
										attachVideo();
										Thread.sleep(Constant.Max_Sleep);
										Thread.sleep(Constant.Medium_Sleep);
										new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing video attachment')]"))).perform();
										replyBtn.click();
										sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
										if(sReplyText.contains(sDate)){
											//reply to video
											flag4 = attachVideo();
											if(flag4 == true){
												//send document
												String[] sDocType = {"pdf"};
												attachDocument(sDocType);
												new TouchAction(driver).longPress(driver.findElement(By.id("com.schnell.taskassist:id/fileNameTextView"))).perform();
												replyBtn.click();
												sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/closeReplyIconText']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
												if(sReplyText.contains("Document")){
													//reply to Document
													flag5 = attachVideo();
													if(flag5 == true){
														//send audio
														attachAudio();
														new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
														replyBtn.click();
														sReplyText = replyMsgTextView.getText();
														if(sReplyText.contains("Audio")){
															//reply to audio
															flag6 = attachVideo();
															if(flag6 == true){
																//send recorded audio
//																recordAudio();
//																new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
//																replyBtn.click();
//																sReplyText = replyMsgTextView.getText();
//																if(sReplyText.contains("Audio")){
//																	//reply to recorded audio
//																	flag7 = attachVideo();
//																	if(flag7 == true){
																		flag = true;
//																	}
//																}
															}
														}
													
													}
												}
											}
										}
									}
								}
							}
						}
					}
					profilePicBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					}
				}
			}catch(Exception e){
				System.err.println("Failed to delete message "+e);
			}
			return flag;
		}
	
	public boolean replyToAllMessages_Audio(int iRowNo) throws Exception{
		boolean flag = false,flag1,flag2, flag3, flag4, flag5, flag6, flag7;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(iRowNo).get("User name");
		String sReplyText, sDocName, sTime;
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				//send text msg
				sendTextMessage();
				new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test text message "+sDate+"')]"))).perform();
				replyBtn.click();
				sReplyText = replyMsgTextView.getText();
				if(sReplyText.contains(sDate)){
					//reply as Document
					flag1 = attachAudio();
					if(flag1 == true){
						//send emoticons
						sendEmojiNTextMsg();
						new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test emoticons message \ud83d\ude04 \ud83d\ude03 \ud83d\ude02 \ud83d\ude01 \ud83d\ude05 \ud83d\ude06"
										+ "\ud83d\ude07 \ud83d\ude08 \ud83d\ude09"+sDate+"')]"))).perform();
						replyBtn.click();
						sReplyText = replyMsgTextView.getText();
						if(sReplyText.contains(sDate)){
							//reply to Document
							flag2 = attachAudio();
							if(flag2 == true){
								//send image
								attachImage();
								Thread.sleep(Constant.Medium_Sleep);
								new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing image attachment')]"))).perform();
								replyBtn.click();
								sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
								if(sReplyText.contains(sDate)){
									//reply to image
									flag3 = attachAudio();
									if(flag3 == true){
									//send video
										attachVideo();
										Thread.sleep(Constant.Max_Sleep);
										Thread.sleep(Constant.Medium_Sleep);
										new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing video attachment')]"))).perform();
										replyBtn.click();
										sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
										if(sReplyText.contains(sDate)){
											//reply to video
											flag4 = attachAudio();
											if(flag4 == true){
												//send document
												String[] sDocType = {"pdf"};
												attachDocument(sDocType);
												new TouchAction(driver).longPress(driver.findElement(By.id("com.schnell.taskassist:id/fileNameTextView"))).perform();
												replyBtn.click();
												sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/closeReplyIconText']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
												if(sReplyText.contains("Document")){
													//reply to Document
													flag5 = attachAudio();
													if(flag5 == true){
														//send audio
														attachAudio();
														new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
														replyBtn.click();
														sReplyText = replyMsgTextView.getText();
														if(sReplyText.contains("Audio")){
															//reply to audio
															flag6 = attachAudio();
															if(flag6 == true){
																//send recorded audio
//																recordAudio();
//																new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
//																replyBtn.click();
//																sReplyText = replyMsgTextView.getText();
//																if(sReplyText.contains("Audio")){
//																	//reply to recorded audio
//																	flag7 = attachVideo();
//																	if(flag7 == true){
																		flag = true;
//																	}
//																}
															}
														}
													
													}
												}
											}
										}
									}
								}
							}
						}
					}
					profilePicBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					}
				}
			}catch(Exception e){
				System.err.println("Failed to reply to "+e);
			}
			return flag;
		}
	
	public boolean recordAudio(){
		boolean flag = false;
		try{
			audioRecordBtn.click();
			Thread.sleep(Constant.Max_Sleep);
			sendTextMsg.click();
			String sCurrent = Constant.CurrentTimeFormat();
			Thread.sleep(Constant.Medium_Sleep);
			if(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]/preceding::android.widget.SeekBar[1]")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Unable to record audio "+e);
		}
		return flag;
	}
	
	public boolean sendRecordAudio_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				flag = recordAudio();
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Unable to record audio "+e);
		}
		return flag;
	}
	
	public boolean replyToAllMessages_RecordedAudio(int iRowNo) throws Exception{
		boolean flag = false,flag1,flag2, flag3, flag4, flag5, flag6, flag7;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(iRowNo).get("User name");
		String sReplyText, sDocName, sTime;
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				//send text msg
				sendTextMessage();
				new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test text message "+sDate+"')]"))).perform();
				replyBtn.click();
				sReplyText = replyMsgTextView.getText();
				if(sReplyText.contains(sDate)){
					//reply as Document
					flag1 = recordAudio();
					if(flag1 == true){
						//send emoticons
						sendEmojiNTextMsg();
						new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test emoticons message \ud83d\ude04 \ud83d\ude03 \ud83d\ude02 \ud83d\ude01 \ud83d\ude05 \ud83d\ude06"
										+ "\ud83d\ude07 \ud83d\ude08 \ud83d\ude09"+sDate+"')]"))).perform();
						replyBtn.click();
						sReplyText = replyMsgTextView.getText();
						if(sReplyText.contains(sDate)){
							//reply to Document
							flag2 = recordAudio();
							if(flag2 == true){
								//send image
								attachImage();
								new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing image attachment')]"))).perform();
								replyBtn.click();
								sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
								if(sReplyText.contains(sDate)){
									//reply to image
									flag3 = recordAudio();
									if(flag3 == true){
									//send video
										attachVideo();
										new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'testing video attachment')]"))).perform();
										replyBtn.click();
										sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/chatAttachmentReplyImageView']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
										if(sReplyText.contains(sDate)){
											//reply to video
											flag4 = recordAudio();
											if(flag4 == true){
												//send document
												String[] sDocType = {"PDF"};
												attachDocument(sDocType);
												new TouchAction(driver).longPress(driver.findElement(By.id("com.schnell.taskassist:id/fileNameTextView"))).perform();
												replyBtn.click();
												sReplyText = driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.schnell.taskassist:id/closeReplyIconText']/preceding::android.widget.TextView[@resource-id='com.schnell.taskassist:id/repleMessageTextView'][1]")).getText();
												if(sReplyText.contains("Document")){
													//reply to Document
													flag5 = recordAudio();
													if(flag5 == true){
														//send audio
														attachAudio();
														new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
														replyBtn.click();
														sReplyText = replyMsgTextView.getText();
														if(sReplyText.contains("Audio")){
															//reply to audio
															flag6 = recordAudio();
															if(flag6 == true){
																//send recorded audio
																recordAudio();
																new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+Constant.CurrentTimeFormat().substring(0,4)+"')]/preceding::android.widget.ImageView[@resource-id='com.schnell.taskassist:id/profileImageView']"))).perform();
																replyBtn.click();
																sReplyText = replyMsgTextView.getText();
																if(sReplyText.contains("Audio")){
																	//reply to recorded audio
																	flag7 = recordAudio();
																	if(flag7 == true){
																		flag = true;
																	}
																}
															}
														}
													
													}
												}
											}
										}
									}
								}
							}
						}
					}
					profilePicBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					}
				}
			}catch(Exception e){
				System.err.println("Failed to delete message "+e);
			}
			return flag;
		}
	
	public boolean validateCancelInRecording(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			chatContactsBtn.click();
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				audioRecordBtn.click();
				Thread.sleep(Constant.Max_Sleep);
				cancelRecordingBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(!driver.getPageSource().contains(sTime)){
					flag = true;
				}
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Failed to validate cancel button while recording "+e);
		}
		return flag;
	}
	
	public boolean copyNPasteTxtMsg_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String sAnotherUser = xls.get(rowNo).get("Another User");
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				sendTextMessage();
				new TouchAction(driver).longPress(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'test text message "+sDate+"')]"))).perform();
				optionsInChatDash.click();
				new TouchAction(driver).press(245, 80).waitAction().release().perform();
				Thread.sleep(2000);
				profilePicBtn.click();
			}
			closeSearchBtn.click();
			selectChat(sAnotherUser);
			if(profileChatTitle.getText().contains(sAnotherUser)){
				new TouchAction(driver).longPress(editTextMsg).waitAction().release().perform();
				Thread.sleep(Constant.Min_Sleep);
				new TouchAction(driver).press(94, 685).waitAction().release().perform();
				sendTextMsg.click();
				String sCurrent = Constant.CurrentTimeFormat();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]")).isDisplayed() && 
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]")).isDisplayed()){
					flag = true;
				}
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Failed to copy and paste text in other chat "+e);
		}
		return flag;
	}
	
	public boolean clickPickNSend_Personal(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			selectChat(sUserName);
			if(profileChatTitle.getText().contains(sUserName)){
				cameraIconChatScreen.click();
				Thread.sleep(2000);
				clickPhotoBtn.click();
				Thread.sleep(2000);
				clickDoneBtn.click();
				Thread.sleep(2000);
				imageCaptionTxt.sendKeys("testing image attachment \ud83d\ude04 \ud83d\ude03 "+sDate);
				sendImageBtn.click();
				String sCurrent = Constant.CurrentTimeFormat();
				Thread.sleep(Constant.Max_Sleep);
				if(driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]/preceding::android.widget.RelativeLayout/android.widget.ImageView[1]")).isDisplayed() && 
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sCurrent+"')]")).isDisplayed()){
					flag = true;
				}
				Thread.sleep(2000);
				profilePicBtn.click();
			}
		}catch(Exception e){
			System.err.println("Failed to click and send pic to personal chat "+e);
		}
		return flag;
	}
	
	public boolean updateProfileName(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			String sUsername = userNameInSettings.getText();
			userNameInSettings.click();
			editProfileNameBtn.click();
			editProfileNameTxt.clear();
			editProfileNameTxt.sendKeys("Automation"+sDate);
			okBtnUpdateProfileName.click();
			Thread.sleep(Constant.Medium_Sleep);
			String sUpdatedUsername = userNameInSettings.getText();
			if(!sUpdatedUsername.equals(sUsername)){
				flag = true;
			}
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to update profile name "+e);
		}
		return flag;
	}
	
	public boolean validateCancelBtnProfileName(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			String sUsername = userNameInSettings.getText();
			userNameInSettings.click();
			editProfileNameBtn.click();
			editProfileNameTxt.clear();
			editProfileNameTxt.sendKeys("Automation"+sDate);
			cancelBtnUpdateProfileName.click();
			String sUpdatedUsername = profileNameEdit_settings.getText();
			if(sUpdatedUsername.equals(sUsername)){
				flag = true;
			}
			backArrow.click();
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to update profile name "+e);
		}
		return flag;
	}
	
	public boolean EmptyProfileName(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			String sUsername = userNameInSettings.getText();
			userNameInSettings.click();
			editProfileNameBtn.click();
			editProfileNameTxt.clear();
			okBtnUpdateProfileName.click();
			String sUpdatedUsername = profileNameEdit_settings.getText();
			if(sUpdatedUsername.equals(sUsername)){
				flag = true;
			}
			backArrow.click();
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to update profile name "+e);
		}
		return flag;
	}
	
	public boolean updateProfilePic_Camera(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			userNameInSettings.click();
			cameraIconProfileSettings.click();
			cameraIcon_setting.click();
			Thread.sleep(2000);
			clickPhotoBtn.click();
			Thread.sleep(2000);
			clickDoneBtn.click();
			Thread.sleep(2000);
			cropImage.click();
			Thread.sleep(Constant.Medium_Sleep);
			if(userNameInSettings.isDisplayed()){
				flag = true;
			}
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to update profile pic with camera "+e);
		}
		return flag;
	}
	
	public boolean updateProfilePic_Gallery(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			userNameInSettings.click();
			cameraIconProfileSettings.click();
			galleryIcon.click();
			Thread.sleep(2000);
			new TouchAction(driver).press(52, 100).waitAction().release().perform();
			Thread.sleep(2000);
			if(driver.getPageSource().contains("Open from")){
				new TouchAction(driver).press(137, 313).waitAction().release().perform();
			}
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Download')][@index='0']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Total Due pop up.png')][@index='0']")).click();
			Thread.sleep(2000);
			cropImage.click();
			Thread.sleep(Constant.Medium_Sleep);
			if(userNameInSettings.isDisplayed()){
				flag = true;
			}
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to update profile pic with camera "+e);
		}
		return flag;
	}
	
	public boolean deleteProfilePic(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			String sUsername = userNameInSettings.getText();
			userNameInSettings.click();
			cameraIconProfileSettings.click();
			deleteIcon.click();
			Thread.sleep(Constant.Medium_Sleep);
			if(userNameInSettings.isDisplayed()){
				flag = true;
			}
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to update profile name "+e);
		}
		return flag;
	}
	
	public boolean cancelBtnProfilePic(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			String sUsername = userNameInSettings.getText();
			userNameInSettings.click();
			cameraIconProfileSettings.click();
			cancelBtnProfilePic.click();
			if(profileNameEdit_settings.isDisplayed()){
				flag = true;
			}
			backArrow.click();
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to validated cancel button in profile pic "+e);
		}
		return flag;
	}
	
	public boolean createGroupFromContacts(int rowNo) throws Exception{
		boolean flag = false;
		try{
			chatContactsBtn.click();
			newGroup.click();
			flag = createGroup(rowNo);
		}catch(Exception e){
			System.err.println("Failed to create group by clicking contacts icon "+e);
		}
		return flag;
	}
	
	public boolean createGroup(int rowNo) throws Exception{
		boolean flag = false,flag1 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String[] sUserList = sUserName.split(",");
		ArrayList<String> sSelectedList = new ArrayList<String>();
		try{
			if(createGrpBtn.isDisplayed()){
				for(int i=0;i<sUserList.length;i++){
					searchIcon.click();
					searchTextField.clear();
					searchTextField.sendKeys(sUserList[i]);
					if(ChatsList.get(i).getText().contains(sUserList[i])){
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sUserList[i]+"')]")).click();
					}
				}
				createGrpBtn.click();
				groupNameEditTxt.sendKeys("Automation \ud83d\ude04 \ud83d\ude03 "+sDate);
				for(int i=0;i<ChatsList.size();i++){
					sSelectedList.add(ChatsList.get(i).getText());
				}
				createGrpBtn.click();
				 for (String s : sUserList) {
			        if (sSelectedList.contains(s)) {
			            flag1 = true;
			        }else{
			        	flag1 = false;
			        }
				 }
				 selectChat(sDate);
				if(profileChatTitle.getText().contains("Automation \ud83d\ude04 \ud83d\ude03 "+sDate)  && dayBotMessage.getText().contains("TODAY")
						&& alertBotMsg.getText().contains("You created group Automation \ud83d\ude04 \ud83d\ude03 "+sDate) && flag1 == true){
					flag = sendTextMessage();
					Thread.sleep(Constant.Min_Sleep);
					profilePicBtn.click();
				}
			}
		}catch(Exception e){
			System.err.println("Failed to add group "+e);
		}
		return flag;
	}
	
	public boolean createGroupFromSettings(int rowNo) throws Exception{
		boolean flag = false;
		try{
			optionsInChatDash.click();
			newGroup.click();
			flag = createGroup(rowNo);
		}catch(Exception e){
			System.err.println("Failed to create group by clicking contacts icon "+e);
		}
		return flag;
	}
	
	public boolean emptyGrpDesc(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String[] sUserList = sUserName.split(",");
		try{
			optionsInChatDash.click();
			newGroup.click();
			if(createGrpBtn.isDisplayed()){
				for(int i=0;i<sUserList.length;i++){
					searchIcon.click();
					searchTextField.clear();
					searchTextField.sendKeys(sUserList[i]);
					if(ChatsList.get(i).getText().contains(sUserList[i])){
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sUserList[i]+"')]")).click();
					}
				}
				createGrpBtn.click();
				createGrpBtn.click();
				if(groupNameEditTxt.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to create group by clicking contacts icon "+e);
		}
		return flag;
	}
	
	public boolean createGrpWithProfilePic_Gallery(int rowNo) throws Exception{
		boolean flag = false,flag1;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String[] sUserList = sUserName.split(",");
		ArrayList<String> sSelectedList = new ArrayList<String>();
		try{
			optionsInChatDash.click();
			newGroup.click();
			if(createGrpBtn.isDisplayed()){
				for(int i=0;i<sUserList.length;i++){
					searchIcon.click();
					searchTextField.clear();
					searchTextField.sendKeys(sUserList[i]);
					if(ChatsList.get(i).getText().contains(sUserList[i])){
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sUserList[i]+"')]")).click();
					}
				}
				createGrpBtn.click();
				groupNameEditTxt.sendKeys("Automation \ud83d\ude04 \ud83d\ude03 "+sDate);
				for(int i=0;i<ChatsList.size();i++){
					sSelectedList.add(ChatsList.get(i).getText());
				}
				grpProfilePic.click();
				galleryIcon.click();
				Thread.sleep(2000);
				new TouchAction(driver).press(52, 100).waitAction().release().perform();
				Thread.sleep(2000);
				if(driver.getPageSource().contains("Open from")){
					new TouchAction(driver).press(137, 313).waitAction().release().perform();
				}
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Download')][@index='0']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Total Due pop up.png')][@index='0']")).click();
				Thread.sleep(2000);
				cropImage.click();
				Thread.sleep(Constant.Medium_Sleep);
				createGrpBtn.click();
				 for (String s : sUserList) {
			        if (sSelectedList.contains(s)) {
			            flag1 = true;
			        }else{
			        	flag1 = false;
			        }
				 }
				 selectChat(sDate);
				if(profileChatTitle.getText().contains("Automation \ud83d\ude04 \ud83d\ude03 "+sDate)  && dayBotMessage.getText().contains("TODAY")
						&& alertBotMsg.getText().contains("You created group Automation \ud83d\ude04 \ud83d\ude03 "+sDate)){
					flag = sendTextMessage();
					Thread.sleep(Constant.Min_Sleep);
					profilePicBtn.click();
				}
			}
		}catch(Exception e){
			System.err.println("Failed to create group by clicking contacts icon "+e);
		}
		return flag;
	}
	
	public boolean createGrpWithProfilePic_Camera(int rowNo) throws Exception{
		boolean flag = false,flag1;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String[] sUserList = sUserName.split(",");
		ArrayList<String> sSelectedList = new ArrayList<String>();
		try{
			optionsInChatDash.click();
			newGroup.click();
			if(createGrpBtn.isDisplayed()){
				for(int i=0;i<sUserList.length;i++){
					searchIcon.click();
					searchTextField.clear();
					searchTextField.sendKeys(sUserList[i]);
					if(ChatsList.get(i).getText().contains(sUserList[i])){
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sUserList[i]+"')]")).click();
					}
				}
				createGrpBtn.click();
				groupNameEditTxt.sendKeys("Automation \ud83d\ude04 \ud83d\ude03 "+sDate);
				for(int i=0;i<ChatsList.size();i++){
					sSelectedList.add(ChatsList.get(i).getText());
				}
				grpProfilePic.click();
				cameraIcon_setting.click();
				Thread.sleep(2000);
				clickPhotoBtn.click();
				Thread.sleep(2000);
				clickDoneBtn.click();
				Thread.sleep(2000);
				cropImage.click();
				Thread.sleep(Constant.Medium_Sleep);
				createGrpBtn.click();
				 for (String s : sUserList) {
			        if (sSelectedList.contains(s)) {
			            flag1 = true;
			        }else{
			        	flag1 = false;
			        }
				 }
				 selectChat(sDate);
				if(profileChatTitle.getText().contains("Automation \ud83d\ude04 \ud83d\ude03 "+sDate)  && dayBotMessage.getText().contains("TODAY")
						&& alertBotMsg.getText().contains("You created group Automation \ud83d\ude04 \ud83d\ude03 "+sDate)){
					flag = sendTextMessage();
					Thread.sleep(Constant.Min_Sleep);
					profilePicBtn.click();
				}
			}
		}catch(Exception e){
			System.err.println("Failed to create group by clicking contacts icon "+e);
		}
		return flag;
	}
	
	public boolean cancelValidation_GrpPic(int rowNo) throws Exception{
		boolean flag = false,flag1;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String[] sUserList = sUserName.split(",");
		ArrayList<String> sSelectedList = new ArrayList<String>();
		try{
			optionsInChatDash.click();
			newGroup.click();
			if(createGrpBtn.isDisplayed()){
				for(int i=0;i<sUserList.length;i++){
					searchIcon.click();
					searchTextField.clear();
					searchTextField.sendKeys(sUserList[i]);
					if(ChatsList.get(i).getText().contains(sUserList[i])){
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sUserList[i]+"')]")).click();
					}
				}
				createGrpBtn.click();
				groupNameEditTxt.sendKeys("Automation \ud83d\ude04 \ud83d\ude03 "+sDate);
				for(int i=0;i<ChatsList.size();i++){
					sSelectedList.add(ChatsList.get(i).getText());
				}
				grpProfilePic.click();
				cancelBtnProfilePic.click();
				flag1 = Constant.isElementPresent(By.id("com.schnell.taskassist:id/groupNameEditText"));
				if(flag1 = true){
					flag = true;
				}
				backArrow.click();
				back_Collapse.click();
				backArrow.click();
			}
		}catch(Exception e){
			System.err.println("Failed to create group by clicking contacts icon "+e);
		}
		return flag;
	}
	
	public boolean viewGrpParticipantContact(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String[] sUserList = sUserName.split(",");
		ArrayList<String> sSelectedList = new ArrayList<String>();
		try{
			createGroupFromContacts(rowNo);
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'"+sDate+"')]")).click();
			if(profileChatTitle.getText().contains("Automation \ud83d\ude04 \ud83d\ude03 "+sDate)){
				catchUpTitle.click();
				Constant.swipingVertical_Down();
				String[] sNoOfParticipants = noOfParticipants.getText().split("\\s+");
				for(int i=0;i<participantList.size();i++){
					if(!sSelectedList.contains(participantList.get(i).getText())){
						sSelectedList.add(participantList.get(i).getText());
					}
					if(sSelectedList.size() == Integer.parseInt(sNoOfParticipants[0])){
						break;
					}
					Constant.swipingVertical_Down();
				}
				 for (String s : sUserList) {
				        if (sSelectedList.contains(s)) {
				            flag = true;
				        }else{
				        	flag = false;
				        	break;
				        }
					 }
				backArrow.click();
			}
			Thread.sleep(Constant.Min_Sleep);
			profilePicBtn.click();
		}catch(Exception e){
			System.err.println("Failed to view group participant list "+e);
		}
		return flag;
	}
	
	public boolean chatWithAllParticipants(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		String[] sUserList = sUserName.split(",");
		ArrayList<String> sSelectedList = new ArrayList<String>();
		try{
			selectChat("Automation");
			if(profileChatTitle.getText().contains("Automation \ud83d\ude04 \ud83d\ude03 "+sDate)){
				catchUpTitle.click();
				String[] sNoOfParticipants = noOfParticipants.getText().split("\\s+");
				for(int i=0;i<Integer.parseInt(sNoOfParticipants[0]);i++){
					if(!ChatsList.get(i).getText().equals("You")){
						ChatsList.get(i).click();
						viewContact.click();
					}
					if(sSelectedList.size() == Integer.parseInt(sNoOfParticipants[0])){
						break;
					}
					Constant.swipingVertical_Down();
				}
				 for (String s : sUserList) {
				        if (sSelectedList.contains(s)) {
				            flag = true;
				        }else{
				        	flag = false;
				        }
					 }
				backArrow.click();
			}
			Thread.sleep(Constant.Min_Sleep);
			profilePicBtn.click();
		}catch(Exception e){
			System.err.println("Failed to view group participant list "+e);
		}
		return flag;
	}
	
	public boolean settingsComponentVerify(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			Thread.sleep(Constant.Min_Sleep);
			if(userNameInSettings.isDisplayed() && profilePicIcon_Settings.isDisplayed() && accountOption.isDisplayed()
					&& chatOption.isDisplayed() && inviteOption.isDisplayed() && helpOption.isDisplayed()){
				flag = true;
			}
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to verify settings components "+e);
		}
		return flag;
	}
	
	public boolean fontSizeVerify(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			Thread.sleep(Constant.Min_Sleep);
			chatOption.click();
			fontSize.click();
			if(fontSizePopUP.isDisplayed() && smallFont.isDisplayed() && mediumFont.isDisplayed()
					&& largeFont.isDisplayed()){
				flag = true;
			}
			cancel_FontSizePopup.click();
			backArrow.click();
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to verify font size components "+e);
		}
		return flag;
	}
	
	public boolean inviteFriendVerify(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sUserName = xls.get(rowNo).get("User name");
		try{
			optionsInChatDash.click();
			settingHeading.click();
			Thread.sleep(Constant.Min_Sleep);
			inviteOption.click();
			messagingOption_Invite.click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='"+sUserName+"']")).click();
			String sMsg = composeMsgTxt_Invite.getText();
			if(sMsg.equals("Hey, Check out Catch Up, I use it to message, manage my activities and tasks. Get it for free at https://play.google.com/store/apps/details?id=com.schnell.taskassist")){
				flag = true;
			}
			sendMsgBtn_Invite.click();
			Thread.sleep(Constant.Min_Sleep);
			backArrow.click();
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to verify invite friend option "+e);
		}
		return flag;
	}
	
	public boolean helpComponentVerify(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			Thread.sleep(Constant.Min_Sleep);
			helpOption.click();
			if(faq_Help.isDisplayed() && contactUs_Help.isDisplayed() && privacyPolicy_Help.isDisplayed() && appInfo_Help.isDisplayed()){
				flag = true;
			}
			backArrow.click();
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to verify help option components "+e);
		}
		return flag;
	}
	
	public boolean chatBackUpBtnVerify(){
		boolean flag = false;
		try{
			optionsInChatDash.click();
			settingHeading.click();
			Thread.sleep(Constant.Min_Sleep);
			chatOption.click();
			chatBackUPOption.click();
			if(chatBackUPBtn.isDisplayed()){
				flag = true;
			}
			backArrow.click();
			backArrow.click();
			backArrow.click();
		}catch(Exception e){
			System.err.println("Failed to verify Chat back up button availability "+e);
		}
		return flag;
	}
	
	public boolean verifyBackUPBtn(){
		boolean flag = false;
		String sDate = Constant.NormalDateFormat();
		String date = Constant.CurrentDate();
		try{
			optionsInChatDash.click();
			settingHeading.click();
			Thread.sleep(Constant.Min_Sleep);
			chatOption.click();
			chatBackUPOption.click();
			chatBackUPBtn.click();
			String sTime = Constant.CurrentTimeFormat();
			driver.pressKeyCode(AndroidKeyCode.HOME);
			allAppIcon.click();
			allAppSearchIcon.click();
			allAppSearchField.sendKeys("Setting");
			driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();
			settingsSearchIcon.click();
			settingsSearchField.sendKeys("Storage");
			driver.findElement(By.xpath("//android.widget.TextView[@text='Internal storage']")).click();
			Thread.sleep(2000);
			Constant.swipingVertical_Down();
			driver.findElement(By.xpath("//android.widget.TextView[@text='Other']")).click();
			driver.findElement(By.xpath("//android.widget.Button[@text='Explore']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='CatchUp']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='Backup']")).click();
			menuSortOption.click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='By date modified']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='"+sDate+"']")).click();
			menuSortOption.click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='By date modified']")).click();
			String sActTime = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'DB_"+date+"')]/following::android.widget.LinearLayout/android.widget.TextView[@index='0'][1]")).getText();
			if(sTime.contains(sActTime)){
				flag = true;
			}
			driver.pressKeyCode(AndroidKeyCode.HOME);
			allAppIcon.click();
			allAppSearchIcon.click();
			allAppSearchField.sendKeys("Catch Up");
			driver.findElement(By.xpath("//android.widget.TextView[@text='Catch Up']")).click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to Back up file location "+e);
		}
		return flag;
	}
	
	public boolean WarningMSg_invalidBackupFile(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sMobileNumber = xls.get(rowNo).get("Mobile number");
		String sOTP = xls.get(rowNo).get("OTP");
		try{
			driver.resetApp();
			if(enterPhoneNum.isDisplayed()){
				enterPhoneNum.sendKeys(sMobileNumber);
				verifyPhoneNum.click();
				Thread.sleep(Constant.Min_Sleep);
				if(enterOTP.isDisplayed()){
					enterOTP.sendKeys(sOTP);
					loginBtn.click();
					Thread.sleep(Constant.Medium_Sleep);
					if(!profileNameEdit.getText().isEmpty()){
						profileNextBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						if(backUPPopup.isDisplayed()){
							yes_backUPPopup.click();
						}
						allowPermission.click();
						Thread.sleep(2000);
						new TouchAction(driver).press(52, 100).waitAction().release().perform();
						Thread.sleep(2000);
						if(driver.getPageSource().contains("Open from")){
							new TouchAction(driver).press(146, 513).waitAction().release().perform();
						}
						Thread.sleep(Constant.Min_Sleep);
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'pdf')][@index='0']")).click();
						if(backUpFailedPopup.isDisplayed() && popUpMsg.getText().contains("Oops! looks like that file is corrupted. Do you have any other backup file?")){
							flag = true;
							no_backUPPopup.click();
							allowPermission.click();
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate warning message for invalid back up file selection"+e);
		}
		return flag;
	}
	
	public boolean retriveMsgsBackUPFile(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_CatchUp(),"catch up"); 
		String sMobileNumber = xls.get(rowNo).get("Mobile number");
		String sOTP = xls.get(rowNo).get("OTP");
		try{
			driver.resetApp();
			if(enterPhoneNum.isDisplayed()){
				enterPhoneNum.sendKeys(sMobileNumber);
				verifyPhoneNum.click();
				Thread.sleep(Constant.Min_Sleep);
				if(enterOTP.isDisplayed()){
					enterOTP.sendKeys(sOTP);
					loginBtn.click();
					Thread.sleep(Constant.Medium_Sleep);
					if(!profileNameEdit.getText().isEmpty()){
						profileNextBtn.click();
						if(backUPPopup.isDisplayed()){
							yes_backUPPopup.click();
						}
						allowPermission.click();
						Thread.sleep(2000);
						new TouchAction(driver).press(52, 100).waitAction().release().perform();
						Thread.sleep(2000);
						if(driver.getPageSource().contains("Open from")){
							new TouchAction(driver).press(183, 596).waitAction().release().perform();
						}
						Thread.sleep(Constant.Min_Sleep);
						driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'pdf')][@index='0']")).click();
						if(backUpFailedPopup.isDisplayed() && popUpMsg.getText().contains("Oops! looks like that file is corrupted. Do you have any other backup file?")){
							flag = true;
							no_backUPPopup.click();
						}
					}
				}
			}
		}catch(Exception e){
			System.err.println("Failed to validate warning message for invalid back up file selection"+e);
		}
		return flag;
	}
}

