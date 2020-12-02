package exer;

import java.time.LocalDate;
import java.util.*;

/**
 * 西二炸鸡店类West2FriedChickenRestauran（实现炸鸡店接口）
 * 变量：餐厅账目余额（判断是否买的起原料），啤酒列表、果汁列表，套餐
 * 列表（注意这三个变量不是普通数组）用于保存店里所有的啤酒、果汁和套
 * 餐
 * 私有方法：重载use函数（即两个use方法传入的参数不同），分别接受Beer
 * 或者Juice参数，在出售套餐是同时移除对应的饮料（通过饮料名字在列表中
 * 判断是否有对应的饮料，如果存在选择出售第一个符合条件的，否则应该抛
 * 出异常）
 * 实现炸鸡店接口，能够进行售卖和批量进货（用instanceof来判断是啤酒还
 * 是果汁）
 * 在创建该类时对套餐列表进行初始化，套餐初始化后不可变，要求使用静态
 * 代码块
 * @author 石致彬
 * @create 2020-11-05 21:22
 */
public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    private double balance = 1000.00;
    //饮料和啤酒需要频繁地插入和删除(进货和出售),使用LinkedList
    private List<Beer> beerList = new LinkedList<>();
    private List<Juice> juiceList = new LinkedList<>();
    //套餐初始化后不可变，不需要进行插入和删除，使用ArrayList
    private static List<SetMeal> SetMealList= new ArrayList<>();

    static {
        SetMealList.add(new SetMeal("套餐1", 16, "原味香酥鸡", new Juice("可乐", 5, LocalDate.of(2020, 11, 5))));
        SetMealList.add(new SetMeal("套餐2", 17, "御膳香酥鸡", new Juice("雪碧", 5, LocalDate.of(2020, 11, 5))));
        SetMealList.add(new SetMeal("套餐3", 30, "脆皮全鸡", new Beer("罗斯福6号",10,LocalDate.of(2020,11,5),7.5f)));
        SetMealList.add(new SetMeal("套餐4", 35, "蜜汁手扒鸡", new Beer("罗斯福10号",11.5,LocalDate.of(2020,11,5),11.3f)));
    }
    public West2FriedChickenRestaurant() {}
    public West2FriedChickenRestaurant(double balance){
        this.balance = balance;
    }

    public void showMenu() {
        Iterator<SetMeal> iterator = SetMealList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    private void use(Beer beer) throws RuntimeException{
        //遍历BeerList
        boolean isFound = false;
        for (int i = 0; i < beerList.size(); i++) {
            Beer beer1 = beerList.get(i);
            if (beer1.isOverPeriod(LocalDate.now())) {
                //如果遍历到的酒过期了就从列表中删除
                beerList.remove(i);
                i--;
            } else if (beer.getName().equals(beer1.getName())) {
                //遍历到的符合条件的第一个就使用
                beerList.remove(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new IngredientSortOutException(beer.getName()+"已经售空");
        }
    }

    private void use(Juice juice) throws RuntimeException{
        boolean isFound = false;
        for (int i = 0; i < juiceList.size(); i++) {
            Juice juice1 = juiceList.get(i);
            if (juice1.isOverPeriod(LocalDate.now())) {
                //遍历到的有过期的就删除
                juiceList.remove(i);
                i--;
            } else if (juice.getName().equals(juice1.getName())) {
                //有符合条件的就使用
                juiceList.remove(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new IngredientSortOutException(juice.getName()+"已经售空");
        }
    }

    @Override
    public void saleSetMeal(String mealName) {
        Iterator<SetMeal> iterator = SetMealList.iterator();
        SetMeal setMeal = null;
        boolean isFound = false;
        String chickenName = "";
        //遍历套餐列表看是否有该套餐
        while (iterator.hasNext()) {
            setMeal = iterator.next();
            if (mealName.equals(setMeal.getName())){
                isFound = true;
                chickenName = setMeal.getChickenName();
                break;
            }
        }
        if (isFound) {
            if (setMeal.getDrink() instanceof Beer) {
                Beer beer = (Beer)setMeal.getDrink();
                try {
                    use(beer);
                    balance += setMeal.getPrice();
                    System.out.print("您好，这是您的 "+chickenName);
                    System.out.println("和"+beer.getName());
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            } else if (setMeal.getDrink() instanceof Juice){
                Juice juice = (Juice)setMeal.getDrink();
                try {
                    use(juice);
                    balance += setMeal.getPrice();
                    System.out.print("您好，这是您的 "+chickenName);
                    System.out.println("和"+juice.getName());
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("本店无该套餐！");
        }
    }

    @Override
    public void purchase() throws RuntimeException{
        double sumCost=0;
        //每次批量进货啤酒两种每种各10瓶，饮料两种每种各10瓶
        sumCost = 5*10+5*10+10*10+11.5*10;
        if (balance >= sumCost) {
            balance -=sumCost;
            for (int i = 0; i < 10; i++) {
                //为了测试在use过程中是否会删除过期的，每次进货的雪碧和罗斯福10号都设置为过期的
                juiceList.add(new Juice("可乐",5,LocalDate.now()));
                juiceList.add(new Juice("雪碧",5,LocalDate.of(2020,1,1)));
                beerList.add(new Beer("罗斯福6号",10,LocalDate.now(),7.5f));
                beerList.add(new Beer("罗斯福10号",11.5,LocalDate.of(2020,1,1),11.3f));
            }
            System.out.println("进货成功！");
        } else {
            throw new OverdraftBalanceException("您当前的余额为"+balance+",进货还需要"+(sumCost-balance)+"￥");
        }
    }
}
