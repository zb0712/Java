package exer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**果汁类Juice（继承自饮料类）
    保质期2天
 * @author 石致彬
 *  2020-11-05 20:46
 */
public class Juice extends Drinks{

    public Juice(String name, double cost, LocalDate date) {
        super(name, cost, date, 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Juice juice = (Juice)obj;
        return juice.getName().equals(this.getName()) && juice.getDate().equals(this.getDate());
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "产品名称："+name+"\n"+
                "生产日期：" + dateTimeFormatter.format(date) +"\n"+
                "保质期：" + period;
    }
}
