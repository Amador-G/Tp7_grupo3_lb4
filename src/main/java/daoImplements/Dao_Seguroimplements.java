package daoImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Seguro;
import dao.Dao_Seguro;

public class Dao_Seguroimplements implements Dao_Seguro {
	private static final String add = "INSERT INTO personas(Dni, Nombre, Apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE Dni = ?";
	private static final String modify = "UPDATE personas SET Nombre = ?, Apellido = ? WHERE DNI = ?";
	private static final String list = "SELECT * FROM personas";
	private static final String getUser = "SELECT Dni FROM personas WHERE Dni = ?";
	@Override
	public boolean add(Seguro seg) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean addseg = false;
		try
		{
			statement = conexion.prepareStatement(add);
			statement.setInt(1, seg.getID());
			statement.setString(2, seg.getDescripcion());
			statement.setInt(3, seg.getTipo());
			statement.setFloat(4, seg.getCostoContratacion());
			statement.setFloat(5, seg.getCostoMaximo());

			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				addseg = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return addseg;
	}
	@Override
	public boolean delet(int id) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean deleteseg = false;		
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, id);
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				deleteseg = true;
			}			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			}catch(SQLException e2)
			{
				e2.printStackTrace();
			}
		}
		return deleteseg;
	}
	@Override
	public boolean modify(Seguro seg) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean modifyseg = false;
		try {
			statement = conexion.prepareStatement(modify);
			statement.setInt(1, seg.getID());
			statement.setString(2, seg.getDescripcion());
			statement.setInt(3, seg.getTipo());
			statement.setFloat(4, seg.getCostoContratacion());
			statement.setFloat(5, seg.getCostoMaximo());
			
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				modifyseg = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}		
		return modifyseg;
	}
	@Override
	public boolean exists(int id) {
		PreparedStatement statement;
		ResultSet resultado;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean existe = false;
		
		try 
		{
			statement = conexion.prepareStatement(getUser);
			statement.setInt(1, id);
			resultado = statement.executeQuery();
			
			if(resultado.next()) existe = true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return existe;
	}
	
	private Seguro parseSeguro(ResultSet resultSet) throws SQLException
	{
		
		int id = resultSet.getInt("idSeguro");
		String descripcion = resultSet.getString("descripcion");
		int tipo = resultSet.getInt("idTipo");
		float costoContratacion = resultSet.getFloat("costoContratacion");
		float costoAsegurado = resultSet.getFloat("costoAsegurado");
		return new Seguro(id,descripcion,tipo,costoContratacion,costoAsegurado);
	}
	
	@Override
	public List<Seguro> list() {
		PreparedStatement statement;
		ResultSet resultado;
		ArrayList<Seguro> listaDeSeguros = new ArrayList<Seguro>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try 
		{
			statement = conexion.prepareStatement(list);
			resultado = statement.executeQuery();
			while (resultado.next()) {
				listaDeSeguros.add(parseSeguro(resultado));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaDeSeguros;
	}
	

}
