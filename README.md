<h1 align="center">
  <br>
  <a href="http://www.amitmerchant.com/electron-markdownify"><img src="https://f.hubspotusercontent20.net/hubfs/2829524/Copia%20de%20LOGOTIPO_original-2.png"></a>
  <br>
  Performance con Karate - Gatling
  <br>
</h1>

<h4 align="center">Proyecto base de <a href="https://github.com/karatelabs/karate" target="_blank">Pragma</a>.</h4>


<p align="center">
  <a href="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html">
    <img src="https://img.shields.io/badge/Java-11+-orange.svg" alt="Java">
  </a>
  <a href="https://www.mysql.com/">
    <img src="https://img.shields.io/badge/Database-MySQL-blue.svg" alt="MySQL">
  </a>
  <a href="https://www.postgresql.org/">
    <img src="https://img.shields.io/badge/Database-PostgreSQL-blue.svg" alt="PostgreSQL">
  </a>
  <a href="https://www.w3schools.com/sql/">
    <img src="https://img.shields.io/badge/SQL-Fundamentals-lightgrey.svg" alt="SQL">
  </a>
  <a href="https://cucumber.io/">
    <img src="https://img.shields.io/badge/Cucumber-BDD-green.svg" alt="Cucumber">
  </a>
  <a href="https://serenity-bdd.info/">
    <img src="https://img.shields.io/badge/Serenity-Reporting-blueviolet.svg" alt="Serenity">
  </a>
  <a href="https://www.selenium.dev/">
    <img src="https://img.shields.io/badge/Selenium-Web_Testing-brightgreen.svg" alt="Selenium">
  </a>
</p>

Este proyecto realiza pruebas de performance utilizando Karate junto con Gatling para simular carga y medir el rendimiento de un servicio.

<p align="center">
  <a href="#topicos">Topicos</a> •
  <a href="#tecnologias">Tecnologias</a> •
  <a href="#consideraciones">Consideraciones</a> •
  <a href="#descarga">Descarga</a> •
  <a href="#instalación-y-ejecución">Instalación y ejecución</a> •
  <a href="#autores">Autores</a> •
  <a href="#relacionados">Relacionados</a> •
  <a href="#roadmap">Roadmap</a>
</p>

## Topicos

* Karate
* Gatling
* Gradle
* Scala

## Tecnologias
### This project required:
- [JDK java] version 16
- [Karate] Version 1.5.0
- [Gradle] last version


## Estructura del Proyecto
```
  ├── src/
  │   ├── test/
  │   │   ├── java/
  │   │   │   ├── performance/               # Runner de pruebas de performance
  │   │   │   ├── karate/                    # Pruebas en Karate
  │   │   │   │   ├── config.feature         # Carga de configuraciones
  │   │   │   │   ├── test.feature           # Prueba de API
  │   │   ├── resources/
  │   │   │   ├── karate-config.js           # Archivo de configuración global
  ├── build.gradle                            # Configuración de Gradle
  ├── README.md                               # Documentación del proyecto


```
## Descarga
Para clonar está aplicación desde la linea de comando:

```bash
git clone https://github.com/somospragma/qa-performance-karate-gatling
cd qa-performance-karate-gatling
git remote remove origin
git remote add origin URL_DE_TU_NUEVO_REPOSITORIO
git push -u origin master
```
Nota: Asegúrate de reemplazar URL_DE_TU_NUEVO_REPOSITORIO con la URL del repositorio que creaste en tu cuenta de GitHub.

Puedes descargar el proyecto en el enlace [download](https://github.com/somospragma/qa-transversal-proyecto-base-manejo-base-de-datos-java) 

## Configuración

El archivo karate-config.js contiene las configuraciones del entorno:
```
function() {
    var config = {
        urlBaseAuth: '(variable)',
        urlBase: '(variable)',
        rampUsers: '(variable)',
        during: '(variable)'
    };
    return config;
}
```
## Instalación y ejecución

Para ejecutar está aplicación, necesitas [Gradle](https://gradle.org/install) instalado en tu equipo, ten en cuenta que tu IDE puede gestionar la instalación de estos dos requerimientos. Desde la linea de comando:

```
gradle clean build
```

##  🛠️ Run tests:
Para ejecutar las pruebas de carga, usa el siguiente comando:

gradle gatlingRun

```
gradle gatlingRun
```

Nota:

*   Esto ejecutará el PerformanceTestRunner.java, el cual define la simulación de carga utilizando los escenarios de Karate.

## Reportes

Los reportes de las pruebas se generan en:
```
/build/reports/gatling/
```
Se puede acceder a un resumen de las pruebas ejecutadas con detalles de tiempos de respuesta y número de peticiones por segundo.

## Autores


| [<img src="https://gitlab.com/uploads/-/system/user/avatar/13437423/avatar.png?width=400" width=115><br><sub>Mauro L. Ibarra P.</sub>](https://gitlab.com/mauro.ibarrap) <br/> | [<img src="https://secure.gravatar.com/avatar/23b2db02403d79ebd356e8e8356758ec?s=192&d=identicon" width=115><br><sub>Otro autor</sub>](https://github.com/CristianMillanPragma) | 
:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|


## Relacionados

- [proyecto-base-serenity-bdd-screenplay-browsers-and-utilities](https://github.com/somospragma/qa-web-proyecto-base-serenity-bdd-screenplay-browsers-and-utilities)


## Roadmap

- [Guia QA](https://github.com/amitmerchant1990/pomolectron) - (En construcción) Una guia de proyectos Orientados a la Calidad de Software

