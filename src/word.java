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
		
		String test = tools.makeDash();
		
		// how many row's of tabs u can make
		int row = 0;
		int row_max = 10;
			
		String[] e_arr = new String[row_max];
		String[] B_arr = new String[row_max];
		String[] G_arr = new String[row_max];
		String[] D_arr = new String[row_max];
		String[] A_arr = new String[row_max];
		String[] E_arr = new String[row_max];
		
		String e_base = "e||";
		String B_base = "B||";
		String G_base = "G||";
		String D_base = "D||";
		String A_base = "A||";
		String E_base = "E||";
				
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Song Title: ");
		title_input = sc.nextLine();

		String input;
		
		String[] chord_loc = new String[6];
		for(int i = 0; i < chord_loc.length; i++){
			if(i == 0){
				chord_loc[i] = ">";
			}else{
				chord_loc[i] = " ";
			}
		}
		
		String[] tabs_loc = new String[21];
		for(int i = 0; i < tabs_loc.length; i++){
			if(i == 0){
				tabs_loc[i] = "    ";
			}else if( i == 1){
				tabs_loc[i] = "^^^";
			}else{
				tabs_loc[i] = "---";
			}
		}
		
		StringBuilder input_e = new StringBuilder("---");
		StringBuilder input_B = new StringBuilder("---");
		StringBuilder input_G = new StringBuilder("---");
		StringBuilder input_D = new StringBuilder("---");
		StringBuilder input_A = new StringBuilder("---");
		StringBuilder input_E = new StringBuilder("---");
		
		
		boolean done = false;
		int string_num = 6;
		int max_input = 20;
		int cur_loc = 1;
		
		while( !done && row < row_max)/*does not contain exit command*/{
			// print out which tab you are in in the future
			for(int string_loc = 0; string_loc < string_num; string_loc++){
				
				// print tabs to screen 
				tools.print(chord_loc, tabs_loc, row,
						e_base, B_base, G_base,
						D_base, A_base, E_base);
				
				switch (string_loc) {
					case 0:	System.out.print("Enter e: ");
							input = sc.nextLine();
							if(tools.validate(input)){
								//System.out.println("GOOD");
								input_e.replace(1, 2, input);
								e_base += input_e.toString();
							}else if(input.equals("")){
								e_base += input_e.toString();
							}else{
								while(!tools.validate(input) && !input.equals("")){
									//System.out.println("BAD");
									System.out.print("Enter e: ");
									input = sc.nextLine();
								}
								//System.out.println("GOOD");
								if(!input.equals(""))
									input_e.replace(1, 2, input);
								e_base += input_e.toString();
							}
							break;
							
					case 1:	System.out.print("Enter B: ");
							input = sc.nextLine();
							if(tools.validate(input)){
								//System.out.println("GOOD");
								input_B.replace(1, 2, input);
								B_base += input_B.toString();
							}else if(input.equals("")){
								B_base += input_B.toString();
							}else{
								while(!tools.validate(input) && !input.equals("")){
									//System.out.println("BAD");
									System.out.print("Enter B: ");
									input = sc.nextLine();
								}
								//System.out.println("GOOD");
								if(!input.equals(""))
									input_B.replace(1, 2, input);
								B_base += input_B.toString();
							}
							break;
							
					case 2:	System.out.print("Enter G: ");
							input = sc.nextLine();
							if(tools.validate(input)){
								//System.out.println("GOOD");
								input_G.replace(1, 2, input);
								G_base += input_G.toString();
							}else if(input.equals("")){
								G_base += input_G.toString();
							}else{
								while(!tools.validate(input) && !input.equals("")){
									//System.out.println("BAD");
									System.out.print("Enter G: ");
									input = sc.nextLine();
								}
								//System.out.println("GOOD");
								if(!input.equals(""))
									input_G.replace(1, 2, input);
								G_base += input_G.toString();
							}
							break;
							
					case 3:	System.out.print("Enter D: ");
							input = sc.nextLine();
							if(tools.validate(input)){
								//System.out.println("GOOD");
								input_D.replace(1, 2, input);
								D_base += input_D.toString();
							}else if(input.equals("")){
								D_base += input_D.toString();
							}else{
								while(!tools.validate(input) && !input.equals("")){
									//System.out.println("BAD");
									System.out.print("Enter D: ");
									input = sc.nextLine();
								}
								//System.out.println("GOOD");
								if(!input.equals(""))
									input_D.replace(1, 2, input);
								D_base += input_D.toString();
							}
							break;
							
					case 4:	System.out.print("Enter A: ");
							input = sc.nextLine();
							if(tools.validate(input)){
								//System.out.println("GOOD");
								input_A.replace(1, 2, input);
								A_base += input_A.toString();
							}else if(input.equals("")){
								A_base += input_A.toString();
							}else{
								while(!tools.validate(input) && !input.equals("")){
									//System.out.println("BAD");
									System.out.print("Enter A: ");
									input = sc.nextLine();
								}
								//System.out.println("GOOD");
								if(!input.equals(""))
									input_A.replace(1, 2, input);
								A_base += input_A.toString();
							}
							break;
							
					case 5:	System.out.print("Enter E: ");
							input = sc.nextLine();
							if(tools.validate(input)){
								//System.out.println("GOOD");
								input_E.replace(1, 2, input);
								E_base += input_E.toString();
							}else if(input.equals("")){
								E_base += input_E.toString();
							}else{
								while(!tools.validate(input) && !input.equals("")){
									//System.out.println("BAD");
									System.out.print("Enter E: ");
									input = sc.nextLine();
								}
								//System.out.println("GOOD");
								if(!input.equals(""))
									input_E.replace(1, 2, input);
								E_base += input_E.toString();
							}
							break;
			
					// gotta make a case for back
				}
			
				//System.out.print("repeat or next: ")
			
				if(string_loc == 5){
					// print tabs to screen 
					tools.print(chord_loc, tabs_loc, row,
							e_base, B_base, G_base,
							D_base, A_base, E_base);
				}
				
				// gotta write back here but doesnt work for 0 (just yet)
				// after all is done change locators
				if( string_loc != 5){
					chord_loc[string_loc] = " ";
					chord_loc[string_loc+1] = ">";
				}else{
					chord_loc[string_loc] = " ";
					chord_loc[0] = ">";
				}
			}
			
			// for loop ends
			// ask for next set or option to repeat or finish
			input = "";
			do{
				if(tools.validate_in(input))
					System.out.println("BAD");
				System.out.print("(c)opy, (n)ext or (d)one: ");
				input = sc.nextLine();
			}while(tools.validate_in(input));

			
			
			// this needs more work i need to set counters
			// create a method for print statements?
			while(input.equals("c") || input.equals("C")){
				if(input.equals("c") || input.equals("C")){
					e_base += input_e.toString();
					B_base += input_B.toString();
					G_base += input_G.toString();
					D_base += input_D.toString();
					A_base += input_A.toString();
					E_base += input_E.toString();	
					
					
					tabs_loc[cur_loc] = "---";
					cur_loc++;
					tabs_loc[cur_loc] = "^^^";
					
				}
				
				// print tabs to screen 
				tools.print(chord_loc, tabs_loc, row,
						e_base, B_base, G_base,
						D_base, A_base, E_base);
				
				if(tabs_loc[tabs_loc.length-1].equals("^^^")){
					
					
					
					e_arr[row] = e_base;
					B_arr[row] = B_base;
					G_arr[row] = G_base;
					D_arr[row] = D_base;
					A_arr[row] = A_base;
					E_arr[row] = E_base;
					row++;
					
					e_base = "e||";
					B_base = "B||";
					G_base = "G||";
					D_base = "D||";
					A_base = "A||";
					E_base = "E||";
					
					cur_loc = 1;
					tabs_loc[cur_loc] = "^^^";
					tabs_loc[tabs_loc.length-1] = "---";
				}
				
				
				System.out.print("(c)opy, (n)ext or (d)one: ");
				input = sc.nextLine();
			}
			
			if(input.equals("n") || input.equals("N") ||  input.equals("")){
				tabs_loc[cur_loc] = "---";
				cur_loc++;
				tabs_loc[cur_loc] = "^^^";
				
				// reset
				input_e = new StringBuilder("---");
				input_B = new StringBuilder("---");
				input_G = new StringBuilder("---");
				input_D = new StringBuilder("---");
				input_A = new StringBuilder("---");
				input_E = new StringBuilder("---");
				
				if(tabs_loc[tabs_loc.length-1].equals("^^^")){
					e_arr[row] = e_base;
					B_arr[row] = B_base;
					G_arr[row] = G_base;
					D_arr[row] = D_base;
					A_arr[row] = A_base;
					E_arr[row] = E_base;
					row++;
					
					e_base = "e||";
					B_base = "B||";
					G_base = "G||";
					D_base = "D||";
					A_base = "A||";
					E_base = "E||";
					
					cur_loc = 1;
					tabs_loc[cur_loc] = "^^^";
					tabs_loc[tabs_loc.length-1] = "---";
				}
				
			}
			
			if(input.equals("d") || input.equals("D")){
				e_arr[row] = e_base;
				B_arr[row] = B_base;
				G_arr[row] = G_base;
				D_arr[row] = D_base;
				A_arr[row] = A_base;
				E_arr[row] = E_base;
				row++;
				
				done = true;
			}
			
			if(input.equals("nt") || input.equals("NT")){
				e_arr[row] = e_base;
				B_arr[row] = B_base;
				G_arr[row] = G_base;
				D_arr[row] = D_base;
				A_arr[row] = A_base;
				E_arr[row] = E_base;
				row++;
				
				e_base = "e||";
				B_base = "B||";
				G_base = "G||";
				D_base = "D||";
				A_base = "A||";
				E_base = "E||";
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
		
		
		for(int i = 0; i < row; i++){
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
