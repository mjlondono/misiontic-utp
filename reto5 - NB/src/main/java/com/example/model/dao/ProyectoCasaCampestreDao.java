package com.example.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.model.vo.ProyectoCasaCampestreVo;
import com.example.util.JDBCUtilities;

public class ProyectoCasaCampestreDao {

    public ArrayList<ProyectoCasaCampestreVo> listar() throws SQLException{

        ArrayList<ProyectoCasaCampestreVo> resultado = new ArrayList<ProyectoCasaCampestreVo>();

        Connection conn = JDBCUtilities.getConnection();
        
        try {
            
            String csql = "SELECT p.ID_Proyecto, p.Constructora, p.Numero_Habitaciones, p.Ciudad " +
                          "FROM Proyecto p " +
                          "WHERE p.Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla') " +
                          "AND p.Clasificacion = 'Casa Campestre';";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(csql);

            while(rs.next()){

                ProyectoCasaCampestreVo casaCamprestre = new ProyectoCasaCampestreVo(
                    rs.getInt("ID_Proyecto"),
                    rs.getString("Constructora"),
                    rs.getDouble("Numero_Habitaciones"),
                    rs.getString("Ciudad")
                );

                resultado.add(casaCamprestre);

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
