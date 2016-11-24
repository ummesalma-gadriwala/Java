  //////////////////////////
 // Umme Salma Gadriwala //
//////////////////////////

package cs2s03;
public class MatrixArrayRC{
	/*
	* implements a n x n matrix using an Array of rows
	* of Arrays of values
	*/

	private long [] [] mat;         // [row] [column]
	private int dim;
	
	private MatrixArrayRC () {}

	public MatrixArrayRC (long[] mat) throws WrongLength {
		if (mat.length != 9) {
			throw new WrongLength(9, "MatrixArrayRC",mat.length);
		}
		//takes an array of 9 elements
		dim = 3;
		this.mat = new long[3][3];
		this.mat[0][0] = mat[0];
		this.mat[0][1] = mat[1];
		this.mat[0][2] = mat[2];
		this.mat[1][0] = mat[3];
		this.mat[1][1] = mat[4];
		this.mat[1][2] = mat[5];
		this.mat[2][0] = mat[6];
		this.mat[2][1] = mat[7];
		this.mat[2][2] = mat[8];
	}

	public MatrixArrayRC (int n, long[] mat) throws WrongLength {
		//takes an array of nxn elements
		/*
		elem: index of local array mat
		r: row index of global array mat
		c: column index of global array mat
		*/
		if (mat.length != (n*n)) {
			throw new WrongLength(n*n, "MatrixArrayRC",mat.length);
		}
		dim = n;
		int elem = 0;
		this.mat = new long[n][n];
		for (int r = 0; r < n ; r++) {
			for (int c = 0; c < n ; c++) {
				this.mat[r][c] = mat[elem];
				elem = elem + 1;
			}
		}
	}

	private MatrixArrayRC identityMatrix () throws WrongLength {
		long[] a0 = new long[dim*dim];
		int index = 0;
		for (int q = 0; q < dim; q++){
			a0[index] = 1;
			index = index + dim + 1;
		}
		MatrixArrayRC id = new MatrixArrayRC(dim, a0);
		return id;
	}

	private MatrixArrayRC copyMatrix () throws WrongLength {
		long [][] duplicateMatrix = mat;
		//flatten matrix 
		long [] flatArray = new long[dim*dim];
		int index = 0;
		for (long[] m : duplicateMatrix) {
			for (int n = 0; n < dim; n++){
			flatArray[index] = m[n];
			}
		}		
		MatrixArrayRC copy = new MatrixArrayRC (dim, flatArray);
		return copy;
	}

	public long[] toArray () {
		long [] arrayMatrix = new long [dim*dim];
		int elem = 0;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				arrayMatrix[elem] = mat[i][j];
				elem++;
			}
		}
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

	public MatrixArrayRC matrixpower (int i) throws WrongLength, WrongPower {
		//computes matrix product A^i = A x A x ... x A
		/*
		* i = > 0, power of A
		* a0 = identity matrix
		* product = A^1 = A
		*/
		if (i < 0) {
			throw new WrongPower(i, "MatrixArrayRC");
		}
		MatrixArrayRC a0 = (identityMatrix ());
		if (i == 0) { return a0; }
		long[] flatMatrix = new long [dim*dim];
		int elem = 0;
		for (int p = 0; p < dim; p++) {
			for (int q = 0; q < dim; q++) {
				flatMatrix[elem] = mat[p][q];
				elem++;
			}
		}
		long product [] = flatMatrix;
		for (int power = 1; power < i; power++){   //mat*mat i times
			product = mult(flatMatrix, product);
		}
		MatrixArrayRC result = new MatrixArrayRC(dim, product);
		return result;
	}
}
