# Documentación de la Biblioteca Compartida

## Pipeline Principal: `ciPipeline`

Pipeline completo de CI/CD para aplicaciones Python.

**Parámetros:**
- `pythonVersion` (opcional): Versión de Python a usar (por defecto: '3.13.3')
- `testDir` (opcional): Directorio que contiene las pruebas (por defecto: 'tests/')
- `coverage` (opcional): Si se debe generar el informe de cobertura (por defecto: true)
- `buildDir` (opcional): Directorio de salida para los paquetes (por defecto: 'dist/')
- `emailCredId` (opcional): ID de las credenciales para notificaciones (por defecto: 'email_recipient')

**Etapas del Pipeline:**
1. **Setup Python**: Configura el entorno Python
2. **Lint**: Ejecuta análisis estático de código
3. **Test**: Ejecuta pruebas unitarias con cobertura
4. **Build**: Construye el paquete Python

**Ejemplo de Uso en Jenkinsfile:**
```groovy
@Library('mi-shared-library') _

ciPipeline(
    pythonVersion: '3.13.3',
    testDir: 'tests/',
    coverage: true,
    buildDir: 'dist/',
    emailCredId: 'email_recipient'
)
```

## Funciones Individuales

### `buildPythonApp`

Construye la aplicación Python y genera los paquetes de distribución.

**Parámetros:**
- `venvDir` (opcional): Directorio del entorno virtual (por defecto: '${env.WORKSPACE}/venv')
- `buildDir` (opcional): Directorio de salida (por defecto: 'dist/')

### `testPythonApp`

Ejecuta las pruebas de la aplicación Python.

**Parámetros:**
- `venvDir` (opcional): Directorio del entorno virtual (por defecto: '${env.WORKSPACE}/venv')
- `testDir` (opcional): Directorio de pruebas (por defecto: 'tests/')
- `sourceDir` (opcional): Directorio de código fuente (por defecto: 'src/agente_prueba2')

### `setupPythonEnv`

Configura un entorno virtual de Python.

**Parámetros:**
- `pythonVersion` (opcional): Versión de Python (por defecto: '3.13.3')
- `venvDir` (opcional): Directorio del entorno virtual (por defecto: '${env.WORKSPACE}/venv')

## Flujo de Trabajo Recomendado

1. Usa `ciPipeline` para un flujo completo de CI/CD
2. Usa las funciones individuales para personalizar el flujo según necesidades específicas
3. Las credenciales se manejan de forma segura mediante el almacén de credenciales de Jenkins

## Configuración en Jenkins

1. **Configura la biblioteca compartida en Jenkins**:
   - Ve a `Jenkins Dashboard` > `Manage Jenkins` > `System Configuration` > `Configure System`
   - Busca `Global Pipeline Libraries`
   - Agrega una nueva biblioteca con:
     - **Name**: `agente-prueba2-shared-library`
     - **Default version**: `main`
     - **Retrieval method**: `Modern SCM`
     - **Source Code Management**: `Git`
     - **Project Repository**: URL de tu repositorio de la biblioteca

2. **Uso en el Jenkinsfile**:
   ```groovy
   @Library('agente-prueba2-shared-library@main') _

   pipeline {
       // ...
   }
   ```

## Estructura del Proyecto

```
.jenkins/
├── src/
│   └── org/
│       └── example/
│           └── Utils.groovy
├── vars/
│   ├── buildPythonApp.groovy
│   ├── testPythonApp.groovy
│   └── withPythonEnv.groovy
├── README.md
└── DOCUMENTATION.md
```
