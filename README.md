# Tickup Notify - Service de Notification Email

Service microservice pour l'envoi d'emails via API REST.

## Fonctionnalités

- Envoi d'emails avec support HTML
- Support des pièces jointes en base64
- Multi-destinataires
- Health checks
- Dockerisé

## API Endpoint

### POST /api/v1/email/send

**Corps de la requête:**
```json
{
  "object": "Sujet de l'email",
  "content": "Contenu HTML ou texte",
  "recipients": ["email1@example.com", "email2@example.com"],
  "attachments": [
    {
      "fileName": "document.pdf",
      "base64": "JVBERi0xLjQK..."
    }
  ]
}
```

**Réponse:**
```json
{
  "message": "Email envoyé avec succès",
  "status": 200,
  "body": true,
  "timestamp": "2026-03-15T14:00:00.000Z"
}
```

## Docker

### Construction et démarrage

```bash
# Construire l'image
docker build -t tickup-notify .

# Démarrer avec docker-compose
docker-compose up -d

# Vérifier les logs
docker-compose logs -f tickup-notify
```

### Configuration

Les variables d'environnement peuvent être configurées dans `docker-compose.yml`:

- `SPRING_PROFILES_ACTIVE`: Profil Spring (prod/dev)
- `JAVA_OPTS`: Options JVM
- `SPRING_MAIL_*`: Configuration email

## Développement

### Prérequis

- Java 17+
- Maven 3.6+
- Docker (optionnel)

### Lancement local

```bash
# Compiler
mvn clean package

# Démarrer
mvn spring-boot:run
```

### Tests

```bash
# Lancer les tests
mvn test

# Test avec coverage
mvn clean test jacoco:report
```

## Configuration Email

Configurer les propriétés dans `application-prod.properties`:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=votre-email@gmail.com
spring.mail.password=votre-mot-de passe-app
```

## Health Check

L'application expose un endpoint de health check:

```
GET http://localhost:9001/actuator/health
```

## Monitoring

- Logs: `logs/tickup-notify.log`
- Health checks: `/actuator/health`
- Info: `/actuator/info`

## Architecture

```
├── src/main/java/com/tickupnotify/
│   ├── controller/     # Controllers REST
│   ├── services/       # Logique métier
│   ├── models/        # Modèles de données
│   └── apiException/  # Gestion des réponses API
├── src/main/resources/
│   ├── application.properties
│   └── application-prod.properties
├── Dockerfile
├── docker-compose.yml
└── .dockerignore
```
