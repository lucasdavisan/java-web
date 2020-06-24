package negocio;

public class Retangulo extends Figura {
	private float x, y;
	
	public Retangulo(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void calcularArea() {
		area = x * y;
	}
}
