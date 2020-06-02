package no.hvl.dat102;

public class Student {
	private int snr;
	private String navn;
	
	public Student(int snr, String navn) {
		this.snr = snr;
		this.navn = navn;
	}
	
	public boolean equals(Student stud) {
		if (this == stud)
			return true;
		
		if (this.snr == stud.snr && this.navn.equals(stud.navn))
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return (this.snr + this.navn.hashCode());
		
	}
}
