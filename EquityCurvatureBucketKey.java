package equity;
import containers.IRiskKey;
import containers.RiskFactory;
import containers.RiskInterBucketKey;
import staticdata.EQBucket;
import staticdata.RiskFactorClass;
import staticdata.SensitivityType;


public class EquityCurvatureBucketKey implements  IRiskKey<EquityCurvatureBucket, EquityCurvatureBucketKey>
{
	protected RiskInterBucketKey riskinterbucketkey;
    protected EQBucket bucket;

    public EquityCurvatureBucketKey( RiskFactory _factory,EQBucket _bucket)
    {
       
    	riskinterbucketkey= new RiskInterBucketKey(_factory,RiskFactorClass.Equity,SensitivityType.Delta);
        this.bucket = _bucket;
    }

    @Override
    public boolean Equals(EquityCurvatureBucketKey other)
    {
        return (this.bucket==other.bucket);

    }
    
    @Override public boolean equals(Object obj){
		
    	EquityCurvatureBucketKey other = (EquityCurvatureBucketKey)obj;
		return other != null && this.Equals(other);
		
	}

    public RiskInterBucketKey Getriskinterbucketkey(){
    	
    	return riskinterbucketkey;
    }
    
    @Override public  int hashCode()
    {
        return this.bucket.hashCode()^EquityCurvatureBucketKey.class.hashCode();
    }
    
    

	@Override
	public EquityCurvatureBucket NewRiskFactor() {
		
		return new EquityCurvatureBucket(this);
	}
	
	@Override
	public String GetString() {
		
		return riskinterbucketkey.GetString() + "_" + this.bucket.toString();
	}

}