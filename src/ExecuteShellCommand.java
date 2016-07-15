import java.io.*; 

    public class ExecuteShellCommand
    { 
        public static void main(String args[]) 
        { 
        	int numDash = 61;
    		//61
    		String dash = "";
    		for(int i =0; i < numDash; i++){
    			dash +="-";
    		}
    		
    		String e_base = "e||" + dash;
    		String B_base = "B||" + dash;
    		String G_base = "G||" + dash;
    		String D_base = "D||" + dash;
    		String A_base = "A||" + dash;
    		String E_base = "E||" + dash;
    		
    		System.out.println(e_base);
    		System.out.println(B_base);
    		System.out.println(G_base);
    		System.out.println(D_base);
    		System.out.println(A_base);
    		System.out.println(E_base);
    		

        } 
    }