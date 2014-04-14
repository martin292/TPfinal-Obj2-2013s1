package Fechas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;

import junit.framework.TestCase;

public class RangoTest extends TestCase {


	Rango rango1;
	Rango rango2;
	Rango rango3;
	Rango rango4;
	Rango rango5;
	Rango rango6;
	Rango rango7;
	Rango rango8;
	Calendar f1;
	Calendar f2;
	Calendar f3;
	Calendar f4;
	Calendar f5;
	Calendar f6;
	Calendar f7;
	Calendar f8;
	Calendar f9;
	Calendar f10;
	Calendar f11;

	public List<Rango> rangos = new ArrayList<Rango>();
	

	public void setUp(){
		
		rango1 = new Rango();
		rango2 = new Rango();
		rango3 = new Rango();
		rango4 = new Rango();
		rango5 = new Rango();
		rango6 = new Rango();
		rango7 = new Rango();
		rango8 = new Rango();
		
		f1 = Calendar.getInstance();
		f2 = Calendar.getInstance();
		f3 = Calendar.getInstance();
		f4 = Calendar.getInstance();
		f5 = Calendar.getInstance();
		f6 = Calendar.getInstance();
		f7 = Calendar.getInstance();
		f8 = Calendar.getInstance();
		f9 = Calendar.getInstance();
		f10 = Calendar.getInstance();
		f11 = Calendar.getInstance();
		
		f1.set(2013,8,10);	
		f2.set(2013,11,5);
		f3.set(2013,12,5);	
		f4.set(2014,10,5);
		f5.set(2014,11,5);
		f6.set(2013,7,10);
		f7.set(2013,9,10);
		f8.set(2014,1,1);
		f9.set(2013, 3, 8);
		f10.set(2013, 5, 22);
		f11.set(2013, 4, 16);
		
		rango1.setFechaInicio(f1); //2013,8,10
		rango1.setFechaFin(f2);    //2013,11,5
				
		rango2.setFechaInicio(f1); //2013,8,10
		rango2.setFechaFin(f2);    //2013,11,5
			
		rango3.setFechaInicio(f1); //2013,8,10
		rango3.setFechaFin(f3);    //2013,12,5
		
		rango4.setFechaInicio(f4); //2014,10,5
		rango4.setFechaFin(f5);    //2014,11,5
		
		rango5.setFechaInicio(f6); //2013,7,10
		rango5.setFechaFin(f2);    //2013,11,5
		
		rango6.setFechaInicio(f7); //2013,9,10
		rango6.setFechaFin(f2);    //2013,11,5
		
		rango7.setFechaInicio(f1); //2013,8,10
		rango7.setFechaFin(f8);    //2014,1,1
		
		rango8.setFechaInicio(f9);//2013, 3, 8
		rango8.setFechaFin(f10);  //2013, 5, 22
		
		rangos.add(rango1);
		rangos.add(rango3);
		rangos.add(rango4);
		rangos.add(rango5);
		rangos.add(rango6);
	}
	
	
	public void testIncluidoEn(){
				
		assertTrue(rango1.incluidoEn(rango2));
		assertTrue(rango1.incluidoEn(rango3));
		assertTrue(rango1.incluidoEn(rango5));
		assertTrue(rango6.incluidoEn(rango7));
		
		assertFalse(rango1.incluidoEn(rango6));
		assertFalse(rango1.incluidoEn(rango4));
		assertFalse(rango3.incluidoEn(rango2));
	}
	
	
	public void testEstaEn(){
		
		assertTrue(rango2.estaEn(rangos));//R2 esta incluido en la lista.
		
		assertFalse(rango7.estaEn(rangos));//R7 no esta incluido en la lista.
		
	}
	
	
	public void testIncluyeAUnaFecha(){ 
		
		assertTrue("FALLA LA INCLUSION DE LA FECHA f11 EN EL RANGO rango8", rango8.incluyeA(f11));
		assertTrue("FALLA LA INCLUSION DE LA FECHA f19 EN EL RANGO rango8", rango8.incluyeA(f9));
	}
	
	
	public void testIncluyeAUnRango(){
		
		assertTrue("FALLA LA INCLUSION DEL rango1 EN EL rango2", rango2.incluyeA(rango1));
		assertTrue("FALLA LA INCLUSION DEL rango6 EN EL rango7", rango7.incluyeA(rango6));
		assertTrue("FALLA LA INCLUSION DEL rango3 EN EL rango7", rango7.incluyeA(rango3));
		
		assertFalse("FALLA LA NO INCLUSION DEL rango1 EN EL rango4", rango4.incluyeA(rango1));
		assertFalse("FALLA LA NO INCLUSION DEL rango5 EN EL rango2", rango2.incluyeA(rango5));
		assertFalse("FALLA LA NO INCLUSION DEL rango8 EN EL rango1", rango1.incluyeA(rango8));
		
	}
	
	public void testEsIgual(){
		
		Calendar fi = Calendar.getInstance();
		Calendar ff = Calendar.getInstance();
		
		fi.set(2014,10,5);	
		ff.set(2014,11,5);
		
		rango5.setFechaInicio(fi);
		rango5.setFechaFin(ff);
		
		assertTrue("FALLA LA COMPARACION DE DOS RANGOS IGUALES", rango1.esIgual(rango2));
		//assertTrue("FALLA LA COMPARACION DE DOS RANGOS IGUALES", rango4.esIgual(rango5));
		assertFalse("FALLA LA COMPARACION DE DOS RANGOs DIFERENTES", rango1.esIgual(rango8));
	}
	
	public void testCantDias(){
		
		Calendar fi = Calendar.getInstance();
		Calendar ff = Calendar.getInstance();
		
		fi.set(2013,4,1);	
		ff.set(2013,4,27);
		
		rango1.setFechaInicio(fi);
		rango1.setFechaFin(ff);
		
		assertEquals(27, rango1.cantDias());
		assertEquals(87, rango2.cantDias());
		assertEquals(57, rango6.cantDias());
	}
	
	/**
	public void testCantDiasQueIncluye(){
		
		Calendar fInicio1 = Calendar.getInstance();
		Calendar fFin1 = Calendar.getInstance();
		Calendar fInicio2 = Calendar.getInstance();
		Calendar fFin2 = Calendar.getInstance();
		//Calendar fInicio3 = Calendar.getInstance();
		//Calendar fFin3 = Calendar.getInstance();
		
		//rango1: 2013,8,10  //9/7/2013
		        //2013,11,5  //4/10/2013
		
		fInicio1.set(2013, 1, 1);
		fFin1.set(2013, 1, 3);
		
		fInicio2.set(2013, 1, 1);
		fFin2.set(2013, 1, 3);
		
		rango5.setFechaInicio(fInicio1);
		rango5.setFechaFin(fFin1);
		
		rango6.setFechaInicio(fInicio2);
		rango6.setFechaFin(fFin2);
		
		assertEquals(3, rango6.cantDias());
		assertEquals(3, rango5.cantDiasQueIncluye(rango6));
		
		assertEquals(87, rango1.cantDiasQueIncluye(rango2)); // son rangos iguales
		assertEquals(0, rango3.cantDiasQueIncluye(rango4));
		assertEquals(5, rango1.cantDiasQueIncluye(rango5));
		assertEquals(21, rango1.cantDiasQueIncluye(rango6));
			
	}*/
	
}

