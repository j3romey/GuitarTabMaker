import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.FileOutputStream;
import java.util.Scanner;

public class word {
	public static void main(String[] args) {
		paragraphTools tools = new paragraphTools();
		String title_input =  null;
		String capo_num = null;
		String tuning =  null;
		
		// how many row's of tabs u can make
		int index = 0;
		int index_max = 10;
		
		//how many guitar things per tabs
		int counter = 0;
		int counter_max = 61;
		
		String[] e_arr = new String[index_max];
		String[] B_arr = new String[index_max];
		String[] G_arr = new String[index_max];
		String[] D_arr = new String[index_max];
		String[] A_arr = new String[index_max];
		String[] E_arr = new String[index_max];
		
		String e_base = "e||";
		String B_base = "B||";
		String G_base = "G||";
		String D_base = "D||";
		String A_base = "A||";
		String E_base = "E||";
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Song Title: ");
		title_input = sc.nextLine();
		
		System.out.print("Enter Capo Location: ");
		capo_num = sc.nextLine();
		
		System.out.print("Enter Tuning: ");
		tuning = sc.nextLine();
		
		String input;
		String str = ""; // fix to be inputs
		
		String fret = "";
		boolean done = false;
		boolean dbl = false;
		while( !done && index < index_max)/*does not contain exit command*/{
			
			System.out.print("Enter Tabs: ");
			input = sc.nextLine();
			
			if(tools.validate2(input)){ /*check if input is a string*/
				str = ""+ input.charAt(0);
				fret = ""+ input.charAt(1);
				
				
				if(str.equals("e")){
					e_base += fret;
				}
				
				if(str.equals("B")){
					B_base += fret;
				}
				
				if(str.equals("G")){
					G_base += fret;
				}
				
				if(str.equals("D")){
					D_base += fret;
				}
				
				if(str.equals("A")){
					A_base += fret;
				}
				
				if(str.equals("E")){
					E_base += fret;
				}
				
				
			}else if(tools.validate3(input)){ /*check if input is a string*/
				str = "" + input.charAt(0);
				fret = "" +  input.charAt(1);
				fret += input.charAt(2);
			
				
				
				if(str.equals("e")){
					e_base += fret;
				}
				
				if(str.equals("B")){
					B_base += fret;
				}
				
				if(str.equals("G")){
					G_base += fret;
				}
				
				if(str.equals("D")){
					D_base += fret;
				}
				
				if(str.equals("A")){
					A_base += fret;
				}
				
				if(str.equals("E")){
					E_base += fret;
				}
				
				dbl = true;
				
				
			}else if(input.equals("n") && counter < counter_max) {
				
				if(e_base.length() == 3+counter){
					e_base += "-";
					if(dbl){
						e_base += "-";
					}
				}
				
				if(B_base.length() == 3+counter){
					B_base += "-";
					if(dbl){
						B_base += "-";
					}
				}
				
				if(G_base.length() == 3+counter){
					G_base += "-";
					if(dbl){
						G_base += "-";
					}
				}
				
				if(D_base.length() == 3+counter){
					D_base += "-";
					if(dbl){
						D_base += "-";
					}
				}
				
				if(A_base.length() == 3+counter){
					A_base += "-";
					if(dbl){
						A_base += "-";
					}
				}
				
				if(E_base.length() == 3+counter){
					E_base += "-";
					if(dbl){
						E_base += "-";
					}
				}
				
				if(dbl){
					dbl = false;
					counter++;
					counter++;
				}else{
					counter++;
				}
			}else if(input.equals("nt") || counter >= counter_max ){
				e_arr[index] = e_base;
				B_arr[index] = B_base;
				G_arr[index] = G_base;
				D_arr[index] = D_base;
				A_arr[index] = A_base;
				E_arr[index] = E_base;
				
				e_base = "e||";
				B_base = "B||";
				G_base = "G||";
				D_base = "D||";
				A_base = "A||";
				E_base = "E||";
				
				index++;
				counter = 0;
			}else if(input.equals("b") && counter != 0){
				
				e_base = e_base.substring(0, e_base.length()-1); // remove length by 1
				B_base = B_base.substring(0, B_base.length()-1); 
				G_base = G_base.substring(0, G_base.length()-1);
				D_base = D_base.substring(0, D_base.length()-1); 
				A_base = A_base.substring(0, A_base.length()-1);
				E_base = E_base.substring(0, E_base.length()-1);
				
			}else if(input.equals("d")){
				// increment counter here somewhere
				if(e_base.length() == 3+counter){
					e_base += "-";
				}
				
				if(B_base.length() == 3+counter){
					B_base += "-";
				}
				
				if(G_base.length() == 3+counter){
					G_base += "-";
				}
				
				if(D_base.length() == 3+counter){
					D_base += "-";
				}
				
				if(A_base.length() == 3+counter){
					A_base += "-";
				}
				
				if(E_base.length() == 3+counter){
					E_base += "-";
				}

				e_arr[index] = e_base;
				B_arr[index] = B_base;
				G_arr[index] = G_base;
				D_arr[index] = D_base;
				A_arr[index] = A_base;
				E_arr[index] = E_base;
				index++;
				
				
				done = true;
			}else{
							
				System.out.println("wrong command, try again");
				
			}
		}
		
		
		
		
		
		// Title Creator
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph title = document.createParagraph();
		XWPFRun run = title.createRun();
		run.setFontSize(12);
	    run.setFontFamily("Courier New");
	
		run.setText("Guitar Tab Maker");
		run.addBreak();
		run.setText("Title: " + title_input);
		run.addBreak();
		
		
		for(int i = 0; i < index; i++){
			run.addBreak();
			run.setText(e_arr[i]);
			run.addBreak();
			run.setText(B_arr[i]);
			run.addBreak();
			run.setText(G_arr[i]);
			run.addBreak();
			run.setText(D_arr[i]);
			run.addBreak();
			run.setText(A_arr[i]);
			run.addBreak();
			run.setText(E_arr[i]);
			run.addBreak();
		}
		
		
		
		
		
		try{
			FileOutputStream output = new FileOutputStream("test.docx");
			document.write(output);
			
			// close everything
			output.close();
			document.close();
			sc.close();
			System.out.println("SUCESS: DOCUMENT MADE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
