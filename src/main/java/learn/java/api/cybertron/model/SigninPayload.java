package learn.java.api.cybertron.model;

public class SigninPayload {

    private String identifier;
    private String password;
    private boolean longlived;

    protected SigninPayload(String identifier, String password, boolean longlived){
        this.identifier = identifier;
        this.password = password;
        this.longlived = longlived;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLonglived() {
        return longlived;
    }

    public void setLonglived(boolean longlived) {
        this.longlived = longlived;
    }



}
