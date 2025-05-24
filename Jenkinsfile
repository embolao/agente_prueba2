pipeline {
    agent any

    environment {
        PYTHON_VERSION = '3.13.3'
        VENV_DIR = "${env.WORKSPACE}/venv"
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
                    def usePyenv = sh(script: 'command -v pyenv >/dev/null 2>&1', returnStatus: true) == 0

                    if (usePyenv) {
                        echo 'Usando pyenv para configurar Python...'
                        sh """
                            export PYENV_ROOT="\$HOME/.pyenv"
                            export PATH="\$PYENV_ROOT/bin:\$PATH"
                            eval "\$(pyenv init --path)"
                            eval "\$(pyenv init -)"

                            if ! pyenv versions --bare | grep -q "^${PYTHON_VERSION}\$"; then
                                pyenv install -s ${PYTHON_VERSION}
                            fi

                            pyenv global ${PYTHON_VERSION}
                            python -m venv ${VENV_DIR}
                        """
                    } else {
                        echo 'pyenv no encontrado, usando Python del sistema...'
                        sh "python3 -m venv ${VENV_DIR}"
                    }

                    def pythonExe = "${VENV_DIR}/bin/python"
                    def pipExe = "${VENV_DIR}/bin/pip"

                    sh """
                        ${pipExe} install --upgrade pip wheel setuptools
                        ${pipExe} install -e .[testing]
                    """
                }
            }
        }

        stage('Lint') {
            steps {
                script {
                    def pythonExe = "${env.WORKSPACE}/venv/bin/python"
                    def pipExe = "${env.WORKSPACE}/venv/bin/pip"
                    sh "${pipExe} install flake8 black isort mypy"
                    sh "${pythonExe} -m flake8 src/ tests/"
                    sh "${pythonExe} -m black src/ tests/"
                    sh "${pythonExe} -m isort src/ tests/"     // Aquí se corrige para que formatee y no falle
                    sh "${pythonExe} -m mypy src/ tests/"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    def pythonExe = "${env.WORKSPACE}/venv/bin/python"
                    def pipExe = "${env.WORKSPACE}/venv/bin/pip"
                    sh "${pipExe} install pytest pytest-cov"
                    sh "${pythonExe} -m pytest --cov=src/agente_prueba2 --cov-report=xml tests/"
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
                    def pythonExe = "${env.WORKSPACE}/venv/bin/python"
                    def pipExe = "${env.WORKSPACE}/venv/bin/pip"
                    sh "${pipExe} install build"
                    sh "${pythonExe} -m build"
                    archiveArtifacts artifacts: 'dist/*', fingerprint: true
                }
            }
        }
    }

    post {
        always {
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
