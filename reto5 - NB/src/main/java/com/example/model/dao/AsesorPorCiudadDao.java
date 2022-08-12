package com.example.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.model.vo.AsesorPorCiudadVo;
import com.example.util.JDBCUtilities;

public class AsesorPorCiudadDao {

    public ArrayList<AsesorPorCiudadVo> listar() throws SQLException{

        ArrayList<AsesorPorCiudadVo> resultado = new ArrayList<AsesorPorCiudadVo>();

        Connection conn = JDBCUtilities.getConnection();
        
        try {
            
            String csql = "SELECT l.ID_Lider, l.Nombre, l.Primer_Apellido, l.Ciudad_Residencia " +
                          "FROM Lider l " +
                          "ORDER BY l.Ciudad_Residencia;";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(csql);

            while(rs.next()){

                AsesorPorCiudadVo asesor = new AsesorPorCiudadVo(
                    rs.getInt("ID_Lider"),
                    rs.getString("Nombre"),
                    rs.getString("Primer_Apellido"),
                    rs.getString("Ciudad_Residencia")
                );

                resultado.add(asesor);

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error en la consulta");
        } finally{

            if(conn != null){

                conn.close();
            }



        }

        return resultado;
    }
    


}