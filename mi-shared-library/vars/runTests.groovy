def call() {
    echo "Ejecutando tests..."

    sh '''
        # Activar entorno virtual de forma segura
        export PYTHONPATH=$(pwd)/agente_prueba2
        venv/bin/python3 -m pytest agente_prueba2/tests
    '''
}







