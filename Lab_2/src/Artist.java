
public class Artist {
	String name, song, numOfHits, ranking, url, count; // variables to store information from csv file
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
	
	public String getHits() { // get number of hits
		return numOfHits;
	}
	
	public void setRanking(String str) { // set ranking
		ranking = str;
	}
	
	public String getRanking() { // get song ranking
		return ranking;
	}
	
	public void setUrl(String str) { // set url
		url = str;
	}
	
	public String getUrl() { // get url
		return url;
	}
	
	public void setCount(String x) {
		count = x;
	}
	
	public String getCount() {
		return count;
	}
	public String toString() { // returns a string of all information based on original csv file
		return getRanking() + "," + getSong() + "," + getName() + "," + getHits() + "," + getUrl();
	}
	
	public String twoString() { // returns a string of name of artist, all the songs names, and the number of appearances on the ranking
		return getName() + "," + getSong() + "," + getCount();
	}
}
