/**
 * Copyright (c) 2000-2005 Kangda, Inc All Rights Reserved.
 */
package com.kangdainfo.common.service;

import com.kangdainfo.common.model.bo.CommonAppSetting;
import com.kangdainfo.common.model.bo.CommonUser;
import com.kangdainfo.common.model.dao.CommonAuthDao;
import com.kangdainfo.common.model.dao.CommonCodeDao;
import com.kangdainfo.common.model.dao.CommonCodeKindDao;
import com.kangdainfo.common.model.dao.CommonDepartmentDao;
import com.kangdainfo.common.model.dao.CommonDtreeDao;
import com.kangdainfo.common.model.dao.CommonGroupDao;
import com.kangdainfo.common.model.dao.CommonNewsDao;
import com.kangdainfo.common.model.dao.CommonUserDao;
import com.kangdainfo.common.model.dao.CommonUserRoleDao;
import com.kangdainfo.util.net.FtpRoutingContext;

public interface CommonService extends com.kangdainfo.persistence.BaseDao {
	
	/**
	 * 取得子系統資訊
	 * @return
	 */
	public java.util.List<com.kangdainfo.common.model.bo.SubSystem> getSubSystems();
	public void setSubSystems(java.util.List<com.kangdainfo.common.model.bo.SubSystem> subSystems);
	public com.kangdainfo.common.model.bo.SubSystem getSubSystemById(int sid);
	
	/**
	 * 權限設定資料
	 * @return
	 */
	public CommonAuthDao getCommonAuthDao();	
	public void setCommonAuthDao(CommonAuthDao obj);
	
	
	/**
	 * 取得共用代碼類別資料
	 * @return
	 */
	public CommonCodeKindDao getCommonCodeKindDao();
	public void setCommonCodeKindDao(CommonCodeKindDao obj);
	
	/**
	 * 取得共用代碼資料
	 * @return
	 */
	public CommonCodeDao getCommonCodeDao();
	public void setCommonCodeDao(CommonCodeDao obj);
	
	
	/**
	 * 取得機關代碼資料
	 * @return
	 */
	public CommonDepartmentDao getCommonDepartmentDao();
	public void setCommonDepartmentDao(CommonDepartmentDao obj);
	
	/**
	 * 取得功能選單物件
	 * @return
	 */
	public CommonDtreeDao getCommonDtreeDao();
	public void setCommonDtreeDao(CommonDtreeDao obj);	

	/**
	 * 群組資料
	 * @return
	 */
	public CommonGroupDao getCommonGroupDao();
	public void setCommonGroupDao(CommonGroupDao commonGroupDao);
		
	/**
	 * 最新消息
	 * @return
	 */
	public CommonNewsDao getCommonNewsDao();
	public void setCommonNewsDao(CommonNewsDao obj);	
	
	/**
	 * 取得使用者資料
	 * @return
	 */
	public CommonUserDao getCommonUserDao();
	public void setCommonUserDao(CommonUserDao obj);
	
	/**
	 * 使用者群組和角色資料
	 * @return
	 */
	public CommonUserRoleDao getCommonUserRoleDao();
	public void setCommonUserRoleDao(CommonUserRoleDao obj);	
	

	/**
	 * 使用者忘記密碼時用
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public boolean updateAndResetUserPassword(CommonUser obj) throws Exception;	

	/**
	 * 登入時產生VisitLog
	 * @param obj
	 * @throws Exception
	 */
	public void saveCommonVisitLog(CommonUser obj, String ip, String logAction, String logStatus, String logMsg) throws Exception;
	public void saveCommonVisitLog(String loginAccount, String ip, String logAction, String logStatus, String logMsg) throws Exception;
	
	public void sendEmail(String subject, String mailBody, java.util.List<javax.mail.internet.InternetAddress> mailList, java.util.List<String> attFilePathList);
	public void sendEmail(String subject, String mailBody, java.util.List<javax.mail.internet.InternetAddress> mailList, java.util.List<String> attFilePathList, boolean isHTML);
	
	/**
	 * 寫入訊息讀取紀錄
	 * @param obj
	 * @param newsId
	 * @throws Exception
	 */
	public void saveCommonNewsReadLog(CommonUser obj, int newsId) throws Exception;
	
	/**
	 *  一些啟始就設定的AP參數資訊
	 *  @see WEB-INF/properites/app.properties 
	 */
	public CommonAppSetting getCommonAppSetting();
	public void setCommonAppSetting(CommonAppSetting obj);	
	
	
	/**
	 * 取得FtpRouter物件給檔案上下載用的
	 * <br>請勿呼叫它來做其它ftp用途，若有需要請自行建立com.kangdainfo.util.net.FtpRounterImpl來使用
	 * @see com.kangdainfo.util.net.*
	 * @return
	 */	
	public FtpRoutingContext getFtpRoutingContext();
	public void setFtpRoutingContext(FtpRoutingContext ftpRoutingContext);
	
	/**
	 * 傳入CommonConfig.id值
	 * @param serverType
	 * @return
	 */
	public FtpRoutingContext getFtpRoutingContext(String serverType);
	
	/**
	 * 傳入取號類別後,取得該類別最大號+1
	 * <br>若有多個物件會大量用到,則需要個別獨立,因為會造成很可怕的等待或死鎖的發生 
	 * @param seqKey
	 * @return
	 * @throws Exception
	 */
	public long generateSeqNo(String seqKey) throws Exception;
	
}

