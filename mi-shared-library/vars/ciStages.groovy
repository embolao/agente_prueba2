// vars/ciStages.groovy

def setupPython(Map args = [:]) {
    echo "Setting up Python ${args.pythonVersion}, venv at ${args.venvDir}"
    sh """
        python${args.pythonVersion} -m venv ${args.venvDir}
        source ${args.venvDir}/bin/activate
        pip install --upgrade pip
        pip install -r requirements.txt
    """
}

def lintPython(Map args = [:]) {
    echo "Running lint"
    sh """
        source ${args.venvDir}/bin/activate
        flake8 .
    """
}

def testPython(Map args = [:]) {
    echo "Running tests"
    sh """
        source ${args.venvDir}/bin/activate
        pytest
    """
}

return this

