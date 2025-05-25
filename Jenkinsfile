@Library('mi-shared-library@master') _
import ciStages

pipeline {
    agent any

    environment {
        VENV_DIR = "${env.WORKSPACE}/venv"
    }

    stages {
        stage('Setup Python') {
            steps {
                script {
                    ciStages.setupPython(pythonVersion: '3.13.3', venvDir: env.VENV_DIR)
                }
            }
        }

        stage('Lint') {
            steps {
                script {
                    ciStages.lintPython(venvDir: env.VENV_DIR)
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    ciStages.testPython(venvDir: env.VENV_DIR)
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline finalizado'
        }
    }
}


