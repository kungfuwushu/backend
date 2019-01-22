# Wushu Nantes-Cholet-Angers - Backend & Services project
This project aims at providing the backend services to be used to support a sports club practicing Wushu

## Default testing data
Testing data is declared in `import.sql`.

To load data on first start or to reset data with defaults, change `spring.jpa.hibernate.ddl-auto` property value (in `application.properties`) with either `create` or `create-drop`.