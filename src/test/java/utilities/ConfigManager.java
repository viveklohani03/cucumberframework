package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	Properties prop = null;
	String configfile = "./src/test/resources/config.properties";
	
	public Properties readPropertiesFile() throws IOException {
	      FileInputStream fis = null;   
	      try {
	         fis = new FileInputStream(configfile);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	   }

}
