package com.makesystem.statusvenda.util;

import java.lang.reflect.Field;

public class Reflexao {

	String atributoRecuperado = null;
	
	public String refletirObjetos(Class classe) {
		
		Field[] atributos = classe.getDeclaredFields();
		//System.out.println("Teste " + atributos.toString());
		for(Field F: atributos) {
			String atributoRecuperado = F.getName();
			System.out.print(atributoRecuperado + ";");
		}
		return atributoRecuperado;
	}
}
