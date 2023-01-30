#Download base maven image
FROM maven:3.8.5-openjdk-17-slim

#Set project deployment directory
WORKDIR /order-fullfilment-system

#Copy project pom file to working directory
COPY ./pom.xml .

#Copy all required files and folders to 'build' directory
COPY ./src ./src

#Build application binary
RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "./target/order-fullfilment-system.jar"]