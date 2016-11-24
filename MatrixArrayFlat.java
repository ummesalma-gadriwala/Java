  //////////////////////////
 // Umme Salma Gadriwala //
//////////////////////////

package cs2s03;
public class MatrixArrayFlat {
	/*
	implements a n x n matrix using a 1D Array
	*/
	private long[] mat;
	private int dim;
	
	private MatrixArrayFlat() {}

	public MatrixArrayFlat(long[] mat) throws WrongLength {
		//takes an array of 9 elements
		if (mat.length != 9) {
			throw new WrongLength(9, "MatrixArrayFlat",mat.length);
		}
		this.mat = new long[9];
		this.mat = mat;
		dim = 3;
	}

	public MatrixArrayFlat(int n, long[] mat) throws WrongLength {
		//takes an array of nxn elements
		if (mat.length != (n*n)) {
			throw new WrongLength(n*n, "MatrixArrayFlat",mat.length);
		}
		this.mat = new long[n*n];
		this.mat = mat;
		dim = n;
	}

	private MatrixArrayFlat identityMatrix () throws WrongLength {
		long[] a0 = new long[mat.length];
		int index = 0;
		for (int q = 0; q < dim; q++){
			a0[index] = 1;
			index = index + dim + 1;
		}
		MatrixArrayFlat id = new MatrixArrayFlat(dim, a0);
		return id;
	}
	//{1,0,0,0,1,0,0,0,1}
	private MatrixArrayFlat copyMatrix () throws WrongLength {
		MatrixArrayFlat copy = new MatrixArrayFlat(dim, mat);
		return copy;
	}

	public long[] toArray () {
		long [] arrayMatrix = mat;
		return arrayMatrix;
	}

	private long[] mult (long [] matOne, long [] matTwo) {
		int ix = 0;
		long[] p = new long[dim*dim];
		int index = 0;
		for (int w = 0; w < dim; w++) {
			int init = ix;
			for (int y = 0; y < dim; y++) {
				int jy = y;
				long sum = 0;
				for (int x = 0; x < dim; x++) {
					sum = sum + matOne[ix]*matTwo[jy];
					jy = jy + dim;
					ix = ix + 1;
				}
				ix = init;
				p[index] = sum;
				if (index < (dim*dim - 1)){
					index++;
				}
			}
			ix = ix + dim;
		}
		return p;
	}
	
	public MatrixArrayFlat matrixpower (int i) throws WrongLength, WrongPower {
		//computes matrix product A^i = A x A x ... x A
		/*
		* i = > 0, power of A
		* a0 = identity matrix
		* product = A^1 = A
		*/
		if (i < 0) {
			throw new WrongPower(i, "MatrixArrayFlat");
		}
		MatrixArrayFlat a0 = (identityMatrix ());
		if (i == 0) { return a0; }
		long[] flatMatrix = mat;
		long[] product = flatMatrix;

		for (int power = 1; power < i; power++){   //mat*mat i times
			product = mult(flatMatrix, product);
		}
		MatrixArrayFlat result = new MatrixArrayFlat(dim, product);
		return result;
	}
}
