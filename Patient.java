
public class Patient {
	String fName, lName, s1, s2, s3;
	int total;
	
	
	public Patient() {
		
	}
	/**
	 * @param fName
	 * @param lName
	 * @param s1
	 */
	public Patient(String fName, String lName, String s1) {
		this.fName = fName;
		this.lName = lName;
		this.s1 = s1;
	}
	/**
	 * @param fName
	 * @param lName
	 * @param s1
	 * @param s2
	 */
	public Patient(String fName, String lName, String s1, String s2) {
		this.fName = fName;
		this.lName = lName;
		this.s1 = s1;
		this.s2 = s2;
	}
	/**
	 * @param fName
	 * @param lName
	 * @param s1
	 * @param s2
	 * @param s3
	 */
	public Patient(String fName, String lName, String s1, String s2, String s3) { //used to find symptoms and searching
		this.fName = fName;
		this.lName = lName;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	/**
	 * @param fName
	 * @param lName
	 * @param total
	 */
	public Patient(String fName, String lName, int total) { //used for priority queue
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
	 * @return the s1
	 */
	public String getS1() {
		return s1;
	}
	/**
	 * @param s1 the s1 to set
	 */
	public void setS1(String s1) {
		this.s1 = s1;
	}
	/**
	 * @return the s2
	 */
	public String getS2() {
		return s2;
	}
	/**
	 * @param s2 the s2 to set
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
	/**
	 * @return the s3
	 */
	public String getS3() {
		return s3;
	}
	/**
	 * @param s3 the s3 to set
	 */
	public void setS3(String s3) {
		this.s3 = s3;
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
		return "Patient [fName=" + fName + ", lName=" + lName + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + "]";
	}


}
