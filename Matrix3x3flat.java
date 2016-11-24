package cs2s03;

public class Matrix3x3flat {
	private class Record9 {        
		//single private record with 9 fields
			long t1;
			long t2;
			long t3;
			long t4;
			long t5;
			long t6;
			long t7;
			long t8;
			long t9;

			private Record9 (long[] mat) {
				t1 = mat[0];
				t2 = mat[1];
				t3 = mat[2];
				t4 = mat[3];
				t5 = mat[4];
				t6 = mat[5];
				t7 = mat[6];
				t8 = mat[7];
				t9 = mat[8];
			}
		}

		private Record9 mat;

		private Matrix3x3flat () {}

		public Matrix3x3flat (long[] mat) throws WrongLength {
			if (mat.length != 9) {
				throw new WrongLength(9, "Matrix3x3flat",mat.length);
			}
			this.mat = new Record9 (mat);
		}

		private Matrix3x3flat identityMatrix () throws WrongLength {
			//returns a 3x3 identity matrix of type Matrix3x3flat
			long[] id = {1,0,0,0,1,0,0,0,1};
//			Matrix3x3flat a0 = null;
//			try {
			Matrix3x3flat a0 = new Matrix3x3flat(id);
//			} catch (WrongLength e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return a0;
		}

		private Matrix3x3flat copyMatrix (Matrix3x3flat mat) throws WrongLength {
			//takes a matrix and returns a copy
			Matrix3x3flat copy = mat;
			return copy;
		}

		public long[] toArray () {
			//returns a flat array of type long
			long [] arrayMatrix = {mat.t1, 
								   mat.t2,
								   mat.t3,
								   mat.t4,
								   mat.t5,
								   mat.t6,
								   mat.t7,
								   mat.t8,
								   mat.t9};
			
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

		public Matrix3x3flat matrixpower (int i) throws WrongLength, WrongPower {
			//computes matrix product A^i = A x A x ... x A
			/*
			* i = > 0, power of A
			* a0 = identity matrix
			* product = A^1 = A
			*/
			if (i < 0) {
				throw new WrongPower(i, "Matrix3x3flat");
			}
			Matrix3x3flat a0 = (identityMatrix ());
			
			//long[] product = {0,0,0,0,0,0,0,0,0};
			if (i == 0) { return a0; }
			//flattens matrix
			long [] flatMatrix = {mat.t1,
								  mat.t2, 
								  mat.t3, 
								  mat.t4, 
								  mat.t5, 
								  mat.t6, 
								  mat.t7, 
								  mat.t8, 
								  mat.t9};
			long[] product = flatMatrix;
			for (int power = 1; power < i; power++){   //mat*mat i times
				product = mult(flatMatrix, product);
			}
			Matrix3x3flat result = new Matrix3x3flat (product);

			return result;
		}
}
