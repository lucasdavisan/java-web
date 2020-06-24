package negocio;

public class Massa implements IMassa {
	private float massa;
	
	@Override
	public float converterQuiloParaLibra(float massa) {
		return massa * 2.2046f;
	}
	
	@Override
	public float converterLibraParaQuilo(float massa) {
		return massa / 2.2046f;
	}
}
