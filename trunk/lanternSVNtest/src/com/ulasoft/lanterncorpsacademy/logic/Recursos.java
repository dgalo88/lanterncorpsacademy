package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IRecursoDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.lantern.RecursoDAO;

public class Recursos {

	private static IRecursoDO recurso;
	private String Nombre;

	public Recursos() {

	}

	public Recursos(int i) {
		setNombre(Data.getRecurso(i+1));
	}

	public static List<IRecursoDO> obtenerRecursos() throws Exception {

		RecursoDAO recursoDAO = new RecursoDAO();
		List<IRecursoDO> recursos = new ArrayList<IRecursoDO>();

		for (int i = 0; i < 8; i++) {
			recurso = (IRecursoDO) recursoDAO.loadById(i);
			recursos.add(recurso);
		}

		return recursos;
	}

	public static TestTableModel asignarRecursos(TestTableModel tableDtaModel, //
			List<IRecursoDO> recursos) {

		for (int posicion = 0; posicion < recursos.size(); posicion++) {
			(recursos.get(posicion)).setId(posicion + 1);
			tableDtaModel.add(recursos.get(posicion));
		}
		return tableDtaModel;
	}

	public static TestTableModel asignarRec(TestTableModel tableDtaModel, //
			List<Recursos> recursos) {

		for (int posicion = 0; posicion < recursos.size(); posicion++) {
			recursos.get(posicion);
			tableDtaModel.add(recursos.get(posicion));
		}
		return tableDtaModel;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getNombre() {
		return Nombre;
	}

}
