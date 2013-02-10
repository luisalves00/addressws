package org.tamarillo.addressws.jpa.exception;

/**
 * The Class PreexistingEntityException.
 */
public class PreexistingEntityException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -142130297700639351L;
	
	/**
	 * Instantiates a new preexisting entity exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Instantiates a new preexisting entity exception.
     *
     * @param message the message
     */
    public PreexistingEntityException(String message) {
        super(message);
    }
}
