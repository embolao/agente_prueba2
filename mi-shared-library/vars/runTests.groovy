def call() {
    echo "Ejecutando tests..."
    dir('agente_prueba2') {
        sh '''
            #!/bin/bash
            set -e
            . ../venv/bin/activate
            export PYTHONPATH=$(pwd)
            pytest tests/
        '''
    }
}
