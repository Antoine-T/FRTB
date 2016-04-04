package excellimport;

import java.util.Map;

import org.apache.poi.ss.usermodel.Row;

import CalculFRTB.Market;
import equity.EquityDeltaRiskFactor;
import staticdata.EQBucket;
import staticdata.EQRiskFactorClass;
import staticdata.EQregion;
import staticdata.EQsector;
import staticdata.EQsize;


public class ExcelInputEquityDelta extends ExcelInput<InputEnumEquityDelta> {


	private EQsize marketcap;
	private EQregion economy;
	private EQsector sector;
	private EQBucket bucket;
	private EQRiskFactorClass factorclass;
	private String equityname;
	
	private Double Sensitivity;
	
	public ExcelInputEquityDelta(SensitivitiesImportUtils _utils, Row _row, Map<String, Integer> _ColumnNames,
			Market _market) {
		super(_utils, _row, _ColumnNames, _market);
		this.KType=InputEnumEquityDelta.class;
		
	}
	


	@Override
	protected boolean CheckDataIntegrity() {
		boolean test=true;
		
		try {
			marketcap = EQsize.valueOf(utils.Transform(this.GetInputField(InputEnumEquityDelta.EQ_size,String.class)));
		} catch (Exception e) {
			test=false;
		}
		
		
		try {
			economy =EQregion.valueOf(utils.Transform(this.GetInputField(InputEnumEquityDelta.EQ_region,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			sector =EQsector.valueOf(utils.Transform(this.GetInputField(InputEnumEquityDelta.EQ_sector,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		bucket = EQBucket.GetEQBucket(marketcap, economy, sector);
		if (bucket==null) {
			test=false;
		}
		
		try {
			factorclass =EQRiskFactorClass.valueOf(utils.Transform(this.GetInputField(InputEnumEquityDelta.EQ_RiskFactorClass,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			equityname =this.GetInputField(InputEnumEquityDelta.EQ_RiskFactorClass,String.class);
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			Sensitivity = this.GetInputField(InputEnumEquityDelta.Sensitivity,Double.class);
		} catch (Exception e) {
			test=false;
		}
		
		
		return test;
	}

	@Override
	protected boolean ImportSensitivity() {
		
		boolean test=true;
		
		try {
			
			EquityDeltaRiskFactor equitydelta = market.factory.GetEquityDelta(bucket, factorclass, equityname);
			this.market.myLog.log(java.util.logging.Level.INFO,"working on element : " + equitydelta.Key().toString());

			equitydelta.PushSensitivity(Sensitivity);
//			this.market.myLog.log(java.util.logging.Level.INFO,"Pushing  : " + Sensitivity.toString() + " to tenor : " + irtenor.toString());
			
			
		} catch (Exception e) {
			test=false;
		}
		
		return test;
	}

}
