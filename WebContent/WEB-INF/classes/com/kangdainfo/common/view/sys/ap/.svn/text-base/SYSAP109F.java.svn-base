package com.kangdainfo.common.view.sys.ap;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.owasp.esapi.ESAPI;

import jxl.*; 
import jxl.write.*; 
import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.*;
import com.kangdainfo.common.util.*;
import com.kangdainfo.common.util.filestore.ContentTypeConfiguration;


public class  SYSAP109F extends SuperBean{
	
	private String q_filePath;
	public String getQ_filePath() {	return checkGet(q_filePath);	}
	public void setQ_filePath(String q_filePath) {	this.q_filePath = checkSet(q_filePath);	}
	
	private String msg;
	public String getMsg() {		return checkGet(msg);	}
	public void setMsg(String msg) {		this.msg = checkSet(msg);	}
	
	
	public void templateToHttpResponse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		java.util.List list =  ServiceGetter.getInstance().getCommonService().load(" from CommonDtree where 1=1 ");
		if (list!=null && list.size()>0) {
			File outputFile = new File(System.getProperty("java.io.tmpdir") + File.separator + "InspTemplate.xls");
			WritableWorkbook workbook = Workbook.createWorkbook(outputFile);	
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);	
			sheet.addCell(new Label(0, 0, "DtreeId"));
			sheet.setColumnView(0, 10);
			sheet.addCell(new Label(1, 0, "中文"));
			sheet.setColumnView(1, 20);
			sheet.addCell(new Label(2, 0, "English"));
			sheet.setColumnView(2, 20);
			sheet.addCell(new Label(3, 0, "简体"));
			sheet.setColumnView(3, 20);
			sheet.addCell(new Label(4, 0, "日本語"));
			sheet.setColumnView(4, 20);
			sheet.addCell(new Label(5, 0, "Italia"));
			sheet.setColumnView(5, 20);
			sheet.addCell(new Label(6, 0, "ประเทศไทย"));
			sheet.setColumnView(6, 20);
			
			java.util.Map<String, String> locMap = new java.util.HashMap<String, String>();
			java.util.List<CommonDtreeLocName> objList = ServiceGetter.getInstance().getCommonService().load("from CommonDtreeLocName where 1=1 ");
			if (objList!=null && objList.size()>0) {
				for (CommonDtreeLocName dtl : objList) {
					String key = Common.get(dtl.getId())+"_"+Common.get(dtl.getCodeId());
					locMap.put(key, dtl.getName());
				}
			}
			objList.clear();
			
			for (int i=0; i<list.size(); i++) {
				CommonDtree dtl = (CommonDtree) list.get(i);
				
				sheet.addCell(new Label(0, i+1, Common.get(dtl.getId())));
				sheet.addCell(new Label(1, i+1, Common.get(dtl.getName())));
				sheet.addCell(new Label(2, i+1, !"".equals(Common.get(dtl.getId()+"_en_US"))?locMap.get(Common.get(dtl.getId()+"_en_US")):""));
				sheet.addCell(new Label(3, i+1, !"".equals(Common.get(dtl.getId()+"_zh_CN"))?locMap.get(Common.get(dtl.getId()+"_zh_CN")):""));
				sheet.addCell(new Label(4, i+1, !"".equals(Common.get(dtl.getId()+"_ja_JP"))?locMap.get(Common.get(dtl.getId()+"_ja_JP")):""));
				sheet.addCell(new Label(5, i+1, !"".equals(Common.get(dtl.getId()+"_it_IT"))?locMap.get(Common.get(dtl.getId()+"_it_IT")):""));
				sheet.addCell(new Label(6, i+1, !"".equals(Common.get(dtl.getId()+"_th_TH"))?locMap.get(Common.get(dtl.getId()+"_th_TH")):""));
			}
			workbook.write();			
			workbook.close();
			
