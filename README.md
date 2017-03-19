# README #

Luiza Labs API

author: Daniel Assunção Faria de Menezes

email: daniel.afmenezes@gmail.com

# How to #

The application was developed to run with the web container jetty running on maven. To start the system by running the unit tests just run the command at the root of the project, where the maven configuration file can be found(pom.xml):

`mvn test jetty:run`

The API was designed to run with only the web container (No EJB container was necessary). 
To persiste data the system use the Derby on memory Relational Database provided by Apache, the database is created when the application starts, the script can be founded at `resource/META-INF/create-script.sql.`
The service was implemented by JAX-RS on methods GET, POST and DELETE, The PUT method wasn't implemented because the update operation wasn't necessary to application. 

# Api Calls: #

	# Marker #
	-- GET
	localhost:8080/rest/marker/get/{id}
	-- GET
	localhost:8080/rest/marker/getAll
	-- POST
	localhost:8080/rest/marker/save/
	-- DELETE
	localhost:8080/rest/marker/delete/{id}

# Execution LOG #
MacBook-Pro-de-Daniel:luizalabsapi danielmenezes$ mvn test jetty:run
Listening for transport dt_socket at address: 8000
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Restful API 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ luizalabsapi ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/danielmenezes/Documents/GIT/luizalabsapi/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ luizalabsapi ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ luizalabsapi ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/danielmenezes/Documents/GIT/luizalabsapi/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ luizalabsapi ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ luizalabsapi ---
[INFO] Surefire report directory: /Users/danielmenezes/Documents/GIT/luizalabsapi/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.avenuecode.api.facade.MarkerFacadeTest
mar 19, 2017 10:48:04 AM org.glassfish.jersey.server.ApplicationHandler initialize
INFORMAÇÕES: Initiating Jersey application, version Jersey: 2.5.1 2014-01-02 13:43:00...
mar 19, 2017 10:48:04 AM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer start
INFORMAÇÕES: Starting JettyTestContainer...
2017-03-19 10:48:04.484:INFO:oejs.Server:main: jetty-9.0.6.v20130930
2017-03-19 10:48:04.533:INFO:oejs.ServerConnector:main: Started ServerConnector@387eae0a{HTTP/1.1}{0.0.0.0:9998}
mar 19, 2017 10:48:04 AM org.glassfish.jersey.filter.LoggingFilter log
INFORMAÇÕES: 1 * Sending client request on thread main
1 > POST http://localhost:9998/marker/save
1 > Content-Type: application/json
{"id":1,"label":"Luizalabs Franca","lat":-20.57,"lng":-47.48}

[EL Info]: 2017-03-19 10:48:05.47--ServerSession(673711594)--EclipseLink, version: Eclipse Persistence Services - 2.5.2.v20131113-a7346c6
[EL Info]: connection: 2017-03-19 10:48:06.233--ServerSession(673711594)--file:/Users/danielmenezes/Documents/GIT/luizalabsapi/target/classes/_API_PU login successful
mar 19, 2017 10:48:06 AM org.glassfish.jersey.filter.LoggingFilter log
INFORMAÇÕES: 2 * Client response received on thread main
2 < 200
2 < Content-Type: text/html
2 < Server: Jetty(9.0.6.v20130930)
2 < Transfer-Encoding: chunked
Marker has been successfully saved

mar 19, 2017 10:48:06 AM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer stop
INFORMAÇÕES: Stopping JettyTestContainer...
2017-03-19 10:48:06.769:INFO:oejs.ServerConnector:main: Stopped ServerConnector@387eae0a{HTTP/1.1}{0.0.0.0:9998}
mar 19, 2017 10:48:06 AM org.glassfish.jersey.server.ApplicationHandler initialize
INFORMAÇÕES: Initiating Jersey application, version Jersey: 2.5.1 2014-01-02 13:43:00...
mar 19, 2017 10:48:06 AM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer start
INFORMAÇÕES: Starting JettyTestContainer...
2017-03-19 10:48:06.857:INFO:oejs.Server:main: jetty-9.0.6.v20130930
2017-03-19 10:48:06.859:INFO:oejs.ServerConnector:main: Started ServerConnector@20d0d80a{HTTP/1.1}{0.0.0.0:9998}
mar 19, 2017 10:48:06 AM org.glassfish.jersey.filter.LoggingFilter log
INFORMAÇÕES: 1 * Sending client request on thread main
1 > GET http://localhost:9998/marker/get/1

mar 19, 2017 10:48:06 AM org.glassfish.jersey.filter.LoggingFilter log
INFORMAÇÕES: 2 * Client response received on thread main
2 < 200
2 < Content-Type: application/json
2 < Server: Jetty(9.0.6.v20130930)
2 < Transfer-Encoding: chunked
{"id":1,"label":"Luizalabs Franca","lat":-20.57,"lng":-47.48}

mar 19, 2017 10:48:06 AM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer stop
INFORMAÇÕES: Stopping JettyTestContainer...
2017-03-19 10:48:06.904:INFO:oejs.ServerConnector:main: Stopped ServerConnector@20d0d80a{HTTP/1.1}{0.0.0.0:9998}
mar 19, 2017 10:48:06 AM org.glassfish.jersey.server.ApplicationHandler initialize
INFORMAÇÕES: Initiating Jersey application, version Jersey: 2.5.1 2014-01-02 13:43:00...
mar 19, 2017 10:48:06 AM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer start
INFORMAÇÕES: Starting JettyTestContainer...
2017-03-19 10:48:06.980:INFO:oejs.Server:main: jetty-9.0.6.v20130930
2017-03-19 10:48:06.983:INFO:oejs.ServerConnector:main: Started ServerConnector@3f1adad1{HTTP/1.1}{0.0.0.0:9998}
mar 19, 2017 10:48:07 AM org.glassfish.jersey.filter.LoggingFilter log
INFORMAÇÕES: 1 * Sending client request on thread main
1 > GET http://localhost:9998/marker/getAll

