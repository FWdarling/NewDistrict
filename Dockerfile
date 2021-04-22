#FROM openjdk:8-jdk-alpine as build
FROM maven:3.8.1-openjdk-8-slim as build

#COPY mvnw .
#COPY .mvn .mvn

WORKDIR /app

COPY pom.xml .

COPY sources.list /etc/apt/sources.list
COPY settings.xml /usr/share/maven/ref/

# RUN ./mvnw dependency:go-offline -B
RUN mvn -f pom.xml -s /usr/share/maven/ref/settings.xml dependency:go-offline -B

COPY src src

RUN mvn -s /usr/share/maven/ref/settings.xml package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# RUN ./mvnw package -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jre-alpine

ARG DEPENDENCY=/app/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demo.DemoApplication"]
