package com.service.impl;

import com.service.GetJsonByUrlService;
import com.service.GetMovieInfoService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 54472 on 2017/12/21.
 */
@Service(value = "getMovieInfoServiceImpl")
public class GetMovieInfoServiceImpl implements GetMovieInfoService {

    @Resource(name = "getJsonByUrlServiceImpl")
    private GetJsonByUrlService getJsonByUrlService;

    private static final String timeApiUrl = "https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=";
    private static final String locationId = "880"; //成都地区

    private static final String doubanApiUrl = "https://api.douban.com/v2/movie/in_theaters";
    private static final String doubanUrl = "https://api.douban.com/v2/movie/";

    /**
     * Time电影正在热映数据
     * @return
     */
    public ArrayList<Map<String, Object>> getTimeMoviesJson() {
        String strUrl = doubanApiUrl;
        JSONArray jsonArray = new JSONArray();
        ArrayList<Map<String, Object>> list = new ArrayList<>();

        String movieName;
        String directorName;
        String directorUrl;
        String label;
        String imageUrl;
        int rating;

        jsonArray = JSONArray.fromObject(getJsonByUrlService.getJsonByUrl(strUrl).getString("subjects"));
        for(int i = 0; i < 20; i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            JSONArray directors = JSONArray.fromObject(jsonObject.getString("directors")); //电影导演信息
            JSONObject imagesUrl = JSONObject.fromObject(jsonObject.getString("images")); //电影封面图片：大中小

            try {
                movieName = jsonObject.getString("title");
            } catch (IndexOutOfBoundsException e) {
                movieName = "Not find";
            }
            try {
                directorName = directors.getJSONObject(0).getString("name");
            } catch (IndexOutOfBoundsException e) {
                directorName = "Not find";
            }
            try {
                directorUrl = directors.getJSONObject(0).getString("alt");
            } catch (IndexOutOfBoundsException e) {
                directorUrl = null;
            }
            try {
                label = jsonObject.getString("genres");
            } catch (IndexOutOfBoundsException e) {
                label = "Not find";
            }
            try {
                imageUrl = imagesUrl.getString("medium");
            } catch (IndexOutOfBoundsException e) {
                imageUrl = null;
            }
            try {
                rating = (int) (Float.parseFloat(JSONObject.fromObject(
                                        jsonObject.getString("rating")).getString("average")) / 2);
            } catch (IndexOutOfBoundsException e) {
                rating = 0;
            }
//            try {
//
//            } catch (IndexOutOfBoundsException e) {
//
//            }

            Map<String, Object> map = new HashMap<>();
            map.put("movieName", movieName); //取电影名字
            map.put("directorName", directorName); //取第一个导演名字
            map.put("directorUrl", directorUrl); //导演豆瓣连接
            map.put("label", label); //电影类别
            map.put("imageLarge", imageUrl); //电影封面大图
            map.put("rating", rating); //电影评分

            list.add(map);
        }
        return list;
    }

    @Override
    public Map<String, String> getDoubanMoviesJson(String movieId) {
        String strUrl = doubanUrl + movieId;
        JSONObject jsonObject = null;
        jsonObject = getJsonByUrlService.getJsonByUrl(strUrl);

        Map<String, String> map = new HashMap<>();
        map.put("alt_title", jsonObject.getString("alt_title")); //电影标题
        map.put("writer", jsonObject.getJSONObject("attrs").getString("writer") //编剧
                .replaceAll("\\[","").replaceAll("\\]", "").replaceAll("\"", ""));
        map.put("director", jsonObject.getJSONObject("attrs").getString("director") //导演
                .replaceAll("\\[","").replaceAll("\\]", "").replaceAll("\"", ""));
        map.put("country", jsonObject.getJSONObject("attrs").getString("country") //国家
                .replaceAll("\\[","").replaceAll("\\]", "").replaceAll("\"", ""));
        map.put("pubdate", jsonObject.getJSONObject("attrs").getString("pubdate") //上映日期
                .replaceAll("\\[","").replaceAll("\\]", "").replaceAll("\"", ""));
        map.put("movie_duration", jsonObject.getJSONObject("attrs").getString("movie_duration") //片长
                .replaceAll("\\[","").replaceAll("\\]", "").replaceAll("\"", ""));
        map.put("movie_type", jsonObject.getJSONObject("attrs").getString("movie_type") //类型
                .replaceAll("\\[","").replaceAll("\\]", "").replaceAll("\"", ""));
        map.put("cast",jsonObject.getJSONObject("attrs").getString("cast") //主演
                .replaceAll("\\[","").replaceAll("\\]", "").replaceAll("\"", "").replaceAll("\\,", "\n"));
        map.put("average", jsonObject.getJSONObject("rating").getString("average")); //评分
        map.put("numRaters",jsonObject.getJSONObject("rating").getString("numRaters")); //评价人数
        map.put("image", jsonObject.getString("image")); //封面
        map.put("summary", jsonObject.getString("summary")); //简介

        return map;
    }

    public static String traverseArray(JSONArray array, String key) {
        String str = "";
        if(array.size() > 0) {
            for(int i = 0; i < array.size(); i++) {
                str += "\"" + array.getJSONObject(i).getString(key) + "\"";
            }
        }
        return str;
    }
}
