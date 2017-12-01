package com.application;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.application.GetJsonByUrl.getBookJsonByUrl;

/**
 * Created by 54472 on 2017/11/14.
 * 向聚合图书API获取图书信息
 */
public class JuheBookAPI {
    private static final String url = "http://apis.juhe.cn/goodbook/query";
    private static final String key = "e191d9d8436c7ac323341936f2ef975b";

    /**
     * Gets juhe books json.
     *
     * @return the juhe books json
     * @throws IOException the io exception
     */
    public static Map<String, String> getJuheBooksJson() throws IOException {
        String title = null; //书名
        String catalog = null; //目录
        String sub2 = null; //简介
        String strUrl = url + "?key=" + key + "&catalog_id=246&1=10&rn=1";
        JSONArray jsonArray = JSONArray.fromObject(getBookJsonByUrl(strUrl).getJSONObject("result").getString("data"));
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            title = jsonObject.getString("title");
            catalog = jsonObject.getString("catalog");
            sub2 = jsonObject.getString("sub2");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("title",title);
        map.put("catalog", catalog);
        map.put("sub2", sub2);
        return map;
    }
}
