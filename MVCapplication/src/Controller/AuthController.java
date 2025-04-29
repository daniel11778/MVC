package Controller;

import Model.AuthModel;

public class AuthController {
    private AuthModel model;

    public AuthController() {
        this.model = new AuthModel();
    }

    public boolean validateLogin(String email, String password) {
        return model.login(email, password);
    }
}