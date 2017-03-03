package nmsucs;

/**
 * Main function to perform pdf-> txt conversion
 * 
 * @author Cao
 *
 */
public class processMain {
	
	public static void main(String[] args) {
		
		String pdfFileDir = "";
		//String txtFileDir = "";
		if(args.length==0){
			//pdfFileDir = "data/pdf/P1--ICDE2008_ZhouP08/cited";
			//pdfFileDir = "data/pdf/P9/references";
			//pdfFileDir = "data/pdf/test";
			pdfFileDir = "data";
			//txtFileDir = "data/txt/P1--ICDE2008_ZhouP08/cited";
		}else if(args.length==1){
			pdfFileDir = args[0];
			//txtFileDir = args[1];
		}else{
			System.out.println("<1. input PDF file directory> <2. output txt file directory>");
			return;
		}
		pdfHandler ph = new pdfHandler();
		ph.batchPdfToText(pdfFileDir);
	}
}

