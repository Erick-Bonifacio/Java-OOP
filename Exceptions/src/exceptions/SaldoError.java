package exceptions;

import java.io.Serial;

public class SaldoError extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public SaldoError(String msg) {
        super(msg);
    }
}
