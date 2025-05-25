def call(String message) {
    echo "Notificación: ${message}"
    // Para enviar a Slack real, usar plugin de Slack o curl + webhook
    // Ejemplo:
    // sh "curl -X POST -H 'Content-type: application/json' --data '{\"text\":\"${message}\"}' https://hooks.slack.com/services/XXX/YYY/ZZZ"
}
