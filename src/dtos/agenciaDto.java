/**
 * 
 */
package dtos;

/**
 * Datos de la agencia para entrega
 */
public class agenciaDto {

	
	long id;
	String nombreProducto = "aaaaa";
	int costeProducto = 000;
	String fechaEntrega = "dd/MM/yyy hh:mm:ss";
	

	/**
	 * 
	 */
	public agenciaDto() {
		super();
	}
	/**
	 * @param id
	 * @param nombreProducto
	 * @param costeProducto
	 * @param fechaEntrega
	 */
	public agenciaDto(long id, String nombreProducto, int costeProducto, String fechaEntrega) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.costeProducto = costeProducto;
		this.fechaEntrega = fechaEntrega;
	}
	@Override
	public String toString() {
		return "agenciaDto [id=" + id + ", nombreProducto=" + nombreProducto + ", costeProducto=" + costeProducto
				+ ", fechaEntrega=" + fechaEntrega + "]";
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * @return the costeProducto
	 */
	public int getCosteProducto() {
		return costeProducto;
	}
	/**
	 * @param costeProducto the costeProducto to set
	 */
	public void setCosteProducto(int costeProducto) {
		this.costeProducto = costeProducto;
	}
	/**
	 * @return the fechaEntrega
	 */
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	
}
