package com.kangdainfo.common.util;

import java.util.ArrayList;
import java.util.List;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.model.bo.CommonCode;
import com.kangdainfo.common.util.report.ReportEnvironment;

/**
*<br>程式目的：顯示Html view之函數
*<br>程式代號：View
*<br>撰寫日期：94/05/10
*<br>程式作者：Kangdainfo
*<br>--------------------------------------------------------
*<br>修改作者　　修改日期　　　修改目的
*<br>--------------------------------------------------------
*<br>
*/
public class View {
	
	private View() {
		//avoid instantiation...
	}
    
	static final int[] roleIdArray = new int[] {1,2,3};
	static final String[] roleName = new String[] {"一般使用者","業務管理者","系統管理者"};
	static final String[] schoolType = new String[]{"01","02","03","04"};
	static final String[] schoolTypeName = new String[]{"高級中學","國民中學","國民小學","幼稚園"};

	public static String getItemName(Object[] itemId, Object[] itemName, Object id) {	
		if (id!=null) {
			for (int i=0; i<itemId.length; i++) {
				if (id!=null && id.equals(itemId[i])) return Common.get(itemName[i]);
			}			
		}
		return Common.get(id);
	}
	public static String getItemOption(Object[] itemId, Object[] itemName, Object selectedOne) {	
		return getItemOption(itemId, itemName, selectedOne, 2);
	}
	public static String getItemOption(Object[] itemId, Object[] itemName, Object selectedOne, int defaultChoice) {		
        StringBuilder sb = new StringBuilder();
        if (defaultChoice==1) sb.append("<option value=''>請選擇</option>");
        else if (defaultChoice==2) sb.append("<option value=''></option>");             
		for (int i=0; i<itemId.length; i++) {
            sb.append("<option value='").append(itemId[i]).append("' ");
            if (selectedOne!=null && selectedOne.equals(itemId[i])) sb.append(" selected ");
            sb.append(">").append(itemName[i]).append("</option>\n");
		}
		return sb.toString();
	}	
	
	public static String getRoleName(String roleId) {
		int rid = Common.getInt(roleId);
		for (int i=0; i<roleIdArray.length; i++) {
			if (rid==roleIdArray[i]) return roleName[i];
		}
		return "";
	}
	
	public static String getRoleOption(String selected) {
		int roleId = Common.getInt(selected);
        StringBuilder sb = new StringBuilder().append("<option value=''></option>");		
		for (int i=0; i<roleIdArray.length; i++) {
            sb.append("<option value='").append(roleIdArray[i]).append("' ");
            if (roleId == roleIdArray[i]) sb.append(" selected ");
            sb.append(">").append(roleName[i]).append("</option>\n");    			
		}
		return sb.toString();
	}	
	
	/**
	 * 學校類別名稱
	 * @param s = 類別代碼
	 * @return
	 */
	public static String getSchoolTypeName(String s) {
		if (s!=null) {
			for (int i=0; i<schoolType.length; i++) {
				if (s.equals(schoolType[i])) return schoolTypeName[i];
			}
		}
		return "";
	}
	
	/**
	 * 學校類別選單
	 * @param selectedOne
	 * @return
	 */
	public static String getSchoolTypeOption(String selectedOne) {
        StringBuilder sb = new StringBuilder().append("<option value=''>請選擇</option>");		
		for (int i=0; i<schoolType.length; i++) {
            sb.append("<option value='").append(schoolType[i]).append("' ");
            if (selectedOne!= null && selectedOne.equals(schoolType[i])) {
                sb.append(" selected ");
            }
            sb.append(">").append(schoolTypeName[i]).append("</option>\n");    			
		}
		return sb.toString();
	}			
	
    /**
     * <br>
     * <br>目的：組合html option語法函數
     * <br>參數：(1)sql字串 (2)被選的value
     * <br>傳回：加上html option element<br>
     * eg. getOption("select id, codeKindName from CommonCodeKind", "") 
     */
    static public String getOption(String sql, String selectedOne) {
    	return getOption(sql,selectedOne,false,1);
    }
    /**
     * 目的：組合html option語法函數
     * @param sql
     * @param selectedOne
     * @param limitLen = 是否限制顯示長度(若為true,則最多顯示60個字)
     * @param defaultChoice = 1.請選擇, 2.空白, 預設是沒有預設選項<br>
     * eg. getOption("select id, codeKindName from CommonCodeKind", "", 1)
     * @return
     */
    static public String getOption(String sql, String selectedOne, boolean limitLen, int defaultChoice) {
    	return getOption(sql, selectedOne, limitLen, defaultChoice, "");
    }
    static public String getOption(String sql, String selectedOne, boolean limitLen, int defaultChoice, String event) {
        StringBuilder sb = new StringBuilder();
        if (defaultChoice==1) sb.append("<option value=''>請選擇</option>");
        else if (defaultChoice==2) sb.append("<option value=''></option>");        
        try {
        	if (Common.get(sql).length()>10) {
            	List list = ServiceGetter.getInstance().getCommonService().load(sql);
            	if (list!=null && list.size()>0) {
            		for (int i=0; i<list.size(); i++) {
            			Object[] obj = (Object[])list.get(i);
                        String id = Common.get(obj[0]);
                        String name = Common.get(obj[1]);
                        
                        sb.append("<option value='").append(id).append("' ").append(event);
                        if (selectedOne!= null && selectedOne.equals(id)) {
                            sb.append(" selected ");
                        }
                        if (limitLen && Common.get(name).length()>60) sb.append(">").append(name.substring(0,60)).append("..</option>\n");
                        else sb.append(">").append(name).append("</option>\n");
            		}
            	}        		
        	}

        } catch (Exception ex) {
            sb.append("<option value=''>查詢錯誤</option>");
            ex.printStackTrace();
        }
        return sb.toString();
    }
    
    /**
     * <br>
     * <br>目的：組合html option語法函數 
     * <br>參數：(1)sql字串 (2)被選的value 
     * <br>傳回：加上html option element 
     */
    static public String getSingleOption(String sql, String selectedOne) {
    	return getSingleOption(sql, selectedOne, 1);
    }
    static public String getSingleOption(String sql, String selectedOne, int defaultChoice) {
    	return getSingleOption(sql, selectedOne, defaultChoice, "");
    }	 
    static public String getSingleOption(String sql, String selectedOne, int defaultChoice, String event) {
        StringBuilder sb = new StringBuilder();
        if (defaultChoice==1) sb.append("<option value=''>請選擇</option>");
        else if (defaultChoice==2) sb.append("<option value=''></option>");
        try {
        	List list = ServiceGetter.getInstance().getCommonService().load(sql);
        	if (list!=null && list.size()>0) {
        		for (int i=0; i<list.size(); i++) {
                    String id = list.get(i).toString();                    
                    sb.append("<option value='").append(id).append("' ").append(event);
                    if (selectedOne!= null && selectedOne.equals(id)) {
                    	sb.append(" selected ");
                    }
                    sb.append(">").append(id).append("</option>\n");      			
        		}
        	}
        } catch (Exception ex) {
        	sb.append("<option value=''>查詢錯誤</option>");
            ex.printStackTrace();
        }
        return sb.toString(); 
    }	      
    
