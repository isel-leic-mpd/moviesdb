# Enunciado do Trabalho II - parte II

**Data limite de entrega: 6 de junho**

**Objectivos**: Prática com `Stream<T>` e `Spliterator<T>`

**NOTA**: 
1.  A solução entregue deve incluir todos os testes unitários necessários para
    validar o correcto funcionamento das funcionalidades pedidas. 
    **ATENÇÃO**: os testes devem verificar o correcto funcionamento do projeto mesmo sem
    ligação à internet.



Crie o módulo `moviesdb_streams` e copie o conteúdo do package `isel.leirt.mpd.moviesdb1` do
módulo moviesdb_lazy para o package `isel.leirt.mpd.moviesdb2` no novo módulo.


## 1. Utilização de sequências Stream e operação cache

No módulo `moviesdb_streams` substitua a utilização de:

1. `Iterator<T>` por `Stream<T>`.
2. `Iterable<T>` por `Stream<T>` ou `Supplier<Stream<T>>`.
2. `Queries` do módulo `moviesdb_utils` pelos métodos estáticos e default de `Stream<T>`.

Acrescente ao módulo `moviesdb_utils` o package `isel.leirt.mpd.streams` e nesse package a  classe  
`StreamUtils` com o método `Supplier<Stream<T>> cache(Stream<T> src)` que permite criar uma cache sobre 
o acesso à stream `src`recebida por parâmetro.

A sequência resultante do `cache()` deve:
1. guardar em memória os elementos que vão sendo obtidos da sequência fonte `src`.
2. retornar sempre os elementos que já estejam guardados em
memória e só obter um novo elemento da fonte caso este não esteja _cached_.

Exemplo de utilização do método `cache()` sobre uma sequência infinita:

```java
Random r = new Random();
Stream<Integer> nrs = generate(() -> r.nextInt(100));
Supplier<Stream<Integer>> nrs = cache(nrs);
Object[] expected = nrs.get().limit(10).ToArray();
Object[] actual = nrs.get().limit(10).ToArray();
assertArrayEquals(expected, actual);
```
Note que os elementos das sequências resultantes de `cache()` podem ser obtidos alternadamente
entre sequências (através de iteração externa via `tryAdvance` de `Spliterator`).

Modifique os objectos do modelo (`Genre`, `TvSeries` e `Actor`), para evitar que múltiplos pedidos dos objetos
associados (ex: as séries de um dado género) impliquem múltiplos pedidos à `MoviesDbWebApi`.

## 2. Operação sortedMerge

Implemente em `StreamUtils` o método `Stream<T> sortedMerge(Comparator<T> cmp, Stream<T> ... streams)` que 
retorna uma nova sequência ordenada segundo o comparador `cmp` a partir das sequências parciais recebidas no parâmetro `streams`.
** Considere que as sequências parciais também estão ordenadas segundo o critério definido por `cmp` **
A implementação deve ser _lazy_.

Poderá começar por realizar a versão simplificada `Stream<T> sortedMerge(Comparator<T> cmp, Stream<T> src1, Stream<T> src2)` que 
faz o merge (_lazy_) das duas sequências `src1`e `src2`.


## 3. Operação do serviço 

Tirando partido da operação `sortedMerge`, acrescente ao serviço os métodos:

1. `Stream<TvSeries> getMostPopularSeriesFromGenres(int maxSeries, int ... genreIds)` que retorna a sequência das `maxSeries`mais populares
   dentro dos géneros indicados.

2. `Stream<TvSeries> getMostPopularSeries(int maxSeries)` que retorna a sequência com as séries de Tv mais populares dentro de todos os géneros.










