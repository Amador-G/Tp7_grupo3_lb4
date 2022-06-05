package dao;

import java.util.List;

import Entidades.Seguro;

public interface Dao_Seguro {
	public boolean add(Seguro seg);
	public boolean delet(int dni);
	public boolean modify(Seguro us);
	public boolean exists(int dni);
	public List<Seguro> list();

}
