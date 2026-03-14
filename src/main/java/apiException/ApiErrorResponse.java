package apiException;

import java.util.Map;

public class ApiErrorResponse {
    private String status;
    private String message;
    private int code;
    private Map<String, String> errors;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(String status, String message, int code, Map<String, String> errors) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.errors = errors;
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

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ApiErrorResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", errors=" + errors +
                '}';
    }
}
