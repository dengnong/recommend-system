package com.application;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.application.GetJsonByUrl.getBookJsonByUrl;

/**
 * Created by 54472 on 2017/11/14.
 * 向豆瓣图书API获取图书信息
 */
public class DoubanBookAPI {
    private static final String url = "https://api.douban.com//v2/book/";

    /**
     * Gets douban books json.
     *
     * @return the douban books json
     */
    public static Map<String, String> getDoubanBooksJson() throws IOException {
        String title = null; //书名
        String author = null; //作者
        String publisher = null; //出版社
        String summary = null; //概述
        String strUrl = url + 25858904;
        JSONObject jsonObject = getBookJsonByUrl(strUrl);
        JSONArray jsonArrayAuthor = JSONArray.fromObject(jsonObject);
//        for (int i = 0; i < jsonArrayAuthor.size(); i++) {
//            JSONObject jsonAuthor = (JSONObject) jsonArrayAuthor.get(i);
//            author = author + " " + jsonAuthor.getString("author");
//        }
        author = jsonObject.getString("author");
        title = jsonObject.getString("title");
        publisher = jsonObject.getString("publisher");
        summary = jsonObject.getString("summary");
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", title);
        map.put("author", author);
        map.put("publisher", publisher);
        map.put("summary", summary);
        return map;
    }
}
