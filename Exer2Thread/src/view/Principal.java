package view;

import controller.ThreadSomaMat;

public class Principal {
	public static void main(String []args){
		int m[][] = new int[3][5];
		for(int x=0;x<3;x++){
			for(int y=0;y<5;y++){
				m[x][y] = (int)(Math.random() * 21);
			}
		}
		
		for(int x=0;x<3;x++){
			for(int y=0;y<5;y++){
				System.out.print(m[x][y]+" ");
			}
			System.out.println();
		}
		
		for (int x = 0; x<3 ; x++) {
			int a = m[x][0];
			int b = m[x][1];
			int c = m[x][2];
			int d = m[x][3];
			int e = m[x][4];
		Thread thread = new ThreadSomaMat(a,b,c,d,e);
		thread.start();
		}
		}
	}


