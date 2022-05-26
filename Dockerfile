FROM openjdk:17
COPY ./build/libs/ProdutoAPI-0.0.1-SNAPSHOT.jar ProdutoAPI-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "ProdutoAPI-0.0.1-SNAPSHOT.jar"]