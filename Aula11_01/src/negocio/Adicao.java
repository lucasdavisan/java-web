package negocio;

public class Adicao implements ICalculo {
	private float x, y;
	
	public Adicao(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public float calcular() {
		return this.x + this.y;
	}
}
