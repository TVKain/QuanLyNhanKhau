package hust.itep.quanlynhankhau.dao.sqlbuilder;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class SelectBuilder {
    String table;
    ArrayList<String> columns;
    ArrayList<String> wherePredicates;

    /***
     * @param table
     * @return
     *
     * SQLBuilder.selectFrom("nhan_khau") => select (?, ?, ?)
     *                                       from nhan_khau
     *                                       where (?) and (?) or (?)
     */
    public SelectBuilder() {
        columns = ArrayList<String>();


    }

    public SQLBuilder where(String pred) {

    }

    public SQLBuilder and(String )

    public PreparedStatement buildPreparedStatement() {

    }




}
