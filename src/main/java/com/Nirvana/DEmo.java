package com.Nirvana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DEmo {
	
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;
	public static XSSFRow Row;
	static DataFormatter formatter = new DataFormatter();
	
	public static void main(String arg[]) throws IOException
	{	
		
		File f = new File("UploadData/NewApp.xlsx");
		String absolute = f.getAbsolutePath();
		System.out.println("Absolute  path: "
				+ absolute);
		
		ArrayList<String> RowNumberE = DEmo.getColumnData(absolute, "NewApp", "RowNumber");
		ArrayList<String> DOTNumberE = DEmo.getColumnData(absolute, "NewApp", "DOTNumber");
		ArrayList<String> EligibilityE = DEmo.getColumnData(absolute, "NewApp", "Eligibility");
		ArrayList<String> CoverageRequestedE = DEmo.getColumnData(absolute, "NewApp", "CoverageRequested");
		ArrayList<String> ProducerE = DEmo.getColumnData(absolute, "NewApp", "Producer");
		ArrayList<String> Miles_0_50E = DEmo.getColumnData(absolute, "NewApp", "Miles_0_50");
		ArrayList<String> Miles_51_200E = DEmo.getColumnData(absolute, "NewApp", "Miles_51_200");
		ArrayList<String> Miles_201_500E = DEmo.getColumnData(absolute, "NewApp", "Miles_201_500");
		ArrayList<String> Miles501E = DEmo.getColumnData(absolute, "NewApp", "Miles501");
		ArrayList<String> UploadedFileE = DEmo.getColumnData(absolute, "NewApp", "UploadedFile");
		ArrayList<String> OperationsE = DEmo.getColumnData(absolute, "NewApp", "Operations");
		ArrayList<String> DryVanE = DEmo.getColumnData(absolute, "NewApp", "DryVan");
		ArrayList<String> RefrigeratedE = DEmo.getColumnData(absolute, "NewApp", "Refrigerated"); 
		ArrayList<String> FlatbedE = DEmo.getColumnData(absolute, "NewApp", "Flatbed"); 
		ArrayList<String> IntermodalE = DEmo.getColumnData(absolute, "NewApp", "Intermodal"); 
		ArrayList<String> TankerE = DEmo.getColumnData(absolute, "NewApp", "Tanker"); 
		ArrayList<String> HazmatE = DEmo.getColumnData(absolute, "NewApp", "Hazmat");
		ArrayList<String> HeavyHaulE = DEmo.getColumnData(absolute, "NewApp", "HeavyHaul"); 
		ArrayList<String> DumpE = DEmo.getColumnData(absolute, "NewApp", "Dump");
		ArrayList<String> PrimaryCommodityE = DEmo.getColumnData(absolute, "NewApp", "PrimaryCommodity"); 
		ArrayList<String> PowerUnits1E  = DEmo.getColumnData(absolute, "NewApp", "PowerUnits1");
		ArrayList<String> LossIncurred1E = DEmo.getColumnData(absolute, "NewApp", "LossIncurred1"); 
		ArrayList<String> Claims1E  = DEmo.getColumnData(absolute, "NewApp", "Claims1");
		ArrayList<String> PowerUnits2E  = DEmo.getColumnData(absolute, "NewApp", "PowerUnits2");
		ArrayList<String> LossIncurred2E  = DEmo.getColumnData(absolute, "NewApp", "LossIncurred2");
		ArrayList<String> Claims2E  = DEmo.getColumnData(absolute, "NewApp", "Claims2");
		ArrayList<String> PowerUnits3E  = DEmo.getColumnData(absolute, "NewApp", "PowerUnits3");
		ArrayList<String> LossIncurred3E  = DEmo.getColumnData(absolute, "NewApp", "LossIncurred3");
		ArrayList<String> Claims3E  = DEmo.getColumnData(absolute, "NewApp", "Claims3");
		ArrayList<String> PowerUnits4E = DEmo.getColumnData(absolute, "NewApp", "PowerUnits4");
		ArrayList<String> LossIncurred4E  = DEmo.getColumnData(absolute, "NewApp", "LossIncurred4");
		ArrayList<String> Claims4E  = DEmo.getColumnData(absolute, "NewApp", "Claims4");
		ArrayList<String> AutoLiabilityE  = DEmo.getColumnData(absolute, "NewApp", "AutoLiability");
		ArrayList<String> PlansE = DEmo.getColumnData(absolute, "NewApp", "Plans");
		ArrayList<String> PhysicalDamageE = DEmo.getColumnData(absolute, "NewApp", "PhysicalDamage");
		ArrayList<String> InsuredsFullNameE = DEmo.getColumnData(absolute, "NewApp", "InsuredsFullName");
		ArrayList<String> InsuredsEmailE = DEmo.getColumnData(absolute, "NewApp", "InsuredsEmail");
		ArrayList<String> OwnerOperatorsUnitsE = DEmo.getColumnData(absolute, "NewApp", "OwnerOperatorsUnits");
		ArrayList<String> HazardousMaterialsE = DEmo.getColumnData(absolute, "NewApp", "HazardousMaterials");
		ArrayList<String> LiftGateService_WhiteGloveDeliveryE = DEmo.getColumnData(absolute, "NewApp", "LiftGateService_WhiteGloveDelivery");
		ArrayList<String> ResidentialDeliveryE = DEmo.getColumnData(absolute, "NewApp", "ResidentialDelivery");
		ArrayList<String> Double_TripleTrailersE = DEmo.getColumnData(absolute, "NewApp", "Double_TripleTrailers");
		ArrayList<String> MeatOnHookE = DEmo.getColumnData(absolute, "NewApp", "MeatOnHook");
		ArrayList<String> LargeLossesE = DEmo.getColumnData(absolute, "NewApp", "LargeLosses");
		ArrayList<String> AdditionalInformationE = DEmo.getColumnData(absolute, "NewApp", "AdditionalInformation");
		ArrayList<String> UploadedFileLossRunE = DEmo.getColumnData(absolute, "NewApp", "UploadedFileLossRun");

		String rownum = RowNumberE.get(0);
		int RowNumber = Integer.parseInt(rownum);
		
		String DOTNumber = DOTNumberE.get(RowNumber);
		String Eligibility = EligibilityE.get(RowNumber);
		String CoverageRequested = CoverageRequestedE.get(RowNumber);
		String Producer = ProducerE.get(RowNumber);
		String Miles_0_50 = Miles_0_50E.get(RowNumber);
		String Miles_51_200 = Miles_51_200E.get(RowNumber);
		String Miles_201_500 = Miles_201_500E.get(RowNumber);
		String Miles501 = Miles501E.get(RowNumber);
		String UploadedFile = UploadedFileE.get(RowNumber);
		String Operations = OperationsE.get(RowNumber);
		String DryVan = DryVanE.get(RowNumber);
		String Refrigerated = RefrigeratedE.get(RowNumber); 
		String Flatbed = FlatbedE.get(RowNumber); 
		String Intermodal = IntermodalE.get(RowNumber); 
		String Tanker = TankerE.get(RowNumber); 
		String Hazmat = HazmatE.get(RowNumber);
		String HeavyHaul = HeavyHaulE.get(RowNumber); 
		String Dump = DumpE.get(RowNumber);
		String PrimaryCommodity = PrimaryCommodityE.get(RowNumber); 
		String PowerUnits1  = PowerUnits1E.get(RowNumber);
		String LossIncurred1 = LossIncurred1E.get(RowNumber); 
		String Claims1  = Claims1E.get(RowNumber);
		String PowerUnits2  = PowerUnits2E.get(RowNumber);
		String LossIncurred2  = LossIncurred2E.get(RowNumber);
		String Claims2  = Claims2E.get(RowNumber);
		String PowerUnits3  = PowerUnits3E.get(RowNumber);
		String LossIncurred3  = LossIncurred3E.get(RowNumber);
		String Claims3  = Claims3E.get(RowNumber);
		String PowerUnits4 = PowerUnits4E.get(RowNumber);
		String LossIncurred4  = LossIncurred4E.get(RowNumber);
		String Claims4  = Claims4E.get(RowNumber);
		String AutoLiability  = AutoLiabilityE.get(RowNumber);
		String Plans = PlansE.get(RowNumber);
		String PhysicalDamage = PhysicalDamageE.get(RowNumber);
		String InsuredsFullName = InsuredsFullNameE.get(RowNumber);
		String InsuredsEmail = InsuredsEmailE.get(RowNumber);
		String OwnerOperatorsUnits = OwnerOperatorsUnitsE.get(RowNumber);
		String HazardousMaterials = HazardousMaterialsE.get(RowNumber);
		String LiftGateService_WhiteGloveDelivery = LiftGateService_WhiteGloveDeliveryE.get(RowNumber);
		String ResidentialDelivery = ResidentialDeliveryE.get(RowNumber);
		String Double_TripleTrailers = Double_TripleTrailersE.get(RowNumber);
		String MeatOnHook = MeatOnHookE.get(RowNumber);
		String LargeLosses = LargeLossesE.get(RowNumber);
		String AdditionalInformation = AdditionalInformationE.get(RowNumber);
		String UploadedFileLossRun = UploadedFileLossRunE.get(RowNumber);
			
		
		
				
		
		System.out.println(	AutoLiability	);
		
		

	}
	
	
	public static String nameis() {
		
		String url = "https://mb-qa1.my.matchbookservices.com/";
		 String val = url.replaceFirst("https://", " ");
		 String valueis = val.replaceFirst(".my.matchbookservices.com/", " ");
		System.out.println(" Value is "+valueis);
		return url;
	}
	
	
	
	public static String renameFile()
	{
		File folder = new File("DownloadData/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    System.out.println("File " + listOfFiles[i].getName());
		    //System.out.println("First File " + listOfFiles[0].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		  
		  System.out.println(" First File ===> " + listOfFiles[0].getName()); 
		}
		return listOfFiles[0].getName();
	}
	
	
	public static String getCellData(int RowNum, String Header) throws Exception {
		try {
			String value = formatter.formatCellValue(ExcelWSheet.getRow(RowNum).getCell(readHeader(Header)));
			return value;
		} catch (Exception e) {
			return "";
		}
	}
	
	public static int readHeader(String Header) {
		try {
			int colNum = ExcelWSheet.getRow(0).getLastCellNum();
			Row = ExcelWSheet.getRow(0);
			for (int j = 0; j < colNum; j++) {
				Cell = Row.getCell(j);
				String cellValue = formatter.formatCellValue(Cell);
				if (cellValue.equalsIgnoreCase(Header)) {
					return j;
				}

			}
		} catch (Exception e) {
		}
		return -1;
	}
	
	 public static ArrayList<String>  getColumnData(String Filepath,String sheetname, String header) throws IOException
	   	{
	   		int rownum=0;
	   		ArrayList<String> code = new  ArrayList<String>();
	   		formatter = new DataFormatter();
	   		FileInputStream	fin = new FileInputStream(Filepath);
	   			ExcelWBook = new XSSFWorkbook(fin);
	   			ExcelWSheet = ExcelWBook.getSheet(sheetname);
	   		try {

	   			int rowCount = ExcelWSheet.getLastRowNum();
	   			for (int i = 0; i < rowCount; i++) {

	   				rownum = i + 1;
	   				code.add(getCellData(rownum, header));
	   			}
	   			ExcelWBook.close();
	   			fin.close();
	   		}
	   		catch(Exception e)
	   		{
	   			
	   		}
	   		return code;
	   	}


}
