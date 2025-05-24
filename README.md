# Agente Prueba 2

Un proyecto Python de ejemplo con configuración de desarrollo profesional.

## 🚀 Características

- Estructura de proyecto Python estándar
- Pruebas unitarias con pytest
- Cobertura de código con pytest-cov
- Formateo de código con Black
- Ordenamiento de imports con isort
- Linting con Flake8
- Verificación de tipos con mypy
- Hooks de pre-commit para mantener la calidad del código
- Configuración para documentación con Sphinx

## 🛠️ Configuración del Entorno

1. Clona el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd agente_prueba2
   ```

2. Crea y activa un entorno virtual (recomendado):
   ```bash
   python -m venv venv
   source venv/bin/activate  # En Linux/Mac
   # o
   .\venv\Scripts\activate  # En Windows
   ```

3. Instala las dependencias de desarrollo:
   ```bash
   pip install -e ".[dev]"
   ```

4. Instala los hooks de pre-commit:
   ```bash
   pre-commit install
   ```

## 🧪 Ejecutar Pruebas

```bash
# Ejecutar todas las pruebas
pytest

# Ejecutar pruebas con cobertura
pytest --cov=src/agente_prueba2

# Ejecutar pruebas con cobertura y reporte HTML
pytest --cov=src/agente_prueba2 --cov-report=html
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

## 👤 Autor

**embolao**

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor, lee la [guía de contribución](CONTRIBUTING.md) para más detalles.

## 📝 Changelog

Consulta el [CHANGELOG.md](CHANGELOG.md) para ver los cambios recientes en el proyecto.

---

📅 Última actualización: Mayo 2024
