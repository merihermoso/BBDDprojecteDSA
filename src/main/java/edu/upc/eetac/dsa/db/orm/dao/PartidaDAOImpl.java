package edu.upc.eetac.dsa.db.orm.dao;

import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.db.orm.Session;
import edu.upc.eetac.dsa.db.orm.model.Partida;
import edu.upc.eetac.dsa.db.orm.model.User;

import java.util.HashMap;
import java.util.List;

public class PartidaDAOImpl implements IPartidaDAO{

    public int addPartida(String fechaInicio, String horaInicio, String fechaFin, String horaFin, int score) {
        Session session = null;
        int partidaID = 0;
        try {
            session = FactorySession.openSession();
            Partida partida = new Partida(fechaInicio,horaInicio,fechaFin,horaFin,score);
            session.save(partida);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return partidaID;
    }


    public Partida getPartida(int partidaID) {
        Session session = null;
        Partida partida = null;
        try {
            session = FactorySession.openSession();
            partida = (Partida)session.get(User.class, partidaID);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return partida;
    }




    public void updatePartida(int partidaID, String fechaInicio, String horaInicio, String fechaFin, String horaFin, int score) {
        Partida partida = this.getPartida(partidaID);
        partida.setFechaInicio(fechaInicio);
        partida.setHoraInicio(horaInicio);
        partida.setFechaFin(fechaFin);
        partida.setHoraFin(horaFin);
        partida.setScore(score);

        Session session = null;
        try {
            session = FactorySession.openSession();
            session.update(Partida.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
    }


    public void deletePartida(int partidaID) {
        Partida partida= this.getPartida(partidaID);
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.delete(Partida.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

    }

    public List<Partida> getPartidas() {
        return null;
    }


    public List<Partida> getPartida() {
        Session session = null;
        List<Partida> partidaList=null;
        try {
            session = FactorySession.openSession();
            partidaList = session.findAll(Partida.class);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return partidaList;
    }


    public List<Partida> getPartidaByUserID(int userID) {

        Session session = null;
        List<Partida> partidaList=null;
        try {
            session = FactorySession.openSession();

            HashMap<String, Integer> params = new HashMap<String, Integer>();
            params.put("userID", userID);

            partidaList = session.findAll(Partida.class, params);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }
        return partidaList;
    }


}
