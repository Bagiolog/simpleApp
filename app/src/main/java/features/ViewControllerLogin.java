package features;

import com.example.stage3.myapplication.R;

public class ViewControllerLogin {

    public ViewControllerLogin(){ }

    public boolean loginCompleto(String username, String password){
        return username.equals("Carolina") && password.equals("1234");
    }

    public boolean loginOnlyPassword(String password){
        return password.equals("1234");
    }

    public boolean loginOnlyUsername(String username){
        return username.equals("Carolina");
    }
}
