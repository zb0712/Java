package exer;

/**
 * @author 石致彬
 * @create 2020-11-05 21:19
 */
public class OverdraftBalanceException extends RuntimeException{
    public OverdraftBalanceException(){

    }

    public static final long serialVersionUID = 456789451324657L;
    public OverdraftBalanceException(String msg){
        super(msg);
    }
}
