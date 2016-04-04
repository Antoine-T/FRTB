package girr;
import containers.IRiskKey;
import containers.IRiskSubKey;
import containers.RiskFactory;
import staticdata.IRccy;

public class GIRRCurvatureRiskFactorKey 
	implements IRiskKey<GIRRCurvatureRiskFactor,GIRRCurvatureRiskFactorKey>,
	IRiskSubKey<GIRRCurvatureBucketKey>
{

	
	protected GIRRCurvatureBucketKey girrcurvaturebucketkey;
	
	public GIRRCurvatureRiskFactorKey(RiskFactory _factory,IRccy _currency) 
    {
		this.girrcurvaturebucketkey= new GIRRCurvatureBucketKey(_factory,_currency);
    }

	public GIRRCurvatureBucketKey girrcurvaturebucketkey(){
		
		return girrcurvaturebucketkey;
		
	}
	
	
	@Override public boolean Equals(GIRRCurvatureRiskFactorKey other) {
		
		return this.girrcurvaturebucketkey.Equals(other.girrcurvaturebucketkey);
	}
	
	@Override public boolean equals(Object obj){
		
		GIRRCurvatureRiskFactorKey other = (GIRRCurvatureRiskFactorKey)obj;
		return other != null && this.Equals(other);
		
	}
	
	@Override public int hashCode()
    {
		
        return girrcurvaturebucketkey.hashCode()^GIRRCurvatureRiskFactorKey.class.hashCode();
    }


	@Override
	public GIRRCurvatureRiskFactor NewRiskFactor() {
		return new GIRRCurvatureRiskFactor(this);
	}
	



	@Override
	public GIRRCurvatureBucketKey GetSuperKey() {
		return this.girrcurvaturebucketkey;
	}

	@Override
	public String GetString() {
		return girrcurvaturebucketkey.GetString();
	}




}
