package mwc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class RoboticsSummative
{

	public static void main(String[] args) throws Exception
	{
		int n = readInt();
		long[] pieces = new long[n];
		for (int i = 0; i < n; i++)
			pieces[i] = readLong();
		Arrays.sort(pieces);
		
		long area = 0;
		
		for (int i = n - 4; i >= 0; i--)
			if (Math.abs(pieces[i] - pieces[i + 1]) <= 1 && Math.abs(pieces[i + 2] - pieces[i + 3]) <= 1)
			{
				area += pieces[i] * pieces[i + 2];
				i -= 3;
			}
		
		System.out.println(area);
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
