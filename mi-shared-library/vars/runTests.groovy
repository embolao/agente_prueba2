def call() {
    echo "Ejecutando tests..."
    sh '''
        #!/bin/bash
        . venv/bin/activate
        export PYTHONPATH=$(pwd)/agente_prueba2
        pip install pytest
        pytest agente_prueba2/tests/
    '''
}
