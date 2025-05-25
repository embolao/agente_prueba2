def call() {
    sh '''
        export PYTHONPATH=$(pwd)/agente_prueba2
        . venv/bin/activate
        python -m pytest agente_prueba2/agente_prueba2/tests -v
    '''
}







