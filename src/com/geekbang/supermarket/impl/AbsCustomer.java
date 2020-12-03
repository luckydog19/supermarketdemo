package com.geekbang.supermarket.impl;

import com.geekbang.supermarket.interfaces.Category;
import com.geekbang.supermarket.interfaces.Customer;
import com.geekbang.supermarket.interfaces.Merchandise;
import com.geekbang.supermarket.interfaces.ShoppingCart;
import org.omg.CORBA.PUBLIC_MEMBER;

import static com.geekbang.supermarket.util.ShoppingUtil.getRandomCategory;

public class AbsCustomer implements Customer {
    private Category shouldBuy;
    private String custId;
    private double moneySpent;
    private  int guangLeft=0;
    private  int guangCount=0;

    public static final int DEFAULT_GUANG_COUNT=5;

    public AbsCustomer(String custId,Category shouldBuy,int guangCount){
        this.shouldBuy=shouldBuy;
        this.guangCount=guangCount;
        this.custId=custId;
    }
    public int getGuangCount(){return guangCount;}
    public void setGuangCount(int guangCount){this.guangCount=guangCount;}
    public AbsCustomer(String custId,Category shouldBuy){
        this(custId,shouldBuy,DEFAULT_GUANG_COUNT);
    }


    @Override
    public String getCustId() {
        return custId;
    }

    @Override
    public void startShopping() {
     guangLeft=guangCount;
    }

    /**
     * 先看目的品类，没有则随变逛
     * @return
     */
    @Override
    public Category chooseCategory() {
        if(guangLeft+1>=guangCount){
            return shouldBuy;
        }else {
            return getRandomCategory();
        }
    }

    @Override
    public int buyMerchandise(Merchandise merchandise) {
        return 0;
    }

    @Override
    public boolean wantToCheckout() {
        guangLeft--;
        return guangLeft<=0;
    }

    @Override
    public double payFor(ShoppingCart shoppingCart, double totalCost) {
        moneySpent+=totalCost;
        return totalCost;
    }

    public Category getShouldBuy(){
        return shouldBuy;
    }

    @Override
    public double getMoneySpent() {
        return moneySpent;
    }
}
