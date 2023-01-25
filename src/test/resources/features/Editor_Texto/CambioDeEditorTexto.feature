

Feature: Cambio de Editor de texot
Se ha cambiado el editor de texto para tener la funcionalidad de agregar imagenes y al lado de estas poder escribir texto

Background:
Given el usuario se loga en la aplicacion Hercules
| usuario       | password   |   rol                |    
| maarrones     | Primera09  | Tecnico de Central   |
And el usuario realiza una busqueda de riesgo por id 
|  id     |
| 14723   | 

@medidas
Scenario: Editar medidas
When el usuario abre el editor de texto con el boton Medidas
Then el usuario puede agregar imagen
And el usuario puede agregar texto al lado de la imagen 
And el usuario guarda los cambios correctamente

@medidasAterceros
Scenario: Editar medidas a terceros
When el usuario abre el editor de texto con el boton Medidas a Terceros
Then el usuario puede agregar imagen
And el usuario puede agregar texto al lado de la imagen
And el usuario guarda los cambios correctamente



