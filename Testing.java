  //////////////////////////
 // Umme Salma Gadriwala //
//////////////////////////

package cs2s03;
import static org.junit.Assert.*;
import org.junit.Test;

public class Testing {
	//10 test matrices
	public static long [] m01  =     {0,1,1,0,0,0,0,0,0};   //m01 square is 0
	public static long [] m02  =     {2,1,2,0,0,0,0,0,0};
	public static long [] m03  =     {0,1,2,3,0,0,0,0,0};
	public static long [] m04  =     {0,1,2,3,4,0,0,0,0};
	public static long [] m05  =     {0,1,2,3,4,5,0,0,0};
	public static long [] m06  =     {0,1,2,3,4,5,6,0,0};
	public static long [] m07  =     {0,1,2,3,4,5,6,7,0};
	public static long [] m08  =     {0,1,2,3,4,5,6,7,8};
	public static long [] m09  =     {1,1,2,0,0,0,0,0,0};
	public static long [] m10 =      {5,-3,2,15,-9,6,10,-6,4};    //m10 square is 0
	
	//identity matrix
	public static long [] identity = {1,0,0,0,1,0,0,0,1};
	//matrix squared
	public static long [] m1s  =    {0,0,0,0,0,0,0,0,0};   //m1 square is 0
	public static long [] m2s  =    {4,2,4,0,0,0,0,0,0};
	public static long [] m3s  =    {3,0,0,0,3,6,0,0,0};
	public static long [] m4s  =    {3,4,0,12,19,6,0,0,0};
	public static long [] m5s  =    {3,4,5,12,19,26,0,0,0};
	public static long [] m6s  =    {15,4,5,42,19,26,0,6,12};
	public static long [] m7s  =    {15,18,5,42,54,26,21,34,47};
	public static long [] m8s  =    {15,18,21,42,54,66,69,90,111};
	public static long [] m9s  =    {1,1,2,0,0,0,0,0,0};
	public static long [] m10s =    {0,0,0,0,0,0,0,0,0};    //m10 square is 0
	
