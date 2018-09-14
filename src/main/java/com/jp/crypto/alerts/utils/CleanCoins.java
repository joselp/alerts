package com.jp.crypto.alerts.utils;

import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CleanCoins {

    public static void main(String... args){

        Set<String> coins = null;

        try {
            Path path = Paths.get(new ClassPathResource("PoloniexCoins").getFile().getAbsolutePath());
            coins = new HashSet<>();

            Stream<String> lines = Files.lines(path);

            coins = lines.map(s -> s.substring(s.indexOf("_") + 1)).collect(Collectors.toSet());

        } catch (Exception e){
            e.printStackTrace();
        }

        coins.forEach(s -> System.out.print(s+","));
    }

}
