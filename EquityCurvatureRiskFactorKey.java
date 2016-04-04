package equity;

import containers.IRiskKey;
import containers.IRiskSubKey;
import containers.RiskFactory;
import staticdata.EQBucket;
import staticdata.EQRiskFactorClass;

public class EquityCurvatureRiskFactorKey 
implements IRiskKey<EquityCurvatureRiskFactor, EquityCurvatureRiskFactorKey>, 
IRiskSubKey<EquityCurvatureBucketKey>
{
	
	protected EquityCurvatureBucketKey equitycurvaturebucketkey;
	protected EQRiskFactorClass factorclass;
	protected String equityname;
	
	public EquityCurvatureRiskFactorKey(RiskFactory _factory,EQBucket _bucket,EQRiskFactorClass _factorclass,String _equityname) 
	{
		this.equitycurvaturebucketkey=new EquityCurvatureBucketKey(_factory,_bucket);
		this.factorclass = _factorclass;
		this.equityname=_equityname;
		
	}
	
	public EquityCurvatureBucketKey Getequitycurvaturebucketkey(){
		
		return equitycurvaturebucketkey;
		
	}
	
	@Override public boolean Equals(EquityCurvatureRiskFactorKey other) {
		
		return this.equitycurvaturebucketkey.Equals(other.equitycurvaturebucketkey)&&(this.factorclass == other.factorclass)&&(this.equityname == other.equityname);
	}
	
	@Override public boolean equals(Object obj){
		
		EquityCurvatureRiskFactorKey other = (EquityCurvatureRiskFactorKey)obj;
		return other != null && this.Equals(other);
		
	}
	
	@Override public int hashCode()
	{
		
	    return this.equitycurvaturebucketkey.hashCode()^this.factorclass.hashCode()^this.equityname.hashCode()^EquityDeltaRiskFactorKey.class.hashCode();
	}
	
	
	@Override
	public EquityCurvatureRiskFactor NewRiskFactor() {
		return new EquityCurvatureRiskFactor(this);
	}
	
	
	
	
	@Override
	public EquityCurvatureBucketKey GetSuperKey() {
		return this.equitycurvaturebucketkey;
	}
	
	@Override
	public String GetString() {
	
		return equitycurvaturebucketkey.GetString() + "_" + this.factorclass.toString() + "_" + this.equityname.toString()  ;
	}
	
	
	



}