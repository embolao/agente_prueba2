def setupPython(Map args = [:]) {
    def pythonVersion = args.pythonVersion ?: '3.10.0'
    def venvDir = args.venvDir ?: './venv'

    echo "Instalando Python versión ${pythonVersion} en ${venvDir}"

    sh """
        python3 -m venv ${venvDir}
        . ${venvDir}/bin/activate
        python --version
    """
}

def lintPython(Map args = [:]) {
    def venvDir = args.venvDir ?: './venv'

    echo "Ejecutando lint en el entorno virtual: ${venvDir}"

    sh """
        . ${venvDir}/bin/activate
        pip install flake8 > /dev/null
        flake8 .
    """
}

def testPython(Map args = [:]) {
    def venvDir = args.venvDir ?: './venv'

    echo "Ejecutando pruebas en el entorno virtual: ${venvDir}"

    sh """
        . ${venvDir}/bin/activate
        pip install pytest > /dev/null
        pytest tests/
    """
}
