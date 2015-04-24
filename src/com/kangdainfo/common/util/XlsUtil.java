package com.kangdainfo.common.util;

import java.io.*;

import jxl.*; 
import jxl.write.*; 

import org.apache.poi.hssf.usermodel.*;

/**
 * Retrieve Excel File Utility
 *
 * @version 1.0, May 2, 2006
 * @author  clive.chang
 * @since   TAJK Project
 */

public class XlsUtil {
    
    private String xlsFileName;
    public void setXlsFileName(String s) { xlsFileName = Common.set(s); }
    public String getXlsFileName() { return Common.get(xlsFileName); }    
    
    public XlsUtil() {}
    
    public java.io.File genXlsFile(java.util.List<String> list, String seperator) throws Exception {
    	java.util.Map<String, java.util.List<Object[]>> rs = new java.util.HashMap<String, java.util.List<Object[]>>();
    	if (list!=null && list.size()>0) {
    		java.util.List<Object[]> dataList = new java.util.ArrayList<Object[]>();
    		for (int i=0; i<list.size(); i++) {
    			String s = list.get(i);
    			if (s!=null && s.length()>0) {
    				dataList.add(s.split(seperator!=null?seperator:","));		
    			}
    		}
    		rs.put("Sheet1", dataList);
    	}
    	return genXlsFile(rs);
    }        
    public java.io.File genXlsFile(java.util.List<Object[]> list) throws Exception {
    	java.util.Map<String, java.util.List<Object[]>> rs = new java.util.HashMap<String, java.util.List<Object[]>>();
    	rs.put("Sheet1", list);
    	return genXlsFile(rs);
    }    
    public java.io.File genXlsFile(java.util.Map<String, java.util.List<Object[]>> rs) throws Exception {
    	if (rs!=null && rs.size()>0) {
    		int rowIdx=0,colIdx=0, j=0;
    		java.io.File f = new File(System.getProperty("java.io.tmpdir")+File.separator+(getXlsFileName().equals("")?Common.getVMID()+".xls":getXlsFileName()));    		
    		WritableWorkbook wb = Workbook.createWorkbook(f);
    		int sheetNumber = 0;
    		for (String key : rs.keySet()) {
    			WritableSheet sheet = wb.createSheet(key, sheetNumber); 
    			java.util.List<Object[]> list = rs.get(key);    	    				
    			if (list!=null && list.size()>0){ 
    				for (int i = 0 ; i < list.size() ; i ++){
    					Object[] row = list.get(i);				    							
    					for (j = 0 ; j < row.length ; j ++){
    						WritableCell cell = sheet.getWritableCell(colIdx+j,rowIdx+i);
    						if (row[j]!=null) {
    							WritableCell updateCell = null;
    							if (row[j] instanceof java.lang.String) {
    								if (cell.getCellFormat()!=null)	updateCell = new Label(colIdx+j, rowIdx+i, Common.get(row[j]),cell.getCellFormat());
    								else updateCell = new jxl.write.Label(colIdx+j, rowIdx+i, Common.get(row[j]));
    							} else if (row[j] instanceof java.lang.Number) {					    
    								if (cell.getCellFormat()!=null) updateCell = new jxl.write.Number(colIdx+j, rowIdx+i, Common.getNumeric(row[j]), cell.getCellFormat());						
    								else updateCell = new jxl.write.Number(colIdx+j, rowIdx+i, Common.getNumeric(row[j]));
    							} else if (row[j] instanceof java.lang.Boolean) {
    								if (cell.getCellFormat()!=null) updateCell = new jxl.write.Boolean(colIdx+j, rowIdx+i,(java.lang.Boolean)row[j], cell.getCellFormat());
    								else updateCell = new jxl.write.Boolean(colIdx+j, rowIdx+i,(java.lang.Boolean)row[j]);
    							} else if (row[j] instanceof java.util.Date) {
    								if (cell.getCellFormat()!=null) updateCell = new jxl.write.DateTime(colIdx+j, rowIdx+i, (java.util.Date)row[j], cell.getCellFormat());
    								else updateCell = new jxl.write.DateTime(colIdx+j, rowIdx+i, (java.util.Date)row[j]);
    							} else {
    								if (cell.getCellFormat()!=null)	updateCell = new jxl.write.Label(colIdx+j, rowIdx+i, Common.get(row[j]), cell.getCellFormat());
    								else updateCell = new jxl.write.Label(colIdx+j, rowIdx+i, Common.get(row[j]));
    							}					
    							try {
    								sheet.addCell(updateCell);
    							}  catch (Exception e) {
    								System.out.println(row[j]);
    								e.printStackTrace();
    							}						
    						}  						
    					}				
    				}
    			}
    			sheetNumber++;
    		}
    		wb.write();			
			wb.close();
			return f;
    	}
    	return null;
    }
    
    
    /**
     *
     * @param      fileName       the excel file path.
     * @param	  sheetNumber    the excel sheet number, from 0 ~ n.
     * @param	  includeHeader  include first column or not. True/False.
     * @param	  intArraySize   the size of inner array.
     * @return     the <code>ArrayList</code> object.
     * @exception  Exception if excel file does not found.
     *
     */
    public java.util.List<String[]> getJExcelModel(String fileName, int sheetNumber, boolean includeHeader, Integer intArraySize) throws Exception {
        setXlsFileName(fileName);
        java.util.List<String[]> objList=new java.util.ArrayList<String[]>();
        try {
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            Sheet s = workbook.getSheet(sheetNumber);
            Cell[] row = null;
            String rowArray[];
            for (int i = 0 ; i < s.getRows() ; i++) {
                row = s.getRow(i);
                if (row!=null && row.length > 0) {
                    rowArray = new String[intArraySize!=null?intArraySize:row.length];
                    for (int j = 0; j < rowArray.length; j++) {
                    	if (row.length>j) rowArray[j] = Common.get(row[j].getContents()).replaceAll("'", "").replaceAll("\"", "");
                    	else rowArray[j] = "";                    	
                        //if (j>=row.length) rowArray[j] = "";
                        //else rowArray[j] = Common.get(row[j].getContents()).replaceAll("'", "").replaceAll("\"", "");
                    }
                    if (includeHeader) {
                        objList.add(rowArray);
                    } else if (i>0) {
                        objList.add(rowArray);
                    }
                }
            }
            workbook.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return objList;
    }
    
    public java.util.List<String[]> getJExcelModel(String fileName, String sheetName, boolean includeHeader, Integer intArraySize) throws Exception {
        setXlsFileName(fileName);
        java.util.List<String[]> objList=new java.util.ArrayList<String[]>();
        try {
            Workbook workbook = Workbook.getWorkbook(new File(fileName));
            Sheet s = workbook.getSheet(sheetName);
            Cell[] row = null;
            String rowArray[];
            for (int i = 0 ; i < s.getRows() ; i++) {
                row = s.getRow(i);
                if (row!=null && row.length > 0) {
                    rowArray = new String[intArraySize!=null?intArraySize:row.length];
                    for (int j = 0; j < rowArray.length; j++) {
                        if (row.length>j) rowArray[j] = Common.get(row[j].getContents()).replaceAll("'", "").replaceAll("\"", "");
                        else rowArray[j] = "";
                    }
                    if (includeHeader) {
                        objList.add(rowArray);
                    } else if (i>0) {
                        objList.add(rowArray);
                    }
                }
            }
            workbook.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return objList;
    }
    
    public java.util.List<String[]> getJExcelModel(String fileName, int sheetNumber, boolean includeHeader) throws Exception {
    	return getJExcelModel(fileName, sheetNumber, includeHeader, null);
    }
    
    
    /**
    *
    * @param      fileName       the excel file path.
    * @param	  sheetNumber    the excel sheet number, from 0 ~ n.
    * @param	  includeHeader  include first column or not. True/False.
    * @param	  intArraySize   the size of inner array.
    * @return     the <code>ArrayList</code> object.
    * @exception  Exception if excel file does not found.
    *
    */
   public java.util.List<Object[]> getPOIModel(String fileName, int sheetNumber, boolean includeHeader, Integer intArraySize) throws Exception {
       setXlsFileName(fileName);
       java.util.List<Object[]> objList=new java.util.ArrayList<Object[]>();
       try {
    	   HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(fileName));
    	   HSSFSheet sheet = wb.getSheetAt(sheetNumber);
    	   HSSFCell cell = null;    	   
    	   HSSFRow row = null;
    	   for (int i=0 ; i<sheet.getPhysicalNumberOfRows();i++){
    		   row = sheet.getRow(i);
    		   if (row!=null) {
    			   Object[] rowArray = new Object[intArraySize!=null?intArraySize:row.getPhysicalNumberOfCells()];
    			   for (int j = 0; j < rowArray.length; j++) {
    				   cell = row.getCell(j);
    				   if (j>=row.getPhysicalNumberOfCells()) rowArray[j] = "";
    				   else if (cell != null && cell.getCellType()==HSSFCell.CELL_TYPE_STRING && cell.getRichStringCellValue()!= null && !"".equals(Common.get(cell.getRichStringCellValue()))){
    					   rowArray[j] = cell.getRichStringCellValue().getString();
    				   }
    			   }
    			   if (includeHeader) {
    				   objList.add(rowArray);
    			   } else if (i>0) {
    				   objList.add(rowArray);
    			   }				
    		   }			
    	   }	
       } catch(Exception e) {
           e.printStackTrace();
       }
       return objList;
   }
   
    public String genSQLScript(String excelFilePath, int sheetNumber) throws Exception {
        try {
            StringBuffer sb = new StringBuffer(5000).append("");
            Workbook workbook = Workbook.getWorkbook(new File(excelFilePath));
            Sheet s = workbook.getSheet(sheetNumber);
            String tableName = s.getName();
            Cell[] row = null;
            for (int i = 0 ; i < s.getRows() ; i++) {
                row = s.getRow(i);
                if (row!=null && row.length > 0) {
                    if (i==0) {
                        sb.append("create table ").append(tableName).append("( ");
                    } else {
                        sb.append("INSERT INTO " ).append( tableName ).append( " VALUES (");
                    }
                    for (int j = 0; j < row.length; j++) {
                        if (i==0) {
                            if (j==0) sb.append(Common.get(row[j].getContents()) ).append( " varchar(255) ");
                            else sb.append(",").append(Common.get(row[j].getContents()) ).append( " varchar(255) ");
                        } else {
                            if (j==0) sb.append(Common.sqlChar((row[j].getContents())));
                            else sb.append(", ").append( Common.sqlChar(row[j].getContents()));
                        }
                    }
                    sb.append(");\n\n ");
                }
            }
            workbook.close();
            return sb.toString();
        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return "";
    }
    
    public String genPOISQLScript(String excelFilePath, int sheetNumber) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(excelFilePath));
        String tableName =  wb.getSheetName(sheetNumber);
        HSSFSheet sheet = wb.getSheet(tableName);
        HSSFCell cell = null;
        try {
            StringBuffer sb = new StringBuffer(5000).append("");
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            int j = 0;
            for(int i = 0; i < rowCount; i++) {
                if (i==0) {
                    sb.append("create table ").append(tableName).append("( ");
                } else {
                    sb.append("INSERT INTO " ).append( tableName ).append( " VALUES (");
                }
                HSSFRow row = sheet.getRow(i);
                for(j=0; j<colCount; j++) {
                	cell = row.getCell(j);
                    String v = "";
                    if (cell!=null) {
                        switch(row.getCell(j).getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            v = row.getCell(j).getNumericCellValue() + "";
                            break;
                            
                        case HSSFCell.CELL_TYPE_STRING:
                            v = cell.getRichStringCellValue().getString();
                            break;
                            
                        case HSSFCell.CELL_TYPE_FORMULA:
                            v = cell.getRichStringCellValue().getString();
                            if ("".equals(Common.get(v))) {
                                try {
                                    v = row.getCell(j).getNumericCellValue()+"";
                                } catch (Exception e) {
                                    v = "";
                                    e.printStackTrace();
                                }
                            }
                            break;
                            
                        case HSSFCell.CELL_TYPE_BLANK:
                            v = cell.getRichStringCellValue().getString();
                            break;
                        default:
                            v = row.getCell(j).toString();
                        }                    	
                    }

                    
                    if (i==0) {
                        if (j==0) sb.append(Common.get(v) ).append( " varchar(255) ");
                        else sb.append(",").append(Common.get(v) ).append( " varchar(255) ");
                    } else {
                        if (j==0) sb.append(Common.sqlChar((v)));
                        else sb.append(", ").append( Common.sqlChar(v));
                    }
                }
                sb.append(");\n\n ");
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println("A POI error has occured.");
            e.printStackTrace();
        }
        return "";
    }    
    
    public String[][] toArray(String excelFilePath, int sheetNumber, int intArraySize) throws Exception {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(excelFilePath));
            Sheet s = workbook.getSheet(sheetNumber);            
            Cell[] row = null;
            java.util.HashMap<Integer,String[]> m = new java.util.HashMap<Integer,String[]>();   
            for (int i = 0 ; i < s.getRows() ; i++) {
                row = s.getRow(i);
                if (row!=null && row.length>=intArraySize) {  		            	
                    String[] rowArray = new String[intArraySize];	            	
                    for (int j = 0; j < intArraySize; j++) {
                    	if (row.length>j) Common.get(row[j].getContents());
                    	else rowArray[j] = "";                        
                    	//if (j>=row.length) rowArray[j] = "";
                        //else rowArray[j] = Common.get(row[j].getContents());
                    }
                    m.put(i,rowArray);
                }
            }            
            workbook.close();
            String[][] arrData = new String[m.size()][intArraySize];
            for (int i=0; i<m.size(); i++) {
                arrData[i] = (String[])m.get(i);
            }
            return arrData;
        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return null;
    }    
    
