Feature: Contacto con el Cliente
  Yo como cliente de Parabank
  Quiero poder contactarme con el Banco Parabank
  Para realizar una PQRS

  @CostumerCare
  Scenario: Como cliente proporciono la información necesaria para que me puedan responder
    Given el cliente entra en la seccion Contact Us del sitio Web de Parabank
    When  el cliente ingresa una informacion de contacto y clickea el boton Send to Customer Care
    Then  recibira un mensaje de confirmacion por diligenciar la peticion