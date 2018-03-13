package com.service.impl;

import com.repository.MarksRepository;
import com.service.BookService;
import com.service.UserCFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by 54472 on 2018/3/12.
 */
@Service(value = "userCFServiceImpl")
public class UserCFServiceImpl implements UserCFService {

    @Autowired
    private MarksRepository marksRepository;

    @Resource(name = "bookServiceImpl")
    private BookService bookService;

    public ArrayList<String> userCf() {
        ArrayList<String> list = bookService.bookRandom();
        return list;
    }

    public ArrayList<String> userCf(String account) {
        //用户数量
        int N = marksRepository.countUserId();
        int[][] sparseMatrix = new int[N][N];//建立用户稀疏矩阵【相似度矩阵】
        Map<String, Integer> userItemLength = new HashMap<>();//存储每个用户收藏的物品总数:A 3
        Map<String, Set<String>> itemUserCollection = new HashMap<>();//物品-用户倒排表:a A B
        Set<String> items = new HashSet<>();//辅助存储物品集合
        Map<String, Integer> userId = new HashMap<>();//辅助存储每个用户的用户ID映射
        Map<Integer, String> idUser = new HashMap<>();//辅助存储每个ID对应的用户映射
        for (int i = 0; i < N; i++) {
            List<String> user = marksRepository.findUserId();
            List<String> item = marksRepository.findItemIdByUserId(user.get(i));
            ArrayList<String> user_item = new ArrayList<>();
            user_item.add(user.get(i));
            for (int k = 0; k < item.size(); k++) {
                user_item.add(item.get(k));
            }
            int length = user_item.size();
            userItemLength.put(user_item.get(0), length - 1);
            userId.put(user_item.get(0), i);
            idUser.put(i, user_item.get(0));
            //建立 物品-用户 倒排表
            for (int j = 1; j < length; j++) {
                if (items.contains(user_item.get(j))) {
                    //如果已经包含对应的物品--用户映射，直接添加对应的用户
                    itemUserCollection.get(user_item.get(j)).add(user_item.get(0));
                } else {
                    //否则创建对应物品--用户集合映射
                    items.add(user_item.get(j));
                    //创建物品--用户倒排关系
                    itemUserCollection.put(user_item.get(j), new HashSet<String>());
                    itemUserCollection.get(user_item.get(j)).add(user_item.get(0));
                }
            }
        }
        System.out.println(itemUserCollection.toString());
        //计算相似度矩阵【稀疏】
        Set<Map.Entry<String, Set<String>>> entrySet = itemUserCollection.entrySet();
        Iterator<Map.Entry<String, Set<String>>> iterator = entrySet.iterator();
        while(iterator.hasNext()) {
            Set<String> commonUsers = iterator.next().getValue();
            for(String user_u : commonUsers) {
                for(String user_v : commonUsers) {
                    if(user_u.equals(user_v)) {
                        continue;
                    }
                    //计算用户u与用户v都有正反馈的物品总数
                    sparseMatrix[userId.get(user_u)][userId.get(user_v)] += 1;
                }
            }
        }
        System.out.println(userItemLength.toString());
        //输入需要推荐的用户
        //*********************************
        int recommendUserId = userId.get(account);
        System.out.println(recommendUserId);
        for (int j = 0;j < sparseMatrix.length; j++) {
            if(j != recommendUserId){
                System.out.println(idUser.get(recommendUserId)+"--"+idUser.get(j)+"相似度:"
                        +sparseMatrix[recommendUserId][j]/Math.sqrt(userItemLength.get(idUser.get(recommendUserId))
                        *userItemLength.get(idUser.get(j))));
            }
        }
        //计算指定用户recommendUser的物品推荐度
        Map<String, Double> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (String goods : items) {
            //遍历每一件物品
            //*****************************
            Set<String> users = itemUserCollection.get(goods);
            if (!users.contains(account)) {
                //如果被推荐用户没有购买当前物品，则进行推荐度计算
                double itemRecommendDegree = 0.0;
                for (String usr : users) {
                    //******************************
                    itemRecommendDegree += sparseMatrix[userId.get(account)][userId.get(usr)] / Math
                            .sqrt(userItemLength.get(account) * userItemLength.get(usr));
                }
                if(itemRecommendDegree != 0.0) {
                    map.put(goods, itemRecommendDegree);
                    list = sortMap(map);
                }
              System.out.println("The item " + goods + " for " + account + "'s recommended degree:" + itemRecommendDegree);
            }
        }
        list.addAll(bookService.bookRandom());
        return list;
    }

    //排序map
    public ArrayList<String> sortMap(Map<String, Double> map) {
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(map.entrySet());
        ArrayList<String> arrayList = new ArrayList<>();

        Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
            //升序排序
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (int i = list.size() - 1; i >= 0; i--) {
            arrayList.add(list.get(i).getKey());
        }
        return arrayList;
    }
}
