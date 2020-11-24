# API LIVRES BAIXADA SANTISTA

## Testes feitos pelo Grupo L1

### Testes unitários

Dentro da pasta de testes do projeto, temos o pacote "br.com.livresbs.livres.model", o qual encontra-se a classe ConsumidorTest.
Nesta classe executamos os testes da classe Consumidor. 
Devido ao projeto ser uma API com métodos que fazem acesso ao banco de dados, e possuem interação com demais métodos da aplicação, optamos por realizar
os testes dos métodos getters da classe Consumidor, utilizando JUnit integrado ao pacote do Spring Boot.

Os testes consistem em:

 1 - criar um consumidor;

 2 - definir o atributo que iremos testar;

 3 - verificar se o valor retornado é igual ao definido na etapa 2.

```
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ConsumidorTest {

 @Test
 final void testGetCpf() {
  Consumidor c1 = new Consumidor();
  c1.setCpf("12345678912");
  assertEquals("12345678912", c1.getCpf());
 }

 @Test
 final void testGetNome() {
  Consumidor c1 = new Consumidor();
  c1.setNome("gabriel");
  assertEquals("gabriel", c1.getNome());
 }

 @Test
 final void testGetSobrenome() {
  Consumidor c1 = new Consumidor();
  c1.setSobrenome("Tavares");
  assertEquals("Tavares", c1.getSobrenome());
 }

 @Test
 final void testGetSenha() {
  Consumidor c1 = new Consumidor();
  c1.setSenha("Ciro");
  assertEquals("Ciro", c1.getSenha());
 }

 @Test
 final void testGetPrecomunidade() {
  Consumidor c = new Consumidor();
  PreComunidade p = new PreComunidade();
  c.setPrecomunidade(p);
  assertEquals(p, c.getPrecomunidade());
 }
}
```

### Testes funcionais

Diagrama demonstrando o fluxo do teste que tenta inserir um novo consumidor ao sistema utilizando a interface gráfica.
![imagem do diagrama do teste inserindo um novo consumidor](/docs/inserirNovo.jpeg "Diagrama do teste inserindo um novo consumidor")

Diagrama demonstrando o fluxo do teste que tenta inserir um consumidor já existente no sistema utilizando a interface gráfica.
![imagem do diagrama do teste inserindo um consumidor existente](/docs/inserirExistente.jpeg "Diagrama do teste inserindo um consumidor existente")