package Assessable_Activity;

public class ChessPlayer {
	//Attributes for ChessPlayers objects.
	private String id;
	private String fullname;
	private String country;
	private float score1;
	private float score2;
	private float score3;
	private float totalScore;
	
	//ChessPlayer constructor
	public ChessPlayer(String id, String fullname, String country, float score1, float score2, float score3) {
		this.id = id;
		this.fullname = fullname;
		this.country = country;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.totalScore = score1 + score2 + score3;
	}
	
	//Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public float getScore1() {
		return score1;
	}

	public void setScore1(float score1) {
		this.score1 = score1;
	}

	public float getScore2() {
		return score2;
	}

	public void setScore2(float score2) {
		this.score2 = score2;
	}

	public float getScore3() {
		return score3;
	}

	public void setScore3(float score3) {
		this.score3 = score3;
	}
	
	//Method to return a String with the data of a ChessPlayer instance.
	@Override
	public String toString() {
		return  this.id + "," +  this.fullname + "," +  this.country + "," + this.score1 + "," + this.score2 + "," + this.score3 + "," + this.totalScore + "\n";
	}	
}
