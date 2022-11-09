
Feature: Logarse con diferentes Roles
Como usuario quiero logarme en la aplicacion HERCULES de forma correcta
@hola
Scenario: Login correcto
Given yo como usuario quiero ingresar en la aplicacion Hercules
And con el usuario "<usuario>" en el campo usuario
And  con la contrasenia "<password>" en el campo password
When se hace click en el boton "<boton>"
Then verifico  que aparece mi nombre completo: "<nombreCompleto>"
And verifico que mi rol es "<rol>"

Examples:
| usuario   | password   | boton | nombreCompleto                   |          rol              |
| maarrones | Primera08  | login | Arrones Alcañiz, Marcos Antonio  |  Técnico de central       |
#| prl1      | Primera08  | login |    prl1                          |  Tecnico de zona          |   
#| prl2      | Primera08  | login |    prl2                          |  Generico Responsable      | 
#| prl3      | Primera08  | login |    prl3                          |   Responsable de impresion | 


