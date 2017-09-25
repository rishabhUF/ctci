package dynamicProgramming;
import java.util.TreeMap;

public class hello {
	
	public static void main(String args[])
	{
		TreeMap<String,Integer> port = new TreeMap<>();
		TreeMap<String,Integer> bench = new TreeMap<>();
		
		String input = "PORT:AXN,20,10;CXN,10,15|BENCH:AXN,30,10;CNX,25,12;XVZ,20,10";
		//parted on |
		String[] equalPart = input.split("\\|");
		//PORT
		String[] port1 = equalPart[0].split(":");
		//STOCKS PORT
		String[] portStocking = port1[1].split(";");
		//putting port things
		for(int i=0;i<portStocking.length;i++)
		{
			String[] port_stock = portStocking[i].split(",");
			if(!port.containsKey(port_stock[0]))
			{
				port.put(port_stock[0], (Integer.parseInt(port_stock[1])*Integer.parseInt(port_stock[2])));
			}
		}
		//calculating nav port
		int nav_port = 0;
		for(String key : port.keySet())
		{
			nav_port+=port.get(key);
		}
		//adding stock %NAV
		TreeMap<String, Double> portperc = new TreeMap<>();
		for(String key : port.keySet())
		{
			portperc.put(key, (double) ((port.get(key) *100)/ nav_port));
		}
		//BENCH
		String[] bench1 = equalPart[1].split(":");
		//STOCKS
		String[] benchStocking = bench1[1].split(";");
		//putting bench things
		for(int i=0;i<benchStocking.length;i++)
		{
			String[] bench_stock = benchStocking[i].split(",");
			if(!bench.containsKey(bench_stock[0]))
			{
				bench.put(bench_stock[0], (Integer.parseInt(bench_stock[1])*Integer.parseInt(bench_stock[2])));
			}
		}
		//calculating the nav bench
		int nav_bench = 0;
		for(String key : bench.keySet())
		{
			nav_bench+=bench.get(key);
		}
		//calculating %nav bench
		TreeMap<String, Double> benchperc = new TreeMap<>();
		for(String key : bench.keySet())
		{
			benchperc.put(key, (double) ((bench.get(key) *100)/ nav_bench));
		}
		StringBuilder final_result = new StringBuilder();
		//printing the values port
		for(String key : portperc.keySet())
		{
			if(benchperc.containsKey(key))
			{
				double print_res = portperc.get(key) - benchperc.get(key);
				String print_result = String.format("%.2f", print_res);
				final_result.append(key+":"+print_result+",");
				benchperc.remove(key);
			}
			else
			{
				String print_result = String.format("%.2f", portperc.get(key));
				final_result.append(key+":"+print_result+",");
			}
		}
		//printing the values of bench
		for(String key : benchperc.keySet())
		{
			String print_result = String.format("%.2f", benchperc.get(key));
			final_result.append(key+":"+print_result+",");
		}
		
		System.out.print(final_result.deleteCharAt(final_result.length()-1).toString());
		
	}
}
