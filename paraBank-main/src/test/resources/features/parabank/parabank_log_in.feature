Feature: Logearse en la Plataforma
  Yo como cliente de la empresa Parabank
  Quiero poder loguearme en la Página Web de la empresa
  Para conocer la información de mi cuenta bancaria

  Background:
    Given el cliente ingresa en la Opcion de Login del sitio Web de Parabank

  Scenario: Como cliente proporciono la información necesaria para poder loguearme
    When  el cliente ingresa su informacion de usuario y da click en Log In
    Then  recibira un mensaje de informacion sobre su cuenta

  Scenario: Como cliente proporciono cierta informacion para poder loguearme
    When  el cliente ingresa un usuario y da click en Log In
    Then  recibira un mensaje de error indicando que se debe ingresar un usuario y contrasena