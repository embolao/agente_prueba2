@Library('mi-shared-library@master') _

pipeline {
    agent any

    environment {
        VENV_DIR = "${env.WORKSPACE}/venv"
    }

    stages {
        stage('Setup Python') {
            steps {
                script {
                    ciStages.setupPython(pythonVersion: '3.13.3', venvDir: "${VENV_DIR}")
                }
            }
        }

        stage('Lint') {
            steps {
                script {
                    ciStages.lintPython(venvDir: "${VENV_DIR}")
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline finalizado"
        }
    }
}

