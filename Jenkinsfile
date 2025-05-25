@Library('mi-shared-library') _

pipeline {
  agent any
  stages {
    stage('Test Lib') {
      steps {
        script {
          ciStages.hello()
        }
      }
    }
  }
}




