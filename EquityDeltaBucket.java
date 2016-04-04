package equity;

import containers.IRisk;
import containers.LinearRiskBucket;


public class EquityDeltaBucket 
extends LinearRiskBucket<EquityDeltaRiskFactor,EquityDeltaRiskFactorKey>
implements  IRisk<EquityDeltaBucket, EquityDeltaBucketKey>{

	
	protected EquityDeltaBucketKey key;
	protected EquityCalculator calculator;
	
	public EquityDeltaBucket(EquityDeltaBucketKey _key){
		
		key=_key;
		calculator=key.Getriskinterbucketkey().Getglobalriskkey().GetFactory().Getequitycalculator();
		
	}
	
	@Override
	public EquityDeltaBucketKey Key() {
		
		return key;
	}

	@Override
	public Double GetCorrelation(EquityDeltaBucket other) {

		return calculator.GetDeltaGamma(other.key.bucket,this.key.bucket);
	}


}
