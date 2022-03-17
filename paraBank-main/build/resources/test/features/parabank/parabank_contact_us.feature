Feature: Contacto con el Cliente
  Yo como cliente de Parabank
  Quiero poder contactarme con el Banco Parabank
  Para realizar una PQRS

  @CostumerCare
  Scenario Outline: Como cliente proporciono la información necesaria para que me puedan responder
    Given el cliente entra en la seccion Contact Us del sitio Web de Parabank
    When  el cliente ingresa un nombre: <nombre>, un email: <email>, un numero de telefono: <telefono> y un mensaje: <mensaje> y clickea el boton Send to Customer Care
    Then  recibira un mensaje de confirmacion <mensajeDeConfirmacion> por diligenciar la peticion
    Examples:
      |nombre       |email				    |telefono  |mensaje      |mensajeDeConfirmacion  |
      |Dehyro Mendez|mendezdehyro@gmail.com |3185610660|Hola Parabank|Thank you Dehyro Mendez|
      |Camilo Cano  |camiloc@gmail.com	    |3245678765|Buen dia     |Thank you Camilo Cano  |
      |Jose Cabrera |josec@gmail.com		|3214678907|Buenas Tardes|Thank you Jose Cabrera |