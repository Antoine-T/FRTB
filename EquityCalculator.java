package equity;

import java.util.Map;
import staticdata.EQsize;
import staticdata.CapiEconomie;
import staticdata.EQBucket;
import staticdata.EQRiskFactorClass;
import staticdata.EQregion;

public class EquityCalculator {

	protected double x;
	protected double gamma;
	protected double rw;
	protected double alpha;
	protected double small_LH;
	protected double big_LH;
	protected Map<EQBucket,Double> weights;
	protected Map<CapiEconomie,Double> capi_eco;
	
	protected double rwk;
	
	public EquityCalculator(double _x,double _gamma,double _small_LH, double _big_LH,
			double _rw,	double _alpha,Map<EQBucket,Double> _weights,
			Map<CapiEconomie,Double> _capi_eco){
		x=_x;
		gamma=_gamma;
		rw=_rw;
		alpha = _alpha;
		small_LH =_small_LH;
		big_LH= _big_LH;
		weights=_weights;
		capi_eco=_capi_eco;

	}
	
	
	public double GetDeltaGamma(EQBucket bucket1, EQBucket bucket2){
			
		
		return (bucket1 == EQBucket.Bucket11 ||bucket2 == EQBucket.Bucket11)? 0: gamma ;
	}
	
	public double GetVegaGamma(){
		
		return gamma;
	}
	
	public double GetCurvatureGamma(){
		
		return gamma*gamma;
	}
	
	public double GetDeltaWeight(EQBucket bucket ){
		
		return weights.get(bucket);
	}
	
	public double GetVegaWeight(EQBucket bucket){
		
		return rwk=Math.min(rw*Math.sqrt(getLiquidity(bucket)/10.0),1.0);
	}
	public double getLiquidity(EQBucket bucket){
		return (bucket.getregion()==EQregion.Advanced_economies)? big_LH : small_LH;
	}
	

	
	public double GetDeltaCorrelation(EQBucket bucket, EQRiskFactorClass _EQRiskFactorClass1,EQRiskFactorClass _EQRiskFactorClass2){
		
		double correl=0.0;
		correl = (bucket.getregion()==EQregion.Advanced_economies) ? 
				(bucket.getsize()==EQsize.Large)? capi_eco.get(CapiEconomie.large_advanced):
					capi_eco.get(CapiEconomie.small_advanced) :
				(bucket.getsize()==EQsize.Large)?capi_eco.get(CapiEconomie.large_emerging) : 
					capi_eco.get(CapiEconomie.small_emerging);
				
		return correl=(_EQRiskFactorClass2 == _EQRiskFactorClass1) ? correl : correl*(1-x);
	}

	

	
	public double GetVegaCorrelation(EQBucket bucket, EQRiskFactorClass _EQRiskFactorClass1,EQRiskFactorClass _EQRiskFactorClass2,double optionmaturity1, double optionmaturity2){
		
		double correloptionmaturity = Math.exp(-this.alpha*Math.abs(optionmaturity1-optionmaturity2)/Math.min(optionmaturity1, optionmaturity2));
		
		return Math.min(correloptionmaturity*GetDeltaCorrelation(bucket,_EQRiskFactorClass1,_EQRiskFactorClass2), 1.0);
	}
	
	public double GetCurvatureCorrelation(){

		return 1.0;
	}
	
}

