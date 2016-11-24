package cs2s03;
import java.util.Vector;

public class Matrix3x3rc {
	/*
	implements a 3 x 3 matrix using a record of 3 rows;
	each row should be a record of 3 values
	*/
	private class Row3 {        
	//three rows
		public Column3 r0;
		public Column3 r1;
		public Column3 r2;

		private Row3 (long[] mat) {
			r0 = new Column3(mat[0], mat[1],mat[2]);
			r1 = new Column3(mat[3], mat[4],mat[5]);
			r2 = new Column3(mat[6], mat[7],mat[8]);
		}
	}

	private class Column3 {
		//three column values for each row
		long c0;
		long c1;
		long c2;
		private Column3 (long c0, long c1, long c2) {
			this.c0 = c0;
			this.c1 = c1;
			this.c2 = c2;
		}
	}

	private Row3 mat;
	
	private Matrix3x3rc() {}

	public Matrix3x3rc(long[] mat) throws WrongLength {
		if (mat.length != 9) {
			throw new WrongLength(9, "Matrix3x3rc",mat.length);
		}
		this.mat = new Row3 (mat);
	}

	private Matrix3x3rc identityMatrix () throws WrongLength {
		long[] id = {1,0,0,0,1,0,0,0,1};
//		Matrix3x3rc a0 = null;
//		try {
		Matrix3x3rc a0 = new Matrix3x3rc(id);
//		} catch (WrongLength e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return a0;
	}

	private Matrix3x3rc copyMatrix (Matrix3x3rc mat) throws WrongLength {
		Matrix3x3rc copy = mat;
		return copy;
	}

	public long[] toArray () {
		long [] arrayMatrix = { mat.r0.c0,
						 	    mat.r0.c1, 
						        mat.r0.c2, 
						        mat.r1.c0, 
						        mat.r1.c1, 
						        mat.r1.c2, 
						        mat.r2.c0, 
						        mat.r2.c1, 
						        mat.r2.c2 };
		return arrayMatrix;
	}
	
	private long[] mult (long [] matOne, long [] matTwo) {
		int ix = 0;
		long[] p = {0,0,0,0,0,0,0,0,0};
		int index = 0;
		for (int w = 0; w < 3; w++) {
			if (w==0){ ix = 0; }
			else if (w==1) { ix = 3; }
			else if (w==2) { ix = 6; }
			int init = ix;
			for (int y = 0; y < 3; y++) {
				int jy = y;
				long sum = 0;
				for (int x = 0; x < 3; x++) {
					sum = sum + matOne[ix]*matTwo[jy];
					jy = jy + 3;
					ix = ix + 1;
				}
				ix = init;
				p[index] = sum;
				if (index < 8){
					index++;
				}
			}
		}
		return p;
	}
	
	public Matrix3x3rc matrixpower (int i) throws WrongLength, WrongPower {
		//computes matrix product A^i = A x A x ... x A
		/*
		* i = > 0, power of A
		* a0 = identity matrix
		* product = A^1 = A
		*/
		if (i < 0) {
			throw new WrongPower(i, "Matrix3x3rc");
		}
		
		Matrix3x3rc a0 = (identityMatrix ());
		if (i == 0) { return a0; }

		long[] flatMatrix = {mat.r0.c0,
						 	mat.r0.c1, 
						 	mat.r0.c2, 
						 	mat.r1.c0, 
						 	mat.r1.c1, 
						 	mat.r1.c2, 
						 	mat.r2.c0, 
						 	mat.r2.c1, 
						 	mat.r2.c2};
		long[] product = flatMatrix;
		for (int power = 1; power < i; power++){   //mat*mat i times
			product = mult(flatMatrix, product);
		}

			Matrix3x3rc result = new Matrix3x3rc (product);

		return result;
		}
}
