package readJsonFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;



public class readJSON {

	public static void main (String [] args ) {
		
		JSONParser parser = new JSONParser() ; 
		
		try {
			
			Object obj = parser.parse(new FileReader("fileJson.json"));
			JSONObject user = (JSONObject) obj ; 
			
			Stack<String> USER = new Stack<String>(); 
			
			
			String lastname = (String) user.get("lastname");
			String firstname = (String) user.get("firstname");
			JSONArray phone = (JSONArray) user.get("phone");
			String email = (String) user.get("email");
			Object age = user.get("age");
//            int Age = (int) (long) age;
			String Age = String.valueOf(age) ;
			Iterator<String> iterator = phone.iterator();
			
            USER.push(lastname);
            USER.push(firstname);
            
            while(iterator.hasNext()) {
            	USER.push(iterator.next());
            }
            
            USER.push(email);
            USER.push(Age);
            
			System.out.println(obj ) ; 
			System.out.println(USER) ; 

			
		}catch(FileNotFoundException e) {
			e.printStackTrace() ;
		} catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }   catch (Exception e) {
            e.printStackTrace();
        }
	}

}
