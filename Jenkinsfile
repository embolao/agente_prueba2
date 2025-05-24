pipeline {
    agent any

    environment {
        // Configura el entorno de Python
        PYTHON_VERSION = '3.8'
        VENV_DIR = "${env.WORKSPACE}/venv"
    }

    stages {
        stage('Checkout') {
            steps {
                // Obtener el código del repositorio
                checkout scm
            }
        }

        stage('Set Up Python') {
            steps {
                script {
                    // Crear y activar entorno virtual
                    sh "python -m venv ${VENV_DIR}"
                    sh "${VENV_DIR}/bin/pip install --upgrade pip"
                    sh "${VENV_DIR}/bin/pip install -e .[testing]"
                }
            }
        }

        stage('Lint') {
            steps {
                script {
                    // Ejecutar linters
                    sh "${VENV_DIR}/bin/flake8 src/ tests/"
                    sh "${VENV_DIR}/bin/black --check src/ tests/"
                    sh "${VENV_DIR}/bin/isort --check-only src/ tests/"
                    sh "${VENV_DIR}/bin/mypy src/ tests/"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Ejecutar pruebas con cobertura
                    sh "${VENV_DIR}/bin/pytest --cov=src/agente_prueba2 --cov-report=xml tests/"
                }
            }
            post {
                always {
                    // Publicar reporte de cobertura
                    publishCoverage adapters: [coberturaAdapter('coverage.xml')]
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    // Construir el paquete
                    sh "${VENV_DIR}/bin/python setup.py sdist bdist_wheel"

                    // Archivar los artefactos
                    archiveArtifacts artifacts: 'dist/*', fingerprint: true
                }
            }
        }
    }

    post {
        always {
            // Limpiar el espacio de trabajo
            cleanWs()
        }
        success {
            echo 'Pipeline ejecutado exitosamente!'
        }
        failure {
            echo 'El pipeline ha fallado. Por favor revisa los logs.'
        }
    }
}
