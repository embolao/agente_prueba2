def call() {
    echo "Ejecutando tests..."

    sh '''
        . venv/bin/activate
        cd agente_prueba2
        export PYTHONPATH=$(pwd)
        pytest tests/
    '''
}





