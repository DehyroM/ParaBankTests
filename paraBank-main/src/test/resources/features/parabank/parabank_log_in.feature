Feature: Logearse en la Plataforma
  Yo como cliente de Parabank
  Quiero poder loguearme en la Página Web del Banco Parabank
  Para conocer la información de mi cuenta bancaria

  @Login
  Scenario Outline: Como cliente proporciono la información necesaria para poder loguearme
    Given el cliente ingresa en la Opcion de Login del sitio Web de Parabank
    When  el cliente ingresa un usuario: <user>, una contrasena: <pass>, y da click en Log In
    Then  recibira un mensaje de informacion sobre su cuenta <infMess>
    Examples:
      |user   |pass     |infMess         |
      |mdehyro|pass2315 |Available Amount|
      |cdavid |pass2316 |Available Amount|
      |djose  |pass2317 |Available Amount|

