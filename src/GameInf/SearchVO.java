package GameInf;

public class SearchVO {	
	private String Title;
	private String Content;
	
	public SearchVO(String title, String content) {
		this.Title = title;
		this.Content = content;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public String getContent() {
		return Content;
	}
	
	public void setTitle(String title) {
		Title = title;
	}

	public void setContent(String content) {
		Content = content;
	}

}