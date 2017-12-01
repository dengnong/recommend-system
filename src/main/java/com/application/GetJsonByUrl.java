package com.application;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by 54472 on 2017/11/14.
 * 通过url取json数据
 */
public class GetJsonByUrl {

    /**
     * Gets book json by url.
     *
     * @param urlTemp the url temp
     * @return the juhe book json by url
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
//        System.out.println(jsonObject);
        return jsonObject;
    }
}
