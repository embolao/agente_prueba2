def runTests() {
    echo "Ejecutando tests..."
    sh '''
        #!/bin/bash
        source venv/bin/activate
        export PYTHONPATH=$(pwd)/agente_prueba2
        pip install pytest
        pytest agente_prueba2/tests/
    '''
}
