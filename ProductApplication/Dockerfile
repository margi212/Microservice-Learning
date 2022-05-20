FROM eclipse-temurin:11-jre-alpine 
ADD target/product-0.0.1-SNAPSHOT.jar product.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar" , "product.jar"]
