package com.kangdainfo.common.view.sys.ca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonZip;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.Datetime;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.util.io.file.FileDelete;
import com.kangdainfo.web.listener.MyServletContext;

public class SYSCA004F extends SuperBean {
	private String id;
	private String zipCode;
	private String cityName;
	private String roadName;
	private String noName;
	private String filePath;
	
	private String q_zipCode;
	private String q_cityName;
	private String q_roadName;
	private String q_noName;
	private String q_zipInfo;
	//匯入資料用
	private String im_userId;
	private String im_userIp;
	private String im_userShortName;

	@Override
	public ArrayList doQueryAll() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();		
		StringBuffer hql = new StringBuffer();
		hql.append("from CommonZip where 1=1");
		if(!"".equals(getQ_zipCode())){
			hql.append(" and zipCode = " + Common.sqlChar(getQ_zipCode()));
		}
		
		if(!"".equals(getQ_cityName())){
			hql.append(" and cityName = " + Common.sqlChar(getQ_cityName()));
		}
		
		if(!"".equals(getQ_roadName())){
			hql.append(" and roadName like " + Common.sqlChar("%" + getQ_roadName() + "%"));
		}
		
		if(!"".equals(getQ_noName())){
			hql.append(" and noName like " + Common.sqlChar("%" + getQ_noName() + "%"));
		}
		
