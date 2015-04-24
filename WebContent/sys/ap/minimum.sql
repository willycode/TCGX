insert into COMMON_VERSION(id,bitYN,versionDescription) values(1,'Y','init');
insert into COMMON_CODEKIND(codeKindId,codeKindName) values('MSG','訊息管理');
insert into COMMON_CODEKIND(codeKindId,codeKindName) values('TIT','職稱');
insert into COMMON_CODE(codeKindId,codeId,codeName) values(1,'01','最新消息');
insert into COMMON_CODE(codeKindId,codeId,codeName) values(1,'02','檔案下載');
insert into COMMON_CODE(codeKindId,codeId,codeName) values(2,'01','主管/經理');
insert into COMMON_CODE(codeKindId,codeId,codeName) values(2,'02','職員/員工');
INSERT INTO COMMON_GROUP (groupName,groupDesc,editId,editDate,editTime) VALUES ('Administraors','最高權限管理者',null,null,null);
INSERT INTO COMMON_GROUP (groupName,groupDesc,editId,editDate,editTime) VALUES ('PowerUsers','業務管理者',null,null,null);
INSERT INTO COMMON_GROUP (groupName,groupDesc,editId,editDate,editTime) VALUES ('Users','一般使用者','系統管理者','0960915','204235');
INSERT INTO COMMON_DEPARTMENT(parentId,lev,departmentCode,department,shortName,fullName,fullCode,preFullCode,phone,fax,zip,address,email,notes,homepage,chiefTitle,chiefName,isSchool,schoolType,editId,editDate,editTime) VALUES (null,0,'01','系統預設機關',null,'系統預設機關','0100000000000',null,null,null,null,null,null,'',null,null,null,null,null,null,null,null);
INSERT INTO COMMON_USER (userId,userSSN,userPWD,userName,groupId,roleId,deptId,userTitle,userTel,userMobile,userFax,userEmail,takeJobDate,isStop,isDeptManager,isAdministrator,memo,editId,editDate,editTime) VALUES ('admin',null,'edc4f833b30477e0c859c16cfb2a72dfbb8acca6','admin',1,3,1,null,null,null,null,null,null,'N',null,null,'test','admin','0961010','185418');

INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (1,-11,-11,'系統管理','','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (4,-11,1,'權限管理','','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (5,-11,1,'代碼管理','','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (7,-11,1,'訊息管理','','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (14,-11,1,'工具程式','','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (2,-11,4,'群組及授權維護作業','../sys/ap/sysap002f.jsp','','','','','','SYSAP002','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (3,-11,4,'使用者管理','../sys/ap/sysap001f.jsp','','','','','','SYSAP001','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (18,-11,4,'功能選單查身份別','../sys/ap/sysap003r.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (6,-11,5,'共用代碼維護作業','../sys/ca/sysca001f.jsp','','','','','','SYSCA001','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (9,-11,5,'機關代碼管理','../sys/ca/sysca002f.jsp','','','','','','SYSCA002F','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (10,-11,5,'CPA機關代碼管理','../sys/ca/sysca002f_cpa.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (11,-11,5,'CPA機關代碼轉入作業','../sys/ca/sysca002f_cpa_import.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (24,-11,5,'報表範例-代碼報表','../sys/ex/sysex900r.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (8,-11,7,'訊息公告','../sys/wm/syswm001f.jsp','','','','','','SYSWM001','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (13,-11,7,'訊息傳送','../sys/wm/syswm003f.jsp','','','','','','SYSWM003','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (15,-11,14,'SQL指令查詢','../sys/ap/querySQL.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (16,-11,14,'SQL指令更新','../sys/ap/updateSQL.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (17,-11,14,'功能選單匯出作業','../sys/ap/functionSQL.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (19,-11,14,'移除鎖定之使用者','../sys/ap/sysap005f.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (20,-11,14,'系統日誌查詢','../sys/ap/sysap006r.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (21,-11,14,'系統上線狀況查詢','../sys/ds/sysds805r.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (22,-11,14,'使用者登出入紀錄查詢','../sys/ds/sysds801r.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (25,-11,1,'系統參數','','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (26,-11,25,'FTP設定','../sys/ap/sysap102f.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (27,-11,25,'SMTP設定','../sys/ap/sysap106f.jsp','','','','','','','',1000);
INSERT INTO COMMON_DTREE (id,sysid,pid,name,url,title,target,icon,iconOpen,opened,btnRead,btnWrite,sorted) VALUES (28,-11,25,'管理者Email設定','../sys/ap/sysap108f.jsp','','','','','','','',1000);

