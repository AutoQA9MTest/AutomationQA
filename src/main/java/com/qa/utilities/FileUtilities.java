package com.qa.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;

public class FileUtilities {

/***
 * Name of Function 	:- fnGetPropertiesDetail
 * Function Description :- To Get the Property Details from File Name
 * @param strFileName
 * @return Properties
 */
public static Properties fnGetPropertiesDetail(String strFileName)
{
	Properties prop = new Properties();
	try
	{
		String dir = fnGetCurrentUserDir();
		strFileName=strFileName.replace(".properties", "");
		String strFilePath=dir+"/Config/"+ strFileName+ ".properties";
		prop.load(new FileInputStream(strFilePath));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return prop;
}

/***
 * Name of Function 	:- fnGetCurrentUserDir
 * Function Description :- To Get the Current Directory Path
 * @return String
 */
public static String fnGetCurrentUserDir()
{
	 String dir = System.getProperty("user.dir");
     dir=dir.replaceAll("\\\\", "/");
    // System.out.println("current dir = " + dir);
     return dir;
}
	
/***
 * Name of Function 	:- GetCurrentTimeStamp
 * Function Description :- To Get the Current Time Stamp
 * @return String
 */
public static String GetCurrentTimeStamp() {
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);
    return strDate;
}

/***
 * Name of Function 	:- GetCurrentTimeStamp
 * Function Description :- To Get the Current Time Stamp
 * @return String
 */
public static String GetCurrentTimeStampAsString() {
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);
    strDate=strDate.replace("-","").replace(" ", "").replace(":","");
    return strDate;
}
/***
 * Name of Function 	:- GetCurrentDateStamp
 * Function Description :- Get current system time
 * @return String
 */
public static String GetCurrentDateStamp() {
  SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");// dd/MM/yyyy
  Date now = new Date();
  String strDate = sdfDate.format(now);
  return strDate;
}

/***
 * Name of Function 	:- createfolder
 * Function Description :- To Create a Folder
 * @param Path,folderName
 * @return boolean
 */	
public static boolean createfolder(String Path,String folderName)
{
	boolean blnStatus=false;
	try
	{
     File newFolder = new File(Path+"/"+folderName);
     blnStatus =  newFolder.mkdirs();
     if(blnStatus)
     {
         System.out.println("Folder was created !");
     }
     else
     {
         System.out.println("Unable to create folder");
     }
	}catch(Exception e){}
	return blnStatus;
}

/***
 * Name of Function 	:- DeleteFolder
 * Function Description :- To Delete a Folder
 * @param Path,folderName
 * @return boolean
 */	
public static boolean DeleteFolder(String Path,String folderName)
{
	boolean blnStatus=false;
	try
	{
     File file = new File(Path+"/"+folderName);
     if(!file.exists())
     {
         System.out.println("File Do not Exist");
     }
     else
     {
         file.delete();
         System.out.println("Deleted file");
         blnStatus=true;
     }
	}
	catch(Exception e){}
	return blnStatus;
}

/***
 * Name of Function 	:- RenameFolder
 * Function Description :- To Rename a Folder
 * @param Path,oldfolderName,newfolderName
 * @return boolean
 */	
public boolean RenameFolder(String Path,String oldfolderName,String newfolderName)
{
	boolean blnStatus=false;
	try
	{
		File oldfile = new File(Path+"/"+oldfolderName);
	    File newfile = new File(Path+"/"+newfolderName);
	    if(!oldfile.exists())
	    {
	       System.out.println("File Do not Exist");
	    }
	    else
	    {
	       oldfile.renameTo(newfile);
	       System.out.println("File renamed");
	       blnStatus=true;
	    }
	}
	catch(Exception e){}
	return blnStatus;
}

/***
 * Name of Function 	:- SearchFolder
 * Function Description :- To Search a Folder
 * @param Path,folderName
 * @return boolean
 */	
public boolean SearchFolder(String Path,String folderName)
{
   boolean blnStatus=false;;
   try
   {
	   File file = new File(Path+"/"+folderName);
	   if(!file.exists())
	   {
	       System.out.println("File Do not Exist");
	   }
	   else
	   {
	       System.out.println("File Exist : "+file);
	       blnStatus=true;
	   }
   }
   catch(Exception e){}
   return blnStatus;  
}