    /**
     * <br>
     * <br>目的：組合Yes or No option語法函數 
     * <br>參數：被選的value 
     * <br>傳回：加上html option element 
     */
    static public String getYNOption(String selectedOne) {
    	return getTextOption("Y;是;N;否",selectedOne, 1);
    }
    
    /**
     * 組合多選 option<br>
     * eg.View.getCheckBoxTextOption("field","fd10","1;One;2;Two;3;Three",null)
     * @param textOption = 分隔符號';'，第一個表存入db的值，第2個表option
     * @param selectedCheckBox = 被選取的value<br>
     * 
     * @return
     */        
    public static String getCheckBoxTextOption(String className, String checkBoxFieldName, String textOption, String[] selectedCheckBox) {
    	StringBuilder sb = new StringBuilder();
    	String[] arrOption = textOption.split(";");
    	int j=0;
    	for(int i=0 ; i<arrOption.length;i++){
    		sb.append("<input class=\"" ).append( className ).append( "\" type=\"checkbox\" name=\"" ).append( checkBoxFieldName ).append( "\" value=\"" ).append( arrOption[i] ).append( "\"");
    		if (selectedCheckBox!=null && selectedCheckBox.length>0) {
    			for (j=0; j<selectedCheckBox.length; j++) {
    				if(arrOption[i].equals(selectedCheckBox[j])) sb.append(" checked");
    			}
    		}
    	    sb.append(">").append(arrOption[i+1]).append(" ");
    	    i++;
    	}
        return sb.toString();    	
    }
    /**
     * eg. View.getCheckBoxOption("field","fd8","select id, codeId||'-'||codeName from CommonCode where commonCodeKind.codeKindId='TIT' order by codeId",null)
     * @param className
     * @param checkBoxFieldName
     * @param sql
     * @param selectedCheckBox
     * @return
     */
    public static String getCheckBoxOption(String className, String checkBoxFieldName, String sql, String[] selectedCheckBox) {
    	StringBuilder sb = new StringBuilder();    	
    	java.util.List list = ServiceGetter.getInstance().getCommonService().load(sql);
    	if (list!=null && list.size()>0) {
    		int j=0;
        	for(int i=0 ; i<list.size();i++){
        		Object[] o = (Object[]) list.get(i);
        		sb.append("<input class=\"" ).append( className ).append( "\" type=\"checkbox\" name=\"" ).append( checkBoxFieldName ).append( "\" value=\"" ).append( o[0] ).append( "\"");
        		if (selectedCheckBox!=null && selectedCheckBox.length>0) {
        			for (j=0; j<selectedCheckBox.length; j++) {
        				if(Common.get(o[0]).equals(selectedCheckBox[j])) sb.append(" checked");
        			}
        		}
        	    sb.append(">").append(o[1]).append(" ");
        	}    		
    	}
        return sb.toString();    	
    }    
    
    
    /**
     * 組合單選 option<br>
     * View.getRadioBoxTextOption("field","fd11","1;One;2;Two;3;Three","")
     * @param textOption = 分隔符號';'，第一個表存入db的值，第2個表option
     * @param selectedOne = 被選的value
     * @return
     */    
    public static String getRadioBoxTextOption(String className, String radioFieldName, String textOption, String selectedOne) {
    	StringBuilder sb = new StringBuilder();
    	String[] arrOption = textOption.split(";");
    	for(int i=0 ; i<arrOption.length;i++){
    		sb.append("<input class=\"" ).append( className ).append( "\" type=\"radio\" id=\"" ).append( radioFieldName ).append( "\" name=\"" ).append( radioFieldName ).append( "\" value=\"" ).append( arrOption[i] ).append( "\"");
    	    if(arrOption[i].equals(selectedOne)) sb.append(" checked");
    	    sb.append(">").append(arrOption[i+1]).append(" ");
    	    i++;
    	}    	
        return sb.toString();    	
    }    
    /**
     * eg. View.getRadioBoxOption("field","fd9","select id, codeId||'-'||codeName from CommonCode where commonCodeKind.codeKindId='TIT' order by codeId","")
     * @param className
     * @param checkBoxFieldName
     * @param sql
     * @param selectedOne
     * @return
     */
    public static String getRadioBoxOption(String className, String checkBoxFieldName, String sql, String selectedOne) {
    	StringBuilder sb = new StringBuilder();    	
    	java.util.List list = ServiceGetter.getInstance().getCommonService().load(sql);
    	if (list!=null && list.size()>0) {
        	for(int i=0 ; i<list.size();i++){
        		Object[] o = (Object[]) list.get(i);
        		sb.append("<input class=\"" ).append( className ).append( "\" type=\"radio\" name=\"" ).append( checkBoxFieldName ).append( "\" value=\"" ).append( o[0] ).append( "\"");
        		if(Common.get(o[0]).equals(selectedOne)) sb.append(" checked");
        	    sb.append(">").append(o[1]).append(" ");
        	}    		
    	}
        return sb.toString();    	
    }      
    
    /**
     * <br>
     * <br>目的：組合月份01~12 option語法函數 
     * <br>參數：被選的value 
     * <br>傳回：加上html option element 
     */    
    static public String getMonthOption(String selectedOne, int defaultChoice) {
        StringBuilder sb = new StringBuilder(100);
        if (defaultChoice==1) sb.append("<option value=''>請選擇</option>");
        else if (defaultChoice==2) sb.append("<option value=''></option>");         
    	for (int i=1; i<13; i++) {
            sb.append("<option value='" ).append( Common.formatFrontZero(""+i,2) ).append( "' ");
            if (selectedOne!= null && selectedOne.equals(Common.formatFrontZero(Integer.toString(i),2))) {
                sb.append(" selected ");
            }
            sb.append(">" ).append( Common.formatFrontZero(""+i,2) ).append( "</option>\n");    		
    	}
        return sb.toString();
    }     
    static public String getMonthOption(String selectedOne) {
    	return getMonthOption(selectedOne,1);
    }  
    
    /**
     * <br>
     * <br>目的：組合0~100百分比option語法函數 
     * <br>參數：被選的value 
     * <br>傳回：加上html option element 
     */    
    static public String getPercentageOption(String selectedOne) {
    	return getNumberOption(selectedOne, 1, 0, 100);
    }
    static public String getPercentageOption(String selectedOne,int defaultChoice) {
    	return getNumberOption(selectedOne, defaultChoice, 0, 100);
    }     
    /**
     * <br>
     * <br>目的：組合數字的option語法函數 
     * <br>參數：被選的value, 預設選擇, 開始數字, 結束數字
     * <br>傳回：加上html option element 
     */    
    static public String getNumberOption(String selectedOne, int defaultChoice, int startNumber, int stopNumber) {
        StringBuilder sb = new StringBuilder(100);
        if (defaultChoice==1) sb.append("<option value=''>請選擇</option>");
        else if (defaultChoice==2) sb.append("<option value=''></option>");      
    	for (int i=startNumber; i<stopNumber; i++) {
            sb.append("<option value='" ).append( i ).append( "' ");
            if (selectedOne!= null && selectedOne.equals(""+i)) {
                sb.append(" selected ");
            }
            sb.append(">" ).append( i ).append( "</option>\n");    		
    	}
        return sb.toString();
    }    
    
