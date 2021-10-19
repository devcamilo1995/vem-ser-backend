package com.dbc.Aula6.Funcional;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculoTest {
    @Test
    public void deveConterImplementacaoComSoma(){
        //setup
        Calculo calculo = new Calculo() {
            @Override
            public int gerar(int valor, int valor2) {
                return valor + valor2;
            }
        };
        //act
        int verifica = calculo.gerar(10,20);

        //assert
        assertEquals(30,verifica);
    }
}
