package girr;


import containers.IRiskKey;
import containers.RiskFactory;
import containers.RiskInterBucketKey;
import staticdata.IRccy;
import staticdata.RiskFactorClass;
import staticdata.SensitivityType;

public class GIRRDeltaBucketKey 
	implements  IRiskKey<GIRRDeltaBucket, GIRRDeltaBucketKey>
{
	protected RiskInterBucketKey riskinterbucketkey;
    protected IRccy currency;

    public GIRRDeltaBucketKey( RiskFactory _factory,IRccy _currency)
    {
       
    	riskinterbucketkey= new RiskInterBucketKey(_factory,RiskFactorClass.GIRR,SensitivityType.Delta);
        this.currency = _currency;
    }

    @Override
    public boolean Equals(GIRRDeltaBucketKey other)
    {
        return (this.currency==other.currency);

    }
    
    @Override public boolean equals(Object obj){
		
    	GIRRDeltaBucketKey other = (GIRRDeltaBucketKey)obj;
		return other != null && this.Equals(other);
		
	}

    public RiskInterBucketKey Getriskinterbucketkey(){
    	
    	return riskinterbucketkey;
    }
    
    @Override public  int hashCode()
    {
        return this.currency.hashCode()^GIRRDeltaBucketKey.class.hashCode();
    }
    
    

	@Override
	public GIRRDeltaBucket NewRiskFactor() {
		
		return new GIRRDeltaBucket(this);
	}
	
	@Override
	public String GetString() {
		
		return riskinterbucketkey.GetString() + "_" + this.currency.toString();
	}

}
