import java.math.BigInteger;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

public class paragraphTools {
	
	public void setSingleLineSpacing(XWPFParagraph para) {
	    CTPPr ppr = para.getCTP().getPPr();
	    if (ppr == null) ppr = para.getCTP().addNewPPr();
	    CTSpacing spacing = ppr.isSetSpacing()? ppr.getSpacing() : ppr.addNewSpacing();
	    spacing.setAfter(BigInteger.valueOf(0));
	    spacing.setBefore(BigInteger.valueOf(0));
	    spacing.setLineRule(STLineSpacingRule.AUTO);
	    spacing.setLine(BigInteger.valueOf(240));
	}
	
	public String makeDash(){
		int numDash = 60;
		//61
		String dash = "";
		for(int i =0; i < numDash; i++){
			dash +="-";
		}
		return (dash);
	}
	
	public void print(String[] chord_loc, String[] tabs_loc, int row,
						String e_base, String B_base, String G_base,
						String D_base, String A_base, String E_base){
		System.out.println("Tab#: " + (row+1));
		System.out.println(chord_loc[0] + e_base);
		System.out.println(chord_loc[1] + B_base);
		System.out.println(chord_loc[2] + G_base);
		System.out.println(chord_loc[3] + D_base);
		System.out.println(chord_loc[4] + A_base);
		System.out.println(chord_loc[5] + E_base);
	
		for(int i = 0; i < tabs_loc.length; i++){
			System.out.print(tabs_loc[i]);
		}
		System.out.println();
	}
	
	public boolean validate(String s){
		if(s.length() != 1 ){
			return false;
		}
		
		if ("123456789x\\/hp".indexOf(s.charAt(0)) != -1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validate_in(String s){
		
		if(s.equals("")){
			return true;
		}
		
		if ("123456789x\\/hp".indexOf(s.charAt(0)) != -1){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	public boolean validate3(String s){
		
		boolean str = false;
		boolean fret = false;
		boolean fret2 = false;
		
		if(s.length() != 3 ){
			return false;
		}
		
		if ("EADGBe".indexOf(s.charAt(0)) != -1){
			str = true;
		}
		
		if ("1234567890".indexOf(s.charAt(1)) != -1){
			fret = true;
		}
		
		if ("1234567890".indexOf(s.charAt(2)) != -1){
			fret = true;
		}
		
		if(str && fret){
			return (true);
		}else{
			return (false);
		}
	}
}
