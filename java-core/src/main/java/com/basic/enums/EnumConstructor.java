package com.basic.enums;

import java.io.IOException;

public class EnumConstructor {
	
	enum Level {
	    INFO(1, "Informative message", 0x00aa00),
	    WARNING(2, "Warning message", 0xFFA500),
	    ERROR(3, "Error message", 0xA30000);

	    private final int severity;
	    private final String label;
	    private final int color;

	    private Level(int severity, String label, int color) {
	        this.severity = severity;
	        this.label = label;
	        this.color = color;
	    }

	    public int getSeverity() {
	        return severity;
	    }

	    public String getLabel() {
	        return label;
	    }

	    public int getColor() {
	        return color;
	    }
	}

	public static void main(String[] args) throws IOException {
		for (Level level : Level.values()) {
		    System.out.println("Level " + level.name()
		            + "\n\tSeverity: " + level.getSeverity()
		            + "\n\tLabel: " + level.getLabel()
		            + "\n\tColor: " + level.getColor());
		}
	}

}
