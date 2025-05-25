# Jenkins Shared Library

Esta es una biblioteca compartida para los pipelines de Jenkins del proyecto.

## Estructura

- `vars/`: Definiciones de pasos personalizados
- `src/`: Código fuente en Groovy (clases de utilidad)

## Uso

En tu Jenkinsfile:

```groovy
@Library('mi-shared-library@main') _

pipeline {
    // ...
}
```
