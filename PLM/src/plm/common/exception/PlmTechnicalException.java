package plm.common.exception;

public class PlmTechnicalException extends RuntimeException {

    private static final long serialVersionUID = 7286687721665975226L;

    public PlmTechnicalException(String string) {
        super(string);
    }

    public PlmTechnicalException(Throwable e) {
        super(e);
    }

    public PlmTechnicalException(String string, Throwable e) {
        super(string, e);
    }
}
