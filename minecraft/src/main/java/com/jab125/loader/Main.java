package com.jab125.loader;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        args = new String[]{"--accessToken", "", "--version", "DEV", "--assetsDir", args[0], "--assetIndex", "5"};
        String[] newaArgs = {"net.minecraft.client.main.Main"};
        com.jab125.tweakloader.Main.main(concatWithArrayCopy(newaArgs, args));
    }

    static <T> T[] concatWithArrayCopy(T[] array1, T[] array2) {
        T[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
}
