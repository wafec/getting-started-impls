FROM gradle:7-jdk11 as build

WORKDIR /app

COPY . ./

RUN gradle bootJar


FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app

COPY --from=build /app/app/build/libs/ ./

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]