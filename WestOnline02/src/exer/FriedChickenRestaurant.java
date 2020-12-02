package exer;

/**
 *炸鸡店接口FriedChickenRestaurant：
 * 抽象方法：出售套餐，批量进货
 *
 * @author 石致彬
 *  2020-11-05 21:12
 */
public interface FriedChickenRestaurant {
    void saleSetMeal(String mealName);
    void purchase();
}
