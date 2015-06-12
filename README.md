## Introduction

This is a single-module maven project that demonstrates how the following technologies can be integrated:

* Spring Boot (Single-jar deployment of Spring MVC-based projects)
* Sass Maven Plugin (Sass to CSS)
* Wro4J (For build-time javascript combination/minification)
* Handlebars.java (Server-side templating...potential for client-side use of "compiled" templates not demonstrated yet)

## Running

To build a single-jar executable:

    mvn package

To run a 'live server'

    mvn spring-boot:run (ctrl-c to end)

While the live server is running, you may modify handlebars templates in-place (in the source tree)
and have changes immediately visible when hitting http://localhost:8080/. Same with javascript,
images, and all 'static' resources.

To enable use of minified/combined javascript during a spring-boot:run invocation, specify
-Dlive-server.profiles=production

To auto-build SASS -> CSS while the above is running, in another terminal:

    mvn sass:watch (ctrl-c to end)

While this is running during a spring-boot:run invocation, you may modify any SASS sources in the
source tree and have the CSS changes automatically visible when hitting http://localhost:8080/
