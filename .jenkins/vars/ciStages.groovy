def setupPython(Map params = [:]) {
    def pythonVersion = params.get('pythonVersion', '3.13.3')
    def venvDir = params.get('venvDir', "${env.WORKSPACE}/venv")
    try {
        echo "Configurando Python ${pythonVersion} en ${venvDir}"
        sh """
            python${pythonVersion} -m venv ${venvDir}
            ${venvDir}/bin/pip install --upgrade pip setuptools wheel
            ${venvDir}/bin/pip install -r requirements.txt
        """
    } catch (Exception e) {
        error("Error en setupPython: ${e.message}")
    }
}

def lintPython(Map params = [:]) {
    def venvDir = params.get('venvDir', "${env.WORKSPACE}/venv")
    try {
        echo "Ejecutando lint con flake8 en entorno virtual: ${venvDir}"
        def status = sh(script: "${venvDir}/bin/flake8 .", returnStatus: true)
        def output = sh(script: "${venvDir}/bin/flake8 .", returnStdout: true).trim()
        echo output
        if (status != 0) {
            error("Errores detectados por flake8. Código de salida: ${status}")
        } else {
            echo "Lint pasó sin errores."
        }
    } catch (Exception e) {
        error("Error ejecutando lintPython: ${e.message}")
    }
}

def testPython(Map params = [:]) {
    def venvDir = params.get('venvDir', "${env.WORKSPACE}/venv")
    try {
        echo "Ejecutando tests con pytest en entorno virtual: ${venvDir}"
        sh """
            ${venvDir}/bin/pytest --maxfail=1 --disable-warnings -q
        """
    } catch (Exception e) {
        error("Error ejecutando testPython: ${e.message}")
    }
}

def publishCoverage() {
    try {
        echo "Publicando reporte de cobertura"
        // Asume que ya se genera .coverage, modifica si usas otra herramienta
        sh "coverage xml"
        publishCoverage adapters: [coberturaAdapter('coverage.xml')]
    } catch (Exception e) {
        error("Error publicando cobertura: ${e.message}")
    }
}

def buildPython(Map params = [:]) {
    def venvDir = params.get('venvDir', "${env.WORKSPACE}/venv")
    try {
        echo "Construyendo paquete Python"
        sh """
            ${venvDir}/bin/python setup.py sdist bdist_wheel
        """
    } catch (Exception e) {
        error("Error en buildPython: ${e.message}")
    }
}

def cleanWorkspace() {
    try {
        echo "Limpiando workspace"
        deleteDir()
    } catch (Exception e) {
        echo "Error limpiando workspace: ${e.message}"
    }
}

def sendEmail(Map params = [:]) {
    def credentialId = params.get('credentialId', '')
    try {
        echo "Enviando email a destinatarios configurados"
        emailext (
            subject: "Jenkins Build Notification - ${currentBuild.fullDisplayName}",
            body: "Revisa los resultados del build: ${env.BUILD_URL}",
            recipientProviders: [[$class: 'DevelopersRecipientProvider']],
            to: credentialId
        )
    } catch (Exception e) {
        echo "Error enviando email: ${e.message}"
    }
}
