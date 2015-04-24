package com.kangdainfo.workflow.view;

import java.util.HashMap;
import java.util.Map;

import com.kangdainfo.ServiceGetter;
import com.kangdainfo.common.util.Common;
import com.kangdainfo.common.util.SuperBean;
import com.kangdainfo.common.util.View;
import com.kangdainfo.workflow.model.bo.FramePath;
import com.kangdainfo.workflow.model.bo.WorkFlow;

public class SETUP002F extends SuperBean{


String id;
String taskName;		//節點代號(20)
String taskChName;		//節點名稱(30)

String detailId;
String parent;		    //所屬framePath
String status;			//流程-狀態
String name;            //流程-名稱
String nextFramePath;	//流程-下一節點


@Override
public void doCreate() throws Exception {	
	WorkFlow obj = new WorkFlow();	
	FramePath master = (FramePath) View.getObject("from  " + FramePath.class.getCanonicalName() + "  where id=" + Common.getInt(getId()));
	FramePath nextPath = (FramePath) View.getObject("from  " + FramePath.class.getCanonicalName() + "  where id=" + Common.getInt(getNextFramePath()));	
	obj.setParent(master);
	obj.setStatus(Common.get(status));
	obj.setName(Common.get(name));
	obj.setNextFramePath(nextPath);
	ServiceGetter.getInstance().getCommonService().save(obj);
	setDetailId(Common.get(obj.getId()));
}


@Override
public void doUpdate() throws Exception {
	WorkFlow obj = (WorkFlow) View.getObject("from " + WorkFlow.class.getCanonicalName() + "  where id=" + Common.getInt(getDetailId()));	
	if(obj != null){		
		FramePath nextPath = (FramePath) View.getObject("from " + FramePath.class.getCanonicalName() + "  where id=" + Common.getInt(getNextFramePath()));
		obj.setStatus(Common.get(status));
		obj.setName(Common.get(name));
		obj.setNextFramePath(nextPath);
		ServiceGetter.getInstance().getCommonService().update(obj);
		setDetailId(Common.get(obj.getId()));
	}else{
		throw new Exception("修改失敗，查無資料!");
	}
}

@Override
public void doDelete() throws Exception {
	ServiceGetter.getInstance().getCommonService().delete(WorkFlow.class, Common.getLong(getDetailId()));	
	setDetailId("");
}


/**
 * <br>
 * <br>目的：依主鍵查詢單一資料
 * <br>參數：無
 * <br>傳回：傳回本物件
*/

public SETUP002F  doQueryOne() throws Exception {
	SETUP002F obj = this;
	FramePath o = (FramePath) View.getObject("from  " + FramePath.class.getCanonicalName() + "   where id=" + Common.getInt(getId()));
	WorkFlow c = (WorkFlow) View.getObject(" from  " + WorkFlow.class.getCanonicalName() + "   where id="+Common.sqlChar(getDetailId()));
	if (c!=null) {
		obj.setTaskName(o.getTaskName());
		obj.setTaskChName(o.getTaskChName());
		obj.setParent(Common.get(c.getParent().getId()));
		obj.setStatus(Common.get(c.getStatus()));
		obj.setName(Common.get(c.getName()));
		obj.setNextFramePath("");
		if(null!=c.getNextFramePath()){
			obj.setNextFramePath(Common.get(c.getNextFramePath().getId()));	
		}
	} 
	else throw new Exception("查無該筆資料！");
	return obj;
}


/**
 * <br>
 * <br>目的：依查詢欄位查詢多筆資料
 * <br>參數：無
 * <br>傳回：傳回ArrayList
*/

	public java.util.ArrayList<String[]> doQueryAll() throws Exception {
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		Map<String, Object> maps = new HashMap<String, Object>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("from   " + WorkFlow.class.getCanonicalName() + "  where parent ="+Common.getLong(getId()));		

		this.processCurrentPageAttribute(ServiceGetter.getInstance().getCommonService().loadCount(sb.toString(), maps));
		if (getTotalRecord() > 0) {
			if (getState().indexOf("query")<0) 
				ServiceGetter.getInstance().getCommonService().getCommonUserDao().clear();
			
			java.util.List objList = ServiceGetter.getInstance().getCommonService().load(sb.toString(), this.getRecordStart(), this.getPageSize(), "id", true, maps);
			if (objList != null && objList.size() > 0) {
				java.util.Map<String, String> frameMap = Common.getMap("select id, '('||taskName||')'||'-'||taskChName from  " + FramePath.class.getCanonicalName());
				java.util.Iterator it = objList.iterator();
				while (it.hasNext()) {
					WorkFlow o = (WorkFlow) it.next();							
					String rowArray[] = new String[4];
					rowArray[0] = Common.get(o.getId());
					rowArray[1] = Common.get(o.getStatus());
					rowArray[2] = Common.get(o.getName());
					FramePath nextPath = o.getNextFramePath();
					if(null!=nextPath){
						rowArray[3] = Common.get(frameMap.get(Common.get(nextPath.getId())));
					} else {
						rowArray[3] = "";
					}
					arrList.add(rowArray);					
				}
			}
		}
		return arrList;
	}
	
	public String getId(){ return checkGet(id); }
	public void setId(String s){ id=checkSet(s); }
	public String getTaskName() {
		return checkGet(taskName);
	}
	public void setTaskName(String taskName) {
		this.taskName =checkSet(taskName);
	}
	public String getTaskChName() {
		return checkGet(taskChName);
	}
	public void setTaskChName(String taskChName) {
		this.taskChName =checkSet(taskChName);
	}
	public String getDetailId() {
		return checkGet(detailId);
	}
	public void setDetailId(String detailId) {
		this.detailId = checkSet(detailId);
	}
	public String getParent() {
		return checkGet(parent);
	}
	public void setParent(String parent) {
		this.parent = checkSet(parent);
	}
	public String getStatus() {
		return checkGet(status);
	}
	public void setStatus(String status) {
		this.status = checkSet(status);
	}
	public String getName() {
		return checkGet(name);
	}
	public void setName(String name) {
		this.name = checkSet(name);
	}
	public String getNextFramePath() {
		return checkGet(nextFramePath);
	}
	public void setNextFramePath(String nextFramePath) {
		this.nextFramePath = checkSet(nextFramePath);
	}
	
}


