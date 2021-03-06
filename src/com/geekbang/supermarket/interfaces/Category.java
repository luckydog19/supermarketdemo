package com.geekbang.supermarket.interfaces;

/**
 * 商品的种类
 */
public enum  Category {
    FOOD(10,300),//食品
    COOK(200,2000),//厨具
    SNACK(5,100),//零食
    CLOTHES(200,1000),//衣物
    ELECTRIC(200,10000);//电子产品

    int lowerPrice;
    int higherPrice;

    Category(int lowerPrice,int higherPrice){
        this.lowerPrice=lowerPrice;
        this.higherPrice=higherPrice;
    }

    public int getLowerPrice(){return lowerPrice;}
    public void setLowerPrice(int lowerPrice){this.lowerPrice=lowerPrice;}

    public int getHigherPrice(){return higherPrice;}
    public void setHigherPrice(int higherPrice){this.higherPrice=higherPrice;}

}
