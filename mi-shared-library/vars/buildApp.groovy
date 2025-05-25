def call() {
    sh '''
        #!/bin/bash
        python3 -m venv venv
        . venv/bin/activate
        pip install --upgrade pip
        if [ -f requirements.txt ]; then
            pip install -r requirements.txt
        fi
    '''
}
