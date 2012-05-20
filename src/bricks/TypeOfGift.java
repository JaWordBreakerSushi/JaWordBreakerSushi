package bricks;

public enum TypeOfGift {
	BALL		("./src/img/fortune_cookies.png"),
	LETTER		("./src/img/maki.png"),
	BONUS		("./src/img/fortune_cookies.png"),
	MAGIC		("./src/img/sushi.png"),
	TEMPORAL	("./src/img/onigiri.png"),
	FIXE		("./src/img/miso_fixe.png"),
	MOVABLE		("./src/img/miso_mobile.png"),
	PALET		("./src/img/palet.png");
	
private final String _url;
	
	private TypeOfGift(String url){
		this._url = url;
	}
	
	public String getUrl(){
		return _url;
	}
}
