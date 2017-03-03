/*
 * Copyright (c) 2002, 2004, Regents of the University of California 
 * All rights reserved.

 * Redistribution and use in source and binary forms, with or without modification, are permitted 
 * provided that the following conditions are met:

 *   * Redistributions of source code must retain the above copyright notice, this list of conditions 
 * 		and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice, this list of conditions 
 * 		and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *   * Neither the name of the University of California at Berkeley nor the names of its contributors 
 * 		may be used to endorse or promote products derived from this software without specific prior written 
 * 		permission.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR 
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS 
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE 
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF 
 * THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package nmsucs;

import java.io.*;
import java.util.*;

public class DocumentReader {


	/**
	 * read a document from the disk to a string
	 * @param filename
	 * @return
	 */
	public static String readDoctoStringNew(String filename){
		StringBuffer result = new StringBuffer();
		String line = null;
		//int i= 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				line=line.replaceAll("  ", " ");
				line=line.replaceAll("  ", " ");
				int p = line.length();
				if (p > 0) {
					p = line.length();
					if (line.charAt(p - 1) == '-' && p > 1) {
						result.append(line.substring(0, p - 1));
					} else if (line.charAt(p - 1) == '.') {
						result.append(line);
						result.append('\n');
					} else  if (line.length()<40 && line.length()>3){
						result.append(line);
						result.append('\n');
					} else if (line.charAt(p - 1) == ' ') {
						result.append(line);
					} else {
						result.append(line);
						result.append(" ");
					}
					// i++;
			}}
			//System.out.println(br.toString());
		}
		catch ( IOException ioe ) {
			ioe.printStackTrace();
		}
		return result.toString();
		
	}
	public static String readDoctoString(String filename) {
		StringBuffer result = new StringBuffer();
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {			
				result.append(line);
				result.append("\n");
			}
			//System.out.println(br.toString());
		}
		catch ( IOException ioe ) {
			ioe.printStackTrace();
		}
		return result.toString();
	}
	
	/**
	 * get a certain number of files in a directory with the ".xml" file extension
	 * @param docSource
	 * @param DOCS
	 * @return
	 */
	public static ArrayList getFileNames(String docSource, int DOCS) {
		File source = new File(docSource);
		ArrayList filenames = new ArrayList();
		if (source.isDirectory()) {
			String[] fileList = source.list();
			int len = fileList.length;
			if (len == 0) {
				System.err.println("Empty directory: " + docSource);
				System.exit(0);
			}
			Arrays.sort(fileList);

			for (int i = 0, docCount = 0; i < len && docCount < DOCS; i++)
				if (fileList[i].endsWith(".xml")) {
					String fileName = docSource + '/' + fileList[i];
					filenames.add(fileName);
					docCount++;
				}
			if (filenames.size() < DOCS) {
				System.err.println(
					"Cannot find enough XML files in " + docSource + "!");
				System.exit(0);
			}
		}
		else if (source.isFile() && docSource.endsWith(".xml")) {
			filenames.add(docSource);
			DOCS = 1;
		}
		else {
			System.err.println("DocumentReader::getFileNames -- Illegal input for source files!");
		}
		return filenames;
	}

	/**
	 * get all the files in a directory with the ".xml" file extension
	 * @param docSource
	 * @return
	 */
    public static ArrayList getFileNames(String docSource) {
        File source = new File(docSource);
        ArrayList filenames = new ArrayList();
        if (source.isDirectory()) {
            String[] fileList = source.list();
            int len = fileList.length;
            if (len == 0) {
                System.err.println("Empty directory: " + docSource);
                System.exit(0);
            }
            Arrays.sort(fileList);

            for (int i = 0; i < len; i++)
                if (fileList[i].endsWith(".xml")) {
                    String fileName = docSource + '/' + fileList[i];
                    filenames.add(fileName);
                }
        }
        else if (source.isFile() && docSource.endsWith(".xml")) {
            filenames.add(docSource);
        }
        else {
            System.err.println("DocumentReader::getFileNames -- Illegal input for source files!");
        }
        return filenames;
    }
    /**
     * @by yliu
     * @param dirpath
     * @return
     */
    public static ArrayList<String> getFileFromDir(String dirpath){
    	ArrayList<String> fileName = new ArrayList<String>();
		/* build a filename array list from either a dir or a file*/
		File file = new File(dirpath);		
		if(file.isFile()){
			fileName.add(dirpath);
		}else if(file.isDirectory()){
			String[] filenamearray = file.list();
			for(int i=0;i<filenamearray.length;i++){
				//you can add your own constrain here
				if(filenamearray[i].contains(".txt")&& !filenamearray[i].contains("-")){
					fileName.add(dirpath+"/"+filenamearray[i]);
				}
			}
		}
		return fileName;
    }
    
	/**
	 * get all the files in a directory with a certain file extension
	 * @param docSource
	 * @param extension
	 * @return
	 */
	public static ArrayList getFileNames(String docSource, String extension) {
		File source = new File(docSource);
		ArrayList filenames = new ArrayList();
		if (source.isDirectory()) {
			String[] fileList = source.list();
			int len = fileList.length;
			if (len == 0) {
				System.err.println("Empty directory: " + docSource);
				System.exit(0);
			}
			Arrays.sort(fileList);

			for (int i = 0; i < len; i++)
				if (fileList[i].endsWith(extension) || fileList[i].endsWith(extension.toUpperCase())) {
					String fileName = docSource + '/' + fileList[i];
					filenames.add(fileName);
				}
		}
		else if (source.isFile() && docSource.endsWith(extension)) {
			filenames.add(docSource);
		}
		else {
			System.err.println("DocumentReader::getFileNames -- Illegal input for source files!");
		}
		return filenames;
	}

	/**
	 * get all the files in a directory with a certain file extension
	 * @param docSource
	 * @param extension
	 * @return
	 */
	public static ArrayList getShortFileNames(String docSource, String extension) {
		File source = new File(docSource);
		ArrayList filenames = new ArrayList();
		if (source.isDirectory()) {
			String[] fileList = source.list();
			int len = fileList.length;
			if (len == 0) {
				System.err.println("Empty directory: " + docSource);
				System.exit(0);
			}
			Arrays.sort(fileList);

			for (int i = 0; i < len; i++)
				if (fileList[i].endsWith(extension)) {					
					filenames.add(fileList[i]);
				}
		} else if (source.isFile() && docSource.endsWith(extension)) {
			filenames.add(docSource);
		} else {
			System.err.println(
				"DocumentReader::getFileNames -- Illegal input for source files!");
		}
		return filenames;
	}

	/**
	 * index all the xml files in a directory  
	 * that have been sorted alphabetically.
	 * @param docDir
	 */
    public static void indexDocuments(String docDir) {
        ArrayList names = getFileNames(docDir);
        try {
            String outFile = docDir+"/xmlDocIndex.txt";
            PrintWriter out = new PrintWriter(new FileOutputStream(outFile));
            out.println("index\t\txml_doc_name");
            int size = names.size();
            for (int i=0; i<size; i++) {
                out.println((i+1)+"\t\t"+names.get(i));
            }
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
	 * get short file name, i.e., the name without the path included
	 * it is equivalent to File.getName()
	 * @param name
	 * @return
	 */
    public static String getLocalFileName(String name) {
    	File current = new File(name);
    	current = current.getAbsoluteFile();
    	File parent = current.getParentFile();
    	
    	String filename, filename2;
    	filename = current.getAbsolutePath();
    	String result;
    	if (parent == null) {    		
    		result = filename.substring(1, filename.length());
    	}
    	else {
    		filename2 = parent.getAbsolutePath();
    		result = filename.substring(filename2.length()+1, filename.length());
    	}
    	//System.out.println("local name = "+result);
    	return result;
    }
    
    ///////////////////////////////////////////////////////////////
    
    public static void main(String[] args) {

    }
}
