
Feature: Rellenar Formulario Adiestramiento Parametrizado
  como usuario queremos poder descargarnos un formulario y comprobar que el nombre y DNI corresponde con el trabajador que debe
  rellenar el resto del formulario

Background:
 Given el usuario logado correctamente en Hercules 
| usuario   | password   |
| maarrones | Primera09  |
| prl1      | Primera08  |
| prl2      | Primera08  |   
| prl3      | Primera08  |
 And el usuario se dirige a la pantalla Documentacion-Empleado puesto
 And el usuario realiza una busqueda por evaluacion
| evaluacion |
|   4096     |
|   4096     | 
|   4096     | 
|   4096     |
 And el usuario selecciona un dni, un puesto y genera un lote nuevo
|     dni       |     puesto   |    lote                  |      
|  35579678N    |     6364     |   Tecnico Central        |     
|  35579678N    |     6364     |   Tecnico Zona           |     
|  35579678N    |     6364     |   Responsable            |     
|  35579678N    |     6364     |   Responsable Impresion  |
 And el usuario se dirige a la pantalla Bandeja de Salida y se encuentra la documentacion generada
 
@descargaFormulario
  Scenario Outline: Verificar que el usuario que se descarge el formualirio de adiestramiento para un trabajador  ya venga con su nombre y dni en dicho formulario
    When el usuario se descarga el formulario de adiestramiento con lote "<lote>" , dni "<dni>" y puesto "<puesto>" 
		Then el usuario verifica que esta incluido el nombre del trabajador "<nombreTrabajador>"
		And el usuario verifica que esta incluido  el dni "<dni>"

    Examples: 
| usuario   | password   | evaluacion|    lote                       |     dni       |      puesto  |  nombreTrabajador       | 
| maarrones | Primera09  |    4096   |     Tecnico Central           |  35579678N    |     6364     | MIGUEL CADENAS AMANDI   |
| prl1      | Primera08  |    4096   |     Tecnico Zona              |  35579678N    |     6364     | MIGUEL CADENAS AMANDI   |
| prl2      | Primera08  |   4096    |    Responsable                |  35579678N    |     6364     | MIGUEL CADENAS AMANDI   |
| prl3      | Primera08  |   4096    |   Responsable Impresion       |  35579678N    |     6364     | MIGUEL CADENAS AMANDI   |

@VerficaFormularioSinRespuesta
Scenario Outline: Verifica que el archivo con el contenido de las respuesta no se encuentra en la descarga.
When el usuario se descarga el formulario de adiestramiento con lote "<lote>", dni "<dni>" y puesto "<puesto>" y el CUR
Then el usuario no encuentra el archivo con las respuestas.
    Examples: 
|    lote                   |     dni       |      puesto   |  
|   Tecnico Central         |  35579678N    |      6364     |
|   Tecnico Zona            |  35579678N    |     6364     |
|   Responsable             |  35579678N    |     6364     |
|    Responsable Impresion  |  35579678N    |     6364     |

