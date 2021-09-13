# concurso_preguntas_respuestas
Aplicacion de escritorio que modela un concurso de preguntas y respuestas

Se aplica el patron de arquitectura MVC (model-view-controller) con el fin de tener una aplicacion modularizada y extensible
Se aplican otros patrones como lo son el Singleton, DAO y DTO.

Las categorias, preguntas y datos de conexion a la base de datos, se guardan en un archivo de properties , que se encuentran dentro del proyecto, en la carpeta DATA.

En el concurso, hay tres posibles escenarios:
1. El jugador pierde en alguna pregunta y no se lleva nada.
2. El jugador se retira voluntariamente y se lleva el acumulado que llevaba de premios.
3. El jugador completa todo el concurso y se lleva todos los premios.
