def call() {
    stage('Checkout') {
        checkout scm
    }

    stage('Setup Virtualenv') {
        buildApp()
    }

    stage('Lint') {
        lintCode()
    }

    stage('Test') {
        runTests()
    }

    stage('Deploy') {
        deployApp()
    }

    stage('Notify') {
        notifySlack("✅ Pipeline Python completada con éxito.")
    }
}
