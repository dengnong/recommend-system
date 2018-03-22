package com.service.impl;

import com.service.GetBookInfoService;
import com.service.GetJsonByUrlService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    private static final String douBanBookSearchUrl = "https://api.douban.com/v2/book/search?q=";

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
    public Map<String, String> getDoubanBooksJson(String bookId) {
        String strUrl = DouBanUrl + bookId;
        JSONObject jsonObject = null;
        jsonObject = getJsonByUrlService.getJsonByUrl(strUrl);
        Map<String, String> map = new HashMap<>();
        map.put("title", jsonObject.getString("title")); //书名
        map.put("author", jsonObject.getString("author")); //作者
        map.put("publisher", jsonObject.getString("publisher")); //出版社
        map.put("summary", jsonObject.getString("summary")); //内容简介
        map.put("author_intro", jsonObject.getString("author_intro")); //作者简介
        map.put("price", jsonObject.getString("price")); //定价
        map.put("isbn13", jsonObject.getString("isbn13")); //ISBN号码
        map.put("series_title", jsonObject.getJSONObject("series").getString("title")); //丛书
        map.put("numRaters", jsonObject.getJSONObject("rating").getString("numRaters")); //评价人数
        map.put("average", jsonObject.getJSONObject("rating").getString("average")); //评分
        map.put("pubdate", jsonObject.getString("pubdate")); // 出版年
        map.put("pages", jsonObject.getString("pages")); //页数
        map.put("image", jsonObject.getJSONObject("images").getString("large")); //图片

        return map;
    }

    /**
     * 搜索豆瓣书籍
     */
    public ArrayList<Map<String, String>> searchDoubanBook(String key) {
        String strUrl = douBanBookSearchUrl + key;
        JSONObject jsonObject = null;
        jsonObject = getJsonByUrlService.getJsonByUrl(strUrl);
        JSONArray jsonArray = null;
        ArrayList<Map<String, String>> list = new ArrayList<>();
        try {
            jsonArray = jsonObject.getJSONArray("books");
        } catch(Exception e) {
            return null;
        }
        for(int i = 0; i < jsonArray.size(); i++) {
            String title;
            String author;
            String publisher;
            String alt;
            try {
                title = jsonArray.getJSONObject(i).getString("title");
                author = jsonArray.getJSONObject(i).getString("author")
                        .replaceAll("\\[", "")
                        .replaceAll("\\]", "")
                        .replaceAll("\"","");
                publisher = jsonArray.getJSONObject(i).getString("publisher");
                alt = jsonArray.getJSONObject(i).getString("alt");
            } catch (Exception e) {
                continue;
            }
            Map<String, String> map = new HashMap<>();
            map.put("title", title);
            map.put("author", author);
            map.put("publisher", publisher);
            map.put("alt", alt);
            list.add(map);
        }
        return list;
    }
}
