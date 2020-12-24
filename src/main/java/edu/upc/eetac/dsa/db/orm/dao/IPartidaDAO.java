package edu.upc.eetac.dsa.db.orm.dao;

import edu.upc.eetac.dsa.db.orm.model.Partida;
import edu.upc.eetac.dsa.db.orm.model.User;

import java.util.List;

public interface IPartidaDAO {

    public int addPartida(String fechaInicio, String horaInicio, String fechaFin, String horaFin, int score);
    public Partida getPartida(int partidaID);
    public void updatePartida(int partidaID, String fechaInicio, String horaInicio, String fechaFin, String horaFin, int score);
    public void deletePartida(int partidaID);
    public List<Partida> getPartida();
    public List <Partida> getPartidaByUserID(int userId);
}
