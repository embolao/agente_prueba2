def call() {
    sh '''
        #!/bin/bash
        . venv/bin/activate
        pip install flake8
        flake8 . --exclude=venv
    '''
}
