def call() {
    echo "Creando entorno virtual y preparando dependencias..."
    sh '''
        python3 -m venv venv
        source venv/bin/activate
        pip install --upgrade pip
        pip install -r requirements.txt
    '''
}
