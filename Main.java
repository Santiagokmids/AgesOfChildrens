import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	private static String SEPARATOR = " ";
	private static ArrayList<Double> ages;
	
	public static void main(String[] args) throws IOException {
		startApp();
	}
	
	public static void startApp() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		try {
			
			String cases = br.readLine();
			String age = "";

			if(cases != null && !cases.equals("")){
				
				int cause = Integer.parseInt(cases);
				
				for (int i = 0; i < cause; i++) {
					
					ages = new ArrayList<>();
					age = br.readLine();
					String parts[] = age.split(SEPARATOR);

					for (int j = 0; j < parts.length; j++) {
						
						Double agesChildrens = Double.parseDouble(parts[j]);
						ages.add(agesChildrens);
					}
					
					bw.write("\n"+bubbleSort(ages));	
				}
			}
			br.close();
			bw.close();

		} catch (NumberFormatException nfe) {
			System.out.println("\nPlease enter numbers");	
		}
	}
	
	public static String bubbleSort(ArrayList<Double> age){
		
		String message = "";
		Double exchanges = 0.0, iterations = 0.0;
		
		for(int i=1;i<ages.size();i++) {

			for(int j=0;j<ages.size()-i;j++) {

				if(ages.get(j) > ages.get(j+1)) {
					
					Double tem = ages.get(j);
					ages.set(j, ages.get(j+1));
					ages.set(j+1,tem);
					exchanges++;
				}
			}
			iterations++;
		}
		Double average = (exchanges/iterations);
		message = String.format("%.3f", average)+" - ";
		
		for (int j = 0; j < ages.size(); j++) {
			
			message += ages.get(j)+" ";
			
			if(j == ages.size()-1) {
				
				message += "\n";
			}
		}
		return (message);	
	}
}

