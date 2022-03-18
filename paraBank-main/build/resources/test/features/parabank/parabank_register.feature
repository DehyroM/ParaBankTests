Feature: Registro en la Plataforma
  Yo como cliente de Parabank
  Quiero poder registrarme en la Página Web del Banco Parabank
  Para vincularme con una cuenta bancaria

  @Register
  Scenario: Como cliente proporciono la información necesaria para poder registrarme
    Given el cliente entra en la seccion de Registro del sitio Web de Parabank
    When  el cliente ingresa sus datos personales y clickea el boton Register
    Then  recibira un mensaje de bienvenida o de advertencia: <confMess>

