package learn.java.api.requests;

public class SigninRequest {

    private String identifier;
    private String password;
    private String servicename;
    private boolean longlived = false;

    public SigninRequest(String identifier, String password, String servicename, boolean longlived) {
        this.identifier = identifier;
        this.password = password;
        this.servicename = servicename;
        this.longlived = longlived;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getPassword() {
        return password;
    }

    public String getServicename() {
        return servicename;
    }

    public boolean isLonglived() {
        return longlived;
    }


}
