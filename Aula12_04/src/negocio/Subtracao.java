package negocio;

public class Subtracao implements ICalculo {
	private float valor1, valor2;
	
	public Subtracao(float valor1, float valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	
	@Override
	public float calcular() {
		return valor1 - valor2;
	}
}
