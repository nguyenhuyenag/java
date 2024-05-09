package collection.array;

public class CheckIsAnArray {
	
	public static boolean isArray(Object obj) {
	    return obj instanceof Object[] || obj instanceof boolean[] || 
	      obj instanceof byte[] || obj instanceof short[] || 
	      obj instanceof char[] || obj instanceof int[] || 
	      obj instanceof long[] || obj instanceof float[] || 
	      obj instanceof double[];
	}

	public static void main(String[] args) {
		final Object ARRAY_INT = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(ARRAY_INT instanceof Object[]);
		System.out.println(ARRAY_INT instanceof int[]);
		System.out.println(isArray(ARRAY_INT));
		
		System.out.println(ARRAY_INT.getClass().isArray());
		System.out.println(ARRAY_INT.getClass().getComponentType());
	}

}
