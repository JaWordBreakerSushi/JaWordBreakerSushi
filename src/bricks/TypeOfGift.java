package bricks;

public enum TypeOfGift {
	BALL		("./src/img/maki.png"),
	LETTER		("./src/img/fortune_cookies.png"),
	BONUS		("./src/img/maki.png"),
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
