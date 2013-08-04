public class CycloMatrix 
{
  public static void main(String[] args)
	{
		CycloMatrix mat = new CycloMatrix(5,5);
		mat.defaultFill();
		mat.printCyclic();
	}
	
	private int[][] matrix;
	
	private int r,c;
	
	public CycloMatrix(int r,int c)
	{
		this.r = r;
		this.c = c;
		matrix = new int[r][c];
	}
	
	public void defaultFill()
	{
		int k = 1;
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				matrix[i][j] = k++;
			}
		}
	}
	
	public void setValue(int i, int j, int val)
	{
		try
		{
		if(i > r || j > c || i < 0 || j <0)
			throw new Exception();
		matrix[i][j] = val;
		}
		catch(Exception e)
		{
			System.out.println("Illegal Argument Exception");
		}
	}
	
	public void printCyclic()
	{
		int i = 0;
		int k = c;
		int r = this.r;
		int n = -1;
		int q = 0;
		int max;
		if(r%2 == 0)
			max = r/2;
		else
			max = (r+1)/2;
		
		for(i = 0;i < max;i++)
		{
			int j;
			for(j = i;j<k;j++)
			{
				System.out.println(matrix[i][j]);
			}
			k--;
			int l;
			for(l=i+1;l<r;l++)
			{
				System.out.println(matrix[l][j-1]);
			}
			r--;
			int m;
			for(m = j -2;m > n;m--)
			{
				System.out.println(matrix[l-1][m]);
			}
			n++;
			int p;
			for(p = l-2;p > q;p--)
			{
				System.out.println(matrix[p][m+1]);
			}
			q++;
		}
	}
}
