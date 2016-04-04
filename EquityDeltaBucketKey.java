package equity;

import containers.IRiskKey;
import containers.RiskFactory;
import containers.RiskInterBucketKey;
import staticdata.EQBucket;
import staticdata.RiskFactorClass;
import staticdata.SensitivityType;

public class EquityDeltaBucketKey 
implements  IRiskKey<EquityDeltaBucket, EquityDeltaBucketKey>
{
	protected RiskInterBucketKey riskinterbucketkey;
    protected EQBucket bucket;

    public EquityDeltaBucketKey( RiskFactory _factory,EQBucket _bucket)
    {
       
    	riskinterbucketkey= new RiskInterBucketKey(_factory,RiskFactorClass.Equity,SensitivityType.Delta);
        this.bucket = _bucket;
    }

    @Override
    public boolean Equals(EquityDeltaBucketKey other)
    {
        return (this.bucket==other.bucket);

    }
    
    @Override public boolean equals(Object obj){
		
    	EquityDeltaBucketKey other = (EquityDeltaBucketKey)obj;
		return other != null && this.Equals(other);
		
	}

    public RiskInterBucketKey Getriskinterbucketkey(){
    	
    	return riskinterbucketkey;
    }
    
    @Override public  int hashCode()
    {
        return this.bucket.hashCode()^EquityDeltaBucketKey.class.hashCode();
    }
    
    

	@Override
	public EquityDeltaBucket NewRiskFactor() {
		
		return new EquityDeltaBucket(this);
	}
	
	@Override
	public String GetString() {
		
		return riskinterbucketkey.GetString() + "_" + this.bucket.toString();
	}

}