package Controlador;

import Modelo.Class_Venta_Producto;
import Controlador_Conexion_DB.Conexion;
import Modelo.Clase_Cliente;
import Modelo.Clase_Empleado;
import Modelo.Clase_Producto;
import Modelo.Clase_Venta;
import java.math.BigDecimal;
import java.security.Timestamp;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import javax.lang.model.util.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author diedr
 */
public class CRUD_Venta_Producto {

    public final Conexion con = new Conexion();
    public final Connection cn = (Connection) con.conectar();
    
    public DefaultTableModel buscarVentaYProducto(String textoBusqueda) {
    ResultSet rs;
    DefaultTableModel modelo;
    String[] titulos = {"Id_Venta", "Fecha_Hora", "Id_Cliente"};
    String[] registro = new String[3];

    modelo = new DefaultTableModel(null, titulos);

    try {
        CallableStatement call = cn.prepareCall("{call BuscarVentaYProducto(?)}");
        call.setString(1, textoBusqueda);
        rs = call.executeQuery();

        while (rs.next()) {
            registro[0] = rs.getString("Id_Venta");
            registro[1] = rs.getString("Fecha_Hora");
            registro[2] = rs.getString("Id_Cliente");

            modelo.addRow(registro);
        }
        return modelo;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
}



    public void agregarVentaYProducto(Clase_Venta venta) {
        String sql = "{CALL AgregarVentaYProducto(?, ?, ?, ?, ?, ?)}";

        try (CallableStatement stmt = cn.prepareCall(sql)) {
            stmt.setObject(1, venta.getFecha_Hora());
            stmt.setInt(2, venta.getId_Cliente());
            stmt.setInt(3, venta.getId_Empleado());
            stmt.setBigDecimal(4, venta.getDescuento());
            stmt.setInt(5, venta.getId_Producto());
            stmt.setInt(6, venta.getCantidad());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet obtenerNombreApellidoCliente() throws SQLException {
        String query = "{CALL ObtenerNombreApellidoCliente()}";
        CallableStatement stmt = cn.prepareCall(query);
        return stmt.executeQuery();
    }

    public ResultSet buscarCliente(String criterioBusqueda) throws SQLException {
        String query = "{CALL BuscarCliente(?)}";
        CallableStatement stmt = cn.prepareCall(query);
        stmt.setString(1, criterioBusqueda);
        return stmt.executeQuery();
    }

    public ArrayList<Clase_Empleado> obtenerEmpleados() {
    ArrayList<Clase_Empleado> empleados = new ArrayList<>();
    try {
        String query = "{ call ObtenerEmpleados }";
        CallableStatement stmt = cn.prepareCall(query);
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            int idEmpleado = resultSet.getInt("Id_Empleado");
            String nombreCompleto = resultSet.getString("NombreCompleto");
            String[] nombres = nombreCompleto.split(" ");
            String nombre = nombres[0];
            String apellido = nombres[1];
            Clase_Empleado empleado = new Clase_Empleado(idEmpleado, nombre, apellido);
            empleados.add(empleado);
        }

        resultSet.close();
        stmt.close();
        cn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return empleados;
}

    private void actualizarCantidadProducto(int idProducto, int cantidad) {
        try {
            PreparedStatement stmt = cn.prepareStatement("UPDATE Producto SET Cantidad_Producto = Cantidad_Producto - ? WHERE Id_Producto = ?");
            stmt.setInt(1, cantidad);
            stmt.setInt(2, idProducto);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

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

    public ArrayList<Clase_Cliente> buscarClientes(String busqueda) {
        ArrayList<Clase_Cliente> listaClientes = new ArrayList<>();
        try {
            String query = "{ call BuscarCliente(?) }";
            CallableStatement cstmt = cn.prepareCall(query);
            cstmt.setString(1, busqueda);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("Id_Cliente");
                String cedula = rs.getString("Cedula");
                String nombre1 = rs.getString("Nombre_1");
                String nombre2 = rs.getString("Nombre_2");
                String apellido1 = rs.getString("Apellido_1");
                String apellido2 = rs.getString("Apellido_2");
                String numeroCelular = rs.getString("Numero_Celular");
                String gmail = rs.getString("Gmail");
                String direccion = rs.getString("Direccion");

                Clase_Cliente cliente = new Clase_Cliente(idCliente, cedula, nombre1, nombre2, apellido1, apellido2, numeroCelular, gmail, direccion);
                listaClientes.add(cliente);
            }

            rs.close();
            cstmt.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public ArrayList<Clase_Cliente> obtenerNombresApellidosCliente() {
    ArrayList<Clase_Cliente> clientes = new ArrayList<>();
    try {
        String query = "{ call ObtenerNombreApellidoCliente }";
        CallableStatement cstmt = cn.prepareCall(query);
        ResultSet rs = cstmt.executeQuery();

        while (rs.next()) {
            int idCliente = rs.getInt("Id_Cliente");
            String nombreCompleto = rs.getString("NombreCompleto");
            String[] nombres = nombreCompleto.split(" ");
            String nombre = nombres[0];
            String apellido = nombres[1];
            Clase_Cliente cliente = new Clase_Cliente(idCliente, nombre, apellido);
            clientes.add(cliente);
        }

        rs.close();
        cstmt.close();
        cn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return clientes;
}


    
}
