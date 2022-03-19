Feature: Registro en la Plataforma
  Yo como cliente de la empresa PARA BANK
  Quiero poder registrarme en la página Web de la empresa
  Para adquirir una cuenta bancaria

  Background:
    Given el cliente entra en la seccion de Registro del sitio Web de Parabank

  Scenario: Como cliente proporciono la información necesaria para poder registrarme
    When  el cliente ingresa sus datos personales y clickea el boton Register
    Then  recibira un mensaje de bienvenida

  Scenario: Como cliente proporciono la información para registrarme con una confirmacion de contraseña diferente
    When  el cliente ingresa sus datos personales pero con una confirmacion de contrasena diferente a la contrasena y clickea el boton Register
    Then  recibira un mensaje de error indicando que las contrasenas no coinciden