package com.smartStamp;

import com.smartStamp.etiquetas.application.GenerarCodigo;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication{

    @Inject 
    private GenerarCodigo generarCodigo;
    public static void main(String[] args) {
        Quarkus.run(Main.class,args);
    }
    @Override
    public int run(String... args) throws Exception {
        System.out.println("[Main] Funciono");
        var obj =generarCodigo.crearCodigo("adb");
        System.out.println(obj.toString());
        return 0;
    }

}
