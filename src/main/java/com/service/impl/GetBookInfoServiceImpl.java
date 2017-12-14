package com.service.impl;

import com.service.GetBookInfoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 54472 on 2017/12/14.
 */
@Service(value = "getBookInfoServiceImpl")
public class GetBookInfoServiceImpl implements GetBookInfoService {
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
        try {
            jsonArray = JSONArray.fromObject(getBookJsonByUrl(strUrl).getJSONObject("result").getString("data"));
        } catch (IOException e) {
            System.out.println("无法获取到聚合书籍信息");
            e.printStackTrace();
        }
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
        try {
            jsonObject = getBookJsonByUrl(strUrl);
        } catch (IOException e) {
            System.out.println("无法获取到豆瓣书籍信息");
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", jsonObject.getString("title")); //书名
        map.put("author", jsonObject.getString("author")); //作者
        map.put("publisher", jsonObject.getString("publisher")); //出版社
        map.put("summary", jsonObject.getString("summary")); //概述
        return map;
    }

    /**
     * Gets book json by url.
     *
     * @param urlTemp the url temp
     * @return json
     * @throws IOException the io exception
     */
    public static JSONObject getBookJsonByUrl(String urlTemp) throws IOException {
        URL url = null;
        InputStreamReader input = null;
        HttpURLConnection conn;
        JSONObject jsonObject = null;
        try {
            url = new URL(urlTemp);
            conn = (HttpURLConnection) url.openConnection();
            input = new InputStreamReader(conn.getInputStream(), "utf-8");
            Scanner inputStream = new Scanner(input);
            StringBuffer sb = new StringBuffer();
            while (inputStream.hasNext()) {
                sb.append(inputStream.nextLine());
            }
            jsonObject = JSONObject.fromObject(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonObject;
    }

}
