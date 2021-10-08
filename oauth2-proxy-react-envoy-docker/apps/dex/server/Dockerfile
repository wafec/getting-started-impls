FROM golang
USER root

RUN apt update
RUN apt install -y git make

RUN mkdir /app
WORKDIR /app
RUN git clone https://github.com/dexidp/dex.git

WORKDIR /app/dex
RUN make build

EXPOSE 5556
EXPOSE 5558

CMD ["./bin/dex", "serve", "/tmp/config.yaml"]