package com.dws.practicaweb;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Componentes {

    private String ram;
    private String grafica;
    private String procesador;

    public Componentes(String ram, String grafica, String procesador ){
        this.grafica=grafica;
        this.procesador=procesador;
        if(ram=="4"||ram =="8"||ram=="12"||ram=="16"||ram=="32"){
            this.ram=ram;
        }else{
            ram="0";
        }
    }


    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGrafica() {
        return grafica;
    }

    public void setGrafica(String grafica) {
        this.grafica = grafica;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    @Override
    public String toString() {
        return "Ram= " + ram + "grafica: " + grafica + "procesador: " + procesador;
    }
}
