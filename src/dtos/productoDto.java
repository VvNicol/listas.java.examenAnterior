package dtos;

import java.time.LocalDateTime;

/**
 * @author csi23-nrojlla 01032024 datos del producto
 */
public class productoDto {

	long id;
	String nombreProducto = "aaaaa";
	double costeProducto = 000;
	LocalDateTime fechaCompra = LocalDateTime.of(9999, 12, 31, 00, 00, 00);

	/**
	 * 
	 */
	public productoDto() {
		super();
	}

	

	/**
	 * @param id
	 * @param nombreProducto
	 * @param costeProducto
	 * @param fechaCompra
	 */
	public productoDto(long id, String nombreProducto, double costeProducto, LocalDateTime fechaCompra) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.costeProducto = costeProducto;
		this.fechaCompra = fechaCompra;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "productoDto [id=" + id + ", nombreProducto=" + nombreProducto + ", costeProducto=" + costeProducto
				+ ", fechaCompra=" + fechaCompra + "]";
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
	 * @return the fechaCompra
	 */
	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

}
