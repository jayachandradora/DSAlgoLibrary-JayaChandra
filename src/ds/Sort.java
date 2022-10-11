package ds;

public class Sort {

	public static void main(String[] args) {

		int b[]=new int[9];
		int[] a=new int[10];
		a[0]=1;  
		a[1]=2;  
		a[2]=3;  
		a[3]=4;  
		a[4]=5; 
		a[5]=6;
		a[6]=7;
		a[7]=8;
		a[8]=9;
		a[9]=10;

		int temp;
		for(int i=0; i<=a.length; i++){
			for(int j=i+1; j<a.length; j++){
				if(a[i]> a[j]){
					temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
				}
			}
		}
		
		Sort st = new Sort();
		 b = new Sort().loopArray(a, 3);
		 for(int kk=0; kk<=b.length-1; kk++){
			 System.out.println(b[kk]);
		 }
		 
		 
		 System.out.println("Print hash code value " + st.getHashCode("788yyyyyy7777"));
	}

	public int[] loopArray(int[] a, int k) {
	    int i;
	    int rem = a.length % k; 
	    for(i = 0; i < a.length ; i = i + k) {
	        a = reverseArray(a, i, i+k-1);
	    }
	    if(rem != 0) {
	        reverseArray(a, a.length - rem, a.length - 1);
	    }
	    return a;
	}

	public  int[] reverseArray(int[] a, int start, int end) {
	    int temp, i ,j;
	    for(i = start, j = end; i < j && j < a.length ; i++, j--) {
	        temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }
	    return a;
	}
	
	
	public int getHashCode(String data){
		int addAshciis = 0;
		int codeValue = 0;
		for(int i=0; i<data.length(); i++){
			addAshciis = addAshciis + (int)data.charAt(i);
		}
		
		codeValue = addAshciis%5;
		System.out.println("PRint hash code " + data.hashCode());
		return codeValue;
	}
}
