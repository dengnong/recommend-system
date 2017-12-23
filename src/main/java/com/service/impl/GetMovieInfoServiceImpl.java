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
}
