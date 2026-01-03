package bdd.support;

import java.util.HashMap;
import java.util.Map;

public class AuthService {

    private final Map<String, String> usuarios = new HashMap<>();

    public void registrarUsuario(String email, String password) {
        usuarios.put(email, password);
    }

    public String login(String email, String password) {
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            return "Campos obligatorios";
        }

        if (!usuarios.containsKey(email) || !usuarios.get(email).equals(password)) {
            return "Credenciales inválidas";
        }

        return "Login exitoso";
    }
}
