package Controlador;

import Modelo.Class_Venta_Producto;
import Controlador_Conexion_DB.Conexion;
import Modelo.Clase_Producto;
import java.math.BigDecimal;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author diedr
 */
public class CRUD_Venta_Producto {

    public final Conexion con = new Conexion();
    public final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrarDatosVentaProducto() {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"Id_Venta_Producto", "Cantidad", "Descuento", "Id_Venta", "Id_Producto"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarDatosVentaProducto}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("Id_Venta_Producto");
                registro[1] = rs.getString("Cantidad");
                registro[2] = rs.getString("Descuento");
                registro[3] = rs.getString("Id_Venta");
                registro[4] = rs.getString("Id_Producto");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel buscarVentaProducto(String dato) {
        ResultSet rs;
        DefaultTableModel modelo;

        String[] titulos = {"Id_Venta_Producto", "Cantidad", "Descuento", "Id_Venta", "Id_Producto"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarVentaProducto(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("Id_Venta_Producto");
                registro[1] = rs.getString("Cantidad");
                registro[2] = rs.getString("Descuento");
                registro[3] = rs.getString("Id_Venta");
                registro[4] = rs.getString("Id_Producto");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean verificarVentaProducto(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call BuscarVentaProducto(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public void insertarVentaProducto(Class_Venta_Producto ventaProducto) {
        try {
            CallableStatement cbst = cn.prepareCall("{call InsertarVentaProducto(?, ?, ?, ?, ?)}");
            cbst.setInt(1, ventaProducto.getId_Venta_Producto());
            cbst.setInt(2, ventaProducto.getCantidad());
            cbst.setFloat(3, ventaProducto.getDescuento());
            cbst.setInt(4, ventaProducto.getId_Venta());
            cbst.setInt(5, ventaProducto.getId_Producto());
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void actualizarVentaProducto(Class_Venta_Producto ventaProducto) {
        try {
            CallableStatement cbst = cn.prepareCall("{call ActualizarVentaProducto(?, ?, ?, ?, ?)}");
            cbst.setInt(1, ventaProducto.getId_Venta_Producto());
            cbst.setInt(2, ventaProducto.getCantidad());
            cbst.setFloat(3, ventaProducto.getDescuento());
            cbst.setInt(4, ventaProducto.getId_Venta());
            cbst.setInt(5, ventaProducto.getId_Producto());
            cbst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void eliminarVentaProducto(int Id_Venta_Producto) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarVentaProducto(?)}");
            cbst.setInt(1, Id_Venta_Producto);
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

   

   public ArrayList<Clase_Producto> mostrarDatosCombo(String busqueda) {
    ArrayList<Clase_Producto> listaProductos = new ArrayList<>();
    try {
        String query = "{ CALL MostrarProductos(?) }";
        CallableStatement cstmt = cn.prepareCall(query);
        cstmt.setString(1, busqueda);
        ResultSet rs = cstmt.executeQuery();
        while (rs.next()) {
            int idProducto = rs.getInt("Id_Producto");
            String nombreProducto = rs.getString("Nombre");
            float precioVenta = rs.getFloat("Precio_Venta");

            Clase_Producto producto = new Clase_Producto(idProducto, nombreProducto, precioVenta);
            listaProductos.add(producto);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return listaProductos;
}
}
