
public class Artist {
	String name, song, numOfHits, ranking, url; // variables to store information from csv file
	
	public Artist() {
	}
	public void setName(String str) { // set the string to the variable
		name = str;
	}
	
	public String getName() { // return the variable name
		return name;
	}
	
	public void setSong(String str) { // set a song 
		song = str;
	}
	
	public String getSong() { // get song
		return song;
	}
	
	public void setHits(String str) { // set the # of hits for the song
		numOfHits = str;
	}
	
	public String getHits() {
		return numOfHits;
	}
	
	public void setRanking(String str) {
		ranking = str;
	}
	
	public String getRanking() {
		return ranking;
	}
	
	public void setUrl(String str) {
		url = str;
	}
	
	public String getUrl() {
		return url;
	}

	public String toString() {
		return getRanking() + "," + getSong() + "," + getName() + "," + getHits() + "," + "," + getUrl();
	}
}
