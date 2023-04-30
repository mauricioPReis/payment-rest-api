package fadesp.paymentrestapi.handlers;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Object... paramns){
        super(String.format(message, paramns));
    }
}
