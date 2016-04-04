package girr;

import java.util.Map;

import staticdata.IRccy;
import staticdata.IRCurveType;
import staticdata.IRTenor;
public class GIRRCalculator {
	
	protected double x;
	protected double theta;
	protected double gamma;
	protected double lh;
	protected double rw;
	protected double alpha;
	protected Map<IRTenor,Double> weights;
	
	
	protected double rwk;
	
	public GIRRCalculator(double _x,double _theta,double _gamma,double _lh,	double _rw,	double _alpha, Map<IRTenor,Double> _weights){
		x=_x;
		theta=_theta;
		gamma=_gamma;
		lh=_lh;
		rw=_rw;
		alpha = _alpha;
		weights=_weights;
		
		rwk=Math.min(rw*Math.sqrt(lh/10.0),1.0);
		
	}
	
	
	public double GetDeltaGamma(){
		
		return gamma;
	}
	
	public double GetVegaGamma(){
		
		//return 0.5*gamma;
		return gamma;
	}
	
	public double GetCurvatureGamma(){
		
		return gamma*gamma;
	}
	
	public double GetDeltaWeight(IRTenor irtenor,IRccy currency){
		
		double partial =weights.get(irtenor);
		
		if (currency.IsBCBS) {
			partial/=Math.sqrt(2);
		}
		
		return partial;
	}
	
	public double GetVegaWeight(){
		
		return rwk;
	}
	
	
	public double GetDeltaCorrelation_correc(IRTenor tenor1, IRTenor tenor2,IRCurveType ircurvetype1,IRCurveType ircurvetype2){
		
		double correl=0.0;

		if ((ircurvetype1==IRCurveType.XCCY_basis__USD)||(ircurvetype2==IRCurveType.XCCY_basis__USD)){
			correl=(tenor1==tenor2) ? 1.0 : 0.0;
		}else if ((ircurvetype1==IRCurveType.inflation)||(ircurvetype2==IRCurveType.inflation)) {
			correl=	(tenor1==tenor2) ? 1.0 : 0.4;
		}else {
			correl=  Math.max(0.4,Math.exp(-this.theta*Math.abs(tenor1.tenordouble-tenor2.tenordouble)/Math.min(tenor1.tenordouble, tenor2.tenordouble))) ;
			if ( ! ircurvetype1.equals(ircurvetype2)) {
				correl*=1-x;
			}
		}
	
		return correl;
	}

	
	public double GetDeltaCorrelation(IRTenor tenor1, IRTenor tenor2,IRCurveType ircurvetype1,IRCurveType ircurvetype2){
		
		double correl=0.0;

		if ((tenor1==IRTenor._XCCY_basis__USD)||(tenor2==IRTenor._XCCY_basis__USD)){
			correl=(tenor1==tenor2) ? 1.0 : 0.0;
		}else if ((tenor1==IRTenor._inflation)||(tenor2==IRTenor._inflation)) {
			correl=	(tenor1==tenor2) ? 1.0 : 0.4/(1-x);
		}else {
			correl=  Math.max(0.4,Math.exp(-this.theta*Math.abs(tenor1.tenordouble-tenor2.tenordouble)/Math.min(tenor1.tenordouble, tenor2.tenordouble))) ;
		}
	
		
		if ( ! ircurvetype1.equals(ircurvetype2)) {
			correl*=1-x;
		}
		
		return correl;
	}

	
	public double GetVegaCorrelation_correc(double tenor1, double tenor2,double optionmaturity1, double optionmaturity2){
		
		double correloptionmaturity = Math.exp(-this.alpha*Math.abs(optionmaturity1-optionmaturity2)/Math.min(optionmaturity1, optionmaturity2));
		double correlunderlyingmaturity = Math.exp(-this.alpha*Math.abs(tenor1-tenor2)/Math.min(tenor1, tenor2));
		
		return Math.min(correloptionmaturity*correlunderlyingmaturity, 1.0);
	}
	
	public double GetVegaCorrelation(double tenor1, double tenor2,double optionmaturity1, double optionmaturity2){
		
		double correloptionmaturity = Math.exp(-this.alpha*Math.abs(optionmaturity1-optionmaturity2)/Math.min(optionmaturity1, optionmaturity2));
		double correlunderlyingmaturity = Math.exp(-this.theta*Math.abs(tenor1-tenor2)/Math.min(tenor1, tenor2));
		
		return Math.min(correloptionmaturity*correlunderlyingmaturity, 1.0);
	}
	
	public double GetCurvatureCorrelation(){

		
		return 1.0;
	}
	
}
