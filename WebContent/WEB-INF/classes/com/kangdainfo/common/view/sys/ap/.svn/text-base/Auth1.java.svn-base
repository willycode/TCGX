package com.kangdainfo.common.view.sys.ap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonAuth;
import com.kangdainfo.common.model.bo.CommonConfig;
import com.kangdainfo.common.model.bo.CommonDepartment;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.model.bo.CommonUserRole;
import com.kangdainfo.common.model.bo.CommonVisitLogDetail;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.ctis.model.bo.CenterMemberInfo;
import com.kangdainfo.ctis.model.bo.CtMemberInfo;
import com.kangdainfo.web.util.WebConstants;

public class  Auth1 extends SuperBean{
	String loginAccount;
	String loginIP ;	//使用者登入的IP
	String loginPassword ;
	String script;
	
	public String getLoginAccount() {
		return checkGet(loginAccount);
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = checkSet(loginAccount);
	}

	public String getLoginIP() {
		return checkGet(loginIP);
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = checkSet(loginIP);
	}

	public String getLoginPassword() {
		return checkGet(loginPassword);
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = checkSet(loginPassword);
	}

	public String getScript() {
		return checkGet(script);
	}

	public void setScript(String script) {
		this.script = checkSet(script);
	}

	public String loginCheck(HttpServletRequest request,HttpSession session) throws Exception
	{
		//1.判斷是法師還是學員
		if (loginAccount.indexOf("@")>0)  //此時帳號會是Email	
		{
			//學員
			String ip=Common.formatIPv4(loginIP);
			//利用loginIP的C網段，取得CommonDepartment;
			CommonDepartment commonDepartment = (CommonDepartment)View.getObject("from CommonDepartment where unitStartIp <= "+Common.sqlChar(ip)+" and unitEndIp >="+Common.sqlChar(ip));
			//用CommonDepartment與 loginAccount 取得CENTER_MEMBER_INFO;  //這是學員與精舍的關係，內含學員精舍編號
			CenterMemberInfo centerMemberInfo =(CenterMemberInfo)View.getObject("select A from CenterMemberInfo A, CtMemberInfo B where A.ctMemberId=B.ctMemberId and B.email1 = "+Common.sqlChar(loginAccount)+"  and A.unitId= "+ Common.sqlChar(commonDepartment.getUnitId()) );
		
			System.out.println(centerMemberInfo);
			if (null!=centerMemberInfo)
			{
				
				String centerMemberId = centerMemberInfo.getCenterMemberId(); 		//這才是真正的帳號
				//用 userId這個欄位=memberCode  查詢CommonUser;
			//	CommonUser commonUser = (CommonUser) View.getObject("from CommonUser where userId ="+Common.sqlChar(centerMemberId));
				CommonUser commonUser = (CommonUser) View.getObject("from CommonUser where userId ="+Common.sqlChar(loginAccount));
				System.out.println(centerMemberId);
				if (null!=commonUser)
				{
					//取id=1的一筆;
					CommonConfig commonConfig = (CommonConfig) View.getObject("from CommonConfig where id =1 ");
					
					if (null==commonUser.getPasswordErrorTimes()) commonUser.setPasswordErrorTimes(0);
					if (commonUser.getPasswordErrorTimes() < Integer.parseInt(commonConfig.getField1()))//數字比對
					{
						if (commonUser.getUserPwd().equals(Common.getDigestString(loginPassword,"SHA-1"))/*commonUser密碼與 loginPassword 編碼後比對相同 */)   //編碼方式    Common.getDigestString(loginPassword,"SHA-1")
						{
							//密碼對了，執行密碼正確步驟
					         Date now = new Date();
					         java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
					         System.out.println("LastChangePwd="+commonUser.getLastChangePwd());
					         
							if (commonUser.getLastChangePwd().compareTo(formatter.format(Datetime.dateFlipMonth(now,-3)))<0){
								System.out.println("三個月前="+formatter.format(Datetime.dateFlipMonth(now,-3)));
								script = "7001";   //變更密碼
							}
								
							else{
								script = "0";
							}
								

						} else {
							//密碼錯誤，執行密碼錯誤步驟
							script = "9004";
							//update CommonUser set passwordErrorTimes=passwordErrorTimes+1, lastPasswordErrorTime= new Date();
				     		commonUser.setPasswordErrorTimes(commonUser.getPasswordErrorTimes()+1);
							commonUser.setLastPasswordErrorTime(new Date());
							ServiceGetter.getInstance().getCommonService().getCommonUserDao().updateCommonUser(commonUser);	
							ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(commonUser, loginIP, "1", "N", "9004:密碼錯誤，帳號："+loginAccount+"，IP："+loginIP+"，精舍："+commonDepartment.getUnitId());
						}	
					} else {
						//密碼連續錯誤次數過多
						script = "9007";
						ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(commonUser, loginIP, "1", "N", "9007:密碼輸入錯誤連續"+commonUser.getPasswordErrorTimes()+"次，帳號已經被鎖定，帳號："+loginAccount+"，IP："+loginIP+"，精舍："+commonDepartment.getUnitId());
					}
				} else {
					//精舍有學員資料但沒有建立帳號，因為帳號要特別建立
					script = "9003";
					ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(loginAccount, loginIP, "1", "N", "9003:該學員在精舍未建立帳號，帳號："+loginAccount+"，IP："+loginIP+"，精舍："+commonDepartment.getUnitId());
				}
			} else {
				//用Email欄位=loginAccount  讀取Unique;
				CtMemberInfo ctMemberInfo = (CtMemberInfo)View.getObject("from CtMemberInfo where email1 ="+Common.sqlChar(loginAccount));
				if (null!=ctMemberInfo) 
				{
					//有學員資料，但沒有在這家精舍註冊過
					script= "9002";
					ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(loginAccount, loginIP, "1", "N", "9002:該學員未在精舍註冊，帳號："+loginAccount+"，IP："+loginIP+"，精舍："+commonDepartment.getUnitId());
				} else {
					//沒有這個Email
					script = "9001";
					ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(loginAccount, loginIP, "1", "N", "9001:Unique沒有這個Email，帳號："+loginAccount+"，IP："+loginIP+"，精舍："+commonDepartment.getUnitId());
				}
			}
		} 
		else {
		
			//法師
			//用 userId這個欄位=loginAccount 查詢CommonUser;
			CommonUser commonUser = (CommonUser) View.getObject(" from CommonUser where userId = "+Common.sqlChar(loginAccount));
			if (null!=commonUser)
			{
				//取id=1的一筆;
				CommonConfig commonConfig = (CommonConfig) View.getObject("from CommonConfig where id =1 ");
				if (null==commonUser.getPasswordErrorTimes()) commonUser.setPasswordErrorTimes(0);
				if (commonUser.getPasswordErrorTimes() < Integer.parseInt(commonConfig.getField1()))   //數字比對
				{
					if (commonUser.getUserPwd().equals(Common.getDigestString(loginPassword,"SHA-1")) )   //編碼方式    Common.getDigestString(loginPassword,"SHA-1")
					{
						Boolean contain =false;
						if(!contain)
						{
							String[] deptIpMap = new String[2];
							
						deptIpMap[0]=commonUser.getCommonDepartment().getUnitStartIp();
						deptIpMap[1]=commonUser.getCommonDepartment().getUnitEndIp();
						String ip=(Common.formatIPv4(loginIP));
					
						
						
						String	start =Common.formatIPv4(deptIpMap[0].toString());
						String	end= Common.formatIPv4(deptIpMap[1].toString());
						System.out.println("xxxxxx"+start);
						System.out.println("xxxxxx"+end);
						if(ip.compareTo(start)>=0&&ip.compareTo(end)<=0)
						{
							System.out.println("xxxxxx");
						    	contain =true;
						    	
						}
						
						
						}
						
						//密碼正確，比對IP
//TODO 待修改，先調整CommonUnlimitIp，並且存檔前要經過Common.formatIPv4，除此還有單位存檔也要改
						//List<String[]> ips = new LinkedList<String[]>(); 
						if(!contain){
						java.util.List ips = null;
						if (null != commonUser.getAllowLoginAtCT() && commonUser.getAllowLoginAtCT())
						{
							//所有COMMON_UNLIMIT_IP資料;
							//ips = ServiceGetter.getInstance().getCommonService().getCommonGroupDao().load("select startIp,endIp from CommonUnlimitIp");
				 ips=ServiceGetter.getInstance().getCommonService().load("select startIp,endIp from CommonUnlimitIp");
						}
//						String[] deptIpMap = new String[2];
//						
//						deptIpMap[0]=commonUser.getCommonDepartment().getUnitStartIp();
//						deptIpMap[1]=commonUser.getCommonDepartment().getUnitEndIp();
//						
//						ips.add(deptIpMap);
//						String ip=Common.formatIPv4(loginIP);
//						//利用loginIP的C網段，取得CommonDepartment;
//						CommonDepartment commonDepartment = (CommonDepartment)View.getObject("from CommonDepartment where unitStartIp <= "+Common.sqlChar(ip)+" and unitEndIp >="+Common.sqlChar(ip));
//System.out.println(loginIP);
//System.out.println(Common.formatIPv4(loginIP));

						
						if (ips!=null && ips.size()>0) 
						{
							String ip=(Common.formatIPv4(loginIP));
							String start = null;
							String end = null;
						//	for (String[] map:ips)
							for (int i=0; i<ips.size(); i++) 
							{
								
								Object [] o = (Object[]) ips.get(i);
								
								System.out.println(o[0]);
								System.out.println(o[1]);
								start =Common.formatIPv4(o[0].toString());
								end= Common.formatIPv4(o[1].toString());
								    	
	                        	if(ip.compareTo(start)>=0&&ip.compareTo(end)<=0)
								{
								    		contain =true;
								    		continue;
								}
									
							}
						}
						}
						System.out.println(contain);
						if (contain)//loginIP在ips的任一筆的c網段內)  //需要寫一個method
						{
							//登入者IP在精舍網段內，正常登入
							script = "0";
						} else {
							//IP網段錯誤
							script = "9006";
							ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(commonUser, loginIP, "1", "N", "9006:IP網段錯誤，帳號："+loginAccount+"，IP："+loginIP);
						}
					} else {
						//密碼錯誤
						script = "9004";
						commonUser.setPasswordErrorTimes(commonUser.getPasswordErrorTimes()+1);
						commonUser.setLastPasswordErrorTime(new Date());
						ServiceGetter.getInstance().getCommonService().getCommonUserDao().updateCommonUser(commonUser);	
						//update CommonUser set passwordErrorTimes=passwordErrorTimes+1, lastPasswordErrorTime= new Date();
						ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(commonUser, loginIP, "1", "N", "9004:密碼錯誤，帳號："+loginAccount+"，IP："+loginIP);					
					}
				} 
				else 
				{
					//密碼連續錯誤次數過多
					script = "9007";
					ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(commonUser, loginIP, "1", "N", "9007:密碼輸入錯誤連續"+commonUser.getPasswordErrorTimes()+"次，帳號已經被鎖定，帳號："+loginAccount+"，IP："+loginIP);
				}
			} else {
				//沒有帳號
				script = "9003";
				ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(loginAccount, loginIP, "1", "N", "9003:尚未建立帳號，帳號："+loginAccount+"，IP："+loginIP);
			}
		}
		
		if ("0".equals(script)||"7001".equals(script))
		{
			
			CommonUser commonUser1 = (CommonUser) View.getObject("from CommonUser where 1=1 and userId="+Common.sqlChar(loginAccount));
			commonUser1.setPasswordErrorTimes(0);
			commonUser1.setLastPasswordErrorTime(null);
			//update CommonUser set passwordErrorTimes=0, lastPasswordErrorTime=null;
			ServiceGetter.getInstance().getCommonService().getCommonUserDao().updateCommonUser(commonUser1);	
			
			CommonVisitLogDetail objLog = (CommonVisitLogDetail) View.getObject("from CommonVisitLogDetail where userId="+Common.sqlChar(commonUser1.getUserId()) + " order by id desc");
			if (objLog!=null) {  //把上次登入填入，顯示用
				commonUser1.setLastLoginDate(Common.get(objLog.getLogDate()));
				commonUser1.setLastLoginTime(Common.get(objLog.getLogTime()));
				commonUser1.setLastLoginIP(Common.get(objLog.getUserIP()));			
			} else {
				commonUser1.setLastLoginDate("");
				commonUser1.setLastLoginTime("");
				commonUser1.setLastLoginIP("");
			}
			ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(commonUser1, loginIP, "1", "Y", "");
			CommonUserRole userRole = new CommonUserRole();
			userRole.setId(commonUser1.getId());
			userRole.setRoleId(commonUser1.getRoleId());
			userRole.setCommonGroup(commonUser1.getCommonGroup());
			
			CommonDepartment objDept = commonUser1.getCommonDepartment();
			CommonAuth[] commonAuth = ServiceGetter.getInstance().getCommonService().getCommonAuthDao().getPermission("-11",userRole);
			if (commonAuth!=null && commonAuth.length>0)
			{
				java.util.Map<String, Object[]> permissionMap = ServiceGetter.getInstance().getCommonService().getCommonAuthDao().getPermissionMap(commonAuth);				
								
				//取得使用者權限 //session.getId()
				//user.setCommonAuth(commonAuth);
				commonUser1.setPermissionMap(permissionMap);
				commonUser1.setSessionId(session.getId());
				commonUser1.setLoginDate(Datetime.getYYYMMDD());
				commonUser1.setLoginTime(Datetime.getHHMMSS());
				commonUser1.setUserIP(Common.checkGet(request.getHeader("REMOTE_ADDR")));							
				session.setAttribute("UserRole",userRole);
				session.setAttribute(WebConstants.SESSION_CURRENT_USER,commonUser1);			
				session.setAttribute(WebConstants.SESSION_CURRENT_USER_DEPARTMENT,objDept);
				session.setAttribute(WebConstants.SESSION_CURRENT_SYSTEM_ID, "-11");
				
				
			} else {
				//未設定權限
				script = "9005";
				ServiceGetter.getInstance().getCommonService().saveCommonVisitLog(commonUser1, loginIP, "1", "N", "9005:未設定權限，帳號："+loginAccount+"，IP："+loginIP+"，精舍："+objDept.getUnitId());
			}
		}
		
		return script;
		
	}

	@Override
	public Object doQueryOne() throws Exception {
		return null;
	}

	@Override
	public ArrayList doQueryAll() throws Exception {
		return null;
	}

	@Override
	public void doCreate() throws Exception {
	}

	@Override
	public void doUpdate() throws Exception {
	}

	@Override
	public void doDelete() throws Exception {
	}
}