	//matrix cubed
	public static long [] m1c  =    {0,0,0,0,0,0,0,0,0};   //m1 cubed is 0
	public static long [] m2c  =    {8,4,8,0,0,0,0,0,0};
	public static long [] m3c  =    {0,3,6,9,0,0,0,0,0};
	public static long [] m4c  =    {12,19,6,57,88,24,0,0,0};
	public static long [] m5c  =    {12,19,26,57,88,119,0,0,0};
	public static long [] m6c  =    {42,31,50,213,118,179,90,24,30};
	public static long [] m7c  =    {84,122,120,318,440,354,384,486,212};
	public static long [] m8c  =    {180,234,288,558,720,882,936,1206,1476};
	public static long [] m9c  =    {1,1,2,0,0,0,0,0,0};
	public static long [] m10c =    {0,0,0,0,0,0,0,0,0};    //m10 cubed is 0

	
	@Test (expected = WrongPower.class)
	public void test() throws WrongLength, WrongPower {
		long [] [] testMatrices = { m01, m02, m03, m04, m05,
				                    m06, m07, m08, m09, m10 };
		long [] [] testSquare =   { m1s, m2s, m3s, m4s, m5s,
                                    m6s, m7s, m8s, m9s, m10s };
		long [] [] testCube =     { m1c, m2c, m3c, m4c, m5c,
                                    m6c, m7c, m8c, m9c, m10c };

		//testing Matrix3x3flat
		for (int k = 0; k < 10 ; k++) {
			Matrix3x3flat t = new Matrix3x3flat (testMatrices[k]);
			//try {
			t.matrixpower(-1);
//				fail("Power less than 0");
//			}
//			catch (WrongPower e) {assertTrue(true);}
			assertArrayEquals(identity,(t.matrixpower(0)).toArray());
			assertArrayEquals(testMatrices[k],(t.matrixpower(1)).toArray());
			assertArrayEquals(testSquare[k],(t.matrixpower(2)).toArray());
			assertArrayEquals(testCube[k],(t.matrixpower(3)).toArray());
		}
		
		//testing Matrix3x3rc
		for (int k = 0; k < 10 ; k++) {
			Matrix3x3rc t = new Matrix3x3rc(testMatrices[k]);
//			try {
			t.matrixpower(-1);
//				fail("Power less than 0");
//			}
//			catch (WrongPower e) {assertTrue(true);}
			assertArrayEquals(identity,(t.matrixpower(0)).toArray());
			assertArrayEquals(testMatrices[k],(t.matrixpower(1)).toArray());
			assertArrayEquals(testSquare[k],(t.matrixpower(2)).toArray());
			assertArrayEquals(testCube[k],(t.matrixpower(3)).toArray());;
		}
		
		//testing Matrix3x3cr
		for (int k = 0; k < 10 ; k++) {

			Matrix3x3cr t = new Matrix3x3cr(testMatrices[k]);
//			try {
			t.matrixpower(-1);
//				fail("Power less than 0");
//			}
//			catch (WrongPower e) {assertTrue(true);}
			//assertEquals(t.matrixpower(-1), );
			assertArrayEquals(identity,(t.matrixpower(0)).toArray());
			assertArrayEquals(testMatrices[k],(t.matrixpower(1)).toArray());
			assertArrayEquals(testSquare[k],(t.matrixpower(2)).toArray());
			assertArrayEquals(testCube[k],(t.matrixpower(3)).toArray());;
		}
		
		//testing MatrixArrayFlat
		
		for (int k = 0; k < 10 ; k++) {
			MatrixArrayFlat t = new MatrixArrayFlat(testMatrices[k]);
//			try {
			t.matrixpower(-1);
//				fail("Power less than 0");
//			}
//			catch (WrongPower e) {assertTrue(true);}
			//assertEquals(t.matrixpower(-1), );
			assertArrayEquals(identity,(t.matrixpower(0)).toArray());
			assertArrayEquals(testMatrices[k],(t.matrixpower(1)).toArray());
			assertArrayEquals(testSquare[k],(t.matrixpower(2)).toArray());
			assertArrayEquals(testCube[k],(t.matrixpower(3)).toArray());;
		}
		
		//testing MatrixArrayRC
		for (int k = 0; k < 10 ; k++) {
			MatrixArrayRC t = new MatrixArrayRC(testMatrices[k]);
//			try {
			t.matrixpower(-1);
//				fail("Power less than 0");
//			}
//			catch (WrongPower e) {assertTrue(true);}
			//assertEquals(t.matrixpower(-1), );
			assertArrayEquals(identity,(t.matrixpower(0)).toArray());
			assertArrayEquals(testMatrices[k],(t.matrixpower(1)).toArray());
			assertArrayEquals(testSquare[k],(t.matrixpower(2)).toArray());
			assertArrayEquals(testCube[k],(t.matrixpower(3)).toArray());;
		}
		
		//testing MatrixArrayCR
		for (int k = 0; k < 10 ; k++) {
			MatrixArrayCR t = new MatrixArrayCR(testMatrices[k]);
//			try {
			t.matrixpower(-1);
//				fail("Power less than 0");
//			}
//			catch (WrongPower e) {assertTrue(true);}
			//assertEquals(t.matrixpower(-1), );
			assertArrayEquals(identity,(t.matrixpower(0)).toArray());
			assertArrayEquals(testMatrices[k],(t.matrixpower(1)).toArray());
			assertArrayEquals(testSquare[k],(t.matrixpower(2)).toArray());
			assertArrayEquals(testCube[k],(t.matrixpower(3)).toArray());;
		}
		
		  //////////////////////////////////////
		 //testing classes against each other//
		//////////////////////////////////////
		
		Matrix3x3flat [] mat3x3flat = {  new Matrix3x3flat (m01), 
				                         new Matrix3x3flat (m02), 
				                         new Matrix3x3flat (m03), 
				                         new Matrix3x3flat (m04), 
				                         new Matrix3x3flat (m05), 
				                         new Matrix3x3flat (m06), 
				                         new Matrix3x3flat (m07), 
				                         new Matrix3x3flat (m08), 
				                         new Matrix3x3flat (m09), 
				                         new Matrix3x3flat (m10)  };

		Matrix3x3rc [] mat3x3rc = {  new Matrix3x3rc (m01), 
									 new Matrix3x3rc (m02), 
									 new Matrix3x3rc (m03), 
							         new Matrix3x3rc (m04), 
                                     new Matrix3x3rc (m05), 
                					 new Matrix3x3rc (m06), 
                					 new Matrix3x3rc (m07), 
                					 new Matrix3x3rc (m08), 
                					 new Matrix3x3rc (m09), 
                					 new Matrix3x3rc (m10)  };

		Matrix3x3cr [] mat3x3cr = {  new Matrix3x3cr (m01), 
				                     new Matrix3x3cr (m02), 
				                     new Matrix3x3cr (m03), 
				                     new Matrix3x3cr (m04), 
				                     new Matrix3x3cr (m05), 
				                     new Matrix3x3cr (m06), 
				                     new Matrix3x3cr (m07), 
				                     new Matrix3x3cr (m08), 
				                     new Matrix3x3cr (m09), 
				                     new Matrix3x3cr (m10)  };
		
		MatrixArrayFlat [] matArrayFlat = {  new MatrixArrayFlat (m01), 
                                             new MatrixArrayFlat (m02), 
                                             new MatrixArrayFlat (m03), 
                                             new MatrixArrayFlat (m04), 
                                             new MatrixArrayFlat (m05), 
                                             new MatrixArrayFlat (m06), 
                                             new MatrixArrayFlat (m07), 
                                             new MatrixArrayFlat (m08), 
                                             new MatrixArrayFlat (m09), 
                                             new MatrixArrayFlat (m10)  };
		
		MatrixArrayRC [] matArrayRC = {  new MatrixArrayRC (m01), 
                						 new MatrixArrayRC (m02), 
                						 new MatrixArrayRC (m03), 
                						 new MatrixArrayRC (m04), 
                						 new MatrixArrayRC (m05), 
                						 new MatrixArrayRC (m06), 
                						 new MatrixArrayRC (m07), 
                						 new MatrixArrayRC (m08), 
                						 new MatrixArrayRC (m09), 
                						 new MatrixArrayRC (m10)  };
		
		MatrixArrayCR [] matArrayCR = {  new MatrixArrayCR (m01), 
				                         new MatrixArrayCR (m02), 
				                         new MatrixArrayCR (m03), 
				                         new MatrixArrayCR (m04), 
				                         new MatrixArrayCR (m05), 
				                         new MatrixArrayCR (m06), 
				                         new MatrixArrayCR (m07), 
				                         new MatrixArrayCR (m08), 
				                         new MatrixArrayCR (m09), 
				                         new MatrixArrayCR (m10)  };

        //3x3flat against all                                 
		for (int matrix = 0; matrix < 10; matrix++) {
			for (int power = -1; power <= 3; power++) {
				assertArrayEquals(   ((mat3x3flat[matrix]).matrixpower(power)).toArray(),
						             ((mat3x3flat[matrix]).matrixpower(power)).toArray()    );    //expected, actual
				assertArrayEquals(   ((mat3x3flat[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3rc[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((mat3x3flat[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3cr[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((mat3x3flat[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayFlat[matrix]).matrixpower(power)).toArray()  );
				assertArrayEquals(   ((mat3x3flat[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayRC[matrix]).matrixpower(power)).toArray()    );
				assertArrayEquals(   ((mat3x3flat[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayCR[matrix]).matrixpower(power)).toArray()    );
			}
		}
		
		//3x3rc against all
		for (int matrix = 0; matrix < 10; matrix++) {
			for (int power = -1; power <= 3; power++) {
				assertArrayEquals(   ((mat3x3rc[matrix]).matrixpower(power)).toArray(),
						             ((mat3x3flat[matrix]).matrixpower(power)).toArray()    );    //expected, actual
				assertArrayEquals(   ((mat3x3rc[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3rc[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((mat3x3rc[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3cr[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((mat3x3rc[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayFlat[matrix]).matrixpower(power)).toArray()  );
				assertArrayEquals(   ((mat3x3rc[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayRC[matrix]).matrixpower(power)).toArray()    );
				assertArrayEquals(   ((mat3x3rc[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayCR[matrix]).matrixpower(power)).toArray()    );
			}
		}

		//3x3cr against all
		for (int matrix = 0; matrix < 10; matrix++) {
			for (int power = -1; power <= 3; power++) {
				assertArrayEquals(   ((mat3x3cr[matrix]).matrixpower(power)).toArray(),
						             ((mat3x3flat[matrix]).matrixpower(power)).toArray()    );    //expected, actual
				assertArrayEquals(   ((mat3x3cr[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3rc[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((mat3x3cr[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3cr[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((mat3x3cr[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayFlat[matrix]).matrixpower(power)).toArray()  );
				assertArrayEquals(   ((mat3x3cr[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayRC[matrix]).matrixpower(power)).toArray()    );
				assertArrayEquals(   ((mat3x3cr[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayCR[matrix]).matrixpower(power)).toArray()    );
			}
		}
		
		//arrayFlat against all
		for (int matrix = 0; matrix < 10; matrix++) {
			for (int power = -1; power <= 3; power++) {
				assertArrayEquals(   ((matArrayFlat[matrix]).matrixpower(power)).toArray(),
						             ((mat3x3flat[matrix]).matrixpower(power)).toArray()    );    //expected, actual
				assertArrayEquals(   ((matArrayFlat[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3rc[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((matArrayFlat[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3cr[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((matArrayFlat[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayFlat[matrix]).matrixpower(power)).toArray()  );
				assertArrayEquals(   ((matArrayFlat[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayRC[matrix]).matrixpower(power)).toArray()    );
				assertArrayEquals(   ((matArrayFlat[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayCR[matrix]).matrixpower(power)).toArray()    );
			}
		}
		
		//arrayRC against all
		for (int matrix = 0; matrix < 10; matrix++) {
			for (int power = -1; power <= 3; power++) {
				assertArrayEquals(   ((matArrayRC[matrix]).matrixpower(power)).toArray(),
						             ((mat3x3flat[matrix]).matrixpower(power)).toArray()    );    //expected, actual
				assertArrayEquals(   ((matArrayRC[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3rc[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((matArrayRC[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3cr[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((matArrayRC[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayFlat[matrix]).matrixpower(power)).toArray()  );
				assertArrayEquals(   ((matArrayRC[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayRC[matrix]).matrixpower(power)).toArray()    );
				assertArrayEquals(   ((matArrayRC[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayCR[matrix]).matrixpower(power)).toArray()    );
			}
		}
		
		//arrayCR against all
		for (int matrix = 0; matrix < 10; matrix++) {
			for (int power = -1; power <= 3; power++) {
				assertArrayEquals(   ((matArrayCR[matrix]).matrixpower(power)).toArray(),
						             ((mat3x3flat[matrix]).matrixpower(power)).toArray()    );    //expected, actual
				assertArrayEquals(   ((matArrayCR[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3rc[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((matArrayCR[matrix]).matrixpower(power)).toArray(),
				                     ((mat3x3cr[matrix]).matrixpower(power)).toArray()      );
				assertArrayEquals(   ((matArrayCR[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayFlat[matrix]).matrixpower(power)).toArray()  );
				assertArrayEquals(   ((matArrayCR[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayRC[matrix]).matrixpower(power)).toArray()    );
				assertArrayEquals(   ((matArrayCR[matrix]).matrixpower(power)).toArray(),
				                     ((matArrayCR[matrix]).matrixpower(power)).toArray()    );
			}
		} 
	} 
}
