FROM eclipse-temurin:11-jre-alpine
ADD target/convert-currency-0.0.1-SNAPSHOT.jar cc.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar" , "cc.jar"]