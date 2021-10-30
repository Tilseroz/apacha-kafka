**Apache Kafka společně se Spring Cloud Stream**

Projekt je jednoduchá demonstrace jak ve Spring bootu pomocí Spring Cloud Stream implementovat message brokera Apache Kafku.

Co je Apache Kafka ve zkratce?
- message broker
- Apache Kafka obsahuje Cluster, v něm má několik brokerů, které manažuje Zookeper. V každém brokeru může být více topiců a v každém topicu je několik partitions
- jedná se o publish-subscribe messaging system
- využijeme ho pro komunikaci např. mezi mikroservisy

Popis projektu:

Máme dvě mikroservisy:
- user-service - vystavený rest pro tvoření uživatele
- ticket-service - listener, při vytvoření uživatele zapíše do logu, že byl vytvořen

Projekt slouží pouze pro demonstraci poslání zprávy mezi dvěmi na sobě nezávislými mikroservisy. Neřeší ukládání do DB, authorizaci RESTu apod.

//TODO
- v rámci projektu demonstrovat jak implementovat to stejné dle Functional Programming Model
- zde už nepoužíváme INPUT, OUTPU a BINDING anotace. Jsou nahrazeny java.util.function.[Supplier/Function/Consumer].
- dále demonstrovat RabbitMQ a ukázat si rozdíly