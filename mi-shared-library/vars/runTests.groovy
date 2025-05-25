def call() {
    echo "Ejecutando pruebas con pytest..."
    sh '''
        source venv/bin/activate
        pytest tests/
    '''
}
