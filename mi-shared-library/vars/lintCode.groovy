def call() {
    echo "Ejecutando linter (flake8)..."
    sh '''
        source venv/bin/activate
        flake8 .
    '''
}
