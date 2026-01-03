# Automatización de Pruebas - Proyecto Maven + CI

## Objetivo
Construir un proyecto Java con Maven que incluya pruebas unitarias automatizadas y un pipeline de Integración Continua (CI) en GitHub Actions, ejecutando los tests en cada push o pull request.

- Repositorio Git con commits frecuentes y mensajes claros (chore:, test:, ci:).
- Proyecto Maven configurado con dependencias de testing (JUnit).
- Pruebas unitarias atómicas e independientes (suma y resta).
- Estructura estándar Maven:
  - src/main/java (código)
  - src/test/java (tests)
- .gitignore para evitar subir target/ y archivos del IDE.
- Pipeline CI con GitHub Actions que ejecuta mvn test.
- Reporte/output accesible: artefacto surefire-reports generado por el pipeline.
- Evidencia con capturas: ejecución local y ejecución en CI.

## Estructura del proyecto

demo/
├── src/
│ ├── main/java/com/example/
│ │ └── App.java
│ └── test/java/com/example/
│ ├── AppTest.java
│ └── CalculadoraTest.java
├── .github/
│ └── workflows/
│ └── ci.yml
├── pom.xml
├── .gitignore
└── README.md

## Configuración de Maven
El proyecto utiliza Maven con JUnit para pruebas unitarias.  
Las dependencias están definidas en el archivo pom.xml.

## Pruebas unitarias
Se implementaron pruebas unitarias atómicas e independientes:

- **Suma:** valida que 2 + 3 = 5
- **Resta:** valida que 5 - 2 = 3

Archivo principal:
- src/test/java/com/example/CalculadoraTest.java

---

## Ejecución local de pruebas
Para ejecutar las pruebas en el entorno local:

bash
mvn test
Resultado esperado:

BUILD SUCCESS

Todas las pruebas ejecutadas sin errores

Control de versiones (Git)
Comandos utilizados
Inicialización y configuración:

git init
git branch -M main
Ejemplo de commits:

git commit -m "chore: estructura inicial proyecto maven"
git commit -m "test: agregar pruebas unitarias de suma y resta"
git commit -m "ci: agregar pipeline de integración continua con GitHub Actions"
Archivo .gitignore
Se excluyen archivos innecesarios del repositorio:

git.ignore
# Maven
/target/

# IDEs
/.idea/
.vscode/

# OS
.DS_Store
Thumbs.db
Pipeline de Integración Continua (CI)
Ruta
.github/workflows/ci.yml

Funcionalidad
El pipeline realiza las siguientes acciones:
Descarga el repositorio.
Configura Java 17.
Ejecuta mvn test.
Genera y publica el artefacto con los reportes de pruebas (surefire-reports).

Eventos
El pipeline se ejecuta automáticamente en:
push a la rama main
pull request hacia la rama main

Reportes de pruebas
Los resultados de las pruebas se generan mediante Maven Surefire y se publican como artefacto descargable en GitHub Actions:

target/surefire-reports

Esto permite al equipo revisar el resultado de los tests sin necesidad de ejecutar el proyecto localmente.

Evidencias
Se incluyen capturas de pantalla que muestran:
Ejecución local de mvn test con resultado exitoso.
Ejecución del pipeline en GitHub Actions en estado Success.
Artefacto generado con los reportes de pruebas.

Autor
Proyecto desarrollado como actividad académica de automatización de pruebas Emilio Robles. Iplacex 2025-2026
