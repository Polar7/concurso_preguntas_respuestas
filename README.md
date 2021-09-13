# concurso_preguntas_respuestas
Aplicacion de escritorio que modela un concurso de preguntas y respuestas

Fue creada con el lenguaje Java, con el IDE Intellij IDEA, y como base de datos, escogí Postgresql.
Se aplica el patron de arquitectura MVC (model-view-controller) con el fin de tener una aplicacion modularizada y extensible
Se aplican otros patrones como lo son el Singleton, DAO y DTO.
Y se utiliza JDBC para la conexion.
El proyecto se encuentra documentado para su fácil comprensión.

Las categorias, preguntas y datos de conexion a la base de datos, se guardan en un archivo de properties, que se encuentran dentro del proyecto, en la carpeta DATA. De igual forma, allí se encuentra el driver para la base de datos.

Cuando se ejecuta por primera vez la aplicacion, se obtiene la siguiente interfaz:
- En la parte superior, una imagen referente al concurso
- En la parte a la izquierda, informacion sobre el jugador, tales como su nombre, premios que lleva, y la ronda que va.
- En la parte centro-derecha, un espacio para las preguntas y posibles respuestas.
- Y en la parte inferior, botones para iniciar el juego, retirarse voluntariamente y obtener informacion acerca del creador.

![image](https://user-images.githubusercontent.com/60671203/133017607-a328ba53-b638-4500-b429-0ad8f978b471.png)

Cuando presionamos el boton de nuevo juego, se nos despliega un dialogo para introducir el nombre del nuevo jugador.

![image](https://user-images.githubusercontent.com/60671203/133017819-34f17354-526c-4895-8f25-c54aa54d761b.png)

Si introducimos un nombre, el juego inicia y muestra una primera pregunta, la cual pertenece a una categoria que aparece en la primera ronda.

![image](https://user-images.githubusercontent.com/60671203/133017932-de70f8a2-3644-417b-b597-7469242401c1.png)

Hay 5 categorias, y cada una tiene una dificultad asignada.

![image](https://user-images.githubusercontent.com/60671203/133018076-5687ece4-3913-4b96-877b-c9ce09cf43b9.png)

Como nos encontramos en la primera ronda, nos van a aparecer solo preguntas de la categoria 'SPORT'. 
La pregunta es elegida aleatoriamente si cumple con la categoria/dificultad de la ronda y si se encuentra en el archivos de properties.
Cada pregunta tiene 4 posibles respuestas, y una unica respuesta correcta.

![image](https://user-images.githubusercontent.com/60671203/133018351-09853080-6407-4919-bc49-7527fbb12006.png)

A medida que el jugador va acertando, van apareciendo las preguntas de las otras categorias que estan asignadas a las rondas superiores.

En el concurso, el jugador tiene tres posibles escenarios:
1. El jugador pierde en alguna pregunta y no se lleva nada. La casilla del nombre se colorea de rojo. No importa que tanto haya avanzado, no logra conservar ninguna recompensa.

![image](https://user-images.githubusercontent.com/60671203/133018715-b671c009-2d51-4cc6-a9ac-a4e57cabbed1.png)

2. El jugador se retira voluntariamente y se lleva el acumulado que llevaba de premios. La casilla del nombre se colorea de amarrillo. Se conserva la recompensa que llevaba.

![image](https://user-images.githubusercontent.com/60671203/133019052-f7721cda-0249-4875-a67f-a5313b7ca071.png)


3. El jugador completa todo el concurso y se lleva todos los premios. La casilla del nombre se colorea de verde. Se guarda el acumulado maximo.

![image](https://user-images.githubusercontent.com/60671203/133019158-938cb11a-9cef-4977-bc41-7ef810e21bd6.png)

Todos estos resultados se guardan en una tabla sencilla en la base de datos.

![image](https://user-images.githubusercontent.com/60671203/133019360-98f0f460-e93b-4203-875f-a5c94d378642.png)


Eso es todo :D
