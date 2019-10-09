package learn.basic;

// singleton
public class PrimitiveData {

	private PrimitiveData() {

	}

	private static class Helper {
		private static final PrimitiveData INSTANCE = new PrimitiveData();
	}

	public static PrimitiveData getInstance() {
		return Helper.INSTANCE;
	}

	public final byte	BYTE_MIN 		=	-128;					//	-2^7
	public final byte 	BYTE_MAX 		= 	127; 					//	2^7 - 1
	public final short 	SHORT_MIN		= 	-32768;					//	-2^15
	public final short 	SHORT_MAX 		= 	32767; 					//	2^15 - 1
	public final int 	INT_MIN 		= 	-2147483648; 			//	-2^31
	public final int 	INT_MAX 		= 	2147483647; 			//	2^31 - 1
	public final long 	LONG_MIN 		= 	-9223372036854775808l;	//	-2^63
	public final long 	LONG_MAX 		= 	9223372036854775807l;	//	2^63 - 1

}
