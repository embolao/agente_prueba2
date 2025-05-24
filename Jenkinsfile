pipeline {
    agent any

    environment {
        PYTHON_VERSION = '3.13.3'
        VENV_DIR = "${env.WORKSPACE}/venv"
        PYENV_ROOT = "${env.HOME}/.pyenv"
        PATH = "${env.HOME}/.pyenv/shims:${env.HOME}/.pyenv/bin:${env.PATH}"
        PYTHON = "${VENV_DIR}/bin/python"
        PIP = "${VENV_DIR}/bin/pip"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Set Up Python') {
            steps {
                script {
                    // Configurar pyenv y crear entorno virtual
                    sh """
                        # Inicializar pyenv
                        export PYENV_ROOT="${env.HOME}/.pyenv"
                        export PATH="\$PYENV_ROOT/shims:\$PYENV_ROOT/bin:\$PATH"
                        eval "\$(pyenv init -)"
                        
                        # Instalar Python si no está instalado
                        pyenv install -s ${PYTHON_VERSION}
                        pyenv global ${PYTHON_VERSION}
                        
                        # Crear y configurar entorno virtual
                        python -m venv ${VENV_DIR}
                        ${PIP} install --upgrade pip wheel setuptools
                        ${PIP} install -e .[testing]
                    """.stripIndent()
                }
            }
        }

        stage('Lint') {
            steps {
                script {
                    sh "${PIP} install flake8 black isort mypy"
                    sh "${PYTHON} -m flake8 src/ tests/"
                    sh "${PYTHON} -m black --check src/ tests/"
                    sh "${PYTHON} -m isort --check-only src/ tests/"
                    sh "${PYTHON} -m mypy src/ tests/"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh "${PIP} install pytest pytest-cov"
                    sh "${PYTHON} -m pytest --cov=src/agente_prueba2 --cov-report=xml tests/"
                }
            }
            post {
                always {
                    publishCoverage adapters: [coberturaAdapter('coverage.xml')]
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    sh "${PIP} install build"
                    sh "${PYTHON} -m build"
                    archiveArtifacts artifacts: 'dist/*', fingerprint: true
                }
            }
        }
    }

    post {
        always {
            // Limpiar solo archivos temporales, no el entorno virtual
            cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, 
                   cleanWhenNotBuilt: true, cleanWhenUnstable: true, 
                   deleteDirs: false)
        }
        success {
            echo 'Pipeline ejecutado exitosamente!'
        }
        failure {
            echo 'El pipeline ha fallado. Por favor revisa los logs.'
        }
    }
}
