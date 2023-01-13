import dao.AsociacionDao;
import dao.ClubDao;
import dao.IdCardDao;
import dao.PersonDao;
import modelo.Asociacion;
import modelo.Club;
import modelo.IdCard;
import modelo.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//CAMBIAR EL ALL POR PERSIST Y MIRAR QUE OCURRE ANTES DEL VIERNES --> HACER PERSIST EN VEZ DE DELETE
//CAMBIER EL PERSIST POR EL MERGE --> MERGE EN VEZ DE DELETE

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world");

        AsociacionDao asociacionDao = new AsociacionDao();
        ClubDao clubDao = new ClubDao();

        Asociacion a = new Asociacion();
        a.setId(1);
        a.setNombre("Federación aragonesa");

        Club c1 = new Club();
        c1.setId(1);
        c1.setClub("Cella");
        c1.setAsociacion(a);

        Club c2 = new Club();
        c2.setId(2);
        c2.setClub("Teruel");
        c2.setAsociacion(a);

        List<Club> clubs = new ArrayList<>();
        System.out.println(c1);
        clubs.add(c1);
        clubs.add(c2);
        a.setClubes(clubs);

        //PERSIST
        //asociacionDao.guardaAsociacion(a);
        //clubDao.guardaClub(c1);

        //MERGE
//        Club mergedClub = clubDao.buscarClub(c1);
//        System.out.println(mergedClub);

        Asociacion mergedAsociacion = asociacionDao.buscarAsociacion(a);
        System.out.println(mergedAsociacion);

        //BORRADO EN CASCADA
//        asociacionDao.borrarAsociacion(a);
//        System.out.println("Borrar club");
//        clubDao.borrarClub(c1);
//
//        System.out.println("Fin");
    }
}
