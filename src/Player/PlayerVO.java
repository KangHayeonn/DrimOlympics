package Player;

public class PlayerVO {
	private String Carrier;
	private String Rank;


	public PlayerVO(String carrier, String rank) {

		this.Rank = rank;
		this.Carrier = carrier;
	}

	public String getCarrier() {
		return Carrier;
	}

	public void setCarrier(String carrier) {
		this.Carrier = carrier;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String rank) {
		Rank = rank;
	}

}