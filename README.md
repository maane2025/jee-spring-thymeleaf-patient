{{ ... }}

## Rapport du projet

### Présentation
Cette application web permet la gestion des patients en utilisant les technologies Spring Boot 3.2, Spring MVC, Thymeleaf et Spring Data JPA. Elle a été réalisée par **Maane Aimane** .

### Fonctionnalités principales
- **Affichage** : Liste paginée des patients.
- **Recherche** : Filtrage des patients par nom.
- **Ajout/Modification** : Formulaires avec validation (nom, date de naissance, score).
- **Suppression** : Suppression sécurisée avec confirmation.
- **Sécurité** : Authentification InMemory (Spring Security), gestion des rôles (USER, ADMIN).
- **Design** : Interface moderne avec Bootstrap.
- **Base de données** : Utilisation de H2 en mémoire (modifiable pour MySQL/PostgreSQL).

### Architecture technique
- **Backend** : Spring Boot, Spring Data JPA, Spring Security
- **Frontend** : Thymeleaf, Bootstrap
- **Structure** :
  - `entities` : Modèle Patient
  - `repositories` : Accès aux données
  - `web` : Contrôleurs MVC
  - `security` : Configuration sécurité
  - `templates` : Vues HTML

### Sécurité
- Authentification InMemory (3 comptes par défaut)
- Protection des URLs sensibles (`/deletePatient`, `/admin`)
- Prêt pour extension JDBC ou UserDetailsService

### Lancement
- `mvn spring-boot:run`
- Accès à l’application : [http://localhost:8080](http://localhost:8080)
- Console H2 : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### Améliorations possibles
- Ajout de la sécurité JDBC ou UserDetailsService
- Gestion avancée des rôles
- Internationalisation (i18n)
- Tests unitaires et d’intégration

---

