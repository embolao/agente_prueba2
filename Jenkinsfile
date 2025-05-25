@Library('mi-shared-library@master') _

pipeline {
    agent any

    stages {
        stage('Setup Python') {
            steps {
                script {
                    ciStages.setupPython(pythonVersion: '3.13.3', venvDir: "${env.WORKSPACE}/venv")
                }
            }
        }
    }
}
