# README #

Luiza Labs API

author: Daniel Assunção Faria de Menezes

email: daniel.afmenezes@gmail.com

# How to #

The application was developed to run with the web container jetty running on maven. To start the system by running the unit tests just run the command at the root of the project, where the maven configuration file can be found(pom.xml):

mvn test jetty:run

There is an Http client with some initial calls if it is necessary to see the GET calls through the browser:

com.luizalabs.api.http.HttpClientSample

# Api Calls: #

# Marker #
--GET
localhost:8080/rest/marker/get/{id}

# luizalabsapi
