package Controlador;

import Modelo.Class_Compra_Producto;
import Controlador_Conexion_DB.Conexion;
import Modelo.Clase_Producto;
import Modelo.Clase_Proveedor;
import Modelo.Class_Compra;
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
public class CRUD_Compra_Producto {

    public final Conexion con = new Conexion();
    public final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrarDatosVenta() {
        ResultSet rs;
        DefaultTableModel modelo;

        String[] titulos = {"Id_Compra", "Producto", "Cantidad", "Proveedor", "Fecha_Compra", "Total", "TotalGeneral"};
        String[] registro = new String[7];

        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call ObtenerDatosCompra}");
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("Id_Compra");
                registro[1] = rs.getString("Producto");
                registro[2] = rs.getString("Cantidad");
                registro[3] = rs.getString("Proveedor");
                registro[4] = rs.getString("Fecha_Compra");
                registro[5] = String.valueOf(rs.getDouble("Total"));
                registro[6] = String.valueOf(rs.getDouble("TotalGeneral"));

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public void eliminarCompraYProducto(int idCompra) {
        String sql = "{CALL EliminarCompraYProducto(?)}";

        try (CallableStatement stmt = cn.prepareCall(sql)) {
            stmt.setInt(1, idCompra);
            stmt.execute();

            // Confirmar la transacción
            cn.commit();

            // Cerrar el CallableStatement y la Connection
            stmt.close();
            cn.close();
        } catch (SQLException e) {
            // Imprimir el seguimiento de la pila y el mensaje de la excepción
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Clase_Proveedor> obtenerProveedor() {
        ArrayList<Clase_Proveedor> Proveedor = new ArrayList<>();
        try {
            String query = "{ call ObtenerProveedor }";
            CallableStatement stmt = cn.prepareCall(query);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int idEmpleado = resultSet.getInt("Id_Proveedor");
                String nombreCompleto = resultSet.getString("NombreCompleto");
                String[] nombres = nombreCompleto.split(" ");
                String nombre = nombres[0];
                String apellido = nombres[1];
                Clase_Proveedor proveedor = new Clase_Proveedor(idEmpleado, nombre, apellido);
                Proveedor.add(proveedor);
            }

            resultSet.close();
            stmt.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Proveedor;
    }

    public ArrayList<Clase_Producto> mostrarDatosComboCompra(String busqueda) {
        ArrayList<Clase_Producto> listaProductos = new ArrayList<>();
        try {
            String query = "{ CALL MostrarProductosCompra(?) }";
            CallableStatement cstmt = cn.prepareCall(query);
            cstmt.setString(1, busqueda);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("Id_Producto");
                String nombreProducto = rs.getString("Nombre");
                float precioCompra = rs.getFloat("Precio_Compra");

                Clase_Producto producto = new Clase_Producto(idProducto, nombreProducto, precioCompra);
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listaProductos;
    }

    public void agregarCompraYProducto(Class_Compra compra) {
       String sql = "{CALL AgregarCompraYProducto(?, ?, ?, ?)}";

    try (CallableStatement stmt = cn.prepareCall(sql)) {
        stmt.setObject(1, compra.getFecha_Compra());
        stmt.setInt(2, compra.getId_Proveedor());
        stmt.setInt(3, compra.getId_Producto());
        stmt.setInt(4, compra.getCantidad());

        stmt.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public boolean verificarCompraProducto(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call BuscarCompraProducto(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

}
