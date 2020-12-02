package exer;

import java.time.LocalDate;

/**
 * 饮料类Drinks （抽象类）
 * 变量：自己的名字，成本（double），生产日期（LocalDate类），保质期
 * （单位：天）
 * 函数&方法：全参构造函数，判断当前是否过期方法（使用LocalDate），，
 * 抽象的toString方法
 * @author 石致彬
 *  2020-11-05 20:11
 */
abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate date;
    protected int period;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Drinks(String name, double cost, LocalDate date, int period) {
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.period = period;
    }

    public boolean isOverPeriod(LocalDate now){
        if ((now.toEpochDay()-date.toEpochDay())>period){
            return true;
        }
        return false;
    }

    public abstract String toString();
}
