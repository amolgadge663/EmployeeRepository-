FROM openjdk:8
LABEL authors="amol.gadage"
EXPOSE 8080
ADD target/springboot-curd-k8s.jar springboot-crud-k8s.jar

ENTRYPOINT ["java", "-jar", "springboot-crud-k8s.jar"]