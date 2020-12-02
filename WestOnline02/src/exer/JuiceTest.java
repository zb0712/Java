package exer;

import java.time.LocalDate;

/**
 * 测试Juice类功能
 * @author 石致彬
 * @create 2020-11-06 13:17
 */
public class JuiceTest {
    public static void main(String[] args) {
        Juice juice1 = new Juice("可乐",7, LocalDate.now());
        Juice juice2 = new Juice("可乐",7, LocalDate.of(2020,11,6));
        Juice juice3 = new Juice("可乐",7, LocalDate.of(2020,11,4));
        Juice juice4 = new Juice("可乐",7, LocalDate.of(2020,11,3));
        Juice juice5 = new Juice("雪碧",7, LocalDate.now());
        System.out.println(juice1.equals(juice2));//true
        System.out.println(juice1.equals(juice3));//false 生产日期不同
        System.out.println(juice1.equals(juice5));//false name不同
        System.out.println(juice3.isOverPeriod(LocalDate.now()));//false
        System.out.println(juice4.isOverPeriod(LocalDate.now()));//true 过期
        System.out.println(juice1.toString());
    }

}
