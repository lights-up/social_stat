/**
 * 
 */
package by.lightsup.socialstat.exception;

/**
 * @author note
 *
 */
public class ServiceLayerException extends Exception {

	/**
	 * 
	 */
	public ServiceLayerException() {
	}

	/**
	 * @param arg0
	 */
	public ServiceLayerException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public ServiceLayerException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ServiceLayerException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public ServiceLayerException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
