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

        //INSERT INTO User (ID, lastName,firstName,address,city) VALUES(0,7,7,7)
        return sb.toString();

    }
    public static String createQuerySELECT(Object entity){
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE ID =?");

        return sb.toString();
    }

    public static String createSelectFindAll(Class theClass, HashMap<String, String> params){
        Set<Map.Entry<String,String>> set = params.entrySet();

        StringBuffer sb = new StringBuffer("SELECT * FROM" +theClass.getSimpleName()+" WHERE 1=1");
        for (String key: params.keySet()){
            sb.append(" AND "+key+"=?");
        }
        return sb.toString();
    }
}
