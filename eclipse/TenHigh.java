package hyoukou;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TenHigh {
	public static void main(String argv[]) {
		
		String[] High = new String[200];
		
		 String[] A = null;
		 String[] B = null;
		 String[] C = null;
		 List<String> a = new ArrayList<String>();
		 List<String> b = new ArrayList<String>();
		 List<String> c = new ArrayList<String>();
		 
		 read(a, b, c);
		     A = (String[])a.toArray(new String[0]);
		     B = (String[])b.toArray(new String[0]);
		     C = (String[])c.toArray(new String[0]);
		   
		     //String型からdouble型へ
		     double[] BB = new double[B.length] ;
			 for(int i=0; i< B.length; i++){
				 double bb = Double.parseDouble(B[i]);
				 BB[i] = bb ;
				 }
			 double[] CC = new double[C.length] ;
			 for(int i=0; i< C.length; i++){
				 double cc = Double.parseDouble(C[i]);
				 CC[i] = cc ;
			     }
		
		int i = 0;  
		try{
		       File file = new File("C:\\テーマ研究\\534046high.txt");
		       BufferedReader br = new BufferedReader(new FileReader(file));
		       String str= null;
		       i=0;
		       while((str = br.readLine()) != null){
		           High[i]=str;
		           i = i +1;
		       }
		       br.close();
		       
		  }catch(FileNotFoundException e){
		        System.out.println(e);
		  }catch(IOException e){
		        System.out.println(e);
		  }
		//System.out.println(High[1]);
		double x = 35.7530575 ;
		double X = x-35.66972416666666 ;
		double y = 140.87166666666667 ;
		double Y = y-140.74666666666664 ;
		int [] ido = new int[A.length] ;
		int [] keido = new int[A.length] ;
		String [] Hyoko = new String[A.length] ;
		
		for(int ii=0; ii<A.length ; ii++ ){
			ido[ii] = (int)Math.floor((200*(x-BB[ii]))/X) ;
			keido[ii] = (int)Math.floor((200*(CC[ii]-140.74666666666664))/Y) ;
			Hyoko[ii] = High[ido[ii]].substring(9+(keido[ii]*5), 14+(keido[ii]*5));
		}
		
		int[] H = new int[Hyoko.length] ; 
		for(int ii=0; ii< Hyoko.length; ii++){
			 int h = Integer.parseInt(Hyoko[ii]);
			 H[ii] = h ;
			 }
		//System.out.println(H[22]);
		
		try{
		      File file = new File("C:\\テーマ研究\\点-目標標高-銚子.txt");

		      if (checkBeforeWritefile(file)){
		        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

		        for(int ii=0; ii< A.length; ii++){
		        	if(H[ii]>500){
		        		pw.println("a"+A[ii]+","+"G,0");
		        	}
		        }
		 
		        pw.close();
		      }else{
		        System.out.println("ファイルに書き込めません");
		      }
		    }catch(IOException error){
		      System.out.println(error);
		    }
		System.out.println("整理2");
		}


private static boolean checkBeforeWritefile(File file){
		 if (file.exists()){
			 if (file.isFile() && file.canWrite()){
				 return true;
				 }
			 }
		 return false;
}
		
		
	

		  private static boolean checkBeforeReadfile(File file){
		    if (file.exists()){
		      if (file.isFile() && file.canRead()){
		        return true;
		      }
		    }

		    return false;
	}

		  private static void read(List<String> a, List<String> b, List<String> c) {
				 BufferedReader br = null;
				 try {
				 br = new BufferedReader(new FileReader("C:\\テーマ研究\\点-緯度経度-銚子.txt"));
				 String line = null;
				 // ファイルの読み込み
				while ((line = br.readLine()) != null) {
				 String[] array = line.split(" ");
				 if (array.length == 3) {
				 a.add(array[0]);
				 b.add(array[1]);
				 c.add(array[2]);
				 }
				 }
				
				// 以下エラー処理
					} catch (FileNotFoundException error) {
					 error.printStackTrace();
					 } catch (IOException error) {
					 error.printStackTrace();
					 } finally {
					 try {
					 if (br != null) {
					 br.close();
					 }
					 } catch (IOException error) {
					 error.printStackTrace();
					 }
					 }
	}
}
