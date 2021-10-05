# Learning

## Dotnet

### Creating the Project
```cmd
mkdir ConsumerService
cd ConsumerService
dotnet new webapi
cd ..
dotnet new sln
Rename-Item -Path apps.sln -NewName Apps.sln
dotnet sln Apps.sln add ConsumerService
```

### Configuring a Self-Signed Certificate

```cmd
cd ConsumerService
dotnet user-secrets init
dotnet dev-certs https -ep $env:USERPROFILE\.aspnet\https\<NAME_OF_THE_PROJECT>.pfx -p <CRYPTIC_PASSWORD>
dotnet dev-certs https --trust
dotnet user-secrets -p ConsumerService.csproj set "Kestrel:Certificates:Development:Pasword" "<CRYPTIC_PASSWORD>"
dotnet run
```

$env:USERPROFILE returns the user directory path, like C:\Users\Wallace

<https://docs.microsoft.com/pt-br/dotnet/core/additional-tools/self-signed-certificates-guide#with-dotnet-dev-certs>