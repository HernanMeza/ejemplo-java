package com.ntt.app.vo;

/**
 * The Class ActividadVO.
 */
public class ActividadVO {
	
	/** The creo. */
	boolean creo;
	
	/** The encontro. */
	boolean encontro;
	
	/** The actualizo. */
	boolean actualizo;
	
	/** The mal request. */
	boolean malRequest;
	
	/** The fallo. */
	boolean fallo;

	
	/**
	 * Instantiates a new actividad VO.
	 */
	public ActividadVO() {
		super();
		this.creo = false;
		this.encontro = false;
		this.actualizo = false;
		this.malRequest = false;
		this.fallo = false;
	}
	
	/**
	 * Checks if is creo.
	 *
	 * @return true, if is creo
	 */
	public boolean isCreo() {
		return creo;
	}
	
	/**
	 * Sets the creo.
	 *
	 * @param creo the new creo
	 */
	public void setCreo(boolean creo) {
		this.creo = creo;
	}
	
	/**
	 * Checks if is encontro.
	 *
	 * @return true, if is encontro
	 */
	public boolean isEncontro() {
		return encontro;
	}
	
	/**
	 * Sets the encontro.
	 *
	 * @param encontro the new encontro
	 */
	public void setEncontro(boolean encontro) {
		this.encontro = encontro;
	}
	
	/**
	 * Checks if is actualizo.
	 *
	 * @return true, if is actualizo
	 */
	public boolean isActualizo() {
		return actualizo;
	}
	
	/**
	 * Sets the actualizo.
	 *
	 * @param actualizo the new actualizo
	 */
	public void setActualizo(boolean actualizo) {
		this.actualizo = actualizo;
	}

	/**
	 * Checks if is mal request.
	 *
	 * @return true, if is mal request
	 */
	public boolean isMalRequest() {
		return malRequest;
	}

	/**
	 * Sets the mal request.
	 *
	 * @param fallo the new mal request
	 */
	public void setMalRequest(boolean fallo) {
		this.malRequest = fallo;
	}

	/**
	 * Checks if is fallo.
	 *
	 * @return true, if is fallo
	 */
	public boolean isFallo() {
		return fallo;
	}

	/**
	 * Sets the fallo.
	 *
	 * @param fallo the new fallo
	 */
	public void setFallo(boolean fallo) {
		this.fallo = fallo;
	}
}
