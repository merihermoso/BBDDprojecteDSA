package edu.upc.eetac.dsa.db.orm.util;
import java.util.*;

public class QueryHelper {

    public static String createQueryINSERT(Object entity){

        StringBuffer sb = new StringBuffer("INSERT INTO");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("l");

        String [] fields = edu.upc.eetac.dsa.db.orm.util.ObjectHelper.getFields(entity);

        sb.append("ID");
        for(String field: fields){
            sb.append(", ").append(field);
        }

        sb.append(") VALUES (?");

        for(String field: fields){
            sb.append(", ?");
        }

        sb.append(")");
        //////////////////////////////////////SEGUIR............
    }
}