    /**
     * <br>
     * <br>目的：組合小時0~23 option語法函數 
     * <br>參數：被選的value 
     * <br>傳回：加上html option element 
     */    
    static public String getHourOption(String selectedOne) {
        String sb = "<option value=''>請選擇</option>";
    	for (int i=0; i<24; i++) {
            sb = sb + "<option value='" + i + "' ";
            if (selectedOne!= null && selectedOne.equals(Integer.toString(i))) {
                sb = sb + " selected ";
            }
            sb = sb + ">" + i + "</option>\n";    		
    	}
        return sb;
    }    
    
    /**
     * <br>
     * <br>目的：組合分鐘0~59 option語法函數 
     * <br>參數：被選的value 
     * <br>傳回：加上html option element 
     */    
    static public String getMinuteOption(String selectedOne) {
        String sb = "<option value=''>請選擇</option>";
    	for (int i=0; i<60; i++) {
            sb = sb + "<option value='" + i + "' ";
            if (selectedOne!= null && selectedOne.equals(Integer.toString(i))) {
                sb = sb + " selected ";
            }
            sb = sb + ">" + i + "</option>\n";    		
    	}
        return sb;
    }        
    
    
    /**
     * 組合textOption option
     * @param textOption = 分隔符號';'，第一個表value，第2個表option
     * @param selectedOne = 被選的value
     * @param defaultChoice = 0.沒有預設option, 1.請選擇, 2.有空選擇
     * @return
     */
    static public String getTextOption(String textOption , String selectedOne, int defaultChoice) {
    	StringBuilder sb = new StringBuilder();
        if (defaultChoice==1) sb.append("<option value=''>請選擇</option>");
        else if (defaultChoice==2) sb.append("<option value=''></option>");  
    	String[] arrOption = textOption.split(";");
    	for(int i=0 ; i<arrOption.length;i++){
    	    if(arrOption[i].equals(selectedOne))
    	        sb.append("<option value='").append(arrOption[i]).append("' selected>").append(arrOption[i+1]).append("</option>");
    	    else
    	        sb.append("<option value='").append(arrOption[i]).append("' >").append(arrOption[i+1]).append("</option>");
    	    i++;
    	}
        return sb.toString();
    }
    static public String getTextOption(String textOption , String selectedOne) {
    	return getTextOption(textOption,selectedOne,1);
    }
    /**
     * 功能說明：代碼輸入輔助函式
     * @param className
     * @param inputName
     * @param inputValue
     * @param chineseDesc
     * @param preWrod
     * @param codeKindId
     * @param fullCode
     * @param fullCodeValue
     * @return
     */
    public static String getPopCode(String className, String inputName, String inputValue, String chineseDesc, String preWord, String codeKindId, String fullCode, String fullCodeValue) {
    	return getPopCode(className, inputName, inputValue, chineseDesc, preWord, codeKindId, fullCode, fullCodeValue, null, false);
    }
    public static String getPopCode(String className, String inputName, String inputValue, String chineseDesc, String preWord, String codeKindId, String fullCode, String fullCodeValue, int[] sizeAndLen) {
    	return getPopCode(className, inputName, inputValue, chineseDesc, preWord, codeKindId, fullCode, fullCodeValue, sizeAndLen, false);
    }
    
