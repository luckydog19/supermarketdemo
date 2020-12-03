package com.geekbang.supermarket.interfaces;

import java.util.Locale;

public interface SuperMarket {
    //得到所有商品
    Merchandise[] getAllMarket();
    //随机根据品类选择商品
    Merchandise[] getRandomMerchandiseOfCategory(Category category);
    //收款
    void addEarnedMoney(double moneyEarn);
    //日流水单
    void dailyReport();
}
