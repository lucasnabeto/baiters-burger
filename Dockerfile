FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# a esteira já cria o jar dentro da pasta target na etapa de build.
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]