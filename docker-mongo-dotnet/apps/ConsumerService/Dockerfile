FROM mcr.microsoft.com/dotnet/sdk:5.0

RUN mkdir /app
COPY . /app
WORKDIR /app
RUN dotnet build

EXPOSE 5000
EXPOSE 5001

CMD dotnet run