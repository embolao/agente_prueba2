def call() {
    echo "Ejecutando tests..."

    sh '''
        . venv/bin/activate
        export PYTHONPATH=$(pwd)
        pytest tests/
    '''
}




