package excellimport;

import java.util.Map;

import org.apache.poi.ss.usermodel.Row;

import CalculFRTB.Market;
import equity.EquityCurvatureRiskFactor;
import staticdata.EQBucket;
import staticdata.EQRiskFactorClass;
import staticdata.EQregion;
import staticdata.EQsector;
import staticdata.EQsize;

public class ExcelInputEquityCurvature extends ExcelInput<InputEnumEquityCurvature> {


	private EQsize marketcap;
	private EQregion economy;
	private EQsector sector;
	private EQBucket bucket;
	private EQRiskFactorClass factorclass;
	private String equityname;
	
	private Double curvaturedown;
	private Double curvatureup;
	
	public ExcelInputEquityCurvature(SensitivitiesImportUtils _utils, Row _row, Map<String, Integer> _ColumnNames,
			Market _market) {
		super(_utils, _row, _ColumnNames, _market);
		this.KType=InputEnumEquityCurvature.class;
		
	}
	


	@Override
	protected boolean CheckDataIntegrity() {
		boolean test=true;
		
		try {
			marketcap = EQsize.valueOf(utils.Transform(this.GetInputField(InputEnumEquityCurvature.EQ_size,String.class)));
		} catch (Exception e) {
			test=false;
		}
		
		
		try {
			economy =EQregion.valueOf(utils.Transform(this.GetInputField(InputEnumEquityCurvature.EQ_region,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			sector =EQsector.valueOf(utils.Transform(this.GetInputField(InputEnumEquityCurvature.EQ_sector,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		bucket = EQBucket.GetEQBucket(marketcap, economy, sector);
		if (bucket==null) {
			test=false;
		}
		
		try {
			factorclass =EQRiskFactorClass.valueOf(utils.Transform(this.GetInputField(InputEnumEquityCurvature.EQ_RiskFactorClass,String.class)));
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			equityname =this.GetInputField(InputEnumEquityCurvature.EQ_RiskFactorClass,String.class);
		} catch (Exception e) {
	
			test=false;
		}
		
		try {
			curvaturedown = this.GetInputField(InputEnumEquityCurvature.Curvature_Down,Double.class);
		} catch (Exception e) {
			test=false;
		}
		
		try {
			curvatureup = this.GetInputField(InputEnumEquityCurvature.Curvature_Up,Double.class);
		} catch (Exception e) {
			test=false;
		}
		
		
		
		return test;
	}

	@Override
	protected boolean ImportSensitivity() {
		
		boolean test=true;
		
		try {
			
			EquityCurvatureRiskFactor equitycurvature = market.factory.GetEquityCurvature(bucket, factorclass, equityname);
			this.market.myLog.log(java.util.logging.Level.INFO,"working on element : " + equitycurvature.Key().toString());
			
			
			equitycurvature.PushCurve(curvatureup, curvaturedown);
			this.market.myLog.log(java.util.logging.Level.INFO,"Pushing  : " + curvaturedown.toString() + " to CurveDown and  " + curvatureup.toString() + " to CurveUp : ");
			
			
		} catch (Exception e) {
			test=false;
		}
		
		return test;
	}

}