package girr;


import containers.IRiskKey;
import containers.RiskFactory;
import containers.RiskInterBucketKey;
import staticdata.IRccy;
import staticdata.RiskFactorClass;
import staticdata.SensitivityType;

public class GIRRVegaBucketKey 
implements  IRiskKey<GIRRVegaBucket, GIRRVegaBucketKey>
{
	protected RiskInterBucketKey riskinterbucketkey;
    protected IRccy currency;

    public GIRRVegaBucketKey( RiskFactory _factory,IRccy _currency)
    {
       
    	riskinterbucketkey= new RiskInterBucketKey(_factory,RiskFactorClass.GIRR,SensitivityType.Vega);
        this.currency = _currency;
    }
	

    public RiskInterBucketKey Getriskinterbucketkey(){
    	
    	return riskinterbucketkey;
    }

    @Override public boolean Equals(GIRRVegaBucketKey other)
    {
        return (this.currency==other.currency);

    }
    
    @Override public boolean equals(Object obj){
		
    	GIRRVegaBucketKey other = (GIRRVegaBucketKey)obj;
		return other != null && this.Equals(other);
		
	}
    
   
    
    @Override public  int hashCode()
    {
        return this.currency.hashCode()^GIRRVegaBucketKey.class.hashCode();
    }
    



	@Override
	public GIRRVegaBucket NewRiskFactor() {
	
		return new GIRRVegaBucket(this);
	}
	
	@Override
	public String GetString() {
		
		return riskinterbucketkey.GetString() + "_" + this.currency.toString();
	}

}

