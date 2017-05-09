package Dto;

import java.sql.Date;

public class TechTalkDto {

	private int s_id;
	private Date date;
	private String title;
	private String description;
	private String presenter;
	
	public TechTalkDto(int s_id, Date date, String title, String description, String presenter) {
		super();
		this.s_id = s_id;
		this.date = date;
		this.title = title;
		this.description = description;
		this.presenter = presenter;
	}
	public TechTalkDto( Date date, String title, String description, String presenter) {
		super();
	
		this.date = date;
		this.title = title;
		this.description = description;
		this.presenter = presenter;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
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
	@Override
	public String toString() {
		return "TechTalkDto [s_id=" + s_id + ", date=" + date + ", title=" + title + ", description=" + description
				+ ", presenter=" + presenter + "]";
	}
	
	
	
}
