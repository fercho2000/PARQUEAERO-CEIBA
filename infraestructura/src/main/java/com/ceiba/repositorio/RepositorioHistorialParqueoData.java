package com.ceiba.repositorio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ceiba.crudrepository.CrudHistorialParqueoRepository;
import com.ceiba.entity.EntityHistorialParqueo;
import com.ceiba.entity.EntityVehiculo;
import com.ceiba.modelo.HistorialParqueo;
import com.ceiba.modelo.Vehiculo;
import com.ceiba.puerto.repositorio.RepositorioHistorialParqueo;

@Repository
public class RepositorioHistorialParqueoData implements RepositorioHistorialParqueo {

	CrudHistorialParqueoRepository repositorioParqueo;
	
	
	public RepositorioHistorialParqueoData(CrudHistorialParqueoRepository repositorioParqueo) {
		this.repositorioParqueo = repositorioParqueo;
	}

	@Override
	public Double actualizarHistorial(HistorialParqueo historial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<HistorialParqueo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(HistorialParqueo historialParqueo) {

		Vehiculo vehiculo = historialParqueo.getVehiculo();
		EntityVehiculo entityVehiculo = new EntityVehiculo(vehiculo.getPlaca(), vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(), vehiculo.getMarca(), vehiculo.getModelo());;
		
		EntityHistorialParqueo entidadHistorialParqueo = new EntityHistorialParqueo(historialParqueo.getFechaIngreso(), historialParqueo.getFechaSalida(),
				historialParqueo.getPago(), entityVehiculo);
		this.repositorioParqueo.save(entidadHistorialParqueo);

	}

	@Override
	public boolean existe(String placaVehiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeHistorial(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int cantidadVehiculos(String tipo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String devuelveTipo(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int devuelveCilindraje(String placa) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}