			OutputStream os = null;
		    FileInputStream is = null;	        
		    try{
		        String ct = ContentTypeConfiguration.getContentType(outputFile.getName());
		        if(ct != null){
		            response.setContentType(ct);
		        }		        	
		    	response.setHeader("Cache-control","");
			    response.setContentLength((int)outputFile.length());	        
			    response.setHeader("Content-Disposition", "attachment; filename=\"" + outputFile.getName() + "\"");	
			    
		    	byte b[] = new byte[(int)outputFile.length()];
		    	if (outputFile.isFile()) {
		    		response.flushBuffer();
		    	    is = new FileInputStream(outputFile);
		    	    os = response.getOutputStream();
		    	    int read = 0;
		    	    while ((read = is.read(b)) != -1)
		    	    {
		    	        os.write(b,0,read);
		    	    }
		    	}
		    }catch(Exception x){
		    	try{
		    		response.sendError(500,"Template產製錯誤！");
		    	}catch(Exception e){}
		    }finally{
		    	if (os!=null) os.close();
		        if (is!=null) is.close();
		    }
		}else{
			setMsg("查無資料 !");
		}	
	}
	
	public void importCommonDtreeLocName() throws Exception {	
		if (!"".equals(Common.get(getQ_filePath()))) {			
			String[] arrFileName = null;	
			arrFileName = ESAPI.encoder().decodeForHTML(Common.get(getQ_filePath())).split(":;:");			
			if (arrFileName.length>1) {
				String filestoreLocation = ServiceGetter.getInstance().getMyServletContext().getServletContext().getInitParameter("filestoreLocation");
				File f = new File(filestoreLocation + File.separator + arrFileName[0] + File.separator+arrFileName[1]);
				
				if (f.isFile() && f.exists() && f.canRead()) {
					XlsUtil xlsUtil = new XlsUtil();
					java.util.List<String[]> list = xlsUtil.getJExcelModel(f.getPath(), 0, false, 5);
					if (list!=null && list.size()>0) {					
						
						CommonUser currentUser = ServiceGetter.getInstance().getAuthenticationService().getCurrentUser();
						String userId = currentUser!=null?currentUser.getUserId():"";
						String yyyMMdd = Datetime.getYYYMMDD();
						String hhMMss = Datetime.getHHMMSS();					
						//新增修改Map
						java.util.Map<String, CommonDtreeLocName> h = new java.util.HashMap<String, CommonDtreeLocName>();
						java.util.List<CommonDtreeLocName> objList = ServiceGetter.getInstance().getCommonService().load("from CommonDtreeLocName where 1=1 ");
						if (objList!=null && objList.size()>0) {
							for (CommonDtreeLocName dtl : objList) {
								String key = Common.get(dtl.getId())+"_"+Common.get(dtl.getCodeId());
								h.put(key, dtl);
							}
						}
						objList.clear();
						//判斷Dtree是否存在
						java.util.Map<String, String> dtreeMap = new java.util.HashMap<String, String>();
						java.util.List<CommonDtree> objList2 = ServiceGetter.getInstance().getCommonService().load("from CommonDtree where 1=1 ");
						if (objList2!=null && objList2.size()>0) {
							for (CommonDtree dtl : objList2) {
								dtreeMap.put(Common.get(dtl.getId()), "Y");
							}
						}
						objList2.clear();
						
						java.util.List<CommonDtreeLocName> saveList = new java.util.ArrayList<CommonDtreeLocName>();
						java.util.List<CommonDtreeLocName> updateList = new java.util.ArrayList<CommonDtreeLocName>();
						StringBuffer transMsg = new StringBuffer();
						for (int i=0; i<list.size(); i++) {							
							String[] rs = list.get(i);
							for (int j=0; j<rs.length; j++) {								
								if(dtreeMap.get(Common.get(rs[0])) != null){
									String codeId ="";
									switch (Common.getInt(j)){
									case 2:
										codeId="en_US"; 
										break;
									case 3:
										codeId="zh_CN";
										break;
									case 4:
										codeId="ja_JP";
										break;
									case 5:
										codeId="it_IT";
										break;
									case 6:
										codeId="th_TH";
										break;
									}
									if(j>=2){
										if(!"".equals(Common.get(rs[j]))){  //空值不做處理
											boolean isUpdate = true;									
											String key = Common.get(rs[0])+"_"+codeId;
											CommonDtreeLocName obj = h.get(key);
											if (obj == null) {
												obj = new CommonDtreeLocName();
												obj.setCodeId(codeId);
												isUpdate = false;
											}									
											obj.setName(Common.get(rs[j]));
											obj.setEditId(userId);
											obj.setEditDate(yyyMMdd);
											obj.setEditTime(hhMMss);
											
											if (isUpdate) updateList.add(obj);
											else saveList.add(obj);	
										}										
									}
								}else{
									transMsg.append("第").append(i).append("筆，資料異常!");
								}								
							}																			
						}
						
						transMsg.append("新增筆數：").append(saveList.size());
						transMsg.append("更新筆數：").append(updateList.size());
						
						if(updateList!=null && updateList.size()>0){
							ServiceGetter.getInstance().getCommonService().updateBatch(updateList);
							updateList.clear();
						}
						if(saveList!=null && saveList.size()>0){
							ServiceGetter.getInstance().getCommonService().save(saveList);
							saveList.clear();
						}						
						if(transMsg.toString().length() > 0){
							setMsg(transMsg.toString());
						}
					}else{
						setMsg("輸入樣版無法解析，請重新操作 !");
					}
				}
			}
		}else{
			setMsg("檔案路徑錯誤，請重新操作 !");
		}
	}
	
	@Override
	public Object doQueryOne() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList doQueryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void doCreate() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doUpdate() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doDelete() throws Exception {
		// TODO Auto-generated method stub
		
	}


}


