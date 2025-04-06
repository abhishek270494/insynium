package java.common.dto;

/**
 * Model of a server error to be sent to client in case error happens in the backend. It contains http status and error detail.
 */
public class ServerErrorResponse {

    private int httpStatus;
    private String serializedErrorBody;

    public ServerErrorResponse(int httpStatus, String serializedErrorBody) {
        this.httpStatus = httpStatus;
        this.serializedErrorBody = serializedErrorBody;
    }

    public String getSerializedErrorBody() {
        return serializedErrorBody;
    }

    public void setSerializedErrorBody(String serializedErrorBody) {
        this.serializedErrorBody = serializedErrorBody;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
