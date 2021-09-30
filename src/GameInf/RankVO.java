package GameInf;

public class RankVO {
	
	private String Country;
	private String Gold;
	private String Silver;
	private String Bronze;
	private String Sum;
	
	public RankVO(String country, String gold, String silver, String bronze, String sum) {
		this.Country = country;
		this.Gold = gold;
		this.Silver = silver;
		this.Bronze = bronze;
		this.Sum = sum;
	}
	
	/////////////////////

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getGold() {
		return Gold;
	}

	public void setGold(String gold) {
		Gold = gold;
	}

	/////////////////////
	
	public String getSilver() {
		return Silver;
	}

	public void setSilver(String silver) {
		Silver = silver;
	}

	public String getBronze() {
		return Bronze;
	}

	public void setBronze(String bronze) {
		Bronze = bronze;
	}

	public String getSum() {
		return Sum;
	}

	public void setSum(String sum) {
		Sum = sum;
	}
}
