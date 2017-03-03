package nmsucs;
import org.apache.pdfbox.*;
import org.apache.pdfbox.cos.*;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.util.*;
import java.io.*;
import java.util.*;
public class pdfHandler {
	
	private PDFParser parser;
	private PDFTextStripper pdfStripper;
	private PDDocument pdDoc;
	private COSDocument cosDoc;
	
	public pdfHandler ()  {
	}
	




public String pdfToText (String fileName){
		String parsedText="";
		System.out.println("Parsing PDF file "+ fileName +"....");
		File f = new File(fileName);
		
		if(!f.isFile()) {
			System.out.println("File " + fileName + " does not exist.");
			return null;
		}
		
		try{
			parser = new PDFParser(new FileInputStream(f));
		} catch (Exception e){
			System.out.println("Unable to open PDF parser.");
			return null;
		}
		
		try{
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument (cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
			cosDoc.close();
			pdDoc.close();
		} catch (Exception e){
			System.out.println("An exception occured in parsing the PDF Document.");
			e.printStackTrace();
			try{
				if(cosDoc !=null ) cosDoc.close();
				if(pdDoc !=null) pdDoc.close();
			} catch (Exception e1){
				e.printStackTrace();
			}
			return null;
		}
		System.out.println("PDF file parsing DONE.");
		
		
		return parsedText;
	}
	
	public void writeTextToFile(String pdfText, String fileName) {
		System.out.println("\nWriting PDF text to output text file " + fileName + "....");
		try {
			Writer out= new BufferedWriter(new OutputStreamWriter(
			        new FileOutputStream(fileName), "UTF8"));
			
			out.write(pdfText);
			out.close();  
			} catch (Exception e) {
				System.out.println("An exception occured in writing the pdf text to file.");
				e.printStackTrace();
				}
			System.out.println("Wring text file DONE.");
	}


	public void batchPdfToText(String inputPdfDir)
	{
		DocumentReader DR=new DocumentReader();
		String context="";
		String currentF="";
		ArrayList<String> fileName= DR.getFileNames(inputPdfDir,"pdf");
		
		Iterator<String> it1 = fileName.iterator();
	     while(it1.hasNext()){
	    	 currentF=((String)it1.next()).trim();
	         context=pdfToText(currentF);
	         
	         currentF=currentF.replaceAll("PDF","pdf");
	         String outputTextFile =  currentF.replaceAll("pdf", "txt");
	         
	         writeTextToFile(context,outputTextFile);
	     }
		
		return;
	}
}
