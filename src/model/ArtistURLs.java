package model;
//	{
//		  "response": {
//		    "status": {
//		      "code": "0",
//		      "message": "Success",
//		      "version": "4.2"
//		    },
//		    "urls": {
//		        "myspace_url": "http://www.myspace.com/radiohead",
//		        "lastfm_url": "http://www.last.fm/music/Radiohead",
//		        "mb_url": "http://musicbrainz.org/artist/a74b1b7f-71a5-4011-9441-d0b5e4122711.html",
//		        "wikipedia_url": "http://en.wikipedia.org/wiki/Radiohead",
//		        "official_url": "http://radiohead.com"
//		    }
//		  }
//		}

public class ArtistURLs {
	private String myspace_url;
	private String lastfm_url;
	private String mb_url;
	private String wikipedia_url;
	private String official_url;
	private String twitter_url;
	public String getMyspace_url() {
		return myspace_url;
	}
	public void setMyspace_url(String myspace_url) {
		this.myspace_url = myspace_url;
	}
	public String getLastfm_url() {
		return lastfm_url;
	}
	public void setLastfm_url(String lastfm_url) {
		this.lastfm_url = lastfm_url;
	}
	public String getMb_url() {
		return mb_url;
	}
	public void setMb_url(String mb_url) {
		this.mb_url = mb_url;
	}
	public String getWikipedia_url() {
		return wikipedia_url;
	}
	public void setWikipedia_url(String wikipedia_url) {
		this.wikipedia_url = wikipedia_url;
	}
	public String getOfficial_url() {
		return official_url;
	}
	public void setOfficial_url(String official_url) {
		this.official_url = official_url;
	}
	public String getTwitter_url() {
		return twitter_url;
	}
	public void setTwitter_url(String twitter_url) {
		this.twitter_url = twitter_url;
	}
	@Override
	public String toString() {
		return "ArtistURLs [myspace_url=" + myspace_url + ", lastfm_url=" + lastfm_url + ", mb_url=" + mb_url
				+ ", wikipedia_url=" + wikipedia_url + ", official_url=" + official_url + ", twitter_url=" + twitter_url
				+ "]";
	}
	

}
