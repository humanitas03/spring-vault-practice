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
```
$ cd dockerized-vault
$ docker-compose up -d
```

* shell script 실행 금지..
* 

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