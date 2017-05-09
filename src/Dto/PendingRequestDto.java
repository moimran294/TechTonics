package Dto;

import java.sql.Date;

public class PendingRequestDto {

	
	
	private Date date;
	private String title;
	private String description;
	private String presenter;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPresenter() {
		return presenter;
	}
	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}
	public PendingRequestDto( Date date, String title, String description, String presenter) {
		super();
		
		this.date = date;
		this.title = title;
		this.description = description;
		this.presenter = presenter;
	}
	@Override
	public String toString() {
		return "PendingRequestDto [date=" + date + ", title=" + title + ", description="
				+ description + ", presenter=" + presenter + "]";
	}
	
}
