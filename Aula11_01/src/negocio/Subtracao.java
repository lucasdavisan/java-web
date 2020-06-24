package negocio;

public class Subtracao implements ICalculo {
	private float x, y;
	
	public Subtracao(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public float calcular() {
		return this.x - this.y;
	}
}
