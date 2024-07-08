
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
    try {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor do saque deve ser maior que zero.");
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque."+getSaldo());
        }
		
		} catch (ValorInvalidoException e) {
        System.out.println(e.getMessage());
		}
		catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
    
        // Deduzir o valor do saldo
        saldo -= valor;

       // System.out.println("Saque realizado com sucesso. Novo saldo: " + saldo);
    } 



@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}



	@Override
	public void transferir(double valor, IConta contaDestino) throws SaldoInsuficienteException, ValorInvalidoException {
		if (valor <= 0) {
			throw new ValorInvalidoException("Valor da transferência deve ser maior que zero.");
		}
		if (this == contaDestino) {
            throw new IllegalArgumentException("Não é possível transferir para a mesma conta.");
        }

		this.sacar(valor); // Realiza o saque na conta de origem
		contaDestino.depositar(valor); // Deposita na conta de destino
	
		System.out.println("Transferência realizada com sucesso.");
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));

	}
}