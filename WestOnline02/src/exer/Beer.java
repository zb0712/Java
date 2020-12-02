package exer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * 啤酒类Beer（继承自饮料类）
 * 变量：酒精度数（float）
 * 保质期为30天
 * @author 石致彬
 *  2020-11-05 20:35
 */
public class Beer  extends Drinks{
    private float alcoholDegree;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beer beer = (Beer) o;

        return Float.compare(beer.alcoholDegree, alcoholDegree) == 0 && this.getName().equals(beer.getName()) && this.date.equals(beer.date);
    }


    public Beer(String name, double cost, LocalDate date, float degree) {
        super(name, cost, date, 30);
        this.alcoholDegree=degree;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "产品名称："+name+"\n"+
                "酒精度数" + alcoholDegree + "%"+"\n" +
                "生产日期：" + dateTimeFormatter.format(date) +"\n"+
                "保质期：" + period;
    }
}
