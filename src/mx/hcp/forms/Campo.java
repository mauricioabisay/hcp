package mx.hcp.forms;

public class Campo {
	private String value;
	private boolean error;
	
	public Campo(String value) {
		this.value = value;
		this.error = false;
	}
	
	public Campo(String value, boolean error) {
		this.value = value;
		this.error = error;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
}