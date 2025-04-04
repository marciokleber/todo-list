### Setando a versão do java

```shell 
  sdk env
```

### Rodando a aplicação
```shell 
  mvn clean spring-boot:run
```


>### Testando os endpoints da entidade Categoria
>
>#### findAll
>```shell 
>  curl -X GET http://localhost:8080/todolist/categoria | jq
>```
>
>#### findById
>```shell 
>  curl -X GET http://localhost:8080/todolist/categoria/1 | jq
>```
>
>#### create
>```shell 
>  curl -X POST \
>   -H 'Content-Type: application/json' \
>   -d '{"nome":"Trabalho", "descricao":"Tarefas relacionadas ao trabalho corporativo"}' \
>    http://localhost:8080/todolist/categoria | jq
>```
>
>#### update
>```shell 
>  curl -X PUT \
>   -H 'Content-Type: application/json' \
>   -d '{"nome":"Trabalho", "descricao":"Tarefas relacionadas ao trabalho."}' \
>    http://localhost:8080/todolist/categoria/16 | jq
>```
>
>#### delete
>```shell 
>  curl -X GET http://localhost:8080/todolist/categoria/1 | jq
>```


>
>### Build GraalVm
>```shell 
>sdk use java 17.0.12-graal
>```
>```shell 
>sudo apt-get install build-essential libz-devzlib1g-dev
>```
>```shell 
>mvn clean package -Pnative
>```
>```shell 
>mvn -Pnative native:compile
>```
>



