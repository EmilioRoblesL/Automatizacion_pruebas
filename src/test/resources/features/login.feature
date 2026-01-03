Feature: Inicio de sesión de usuario
  Como usuario registrado
  Quiero iniciar sesión con mis credenciales
  Para acceder al sistema

  Background:
    Given existe un usuario registrado con email "user@test.com" y contraseña "1234"

  Scenario: Login exitoso con credenciales válidas
    When el usuario intenta iniciar sesión con email "user@test.com" y contraseña "1234"
    Then el sistema debe responder "Login exitoso"

  Scenario Outline: Login fallido por credenciales inválidas o campos vacíos
    When el usuario intenta iniciar sesión con email "<email>" y contraseña "<password>"
    Then el sistema debe responder "<resultado>"

    Examples:
      | email             | password | resultado              |
      | user@test.com     | xxxx     | Credenciales inválidas |
      | noexiste@test.com | 1234     | Credenciales inválidas |
      |                   | 1234     | Campos obligatorios    |
      | user@test.com     |          | Campos obligatorios    |
