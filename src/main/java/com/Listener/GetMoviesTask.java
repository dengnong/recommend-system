//package com.Listener;
//
//import com.service.GetMovieInfoService;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by 54472 on 2017/12/22.
// */
//@Component
//@EnableScheduling
//public class GetMoviesTask {
//    public static List<Map<String, Object>> moviesShowingInfo;
//
//    @Resource(name = "getMovieInfoServiceImpl")
//    private GetMovieInfoService getMovieInfoService;
//
//    //0 6 * * * 每天早上6点
//    @Scheduled(cron = "0/30 * * * * ?" )
//    public void  getShowingMovieInfo() {
//        System.out.println("getMovies Task start...");
//        moviesShowingInfo = getMovieInfoService.getTimeMoviesJson();
//    }
//
//    /**
//     * "0 0 12 * * ?"每天中午十二点触发
//     "0 15 10 ? * *"每天早上10：15触发
//     "0 15 10 * * ?"每天早上10：15触发
//     "0 15 10 * * ? *"每天早上10：15触发
//     "0 15 10 * * ? 2005" 2005年的每天早上10：15触发
//     "0 * 14 * * ?"每天从下午2点开始到2点59分每分钟一次触发
//     "0 0/5 14 * * ?"每天从下午2点开始到2：55分结束每5分钟一次触发
//     "0 0/5 14,18 * * ?"每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
//     "0 0-5 14 * * ?"每天14:00至14:05每分钟一次触发
//     "0 10,44 14 ? 3 WED"三月的每周三的14：10和14：44触发
//     "0 15 10 ? * MON-FRI"每个周一、周二、周三、周四、周五的10：15触发
//     "0 15 10 15 * ?"每月15号的10：15触发
//     "0 15 10 L * ?"每月的最后一天的10：15触发
//     "0 15 10 ? * 6L"每月最后一个周五的10：15
//     */
//}