<h1 align="center">
  <br>
  <a href="http://www.amitmerchant.com/electron-markdownify"><img src="https://f.hubspotusercontent20.net/hubfs/2829524/Copia%20de%20LOGOTIPO_original-2.png"></a>
  <br>
  Performance Testing con Karate + Gatling
  <br>
</h1>

<h4 align="center">Framework de pruebas de performance siguiendo las reglas de calidad transversales de  <a href="https://github.com/karatelabs/karate" target="_blank">Pragma</a>.</h4>

<p align="center">
  <a href="https://www.oracle.com/java/technologies/javase-jdk20-downloads.html">
    <img src="https://img.shields.io/badge/Java-20+-orange.svg" alt="Java">
  </a>
  <a href="https://github.com/karatelabs/karate">
    <img src="https://img.shields.io/badge/Karate-1.5.1-green.svg" alt="Karate">
  </a>
  <a href="https://gatling.io/">
    <img src="https://img.shields.io/badge/Gatling-Performance-red.svg" alt="Gatling">
  </a>
  <a href="https://gradle.org/">
    <img src="https://img.shields.io/badge/Gradle-Build-blue.svg" alt="Gradle">
  </a>
  <a href="#">
    <img src="https://img.shields.io/badge/CI/CD-GitHub_Actions-brightgreen.svg" alt="GitHub Actions">
  </a>
</p>

Este proyecto implementa un framework robusto de pruebas de performance utilizando **Karate** para definir escenarios de API y **Gatling** para ejecutar simulaciones de carga, siguiendo las reglas de calidad transversales de Pragma.

## 🎯 Características Principales

✅ **Configuración por Ambientes** - Soporte completo para dev/qa/prod  
✅ **Variables Dinámicas** - Parametrización desde variables de ambiente  
✅ **Assertions Configurables** - Umbrales de performance personalizables  
✅ **CI/CD Automatizado** - Pipeline básico con GitHub Actions  
✅ **Reportes Detallados** - Métricas completas de Gatling  
✅ **Estructura Modular** - Organización siguiendo mejores prácticas

<p align="center">
  <a href="#📋-tabla-de-contenidos">Contenidos</a> •
  <a href="#🛠️-tecnologías">Tecnologías</a> •
  <a href="#📁-estructura">Estructura</a> •
  <a href="#⚙️-configuración">Configuración</a> •
  <a href="#🚀-instalación-y-uso">Instalación</a> •
  <a href="#📊-ejecución-de-pruebas">Ejecución</a> •
  <a href="#📈-reportes">Reportes</a> •
  <a href="#🔧-ci/cd">CI/CD</a>
</p>

---

## 📋 Tabla de Contenidos

