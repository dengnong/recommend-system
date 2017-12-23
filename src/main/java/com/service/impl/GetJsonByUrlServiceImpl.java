package com.service.impl;

import com.service.GetJsonByUrlService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by 54472 on 2017/12/21.
 */
@Service(value = "getJsonByUrlServiceImpl")
public class GetJsonByUrlServiceImpl implements GetJsonByUrlService {
    /**
     * Gets json by url.
     *
     * @param urlTemp the url temp
     * @return json
     * @throws IOException the io exception
     */
    public JSONObject getJsonByUrl(String urlTemp) {
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
