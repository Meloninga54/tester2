import java.util.*;
public class Linear_Sort
{
	
	public static int[] count_Sort(int a[], int k)
	{
		return count_Sort(a,0,k);
	}

	public static int[] count_Sort(int a[])
	{
		int b[]=quick_minmax(a);
		return count_Sort(a,b[0],b[1]);

	}
	public static int[] count_Sort(int a[], int min, int max)
	{
		int k=max-min+1;
		int b[]=new int[k];
		int n=a.length;

		for(int i=0;i<n;i++)
		{
			b[a[i]-min]++;
		}
		for(int i=1;i<b.length;i++)
		{
			b[i]=b[i]+b[i-1];
		}

		int f[]=new int[n];

		for(int i=0;i<n;i++)
		{
			f[b[a[i]-min]-1]=a[i];
			b[a[i]-min]--;
		}
		return(f);	  

	}

	public static int[] Insertion_Sort(int a[], int digit)
	//digit starts from 1 to 12
	{
		
		// printy(a);		
		int n=a.length;
		int d[]=new int[n];
		for(int i=0;i<n;i++)
		{
			d[i]=(a[i]/((int)Math.pow(10,digit)))%10;
		}
		printy(d);
		System.out.println();
		for(int i=0;i<d.length-1;i++)
		{
			int max=d[i];
			for(int j=i+1;j<d.length;j++)
			{
				max=(int)Math.min(d[i],d[j]);
			}
			int t=a[max];
			a[max]=a[i];
			a[i]=t;

			t=d[max];
			d[max]=d[i];
			d[i]=t;

		}

		printy(d);
		System.out.println();
		return a;




	}
	public static void radix_sort(int a[],int numlen)
	{
		for(int i=0;i<numlen;i++)
		{
			a=Insertion_Sort(a,i);
			printy(a);
			System.out.println();
		}
		printy(a);
	}
	public static int[] quick_minmax(int a[])
	{
		int n=a.length;
		int min=a[0];
		int max=a[1-(n%2)];
		int i=2-(n%2);

		for(;i<n-1;i+=2)
		{
			int mini,maxi;
			if(a[i]>a[i+1])
			{
				mini=a[i+1];
				maxi=a[i];
			}
			else
			{
				mini=a[i];
				maxi=a[i+1];
			}

			if(mini<min)
				min=mini;
			if(maxi>max)
				max=maxi;
		}
		int b[]=new int[2];
		b[0]=min;
		b[1]=max;
		return b;

	}
	 
	static void printy(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String[] args) {
		// int a[]={6, 0, 2, 0, 1, 3, 4, 6, 1, 3, 2, -1};
		// a=count_Sort(a);
		// printy(a);

		int x[]={5196, 9711, 4359, 8000, 8732, 6215, 5680, 4661, 5311, 9114};
		printy(x);
		System.out.println();
		radix_sort(x,4);
		// printy(y);
	}
}
//hi
