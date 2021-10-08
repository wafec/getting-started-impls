FROM golang
USER root

RUN apt update
RUN apt install -y git make

RUN mkdir /app
WORKDIR /app
RUN git clone https://github.com/dexidp/dex.git

WORKDIR /app/dex
RUN make examples

EXPOSE 5555

ENTRYPOINT ["./bin/example-app"]