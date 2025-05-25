def setupPython(Map args = [:]) {
    def pythonVersion = args.pythonVersion ?: '3.12.3'
    def venvDir = args.venvDir ?: './venv'

    echo "Instalando Python versión ${pythonVersion} en ${venvDir}"

    sh """
        python3 -m venv ${venvDir}
    """
}

def lintPython(Map args = [:]) {
    def venvDir = args.venvDir ?: './venv'

    echo "Ejecutando lint en el entorno virtual: ${venvDir}"

    sh """
        . ${venvDir}/bin/activate
        pip install --quiet flake8
        flake8 . --exclude=${venvDir}
    """
}

def testPython(Map args = [:]) {
    def venvDir = args.venvDir ?: './venv'

    echo "Ejecutando pruebas en el entorno virtual: ${venvDir}"

    sh """
        . ${venvDir}/bin/activate
        pip install --quiet -r requirements.txt
        pytest
    """
}

return this
