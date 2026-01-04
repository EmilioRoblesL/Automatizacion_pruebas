Automatización de Pruebas – Proyecto Maven + BDD + CI/CD

Objetivo
Construir un proyecto Java con Maven que incorpore pruebas unitarias, pruebas BDD, pruebas de performance y un pipeline de Integración Continua (CI) en GitHub Actions, asegurando visibilidad, calidad de resultados y detección temprana de fallos.

Tecnologías utilizadas
Java 17
Maven
JUnit 5
Cucumber (BDD)
k6 (Performance testing)
Git y GitHub
GitHub Actions (CI/CD)

Estructura del proyecto
demo/
src/
main/java/com/example/
App.java
test/java/
com/example/
AppTest.java
CalculadoraTest.java
bdd/
RunCucumberTest.java
steps/
LoginSteps.java
src/test/resources/
features/
login.feature
performance/
login_test.js
.github/
workflows/
ci.yml
performance.yml
pom.xml
.gitignore
README.md

Control de versiones (Git)
Se utilizó Git con commits frecuentes y mensajes claros, siguiendo buenas prácticas.

Ejemplos de commits:
chore: estructura inicial proyecto maven
test: agregar pruebas unitarias de suma y resta
test: agregar escenarios BDD con Cucumber
ci: agregar pipeline de integración continua
perf: agregar pruebas de performance con k6

Configuración de Maven
El proyecto está configurado mediante el archivo pom.xml, incorporando dependencias para pruebas unitarias con JUnit 5, pruebas BDD con Cucumber y ejecución de pruebas desde Maven mediante el comando mvn test.

Pruebas unitarias
Se implementaron pruebas unitarias atómicas e independientes para validar operaciones básicas:

Suma: valida que 2 + 3 = 5

Resta: valida que 5 - 2 = 3

Archivo principal:
src/test/java/com/example/CalculadoraTest.java

Pruebas BDD (Behavior Driven Development)

Sesión Three Amigos (simulada)
Se simuló una sesión Three Amigos considerando los siguientes roles:

Product Owner: define las reglas del negocio

QA: define los criterios de aceptación

Desarrollador: valida la factibilidad técnica

Funcionalidad definida: Login de usuario.

Escenarios en Gherkin
Se implementaron escenarios BDD utilizando lenguaje Gherkin:

Login exitoso con credenciales válidas

Login fallido por credenciales inválidas o campos vacíos (Scenario Outline con Examples)

Archivo:
src/test/resources/features/login.feature

Step Definitions
Los pasos de los escenarios fueron implementados en Java siguiendo buenas prácticas.

Archivo:
src/test/java/bdd/steps/LoginSteps.java

Ejecución local de pruebas
Para ejecutar las pruebas en el entorno local:

mvn clean test

Resultado esperado:
BUILD SUCCESS
Todas las pruebas ejecutadas correctamente.

Pipeline de Integración Continua (CI)
Pipeline de pruebas funcionales
Ruta del workflow:
.github/workflows/ci.yml

Funcionalidad del pipeline:
Descarga del repositorio
Configuración de Java 17
Ejecución de pruebas unitarias y BDD
Generación de reportes
Publicación de artifacts
Dashboard resumido mediante Job Summary

Artifacts generados:
cucumber-bdd-report (HTML y JSON)
surefire-reports

El pipeline se ejecuta automáticamente en:
Push a la rama main
Pull request hacia la rama main

Pruebas de performance
Herramienta
Se utilizó k6 para diseñar una prueba básica de performance sobre la funcionalidad de login.

Archivo:
performance/login_test.js

Escenario de carga:
10 usuarios virtuales concurrentes
Duración de 30 segundos

Indicadores monitoreados:
TPS / RPS (requests por segundo)
Latencia (percentil p95)
Errores (http_req_failed)
Checks funcionales

Pipeline de performance
Ruta del workflow:
.github/workflows/performance.yml

Funcionalidad:
Ejecución de pruebas k6 mediante Docker
Generación de métricas de performance
Publicación de artifacts
Dashboard resumido en GitHub Actions

Artifact generado:
k6-performance-results

Dashboard y métricas
Se implementa un dashboard de calidad simulado utilizando GitHub Actions Job Summary, permitiendo visualizar:
Estado de las pruebas funcionales
Estado de las pruebas de performance
Acceso a artifacts con reportes descargables
Esto permite al equipo revisar la calidad del sistema sin necesidad de ejecutar pruebas localmente.

Alertas automáticas
Las pruebas funcionales fallan automáticamente si mvn test retorna error.
Las pruebas de performance utilizan thresholds en k6 para controlar errores y latencia.
Si los umbrales definidos se superan, el pipeline falla automáticamente, actuando como alerta ante degradación del sistema.
Se incluye un resumen visual de alertas en el Job Summary del pipeline.

Evidencias
Se incluyen capturas de pantalla que muestran:
Ejecución local de mvn test con resultado exitoso
Ejecución del pipeline CI en estado Success
Artifacts generados (Cucumber, Surefire y k6)
Dashboard resumido en GitHub Actions

Autor
Proyecto desarrollado como actividad académica de Automatización de Pruebas.
Autor: Emilio Robles
Institución: IPLACEX
Periodo académico: 2025 – 2026
