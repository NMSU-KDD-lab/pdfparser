package nmsucs;

import java.io.*;




public class pdfTest {
	public static void main(String[] args) {
		String fname="";
		if(args.length==0){
			fname = "data/pdf/P1/cited/sigmod2009_RastogiHMS.pdf";
		}
		if(args.length==1){
			fname = args[0];
		}
		if(args.length>1){
			System.out.println("input PDF file");
			return;
		}
		pdfHandler ph = new pdfHandler();
		
		
		String s=ph.pdfToText(fname);
		
		System.out.println(s);
		
		//ph.writeTextToFile(s, fname+".txt");
		
		//ph.batchPdfToText(args[0]);
		/*result are:
		 * Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/ICFS2006_WangJT06.pdf....
Jan 8, 2011 2:27:59 PM org.apache.pdfbox.encoding.Encoding getCharacter
WARNING: Not a number in Unicode character name: unionsq
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/ICFS2006_WangJT06.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/Introduction to algorithms2001_Cormen01.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/Introduction to algorithms2001_Cormen01.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/KDD2006_BackstromHKL06.pdf....
Jan 8, 2011 2:27:59 PM org.apache.pdfbox.util.PDFStreamEngine processOperator
INFO: unsupported/disabled operation: EI
Jan 8, 2011 2:27:59 PM org.apache.pdfbox.cos.COSDocument finalize
WARNING: Warning: You did not close a PDF Document
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/KDD2006_BackstromHKL06.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/KDD2006_KumarNT06.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/KDD2006_KumarNT06.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/KDD2006_XuPWSF06.pdf....
Jan 8, 2011 2:28:01 PM org.apache.pdfbox.util.PDFStreamEngine processOperator
INFO: unsupported/disabled operation: EI
Jan 8, 2011 2:28:01 PM org.apache.pdfbox.cos.COSDocument finalize
WARNING: Warning: You did not close a PDF Document
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/KDD2006_XuPWSF06.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/MIT2010_CormenLRS01.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/MIT2010_CormenLRS01.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/PinKDD2007_ZhelevaG07.pdf....
Jan 8, 2011 2:28:02 PM org.apache.pdfbox.cos.COSDocument finalize
WARNING: Warning: You did not close a PDF Document
Jan 8, 2011 2:28:02 PM org.apache.pdfbox.cos.COSDocument finalize
WARNING: Warning: You did not close a PDF Document
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/PinKDD2007_ZhelevaG07.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/RANDOM-APPROX2003_HazanSS03.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/RANDOM-APPROX2003_HazanSS03.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/SIAM Data Mining2004_ChakrabartiYC04.pdf....
Jan 8, 2011 2:28:03 PM org.apache.pdfbox.util.PDFStreamEngine processOperator
INFO: unsupported/disabled operation: EI
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/SIAM Data Mining2004_ChakrabartiYC04.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/SIGCOMM1999_FaloutsosFFF99.pdf....
Jan 8, 2011 2:28:04 PM org.apache.pdfbox.cos.COSDocument finalize
WARNING: Warning: You did not close a PDF Document
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/SIGCOMM1999_FaloutsosFFF99.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/SIGKDD2005_GetoorD05a.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/SIGKDD2005_GetoorD05a.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/SIGMOD2004_YanSJ04.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/SIGMOD2004_YanSJ04.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/SIGMOD2006_xiaoT06.pdf....
Jan 8, 2011 2:28:05 PM org.apache.pdfbox.cos.COSDocument finalize
WARNING: Warning: You did not close a PDF Document
Jan 8, 2011 2:28:05 PM org.apache.pdfbox.cos.COSDocument finalize
WARNING: Warning: You did not close a PDF Document
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/SIGMOD2006_xiaoT06.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/Science2006_GJ06.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/Science2006_GJ06.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/Social Networks2005_LE05.pdf....
Jan 8, 2011 2:28:06 PM org.apache.pdfbox.util.PDFStreamEngine processOperator
INFO: unsupported/disabled operation: EI
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/Social Networks2005_LE05.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/Sociology1988_Scott88.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/Sociology1988_Scott88.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/TKDD2007_MachanavajjhalaDJM07.pdf....
Jan 8, 2011 2:28:07 PM org.apache.pdfbox.util.PDFStreamEngine processOperator
INFO: unsupported/disabled operation: EI
Jan 8, 2011 2:28:07 PM org.apache.pdfbox.cos.COSDocument finalize
WARNING: Warning: You did not close a PDF Document
Jan 8, 2011 2:28:07 PM org.apache.pdfbox.cos.COSDocument finalize
WARNING: Warning: You did not close a PDF Document
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/TKDD2007_MachanavajjhalaDJM07.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/TKDE2001_Samarati01.pdf....
Jan 8, 2011 2:28:07 PM org.apache.pdfbox.util.PDFStreamEngine processOperator
INFO: unsupported/disabled operation: EI
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/TKDE2001_Samarati01.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/UMTR2007_HayGDPS07.pdf....
An exception occured in parsing the PDF Document.
java.lang.NullPointerException
	at org.apache.pdfbox.pdmodel.font.PDFont.getEncodingFromFont(PDFont.java:832)
	at org.apache.pdfbox.pdmodel.font.PDFont.determineEncoding(PDFont.java:293)
	at org.apache.pdfbox.pdmodel.font.PDFont.<init>(PDFont.java:178)
	at org.apache.pdfbox.pdmodel.font.PDSimpleFont.<init>(PDSimpleFont.java:79)
	at org.apache.pdfbox.pdmodel.font.PDType1Font.<init>(PDType1Font.java:139)
	at org.apache.pdfbox.pdmodel.font.PDFontFactory.createFont(PDFontFactory.java:109)
	at org.apache.pdfbox.pdmodel.font.PDFontFactory.createFont(PDFontFactory.java:76)
	at org.apache.pdfbox.pdmodel.PDResources.getFonts(PDResources.java:115)
	at org.apache.pdfbox.util.PDFStreamEngine.processSubStream(PDFStreamEngine.java:243)
	at org.apache.pdfbox.util.PDFStreamEngine.processStream(PDFStreamEngine.java:225)
	at org.apache.pdfbox.util.PDFTextStripper.processPage(PDFTextStripper.java:441)
	at org.apache.pdfbox.util.PDFTextStripper.processPages(PDFTextStripper.java:365)
	at org.apache.pdfbox.util.PDFTextStripper.writeText(PDFTextStripper.java:321)
	at org.apache.pdfbox.util.PDFTextStripper.getText(PDFTextStripper.java:241)
	at pdf.pdfHandler.pdfToText(pdfHandler.java:45)
	at pdf.pdfHandler.batchPdfToText(pdfHandler.java:84)
	at pdf.pdfTest.main(pdfTest.java:20)

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/UMTR2007_HayGDPS07.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/WWW2007_BackstromCJ07.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/WWW2007_BackstromCJ07.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/World2002_Sweeney02.pdf....
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/World2002_Sweeney02.pdf.txt....
Done.
Parsing text from PDF file data\P1--ICDE2008_ZhouP08\references/gSpan2002_YanJ02.pdf....
Jan 8, 2011 2:28:09 PM org.apache.pdfbox.util.PDFStreamEngine processOperator
INFO: unsupported/disabled operation: EI
Done.

Writing PDF text to output text file data\P1--ICDE2008_ZhouP08\references/gSpan2002_YanJ02.pdf.txt....
Done.
		 */
		
	}
}