		System.out.println("SYS0113查詢語法  ==" + hql.toString());
		
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(hql.toString()));
		if(getTotalRecord() > 0){
			if(getState().indexOf("query") < 0){
				ServiceGetter.getInstance().getCommonService().clear();
			}
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql.toString() + "order by zipCode",this.getRecordStart(),this.getPageSize());
			if(objList != null && objList.size() > 0){
				for(Object obj : objList){
					CommonZip o = (CommonZip)obj;
					String[] rowArray = new String[3];
					rowArray[0] = Common.get(o.getId());
					rowArray[1] = Common.get(o.getZipCode());
					rowArray[2] = Common.get(o.getZipInfo());
					arrList.add(rowArray);
				}
			}			
		}
		return arrList;
	}

	@Override
	public Object doQueryOne() throws Exception {
		SYSCA004F obj = this;
		CommonZip c = (CommonZip)View.getObject("from CommonZip where id = " + Common.getInt(getId()));
		if(c != null){
			obj.setId(Common.get(c.getId()));
			obj.setZipCode(Common.get(c.getZipCode()));
			obj.setCityName(Common.get(c.getCityName()));
			obj.setRoadName(Common.get(c.getRoadName()));
			obj.setNoName(Common.get(c.getNoName()));
			obj.setCreateId(c.getCreateId());
			obj.setCreateDate(c.getCreateDate());
			obj.setCreateTime(c.getCreateTime());
			obj.setUpdateId(c.getUpdateId());
			obj.setUpdateDate(c.getUpdateDate());
			obj.setUpdateTime(c.getUpdateTime());
			obj.setUpdateIp(c.getUpdateIp());
			obj.setUpdateUnitShortName(c.getUpdateUnitShortName());
		}
			
		return obj;
	}
	
	@Override
	public void doCreate() throws Exception {
		CommonZip obj = new CommonZip();
		obj.setZipCode(zipCode);
		obj.setCityName(cityName);
		obj.setRoadName(roadName);
		obj.setNoName(noName);
		
		String zipInfo = String.format("%1$-14s", cityName) 
						+ String.format("%1$-24s", roadName)
						+ String.format("%1$-30s", noName);
		System.out.println(zipInfo);		
		obj.setZipInfo(zipInfo);

		obj.setCreateId(createId);
		obj.setCreateDate(createDate);
		obj.setCreateTime(createTime);
		obj.setUpdateId(updateId);
	    obj.setUpdateDate(updateDate);
		obj.setUpdateTime(updateTime);
		obj.setUpdateIp(updateIp);
		obj.setUpdateUnitShortName(updateUnitShortName);
		
		ServiceGetter.getInstance().getCommonService().save(obj);
		setId(Common.get(obj.getId()));
	}

	@Override
	public void doUpdate() throws Exception {
		CommonZip obj = (CommonZip)View.getObject("from CommonZip where id = " + Common.getInt(getId()));
		if(obj != null){
			obj.setZipCode(zipCode);
			obj.setCityName(cityName);
			obj.setRoadName(roadName);
			obj.setNoName(noName);
			
			String zipInfo = String.format("%1$-14s", cityName) 
							+ String.format("%1$-24s", roadName)
							+ String.format("%1$-30s", noName);
			
			obj.setZipInfo(zipInfo);
			obj.setUpdateId(updateId);
		    obj.setUpdateDate(updateDate);
			obj.setUpdateTime(updateTime);
			obj.setUpdateIp(updateIp);
			obj.setUpdateUnitShortName(updateUnitShortName);
			
			ServiceGetter.getInstance().getCommonService().update(obj);
			setId(Common.get(obj.getId()));
		}
	}

	@Override
	public void doDelete() throws Exception {
		CommonZip obj = (CommonZip)View.getObject("from CommonZip where id = " + Common.getInt(getId()));
		if(obj != null){
			ServiceGetter.getInstance().getCommonService().delete(obj);
		}

	}
	
	public java.util.ArrayList<String[]> doQueryAll_corap006_1f() throws Exception {		
		
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		Map<String, Object> maps = new HashMap<String, Object>();

		StringBuffer hql = new StringBuffer();
		hql.append("from CommonZip where 1=1");		
		if (!"".equals(getQ_zipInfo())){
			hql.append(" and zipInfo like :zipInfo ");
			maps.put("zipInfo", "%" + q_zipInfo + "%"); 
		}
		
		System.out.println("corap006f_1f 查詢 == " + hql.toString());
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(hql.toString(), maps));
		if (getTotalRecord() > 0) {
			if (getState().indexOf("query")<0){
				ServiceGetter.getInstance().getCommonService().clear();
			}
			hql.append(" order by zipCode");
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql.toString(), this.getRecordStart(), this.getPageSize(), maps);		
			if (objList!=null && objList.size()>0) {
				for (Object obj : objList) {
					CommonZip o = (CommonZip)obj;
					String rowArray[]=new String[6];	
					rowArray[0]=Common.get(o.getId());
					rowArray[1]=Common.get(o.getZipCode());
					rowArray[2]=Common.get(o.getCityName() + o.getRoadName());
					rowArray[3]=Common.get(o.getZipInfo());
					rowArray[4]=Common.get(o.getCityName().substring(0,3));
					rowArray[5]=Common.get(o.getCityName().substring(3));
					arrList.add(rowArray);					
				}
			}
		}
		return arrList;
	}

	public void doImportProcess() throws Exception{
		//讀取上傳檔案
		if(!"".equals(getFilePath())){			
			String[] arrFileName = filePath.split(":;:");
			if(arrFileName.length > 0){
				String filestoreLocation = MyServletContext.getInstance().getServletContext().getInitParameter("filestoreLocation");
				String zipFileName = filestoreLocation + File.separator + arrFileName[0] + File.separator + arrFileName[1];
				File dir = new File(filestoreLocation + File.separator + arrFileName[0]);
				//存讀取檔案的資料
				java.util.ArrayList<String> zipTxtList = new java.util.ArrayList<String>();
				String strLine = "";
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(zipFileName),"MS950"));
			    int countTxt = 0;
				while ((strLine = in.readLine()) != null) {			    	
			    	StringBuffer sb = new StringBuffer();
			    	char[] ch = strLine.toCharArray();
			    	int ms950Len = 0;
			    	int begIndex = 0; //起始index
			    	int endIndex = 0; //結尾index
			    	for(int i = 0; i < ch.length; i++){
			    		endIndex ++;
			    		//計算big5讀取長度
			    		if(isAscill(ch[i])){
			    			ms950Len += 1;
			    		}
			    		else{
			    			ms950Len += 2;
			    		}
			    		
			    		if(ms950Len == 5){ //取zipCode
			    			sb.append(String.format("%1$-5s", strLine.substring(begIndex,endIndex)));
			    			begIndex = endIndex;
			    		}
			    		else if(ms950Len == 19){ //取cityName
			    			sb.append(String.format("%1$-14s", strLine.substring(begIndex,endIndex)));
			    			begIndex = endIndex;
			    		}
			    		else if(ms950Len == 43){ //取roadName
			    			sb.append(String.format("%1$-24s", strLine.substring(begIndex,endIndex)));
			    			begIndex = endIndex;
			    		}
			    		else if(ms950Len > 43){ //取noName
			    			sb.append(String.format("%1$-30s", strLine.substring(begIndex)));
			    			break;
			    		}
			    	}
			    	if(ms950Len < 44){
			    		System.out.println("有問題的資料 = " + strLine);	
			    		continue;
			    	}
			    	else{			    		
			    		zipTxtList.add(sb.toString());
			    		countTxt++;
			    	}
			    }
				System.out.println("讀取文件 完整資料比數 = " + countTxt);
			    in.close();
			    
			    if(zipTxtList != null && zipTxtList.size() > 0){
				    java.util.List objList = ServiceGetter.getInstance().getCommonService().load("from CommonZip where 1=1 order by zipCode");
					java.util.Map<String, CommonZip> zipMap = new HashMap<String, CommonZip>();
					
					System.out.print("objList有資料 = ");
					System.out.println(objList.size() > 0?true:false);
					
					if(objList != null && objList.size() > 0){
						System.out.println("====有資料====");
						for(Object o : objList){
							CommonZip zip = (CommonZip)o;
							zip.setUpdateId("N"); //暫時把每筆資料更新人員設為N
							zipMap.put(zip.getZipInfo(), zip); //以zipInfo為key鍵
						}
						
						for(String str : zipTxtList){
							String txtZipCode = str.substring(0,5); 	//zipCode 1~5碼
							String txtZipInfo = str.substring(5); 		//zipInfo 6~73碼
							String txtCityName = str.substring(5,19).trim(); 	//cityName 6~19碼
							String txtRoadName = str.substring(19,43).trim(); 	//RoadName 20~43碼
							String txtNoName = str.substring(43).trim(); 	//noName 44~73碼
							
							CommonZip orgZip = zipMap.get(txtZipInfo);
							if(orgZip != null){
								if(!orgZip.getZipCode().equals(txtZipCode)){
									//資料存在 有異動 須更新
									orgZip.setZipCode(txtZipCode);
									orgZip.setCityName(txtCityName);
									orgZip.setRoadName(txtRoadName);
									orgZip.setNoName(txtNoName);
									orgZip.setUpdateId(getIm_userId());
									orgZip.setUpdateDate(Datetime.getYYYMMDD());
									orgZip.setUpdateTime(Datetime.getHHMMSS());
									orgZip.setUpdateIp(getIm_userIp());
									orgZip.setUpdateUnitShortName(getIm_userShortName());
									zipMap.put(txtZipInfo, orgZip); //更改資料塞回map
								}
								else{
									//資料已存在 且沒異動
									orgZip.setUpdateId("Y");
									zipMap.put(txtZipInfo, orgZip); //更改資料塞回map
								}
							}
							else{
								//原始資料沒有 須新增
								orgZip = new CommonZip();
								orgZip.setZipCode(txtZipCode);
								orgZip.setZipInfo(txtZipInfo);
								orgZip.setCityName(txtCityName);
								orgZip.setRoadName(txtRoadName);
								orgZip.setNoName(txtNoName);
								orgZip.setCreateId(getIm_userId());
								orgZip.setCreateDate(Datetime.getYYYMMDD());
								orgZip.setCreateTime(Datetime.getHHMMSS());
								orgZip.setUpdateId(getIm_userId());
								orgZip.setUpdateDate(Datetime.getYYYMMDD());
								orgZip.setUpdateTime(Datetime.getHHMMSS());
								orgZip.setUpdateIp(getIm_userIp());
								orgZip.setUpdateUnitShortName(getIm_userShortName());
								zipMap.put(txtZipInfo, orgZip); //更改資料塞回map
							}
						}
						int Y = 0, N = 0;
						java.util.ArrayList<CommonZip> saveOrUpdateList = new java.util.ArrayList<CommonZip>();
						java.util.ArrayList<CommonZip> deleteList = new java.util.ArrayList<CommonZip>();
						for(String key : zipMap.keySet()){
							CommonZip orgZip = zipMap.get(key);
							//不為空 有異動  新增或更新
//							if(orgZip != null && (!orgZip.getUpdateId().equals("N") && !orgZip.getUpdateId().equals("Y"))){								
//								saveOrUpdateList.add(orgZip);
//								Y++;
//							}
							
							if(orgZip != null && !"N".equals(orgZip.getUpdateId()) && !"Y".equals(orgZip.getUpdateId())){
								saveOrUpdateList.add(orgZip);
								Y++;
							}
							
							//沒比對到資料 刪除
							if(orgZip != null && orgZip.getUpdateId().equals("N")){
								deleteList.add(orgZip);
								N++;
							}
						}
						//批次新增修改
						if(saveOrUpdateList != null && saveOrUpdateList.size() > 0){
							ServiceGetter.getInstance().getCommonService().saveOrUpdateAll(saveOrUpdateList);
						}
						//批次刪除
						if(deleteList != null && deleteList.size() > 0){
							ServiceGetter.getInstance().getCommonService().deleteBatch(deleteList);
						}
						
						System.out.println("要新增修改比數 = " + Y);
						System.out.println("要刪除比數 = " + N);
					}
					else{
						System.out.println("====沒資料====");
						for(String str : zipTxtList){
							String txtZipCode = str.substring(0,5); 	//zipCode 1~5碼
							String txtZipInfo = str.substring(5); 		//zipInfo 6~73碼
							String txtCityName = str.substring(5,19).trim(); 	//cityName 6~19碼
							String txtRoadName = str.substring(19,43).trim(); 	//RoadName 20~43碼
							String txtNoName = str.substring(43).trim(); 	//noName 44~73碼
							
							CommonZip orgZip = new CommonZip();
							orgZip.setZipCode(txtZipCode);
							orgZip.setZipInfo(txtZipInfo);
							orgZip.setCityName(txtCityName);
							orgZip.setRoadName(txtRoadName);
							orgZip.setNoName(txtNoName);
							orgZip.setCreateId(getIm_userId());
							orgZip.setCreateDate(Datetime.getYYYMMDD());
							orgZip.setCreateTime(Datetime.getHHMMSS());
							orgZip.setUpdateId(getIm_userId());
							orgZip.setUpdateDate(Datetime.getYYYMMDD());
							orgZip.setUpdateTime(Datetime.getHHMMSS());
							orgZip.setUpdateIp(getIm_userIp());
							orgZip.setUpdateUnitShortName(getIm_userShortName());
							
							if(zipMap.containsKey(txtZipInfo)){
								System.out.println("重複資料 = " + str);
							}
							zipMap.put(txtZipInfo, orgZip); //更改資料塞回map
							
							
						}
						int count = 0;
						java.util.ArrayList<CommonZip> saveZipList = new java.util.ArrayList<CommonZip>();
						for(String key : zipMap.keySet()){	
							count++;
							CommonZip orgZip = zipMap.get(key);
							saveZipList.add(orgZip);							
						}
						System.out.println("count = " + count);
						ServiceGetter.getInstance().getCommonService().saveBatch(saveZipList);
					}
			    }
			    System.out.println("====刪除檔案====");
			    FileDelete.delete2(dir);
			}			
			
			this.setErrorMsg("檔案匯入完成!");
			setStateUpdateSuccess();
		}
		else{
			this.setErrorMsg("找不到來源檔案路徑!");
			setStateUpdateError();
		}
	}
	
	private static boolean isAscill(char cr) {   
        int k = 0x80;   
        return cr / k == 0 ? true : false;   
    }
	
	public String getId() {
		return checkGet(id);
	}

	public void setId(String id) {
		this.id = checkSet(id);
	}

	public String getZipCode() {
		return checkGet(zipCode);
	}

	public void setZipCode(String zipCode) {
		this.zipCode = checkSet(zipCode);
	}

	public String getCityName() {
		return checkGet(cityName);
	}

	public void setCityName(String cityName) {
		this.cityName = checkSet(cityName);
	}

	public String getRoadName() {
		return checkGet(roadName);
	}

	public void setRoadName(String roadName) {
		this.roadName = checkSet(roadName);
	}

	public String getNoName() {
		return checkGet(noName);
	}

	public void setNoName(String noName) {
		this.noName = checkSet(noName);
	}
	
	public String getFilePath() {
		return checkGet(filePath);
	}

	public void setFilePath(String filePath) {
		this.filePath = checkSet(filePath);
	}

	public String getQ_zipCode() {
		return checkGet(q_zipCode);
	}

	public void setQ_zipCode(String qZipCode) {
		q_zipCode = checkSet(qZipCode);
	}

	public String getQ_cityName() {
		return checkGet(q_cityName);
	}

	public void setQ_cityName(String qCityName) {
		q_cityName = checkSet(qCityName);
	}

	public String getQ_roadName() {
		return checkGet(q_roadName);
	}

	public void setQ_roadName(String qRoadName) {
		q_roadName = checkSet(qRoadName);
	}

	public String getQ_noName() {
		return checkGet(q_noName);
	}

	public void setQ_noName(String qNoName) {
		q_noName = checkSet(qNoName);
	}

	public String getQ_zipInfo() {
		return checkGet(q_zipInfo);
	}

	public void setQ_zipInfo(String qZipInfo) {
		q_zipInfo = checkSet(qZipInfo);
	}

	public String getIm_userId() {
		return checkGet(im_userId);
	}

	public void setIm_userId(String imUserId) {
		im_userId = checkSet(imUserId);
	}

	public String getIm_userIp() {
		return checkGet(im_userIp);
	}

	public void setIm_userIp(String imUserIp) {
		im_userIp = checkSet(imUserIp);
	}

	public String getIm_userShortName() {
		return checkGet(im_userShortName);
	}

	public void setIm_userShortName(String imUserShortName) {
		im_userShortName = checkSet(imUserShortName);
	}
}
