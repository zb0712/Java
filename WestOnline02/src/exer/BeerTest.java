package exer;

import java.time.LocalDate;

/**
 * 测试Beer类的功能
 * @author 石致彬
 * @create 2020-11-06 13:14
 */
public class BeerTest {
    public static void main(String[] args) {
        Beer beer1 = new Beer("罗斯福6号",86, LocalDate.of(2020,11,6),7.3f);
        Beer beer2 = new Beer("罗斯福6号",86, LocalDate.of(2020,11,6),7.7f);
        Beer beer3 = new Beer("罗斯福6号",86, LocalDate.of(2020,10,6),7.3f);
        Beer beer4 = new Beer("罗斯福6号",8, LocalDate.of(2020,11,6),7.3f);
        Beer beer5 = new Beer("罗斯福10号",8, LocalDate.of(2020,11,6),7.3f);
        System.out.println(beer1.equals(beer2));//false degree不同
        System.out.println(beer1.equals(beer3));//false 生产日期不同
        System.out.println(beer1.equals(beer4));//true
        System.out.println(beer1.equals(beer5));//false name不同
        System.out.println(beer3.isOverPeriod(LocalDate.now()));//true 过期了 (测试日期2020.11.6)
        System.out.println(beer2.isOverPeriod(LocalDate.now()));
        System.out.println(beer1.isOverPeriod(LocalDate.now()));
        System.out.println(beer1.toString());
    }

}
