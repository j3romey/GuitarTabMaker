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
		int numDash = 61;
		//61
		String dash = "";
		for(int i =0; i < numDash; i++){
			dash +="-";
		}
		return (dash);
	}
	
	public boolean validate2(String s){
		
		boolean str = false;
		boolean fret = false;
		
		if(s.length() != 2 ){
			return false;
		}
		
		if ("EADGBe".indexOf(s.charAt(0)) != -1){
			str = true;
		}
		
		if ("123456789x\\/hp".indexOf(s.charAt(1)) != -1){
			fret = true;
		}
		if(str && fret){
			return (true);
		}else{
			return (false);
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
