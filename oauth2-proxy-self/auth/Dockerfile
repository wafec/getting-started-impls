FROM gradle:7-jdk11 as build

WORKDIR /app

COPY ./ ./

RUN gradle bootJar


FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY --from=build /app/build/libs/ ./
COPY --from=build /app/src/main/resources/ ./resources

EXPOSE 8080

CMD ["java", "-jar", "auth.jar"]