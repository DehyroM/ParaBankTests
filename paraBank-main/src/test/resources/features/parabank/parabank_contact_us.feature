Feature: Contacto con el Cliente
  Yo como cliente de Parabank
  Quiero poder contactarme con el Banco Parabank
  Para realizar una PQRS

  Background:
    Given el cliente entra en la seccion Contact Us del sitio Web de Parabank

  Scenario: Como cliente proporciono la información necesaria para que me puedan responder
    When  el cliente ingresa una informacion de contacto y clickea el boton Send to Customer Care
    Then  recibira un mensaje de confirmacion por diligenciar la peticion

  Scenario: Como cliente proporciono datos de contacto excepto el nombre
    When  el cliente ingresa una informacion de contacto pero sin ingresar el nombre y clickea el boton Send to Customer Care
    Then  recibira un mensaje de error indicando que se requiere el nombre