package Estoque_CRUD.core.exception;

public class StockOverFlowException extends RuntimeException {
    public StockOverFlowException(String message) {
        super(message);
    }
    public StockOverFlowException() {
        super("Quantidade digitada ultrapassa a quantidade máxima do estoque");
    }
}
