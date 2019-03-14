package architecture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Experiments 
{
	public static void main(String [] args) throws Exception
	{
	    String dataset = args[0];
		CommandInterface ci = new CommandInterface();
		ci.executeCommand("#useDB " + dataset);
		File file = new File(dataset + "_all.nlqs");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    ci.executeCommand("#query " + line);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
