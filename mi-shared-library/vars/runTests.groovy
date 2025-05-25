dir('agente_prueba2') {
    sh '''
        . ../venv/bin/activate
        export PYTHONPATH=$(pwd)/agente_prueba2
        pytest agente_prueba2/tests/
    '''
}

