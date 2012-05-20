package bricks;

public enum TypeOfGift {
	BALL		("./src/img/maki.jpg"),
	LETTER		("./src/img/fortune_cookies.jpg"),
	BONUS		("./src/img/maki.jpg"),
	MAGIC		("./src/img/sushi.jpg"),
	TEMPORAL	("./src/img/onigiri.jpg"),
	FIXE		("./src/img/miso_fixe.jpg"),
	MOVABLE		("./src/img/miso_mobile.jpg"),
	PALET		("./src/img/palet.png");
	
private final String _url;
	
	private TypeOfGift(String url){
		this._url = url;
	}
	
	public String getUrl(){
		return _url;
	}
}
