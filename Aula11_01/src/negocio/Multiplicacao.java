package negocio;

public class Multiplicacao implements ICalculo {
	private float x, y;
	
	public Multiplicacao(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public float calcular() {
		return this.x * this.y;
	}
}
