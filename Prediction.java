import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class Prediction {
     public static void main(String[] args) throws IOException {
     
      File f1 = new File("C:\\Users\\USER\\Desktop\\data.csv");
      Scanner scanner = new Scanner(f1);
      Scanner scan = new Scanner(System.in);
      String [][] arr1 = new String [1001][5];
      String [][] arr2 = new String[1001][1];
      String [] arr = new String[1001];
      double [] s = new double[1000];
      double [][] a = new double[1][4];
      double [] c = new double[6];
      double [] d = new double[1000];
      int y =0;
      double f = 0;
      double n;
      double k =5;
      
      Prediction p = new Prediction();
      
      	
         for (int i = 0; i<a[0].length; i++) {        
            a[0][i] =scan.nextDouble();
      }
         
       while (scanner.hasNextLine())  {            
     arr= scanner.nextLine().split(","); 
     
         for (int i =0; i<4; i++) { 
            arr1 [y][i]= arr[i];    
    }
         arr2 [y][0] = arr[4];           
         
     y++;    
   }
       
       double min = Double.valueOf(arr1[1][0]);
         for (int i=1; i<arr1.length-1; i++) {
           for (int j=0; j<arr1[0].length-1; j++) {   
               if(Double.valueOf(arr1[i][j]) < min ){
            	   
	  min = Double.valueOf(arr1[i][j]);                       
	}            
   }       
  }
      
     double max = Double.valueOf(arr1[1][0]);
         for (int i=1; i<arr1.length-1; i++) {
           for (int j=0; j<arr1[0].length-1; j++) {   
               if(Double.valueOf(arr1[i][j]) > max ) {
	  max = Double.valueOf(arr1[i][j]);                       
	}            
   }       
  }

        double min_range = 0;
        double max_range = 1;
        
      
        for (int i=1; i<arr1.length-1; i++) {
           for (int j=0; j<arr1[0].length-1; j++) {            
              n = ((((Double.valueOf(arr1[i][j]))-min)/(max - min)) * (max_range - min_range)) + min_range;
             // arr1[i][j]= String.valueOf(n);      
               
           }         
        }
        
       double sum = 0;
        for (int j=1; j<=k; j++) {  
         for (int i=1; i<arr1.length-1; i++) {
            sum = Math.pow((a[0][0]- Double.valueOf(arr1[i][0])),2) + Math.pow((a[0][1]- Double.valueOf(arr1[i][1])),2);
             Math.sqrt(sum);
            s[i] = Math.sqrt(sum);
            d[i] = s[i];
             
         } 
       p.sort(s);         
     c[j]=s[j];
       
   }
         for (int i=1; i<=5; i++) {
             for (int x=1; x<arr1.length-1; x++) {
                 if (c[i]==d[x]) {
                	 
             f += Double.valueOf(arr2[x][0]); 
            
             //f = f/k;
                 }
                 
             }
             //System.out.println(c[i]);
         }
             if (f>2) {
              
                 System.out.println("Accepted");
             }
             else {
                 
                 System.out.println("Rejected");
             }
         
          
      scanner.close();   
  }
        //sorting:
     	public void sort(double s[])  { 
        int n = s.length; 
        
        //building heap
        for (int i=n/2-1; i>=0; i--) 
            heapify(s, n, i); 
        
        //extracting an element one by one from heap 
        for (int i=n-1; i>=0; i--) { 
        	
            double temp = s[0]; 
            s[0] = s[i]; 
            s[i] = temp; 
  
            heapify(s, i, 0); 
        } 
    } 
     
     void heapify(double s[], int n, int i) { 
        int largest = i; //the largest is root 
        int l = 2*i+1;  
        int r = 2*i+2; 
  
        if (l < n && s[l] > s[largest]) //if left child larger than root
            largest = l;
  
        if (r < n && s[r] > s[largest]) //if right child
            largest = r; 
  
        if (largest != i)  { //no root
        	
            double swap = s[i]; 
            s[i] = s[largest]; 
            s[largest] = swap;
  
            heapify(s, n, largest); 
        } 
    }      
} 