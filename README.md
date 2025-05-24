# Agente Prueba 2

Un proyecto Python de ejemplo con configuración de desarrollo profesional que incluye CI/CD con Jenkins y gestión de dependencias optimizada.

## 🚀 Características

- 🐍 Python 3.13.3 con soporte para pyenv
- 🧪 Pruebas unitarias con pytest y cobertura de código
- 🛠️ Formateo automático con Black y isort
- 🔍 Linting con Flake8 y verificación de tipos con mypy
- 🔄 Hooks de pre-commit para mantener la calidad del código
- 🏗️ CI/CD con Jenkins configurado
- 📦 Gestión de dependencias con pip y setup.cfg
- 📊 Reportes de cobertura HTML integrados
- 🔧 Entornos virtuales automáticos
- 📝 Documentación con Sphinx (opcional)

## 🛠️ Configuración del Entorno

### Requisitos Previos

- Python 3.8 o superior (se recomienda 3.13.3)
- pip (última versión)
- Git
- pyenv (opcional, recomendado para gestión de versiones de Python)

### Instalación

1. Clona el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd agente_prueba2
   ```

2. Configura Python (opcional con pyenv):
   ```bash
   # Instalar la versión requerida
   pyenv install 3.13.3
   pyenv local 3.13.3
   ```

3. Crea y activa un entorno virtual:
   ```bash
   python -m venv venv
   source venv/bin/activate  # Linux/Mac
   # o
   .\venv\Scripts\activate  # Windows
   ```

4. Instala las dependencias:
   ```bash
   # Instalar solo dependencias de producción
   pip install -e .

   # Instalar dependencias de desarrollo (recomendado)
   pip install -e ".[dev,testing]"

   # O instalar manualmente desde requirements.txt
   pip install -r requirements.txt
   ```

5. Configura los hooks de pre-commit:
   ```bash
   pre-commit install
   ```

## 🏗️ Configuración de Jenkins

El proyecto incluye un `Jenkinsfile` configurado para:
- Detección automática de pyenv
- Creación de entornos virtuales aislados
- Ejecución de pruebas y generación de informes
- Publicación de cobertura de código
- Construcción de paquetes Python

### Requisitos del servidor Jenkins

- Docker o un servidor con Python 3.8+
- Plugins de Jenkins:
  - Pipeline
  - HTML Publisher
  - Cobertura
  - Warnings Next Generation

## 📦 Gestión de Dependencias

El proyecto utiliza `setup.cfg` para la gestión de dependencias principales:

```ini
[options]
install_requires =
    importlib-metadata>=4.0.0; python_version<"3.8"

[options.extras_require]
testing =
    pytest>=7.0.0
    pytest-cov>=3.0.0

dev =
    flake8>=4.0.0
    black>=22.0.0
    isort>=5.0.0
    mypy>=0.900
    build>=0.7.0
    wheel>=0.37.0
```

### Comandos útiles

```bash
# Instalar dependencias de desarrollo
pip install -e ".[dev,testing]"

# Actualizar dependencias
pip install --upgrade -r requirements.txt

# Congelar dependencias actuales
pip freeze > requirements.txt
```

## 🧪 Ejecución de Pruebas

### Pruebas Locales

```bash
# Ejecutar todas las pruebas
pytest

# Ejecutar pruebas con cobertura
pytest --cov=src/agente_prueba2

# Generar reporte HTML de cobertura
pytest --cov=src/agente_prueba2 --cov-report=html

# Ejecutar pruebas específicas
pytest tests/test_skeleton.py -v
```

### Verificación de Calidad de Código

```bash
# Formatear código con Black
black src/ tests/

# Ordenar imports
isort src/ tests/

# Verificar estilo
flake8 src/ tests/

# Verificar tipos
mypy src/ tests/

# Ejecutar todos los checks de pre-commit
pre-commit run --all-files
```

## 📊 Pipeline de CI/CD

El pipeline de Jenkins incluye las siguientes etapas:

1. **Checkout**: Obtiene el código del repositorio
2. **Set Up Python**: Configura el entorno de Python
3. **Lint**: Verifica el estilo y calidad del código
4. **Test**: Ejecuta las pruebas unitarias
5. **Publish Coverage**: Publica el informe de cobertura
6. **Build**: Construye el paquete Python

### Ejecución Manual

```bash
# Instalar dependencias de desarrollo
pip install -e ".[dev,testing]"

# Ejecutar el pipeline localmente (requiere Jenkinsfile-runner)
# jenkinsfile-runner -f ./Jenkinsfile
```

## 🚀 Despliegue

### Construir el paquete

```bash
# Instalar herramientas de construcción
pip install build

# Construir paquete fuente y rueda
python -m build

# Los paquetes se generan en dist/
```

### Instalar localmente

```bash
pip install -e .  # Modo desarrollo
# o
pip install .     # Instalación normal
```

## 🧹 Formateo y Linting

```bash
# Formatear código automáticamente
black src/ tests/

# Ordenar imports
isort src/ tests/

# Verificar estilo
flake8 src/ tests/

# Verificar tipos
mypy src/ tests/
```

## 👥 Contribuyendo

Las contribuciones son bienvenidas. Por favor, sigue estos pasos:

1. Haz un Fork del proyecto
2. Crea una rama para tu característica (`git checkout -b feature/AmazingFeature`)
3. Haz commit de tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Haz push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Distribuido bajo la Licencia MIT. Ver `LICENSE` para más información.

## 👤 Autor

**embolao**

## 📝 Changelog

Los cambios notables se documentan en [CHANGELOG.md](CHANGELOG.md).

## 📌 Versión

1.0.0

---

📅 Última actualización: Mayo 2024

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Python Version](https://img.shields.io/badge/python-3.8%20%7C%203.9%20%7C%203.10%20%7C%203.11%20%7C%203.12%20%7C%203.13-blue)](https://www.python.org/)
[![Code style: black](https://img.shields.io/badge/code%20style-black-000000.svg)](https://github.com/psf/black)
