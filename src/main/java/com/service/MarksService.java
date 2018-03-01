package com.service;

/**
 * Created by 54472 on 2018/3/1.
 */
public interface MarksService {

    /**
     * 添加收藏记录
     */
    public void markItem(String userId, String itemId, String type);

    /**
     * 查询收藏记录
     */
    public boolean markInit(String userId, String itemId, String type);

    /**
     * 取消收藏
     */
    public void markCancel(String userId, String itemId, String type);
}
