# TickUp-Notify

> Service backend développé avec Java et Spring Boot permettant la gestion et l'envoi des notifications email au sein de l'écosystème TickUp.

---

# Présentation

**TickUp-Notify** est un service backend responsable de la gestion des notifications de la plateforme **TickUp**.

Il permet aux différents services de l'écosystème d'envoyer des communications aux utilisateurs par email, notamment lors des actions importantes liées à leurs comptes et à leurs tickets.

Le service est développé avec **Java** et **Spring Boot** suivant une architecture **MVC (Model - View - Controller)** afin de structurer clairement les responsabilités entre les différentes couches applicatives.

---

# Responsabilités

TickUp-Notify prend en charge :

* L'envoi d'emails transactionnels
* La gestion des modèles d'emails
* Les notifications liées aux comptes utilisateurs
* Les confirmations d'inscription
* Les notifications d'achat de tickets
* Les messages de récupération de compte
* Les communications liées aux événements
* L'exposition d'API REST pour les autres services TickUp

---

# Cas d'utilisation

Exemples de scénarios :

### Création d'un compte utilisateur

```text
TickUp-Subs
      │
      ▼
Demande d'envoi d'email
      │
      ▼
TickUp-Notify
      │
      ▼
Email de confirmation envoyé
```

### Achat d'un ticket

```text
TickUp App
      │
      ▼
Confirmation d'achat
      │
      ▼
TickUp-Notify
      │
      ▼
Envoi du ticket numérique par email
```

---

# Stack technique

| Élément             | Technologie                     |
| ------------------- | ------------------------------- |
| Langage             | Java                            |
| Framework           | Spring Boot 3.x                 |
| Architecture        | MVC (Model - View - Controller) |
| Build               | Maven                           |
| API                 | REST API                        |
| Envoi d'emails      | SMTP / JavaMailSender           |
| Base de données     | PostgreSQL *(ou votre SGBD)*    |
| ORM                 | Spring Data JPA / Hibernate     |
| Documentation API   | OpenAPI / Swagger               |
| Gestion de versions | Git                             |

---

# Prérequis

Avant de lancer le projet, assurez-vous de disposer des éléments suivants :

* JDK 17 ou supérieur
* Maven 3.9+
* Un serveur SMTP configuré
* IntelliJ IDEA ou Visual Studio Code
* Git

---


# Exemple de flux de notification

```text
Application cliente
        │
        ▼
Service backend TickUp
        │
        ▼
TickUp-Notify API
        │
        ▼
Service Email
        │
        ▼
Utilisateur final
```



# Intégration dans l'écosystème TickUp

```text
                    TickUp Platform
                           │
        ┌──────────────────┼──────────────────┐
        │                  │                  │
        ▼                  ▼                  ▼
 TickUp App          TickUp-Subs       TickUp-Scan
        │                  │
        └──────────┬───────┘
                   ▼
            TickUp-Notify
          Service Notifications
```

**TickUp-Notify** intervient comme un service indépendant chargé de centraliser les communications sortantes de la plateforme.

---

# Objectif

L'objectif de **TickUp-Notify** est de fournir un service fiable et centralisé permettant l'envoi automatisé des notifications aux utilisateurs tout en garantissant une architecture simple, maintenable et facilement extensible.

---

# Auteur

Projet développé par Samuel Kébé dans le cadre de la plateforme **TickUp**.
