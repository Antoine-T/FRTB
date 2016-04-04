package excellimport;

import java.util.Map;

import org.apache.poi.ss.usermodel.Row;

import CalculFRTB.Market;
import equity.EquityVegaRiskFactor;
import staticdata.EQBucket;
import staticdata.EQRiskFactorClass;
import staticdata.EQregion;
import staticdata.EQsector;
import staticdata.EQsize;
import staticdata.Option_Maturity;

public class ExcelInputEquityVega extends ExcelInput<InputEnumEquityVega> {


	private EQsize marketcap;
	private EQregion economy;
	private EQsector sector;
	private EQBucket bucket;
	private EQRiskFactorClass factorclass;
	private Option_Maturity optionmaturity;
	private String equityname;
	
	private Double Sensitivity;
	
	public ExcelInputEquityVega(SensitivitiesImportUtils _utils, Row _row, Map<String, Integer> _ColumnNames,
			Market _market) {
		super(_utils, _row, _ColumnNames, _market);
		this.KType=InputEnumEquityVega.class;
		
	}
	


	@Override
	protected boolean CheckDataIntegrity() {
		boolean test=true;
		
		try {
			marketcap = EQsize.valueOf(utils.Transform(this.GetInputField(InputEnumEquityVega.EQ_size,String.class)));
		} catch (Exception e) {
			test=false;
		}
		
		
		try {
			economy =EQregion.valueOf(utils.Transform(this.GetInputField(InputEnumEquityVega.EQ_region,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			sector =EQsector.valueOf(utils.Transform(this.GetInputField(InputEnumEquityVega.EQ_sector,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		bucket = EQBucket.GetEQBucket(marketcap, economy, sector);
		if (bucket==null) {
			test=false;
		}
		
		try {
			factorclass =EQRiskFactorClass.valueOf(utils.Transform(this.GetInputField(InputEnumEquityVega.EQ_RiskFactorClass,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			equityname =this.GetInputField(InputEnumEquityVega.EQ_RiskFactorClass,String.class);
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			optionmaturity =Option_Maturity.valueOf(utils.Transform("_"+ this.GetInputField(InputEnumEquityVega.Option_Maturity,String.class)));
		} catch (Exception e) {
			test=false;
		}
		
		try {
			Sensitivity = this.GetInputField(InputEnumEquityVega.Sensitivity,Double.class);
		} catch (Exception e) {
			test=false;
		}
		
		
		return test;
	}

	@Override
	protected boolean ImportSensitivity() {
		
		boolean test=true;
		
		try {
			
			EquityVegaRiskFactor equityvega = market.factory.GetEquityVega(bucket, factorclass, equityname,optionmaturity);
			this.market.myLog.log(java.util.logging.Level.INFO,"working on element : " + equityvega.Key().toString());

			equityvega.PushSensitivity(Sensitivity);
//			this.market.myLog.log(java.util.logging.Level.INFO,"Pushing  : " + Sensitivity.toString() + " to tenor : " + irtenor.toString());
			
			
		} catch (Exception e) {
			test=false;
		}
		
		return test;
	}

}
