public interface IConta {

	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();
 
	//esses métodos poderiam ficar na classe conta, criar interface é opcional
}
