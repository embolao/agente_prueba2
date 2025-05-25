def call() {
    echo "Ejecutando tests..."

    sh '''
        # Configurar entorno
        export PYTHONPATH=$(pwd)
        . venv/bin/activate  # Usar punto en lugar de source
        
        # Ver estructura de archivos (debug)
        echo "Estructura del directorio:"
        ls -la agente_prueba2/
        
        # Ejecutar pytest con verbosidad
        python -m pytest agente_prueba2/tests -v
        
        # Opcional: desactivar entorno
        deactivate
    '''
}







