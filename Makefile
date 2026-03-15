# Makefile pour Tickup Notify

.PHONY: help build run stop clean logs test

help: ## Affiche cette aide
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

build: ## Construit l'image Docker
	docker-compose build

run: ## Démarre l'application avec docker-compose
	docker-compose up -d

stop: ## Arrête l'application
	docker-compose down

clean: ## Nettoie les conteneurs et images
	docker-compose down -v --rmi all

logs: ## Affiche les logs de l'application
	docker-compose logs -f tickup-notify

test: ## Lance les tests unitaires
	mvn test

package: ## Compile et package l'application
	mvn clean package -DskipTests

dev: ## Démarre en mode développement
	mvn spring-boot:run

health: ## Vérifie le health check
	curl -f http://localhost:9001/actuator/health

all: clean build run ## Nettoie, construit et démarre
