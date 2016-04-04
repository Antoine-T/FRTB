package excellimport;

import org.apache.poi.xssf.usermodel.XSSFCell;

public enum InputEnumEquityVega  implements ItoInt {
	
	EQ_size(XSSFCell.CELL_TYPE_STRING),
	EQ_region(XSSFCell.CELL_TYPE_STRING),
	EQ_sector(XSSFCell.CELL_TYPE_STRING),
	EQ_RiskFactorClass(XSSFCell.CELL_TYPE_STRING),
	EQ_Name(XSSFCell.CELL_TYPE_STRING),
	Option_Maturity(XSSFCell.CELL_TYPE_STRING),
	Sensitivity(XSSFCell.CELL_TYPE_NUMERIC);
	
	private int celltype;
	
	InputEnumEquityVega(int _celltype){
		
		celltype=_celltype;
	}
	
	@Override
	public int toInt() {

		return this.celltype;
	}

}
