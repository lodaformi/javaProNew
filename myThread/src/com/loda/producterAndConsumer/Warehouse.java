package com.loda.producterAndConsumer;

import java.util.List;

public class Warehouse {
    private List<Fruit> warehouse;

    private int vol;
    private int cnt;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public Warehouse() {
        vol = 10;
        cnt = 0;
    }

    public Warehouse(List<Fruit> warehouse) {
        this.warehouse = warehouse;
        vol = 10;
        cnt = 0;
    }

    public Boolean isFull() {
        if (cnt == vol) {
            return true;
        }
        return false;
    }

    public Boolean addFruit(Fruit fruit) {
        if (cnt <= vol) {
            warehouse.add(fruit);
            cnt++;
            return true;
        }
        return false;
    }

    /**
     * 获取
     *
     * @return warehouse
     */
    public List<Fruit> getWarehouse() {
        return warehouse;
    }

    /**
     * 设置
     *
     * @param warehouse
     */
    public void setWarehouse(List<Fruit> warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * 获取
     *
     * @return vol
     */
    public int getVol() {
        return vol;
    }

    /**
     * 设置
     *
     * @param vol
     */
    public void setVol(int vol) {
        this.vol = vol;
    }

    public String toString() {
        return "Warehouse{warehouse = " + warehouse + ", vol = " + vol + "}";
    }
}
