@Library('mi-shared-library') _
pipeline {
    agent any
    stages {
        stage('Setup Python') {
            steps {
                script {
                    ciStages.setupPython(pythonVersion: '3.9', venvDir: '.venv')
                }
            }
        }
        stage('Lint') {
            steps {
                script {
                    ciStages.lintPython(venvDir: '.venv')
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    ciStages.testPython(venvDir: '.venv')
                }
            }
        }
    }
}