- [🛠️ Tecnologías](#🛠️-tecnologías)
- [📁 Estructura del Proyecto](#📁-estructura-del-proyecto)
- [⚙️ Configuración por Ambientes](#⚙️-configuración-por-ambientes)
- [🚀 Instalación y Configuración](#🚀-instalación-y-configuración)
- [📊 Ejecución de Pruebas](#📊-ejecución-de-pruebas)
- [📈 Reportes y Métricas](#📈-reportes-y-métricas)
- [🔧 CI/CD con GitHub Actions](#🔧-cicd-con-github-actions)
- [📝 Variables de Configuración](#📝-variables-de-configuración)

---

## 🛠️ Tecnologías

### Stack Principal
- **Java 20+** - Runtime environment (Amazon Corretto)
- **Karate 1.5.1** - Framework de testing API con BDD
- **Gatling** - Motor de simulación de carga y performance
- **Gradle** - Herramienta de build y gestión de dependencias
- **GitHub Actions** - Pipeline de CI/CD automatizado

### Requisitos del Sistema
```
☕ JDK 20+ (Amazon Corretto recomendado)
🔧 Gradle 7.0+ (incluido wrapper)
🌐 Acceso a internet para dependencias
💾 ~100MB espacio libre para reportes
```

---

## 📁 Estructura del Proyecto

```
qa-performance-karate-gatling/
├── 📂 .github/workflows/          # Configuración CI/CD
│   └── performance-tests.yml      # Pipeline básico GitHub Actions
├── 📂 src/test/
│   ├── 📂 java/
│   │   ├── 📂 performance/        # Simulaciones Gatling
│   │   │   └── PerformanceTestRunner.java
│   │   └── 📂 utils/              # Utilidades del proyecto
│   │       ├── PasswordEncryptor.java
│   │       └── UuidFormat.java
│   └── 📂 resources/
│       ├── 📂 config/             # ✨ Configuraciones por ambiente
│       │   ├── karate-config-dev.js     # Desarrollo
│       │   ├── karate-config-qa.js      # QA/Testing  
│       │   └── karate-config-prod.js    # Producción
│       ├── 📂 karate/             # Features de prueba
│       │   ├── config.feature     # Carga configuración global
│       │   ├── testPosts.feature  # Pruebas API Posts
│       │   └── testUsers.feature  # Pruebas API Users
│       ├── karate-config.js       # ⚙️ Configurador principal
│       └── logback-test.xml       # Configuración logging
├── 📂 build/reports/gatling/      # 📊 Reportes generados
├── build.gradle                   # Configuración Gradle
└── README.md                      # Documentación del proyecto
```

---

## ⚙️ Configuración por Ambientes

### 🎛️ Sistema Multi-Ambiente

El proyecto soporta **3 ambientes** con configuraciones específicas:

| Ambiente | Archivo | Uso | Usuarios | Duración | Response Time |
|----------|---------|-----|----------|----------|---------------|
| **DEV** | `karate-config-dev.js` | Desarrollo | 5 | 30s | 2000ms |
| **QA** | `karate-config-qa.js` | Testing | 10 | 60s | 1500ms |
| **PROD** | `karate-config-prod.js` | Producción | 20 | 120s | 1000ms |

### 🔧 Configuración Principal (`karate-config.js`)

```javascript
function fn() {
    var env = karate.env || 'prod';  // Ambiente por defecto
    var config;
    
    // Carga configuración específica del ambiente
    if (env === 'qa') {
        config = karate.callSingle('classpath:config/karate-config-qa.js');
    } else if (env === 'prod') {
        config = karate.callSingle('classpath:config/karate-config-prod.js');
    } else {
        config = karate.callSingle('classpath:config/karate-config-dev.js');
    }
    
    return config;
}
```

### 📊 Parámetros Configurables

Cada ambiente expone estas variables desde **variables de sistema**:

```javascript
performance: {
    rampUsers: parseInt(karate.properties['rampUsers'] || '5'),
    during: parseInt(karate.properties['during'] || '30'),
    thresholds: {
        responseTimeMax: parseInt(karate.properties['responseTimeMax'] || '2000'),
        errorRateMax: parseFloat(karate.properties['errorRateMax'] || '5.0'),
        requestsPerSecMin: parseFloat(karate.properties['requestsPerSecMin'] || '1.0'),
        successfulRequestsMin: parseInt(karate.properties['successfulRequestsMin'] || '50')
    }
}
```

---

## 🚀 Instalación y Configuración

### 1️⃣ Clonación del Proyecto

```bash
git clone https://github.com/somospragma/qa-performance-karate-gatling
cd qa-performance-karate-gatling
```

### 2️⃣ Configuración de Ambiente Local

```bash
# Verificar Java 20+
java -version

# Construir proyecto
./gradlew clean build
```

### 3️⃣ Configuración de Variables (Opcional)

```bash
# Linux/Mac
export KARATE_ENV=qa
export rampUsers=15
export during=60

# Windows
set KARATE_ENV=qa
set rampUsers=15
set during=60
```

---

## 📊 Ejecución de Pruebas

### 🎯 Ejecución Básica

```bash
# Ejecutar con configuración por defecto (PROD)
./gradlew gatlingRun

# Ejecutar en ambiente específico
./gradlew gatlingRun -Dkarate.env=dev

# Ejecutar en QA con parámetros personalizados
./gradlew gatlingRun -Dkarate.env=qa -DrampUsers=20 -Dduring=120
```

### ⚡ Ejecución con Parámetros Avanzados

```bash
./gradlew gatlingRun \
  -Dkarate.env=qa \
  -DrampUsers=25 \
  -Dduring=300 \
  -DresponseTimeMax=1500 \
  -DerrorRateMax=3.0 \
  -DrequestsPerSecMin=10.0 \
  -DsuccessfulRequestsMin=200
```

### 🎮 Simulaciones Disponibles

| Escenario | Feature | Tags | Descripción |
|-----------|---------|------|-------------|
| **Posts API** | `testPosts.feature` | `@posts` | CRUD operations en posts |
| **Users API** | `testUsers.feature` | - | Gestión de usuarios |

---

## 📈 Reportes y Métricas

### 📊 Ubicación de Reportes

```
build/reports/gatling/
├── performancetestrunner-{timestamp}/
│   ├── index.html                    # 🎯 Reporte principal
│   ├── req_posts-stats.html         # Estadísticas Posts API  
│   ├── req_users-stats.html         # Estadísticas Users API
│   └── js/stats.json               # Datos en JSON
```

### 📋 Métricas Capturadas

✅ **Response Time** - Percentiles 50, 75, 95, 99  
✅ **Throughput** - Requests por segundo  
✅ **Error Rate** - Porcentaje de errores  
✅ **Success Count** - Número de requests exitosos  
✅ **Connection Time** - Tiempo de establecimiento de conexión  
✅ **Active Users** - Usuarios concurrentes por momento

### 🎯 Assertions Automáticas

El runner valida automáticamente:

```java
.assertions(
    forAll().requestsPerSec().gte(Double.parseDouble(requestsPerSecMin)),
    forAll().failedRequests().percent().lte(Double.parseDouble(errorRateMax)),
    forAll().responseTime().max().lt(Integer.parseInt(responseTimeMax)),
    forAll().successfulRequests().count().gte(Long.parseLong(successfulRequestsMin))
);
```

---

## 🔧 CI/CD con GitHub Actions

### ⚙️ Pipeline Automatizado

**Archivo**: `.github/workflows/performance-tests.yml`

```yaml
name: Basic CI - Performance Tests

on:
  push:
    branches: [ main ]        # Auto-ejecución en push
  pull_request:
    branches: [ main ]        # Validación en PR  
  workflow_dispatch:          # Ejecución manual
```

### 🎯 Flujo de Trabajo

1. **Checkout** - Descarga código fuente
2. **Setup JDK 20** - Configura Amazon Corretto  
3. **Make gradlew executable** - Permisos de ejecución
4. **Build project** - Compilación con Gradle
5. **Run performance tests** - Ejecución de simulaciones
6. **Upload reports** - Almacenamiento de resultados

### 📥 Artifacts Generados

- **Nombre**: `performance-reports`
- **Contenido**: Reportes completos de Gatling
- **Retención**: 90 días
- **Disponible**: Siempre (incluso si las pruebas fallan)

### ▶️ Ejecución Manual

1. Ve a **Actions** en tu repositorio
2. Selecciona **Basic CI - Performance Tests**  
3. Click **Run workflow**
4. Descarga los reportes desde **Artifacts**

---

## 📝 Variables de Configuración

### 🎛️ Variables Principales

| Variable | Descripción | Default DEV | Default QA | Default PROD |
|----------|-------------|-------------|------------|--------------|
| `karate.env` | Ambiente de ejecución | `dev` | `qa` | `prod` |
| `rampUsers` | Usuarios concurrentes | `5` | `10` | `20` |
| `during` | Duración en segundos | `30` | `60` | `120` |
| `urlBase` | URL base del servicio | `jsonplaceholder.typicode.com` | - | - |

### 📊 Variables de Thresholds

| Variable | Descripción | Unidad | DEV | QA | PROD |
|----------|-------------|--------|-----|----|----- |
| `responseTimeMax` | Tiempo máximo respuesta | ms | 2000 | 1500 | 1000 |
| `errorRateMax` | Porcentaje máximo errores | % | 5.0 | 3.0 | 1.0 |
| `requestsPerSecMin` | Mínimo requests/segundo | req/s | 1.0 | 5.0 | 10.0 |
| `successfulRequestsMin` | Mínimo requests exitosos | count | 50 | 100 | 500 |

### 💡 Ejemplo de Configuración Custom

```bash
# Para una prueba de stress en QA
./gradlew gatlingRun \
  -Dkarate.env=qa \
  -DrampUsers=50 \
  -Dduring=600 \
  -DresponseTimeMax=3000 \
  -DerrorRateMax=8.0
```

---

## 👥 Autores

| [<img src="https://gitlab.com/uploads/-/system/user/avatar/13437423/avatar.png?width=400" width=115><br><sub>Mauro L. Ibarra P.</sub>](https://gitlab.com/mauro.ibarrap) | [<img src="https://secure.gravatar.com/avatar/23b2db02403d79ebd356e8e8356758ec?s=192&d=identicon" width=115><br><sub>Cristian Millán</sub>](https://github.com/CristianMillanPragma) |
|:---:|:---:|

---

## 🔗 Enlaces Relacionados

- [Karate Documentation](https://github.com/karatelabs/karate) - Framework principal
- [Gatling Documentation](https://gatling.io/docs/) - Motor de performance  
- [Pragma QA Guidelines](https://github.com/somospragma) - Reglas de calidad transversales
- [Serenity BDD Project](https://github.com/somospragma/qa-web-proyecto-base-serenity-bdd-screenplay-browsers-and-utilities) - Proyecto base Web

---

## 🗺️ Roadmap

- [ ] **Mejora Sintaxis BDD** - Implementar features con mejor sintaxis Gherkin
- [ ] **Datos de Prueba** - Sistema de generación y gestión de test data  
- [ ] **Métricas Avanzadas** - Dashboard en tiempo real con Grafana
- [ ] **Pruebas de Seguridad** - Integración con herramientas de security testing
- [ ] **Multi-protocolo** - Soporte para WebSockets y GraphQL
- [ ] **Reportes Personalizados** - Templates custom para diferentes stakeholders

---

<div align="center">

### 🚀 ¡Listo para ejecutar pruebas de performance de clase mundial!

**¿Tienes preguntas?** Abre un [issue](https://github.com/somospragma/qa-performance-karate-gatling/issues) o contacta al equipo de QA

</div>
