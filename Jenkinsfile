@Library('mi-shared-library@master') _

pipeline {
    agent any

    stages {
        stage('Setup Python') {
            steps {
                script {
                    setupPython(pythonVersion: '3.12.3', venvDir: "${env.WORKSPACE}/venv")
                }
            }
        }

        stage('Lint') {
            steps {
                script {
                    lintPython(venvDir: "${env.WORKSPACE}/venv")
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    testPython(venvDir: "${env.WORKSPACE}/venv")
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
