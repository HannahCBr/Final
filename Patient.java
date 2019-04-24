
public class Patient implements Comparable<Patient>{
	String fName, lName;
	int total;
	
	
	public Patient() {
		
	}
	/**
	 * @param fName
	 * @param lName
	 */
	public Patient(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}
	/**
	 * @param fName
	 * @param lName
	 * @param total
	 */
	public Patient(int total, String fName, String lName) { //used for priority queue
		this.fName = fName;
		this.lName = lName;
		this.total = total;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "fName=" + fName + ", lName=" + lName + ", total=" +total+" ";
	}
	@Override
	public int compareTo(Patient o) {
		if (this.getTotal()<o.getTotal()) {
			return 1;
		} else if (this.getTotal()>o.getTotal()) {
			return -1;
		} else {
			return 0;
		}
	}


}