    public static void main(String[] args) throws Exception {
    	XlsUtil obj = new XlsUtil();    	
    	java.io.File f = null;
    	/**
    	java.util.Map<String, java.util.List<Object[]>> h = new java.util.TreeMap<String, java.util.List<Object[]>>();
    	int idx = 0;
    	for (int i=0; i<10; i++) {
    		java.util.List<Object[]> list = new java.util.ArrayList<Object[]>();
			Object[] col = new Object[10];
			for (idx=0; idx<col.length; idx++) {
				col[idx] = "col"+idx;
			}
			list.add(col);
			
    		for (int j=0; j<100; j++) {
    			Object[] r = new Object[10];
    			for (idx=0; idx<r.length; idx++) {
    				r[idx] = i*j+idx;
    			}
    			list.add(r);
    		}
    		h.put(Common.formatFrontZero(String.valueOf(i), 5), list);
    	}
    	f = obj.genXlsFile(h);
    	**/
    	
    	
    	java.util.List<String> dataList = new java.util.ArrayList<String>();    	
    	dataList.add("你好嗎,,,Hello Kitty");
    	dataList.add("x,,,Hello Kitty");
    	dataList.add("Hello Kitty");    	
    	f = obj.genXlsFile(dataList,null);  
    	
    	if (f!=null) {
    		System.out.println(f.getPath());
    	} else {
    		System.out.println("NULL FILE");
    	}     	
    	
    }
    
}
