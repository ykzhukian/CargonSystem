package asgn2Containers;

import asgn2Codes.ContainerCode;
import asgn2Exceptions.InvalidContainerException;

/**
 * This class is used to represent the characteristics of a
 * generic freight, or intermodal, cargo container.  All containers
 * that may be loaded onto a ship must be marked with a valid
 * container code and must have a stated gross weight.  (The gross
 * weight is the sum of the container's tare and net weights.)
 * 
 * @author CAB302 Ryan does something here
 * @version 1.0
 */
public abstract class FreightContainer {
	
	ContainerCode code;
	int grossWeight;
	String type = "";
	
	/**
	 * Constructs a freight container object with the given
	 * container code and weight.  We assume that the container
	 * itself weighs 4 tonnes (the tare weight) and that the
	 * maximum gross weight for this kind of container is 30
	 * tonnes.  (These figures are consistent with standard
	 * 20 foot containers.)
	 * 
	 * @param code the container's code
	 * @param grossWeight the container's weight in tonnes
	 * @throws InvalidContainerException if the gross weight is not between 4 and
	 * 30 tonnes, inclusive
	 */
	public FreightContainer(ContainerCode code, Integer grossWeight) throws InvalidContainerException {
		if (code == null) {
			throw new InvalidContainerException("Missing code");
		}
		if (grossWeight > 30 || grossWeight < 4) {
			throw new InvalidContainerException("Gross weight invalid");
		}
		this.code = code;
		this.grossWeight = grossWeight;
	}

	/**
	 * Returns the container's code.
	 * 
	 * @return the code
	 */
	public ContainerCode getCode() {
		return code;
	}

	/**
	 * Returns the container's gross weight.
	 * 
	 * @return the gross weight (in tonnes)
	 */
	public Integer getGrossWeight() {
		return grossWeight;
	}
	
	public String getType() {
		return type;
	}


}
