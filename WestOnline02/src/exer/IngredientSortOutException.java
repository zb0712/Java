package exer;

/**
 * @author 石致彬
 * @create 2020-11-05 21:17
 */
public class IngredientSortOutException extends RuntimeException{
    public IngredientSortOutException(){

    }

    public static final long serialVersionUID = 784231123456L;
    public IngredientSortOutException(String msg){
        super(msg);
    }
}
