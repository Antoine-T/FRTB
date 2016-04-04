package equity;

import containers.IRisk;
import containers.LinearRiskFactor;

public class EquityVegaRiskFactor extends LinearRiskFactor 
implements  IRisk<EquityVegaRiskFactor, EquityVegaRiskFactorKey>
{


protected EquityVegaRiskFactorKey key;
protected EquityCalculator calculator;

	
	public EquityVegaRiskFactor(EquityVegaRiskFactorKey _key)
	{
		this.key = _key;
		calculator=key.Getequityvegabucketkey().Getriskinterbucketkey().Getglobalriskkey().GetFactory().Getequitycalculator();
	    
	}
	
	
	
	
	@Override
	public EquityVegaRiskFactorKey Key() {
		
		return key;
	}
	
	@Override
	public Double GetCorrelation(EquityVegaRiskFactor other) {
	
		return 0.0;
	}
	
	
	
	
	
	@Override
	public double GetWeight() {
		return 0;
		
	
	}
	
	

}
