def call() {
    echo "Ejecutando tests..."

    sh '''
    . venv/bin/activate
    cd agente_prueba2/tests
    export PYTHONPATH=$(pwd)
    pytest
'''

}






