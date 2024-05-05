/**
 * 
 */
package dtos;

import java.time.LocalDateTime;

/**
 * Datos de la agencia para entrega
 */
public class agenciaDto {

	
	long id;
	String nombreProducto = "aaaaa";
	double costeProducto = 00.0;
	LocalDateTime fechaEntrega = LocalDateTime.of(9999, 12, 31,00,00,00);
	


	

	@Override
	public String toString() {
		return "agenciaDto [id=" + id + ", nombreProducto=" + nombreProducto + ", costeProducto=" + costeProducto
				+ ", fechaEntrega=" + fechaEntrega + "]";
	}
	
	public agenciaDto() {
		super();
	}
	
	/**
	 * @param id
	 * @param nombreProducto
	 * @param costeProducto
	 * @param fechaEntrega
	 */
	public agenciaDto(long id, String nombreProducto, double costeProducto, LocalDateTime fechaEntrega) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.costeProducto = costeProducto;
		this.fechaEntrega = fechaEntrega;
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
	 * @param costeProducto the costeProducto to set
	 */
	public void setCosteProducto(int costeProducto) {
		this.costeProducto = costeProducto;
	}
	/**
	 * @return the costeProducto
	 */
	public double getCosteProducto() {
		return costeProducto;
	}
	/**
	 * @param costeProducto the costeProducto to set
	 */
	public void setCosteProducto(double costeProducto) {
		this.costeProducto = costeProducto;
	}
	/**
	 * @return the fechaEntrega
	 */
	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	/**
	 * 
	 */

}
