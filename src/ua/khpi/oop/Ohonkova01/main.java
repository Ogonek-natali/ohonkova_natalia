package ua.khpi.oop.Ohonkova01;

public class main {
	public static int count_pair(long x) {
	    long buf = x;
	    long num = 0;
	    int count = 0;
	    while(buf != 0) {
	          num = buf % 10;
	          if(num % 2 == 0) {
	            count++;
	          }
	          buf /= 10;
	        }
	    return count;
	  }
	  public static int count_not_pair(long x) {
	    long buf = x;
	    long num = 0;
	    int count = 0;
	    while(buf != 0) {
	          num = buf % 10;
	          if(num % 2 != 0) {
	            count++;
	          }
	          buf /= 10;
	        }
	    return count;
	  }
	  public static int count_one(long x) {
		  	String bin = Long.toBinaryString(x);
	          int count = 0;
	          for(int i = 0; i < bin.length(); i++) {
	            if(bin.charAt(i) == '1') {
	              count++;
	            }
	          }
	         return count;
	  }
	  
	  public static void main(String[] args) {
	    final short StudBook = 0x4666;      //0х для считывания числа в 16 системе
	    final long MPhone = 380639891902L;  //L для типа  long
	    final byte Num = 0b1011100;         //0b двоичный литерал
	    final short Num2 = 021750;  //0 в начале для восьмиричного литерала
	    final int StudNum = 11;
	    final char letter = (char)StudNum+65;
	       
	        
	        System.out.println("StudBook: " + StudBook + ", Pair: " + count_pair(StudBook) + ", Not_Pair: " + count_not_pair(StudBook)+", BinaryNum: "+Long.toBinaryString(StudBook)+",BinaryCount: "+count_one(StudBook));
	        System.out.println("MPhone: " + MPhone + ", Pair: " + count_pair(MPhone) + ", Not_Pair: " + count_not_pair(MPhone)+", BinaryNum: "+Long.toBinaryString(MPhone)+",BinaryCount: "+count_one(MPhone));
	        System.out.println("Num: " + Num + ", Pair: " + count_pair(Num) + ", Not_Pair: " + count_not_pair(Num)+", BinaryNum: "+Long.toBinaryString(Num)+",BinaryCount: "+count_one(Num));
	        System.out.println("Num2: " + Num2 + ", Pair: " + count_pair(Num2) + ", Not_Pair: " + count_not_pair(Num2)+", BinaryNum: "+Long.toBinaryString(Num2)+",BinaryCount: "+count_one(Num2));
	        System.out.println("StudNum: " + StudNum + ", Pair: " + count_pair(StudNum) + ", Not_Pair: " + count_not_pair(StudNum)+", BinaryNum: "+Long.toBinaryString(StudNum)+",BinaryCount: "+count_one(StudNum));
	        System.out.println("letter: " + letter);

	    }
}
