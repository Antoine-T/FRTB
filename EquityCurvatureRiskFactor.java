package equity;

import containers.CurvatureRiskFactor;
import containers.IRisk;

public class EquityCurvatureRiskFactor extends CurvatureRiskFactor 
implements  IRisk<EquityCurvatureRiskFactor, EquityCurvatureRiskFactorKey>
{


protected EquityCurvatureRiskFactorKey key;
protected EquityCalculator calculator;

	
	public EquityCurvatureRiskFactor(EquityCurvatureRiskFactorKey _key)
	{
		this.key = _key;
		calculator=key.Getequitycurvaturebucketkey().Getriskinterbucketkey().Getglobalriskkey().GetFactory().Getequitycalculator();
	    
	}
	
	
	
	
	@Override
	public EquityCurvatureRiskFactorKey Key() {
		
		return key;
	}
	
	@Override
	public Double GetCorrelation(EquityCurvatureRiskFactor other) {
	
		return 0.0;
	}
	
	
	
	





	@Override
	public Double GetCapitalStandAlone() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Double GetLinearStandAlone() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Double GetCapitalContribution() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Boolean ComputeStandAlone() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}