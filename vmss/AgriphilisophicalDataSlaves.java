package vmss;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class AgriphilisophicalDataSlaves
{
	static ArrayList<Integer>[] adj;
	static int[] val;
	static long[] total;
	
	static long fill (int x)
	{
		if (total[x] != Long.MIN_VALUE)
			return total[x];
		
		long slave = val[x];
		for (int i : adj[x])
			slave += fill(i);
		return total[x] = slave;
	}
	
	public static void main(String[] args) throws Exception
	{
		int n = readInt();
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < n - 1; i++)
			adj[readInt() - 1].add(readInt() - 1);
		val = new int[n];
		total = new long[n];
		Arrays.fill(total, Long.MIN_VALUE);
		for (int i = 0; i < n; i++)
			val[i] = readInt();
			
		long maxv = Long.MIN_VALUE;
		for (int i = 0; i < n; i++)
			maxv = Math.max(maxv, fill(i));
		System.out.println(maxv);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintWriter out = new PrintWriter(new BufferedWriter(
			new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static String next() throws IOException
	{
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException
	{
		return Long.parseLong(next());
	}

	static int readInt() throws IOException
	{
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException
	{
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException
	{
		return next().charAt(0);
	}

	static String readLine() throws IOException
	{
		return br.readLine().trim();
	}
	
}
