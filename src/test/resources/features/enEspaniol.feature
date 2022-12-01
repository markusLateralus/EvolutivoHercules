#language: es

Característica: Title of your feature
  I want to use this template for my feature file

  Esquema del escenario: Title of your scenario outline
    Dado I want to write a step with <name>
    Cuando I check for the <value> in step
    Entonces I verify the <status> in step

    Ejemplos: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
