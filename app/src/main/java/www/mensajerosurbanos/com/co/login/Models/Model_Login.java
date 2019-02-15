package www.mensajerosurbanos.com.co.login.Models;

public class Model_Login {

    String user;
    String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Model_Login(String user, String password) {
        this.user = user;
        this.password = password;
    }
}
