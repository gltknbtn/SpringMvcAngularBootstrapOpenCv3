package uaiContacts.vo;

public class Company {
	
	
	private String companyName;
	private String catagoryName;
	private int categoryValue;
	
	
	public Company(String companyName, String catagoryName, int categoryValue) {
		this.companyName = companyName;
		this.catagoryName = catagoryName;
		this.categoryValue = categoryValue;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCatagoryName() {
		return catagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	public int getCategoryValue() {
		return categoryValue;
	}
	public void setCategoryValue(int categoryValue) {
		this.categoryValue = categoryValue;
	}
	
	
	
	
}
