import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSV {

	private String fileName;
	private File file;
	private FileWriter outputFile;
	private CSVWriter writer;
	private ArrayList<String[]> times;
	private File directory;
	private FileReader readingFile;
	private CSVReader reader;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private int numRows;
	private boolean hasWritten = false;
	
	public String nameFile() {
		Calendar c = Calendar.getInstance();
		String day = "" + c.get(Calendar.DAY_OF_MONTH);
		if(day.length() == 1) {
			day = "0"+day;
		}
		String month = "" + (c.get(Calendar.MONTH) + 1);
		if(month.length() == 1) {
			month = "0"+month;
		}
		String year = "" + c.get(Calendar.YEAR);
		
		fileName = month + "/" + day + "/" + year;
		return fileName;
	}
	
	public void createFile() {
		nameFile();
		try {
			file = new File(fileName + ".csv");
			
			file.delete();
			
			file = new File(fileName + ".csv");
			
			outputFile = new FileWriter(file);
			writer = new CSVWriter(outputFile);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile(ArrayList<Person> people) {
		createFile();
		
		times = new ArrayList<String[]>();
		String[] header = {"Name","Hours","Minutes"};
		times.add(header);
		
		for(int i = 0; i < people.size(); i++) {
			String[] data = {"" + people.get(i).getName(),"" + people.get(i).getHours(),"" + people.get(i).getMinutes()};
			times.add(data);
		}
		
		writer.writeAll(times);
		
		try {
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public CSV(ArrayList<String> people) {
		times = new ArrayList<String[]>();
		String[] header = {"Name","Hours","Minutes"};
		times.add(header);
		
		file = new File(System.getProperty("user.dir") + "\\Attendance.xlsx");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		if(file.length() > 100) {
			try {
				workbook = new XSSFWorkbook(new FileInputStream(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sheet = workbook.getSheet("Attendance");
			numRows = sheet.getLastRowNum();

		} else {
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("Attendance");
			createFirstRow(people);
			numRows = sheet.getLastRowNum();
		}
		
	}

	public void createFirstRow(ArrayList<String> names) {
		row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("");
		
		for(int i = 1; i <= names.size(); i++) {
			Cell name = row.createCell(i);
			name.setCellValue(names.get(i-1));
		}
		
		try {
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(ArrayList<Person> people) {
		double maxMin = 0;
		for(int i=0; i<people.size();i++) {
			maxMin = Math.max(maxMin, (people.get(i).getHours()*60) + people.get(i).getMinutes());
		}
		
		Font font = workbook.createFont();
		font.setColor(IndexedColors.WHITE.index);
		
		
		CellStyle redStyle = sheet.getWorkbook().createCellStyle();
		redStyle.setFillForegroundColor(IndexedColors.RED.index);
		redStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		redStyle.setFont(font);
		

		CellStyle greenStyle = sheet.getWorkbook().createCellStyle();
		greenStyle.setFillForegroundColor(IndexedColors.GREEN.index);
		greenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		greenStyle.setFont(font);
		
		if(hasWritten == false) {
			numRows++;
			row = sheet.createRow(numRows);
			
			int cellId = 0;
			
			Cell cell = row.createCell(cellId++);
			cell.setCellValue(nameFile());
			
			
			
			for(int i = 0; i < people.size(); i++) {
				Cell cell1 = row.createCell(cellId++);
				cell1.setCellValue(people.get(i).getHours() + ":" + people.get(i).getMinutes());
				double minValue = (people.get(i).getHours()*60) + people.get(i).getMinutes();
				if(minValue >= (0.7*maxMin)) {
					cell1.setCellStyle(greenStyle);
				}else {
					cell1.setCellStyle(redStyle);
				}
			}
			
			try {
				FileOutputStream out = new FileOutputStream(file, false);
				workbook.write(out);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			hasWritten = true;
		} else {
			int cellId = 0;
			
			Cell cell = row.createCell(cellId);
			cell.setCellValue(nameFile());
			
			cellId++;
			
			for(int i = 0; i < people.size(); i++) {
				Cell cell1 = row.createCell(cellId++);
				cell1.setCellValue(people.get(i).getHours() + ":" + people.get(i).getMinutes());
				double minValue = (people.get(i).getHours()*60) + people.get(i).getMinutes();
				if(minValue >= (0.7*maxMin)) {
					cell1.setCellStyle(greenStyle);
				}else {
					cell1.setCellStyle(redStyle);
				}
			}
			
			try {
				FileOutputStream out = new FileOutputStream(file);
				workbook.write(out);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void updateRows() {
		try {
			writer = new CSVWriter(new FileWriter(new File("Attendance.csv")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] rowNum = {String.valueOf(numRows)};
		writer.writeNext(rowNum);
		try {
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> listFiles() {
		directory = new File(System.getProperty("user.dir"));
		String[] dir = directory.list();
		
		ArrayList<String> files = new ArrayList<String>();
		
		for(int i = 0; i < dir.length; i++) {
			if(dir[i].substring(dir[i].length()-3).equals("csv")){
				files.add(dir[i]);
			}
		}
		return files;
	}
	
	public int readRows() {
		try {
			readingFile = new FileReader(new String(System.getProperty("user.dir") + "\\Attendance.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		reader = new CSVReader(readingFile);
		
		try {
			return Integer.parseInt(reader.readNext()[0]);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<String> readFile(String filename){
		ArrayList<String[]> data = new ArrayList<String[]>();
		ArrayList<String> displayData = new ArrayList<String>();
		
		try {
			readingFile = new FileReader(filename);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		reader = new CSVReader(readingFile);
		
		try {
			
			while(true) {
				String[] in = reader.readNext();
				if(in != null) {
					data.add(in);
				}else {
					break;
				}
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 1; i < data.size(); i++) {
			String words = "" + data.get(i)[0] + ": " + data.get(i)[1] + " hours and " + data.get(i)[2] + " minutes";
			displayData.add(words);
		}
		
		return displayData;
	}
	
	public ArrayList<String> readAll(){
		ArrayList<String> fileNames = new ArrayList<String>(listFiles());
		
		ArrayList<String> d = new ArrayList<String>();
		
		Map<String, int[]> map = new HashMap<String,int[]>();
		
		for(int i = 0; i < fileNames.size(); i++) {
			ArrayList<String[]> data = new ArrayList<String[]>();
			
			try {
				readingFile = new FileReader(fileNames.get(i));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			reader = new CSVReader(readingFile);
			
			try {
				boolean go = false;
				while(true) {
					String[] in = reader.readNext();
					if(in != null) {
						if(go) {
							String name = in[0];
							if(map.containsKey(name)) {
								int[] temp = map.get(name);
								int hrs = temp[0];
								int mn = temp[1];
							
								mn += Integer.parseInt(in[2]);
								hrs += Integer.parseInt(in[1]);
							
								hrs += (mn > 60)? 1:0;
								mn %=60;
							
								temp[0] = hrs;
								temp[1] = mn;
							
								map.put(name, temp);
							
							}else {
								int[] temp = {Integer.parseInt(in[1]), Integer.parseInt(in[2])};
								map.put(name, temp);
							}
						}else {
							go = true;
						}
					}else {
						break;
					}
				}
				
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		for(String name : map.keySet()) {
			int[] temp = map.get(name);
			String output = name + ": " + temp[0] + " hours and "+ temp[1] + " minutes";
			d.add(output);
		}
		
		return d;
		
	}

	public ArrayList<String> readAll(int[] start, int[] end){
		ArrayList<String> fileNames = new ArrayList<String>(listFiles());
		
		ArrayList<String> d = new ArrayList<String>();
		
		Map<String, int[]> map = new HashMap<String,int[]>();
		
		for(int i = 0; i < fileNames.size(); i++) {
			String toTest = fileNames.get(i);
			int year = Integer.parseInt(toTest.substring(6,10));
			int day = Integer.parseInt(toTest.substring(3,5));
			int month = Integer.parseInt(toTest.substring(0,2));
			if(year > end[2] || (year == end[2] && month > end[0]) || (year == end[2] && month == end[0] & day > end[1])) {
				break;
			}
			
			if(year < start[2] || (year==start[2] && month < start[0]) || (year == start[2] && month == start[0] && day < start[1])) {
				continue;
			}
			
			ArrayList<String[]> data = new ArrayList<String[]>();
			
			try {
				readingFile = new FileReader(fileNames.get(i));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			reader = new CSVReader(readingFile);
			
			try {
				boolean go = false;
				while(true) {
					String[] in = reader.readNext();
					if(in != null) {
						if(go) {
							String name = in[0];
							if(map.containsKey(name)) {
								int[] temp = map.get(name);
								int hrs = temp[0];
								int mn = temp[1];
							
								mn += Integer.parseInt(in[2]);
								hrs += Integer.parseInt(in[1]);
							
								hrs += (mn > 60)? 1:0;
								mn %=60;
							
								temp[0] = hrs;
								temp[1] = mn;
							
								map.put(name, temp);
							
							}else {
								int[] temp = {Integer.parseInt(in[1]), Integer.parseInt(in[2])};
								map.put(name, temp);
							}
						}else {
							go = true;
						}
					}else {
						break;
					}
				}
				
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		for(String name : map.keySet()) {
			int[] temp = map.get(name);
			String output = name + ": " + temp[0] + " hours and "+ temp[1] + " minutes";
			d.add(output);
		}
		
		return d;
		
	}
	
}
