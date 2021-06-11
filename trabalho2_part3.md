# Enunciado do Trabalho 3

**Objectivos**: Prática com API assíncrona, `CompletableFuture<T>`.
<br>
**Data limite de entrega**:  **27 de Junho de 2021**

Implemente os testes unitários necessários para validar o
funcionamento das funcionalidades pedidas.

**NOTA 1**: não poderá criar ou usar explicitamente fios de execução (i.e.
`Thread`), nem por diferimento de tarefas (i.e.
`CompletableFuture.supplyAsync(...)`) nem através de qualquer outro meio.

**NOTA 2**: não poderá bloquear sobre o resultado das computações assíncronas
(i.e. `.join()` ou `.get()`) com excepção aos testes unitários.

## Parte 0

No âmbito do  projecto **moviesdb** pretende-se tornar a sua API assíncrona. Deverá
criar um novo módulo `moviesdb_async` com base no anterior `moviesdb_streams` e adaptá-lo de
acordo com os requisitos deste enunciado.

## Parte 1 (para cotações até 13 valores)

De modo a que o módulo `moviesdb_async` passe a usar IO não-bloqueante, crie uma
nova interface `AsyncRequest` com um método `getBody()` que tenha API
assíncrona. 
A implementação desta interface para pedidos HTTP GET deve recorrer a uma
biblioteca para realização de pedidos HTTP não bloqueantes, como por exemplo
[AsyncHttpClient](https://github.com/AsyncHttpClient/async-http-client).

Os métodos de `MoviesDbWebApi` e `MoviesService`devem passar a retornar resultados na forma de 
`CompletableFuture<List<...>>` e `CompletableFuture<Stream<...>>`, respectivamente.

Ao contrário das versões anteriores, **os métodos do serviço não são _lazy_**. 
Modifique os testes já existentes de modo a adapraem-se às alterações efetuadas no módulo.

## Parte 2 (Optional) para cotações até 20 valores

Implemente uma aplicação Web usando tecnologia
com suporte para handlers assíncronos, como por exemplo [VertX](https://vertx.io/docs/vertx-web/java/)
 

A aplicação deve disponibilizar as seguintes páginas:

1.  Listagem de todas os géneros de séries de Tv.
    Cada género tem um link para a listagem das séries desse género.
    (página 2).
2.  Listagem de séries de determinado género ou em que determinado actor tenha participado.
    Cada série tem 2 links: um para a listagem dos seus actores (página 3) e outro para a
    listagem dos seus géneros.
    O número de items apresentados nesta página pode ser limitado por um
    parâmetro de _query-string_.
3.  Listagem de actores de uma série. Cada actor tem um link para a listagem
    das séries em que participou (página 2).

As páginas anteriores são acessíveis através dos seguintes caminhos (paths): 

1.	`/genres`
2.	`/genres/:id/tvseries` ou `/actors/:id/tvseries`
3.	`/tvseries/:id/actors`

A aplicação web **nunca poderá bloquear** (não fazer `join()` e nem `get()`) na
obtenção de um resultado. 

