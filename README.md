# spring-session-redis-timeout
Spring Session + HandlerInterceptor + Redis
先在本地启用Redis
# 登录接口
```bash
curl --location --request POST 'http://localhost:8080/api/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=C339017AFC4507AB65EF2E959B7FDD44; SESSION=ODY5YWExOWUtMTZiMi00ODViLTg2YmUtMDNkMTQ5Y2U0OTI3' \
--data-raw '{
    "username":"zyl",
    "password":"passwd"
}'
```
# 访问资源接口
```bash
curl --location --request GET 'http://localhost:8080/api/hello' \
--header 'Cookie: JSESSIONID=C339017AFC4507AB65EF2E959B7FDD44; SESSION=ODY5YWExOWUtMTZiMi00ODViLTg2YmUtMDNkMTQ5Y2U0OTI3'

# 响应结果
hello zyl
```