/***
 * Name of Function 	:- createTextFile
 * Function Description :- To Create a Text File
 * @param Path,folderName
 * @return boolean
 */	
public boolean createTextFile(String Path,String fileName) 
{
     boolean blnstatus=false;
     File newFile = new File(Path+"/"+fileName+(".txt"));
     try
     {
        if(newFile.createNewFile())
        {
           System.out.println("File was created !");
           blnstatus=true;
        }          
      } catch (IOException e) {}
     return blnstatus;
}
/***
 * Name of Function 	:- DeleteTextFile
 * Function Description :- To Delete a Text File
 * @param Path,folderName
 * @return boolean
 */	
public boolean DeleteTextFile(String Path,String fileName) 
{	
	boolean blnStatus=false;
	try
	{
      File newFile = new File(Path+"/"+fileName+(".txt"));
      if(!newFile.exists())
           System.out.println("File Do not Exist");
      else
          newFile.delete();
          System.out.println("Deleted file");
	}
	catch(Exception e){}
	return blnStatus;
}

/***
 * Name of Function 	:- RenameTextFile
 * Function Description :- To Create a Text File
 * @param Path,oldfileName,newfileName
 * @return boolean
 */	
public boolean RenameTextFile(String Path,String oldfileName,String newfileName)
{
	boolean blnStatus=false;
	try
	{
	     File oldfile = new File(Path+"/"+oldfileName);
	     File newfile = new File(Path+"/"+newfileName);
	     if(!oldfile.exists())
	          System.out.println("File Do not Exist");
	     else
	          oldfile.renameTo(newfile);
	          System.out.println("File renamed");
	          blnStatus=true;
	}
	catch(Exception e){}
	return blnStatus;
}

/***
 * Name of Function 	:- CopyFolder
 * Function Description :- To Create a Text File
 * @param Path1,Path2,oldfileNamenewfileName
 * @return boolean
 */	
public boolean CopyFolder(String Path1,String oldfileName,String Path2,String newfileName)
{
	boolean blnStatus=false;
	try
	{
	    File oldfile = new File(Path1+"/"+oldfileName);
	    System.out.println(oldfile);
	    File newfile = new File(Path2+"/"+newfileName);
	    System.out.println(newfile);
	    try 
	    {
	        FileUtils.copyDirectory(oldfile, newfile, DirectoryFileFilter.DIRECTORY);
	        System.out.println("File Copied Successfully!!");
	        blnStatus=true;
	    } catch (IOException e) {}
	}
    catch(Exception e){}
    return blnStatus;
}

/***
 * Name of Function 	:- writeInToAFile
 * Function Description :- To Write in a File
 * @param Path,fileName,data
 * @return boolean
 */	
 public boolean writeInToAFile(String Path,String fileName,String data) 
 {
	 boolean blnStatus=false;
	 try 
	 {
        FileWriter fw=new FileWriter(Path+"/"+fileName+(".txt"));    
        fw.write(data);    
        fw.close();  
        System.out.println("Successfully wrote data in file");
        blnStatus=true;
    } catch (IOException e){}
	return blnStatus;
}

 /***
  * Name of Function 	:- appendStrToFile
  * Function Description :- To Write in a File
  * @param Path,fileName,data
  * @return boolean
  */	
public boolean appendStrToFile(String Path,String fileName,  String data) 
{ 
	boolean blnStatus=false;
	try
	{ 
      BufferedWriter writer = new BufferedWriter(new FileWriter(Path+"/"+fileName+(".txt"),true)); 
      writer.newLine();
      writer.write(data); 
      writer.close(); 
      System.out.println("Successfully wrote data in file");
    } 
    catch (IOException e) {} 
	return blnStatus;
} 

/***
 * Name of Function 	:- fnCopyFolder
 * Function Description :- To copy folder
 * @param strSourceFoler,strDestFolder
 * @return boolean
 */	
	public static boolean fnCopyFolder(String strSourceFoler,String strDestFolder)
	{
		boolean blnStatus=false;
		try
		{ 
			FileUtils.copyDirectory(new File(strSourceFoler),new File(strDestFolder));
	    } 
	    catch (Exception e) {} 
		return blnStatus;
	}
	
}
