package negocio;

public class Circulo extends Figura {
	private float raio;
	
	public Circulo(float raio) {
		this.raio = raio;
	}
	
	@Override
	public void calcularArea() {
		area = (float) (Math.PI * Math.pow(raio, 2));
	}
}
