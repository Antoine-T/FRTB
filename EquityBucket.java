package staticdata;

public enum EquityBucket {
_1,_2,_3,_4,_5,_6,_7,_8,_9,_10,_11;
	
	public String getBucket(){
		return this.toString().substring(1);
	}
}
 