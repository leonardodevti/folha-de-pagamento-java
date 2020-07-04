package entidades;

public class FuncionarioTerceirizado extends Funcionario {

	private Double despesaAdicional;

	public FuncionarioTerceirizado() {
		super();
	}

	public FuncionarioTerceirizado(String nome, Integer horas, Double valorPorHora, Double despesaAdicional) {
		super(nome, horas, valorPorHora);
		this.despesaAdicional = despesaAdicional;
	}

	public Double getDespesaAdicional() {
		return despesaAdicional;
	}

	public void setDespesaAdicional(Double despesaAdicional) {
		this.despesaAdicional = despesaAdicional;
	}

	@Override
	public final double pagamento() {//sobrescrevendo o método da superclasse Funcionario.
		return super.pagamento() + despesaAdicional * 1.1; // Pagamento + 11% da despesa adicional.
	}

}
