package test;

import com.fasterxml.uuid.Generators;

public class MainCore {

    public static void main(String[] args) {
        System.out.println("UUID Version 1: " + Generators.timeBasedGenerator().generate());
        System.out.println("UUID Version 6: " + Generators.timeBasedReorderedGenerator().generate());
        System.out.println("UUID Version 7: " + Generators.timeBasedEpochGenerator().generate());
    }

}
