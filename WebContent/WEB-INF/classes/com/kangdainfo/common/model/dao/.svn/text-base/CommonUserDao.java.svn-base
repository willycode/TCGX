package com.kangdainfo.common.model.dao;

import com.kangdainfo.persistence.BaseDao;
import com.kangdainfo.common.model.bo.*;

public interface CommonUserDao extends BaseDao {
	 /**
     * Save CommonUser to persistence layer.
     * @param obj CommonUser
     */
    public void saveCommonUser(CommonUser obj) throws Exception;
    
    /**
     * 一個使用者可屬於多個角色/群組時用
     * @param obj
     * @param groupIds
     * @throws Exception
     */
    public void saveCommonUser(CommonUser obj, int[] groupIds) throws Exception;

    /**
     * Update CommonUser to persistence layer.
     * @param obj CommonUser
     */
    public void updateCommonUser(CommonUser obj) throws Exception;
    
    /**
     * 一個使用者可屬於多個角色/群組時用
     * @param obj
     * @param groupIds
     * @throws Exception
     */
    public void updateCommonUser(CommonUser obj, int[] groupIds) throws Exception;

    /**
     * Save or update CommonUser to persistence layer.
     * @param obj CommonUser
     */
    public void saveOrUpdateCommonUser(CommonUser obj) throws Exception;

    /**
     * Delete CommonUser from persistence layer.
     * @param obj CommonUser
     */
    public void deleteCommonUser(CommonUser obj) throws Exception;
    
    /**
     * Delete CommonUser from persistence layer.
     * @param id Primary key id.
     */
    public void deleteCommonUser(int id) throws Exception;

    /**
     * Load CommonUser from persistence layer by given id.
     * @param id Primary key id.
     * @return CommonUser
     */
    public CommonUser loadCommonUser(int id);
    
    public CommonUser getCommonUserByUserId(String userId);
    
    public CommonUser saveOrGetVerifiedUser(String userId, String userPwd) throws Exception;
}
