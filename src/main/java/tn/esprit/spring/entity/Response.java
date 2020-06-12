package tn.esprit.spring.entity;

public class Response {
	private boolean status;
    private String details;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Response(boolean status, String details) {
		super();
		this.status = status;
		this.details = details;
	}
	public Response() {
		super();
	}

}
