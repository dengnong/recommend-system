package com.service;

import java.util.List;

/**
 * Created by 54472 on 2018/3/12.
 */
public interface UserCFService {

    List userCf(String account, String type);

    List userCf();

    List userCF2();
}
