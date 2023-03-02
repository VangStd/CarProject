package com.java.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class BookServiceDTO {

	private String yourname;
	@Email(message = "Please enter conrect forma with '@' ex: abc@gmail.com ")
	private String youremail;
	private long serviceid;
	@NotBlank(message = "Please enter or choose Date")
	@Pattern(regexp = "[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}", message = "Date incorrect format ex: '03/29/2023'")
	private String date;
	@Pattern(regexp = "0[0-9]{9,11}", message = "Phone must have begin 0 and from 10 to 12 number")
	private String yourphone;
	private String note;

	public BookServiceDTO() {

	}

	public BookServiceDTO(String yourname, String youremail, long serviceid, String date, String yourphone,
			String note) {
		this.yourname = yourname;
		this.youremail = youremail;
		this.serviceid = serviceid;
		this.date = date;
		this.yourphone = yourphone;
		this.note = note;
	}

	public String getYourname() {
		return yourname;
	}

	public void setYourname(String yourname) {
		this.yourname = yourname;
	}

	public String getYouremail() {
		return youremail;
	}

	public void setYouremail(String youremail) {
		this.youremail = youremail;
	}

	public long getServiceid() {
		return serviceid;
	}

	public void setServiceid(long serviceid) {
		this.serviceid = serviceid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getYourphone() {
		return yourphone;
	}

	public void setYourphone(String yourphone) {
		this.yourphone = yourphone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
