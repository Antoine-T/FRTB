package equity;

import containers.IRisk;
import containers.LinearRiskBucket;

public class EquityVegaBucket extends LinearRiskBucket<EquityVegaRiskFactor,EquityVegaRiskFactorKey>
implements  IRisk<EquityVegaBucket, EquityVegaBucketKey>{

	
	protected EquityVegaBucketKey key;
	protected EquityCalculator calculator;
	
	public EquityVegaBucket(EquityVegaBucketKey _key){
		
		key=_key;
		calculator=key.Getriskinterbucketkey().Getglobalriskkey().GetFactory().Getequitycalculator();
		
	}
	
	@Override
	public EquityVegaBucketKey Key() {
		
		return key;
	}

	@Override
	public Double GetCorrelation(EquityVegaBucket other) {

		return calculator.GetDeltaGamma(this.key.bucket,other.key.bucket);
	}

	


}
