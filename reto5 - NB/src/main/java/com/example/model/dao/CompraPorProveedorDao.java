package com.example.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.model.vo.CompraPorProveedorVo;
import com.example.util.JDBCUtilities;

public class CompraPorProveedorDao {

    public ArrayList<CompraPorProveedorVo> listar() throws SQLException{

        ArrayList<CompraPorProveedorVo> resultado = new ArrayList<CompraPorProveedorVo>();

        Connection conn = JDBCUtilities.getConnection();
        
        try {
            
            String csql = "SELECT c.ID_Compra, p.Constructora, p.Banco_Vinculado " +
                          "FROM Compra c " +
                          "JOIN Proyecto p ON (c.ID_Proyecto = p.ID_Proyecto) " +
                          "WHERE p.Ciudad = 'Salento' AND c.Proveedor = 'Homecenter';";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(csql);

            while(rs.next()){

                CompraPorProveedorVo compra = new CompraPorProveedorVo(
                    rs.getInt("ID_Compra"),
                    rs.getString("Constructora"),
                    rs.getString("Banco_Vinculado")
                );

                resultado.add(compra);

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
