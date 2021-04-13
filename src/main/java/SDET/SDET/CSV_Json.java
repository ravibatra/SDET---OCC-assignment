package SDET.SDET;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class CSV_Json {
	
	static Set<String> JsonFileData =new HashSet<String>();
	static Set<String> CsvFileData =new HashSet<String>();	
	static Set<String> MergedHashSet =new HashSet<String>();
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		//Storing csv content into Hashset
		StoreCSVInHashSet("src\\employee.csv");
		
		//Storing json into hashmap/hashset
		StoreJsonInHashMap("src\\employee.json");
	
		//Writing the results into csv file as a output.csv
		WriteResultToCSV(JsonFileData,CsvFileData,"target\\Output.csv");
	}


	//Storing Json object/array into HashMap, later store in HashSet for comparison
	public static void StoreJsonInHashMap(String FilePath) throws JsonParseException, JsonMappingException, IOException {
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(FilePath))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
      
            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	public static void parseEmployeeObject(JSONObject employee) 
    {
		
	    //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");
         
        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");    
         
        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");  
        
	     //Get employee age 
	   String age = (String) employeeObject.get("age");    
		        
       //Get employee address 
       String address = (String) employeeObject.get("address");    
  
       
       //Get employee salary 
       String salary = String.valueOf(employeeObject.get("salary"));
       
       Object[] employeeDetails = {firstName,lastName,age,address,salary};
       //storing json data into HashSet
       JsonFileData.add(Arrays.toString(employeeDetails));
      
    }
	
	
	public static void StoreCSVInHashSet(String path) throws FileNotFoundException {
		//initialization
		String line = "";  
		String splitBy = ",";  
		int i=0;
		
		//for IO exception used try/catch
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader(path)); 
		
		//loop through end of file
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		
		if(i!=0)
		{
			//Split values by ","
			Object[] employee = line.split(splitBy); 
			
			//storing array values into Hashset
			CsvFileData.add(Arrays.toString(employee));
		}
		i++;
		}  
		
		}   
		catch (IOException e)   
		{  
		//print exception stacktrace	
		e.printStackTrace();  
		}  
	}
	
	private static void WriteResultToCSV(Set<String> jsonFileData1, Set<String> csvFileData1 , String filePath) throws NumberFormatException, IOException{
		ArrayList<Employee> ar = new ArrayList<Employee>();
		
		//print the size of json hashset
		System.out.println(JsonFileData.size());
		
		//print the data of json hashset
		System.out.println(JsonFileData);
		
		//print the size of csv hashset
		System.out.println(CsvFileData.size());
		
		//print the data of csv hashset
		System.out.println(CsvFileData);
		
		//insert the value of json hashset into new hashset for merge json and csv data
		MergedHashSet.addAll(JsonFileData);
		
		//Now adding one by one data of csv hashset into merged hashset 
		for (String csvData : CsvFileData)
		{
			MergedHashSet.add(csvData);
		}
		
		//Check the size and data of merged hashset
		System.out.println(MergedHashSet.size());
		System.out.println(MergedHashSet);
		
		//Create string array to sort the hashset by salary
		for (String MergedHashSet1 : MergedHashSet)
		{
			String[] arr = MergedHashSet1.split(",");
			String Sal = arr[4].replace("]", "");
			int Sal1 = Integer.parseInt(Sal.replace(" ", ""));
			
			ar.add(new Employee(arr[0].replace("[", ""),arr[1],arr[2],arr[3],Sal1));
		
		}
		//use collections to sort by salary	
		  Collections.sort(ar, new SortSalary());
	    
		  //writing the results in csv file
		  FileWriter fw=new FileWriter(filePath);    
		  fw.write("FirstName,LastName,Address,Age,salary");    
		  
		  //sorting by Salary descending
	      System.out.println("\nSorted by Salary Descending");
		  for (int i = ar.size()-1; i >=0; i--)
		  {
			System.out.println(ar.get(i));
			fw.append("\n");
			fw.append(String.valueOf( ar.get(i)));
			
		  }
		  //close the writer connection after writing the data into csv
		  fw.close(); 
	}

	
}
