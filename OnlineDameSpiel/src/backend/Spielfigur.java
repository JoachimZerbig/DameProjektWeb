package backend;

import java.io.Serializable;

/**
 * 
 * @author A2
 *
 */

public class Spielfigur implements Serializable{
	
	private FarbEnum farbe;
//	private Spielfeld position; //noch noetig?
	private boolean dame = false;

	/**
	 * 
	 * @param sstein 
	 * @param FarbeEnum farbe
	 *          
	 * @param Spielfeld position
	 *          
	 */
	public Spielfigur(FarbEnum farbe, boolean b) {

		this.setFarbe(farbe);
		//this.setPosition(position); noch noetig?
		this.setDame(b);

	}

	/**
	 * 
	 * @return Farbenum farbe
	 */
	public FarbEnum getFarbe() {
		return farbe;
	}

	/**
	 * 
	 * @param Farbenum
	 *          farbe
	 */
	public void setFarbe(FarbEnum farbe) {
		this.farbe = farbe;
	}

	/**
	 * 
	 * @return Spielfeld position
	 */
//	public Spielfeld getPosition() {
//		return position; noch noetig?
//	}

	/**
	 * 
	 * @param Spielfeld
	 *          position
	 */
//	public void setPosition(Spielfeld position) {
//		this.position = position; noch noetig?
//	}

	public boolean isDame() {
		return dame;
	}

	public void setDame(boolean dame) {
		this.dame = dame;
	}
	

	/** gibt |O|, |x| v "farblos zurueck bei Weiss, schwarz oder bei falschem aufruf
	 * @return |O|, |x| v "farblos
	 */
	@Override
	public String toString() {
		if(farbe== FarbEnum.weiss){
			if(this.dame==false){
			return ">Stein<";
			}
			if(this.dame==true){
				return ">Dame<";
			}
		}
		if(farbe==FarbEnum.schwarz){
			if(this.dame==false){
				
			
			return ">Stein<";	
		}if(this.dame==true){
		return ">Dame<";	
		}
		}
			return "|_DASD|";
		
	}}
