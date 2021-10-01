FROM gradle:7-jdk11

RUN mkdir /app
COPY . /app
WORKDIR /app
RUN gradle build

EXPOSE 8080

CMD gradle bootRun