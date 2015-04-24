package com.kangdainfo.ctis.view.cor.ap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.ctis.model.cor.ap.Corap009DB;
import com.kangdainfo.web.listener.MyServletContext;

public class CORAP009F extends SuperBean {
	private String id;
	private String center; 		 
	private String fullName;     
	private String ctDharmaName;  
	private String mobileNum1;    
	private String email1;        
	
	//匯入資料用
	private String errMsg;
	private String importMsg;
	private String filePath;

	@Override
	public ArrayList doQueryAll() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();		
		StringBuffer hql = new StringBuffer();
		hql.append("from Corap009DB where 1=1");		
		//System.out.println("CORAP009F 查詢語法  == " + hql.toString());
		
		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(hql.toString()));
		if(getTotalRecord() > 0){
			if(getState().indexOf("query") < 0){
				ServiceGetter.getInstance().getCommonService().clear();
			}
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(hql.toString() + "order by id",this.getRecordStart(),this.getPageSize());
			if(objList != null && objList.size() > 0){
				for(Object obj : objList){
					Corap009DB o = (Corap009DB)obj;
					String[] rowArray = new String[6];
					rowArray[0] = Common.get(o.getId());
					rowArray[1] = Common.get(o.getCenter());
					rowArray[2] = Common.get(o.getFullName());
					rowArray[3] = Common.get(o.getCtDharmaName());
					rowArray[4] = Common.get(o.getMobileNum1());
					rowArray[5] = Common.get(o.getEmail1());
					arrList.add(rowArray);
				}
			}			
		}
		return arrList;
	}

	@Override
	public Object doQueryOne() throws Exception {
		return null;
	}
	
	@Override
	public void doCreate() throws Exception {}

	@Override
	public void doUpdate() throws Exception {}

	@Override
	public void doDelete() throws Exception {}
	
	public void doImportProcess() throws Exception{
		System.out.println("[TCGX]-[CORAP0009F]-[匯入]-[精舍學員名單整批匯入...]");
		//支援xls
		try {
			StringBuilder importMsg = new StringBuilder();
			StringBuilder errMsg = new StringBuilder();
			int counter = 0;
			int checkcounter = 0;
			
			String[] arrFileName = getFilePath().split("&#x3a;");
			String filestoreLocation = MyServletContext.getInstance().getServletContext().getInitParameter("filestoreLocation");
			String srcFileName = filestoreLocation + "/" + arrFileName[0] + "/" + arrFileName[2];
		    FileInputStream file = new FileInputStream(new File(srcFileName));
		    Cell cell = null;
            java.util.List<Corap009DB> saveList = new java.util.ArrayList<Corap009DB>();
            //判斷xls
	        if (arrFileName[2].toLowerCase().endsWith(".xls")) {
	        	//Get the workbook instance for XLS file 
			    HSSFWorkbook workbook = new HSSFWorkbook(file);			 
			    //Get first sheet from the workbook
			    HSSFSheet sheet = workbook.getSheetAt(0);
			    
	            for(int i=1; i<=sheet.getLastRowNum(); i++){
			    	if(!"".equals(sheet.getRow(i).getCell(0)) &&	
			    	   !"".equals(sheet.getRow(i).getCell(1)) &&	
			    	   !"".equals(sheet.getRow(i).getCell(2)) && 
			    	   !"".equals(sheet.getRow(i).getCell(3)) && 
			    	   !"".equals(sheet.getRow(i).getCell(4))){
			    		Corap009DB Corap009DB = new Corap009DB();
				    	Corap009DB.setCenter(Common.get(sheet.getRow(i).getCell(0)));	
						Corap009DB.setFullName(Common.get(sheet.getRow(i).getCell(1)));
						Corap009DB.setCtDharmaName(Common.get(sheet.getRow(i).getCell(2)));
						//Excel數字轉字串
						cell = sheet.getRow(i).getCell(3);					
						cell.setCellType(1); //設定為字串
						Corap009DB.setGender(Common.get(sheet.getRow(i).getCell(3)));
						
						cell = sheet.getRow(i).getCell(4);					
						cell.setCellType(1);
						Corap009DB.setHomePhoneNum1(Common.get(sheet.getRow(i).getCell(4)));
						
						cell = sheet.getRow(i).getCell(5);					
						cell.setCellType(1);
						Corap009DB.setOfficePhoneNum1(Common.get(sheet.getRow(i).getCell(5)));
						
						cell = sheet.getRow(i).getCell(6);					
						cell.setCellType(1);
						Corap009DB.setMobileNum1(Common.get(sheet.getRow(i).getCell(6)));
						
						cell = sheet.getRow(i).getCell(7);					
						cell.setCellType(1);
						Corap009DB.setBirthDate(Common.get(sheet.getRow(i).getCell(7)));
						
						cell = sheet.getRow(i).getCell(8);
						cell.setCellType(1);
						Corap009DB.setTwIdNum(Common.get(sheet.getRow(i).getCell(8)));
						
						Corap009DB.setFamilyProvince(Common.get(sheet.getRow(i).getCell(9)));
						Corap009DB.setFamilyCity(Common.get(sheet.getRow(i).getCell(10)));
						Corap009DB.setCompanyName(Common.get(sheet.getRow(i).getCell(14)));
						Corap009DB.setCompanyJobTitle(Common.get(sheet.getRow(i).getCell(15)));
						Corap009DB.setIntroducerName(Common.get(sheet.getRow(i).getCell(16)));
						Corap009DB.setIntroducerRelationship(Common.get(sheet.getRow(i).getCell(17)));
						Corap009DB.setDonationType(Common.get(sheet.getRow(i).getCell(18)));
						
						cell = sheet.getRow(i).getCell(19);
						cell.setCellType(1);
						Corap009DB.setUrgentContactPersonName1(Common.get(sheet.getRow(i).getCell(19)));
						
						Corap009DB.setUrgentContactPersonRelationship1(Common.get(sheet.getRow(i).getCell(20)));
						
						cell = sheet.getRow(i).getCell(21);
						cell.setCellType(1);
						Corap009DB.setUrgentContactPersonPhoneNum1(Common.get(sheet.getRow(i).getCell(21)));
						Corap009DB.setSchoolDegree(Common.get(sheet.getRow(i).getCell(22)));
						Corap009DB.setSchoolName(Common.get(sheet.getRow(i).getCell(23)));
						Corap009DB.setSchool_major(Common.get(sheet.getRow(i).getCell(24)));
						Corap009DB.setMailingAddress(Common.get(sheet.getRow(i).getCell(25)));
						Corap009DB.setEmail1(Common.get(sheet.getRow(i).getCell(26)));
						
						cell = sheet.getRow(i).getCell(30);
						cell.setCellType(1);					
						Corap009DB.setOkSendMagazine(Common.get(sheet.getRow(i).getCell(30)));
						
						cell = sheet.getRow(i).getCell(31);
						cell.setCellType(1);				
						Corap009DB.setOkSendEletter(Common.get(sheet.getRow(i).getCell(31)));
						
						Corap009DB.setBirthProvinceCountry(Common.get(sheet.getRow(i).getCell(34)));
						
						saveList.add(Corap009DB);
						counter++;
			    	}else{
			    		if("".equals(sheet.getRow(i).getCell(0))){
							errMsg.append("[精舍]空白").append("<br>");
						}
						if("".equals(sheet.getRow(i).getCell(1))){
							errMsg.append("[姓名]空白").append("<br>");
						}
						if("".equals(sheet.getRow(i).getCell(2))){
							errMsg.append("[法名]空白").append("<br>");
						}
						if("".equals(sheet.getRow(i).getCell(3))){
							errMsg.append("[行動電話]空白").append("<br>");
						}
						if("".equals(sheet.getRow(i).getCell(4))){
							errMsg.append("[E-mail]空白").append("<br>");
						}
						checkcounter++;
			    	}
			    }
	        }
	        //判斷xlsx
	        if (arrFileName[2].toLowerCase().endsWith(".xlsx")) {
	        	//Get the workbook instance for XLSX file 
			    XSSFWorkbook workbook = new XSSFWorkbook(file);			 
			    //Get first sheet from the workbook
			    XSSFSheet sheet = workbook.getSheetAt(0);
			    
	            for(int i=1; i<=sheet.getLastRowNum(); i++){
			    	if(!"".equals(sheet.getRow(i).getCell(0)) &&	
			    	   !"".equals(sheet.getRow(i).getCell(1)) &&	
			    	   !"".equals(sheet.getRow(i).getCell(2)) && 
			    	   !"".equals(sheet.getRow(i).getCell(3)) && 
			    	   !"".equals(sheet.getRow(i).getCell(4))){
			    		Corap009DB Corap009DB = new Corap009DB();
				    	Corap009DB.setCenter(Common.get(sheet.getRow(i).getCell(0)));	
						Corap009DB.setFullName(Common.get(sheet.getRow(i).getCell(1)));
						Corap009DB.setCtDharmaName(Common.get(sheet.getRow(i).getCell(2)));
						
						//Excel數字轉字串
						cell = sheet.getRow(i).getCell(3);					
						cell.setCellType(1); //設定為字串
						Corap009DB.setGender(Common.get(sheet.getRow(i).getCell(3)));
						
						cell = sheet.getRow(i).getCell(4);					
						cell.setCellType(1);
						Corap009DB.setHomePhoneNum1(Common.get(sheet.getRow(i).getCell(4)));
						
						cell = sheet.getRow(i).getCell(5);					
						cell.setCellType(1);
						Corap009DB.setOfficePhoneNum1(Common.get(sheet.getRow(i).getCell(5)));
						
						cell = sheet.getRow(i).getCell(6);					
						cell.setCellType(1);
						Corap009DB.setMobileNum1(Common.get(sheet.getRow(i).getCell(6)));
						
						cell = sheet.getRow(i).getCell(7);					
						cell.setCellType(1);
						Corap009DB.setBirthDate(Common.get(sheet.getRow(i).getCell(7)));
						
						cell = sheet.getRow(i).getCell(8);
						cell.setCellType(1);
						Corap009DB.setTwIdNum(Common.get(sheet.getRow(i).getCell(8)));
						
						Corap009DB.setFamilyProvince(Common.get(sheet.getRow(i).getCell(9)));
						Corap009DB.setFamilyCity(Common.get(sheet.getRow(i).getCell(10)));
						Corap009DB.setCompanyName(Common.get(sheet.getRow(i).getCell(14)));
						Corap009DB.setCompanyJobTitle(Common.get(sheet.getRow(i).getCell(15)));
						Corap009DB.setIntroducerName(Common.get(sheet.getRow(i).getCell(16)));
						Corap009DB.setIntroducerRelationship(Common.get(sheet.getRow(i).getCell(17)));
						Corap009DB.setDonationType(Common.get(sheet.getRow(i).getCell(18)));
						
						cell = sheet.getRow(i).getCell(19);
						cell.setCellType(1);
						Corap009DB.setUrgentContactPersonName1(Common.get(sheet.getRow(i).getCell(19)));
						
						Corap009DB.setUrgentContactPersonRelationship1(Common.get(sheet.getRow(i).getCell(20)));
						
						cell = sheet.getRow(i).getCell(21);
						cell.setCellType(1);
						Corap009DB.setUrgentContactPersonPhoneNum1(Common.get(sheet.getRow(i).getCell(21)));
						Corap009DB.setSchoolDegree(Common.get(sheet.getRow(i).getCell(22)));
						Corap009DB.setSchoolName(Common.get(sheet.getRow(i).getCell(23)));
						Corap009DB.setSchool_major(Common.get(sheet.getRow(i).getCell(24)));
						Corap009DB.setMailingAddress(Common.get(sheet.getRow(i).getCell(25)));
						Corap009DB.setEmail1(Common.get(sheet.getRow(i).getCell(26)));
						
						cell = sheet.getRow(i).getCell(30);
						cell.setCellType(1);					
						Corap009DB.setOkSendMagazine(Common.get(sheet.getRow(i).getCell(30)));
						
						cell = sheet.getRow(i).getCell(31);
						cell.setCellType(1);				
						Corap009DB.setOkSendEletter(Common.get(sheet.getRow(i).getCell(31)));
						
						Corap009DB.setBirthProvinceCountry(Common.get(sheet.getRow(i).getCell(34)));
						
						saveList.add(Corap009DB);
						counter++;
			    	}else{
			    		if("".equals(sheet.getRow(i).getCell(0))){
							errMsg.append("[精舍]空白").append("<br>");
						}
						if("".equals(sheet.getRow(i).getCell(1))){
							errMsg.append("[姓名]空白").append("<br>");
						}
						if("".equals(sheet.getRow(i).getCell(2))){
							errMsg.append("[法名]空白").append("<br>");
						}
						if("".equals(sheet.getRow(i).getCell(3))){
							errMsg.append("[行動電話]空白").append("<br>");
						}
						if("".equals(sheet.getRow(i).getCell(4))){
							errMsg.append("[E-mail]空白").append("<br>");
						}
						checkcounter++;
			    	}
			    }
	        } 
	        //寫入資料庫
	        ServiceGetter.getInstance().getCommonService().saveBatch(saveList);
		    
		    if(counter != 0){
				//匯入成功X筆、失敗X筆，共X筆
				importMsg.append("匯入結果：成功").append(counter).append("筆、").append("失敗").append(checkcounter).append("筆").append("，共").append(counter+checkcounter).append("筆<br>");
				this.setImportMsg("<br><br>資料匯入成功，其結果如下：<br>" + importMsg.toString());
				//System.out.println("精舍學員資料匯入 :" + importMsg.toString());
			}
			
		} catch (FileNotFoundException e1) {
		    e1.printStackTrace();
		    this.setErrMsg("<br><br>資料匯入失敗，錯誤訊息如下：<br>" + " FileNotFoundException: " + e1.getMessage());
		} catch (IOException e2) {
		    e2.printStackTrace();
		    this.setErrMsg("<br><br>資料匯入失敗，錯誤訊息如下：<br>" + " IOException: " + e2.getMessage());
		}
		/* 匯入txt檔
		try{
			StringBuilder importMsg = new StringBuilder();
			StringBuilder errMsg = new StringBuilder();
			
			String[] arrFileName = getFilePath().split("&#x3a;");
			if (arrFileName.length>0) {
				String filestoreLocation = MyServletContext.getInstance().getServletContext().getInitParameter("filestoreLocation");
				String srcFileName = filestoreLocation + "/" + arrFileName[0] + "/" + arrFileName[2];				
				File f = new File(srcFileName);				
				ReadWriteTextFile rtf = new ReadWriteTextFile();
				ArrayList<String> objList = rtf.getFileContents(f);
				
				java.util.List<Corap009DB> saveList = new java.util.ArrayList<Corap009DB>();
				int counter = 0;
				int checkcounter = 0;
				
				String a = objList.toString().replace("[", "").replace("]", "");
				String[] mustSplitString = a.split(";"); //整列
				for(int i=0; i<=mustSplitString.length; i++){
					String[] AfterSplit = mustSplitString[i].split(",");
					if(!"".equals(AfterSplit[0].toString()) &&	!"".equals(AfterSplit[1].toString()) &&	!"".equals(AfterSplit[2].toString()) && !"".equals(AfterSplit[3].toString()) && !"".equals(AfterSplit[4].toString())){
						Corap009DB Corap009DB = new Corap009DB();
						Corap009DB.setCenter(Common.get(AfterSplit[0]));		  //精舍		
						Corap009DB.setFullName(Common.get(AfterSplit[1]));		  //姓名
						Corap009DB.setCtDharmaName(Common.get(AfterSplit[2]));    //法名
						Corap009DB.setMobileNum1(Common.get(AfterSplit[3]));      //行動電話
						Corap009DB.setEmail1(Common.get(AfterSplit[4]));	      //E-mail
						saveList.add(Corap009DB);
						ServiceGetter.getInstance().getCommonService().saveBatch(saveList);
						counter++;
					}else {
						if("".equals(AfterSplit[0].toString())){
							errMsg.append("[精舍]空白").append("<br>");
						}
						if("".equals(AfterSplit[1].toString())){
							errMsg.append("[姓名]空白").append("<br>");
						}
						if("".equals(AfterSplit[2].toString())){
							errMsg.append("[法名]空白").append("<br>");
						}
						if("".equals(AfterSplit[3].toString())){
							errMsg.append("[行動電話]空白").append("<br>");
						}
						if("".equals(AfterSplit[4].toString())){
							errMsg.append("[E-mail]空白").append("<br>");
						}
						checkcounter++;
					}
				}
				
				if(counter != 0){
					//匯入成功X筆、失敗X筆，共X筆
					importMsg.append("匯入成功：成功").append(counter).append("筆、").append("失敗").append(checkcounter).append("筆").append("，共").append(counter+checkcounter).append("筆<br>");
					//this.setImportMsg("<br><br>資料匯入成功，其結果如下：<br>" + importMsg.toString());
				}
				
			}
		}catch(Exception e) {
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			//setState("doTransferFail");
			//this.setErrMsg("<br><br>資料匯入失敗，錯誤訊息如下：<br>" + " : " + e.getMessage());	
		}
		//System.out.println("====刪除檔案====");
    	//FileDelete.delete2(dir);
	*/
	}
	
	public String getId() {return checkGet(id);}
	public void setId(String id) {this.id = checkSet(id);}
	public String getCenter() {return checkGet(center);}
	public void setCenter(String center) {this.center = checkSet(center);}
	public String getFullName() {return checkGet(fullName);}
	public void setFullName(String fullName) {this.fullName = checkSet(fullName);}
	public String getCtDharmaName() {return checkGet(ctDharmaName);}
	public void setCtDharmaName(String ctDharmaName) {this.ctDharmaName = checkSet(ctDharmaName);}
	public String getMobileNum1() {return checkGet(mobileNum1);}
	public void setMobileNum1(String mobileNum1) {this.mobileNum1 = checkSet(mobileNum1);}
	public String getEmail1() {return checkGet(email1);}
	public void setEmail1(String email1) {this.email1 = checkSet(email1);}
	public String getFilePath() {return checkGet(filePath);}
	public void setFilePath(String filePath) {this.filePath = checkSet(filePath);}
	public String getErrMsg() {return checkGet(errMsg);}
	public void setErrMsg(String errMsg) {this.errMsg = checkSet(errMsg);}
	public String getImportMsg() {return checkGet(importMsg);}
	public void setImportMsg(String importMsg) {this.importMsg = checkSet(importMsg);}
}