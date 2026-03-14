package apiException;

public class ApiResponseSuccess {
    private String status;
    private String message;
    private int code;
    private Object data;

    public ApiResponseSuccess() {
    }

    public ApiResponseSuccess(String status, String message, int code, Object data) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
