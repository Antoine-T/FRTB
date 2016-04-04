package equity;

import containers.IRiskKey;
import containers.IRiskSubKey;
import containers.RiskFactory;
import staticdata.EQBucket;
import staticdata.EQRiskFactorClass;
import staticdata.Option_Maturity;

public class EquityVegaRiskFactorKey implements IRiskKey<EquityVegaRiskFactor, EquityVegaRiskFactorKey>, 
IRiskSubKey<EquityVegaBucketKey>
{
	
	protected EquityVegaBucketKey equityvegabucketkey;
	protected EQRiskFactorClass factorclass;
	protected String equityname;
	protected Option_Maturity optionmaturity;
	
	public EquityVegaRiskFactorKey(RiskFactory _factory,EQBucket _bucket,EQRiskFactorClass _factorclass,String _equityname,Option_Maturity _optionmaturity) 
	{
		this.equityvegabucketkey=new EquityVegaBucketKey(_factory,_bucket);
		this.factorclass = _factorclass;
		this.equityname=_equityname;
		this.optionmaturity=_optionmaturity;
		
	}
	
	public EquityVegaBucketKey Getequityvegabucketkey(){
		
		return equityvegabucketkey;
		
	}
	
	@Override public boolean Equals(EquityVegaRiskFactorKey other) {
		
		return this.equityvegabucketkey.Equals(other.equityvegabucketkey)&&(this.factorclass == other.factorclass)&&(this.equityname == other.equityname)&&(this.optionmaturity == other.optionmaturity);
	}
	
	@Override public boolean equals(Object obj){
		
		EquityVegaRiskFactorKey other = (EquityVegaRiskFactorKey)obj;
		return other != null && this.Equals(other);
		
	}
	
	@Override public int hashCode()
	{
		
	    return this.equityvegabucketkey.hashCode()^this.factorclass.hashCode()^this.equityname.hashCode()^this.optionmaturity.hashCode()^EquityDeltaRiskFactorKey.class.hashCode();
	}
	
	
	@Override
	public EquityVegaRiskFactor NewRiskFactor() {
		return new EquityVegaRiskFactor(this);
	}
	
	
	
	
	@Override
	public EquityVegaBucketKey GetSuperKey() {
		return this.equityvegabucketkey;
	}
	
	@Override
	public String GetString() {
	
		return equityvegabucketkey.GetString() + "_" + this.factorclass.toString() + "_" + this.equityname.toString() + "_" + this.optionmaturity.toString() ;
	}
	
	
	



}