package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	static int counter =0;
//	static long[] arr = new long[26];
	public static void main(String[] args) {

//		List<Integer> arr = new ArrayList<>(Arrays.asList(9547948 ,8558390 ,9999933 ,5148263 ,5764559 ,906438 ,9296778 ,1156268 ,6642930 ,362317 ,5884372 ,8183642 ,1893625 ,2078221 ,9091567 ,9008204 ,5596899 ,2415143 ,3745745 ,9999933 ,4601052 ,2226334 ,9999933 ,9084710 ,6425739 ,859550 ,7297169 ,2560362 ,7342790 ,6125814 ,973515 ,7983457 ,1411690 ,9999933 ,7698786 ,173508 ,9999933 ,7146414 ,5063134 ,6934007 ,506731 ,9672243 ,1791721 ,3542431 ,9645190 ,4101220 ,120716 ,4815228 ,7129154 ,1377763 ,2420858 ,9999933 ,2913976 ,4704061 ,8792535 ,8232675 ,6865047 ,4119291 ,7633812 ,6646342 ,1714025 ,653612 ,1541039 ,2074983 ,7203496 ,908154 ,2567724 ,6466771 ,9999933 ,8767549 ,923596 ,7545333 ,8336840 ,7677082 ,9224613 ,15813 ,1946806 ,7379477 ,9617658 ,1431652 ,1646399 ,4316536 ,9054082 ,9999933 ,7442742 ,6195231 ,5658010 ,5196448 ,9299025 ,328790 ,4842946));
//		System.out.println(arr.size());
//		Integer max = arr.stream().mapToInt(a->a).max().getAsInt();
//		System.out.println(max);
//        System.out.println(Collections.frequency(arr, max));
//		Collections.sort(arr);
//        long sum=arr.stream().mapToLong(Long::valueOf).sum();
//        long maxi = sum-arr.get(0);
//        long min = sum-arr.get(arr.size()-1);
//        System.out.println(min +" "+maxi);
		//System.out.println(Test.res("y", "yu", 2));
		List<Integer> arr = new ArrayList<>(Arrays.asList(5, 4, 4, 2, 2, 8));
		int max = arr.stream().mapToInt(i->i).max().getAsInt();
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(arr);
        while(max>0){
            res.add(temp.size());
            int min = temp.stream().mapToInt(i->i).min().getAsInt();
            temp = temp.stream().map(i->i-min).filter(i->i>0).collect(Collectors.toList());
            max-=min;
            System.out.println(temp);
            System.out.println(min +" "+max);
        }
        res.add(0);
        System.out.println(res);
	}
	
	
	public static String res(String s, String t, int k) {

	    // Write your code here
	        char[] s1 = s.toCharArray();
	        int n=0;
	        char[] t1 = t.toCharArray();
	        int x = s1.length>t1.length ? t1.length : s1.length;
	        for(int i=0;i<x;i++){
	            if(s1[i]==t1[i])
	                n++;
	            else
	                break;
	        }
	        int val = s1.length+t1.length-2*n;
	        if(val>k){
	            return "No";
	        } else if(k%2==val%2){
	            return "Yes";
	        } else if(k>val+2*n){
	        	System.out.println("Here");
	            return "Yes";
	        } else {
	            return "No";
	        }
	}
	
	public static void printFib() {
		int n = 50; 
		long[] arr = new long[n];
		arr[0]=0;
		arr[1]=1;
		long start = System.currentTimeMillis();
		System.out.println(Test.fibonacci(arr,n-1));
		long end = System.currentTimeMillis()-start;
		System.out.println("Time : "+end);
		System.out.println(counter);
	}

	public static long fibonacci(long[] arr,long n) {
		counter++;
		if(n==0 ){
			return 0;
		}else if(n==1){
			return 1;
		} else if (arr[(int) n]!=0 ){
			return arr[(int)n];
		}else {
			return (arr[(int) n] = fibonacci(arr,n - 1) + fibonacci(arr,n - 2));
		}
	}

}
