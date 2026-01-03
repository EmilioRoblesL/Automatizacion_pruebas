package bdd.steps;

import bdd.support.AuthService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private final AuthService authService = new AuthService();
    private String resultado;

    @Given("existe un usuario registrado con email {string} y contraseña {string}")
    public void existeUsuario(String email, String password) {
        authService.registrarUsuario(email, password);
    }

    @When("el usuario intenta iniciar sesión con email {string} y contraseña {string}")
    public void intentaLogin(String email, String password) {
        resultado = authService.login(email, password);
    }

    @Then("el sistema debe responder {string}")
    public void validaRespuesta(String esperado) {
        assertEquals(esperado, resultado);
    }
}
