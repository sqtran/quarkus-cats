package com.steve;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import lombok.extern.java.Log;

@QuarkusMain
@Log
public class Main {

    public static void main(String ... args) {
        log.info("Running main method");
        Quarkus.run(args);
    }
}
