package servlets;

public class Calculo {
	private float v1, v2;
	
	public Calculo(float v1, float v2) {
		this.setV1(v1);
		this.setV2(v2);
	}
	
	public float getV1() {
		return this.v1;
	}
	
	public void setV1(float v1) {
		this.v1 = v1;
	}
	
	public float getV2() {
		return this.v2;
	}
	
	public void setV2(float v2) {
		this.v2 = v2;
	}
}
