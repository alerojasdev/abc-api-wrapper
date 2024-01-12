# abc-api-wrapper

Esta aplicacion spring boot provee de un endpoint wrapper de la pagina de abc.com.py/buscar.

La applicacion se puede levantar con el siguiente comando:

./mvnw clean spring-boot:run

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







