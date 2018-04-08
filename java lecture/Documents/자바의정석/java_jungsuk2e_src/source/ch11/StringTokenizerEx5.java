import java.util.*;

class StringTokenizerEx5 
{
	public static void main(String[] args) 
	{
		String data = "100,,,200,300";
		
		String[] result = data.split(",");

		for(int i=0; i < result.length;i++)
			System.out.print(result[i]+"|");

		System.out.println("����:"+result.length);

		StringTokenizer st = new StringTokenizer(data, ",", true);

		int i=0;
		for(;st.hasMoreTokens();i++)
			System.out.print(st.nextToken()+"|");

		System.out.println("����:"+i);
	} // main
}

/*
100|||200|300|����:5  <-- split()�����
100|200|300|����:3    <-- StringTokenizer�����
*/
