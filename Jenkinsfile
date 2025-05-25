@Library('mi-shared-library') _

pipeline {
    agent any

    environment {
        VENV_DIR = "${env.WORKSPACE}/venv"
        EMAIL_RECIPIENT = credentials('email_recipient') // ID de tu credencial en Jenkins
    }

    stages {
        stage('Setup Python') {
            steps {
                ciStages.setupPython(pythonVersion: '3.13.3', venvDir: "${VENV_DIR}")
            }
        }

        stage('Lint') {
            steps {
                ciStages.lintPython(venvDir: "${VENV_DIR}")
            }
        }

        stage('Test') {
            steps {
                ciStages.testPython(venvDir: "${VENV_DIR}")
            }
        }

        stage('Coverage Report') {
            steps {
                ciStages.publishCoverage()
            }
        }

        stage('Build') {
            steps {
                ciStages.buildPython(venvDir: "${VENV_DIR}")
            }
        }
    }

    post {
        always {
            cleanWorkspace(
                cleanWhenAborted: true,
                cleanWhenFailure: true,
                cleanWhenNotBuilt: true,
                cleanWhenUnstable: true,
                deleteDirs: false
            )
            emailext (
                to: "${EMAIL_RECIPIENT}",
                subject: "Notificación pipeline ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                mimeType: 'text/html',
                body: '${JELLY_SCRIPT,template="NotificacionDeBuild1"}'
            )
        }
        success {
            echo 'Pipeline ejecutado exitosamente!'
        }
        failure {
            echo 'El pipeline ha fallado. Por favor revisa los logs.'
=======
            ciStages.cleanWorkspace()
            ciStages.sendEmail(credentialId: 'email_recipient')
>>>>>>> 44e9025 (Actualización completa del pipeline de Jenkins con funciones mejoradas)
        }
    }
}
