

import static org.junit.Assert.*;

import io.cucumber.java.en.*;

public class Conta {

	Cliente costumer = new Cliente();

	@Given("um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		costumer.setBalance(int1);
		costumer.setToSpecialCustomer();
	}

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) throws Exception {
		costumer.withdraw(int1);
	}

	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
		assertEquals(Double.valueOf(int1), costumer.getBalance());
	}

	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
		costumer.setToNormalCustomer();
		costumer.setBalance(int1);
	}

	String errorMessage = "";
	
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) throws Exception {
		try {
			costumer.withdraw(int1);
		}catch(Exception error) {
			errorMessage = error.getMessage();
		}
	}

	@Then("nao deve efetuar o saque e deve retornar mensagem de Saldo Insuficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_mensagem_de_saldo_insuficiente() {
		assertEquals(errorMessage, "Saldo insuficiente");
	}
	
	@Then("deve ser realizado o saque e o valor atual devera ser de {int} reais")
	public void deve_ser_realizado_o_saque_e_o_valor_atual_devera_ser_de_reais(Integer int1) {
	    assertEquals(costumer.getBalance(), Double.valueOf(int1));
	}

}
