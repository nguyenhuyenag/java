package common.util;

// singleton
public class DataTypes {

	private DataTypes() {

	}

	private static class Helper {
		private static final DataTypes INSTANCE = new DataTypes();
	}

	public static DataTypes getInstance() {
		return Helper.INSTANCE;
	}

	public final byte MIN_BYTE 		=	-128;					//	-2^7
	public final byte MAX_BYTE 		= 	127; 					//	2^7 - 1
	public final short MIN_SHORT	= 	-32768;					//	-2^15
	public final short MAX_SHORT 	= 	32767; 					//	2^15 - 1
	public final int MIN_INT 		= 	-2147483648; 			//	-2^31
	public final int MAX_INT 		= 	2147483647; 			//	2^31 - 1
	public final long MIN_LONG 		= 	-9223372036854775808l;	//	-2^63
	public final long MAX_LONG 		= 	9223372036854775807l;	//	2^63 - 1

}
