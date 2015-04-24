package com.kangdainfo.common.view.sys.ap;

import java.util.ArrayList;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;

public class SYSAP401F extends SuperBean {
	private String id;
	private String userEmail;
	private String userBirthday;

	public String getId() {
		return checkGet(id);
	}

	public void setId(String id) {
		this.id = checkSet(id);
	}

	public String getUserEmail() {
		return checkGet(userEmail);
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = checkSet(userEmail);
	}

	public String getUserBirthday() {
		return checkGet(userBirthday);
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = checkSet(userBirthday);
	}
	
	public void doUpdateForgetPWD() throws Exception {
		CommonUser c = (CommonUser)View.getObject("from CommonUser where userEmail = " + Common.sqlChar(getUserEmail()) 
							+ " and userBirthday = " + Common.sqlChar(Datetime.getYYYYMMDDFromRocDate(getUserBirthday())));
		try{
			if(c != null){
				String randomPWD = Common.getRandomPassword(8); //取亂數密碼8碼
				
				c.setUserPwd(Common.getDigestString(randomPWD, "SHA-1"));
				c.setUserPwdModDt(null);
				ServiceGetter.getInstance().getCommonService().update(c);
				
				System.out.println("亂數密碼 == " + randomPWD);
				System.out.println("亂數密碼 == " + Common.getDigestString(randomPWD, "SHA-1"));
				
				if(!"".equals(Common.get(c.getUserEmail()))){
					String subject = "系統郵件:您查詢的密碼";
					String mailBody = "密碼:" + randomPWD;
					
					java.util.List<javax.mail.internet.InternetAddress> mailList = new java.util.ArrayList<javax.mail.internet.InternetAddress>();
					javax.mail.internet.InternetAddress mail = new javax.mail.internet.InternetAddress();
					mail.setAddress(Common.get(c.getUserEmail()));
					mailList.add(mail);
					
					if(mailList.size() > 0){
						ServiceGetter.getInstance().getCommonService().sendEmail(subject, mailBody, mailList, null);
						this.setStateUpdateSuccess();
						this.setErrorMsg("請至信箱檢視信件，謝謝!");
					}
					else{
						System.out.println("無Email資料");
					}				
				}
			}
			else{
				this.setErrorMsg("查無資料！");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@Override
	public void doUpdate() throws Exception {

	}
	
	@Override
	public Object doQueryOne() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doCreate() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void doDelete() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList doQueryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
