FROM eclipse-temurin:11-jre-alpine
ADD target/currency-0.0.1-SNAPSHOT.jar currency.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar" , "currency.jar"]