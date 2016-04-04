package excellimport;

import java.util.Map;


import org.apache.poi.ss.usermodel.Row;

import CalculFRTB.Market;
import girr.GIRRDeltaRiskFactor;
import staticdata.IRccy;
import staticdata.IRCurveType;
import staticdata.IRTenor;

public class ExcelInputGIRRDelta extends ExcelInput<InputEnumGIRRDelta> {

	
	private IRccy currency;
	private IRCurveType ircurvetype;
	private IRTenor irtenor;
	private Double Sensitivity;
	
	public ExcelInputGIRRDelta(SensitivitiesImportUtils _utils, Row _row, Map<String, Integer> _ColumnNames,
			Market _market) {
		super(_utils, _row, _ColumnNames, _market);
		this.KType=InputEnumGIRRDelta.class;
		
	}
	


	@Override
	protected boolean CheckDataIntegrity() {
		boolean test=true;
		
		try {
			currency = IRccy.valueOf(utils.Transform(this.GetInputField(InputEnumGIRRDelta.IR_ccy,String.class)));
		} catch (Exception e) {
			test=false;
		}
		
		
		try {
			ircurvetype =IRCurveType.valueOf(utils.Transform(this.GetInputField(InputEnumGIRRDelta.IR_curvetype,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			irtenor =IRTenor.valueOf(utils.Transform("_"+ this.GetInputField(InputEnumGIRRDelta.IR_tenor,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			Sensitivity = this.GetInputField(InputEnumGIRRDelta.Sensitivity,Double.class);
		} catch (Exception e) {
			test=false;
		}
		
		
		return test;
	}

	@Override
	protected boolean ImportSensitivity() {
		
		boolean test=true;
		
		try {
			
			GIRRDeltaRiskFactor girrdelta = market.factory.GetGIRRDelta(currency,ircurvetype ,irtenor);
			this.market.myLog.log(java.util.logging.Level.INFO,"working on element : " + girrdelta.Key().toString());

			girrdelta.PushSensitivity(Sensitivity);
//			this.market.myLog.log(java.util.logging.Level.INFO,"Pushing  : " + Sensitivity.toString() + " to tenor : " + irtenor.toString());
			
			
		} catch (Exception e) {
			test=false;
		}
		
		return test;
	}

}
