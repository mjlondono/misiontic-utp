package com.example.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.model.dao.AsesorPorCiudadDao;
import com.example.model.vo.AsesorPorCiudadVo;
import com.example.model.dao.ProyectoCasaCampestreDao;
import com.example.model.vo.ProyectoCasaCampestreVo;
import com.example.model.dao.CompraPorProveedorDao;
import com.example.model.vo.CompraPorProveedorVo;

public class RequerimientoController {

    private final AsesorPorCiudadDao asesorPorCiudadDao;
    private final ProyectoCasaCampestreDao proyectoCasaCampestreDao;
    private final CompraPorProveedorDao compraPorProveedorDao;

    public RequerimientoController(){

        this.asesorPorCiudadDao = new AsesorPorCiudadDao();
        this.proyectoCasaCampestreDao = new ProyectoCasaCampestreDao();
        this.compraPorProveedorDao = new CompraPorProveedorDao();
    }

    public ArrayList<AsesorPorCiudadVo> consultarAsesorPorCiudad() throws SQLException{

        return this.asesorPorCiudadDao.listar();

    }

    public ArrayList<ProyectoCasaCampestreVo> consultarProyectoCasaCampestre() throws SQLException{

        return this.proyectoCasaCampestreDao.listar();

    }

    public ArrayList<CompraPorProveedorVo> consultarCompraPorProveedor() throws SQLException{

        return this.compraPorProveedorDao.listar();

    }
    
}
