package com.service.impl;

import com.service.GetBookInfoService;
import com.service.GetJsonByUrlService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 54472 on 2017/12/14.
 */
@Service(value = "getBookInfoServiceImpl")
public class GetBookInfoServiceImpl implements GetBookInfoService {

    @Resource(name = "getJsonByUrlServiceImpl")
    private GetJsonByUrlService getJsonByUrlService;

    private static final String DouBanUrl = "https://api.douban.com//v2/book/";
    private static final String JuheUrl = "http://apis.juhe.cn/goodbook/query";
    private static final String JuheKey = "e191d9d8436c7ac323341936f2ef975b";

    /**
     * Gets juhe books json.
     *
     * @return the juhe books json
     */
    public Map<String, String> getJuheBooksJson() {
        String strUrl = JuheUrl + "?key=" + JuheKey + "&catalog_id=246&1=10&rn=1";
        JSONArray jsonArray = null;
        jsonArray = JSONArray.fromObject(getJsonByUrlService.getJsonByUrl(strUrl).getJSONObject("result").getString("data"));
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        Map<String, String> map = new HashMap<String, String>();
        map.put("title",jsonObject.getString("title")); //书名
        map.put("catalog", jsonObject.getString("catalog")); //分类
        map.put("sub2", jsonObject.getString("sub2")); //简介
        return map;
    }

    /**
     * Gets douban books json.
     *
     * @return the douban books json
     */
    public Map<String, String> getDoubanBooksJson() {
        String strUrl = DouBanUrl + 25858904;
        JSONObject jsonObject = null;
        jsonObject = getJsonByUrlService.getJsonByUrl(strUrl);
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", jsonObject.getString("title")); //书名
        map.put("author", jsonObject.getString("author")); //作者
        map.put("publisher", jsonObject.getString("publisher")); //出版社
        map.put("summary", jsonObject.getString("summary")); //概述
        return map;
    }
}
