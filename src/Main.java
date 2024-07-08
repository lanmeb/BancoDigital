public class Main {
    public static void main(String[] args) throws SaldoInsuficienteException, ValorInvalidoException {
		Cliente elania = new Cliente();
		elania.setNome("Elania");
		
		ContaCorrente cc = new ContaCorrente(elania);

		//polimorfismo
		//Conta poupanca = new ContaPoupanca(elania); ou 
		ContaPoupanca poupanca = new ContaPoupanca(elania);
		//IConta poupanca = new ContaPoupanca(elania);

		cc.depositar(000);
		cc.transferir(100, poupanca);
		cc.sacar(300);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}

}
