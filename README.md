# livres
responsável pelo desenvolvimento das funcionalidades referentes aos cadastros básicos (cadastro das deliberações, cadastro dos avaliadores por deliberação, cadastro dos critérios de avaliação por nível de avaliação, cadastro das propostas para avaliação

## Criando sua branch
Utilize a branch dev para inicializar sua branch;
Todas sua alterações devem ser feitas dentro da sua branch e só depois ser feito merge à branch dev;
De preferência padronizar os nomes das branch, exemplo "nomeBranch".

### Testes feitos pelo Grupo L1
Dentro do pacote de testes do projeto, temos o pacote "br.com.livresbs.livres.model", o qual encontra-se a classe ConsumidorTest.

Estamos utilizando JUnit e efetuando todos os testes unitários de todos os Gets da Classe de Consumidor.

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

