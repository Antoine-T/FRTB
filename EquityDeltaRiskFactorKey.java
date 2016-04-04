package equity;

import containers.IRiskKey;
import containers.IRiskSubKey;
import containers.RiskFactory;


import staticdata.EQBucket;
import staticdata.EQRiskFactorClass;


public class EquityDeltaRiskFactorKey 
implements IRiskKey<EquityDeltaRiskFactor, EquityDeltaRiskFactorKey>, 
IRiskSubKey<EquityDeltaBucketKey>
{
	
	protected EquityDeltaBucketKey equitydeltabucketkey;
	protected EQRiskFactorClass factorclass;
	protected String equityname;
	
	public EquityDeltaRiskFactorKey(RiskFactory _factory,EQBucket _bucket,EQRiskFactorClass _factorclass,String _equityname) 
	{
		this.equitydeltabucketkey=new EquityDeltaBucketKey(_factory,_bucket);
		this.factorclass = _factorclass;
		this.equityname=_equityname;
		
	}
	
	public EquityDeltaBucketKey Getequitydeltabucketkey(){
		
		return equitydeltabucketkey;
		
	}
	
	@Override public boolean Equals(EquityDeltaRiskFactorKey other) {
		
		return this.equitydeltabucketkey.Equals(other.equitydeltabucketkey)&&(this.factorclass == other.factorclass)&&(this.equityname == other.equityname);
	}
	
	@Override public boolean equals(Object obj){
		
		EquityDeltaRiskFactorKey other = (EquityDeltaRiskFactorKey)obj;
		return other != null && this.Equals(other);
		
	}
	
	@Override public int hashCode()
	{
		
	    return this.equitydeltabucketkey.hashCode()^this.factorclass.hashCode()^this.equityname.hashCode()^EquityDeltaRiskFactorKey.class.hashCode();
	}
	
	
	@Override
	public EquityDeltaRiskFactor NewRiskFactor() {
		return new EquityDeltaRiskFactor(this);
	}
	
	
	
	
	@Override
	public EquityDeltaBucketKey GetSuperKey() {
		return this.equitydeltabucketkey;
	}
	
	@Override
	public String GetString() {
	
		return equitydeltabucketkey.GetString() + "_" + this.factorclass.toString() + "_" + this.equityname.toString()  ;
	}
	
	
	



}