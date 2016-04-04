package excellimport;


import java.util.Map;


import org.apache.poi.ss.usermodel.Row;

import CalculFRTB.Market;
import girr.GIRRCurvatureRiskFactor;
import staticdata.IRccy;


public class ExcelInputGIRRCurvature extends ExcelInput<InputEnumGIRRCurvature>{

	private IRccy currency;
	private Double curvaturedown;
	private Double curvatureup;
	
	
	public ExcelInputGIRRCurvature(SensitivitiesImportUtils _utils, Row _row, Map<String, Integer> _ColumnNames,
			Market _market) {
		super(_utils, _row, _ColumnNames, _market);
		this.KType=InputEnumGIRRCurvature.class;
	}
	
	
	@Override
	protected boolean CheckDataIntegrity() {
		
		boolean test=true;
		
		try {
			currency = IRccy.valueOf(utils.Transform(this.GetInputField(InputEnumGIRRCurvature.IR_ccy,String.class)));
		} catch (Exception e) {
			test=false;
		}
	
		try {
			curvaturedown = this.GetInputField(InputEnumGIRRCurvature.Curvature_Down,Double.class);
		} catch (Exception e) {
			test=false;
		}
		
		try {
			curvatureup = this.GetInputField(InputEnumGIRRCurvature.Curvature_Up,Double.class);
		} catch (Exception e) {
			test=false;
		}
		
		
		return test;
	}

	@Override
	protected boolean ImportSensitivity() {
		
		boolean test=true;
		
		try {
			
			GIRRCurvatureRiskFactor girrcurvature = market.factory.GetGIRRCurvature(currency);
			this.market.myLog.log(java.util.logging.Level.INFO,"working on element : " + girrcurvature.Key().toString());
			
			
			girrcurvature.PushCurve(curvatureup, curvaturedown);
			this.market.myLog.log(java.util.logging.Level.INFO,"Pushing  : " + curvaturedown.toString() + " to CurveDown and  " + curvatureup.toString() + " to CurveUp : ");
			
			
		} catch (Exception e) {
			test=false;
		}
		

		
		return test;
	}



}
