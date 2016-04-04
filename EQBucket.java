package staticdata;


public enum EQBucket {
	
	 Bucket1(EQsize.Large,EQregion.Emerging_market_economies,EQsector.Consumer_goods_and_services),
	 Bucket2(EQsize.Large,EQregion.Emerging_market_economies,EQsector.Telecommunications_industrials),
	 Bucket3(EQsize.Large,EQregion.Emerging_market_economies,EQsector.Basic_materials_energy),
	 Bucket4(EQsize.Large,EQregion.Emerging_market_economies,EQsector.Financials),
	 Bucket5(EQsize.Large,EQregion.Advanced_economies,EQsector.Consumer_goods_and_services),
	 Bucket6(EQsize.Large,EQregion.Advanced_economies,EQsector.Telecommunications_industrials),
	 Bucket7(EQsize.Large,EQregion.Advanced_economies,EQsector.Basic_materials_energy),
	 Bucket8(EQsize.Large,EQregion.Advanced_economies,EQsector.Financials),
	 Bucket9(EQsize.Small,EQregion.Emerging_market_economies,EQsector.All_sectors_small_only),
	 Bucket10(EQsize.Small,EQregion.Advanced_economies,EQsector.All_sectors_small_only),
	 Bucket11(EQsize.Other_sector,EQregion.Other_sector,EQsector.Other_sector);
	
	public EQsize MarketCap;
	protected EQregion Economy;
	protected EQsector Sector;
	
	EQBucket(EQsize _MarketCap,EQregion _Economy,EQsector _Sector){
		
		MarketCap=_MarketCap;
		Economy=_Economy;
		Sector=_Sector;
	}
	public EQregion getregion()
	{
		return this.Economy;
	}
	public EQsize getsize()
	{
		return this.MarketCap;
	}
	
	public static EQBucket GetEQBucket(EQsize _MarketCap,EQregion _Economy,EQsector _Sector){
	    
		switch (_MarketCap) {
		case Large:
			switch (_Economy) {
			case Emerging_market_economies:
				switch (_Sector) {
				case Consumer_goods_and_services:
					return Bucket1;
				case Telecommunications_industrials:
					return Bucket2;
				case Basic_materials_energy:
					return Bucket3;
				case Financials:
					return Bucket4;
				default:
					return null;
				}
			case Advanced_economies:
				switch (_Sector) {
				case Consumer_goods_and_services:
					return Bucket5;
				case Telecommunications_industrials:
					return Bucket6;
				case Basic_materials_energy:
					return Bucket7;
				case Financials:
					return Bucket8;
				default:
					return null;
				}
			default:
				return null;
			}
		case Small:
			switch (_Economy) {
			case Emerging_market_economies:
				switch (_Sector) {
				case All_sectors_small_only:
					return Bucket9;
				default:
					return null;
				}
			case Advanced_economies:
				switch (_Sector) {
				case All_sectors_small_only:
					return Bucket10;
				default:
					return null;
				}
			default:
				return null;
			}
		case Other_sector:
			switch (_Economy) {
			case Other_sector:
				switch (_Sector) {
				case Other_sector:
					return Bucket11;
				default:
					return null;
				}
			default:
				return null;
			}
		default:
			return null;
		}


	}
	public String getNom(){
		return (this.toString()).substring(6);
	}

}
