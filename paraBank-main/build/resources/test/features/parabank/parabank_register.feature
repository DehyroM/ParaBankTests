Feature: Registro en la Plataforma
  Yo como cliente de Parabank
  Quiero poder registrarme en la Página Web del Banco Parabank
  Para vincularme con una cuenta bancaria

  @Register
  Scenario Outline: Como cliente proporciono la información necesaria para poder registrarme
    Given el cliente entra en la seccion de Registro del sitio Web de Parabank
    When  el cliente ingresa un primer nombre: <fName>, un apellido: <lName>, una direccion: <address>, una ciudad: <city>
    When el cliente ingresa un estado/provincia: <state>, un codigo postal: <zCode>, un telefono: <phone>
    When el cliente ingresa un numero de seguro social: <ssn>, un usuario: <user>, una contrasena: <pass> y una confirmacion de contrasena: <passConf> y clickea el boton Register
    Then  recibira un mensaje de bienvenida <confMess>
    Examples:
      |fName |lName  |address        |city    |state  |zCode |phone     |ssn     |user   |pass    |passConf|confMess       |
      |Dehyro|Mendez |Calle 9 # 4-51 |Pitalito|Huila  |417030|3185610660|23355478|mdehyro|pass2315|pass2315|Welcome mdehyro|
      |David |Cano   |Calle 7 # 3-62 |Ibague  |Tolima |436005|3234664321|24347589|cdavid |pass2316|pass2316|Welcome cdavid |
      |Jose  |Diaz   |Carera 8 # 1-43|Cali    |Valle  |482103|3216063445|25453215|djose  |pass2317|pass2317|Welcome djose  |
