package negocio;

public class Divisao implements ICalculo {
	private float x, y;
	
	public Divisao(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public float calcular() {
		return this.x / this.y;
	}
}
