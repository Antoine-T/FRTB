package staticdata;


public enum InterBucketComputations {

	
	GIRRDelta(RiskFactorClass.GIRR,SensitivityType.Delta),
	GIRRVega(RiskFactorClass.GIRR,SensitivityType.Vega),
	GIRRCurvature(RiskFactorClass.GIRR,SensitivityType.Curvature),
	EQUITYDelta(RiskFactorClass.Equity,SensitivityType.Delta),
	EQUITYVega(RiskFactorClass.Equity,SensitivityType.Vega),
	EQUITYCurvature(RiskFactorClass.Equity,SensitivityType.Curvature);
	public RiskFactorClass riskfactorclass;
	public SensitivityType sensitivitytype;
	
	InterBucketComputations(RiskFactorClass _riskfactorclass,SensitivityType _sensitivitytype){
		
		riskfactorclass=_riskfactorclass;
		sensitivitytype=_sensitivitytype;
	}
}


	
	

