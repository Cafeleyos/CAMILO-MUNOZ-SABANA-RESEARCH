#Solución del parcial 

##Conceptos
###¿Cuáles son las acciones los tres momentos importantes de las excepciones? ¿Cuál es el objetivo de cada una? ¿Cómo se implementa en Java cada acción?.
Como primer momento, una excepción es lanzada utilizando la palabra reservada throw que romperá el código. Esta simplemente informara de manera local que se generó una excepción. Seguido, esta se propaga mediante la palabra reservada throws (se coloca después de definir los parámetros de un método) que sirve para que todos los métodos que lo llamen puedan tomar acciones respecto a esa excepción. Finalmente, se controla la excepción utilizando el comando try- catch que llamara al método o métodos deseados y controlara (imprimiendo la excepción, modificando algo en el método, etc) respectivamente.

###¿Qué es sobre-escritura de métodos? ¿Por qué aplicarla? ¿Cómo impedir que se sobre-escriba un método?.
La sobre escritura de métodos es un aspecto muy importante que aplica en el concepto de herencia. Pues consideramos que existe una clase padre que define ciertos atributos y métodos, de esta, una o varias clases pueden heredar tanto sus comportamientos como sus atributos dependiendo de los modificadores de acceso utilizados. Entonces, estos “hijos” pueden mantener el comportamiento de uno o varios métodos o pueden realizar una sobre escritura en algunos o todos ellos.
Esto, en resumen, permite que un método heredado sea modificado para cambiar parcial o completamente su comportamiento dependiendo de lo requerido. Para realizarlo, simplemente se escribe el encabezado del método a modificar de igual manera en la clase hija y se recomienda colocar una etiqueta de @Override. En caso contrario, donde no deseemos permitir que algún método se sobre escriba utilizaremos la palabra final que evitara este comportamiento. 

##Diseñando 

El método summarize en la clase StudentSynthesizer resume la información del tiempo invertido por cada estudiante en el proyecto imprimiendo 
el nombre y el tiempo trabajado de cada uno de ellos. 
`summarize()` return void

En la clase ExecutiveSynthesizer, el método summarize presenta la duración de cada
iteración del proyecto imprimiendo el Objetivo y la Duración de cada una de ellas
`summarize()` return void
