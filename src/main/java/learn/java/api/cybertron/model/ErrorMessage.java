package learn.java.api.cybertron.model;

public class ErrorMessage {
    private String message;
    private String errorcode;
    private String service;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}

