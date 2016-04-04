package equity;

import containers.IRisk;
import containers.LinearRiskFactor;

public class EquityDeltaRiskFactor 
extends LinearRiskFactor 
implements  IRisk<EquityDeltaRiskFactor, EquityDeltaRiskFactorKey>
{


protected EquityDeltaRiskFactorKey key;
protected EquityCalculator calculator;

	
	public EquityDeltaRiskFactor(EquityDeltaRiskFactorKey _key)
	{
		this.key = _key;
		calculator=key.Getequitydeltabucketkey().Getriskinterbucketkey().Getglobalriskkey().GetFactory().Getequitycalculator();
	    
	}
	
	
	
	
	@Override
	public EquityDeltaRiskFactorKey Key() {
		
		return key;
	}
	
	@Override
	public Double GetCorrelation(EquityDeltaRiskFactor other) {
	
		return calculator.GetDeltaCorrelation(this.key.Getequitydeltabucketkey().bucket,this.key.factorclass,other.key.factorclass);
	}
	
	
	
	
	
	@Override
	public double GetWeight() {
		return calculator.GetDeltaWeight(this.key.Getequitydeltabucketkey().bucket);
		
	}
	
	

}
