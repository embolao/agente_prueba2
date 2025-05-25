@Library('mi-shared-library@master') _  // Usando la versión master de la biblioteca

pipeline {
    agent any
    stages {
        stage('Run CI Python') {
            steps {
                script {
                    ciStages()  // Llamando a la función principal del pipeline
                }
            }
        }
    }
}
