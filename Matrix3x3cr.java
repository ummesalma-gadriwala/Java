package cs2s03;
public class Matrix3x3cr {
	/*
	implements a 3 x 3 matrix using a record of 3 columns;
	each column should be a record of 3 values
	*/
	private class Column3 {        
	//columns
		private Row3 c0;
		private Row3 c1;
		private Row3 c2;

		private Column3 (long[] mat) {
			c0 = new Row3(mat[0], mat[3],mat[6]);
			c1 = new Row3(mat[1], mat[4],mat[7]);
			c2 = new Row3(mat[2], mat[5],mat[8]);
		}
	}

	private class Row3 {
		long r0;
		long r1;
		long r2;
		private Row3 (long r0, long r1, long r2) {
			this.r0 = r0;
			this.r1 = r1;
			this.r2 = r2;
		}
	}

	private Column3 mat;
	
	private Matrix3x3cr() {}

	public Matrix3x3cr(long[] mat) throws WrongLength {
		if (mat.length != 9) {
		throw new WrongLength(9, "Matrix3x3cr",mat.length);
		}
		this.mat = new Column3 (mat);
	}

	private Matrix3x3cr identityMatrix () throws WrongLength {
		long[] id = {1,0,0,0,1,0,0,0,1};
//		Matrix3x3cr a0 = null;
//		try {
			Matrix3x3cr a0 = new Matrix3x3cr (id);
//		} catch (WrongLength e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return a0;
	}

	private Matrix3x3cr copyMatrix (Matrix3x3cr mat) throws WrongLength {
		Matrix3x3cr copy = mat;
		return copy;
	}

	public long[] toArray () {
		long [] arrayMatrix = {mat.c0.r0,
						 mat.c1.r0, 
						 mat.c2.r0, 
						 mat.c0.r1, 
						 mat.c1.r1, 
						 mat.c2.r1, 
						 mat.c0.r2, 
						 mat.c1.r2, 
						 mat.c2.r2};
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
	
	public Matrix3x3cr matrixpower (int i) throws WrongLength, WrongPower {
		//computes matrix product A^i = A x A x ... x A
		/*
		* i = > 0, power of A
		* a0 = identity matrix
		* product = A^1 = A
		*/
		if (i < 0) {
			throw new WrongPower(i, "Matrix3x3cr");
		}
		Matrix3x3cr a0 = (identityMatrix ());
		if (i == 0) { return a0; }
		long[] flatMatrix = {mat.c0.r0,
						 	 mat.c1.r0, 
						  	 mat.c2.r0, 
						 	 mat.c0.r1, 
						 	 mat.c1.r1, 
						 	 mat.c2.r1, 
						  	 mat.c0.r2, 
						 	 mat.c1.r2, 
						 	 mat.c2.r2};
		long[] product = flatMatrix;
		for (int power = 1; power < i; power++){   //mat*mat i times
			product = mult(flatMatrix, product);
		}

//		Matrix3x3cr result = null;
//		try {
			Matrix3x3cr result = new Matrix3x3cr (product);
//		} catch (WrongLength e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return result;
	}
}