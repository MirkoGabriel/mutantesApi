# mutantesApi

** API REST **

    Tiene un servicio ("/mutant") el cual tine una peticion post que recibe una estructura json.
    En una clase instanciada con el atributo array String "dna"
    con ese atributo manda a la funcion "is Mutant" realiza la logica y dependiendo del resultado manda una respuesta http 200 o 403.

** GENERAR WAR **

    crear proyecto java 8 (spring tool)
    packing war
    borrar en proyect->properties->en profile el pom.xml y dar aplicar.
    run as -> spring boot app ->
    run as -> install maven (genera .war)
    maven-> update pyoject

** DEPLOY **

    subir el proyecto a git
    heroku login (logearse en heroku)
    heroku plugins:install heroku-cli-deploy
    heroku war:deploy target/nombre.war --app nombre appheroku.
    heroku open --app nombre appheroku.

** LOCAL **

    ejecutar el proyecto
    levanta el servidor en el localhost:8080 de (forma local)
    probar en postaman localhost:8080/ap/mutant
    seleccionar tipo peticion 'POST'
    seleccionar body -> raw -> tipo de texto (JSON)
    escribir ej :({ "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCATGA"]} )

** HEROKU **
https://mirko-mutantes.herokuapp.com/
