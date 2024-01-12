# abc-api-wrapper

Esta aplicacion spring boot provee de un endpoint wrapper de la pagina de abc.com.py/buscar.

La applicacion se puede levantar con el siguiente comando:

./mvnw clean spring-boot:run

Java Version 17

Se requiere que Java 17 este instalado y que este el ejecutable este en el $PATH

El endpoint esta en 
http://localhost:8080/abc-api-implementation/consulta

Recibe 2 query parameters: 
1) *requestedInfo* (requerido): El texto de busqueda 
2) *f* (opcional): [true|false] dependiendo de si se solicita o no que el contenido de las imagenes aparezcan en la respuesta en formato base64

Adicionalmente para llamar al endpoint se requiere de una API key que debe ser enviada en la cabecera HTTP `apiKey`.
El api key configurado es: `ABC123`

La documentacion swagger esta disponible en
http://localhost:8080/swagger-ui.html

El endpoint esta protegido por un interceptor que valida el api key en el http request header.

Dos convertidores de mensajes fueron agregados para serializar la respuesta a texto plano y html. Ya que SpringBoot solo provee serializadores por defecto para JSON y XML.

Una base de datos H2 esta configurada en memoria segun application.properties y algunos datos iniciales se cargan en la base de datos en DatabaseInitializer.java. La base de datos se utiliza solamente para guardar un API key.

Adjunto un video en donde explico la funcionalidad y el codigo.
