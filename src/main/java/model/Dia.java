package model;

public class Dia {
	private String fecha;
	private String prono;
	private String icono;
	private String preci;
	private String max;
	private String min;
	public Dia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dia(String fecha, String prono, String icono, String preci, String max, String min) {
		super();
		this.fecha = fecha;
		this.prono = prono;
		this.icono = icono;
		this.preci = preci;
		this.max = max;
		this.min = min;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getProno() {
		return prono;
	}
	public void setProno(String prono) {
		this.prono = prono;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public String getPreci() {
		return preci;
	}
	public void setPreci(String preci) {
		this.preci = preci;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	@Override
	public String toString() {
		return "Dia [fecha=" + fecha + ", prono=" + prono + ", icono=" + icono + ", preci=" + preci + ", max=" + max
				+ ", min=" + min + "]";
	}
	

}
