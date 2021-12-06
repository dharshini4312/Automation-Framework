package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import testDataType.Logindata;
import testDataType.RegisterData;

public class JsonReader {
	ConfigFileReader configFileReader = new ConfigFileReader();
	private final String RegisterFilePath = configFileReader.getJsonPath() + "RegisterJson.json";
	private List<RegisterData> RegisterList;
	
	private final String LoginFilePath = configFileReader.getJsonPath() + "LoginJson.json";
	private List<Logindata> LoginList;
	
	public JsonReader(){
		RegisterList = getRegisterData();
		LoginList=getLoginList();
	}
	
	private List<RegisterData> getRegisterData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(RegisterFilePath));
			RegisterData[] registers = gson.fromJson(bufferReader, RegisterData[].class);
			return Arrays.asList(registers);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + RegisterFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
	private List<Logindata>getLoginList(){
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(LoginFilePath));
			Logindata[] login = gson.fromJson(bufferReader, Logindata[].class);
			return Arrays.asList(login);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + RegisterFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
		
	
	public final RegisterData getRegisterByName(String customerName){
			 return RegisterList.stream().filter(x -> x.FirstName.equalsIgnoreCase(customerName)).findAny().get();
	}
	
	
	public final Logindata getLoginByName(String UserName){
			 return LoginList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
}





