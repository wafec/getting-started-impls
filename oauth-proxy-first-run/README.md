```cmd
docker run --rm -p 4180:4180 -p 443:4443 -v "$PWD/:/tmp" -it quay.io/oauth2-proxy/oauth2-proxy --config=/tmp/oauth2-proxy.cfg
```

dev-local.com was configured in Google and in the hosts file in Windows

This url bypass the auth2 login page

http://dev-local.com:4180/oauth2/start

Or

http://dev-local.com:4180/my-app