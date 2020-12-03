package com.geekbang.supermarket.impl;

import com.geekbang.supermarket.interfaces.*;

import static com.geekbang.supermarket.util.ShoppingUtil.output;

public class SimpleShopman implements Shopman {
    private SuperMarket superMarket;

    public SimpleShopman(SuperMarket superMarket){
        this.superMarket=superMarket;
    }
    private static final int MAX_BUY_DEFAULT=9;
    @Override
    public void serveCustomer(Customer customer) {
        int maxTypeToBuy=MAX_BUY_DEFAULT;
        if(customer instanceof AbsCustomer){
            maxTypeToBuy=((AbsCustomer) customer).getGuangCount();
        }
        ShoppingCart shoppingCart=new ShoppingCart(maxTypeToBuy);
        customer.startShopping();

        while ((!customer.wantToCheckout())&&shoppingCart.canHold()){
            Category category=customer.chooseCategory();
            if(category==null){
                continue;
            }
            Merchandise[]toChoose=superMarket.getRandomMerchandiseOfCategory(category);
            for (Merchandise m:toChoose){
                if(m==null){
                    continue;
                }
                int buyCount=customer.buyMerchandise(m);
                if(buyCount>0){
                    shoppingCart.add(m,buyCount);
                    break;
                }
            }
        }
        double originCost=shoppingCart.calculateOriginCost();
        double finalCost=originCost;
        //优惠金额
        double savedMoney=0;
        if(customer instanceof HasCard){
            Card card=((HasCard)customer).getCard();
            savedMoney=card.processCardDiscount(originCost,finalCost,customer,shoppingCart);
            finalCost-=savedMoney;
        }
        //实付金额
        double moneyEarned=customer.payFor(shoppingCart,finalCost);
        superMarket.addEarnedMoney(moneyEarned);
        output("顾客"+customer.getCustId()+"购物清单如下; ");
        output(shoppingCart.toString());

        output("优惠金额为："+savedMoney);
        output("实付金额为："+moneyEarned);
    }
}
