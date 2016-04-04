package staticdata;


public enum Currency {
	USD(true), EUR(true), JPY(true), GBP(true), AUD(true), CHF(true), CAD(true), SEK(true), HKD(false),NZD(false), KRW(false), SGD(false), MXN(false), NOK(false), ZAR(false), DKK(false), ILS(false), CNY(false), RUB(false), TRY(false), BRI(false), INR(false), PLN(false), TWD(false), HUF(false), MYR(false), CZK(false), THB(false), CLP(false), IDR(false), AED(false), ARS(false), BHD(false), BRL(false), COP(false), EGP(false), GHS(false), HRK(false), ISK(false), KWD(false), KZT(false), LTL(false), MAD(false), NGN(false), OMR(false), PEN(false), PHP(false), QAR(false), RON(false), SAR(false), TND(false), XAG(false), XAU(false), XGE(false), XPD(false), XPT
    (false), XSE(false), CRC(false), DZD(false), KES(false), LBP(false), LKR(false), TZS(false), UAH(false), UYU(false), WST(false), KRX(false), TWX(false), BRX(false), CNX(false), MXV(false), MYX(false), RPI(false), SGX(false), RUX(false), SKK(false), THX(false), UNK(false), VND(false);
	
	
	public boolean IsBCBS;
	
	Currency(boolean _IsBCBS){
		
		IsBCBS=_IsBCBS;
	}
	
	
}