    /**
     * 功能說明：代碼輸入輔助函式
     * @param className
     * @param inputName
     * @param inputValue
     * @param chineseDesc
     * @param preWord
     * @param codeKindId
     * @param fullCode
     * @param fullCodeValue
     * @param sizeAndLen : 0.代碼輸入欄位size, 1.代碼輸入欄位maxLength, 2.中文欄位顯示的size
     * @param hideZhName : 若只是顯示代碼, 則用成true
     * @return
     */
    public static String getPopCode(String className, String inputName, String inputValue, String chineseDesc, String preWord, String codeKindId, String fullCode, String fullCodeValue, int[] sizeAndLen, boolean hideZhName) {    	
    	String codeKind = codeKindId;
    	if (codeKindId.indexOf("&")!=-1) {
    		codeKind = codeKindId.substring(0,codeKindId.indexOf("&"));
    	}    	
    	int codeMaxLen = Common.getInt(View.getObject("select codeMaxLen from CommonCodeKind where codeKindId=" + Common.sqlChar(codeKind) + " and codeMaxLen is not null"));
    	StringBuilder sb = new StringBuilder(); 
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")!=-1) ROStr = "";
    	//popId,preWord,popKind,popCode,popCodeName,js
    	sb.append("<input class=\"").append( className ).append( "\" type=\"hidden\" id=\"" ).append( inputName ).append( "\" name=\"" ).append( inputName ).append( "\" value=\"" ).append( inputValue ).append( "\">");    	
    	sb.append("<input class=\"").append( className ).append("\" type=\"text\" style=\"ime-mode: disabled;\" name=\"").append(fullCode).append("\" size=\"").append(sizeAndLen!=null?sizeAndLen[0]:5).append("\" maxlength=\"").append(codeMaxLen>0?codeMaxLen:(sizeAndLen!=null?sizeAndLen[1]:10)).append("\"");    	
    	sb.append(" value=\"").append(fullCodeValue).append("\" onchange=\"getCodeName('" ).append( inputName ).append( "','" ).append( preWord ).append( "','" ).append( codeKindId ).append( "',this,'" ).append( inputName ).append( "Name');\">\n");
    	sb.append("<input class=\"" ).append( className ).append( ROStr ).append( "\" type=\"").append(hideZhName?"hidden":"text").append("\" id=\"" ).append( inputName ).append( "Name\" name=\"" ).append( inputName ).append( "Name\" size=\"").append(sizeAndLen!=null?sizeAndLen[2]:20).append("\" maxlength=\"50\" value=\"" ).append( chineseDesc ).append( "\">");
    	if (!("".equals(ROStr))) { 
        	sb.append("<input class=\"" ).append( className ).append( "\" type=\"button\" id=\"btn_" ).append( inputName ).append( "\" name=\"btn_" ).append( inputName ).append( "\" onclick=\"popCode('" ).append( inputName ).append( "','" ).append( preWord ).append( "','" ).append( codeKindId ).append( "','" ).append( fullCode ).append( "','" ).append( inputName ).append( "Name')\" value=\"...\" title=\"代碼輸入輔助視窗\">");         	
    	}    	
    	return sb.toString(); 
    }
    
    
    /**
     * <br>
     * <br>目的：組合popOrgan語法函數 
     * <br>參數：(1)className:css的class名稱 (2)inputName:傳回機關代碼的欄位名稱 (3)inputValue 機關代碼的值 (4)chineseDesc機關代碼的中文說明 (5)isLimit是否顯示全部機關名稱
     * <br>傳回：加上html option element 
     */
    static public String getPopOrgan(String className, String inputName, String inputValue, String chineseDesc) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")!=-1) ROStr = "";
    	sb.append("<input class=\"").append( className ).append("\" type=\"hidden\" name=\"").append(inputName).append("\" size=\"10\" maxlength=\"10\" value=\"").append(inputValue).append("\">\n");		 
    	sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"20\" maxlength=\"50\" value=\"").append(chineseDesc).append("\">]\n");    	
    	if(!"".equals(ROStr))
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popOrgan('").append(inputName).append("','").append(inputName).append("Name','N')\" value=\"...\" title=\"機關輔助視窗\">\n");
    	return sb.toString();
    } 
    
    /**
     * <br>
     * <br>目的：組合popOrgan語法函數 
     * <br>參數：(1)className:css的class名稱 (2)inputName:傳回機關代碼的欄位名稱 (3)inputValue 機關代碼的值 (4)chineseDesc機關代碼的中文說明 (5)isLimit是否顯示全部機關名稱
     * <br>傳回：加上html option element 
     */
    static public String getPopOrgan(String className, String inputName, String inputValue, String chineseDesc,String isLimit) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")!=-1) ROStr = "";
    	sb.append("<input class=\"").append( className ).append("\" type=\"hidden\" name=\"").append(inputName).append("\" size=\"10\" maxlength=\"10\" value=\"").append(inputValue).append("\">\n");		 
    	sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"20\" maxlength=\"50\" value=\"").append(chineseDesc).append("\">]\n");    	
    	if(!"".equals(ROStr))
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popOrgan('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("')\" value=\"...\" title=\"機關輔助視窗\">\n");
    	return sb.toString();
    }    
    
    /**
     * <br>
     * <br>目的：組合popOrgan語法函數
     * <br>參數：(1)className:css的class名稱 (2)inputName:傳回機關代碼的欄位名稱 (3)inputValue 機關代碼的值 (4)chineseDesc機關代碼的中文說明 (5)isLimit是否顯示全部機關名稱
     * <br>傳回：加上html option element
     */
    static public String getPopOrgan(String className, String inputName, String inputValue, String chineseDesc,String isLimit, String accYear, String manageOrgan) {
    	return getPopOrgan(className, inputName, inputValue, chineseDesc, isLimit, accYear, manageOrgan, null, null);
    }
    static public String getPopOrgan(String className, String inputName, String inputValue, String chineseDesc,String isLimit, String accYear, String manageOrgan, String fullCodeField, String fullCodeValue) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")!=-1) ROStr = "";    	
    	if (fullCodeField!=null && fullCodeField.length()>0) {
        	sb.append("<input class=\"").append( className ).append("\" type=\"text\" style=\"ime-mode: disabled;\" name=\"").append(fullCodeField).append("\" size=\"2\"");
        	sb.append(" maxlength=\"3\" value=\"").append(fullCodeValue).append("\" onchange=\"getOrgan('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( accYear ).append( "','" ).append( fullCodeField ).append( "',this);\">\n");    		
    	}    	    	
    	sb.append("<input class=\"").append( className ).append("\" type=\"hidden\" name=\"").append(inputName).append("\" id=\"").append(inputName).append("\" value=\"").append(inputValue).append("\">\n");
    	//sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"70\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">]\n");
    	sb.append("<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" id=\"").append(inputName).append("Name\" size=\"26\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">\n");
    	if(!"".equals(ROStr))
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" id=\"btn_").append(inputName).append("\" name=\"btn_").append(inputName).append("\" onclick=\"popOrgan('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( accYear ).append( "','" ).append( manageOrgan ).append( "','").append(fullCodeField).append("')\" value=\"...\" title=\"機關輔助視窗\">\n");
    	/**
    	if (fullCodeField!=null && fullCodeField.length()>0) {
    		sb.append("<input class=\"").append( className ).append("\" type=\"hidden\" id=\"").append(fullCodeField).append("\" name=\"").append(fullCodeField).append("\" value=\"").append(fullCodeValue).append("\">\n");
    	}
    	**/
    	return sb.toString();
    }      

    static public String getPopCommonDepartmentByShortCode(String className, String inputName, String inputValue, String chineseDesc) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")!=-1) ROStr = "";    	
    	sb.append("<input class='").append( className ).append("' type='text' style='ime-mode: disabled;' name='").append(inputName).append("' id='").append(inputName).append("' size='3'");
    	sb.append(" maxlength='3' value='").append(inputValue).append("' onchange=\"getCommonDepartmentByShortCode('").append(inputName).append("','").append(inputName).append("Name',this);\"/>\n");
    	sb.append("<input class='").append( className ).append( ROStr ).append( "' type='text' name='").append(inputName).append("Name' id='").append(inputName).append("Name' size='26' maxlength='256' value='").append(chineseDesc).append("'/>\n");
    	if(!"".equals(ROStr))
    	sb.append("<input class='").append( className ).append("' type='button' id='btn_").append(inputName).append("' name='btn_").append(inputName).append("' onclick=\"popCommonDepartmentByShortCode('").append(inputName).append("','").append(inputName).append("Name');\" value='...' title='受理機關輔助視窗'/>\n");
    	return sb.toString();
    }
    
    static public String getPopSubOrgan(String className, String inputName, String inputValue, String chineseDesc,String isLimit, String accYear, String manageOrgan, String fullCodeField, String fullCodeValue) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")!=-1) ROStr = "";    	
    	if (fullCodeField!=null && fullCodeField.length()>0) {
        	sb.append("<input class=\"").append( className ).append("\" type=\"text\" style=\"ime-mode: disabled;\" name=\"").append(fullCodeField).append("\" size=\"2\"");
        	sb.append(" maxlength=\"3\" value=\"").append(fullCodeValue).append("\" onchange=\"getSubOrgan('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( accYear ).append( "','" ).append( fullCodeField ).append( "',this);\">\n");    		
    	}
    	sb.append("<input class=\"").append( className ).append("\" type=\"hidden\" name=\"").append(inputName).append("\" id=\"").append(inputName).append("\" value=\"").append(inputValue).append("\">\n");
    	//sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"70\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">]\n");
    	sb.append("<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" id=\"").append(inputName).append("Name\" size=\"26\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">\n");
    	if(!"".equals(ROStr))
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" id=\"btn_").append(inputName).append("\" name=\"btn_").append(inputName).append("\" onclick=\"popSubOrgan('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( accYear ).append( "','" ).append( manageOrgan ).append( "','").append(fullCodeField).append("')\" value=\"...\" title=\"機關輔助視窗\">\n");
    	/**
    	if (fullCodeField!=null && fullCodeField.length()>0) {
    		sb.append("<input class=\"").append( className ).append("\" type=\"hidden\" id=\"").append(fullCodeField).append("\" name=\"").append(fullCodeField).append("\" value=\"").append(fullCodeValue).append("\">\n");
    	}
    	**/
    	return sb.toString();
    }   
    /**
     * 目的：組合popIncomeSubject語法函數 = 歲入科目輔助視窗
     * 
     * @param className : css的class名稱
     * @param inputName : 傳回科目代碼的欄位名稱
     * @param inputValue : 科目代碼的值
     * @param chineseDesc : 科目名稱
     * @param isLimit
     * @param accYear
     * @param fullCode
     * @param characterId
     * @return
     */
    static public String getPopIncomeSubject(String className, String inputName, String inputValue, String chineseDesc,String isLimit, String accYear, String fullCode, String fullCodeValue, String characterId) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")!=-1) ROStr = "";
    	sb.append("<input class=\"").append( className ).append("\" type=\"text\" name=\"").append(fullCode).append("\" size=\"8\"");
    	sb.append(" maxlength=\"8\" value=\"").append(fullCodeValue).append("\" onchange=\"getIncomeSubject('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( accYear ).append( "','" ).append( fullCode ).append( "','" ).append( characterId ).append( "',this);\">\n");
    	
    	sb.append("<input class=\"").append( className ).append("\" type=\"hidden\" name=\"").append(inputName).append("\" size=\"2\" maxlength=\"10\" value=\"").append(inputValue).append("\">\n");
    	if("".equals(ROStr))
    		sb.append("<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"45\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">\n");    	
    	else
    		sb.append("<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"45\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">\n");
    		//sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"45\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">]\n");
    	if(!"".equals(ROStr))
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popIncomeSubject('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( accYear ).append( "','" ).append( fullCode ).append( "','" ).append( characterId ).append( "')\" value=\"...\" title=\"歲入科目代碼輔助視窗\">\n");
    	return sb.toString();
    }       
    
    /**
     * 目的：組合popASType語法函數 = 歲出科目輔助視窗
     * 
     * @param className
     * @param inputName
     * @param inputValue
     * @param chineseDesc
     * @param isLimit
     * @param accYear
     * @param fullCode
     * @param fullCodeValue
     * @param characterId
     * @return
     */
    static public String getPopASType(String className, String inputName, String inputValue, String chineseDesc,String isLimit, String accYear, String fullCode, String fullCodeValue, String characterId) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")!=-1) ROStr = "";
    	sb.append("<input class=\"").append( className ).append("\" type=\"text\" name=\"").append(fullCode).append("\" size=\"8\"");
    	sb.append(" maxlength=\"10\" value=\"").append(fullCodeValue).append("\" onchange=\"getASType('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( accYear ).append( "','" ).append( fullCode ).append( "','" ).append( characterId ).append( "',this);\">\n");    	
    	sb.append("<input class=\"").append( className ).append("\" type=\"hidden\" name=\"").append(inputName).append("\" size=\"10\" maxlength=\"10\" value=\"").append(inputValue).append("\">\n");
    	if("".equals(ROStr))
    		sb.append("<input class=\"").append( className ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"45\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">\n");
    	else
    		sb.append("<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"45\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">\n");    	
    		//sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"45\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">]\n");
    	if(!"".equals(ROStr))
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popASType('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( accYear ).append( "','" ).append( fullCode ).append( "','" ).append( characterId ).append( "')\" value=\"...\" title=\"歲出科目代碼輔助視窗\">\n");
    	return sb.toString();
    }
        
    /**
     * 目的：組合popIttInspectItem語法函數 = 檢驗項目輔助視窗
     * 
     * @param className : css的class名稱
     * @param inputName : 傳回科目代碼的欄位名稱
     * @param inputValue : 科目代碼的值
     * @param chineseDesc : 科目名稱
     * @param isLimit
     * @param fullCode
     * @return
     */
    static public String getPopIttInspectItem(String className, String inputName, String inputValue, String chineseDesc,String isLimit, String fullCode, String fullCodeValue) {
    	return getPopIttInspectItem(className, inputName, inputValue, chineseDesc,isLimit,fullCode,fullCodeValue,"","");
    }        
    static public String getPopIttInspectItem(String className, String inputName, String inputValue, String chineseDesc,String isLimit, String fullCode, String fullCodeValue, String jsGet, String jsPop) {
    	return getPopIttInspectItem(className, inputName, inputValue, chineseDesc,isLimit,fullCode,fullCodeValue,jsGet,jsPop,"");
    }      
    static public String getPopIttInspectItem(String className, String inputName, String inputValue, String chineseDesc,String isLimit, String fullCode, String fullCodeValue, String jsGet, String jsPop, String cccCode) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")!=-1) ROStr = "";
    	jsGet = Common.get(jsGet);
    	jsPop = Common.get(jsPop);
    	sb.append("<input class=\"").append( className ).append("\" type=\"text\" name=\"").append(fullCode).append("\" style=\"ime-mode: disabled;\" size=\"6\"");
    	sb.append(" maxlength=\"7\" value=\"").append(fullCodeValue).append("\" onchange=\"getIttInspectItem('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( fullCode ).append( "',this,'").append(Common.get(jsGet)).append("','").append(Common.get(cccCode)).append("');").append(jsGet).append("\">\n");
    	
    	sb.append("<input class=\"").append( className ).append("\" type=\"hidden\" name=\"").append(inputName).append("\" size=\"2\" maxlength=\"10\" value=\"").append(inputValue).append("\">\n");
    	sb.append("<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"30\" maxlength=\"256\" value=\"").append(chineseDesc).append("\">\n");
    	if(!"".equals(ROStr))
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popIttInspectItem('").append(inputName).append("','").append(inputName).append("Name','").append(isLimit).append("','" ).append( fullCode ).append( "','").append(jsPop).append("','").append(Common.get(cccCode)).append("');\" value=\"...\" title=\"檢驗項目輔助視窗\">\n");
    	return sb.toString();
    }     
    
     
    /**
     * <br>
     * <br>目的：組合PopProperty語法函數 
     * <br>參數：(1)className:css的class名稱 (2)inputName:傳回財產編號的欄位名稱 (3)inputValue 財產編號的值 (4)chineseDesc財產編號的中文說明 (5)preWord財產編號的前置詞
     * <br>傳回：加上html option element 
     */
    static public String getPopProperty(String className, String inputName, String inputValue, String chineseDesc, String preWord) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if (className.indexOf("RO")>0) {
    		ROStr="";
    		sb.append("[<input class=\"").append( className ).append("\" type=\"text\" name=\"").append(inputName).append("\" size=\"10\" maxlength=\"11\" value=\"").append(inputValue).append("\">");
    		sb.append("<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"20\" maxlength=\"50\" value=\"").append(chineseDesc).append("\">]\n");    		
    	} else {
    		sb.append("<input class=\"").append( className ).append("\" type=\"text\" name=\"").append(inputName).append("\" size=\"10\" maxlength=\"11\" value=\"").append(inputValue).append("\" onBlur=\"getProperty('").append(inputName).append("','").append(inputName).append("Name','").append(preWord).append("');\">\n");
        	if(!"".equals(ROStr)) sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popProperty('").append(inputName).append("','").append(inputName).append("Name','").append( preWord ).append("')\" value=\"...\" title=\"財產編號輔助視窗\">\n");    	
        	sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"20\" maxlength=\"50\" value=\"").append(chineseDesc).append("\">]\n");    		
    	}
        return sb.toString();
    } 
    
    
    /**
     * <br>
     * <br>目的：組合popStore語法函數 
     * <br>參數：(1)className:css的class名稱 (2)inputName:傳回廠商編號的欄位名稱 (3)inputValue 廠商編號的值 (4)chineseDesc廠商編號的中文說明
     * <br>傳回：加上html option element 
     */
    static public String getPopStoreNo(String className, String inputName, String inputValue, String chineseDesc) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	sb.append("<input class=\"").append( className ).append("\" type=\"text\" name=\"").append(inputName).append("\" size=\"10\" maxlength=\"10\" value=\"").append(inputValue).append("\">\n");		 
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popStore('").append(inputName).append("','").append(inputName).append("Name')\" value=\"...\" title=\"廠商輔助視窗\">\n");
    	sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"20\" maxlength=\"50\" value=\"").append(chineseDesc).append("\">]\n");
        return sb.toString();
    }     

    
    /**
     * <br>
     * <br>目的：組合popDocNo語法函數
     * <br>參數：(1)className:css的class名稱 (2)inputName:傳回文號編號的欄位名稱 (3)inputValue 文號編號的值 (4)chineseDesc文號編號的中文說明
     * <br>傳回：加上html option element 
     */
    static public String getPopDocNo(String className, String inputName, String inputValue, String chineseDesc) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	sb.append("<input class=\"").append( className ).append("\" type=\"text\" name=\"").append(inputName).append("\" size=\"5\" maxlength=\"5\" value=\"").append(inputValue).append("\">\n");		 
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popDocNo('").append(inputName).append("','").append(inputName).append("Name')\" value=\"...\" title=\"文號輔助視窗\">\n");
    	sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"20\" maxlength=\"50\" value=\"").append(chineseDesc).append("\">]\n");
        return sb.toString();
    }  
    
    /**
     * <br>
     * <br>目的：組合popKeepUnit語法函數 
     * <br>參數：(1)className:css的class名稱 (2)inputName:傳回保管單位編號的欄位名稱 (3)inputValue 保管單位編號的值 (4)chineseDesc保管單位編號的中文說明
     * <br>傳回：加上html option element 
     */
    static public String getPopKeepUnit(String className, String inputName, String inputValue, String chineseDesc) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	sb.append("<input class=\"").append( className ).append("\" type=\"text\" name=\"").append(inputName).append("\" size=\"5\" maxlength=\"5\" value=\"").append(inputValue).append("\">\n");		 
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popKeepUnit('").append(inputName).append("','").append(inputName).append("Name')\" value=\"...\" title=\"保管單位輔助視窗\">\n");
    	sb.append("[<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("Name\" size=\"20\" maxlength=\"50\" value=\"").append(chineseDesc).append("\">]\n");
        return sb.toString();
    }      
    /**
     * <br>
     * <br>目的：組合popCalendar語法函數 
     * <br>參數：(1)className:css的class名稱 (2)inputName:傳回日期的欄位名稱 (3)inputValue 日期的值
     * <br>傳回：加上html option element 
     */
    static public String getPopCalendar(String className, String inputName, String inputValue) {
    	return getPopCalendar(className, inputName, inputValue, null);
    }     
    static public String getPopCalndar(String className, String inputName, String inputValue) {
    	return getPopCalendar(className, inputName, inputValue, null);
    }    
    static public String getPopCalndar(String className, String inputName, String inputValue, String jsFunction) {
    	return getPopCalendar(className, inputName, inputValue, jsFunction);
    }     
    static public String getPopCalendar(String className, String inputName, String inputValue, String jsFunction) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("<input class=\"").append( className ).append("\" type=\"text\" name=\"").append(inputName).append("\" size=\"7\" maxlength=\"7\" style=\"ime-mode: disabled;\" value=\"").append(inputValue).append("\"");    	
    	if (jsFunction!=null && jsFunction.length()>0) {
    		sb.append(" onchange=\"").append(jsFunction).append("\"");
    	}    	
    	sb.append("\">\n");		 
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"popCalendar('").append(inputName).append("&js=").append(jsFunction!=null?jsFunction:"").append("')\" value=\"...\" title=\"萬年曆輔助視窗\">\n");
        return sb.toString();
    }    

    /**
     * <br>
     * <br>目的：組合popUpload語法函數 
     * <br>參數：(1)className:css的class名稱 (2)inputName:檔案上傳欄位名稱 (3)inputValue 檔案名稱
     * <br>傳回：一個檔案上傳欄位, 上傳及下載檔案按鈕各一個
     * <br>2005/10/22
     */
    public static String getPopUpload(String className, String inputName, String inputValue) {
    	return getPopUpload(className, inputName, inputValue, false);
    }  
    public static String getPopUpload(String className, String inputName, String inputValue, boolean isUploadOnly) {
    	return getPopUpload(className, inputName, inputValue, null, null, isUploadOnly);
    }  
    public static String getPopUpload(String className, String inputName, String inputValue, boolean isUploadOnly, String serverType) {
    	return getPopUpload(className, inputName, inputValue, null, null, isUploadOnly, null);
    }     
    public static String getPopUpload(String className, String inputName, String inputValue, String btnName1, String btnName2, boolean isUploadOnly) {
    	return getPopUpload(className, inputName, inputValue, btnName1, btnName2, isUploadOnly, null);
    } 
    public static String getPopUpload(String className, String inputName, String inputValue, String btnName1, String btnName2, boolean isUploadOnly, String serverType) {
    	StringBuilder sb = new StringBuilder();
    	String ROStr="RO";
    	if ("field".equals(className)) ROStr="_RO";
    	else if ("field_RO".equals(className)) ROStr="";
    	sb.append("<input class=\"").append( className ).append( ROStr ).append( "\" type=\"text\" name=\"").append(inputName).append("\" size=\"20\" maxlength=\"300\" value=\"").append(inputValue).append("\">\n");    	
    	sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("\" onclick=\"openUploadWindow('").append(inputName).append("','").append(inputValue).append("','").append(Common.get(serverType)).append("');\" value=\"").append(Common.get(btnName1).equals("")?"上傳檔案":btnName1).append("\">\n");
    	if (isUploadOnly==false) sb.append("<input class=\"").append( className ).append("\" type=\"button\" name=\"btn_").append(inputName).append("Download\" onclick=\"openDownloadWindow(form1.").append(inputName).append(".value);\" value=\"").append(Common.get(btnName2).equals("")?"下載檔案":btnName2).append("\">\n");    	
    	return sb.toString();
    }    
    
  	/**
  	 * <br>
  	 * <br>目的：組合查詢列表之html
  	 * <br>參數：(1)主鍵之index (2)顯示之index (3)列表集合 (4)是否有查詢旗標
  	 * <br>傳回：傳回列表之html字串
  	*/
    public static String getQuerylist(boolean primaryArray[], boolean displayArray[],
    		java.util.ArrayList objList, String queryAllFlag) {
    	return getQuerylist(primaryArray,displayArray,null,objList,queryAllFlag,true);
    }
    public static String getQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
    		java.util.ArrayList objList, String queryAllFlag) {
    	return getQuerylist(primaryArray,displayArray,arrAlign,objList,queryAllFlag,true);
    }
  	/**
  	 * <br>
  	 * <br>目的：組合查詢列表之html
  	 * <br>參數：(1)主鍵之index (2)顯示之index (3)列表集合對齊方式 (4)列表集合 (5)是否有查詢旗標
  	 * <br>傳回：傳回列表之html字串
  	*/
    public static String getQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
    		java.util.ArrayList objList, String queryAllFlag, boolean withListNo) {
    	return getQuerylist(primaryArray,displayArray,arrAlign,objList,queryAllFlag,withListNo,null,null);
    }
    public static String getQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
    		ArrayList objList, String queryAllFlag, boolean withListNo, boolean linkArray[], String target) {
    	return getQuerylist(primaryArray,displayArray,arrAlign,objList,queryAllFlag,withListNo,null,null,"");
    }
    public static String getQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
    		ArrayList objList, String queryAllFlag, boolean withListNo, boolean linkArray[], String target,String noDataMsg) {
    	return getQuerylist(primaryArray,displayArray,arrAlign,objList,queryAllFlag,withListNo,null,null,"",true);
    }
    public static String getQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
    		ArrayList objList, String queryAllFlag, boolean withListNo, boolean linkArray[], String target,String noDataMsg,boolean checkHtml) {
    	int i, counter=0;
    	boolean trFlag = false, targetFlag = false, even = false;
    	String pk = "";
    	
    	StringBuilder sb = new StringBuilder();
    	if (objList!=null && objList.size()>0) {
			String rowArray[]=new String[primaryArray.length];
			java.util.Iterator it=objList.iterator();
			
			boolean defaultRow = true;
			String defaultKey = "null";
			for(i=0;i<primaryArray.length;i++){
				if (primaryArray[i]) defaultKey = "";
			}
			
			int j=0;
			while(it.hasNext()) {
				j++;
				rowArray= (String[])it.next();
				counter++;				
				String classTR="listTROdd", classTD = "listTDOdd";				
				if (even) {
					classTR = "listTREven";
					classTD = "listTDEven";
				}				
			
				pk = "";
				for(i=0;i<primaryArray.length;i++){			
					if (primaryArray[i]) pk+=Common.escapeReturnChar(rowArray[i]);
				}				
				StringBuilder v = new StringBuilder().append(defaultKey);
				for(i=0;i<primaryArray.length;i++){
					if (primaryArray[i]) {
						if (trFlag) {
							v.append(",'").append(Common.escapeReturnChar(rowArray[i])).append("'");
						} else {
							v.append("'").append(Common.escapeReturnChar(rowArray[i])).append("'");
							trFlag = true;
						}
					}
				}
				if (targetFlag==false && target!=null && !"".equals(Common.get(target))) {
					v.append(",'").append(target).append("'");
					targetFlag = true;
				}					
				
				//顯示TR
				if (linkArray!=null) {
					sb.append(" <tr class='highLight' >");
				} else {
					sb.append(" <tr id=\"").append("listContainerRow").append(pk).append("\"");
					sb.append(" class='").append(classTR).append("' onmouseover=\"this.className='listTRMouseover'\" onmouseout=\"this.className='").append(classTR).append("'\" onClick=\"listContainerRowClick('").append(pk).append("');queryOne(");
					sb.append(v);
					sb.append(");\" >\n");					
				}
				//顯示TD
				if (withListNo) sb.append(" <td class='").append(classTD).append("' >").append(counter).append(".</td>\n");			
				targetFlag = false;
				for(i=0;i<displayArray.length;i++){
					if (displayArray[i]) {
						if (arrAlign!=null && arrAlign.length>0) {
							sb.append(" <td class='").append(classTD).append("' style=\"text-align:").append(arrAlign[i]).append("\">"); //.append(Common.get(rowArray[i])).append("</td>\n");
						} else {
							sb.append(" <td class='").append(classTD).append("' >");
						}
						if (linkArray!=null && linkArray[i]) {
							sb.append("<a href='#' class='sLink2' onClick=\"listContainerRowClick('").append(pk).append("');queryOne(").append(v).append(",").append(i).append(")\"");
							sb.append(">").append(checkHtml?Common.checkGet(rowArray[i]):Common.get(rowArray[i])).append("</a>");
						} else sb.append(checkHtml?Common.checkGet(rowArray[i]):Common.get(rowArray[i]));
						if (defaultRow) { //預設選取欄位
							sb.append("<script type=\"text/javascript\">");
							sb.append("if(typeof queryOne == 'function') {"); 
							sb.append("	if (isObj(document.all.item('state')) && document.all.item('state').value=='queryAllSuccess') {");
							sb.append(" listContainerRowClick('").append(pk).append("');");
							sb.append("	queryOne(").append(v).append(",-1);");
							sb.append("	}");
							sb.append("}");
							sb.append("</script>");							
							//sb.append("<input type='hidden' name='listContainerRowDefault' id='listContainerRowDefault' value=\"" ).append( v ).append( "\">");
							defaultRow = false;
						}
						sb.append("</td>\n");
					}
				}
				sb.append("</tr>\n");
				trFlag = false;
				even = !even;
			}
    	} else {
    		if ("true".equals(queryAllFlag)) sb.append(" <tr class='highLight' ><td class='listTD' colspan='100'>").append("".equals(Common.get(noDataMsg))?"查無資料，請您重新輸入查詢條件！":noDataMsg).append("</td></tr>");
    	}
		return sb.toString();
    }    
               
    /**
     * 組出有checkbox的query List
     *
     * @param primaryArray
     * @param displayArray
     * @param arrAlign
     * @param objList
     * @param queryAllFlag
     * @param checkboxName
     * @return
     */
    public static String getCheckboxQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
            ArrayList objList, String queryAllFlag, String checkboxName) {
    	return getCheckboxQuerylist(primaryArray, displayArray, arrAlign, objList, queryAllFlag, checkboxName, null, null);
    }
    public static String getCheckboxQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
    		ArrayList objList, String queryAllFlag, String checkboxName, boolean linkArray[], String target) {
    	return getCheckboxQuerylist(primaryArray, displayArray, arrAlign, objList, queryAllFlag, checkboxName, linkArray, target, null);
    }  
    public static String getCheckboxQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
    		ArrayList objList, String queryAllFlag, String checkboxName, boolean linkArray[], String target, String className) {
    	return getCheckboxQuerylist(primaryArray, displayArray, arrAlign, objList, queryAllFlag, checkboxName, linkArray, target, className, -1, false);
    }  
    public static String getCheckboxQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
    		ArrayList objList, String queryAllFlag, String checkboxName, boolean linkArray[], String target, String className, int column, boolean disable) {
    	return getCheckboxQuerylist(primaryArray, displayArray, arrAlign, objList, queryAllFlag, checkboxName, linkArray, target, className, column, disable, true);
    }
    public static String getCheckboxQuerylist(boolean primaryArray[], boolean displayArray[], String[] arrAlign,
    		ArrayList objList, String queryAllFlag, String checkboxName, boolean linkArray[], String target, String className, int column, boolean disable, boolean checkHtml) {
    	int i, counter=0;
    	boolean trFlag = false, targetFlag = false;
    	//boolean even = true;
    	StringBuilder sb = new StringBuilder();
    	if (objList!=null && objList.size()>0) {
			java.util.Iterator it=objList.iterator();
			while(it.hasNext()) {
				String[] rowArray = (String[])it.next();
				counter++;
//				String classTR="listTROdd", classTD = "listTDOdd";
//				if (even) {
//					classTR = "listTREven";
//					classTD = "listTDEven";
//				}
				//顯示TR
				//sb.append(" <tr class='highLight' onClick=\"queryOne(");
				sb.append(" <tr class='highLight' >");
				StringBuilder v = new StringBuilder().append("");
				for(i=0;i<primaryArray.length;i++){
					if (primaryArray[i]) {
						if (trFlag) {
							v.append(",'").append(rowArray[i]).append("'");
						} else {
							v.append("'").append(rowArray[i]).append("'");
						trFlag = true;
						}
					}
				}
				//if (target!=null && !"".equals(Common.get(target))) v.append(",'").append(target).append("'");
				//sb.append(v).append(")\" >\n");

				//依照column判斷，disable為true代表有值時disable CheckBox，disable為false代表無值時disable CheckBox。
				String dc = ""; 
				if(column >= 0 && column < displayArray.length){
					if(( disable && Common.get(rowArray[column]).length() > 0) ||
					   (!disable && Common.get(rowArray[column]).equals(""))){
						dc = "disabled";
					}
				}
				//顯示TD
				if (className!=null && !"".equals(Common.get(className))) {
					sb.append(" <td class='listTD' >").append("<input type='checkbox' ").append(dc).append(" class='").append(className).append("' id=\"").append(checkboxName).append("\" name=\"").append(checkboxName).append("\" value=\"").append(v.toString().replaceAll("'", "")).append("\"></td>\n");
				} else {
					sb.append(" <td class='listTD' >").append("<input type='checkbox' ").append(dc).append(" id=\"").append(checkboxName).append("\" name=\"").append(checkboxName).append("\" value=\"").append(v.toString().replaceAll("'", "")).append("\"></td>\n");
				}				
				targetFlag = false;
				for(i=0;i<displayArray.length;i++){
					if (displayArray[i]) {
						if (targetFlag==false && target!=null && !"".equals(Common.get(target))) {
							v.append(",'").append(target).append("'");
							targetFlag = true;
						}

						if (arrAlign!=null && arrAlign.length>0) {
							sb.append(" <td class='listTD' style=\"text-align:").append(arrAlign[i]).append("\">"); //.append(Common.get(rowArray[i])).append("</td>\n");
						} else {
							sb.append(" <td class='listTD' >");
						}
						if (linkArray!=null && linkArray[i]) {
							sb.append("<a href='#' class='sLink2' onClick=\"queryOne(").append(v).append(",").append(i).append(")\"");
							//if (target!=null && !"".equals(Common.get(target))) sb.append(" target=\"").append(target).append("\"");
							sb.append(">").append(checkHtml?Common.checkGet(rowArray[i]):Common.get(rowArray[i])).append("</a>");
						} else sb.append(checkHtml?Common.checkGet(rowArray[i]):Common.get(rowArray[i]));

						sb.append("</td>\n");
					}
				}
				sb.append("</tr>\n");
				trFlag = false;
			}
    	} else {
    		if ("true".equals(queryAllFlag)) sb.append(" <tr class='highLight' ><td class='listTD' colspan='100'>查無資料，請您重新輸入查詢條件！</td></tr>");
    	}
		return sb.toString();
    }
        
    public static Object getObject(String sql) {        
        try {
        	return ServiceGetter.getInstance().getCommonService().getObject(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return null;
    }
    
    public static Object[] getObjects(String sql) {        
        try {
        	return ServiceGetter.getInstance().getCommonService().getObjects(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return null;
    }    
    
    /**
     * 取出某類別(codeKindId)的單一共用代碼(CommonCode)的中文說明(CodeName)  
     * @param list
     * @param codeId
     * @return codeName
     */
    public static String getCommonCodeNameByCodeId(List list, String codeId) {
    	String result = "";
    	if ((list!=null) && codeId!=null) {
    		for(int i=0; i<list.size(); i++){
    		  CommonCode c = (CommonCode)list.get(i);
        	  if (codeId.equals(c.getCodeId())){
        	      result = c.getCodeName();
                  break;
        	  }        	  
    	    }
    	}	
        return result;
    }
    
    public static String getCommonDeptOption(String selectedShortCode,int defaultChoice) {
    	//String hql = "select shortCode, department from CommonDepartment where shortCode is not null and shortCode!='' order by fullCode";
    	//return getOption(hql, selectedShortCode, false, defaultChoice);    	
    	return getCommonDeptOption(selectedShortCode, null, defaultChoice);
    }
    
    public static String getCommonDeptOption(String selectedShortCode,Integer level, int defaultChoice) {
    	String hql = "select shortCode, shortCode||'-'||department from CommonDepartment where 1=1 ";
    	if (level!=null) hql += " and level=" + level;
    	hql += " and shortCode is not null order by shortCode";
    	return getOption(hql, selectedShortCode, false, defaultChoice);
    }       
    public static String getCommonDeptName(String deptShortCode) {
    	try {
    		if (!"".equals(Common.get(deptShortCode))) {
        		com.kangdainfo.common.model.bo.CommonDepartment dept = ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getCommonDepartment(deptShortCode);
        		if (dept!=null) return Common.get(dept.getDepartment());    			
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		return Common.get(deptShortCode);
    	}
    	return Common.get(deptShortCode);
    }
    
    public static com.kangdainfo.common.model.bo.CommonDepartment getCommonDept(String deptShortCode) {
    	try {
    		if (!"".equals(Common.get(deptShortCode))) {
    			return ServiceGetter.getInstance().getCommonService().getCommonDepartmentDao().getCommonDepartment(deptShortCode);
    		}    		    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    	return null;
    }    
    public static String getCommonCodeName(String codeKindId, String codeId) {
    	return Common.get(ServiceGetter.getInstance().getCommonService().getCommonCodeDao().getCommonCodeName(codeKindId, codeId));
    }    
    public static com.kangdainfo.common.model.bo.CommonCode getCommonCode(String codeKindId, String codeId) {
    	return ServiceGetter.getInstance().getCommonService().getCommonCodeDao().getCommonCode(codeKindId, codeId);
    }    
    public static String getLookupField(String sql) {        
        try {
        	return Common.get(ServiceGetter.getInstance().getCommonService().getObject(sql));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return "";
    }
    
    public static String getLookupField(String sql, Object id) {        
        try {
        	List list = ServiceGetter.getInstance().getCommonService().find(sql,id);
        	if (list!=null && list.size()>0) {
        		return Common.get(list.get(0));        			
        	}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	return "";
    }    
    
    public static String getJasperReportFormatOption(String selectedOne) {     
        StringBuilder sb = new StringBuilder().append("<option value=''>請選擇</option>");
    	String[] formatId = new String[]{ReportEnvironment.VAL_FORMAT_PDF,ReportEnvironment.VAL_FORMAT_XLS,ReportEnvironment.VAL_FORMAT_TIF,ReportEnvironment.VAL_FORMAT_CSV,ReportEnvironment.VAL_FORMAT_DOCX,ReportEnvironment.VAL_FORMAT_XLSX,ReportEnvironment.VAL_FORMAT_PPTX};
    	String[] formatName = {"PDF","Excel","TIF","CSV","DOCX","XLSX","PPTX"};
    	//ReportEnvironment.VAL_FORMAT_VIEWER,ReportEnvironment.VAL_FORMAT_HTML,
    	//"PRINT","HTML",
        try {
    		for (int i=0; i<formatId.length; i++) {
                sb.append("<option value='").append(formatId[i]).append("' ");
                if (selectedOne!= null && selectedOne.equals(formatId[i])) {
                    sb.append(" selected ");
                }
                sb.append(">").append(formatName[i]).append("</option>\n");    			
    		}        	
        } catch (Exception ex) {
            sb.append("<option value=''>查詢錯誤</option>");
            ex.printStackTrace();
        }
        return sb.toString();
    }    	
}