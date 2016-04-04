package girr;


import containers.IRiskKey;
import containers.RiskFactory;
import containers.RiskInterBucketKey;
import staticdata.IRccy;
import staticdata.RiskFactorClass;
import staticdata.SensitivityType;

public class GIRRCurvatureBucketKey 
	implements IRiskKey<GIRRCurvatureBucket, GIRRCurvatureBucketKey>
{
	
	protected RiskInterBucketKey riskinterbucketkey;
	protected IRccy currency;

    public GIRRCurvatureBucketKey(RiskFactory _factory, IRccy _currency)
    {
        this.riskinterbucketkey=new RiskInterBucketKey(_factory,RiskFactorClass.GIRR,SensitivityType.Curvature);
        this.currency = _currency;
    }

    @Override public boolean Equals(GIRRCurvatureBucketKey other)
    {
        return (this.currency==other.currency);

    }

    
    @Override public  int hashCode()
    {
        return this.currency.hashCode()^GIRRCurvatureBucketKey.class.hashCode();
    }

	@Override
	public GIRRCurvatureBucket NewRiskFactor() {

		return new GIRRCurvatureBucket(this);
	}
    
	public RiskInterBucketKey Getriskinterbucketkey(){
    	
    	return riskinterbucketkey;
    }

	@Override
	public String GetString() {
		
		return riskinterbucketkey.GetString() + "_" + this.currency.toString();
	}
}

