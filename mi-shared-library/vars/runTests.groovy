def call() {
    echo "Ejecutando tests..."

    sh '''
        # Configurar entorno
        export PYTHONPATH=$(pwd)  # Apunta al directorio raíz (donde está venv/)
        source venv/bin/activate  # Activa el entorno virtual
        
        # Ejecutar pytest desde la raíz, apuntando a la carpeta tests
        python -m pytest agente_prueba2/tests -v
        
        deactivate  # Desactiva el entorno (opcional)
    '''
}







