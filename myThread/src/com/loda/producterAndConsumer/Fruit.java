package com.loda.producterAndConsumer;

public class Fruit {
    private String name;
    private Double price;
//    private Boolean hasFruit;

    public Fruit() {
    }

    public Fruit(String name, Double price) {
        this.name = name;
        this.price = price;
    }

//    public Boolean getHasFruit() {
//        return hasFruit;
//    }
//
//    public void setHasFruit(Boolean hasFruit) {
//        this.hasFruit = hasFruit;
//    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "Fruit{name = " + name + ", price = " + price + "}";
    }
}
