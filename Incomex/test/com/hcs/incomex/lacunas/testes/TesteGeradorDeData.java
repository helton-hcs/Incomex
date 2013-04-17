/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.lacunas.testes;

import com.hcs.incomex.lacunas.GeradorDeData;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author helton
 */
public class TesteGeradorDeData {
    
    @Test
    public void TesteDataComValorInicial() {
        assertTrue(new GeradorDeData(1950).getData().compareTo(new GregorianCalendar(1950, 01, 01))>=0);
    }
    
    @Test
    public void TesteDataComIntervalos() {
        assertTrue(new GeradorDeData(1950,2013).getData().compareTo(new GregorianCalendar(2013, 12, 31))<=0);        
    }
    
}
