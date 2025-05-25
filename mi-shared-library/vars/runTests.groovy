def call() {
    echo "Ejecutando tests..."

    dir('agente_prueba2/agente_prueba2') {
        sh '''
            . ../venv/bin/activate
            export PYTHONPATH=$(pwd)
            pytest tests/
        '''
    }
}


