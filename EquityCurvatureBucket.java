package equity;

import containers.CurvatureRiskBucket;
import containers.IRisk;


public class EquityCurvatureBucket 
extends CurvatureRiskBucket<EquityCurvatureRiskFactor,EquityCurvatureRiskFactorKey>
implements  IRisk<EquityCurvatureBucket, EquityCurvatureBucketKey>{

	
	protected EquityCurvatureBucketKey key;
	protected EquityCalculator calculator;
	
	public EquityCurvatureBucket(EquityCurvatureBucketKey _key){
		
		key=_key;
		calculator=key.Getriskinterbucketkey().Getglobalriskkey().GetFactory().Getequitycalculator();
		
	}
	
	@Override
	public EquityCurvatureBucketKey Key() {
		
		return key;
	}

	@Override
	public Double GetCorrelation(EquityCurvatureBucket other) {

		return calculator.GetDeltaGamma(other.key.bucket,this.key.bucket);
	}

//	@Override
//	public Double GetCapitalStandAlone() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Double GetLinearStandAlone() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Double GetCapitalContribution() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Boolean ComputeStandAlone() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	


}