package excellimport;

import org.apache.poi.xssf.usermodel.XSSFCell;

public enum InputEnumEquityCurvature  implements ItoInt {
	
	EQ_size(XSSFCell.CELL_TYPE_STRING),
	EQ_region(XSSFCell.CELL_TYPE_STRING),
	EQ_sector(XSSFCell.CELL_TYPE_STRING),
	EQ_RiskFactorClass(XSSFCell.CELL_TYPE_STRING),
	EQ_Name(XSSFCell.CELL_TYPE_STRING),
	
	Curvature_Up(XSSFCell.CELL_TYPE_NUMERIC),
	Curvature_Down(XSSFCell.CELL_TYPE_NUMERIC);
	
	private int celltype;
	
	InputEnumEquityCurvature(int _celltype){
		
		celltype=_celltype;
	}
	
	@Override
	public int toInt() {

		return this.celltype;
	}

}
