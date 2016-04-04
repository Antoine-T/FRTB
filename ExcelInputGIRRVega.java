package excellimport;

import java.util.Map;


import org.apache.poi.ss.usermodel.Row;

import CalculFRTB.Market;
import girr.GIRRVegaRiskFactor;
import staticdata.IRccy;
import staticdata.IRTenor;
import staticdata.Option_Maturity;

public class ExcelInputGIRRVega extends ExcelInput<InputEnumGIRRVega>{
	
	private IRccy currency;
	private Option_Maturity optionmaturity;
	private IRTenor irtenor;
	private Double Sensitivity;
	
	
	public ExcelInputGIRRVega(SensitivitiesImportUtils _utils, Row _row, Map<String, Integer> _ColumnNames,
			Market _market) {
		super(_utils, _row, _ColumnNames, _market);
		this.KType=InputEnumGIRRVega.class;
	}
	
	
	
	@Override
	protected boolean CheckDataIntegrity() {
		
		boolean test=true;
		
		
		try {
			currency = IRccy.valueOf(utils.Transform(this.GetInputField(InputEnumGIRRVega.IR_ccy,String.class)));
		} catch (Exception e) {
			test=false;
		}
		
		
		try {
			optionmaturity =Option_Maturity.valueOf(utils.Transform("_"+ this.GetInputField(InputEnumGIRRVega.Option_Maturity,String.class)));
		} catch (Exception e) {
			test=false;
		}
		
		try {
			irtenor =IRTenor.valueOf(utils.Transform("_"+ this.GetInputField(InputEnumGIRRVega.IR_tenor,String.class)));
		} catch (Exception e) {
			test=false;
		}
		
		try {
			Sensitivity = this.GetInputField(InputEnumGIRRVega.Sensitivity,Double.class);
		} catch (Exception e) {

			test=false;
		}
		
		
		return test;
	}

	@Override
	protected boolean ImportSensitivity() {
		
		boolean test=true;
		
		try {
			GIRRVegaRiskFactor girrvega = market.factory.GetGIRRVega(currency, optionmaturity,irtenor);
			this.market.myLog.log(java.util.logging.Level.INFO,"working on element : " + girrvega.Key().toString());
			
			girrvega.PushSensitivity(Sensitivity);
			this.market.myLog.log(java.util.logging.Level.INFO,"Pushing  : " + Sensitivity.toString() + " to tenorMaturityVega : " + irtenor.toString() + "_" + optionmaturity.toString()	 );
				
			
		} catch (Exception e) {
			test=false;
		}
		
		
		
		
		return test;
	}


	
	
	
	
	

}
