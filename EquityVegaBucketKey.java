package equity;

import containers.IRiskKey;
import containers.RiskFactory;
import containers.RiskInterBucketKey;
import staticdata.EQBucket;
import staticdata.RiskFactorClass;
import staticdata.SensitivityType;

public class EquityVegaBucketKey implements  IRiskKey<EquityVegaBucket, EquityVegaBucketKey>
{
	protected RiskInterBucketKey riskinterbucketkey;
    protected EQBucket bucket;

    public EquityVegaBucketKey( RiskFactory _factory,EQBucket _bucket)
    {
       
    	riskinterbucketkey= new RiskInterBucketKey(_factory,RiskFactorClass.Equity,SensitivityType.Vega);
        this.bucket = _bucket;
    }

    @Override
    public boolean Equals(EquityVegaBucketKey other)
    {
        return (this.bucket==other.bucket);

    }
    
    @Override public boolean equals(Object obj){
		
    	EquityVegaBucketKey other = (EquityVegaBucketKey)obj;
		return other != null && this.Equals(other);
		
	}

    public RiskInterBucketKey Getriskinterbucketkey(){
    	
    	return riskinterbucketkey;
    }
    
    @Override public  int hashCode()
    {
        return this.bucket.hashCode()^EquityVegaBucketKey.class.hashCode();
    }
    
    

	@Override
	public EquityVegaBucket NewRiskFactor() {
		
		return new EquityVegaBucket(this);
	}
	
	@Override
	public String GetString() {
		
		return riskinterbucketkey.GetString() + "_" + this.bucket.toString();
	}

}