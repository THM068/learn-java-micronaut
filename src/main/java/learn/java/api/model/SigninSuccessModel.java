package learn.java.api.model;

public class SigninSuccessModel {

    private String username;
    private String token;
    private String securetoken;
    private String messotoken;
    private String securemessotoken;

    //{"username":"UZER",
    // "token":"00-5e037d6dfb0367712e6fe67fc3e73dfb531974d9794d317fd8c1fcc6bc719223",
    // "securetoken":"S0-7b28de7c595b0b574fa3d556762f2cb4d197be9580ab91c618c99f12845f7bb3",
    // "messotoken":"01-5e037d6dfb0367712e6fe67fc3e73dfb531974d9794d317fd8c1fcc6bc719223",
    // "securemessotoken":"S1-7b28de7c595b0b574fa3d556762f2cb4d197be9580ab91c618c99f12845f7bb3"}
    @Override
    public String toString() {
        return "SigninSuccessModel{" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", securetoken='" + securetoken + '\'' +
                ", messotoken='" + messotoken + '\'' +
                ", securemessotoken='" + securemessotoken + '\'' +
                '}';
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecuretoken() {
        return securetoken;
    }

    public void setSecuretoken(String securetoken) {
        this.securetoken = securetoken;
    }

    public String getMessotoken() {
        return messotoken;
    }

    public void setMessotoken(String messotoken) {
        this.messotoken = messotoken;
    }

    public String getSecuremessotoken() {
        return securemessotoken;
    }

    public void setSecuremessotoken(String securemessotoken) {
        this.securemessotoken = securemessotoken;
    }
}
////restResponse.json.securetoken, restResponse.json.token, restResponse.json.securemessotoken, restResponse.json.messotoken, restResponse.json.longlivedtoken

//{"username":"UZER","token":"00-5e037d6dfb0367712e6fe67fc3e73dfb531974d9794d317fd8c1fcc6bc719223","securetoken":"S0-7b28de7c595b0b574fa3d556762f2cb4d197be9580ab91c618c99f12845f7bb3","messotoken":"01-5e037d6dfb0367712e6fe67fc3e73dfb531974d9794d317fd8c1fcc6bc719223","securemessotoken":"S1-7b28de7c595b0b574fa3d556762f2cb4d197be9580ab91c618c99f12845f7bb3"}