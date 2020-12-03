package com.geekbang.supermarket.interfaces;

/**
 * VIP卡，打折卡，赠品卡等
 */
public interface Card {
    /**
     * 执行完毕超市自身的打折策略之后，确定了谷歌需要付多少钱。
     * 然后在根据顾客是否有VIP卡，判单是否继续打折，看顾客是否有现金卡，抵扣现金
     *
     * @param totalCost              商品的原总价
     * @param totalCostAfterDiscount 顾客实际要支付的钱
     * @param customer               购买的顾客
     * @param shoppingCart           购物车
     * @return 优惠额，注意不是优惠后的价格
     */
    double processCardDiscount(double totalCost,double totalCostAfterDiscount,
                               Customer customer,ShoppingCart shoppingCart);

}
