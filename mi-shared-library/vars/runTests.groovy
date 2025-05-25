def call() {
    echo "Ejecutando tests..."

    sh '''
        . venv/bin/activate
        export PYTHONPATH=$(pwd)/agente_prueba2
        pytest agente_prueba2/tests/
    '''
}