mar 19, 2017 10:48:07 AM org.glassfish.jersey.filter.LoggingFilter log
INFORMAÇÕES: 2 * Client response received on thread main
2 < 200
2 < Content-Type: application/json
2 < Server: Jetty(9.0.6.v20130930)
2 < Transfer-Encoding: chunked
[{"id":1,"label":"Luizalabs Franca","lat":-20.57,"lng":-47.48},{"id":2,"label":"Luizalabs SP","lat":-23.51,"lng":-46.61}]

mar 19, 2017 10:48:07 AM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer stop
INFORMAÇÕES: Stopping JettyTestContainer...
2017-03-19 10:48:07.162:INFO:oejs.ServerConnector:main: Stopped ServerConnector@3f1adad1{HTTP/1.1}{0.0.0.0:9998}
mar 19, 2017 10:48:07 AM org.glassfish.jersey.server.ApplicationHandler initialize
INFORMAÇÕES: Initiating Jersey application, version Jersey: 2.5.1 2014-01-02 13:43:00...
mar 19, 2017 10:48:07 AM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer start
INFORMAÇÕES: Starting JettyTestContainer...
2017-03-19 10:48:07.210:INFO:oejs.Server:main: jetty-9.0.6.v20130930
2017-03-19 10:48:07.212:INFO:oejs.ServerConnector:main: Started ServerConnector@ec2bf82{HTTP/1.1}{0.0.0.0:9998}
mar 19, 2017 10:48:07 AM org.glassfish.jersey.filter.LoggingFilter log
INFORMAÇÕES: 1 * Sending client request on thread main
1 > DELETE http://localhost:9998/marker/delete/1

mar 19, 2017 10:48:07 AM org.glassfish.jersey.filter.LoggingFilter log
INFORMAÇÕES: 2 * Client response received on thread main
2 < 200
2 < Content-Type: application/json
2 < Server: Jetty(9.0.6.v20130930)
2 < Transfer-Encoding: chunked
Marker has been successfully deleted

mar 19, 2017 10:48:07 AM org.glassfish.jersey.test.jetty.JettyTestContainerFactory$JettyTestContainer stop
INFORMAÇÕES: Stopping JettyTestContainer...
2017-03-19 10:48:07.255:INFO:oejs.ServerConnector:main: Stopped ServerConnector@ec2bf82{HTTP/1.1}{0.0.0.0:9998}
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.798 sec

Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] >>> jetty-maven-plugin:9.4.0.RC3:run (default-cli) > test-compile @ luizalabsapi >>>
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ luizalabsapi ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/danielmenezes/Documents/GIT/luizalabsapi/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ luizalabsapi ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ luizalabsapi ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/danielmenezes/Documents/GIT/luizalabsapi/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ luizalabsapi ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] <<< jetty-maven-plugin:9.4.0.RC3:run (default-cli) < test-compile @ luizalabsapi <<<
[INFO] 
[INFO] --- jetty-maven-plugin:9.4.0.RC3:run (default-cli) @ luizalabsapi ---
[INFO] Configuring Jetty for project: Restful API
[INFO] webAppSourceDirectory not set. Trying src/main/webapp
[INFO] Reload Mechanic: automatic
[INFO] Classes = /Users/danielmenezes/Documents/GIT/luizalabsapi/target/classes
[INFO] Logging initialized @7418ms to org.eclipse.jetty.util.log.Slf4jLog
[INFO] Context path = /
[INFO] Tmp directory = /Users/danielmenezes/Documents/GIT/luizalabsapi/target/tmp
[INFO] Web defaults = org/eclipse/jetty/webapp/webdefault.xml
[INFO] Web overrides =  none
[INFO] web.xml file = file:///Users/danielmenezes/Documents/GIT/luizalabsapi/src/main/webapp/WEB-INF/web.xml
[INFO] Webapp directory = /Users/danielmenezes/Documents/GIT/luizalabsapi/src/main/webapp
[INFO] jetty-9.4.0.RC3
[WARNING] THIS IS NOT A STABLE RELEASE! DO NOT USE IN PRODUCTION!
[WARNING] Download a stable release from http://download.eclipse.org/jetty/
[INFO] Scanning elapsed time=1706ms
[INFO] DefaultSessionIdManager workerName=node0
[INFO] No SessionScavenger set, using defaults
[INFO] Scavenging every 660000ms
mar 19, 2017 10:48:11 AM org.glassfish.jersey.server.ApplicationHandler initialize
INFORMAÇÕES: Initiating Jersey application, version Jersey: 2.5.1 2014-01-02 13:43:00...
mar 19, 2017 10:48:11 AM org.glassfish.jersey.server.ApplicationHandler bindProvidersAndResources
ADVERTÊNCIA: Component of class interface com.luizalabs.api.facade.MarkerFacade cannot be instantiated and will be ignored.
[INFO] Started o.e.j.m.p.JettyWebAppContext@135a8c6f{/,file:///Users/danielmenezes/Documents/GIT/luizalabsapi/src/main/webapp/,AVAILABLE}{file:///Users/danielmenezes/Documents/GIT/luizalabsapi/src/main/webapp/}
[INFO] Started ServerConnector@50a8eb7f{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
[INFO] Started @11548ms
[INFO] Started Jetty Server
