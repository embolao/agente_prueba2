def call() {
    sh '''
        #!/bin/bash
        . venv/bin/activate
        pip install pytest
        pytest tests/
    '''
}
