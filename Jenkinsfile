@Library('mi-shared-library') _

pipeline {
    agent any

    stages {
        stage('Setup Python') {
            steps {
                script {
                    ciStages.setupPython(pythonVersion: '3.12', venvDir: "${env.WORKSPACE}/venv")
                }
            }
        }
        stage('Lint') {
            steps {
                script {
                    ciStages.lintPython(venvDir: "${env.WORKSPACE}/venv")
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    ciStages.testPython(venvDir: "${env.WORKSPACE}/venv")
                }
            }
        }
    }
}

