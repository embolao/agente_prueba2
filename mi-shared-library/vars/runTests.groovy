def call() {
    echo "Ejecutando tests..."

    sh '''
        export PYTHONPATH=$(pwd)/src
        venv/bin/python3 -m pytest src/agente_prueba2/tests
    '''
}








