# Jenkins Pipeline Documentation

## Overview

This document describes the Jenkins CI/CD pipeline configuration for the `agente_prueba2` project. The pipeline is defined in the `Jenkinsfile` and uses a shared library for common functionality.

## Pipeline Structure

The pipeline is defined using a declarative syntax and consists of the following main stages:

1. **Checkout**: Fetches the source code from the repository
2. **Setup**: Configures the Python environment
3. **Test**: Runs unit tests and generates coverage reports
4. **Build**: Packages the application
5. **Deploy**: Handles deployment to different environments

## Configuration

The pipeline is configured using the following parameters in the `Jenkinsfile`:

```groovy
ciPipeline(
    pythonVersion: '3.13.3',  // Python version to use
    testDir: 'tests/',         // Directory containing test files
    coverage: true,            // Whether to generate coverage reports
    buildDir: 'dist/',         // Output directory for build artifacts
    emailCredId: 'email_recipient'  // Jenkins credentials ID for email notifications
)
```

## Pipeline Stages

### 1. Setup Python Environment
- Creates and activates a Python virtual environment
- Installs required dependencies
- Sets up the development environment

### 2. Linting and Code Analysis
- Runs Flake8 for code style checking
- Formats code with Black
- Sorts imports with isort
- Performs static type checking with mypy
- Runs security analysis with Bandit

### 3. Testing
- Executes unit tests using pytest
- Generates coverage reports
- Publishes test results and coverage reports

### 4. Build
- Builds the Python package
- Generates distribution files (source and wheel)
- Archives build artifacts

### 5. Deployment (Conditional)
- **Staging**: Automatic deployment to staging environment for main/master branches
- **Production**: Manual approval required for production deployment

## Environment Variables

The pipeline uses the following environment variables:

| Variable | Description | Default |
|----------|-------------|---------|
| `PYTHON_VERSION` | Python version to use | 3.13.3 |
| `VENV_DIR` | Virtual environment directory | `${WORKSPACE}/venv` |
| `TEST_DIR` | Directory containing tests | `tests/` |
| `BUILD_DIR` | Build output directory | `dist/` |
| `SOURCE_DIR` | Source code directory | `src/agente_prueba2` |
| `EMAIL_CREDENTIALS_ID` | Jenkins credentials ID for notifications | `email_recipient` |

## Notifications

The pipeline sends email notifications for:
- Build success/failure
- Test results
- Deployment status

## Security

- Uses Jenkins credentials store for sensitive information
- Implements proper cleanup of temporary files
- Follows principle of least privilege

## Maintenance

### Adding New Dependencies
1. Add the package to `setup.cfg` under the appropriate section
2. Update the version constraints if necessary
3. The pipeline will automatically install the new dependencies

### Updating Python Version
1. Update the `pythonVersion` parameter in the `Jenkinsfile`
2. Ensure the new version is available on the Jenkins agents

### Troubleshooting

#### Common Issues
1. **Build Fails on Dependency Installation**
   - Check internet connectivity of Jenkins agent
   - Verify package versions in `setup.cfg`

2. **Tests Failing**
   - Check test output in Jenkins console
   - Run tests locally to reproduce the issue

3. **Deployment Issues**
   - Verify credentials have proper permissions
   - Check target environment accessibility

## Best Practices

1. **Keep the Pipeline Fast**
   - Run only necessary tests in the main pipeline
   - Cache dependencies between builds

2. **Security**
   - Never hardcode credentials in the pipeline
   - Use Jenkins credentials store for all secrets

3. **Maintainability**
   - Keep the Jenkinsfile clean and well-documented
   - Use shared libraries for common functionality

## Related Documentation

- [Jenkins Pipeline Syntax](https://www.jenkins.io/doc/book/pipeline/syntax/)
- [Python Packaging User Guide](https://packaging.python.org/)
- [pytest Documentation](https://docs.pytest.org/)

## Support

For issues related to the CI/CD pipeline, please contact the DevOps team or open an issue in the repository.

---
*Last Updated: May 2025*
