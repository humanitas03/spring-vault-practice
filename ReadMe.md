# Dockerized-vault + Spring vault practice
* Docker 기반 Vault 와 Spring Vault 연동 연습

## Hashcorp Vault
https://learn.hashicorp.com/vault


### dockerized vault references
* https://github.com/mcchae/docker_consul_vault
* https://www.marcolancini.it/2017/blog-vault/

### spring vault reference
* https://www.baeldung.com/spring-vault

### 기타 reference
* https://m.blog.naver.com/wideeyed/222025366151

### dockerized-vault 실행 방법

* docker-compose 명령어 실행
```
$ cd dockerized-vault
$ docker-compose up -d
```

* Vault 정상동작 테스트
  * 아래 curl 명령 수행 후 vault서버에서 아래 응답을 받는지 확인 
```bash
$ curl --request GET 'http://localhost:8200/v1/dbsetup/dbcred' \
--header 'X-Vault-Token: s.uf03va1lEZyZdkYZpaiwtSKL'
```
* 응답
```json
{
    "request_id": "...",
    "lease_id": "",
    "renewable": false,
    "lease_duration": 2764800,
    "data": {
        "password": "password",
        "username": "user"
    },
    "wrap_info": null,
    "warnings": null,
    "auth": null
}
```

* shell script 실행 금지..
* spring-boot app 실행 후 curl 수행
```bash
$ curl http://localhost:8080/
```

### 삽질기록..
* shell script 작성하는데 mac OS X 에서는 ```alias``` 가 잘 먹지 않아.. 삽질을 하다 결국, [해당자료](https://github.com/mcchae/docker_consul_vault) 를 참고하여 스크립트를 수정함.
```bash
vault()
{
	docker-compose exec vault vault "$@"
}
export -f vault
```

* spring-cloud-vault(https://cloud.spring.io/spring-cloud-vault/reference/html/)를 적용해 보려고 했으나, ```https```가 강제가 되는 것 같음...