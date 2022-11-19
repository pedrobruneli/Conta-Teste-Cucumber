
# TESTE CONTA CUCUMBER

## CUCUMBER
Foi criado com o cucumber um arquivo .feature que prevê os testes que serão realizados na classe de Conta de todas as suas funcionalidades. Após rodar o cucumber ele gerou os métodos descritos no arquivo .feature para fazer a implementação dos testes.

## Explicacao do código passo a passo

No código abaixo começa-se criando uma instancia de Cliente chamada costumer para começar à fazer os testes em cima da mesma.

Logo após tem a descrição do que a função irá fazer "um cliente especial com saldo atual de {int} reais".

Assim é setado o balance do cliente igual ao passado no arquivo .feature e o cliente é setado para especial.

### Cenário 1. (Saque de cliente especial com saldo negativo)

```
Cliente costumer = new Cliente();

	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		costumer.setBalance(int1);
		costumer.setToSpecialCustomer();
	}
```

No código abaixo é solicitado um saque de int1 valor, mesmo valor do .feature...

```
@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) throws Exception {
		costumer.withdraw(int1);
	}
```

Por fim é testado se o saque foi realizado com sucesso
```
@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
		assertEquals(Double.valueOf(int1), costumer.getBalance());
	}
```

### Cenário 2. (Saque de cliente comum com saldo negativo)

No código abaixo temos a praticamente a mesma coisa do código acima, porém agora testando com o cliente do tipo "Normal".
```
@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
		costumer.setToNormalCustomer();
		costumer.setBalance(int1);
	}
```

Para conseguir retirar o erro que será lançado ao tentar fazer o saque de cliente comum com saldo negativo, utilizaremos a variavel errorMessage, assim capturando a mensagem de erro lançada do código.

```
String errorMessage = "";
@When("solicitar um saque de {int} reais")
public void solicitar_um_saque_de_reais(Integer int1) throws Exception {
    try {
	    costumer.withdraw(int1);
    } catch (Exception error) {
        errorMessage = error.getMessage();
    }
}
```

Abaixo está sendo verificado se o erro foi lançado com a mensagem correta.
```
@Then("nao deve efetuar o saque e deve retornar mensagem de Saldo Insuficiente")
public void nao_deve_efetuar_o_saque_e_deve_retornar_mensagem_de_saldo_insuficiente() {
	assertEquals(errorMessage, "Saldo insuficiente");
}
```

### Cenário 3 (Cliente comum com saldo positivo)

Para o cenário 3, foi utilizado códigos vistos anteriormente e explicados anteriormente com exceto do abaixo, no qual testa o saldo do cliente para checar se houve o saque corretamente.
```
@Then("deve ser realizado o saque e o valor atual devera ser de {int} reais")
public void deve_ser_realizado_o_saque_e_o_valor_atual_devera_ser_de_reais(Integer int1) {
    assertEquals(costumer.getBalance(), Double.valueOf(int1));
}
```

Os códigos reutilizados podem ser conferidos abaixo.
```
@Given("um cliente comum com saldo atual de {int} reais")
public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
	costumer.setToNormalCustomer();
	costumer.setBalance(int1);
}
```
```
@When("solicitar um saque de {int} reais")
public void solicitar_um_saque_de_reais(Integer int1) throws Exception {
	try {
		costumer.withdraw(int1);
	}catch(Exception error) {
		errorMessage = error.getMessage();
	}
}
```

### Cenário 4

Para este cenário também foi utilizado códigos explicados anteriormente nos quais se encontram abaixo.
```
@Given("um cliente especial com saldo atual de {int} reais")
public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
	costumer.setBalance(int1);
	costumer.setToSpecialCustomer();
}
```
```
@Given("um cliente comum com saldo atual de {int} reais")
public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
	costumer.setToNormalCustomer();
	costumer.setBalance(int1);
}
```
```
@When("solicitar um saque de {int} reais")
public void solicitar_um_saque_de_reais(Integer int1) throws Exception {
	try {
		costumer.withdraw(int1);
	}catch(Exception error) {
		errorMessage = error.getMessage();
	}
}
```
