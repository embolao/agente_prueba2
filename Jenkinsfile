@Library('mi-shared-library@master') _

pipeline {
    agent any

    stages {
        stage('Test library') {
            steps {
                script {
                    ciStages.hello()
                }
            }
        }
    }
}
