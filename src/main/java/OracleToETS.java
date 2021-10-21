//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class OracleToETS {
//    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";//"oracle.jdbc.driver.OracleDriver";//驱动
//    static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:s2";//数据库URL
//
//    static final String USER ="joey";//数据库对应的用户名
//    static final String PASS = "joey";//登录密码
//
//    public static void main(String[] args) {
//        OracleToETS tmp = new OracleToETS();
//        List<User> userList = tmp.getAllList();
//        ESClient esclient = new ESClient();
//        esclient.initESClient();
//        esclient.bulkdoc(userList);
//    }
//
//    public List<User> getAllList()
//    {
//        ResultSet rs = null;//执行SQL语句，返回的结果
//        Statement stmt = null; //将数据发送到数据库中
//        Connection conn = null;//建立数据库的连接
//        List<User> list = new ArrayList<User>();
//        try
//        {
//            Class.forName(JDBC_DRIVER);//oracle数据库驱动
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);//数据库url 用户名 密码
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery("SELECT * FROM o_user ");
//            while(rs.next())
//            {
//                String tmpId = rs.getString("ID");
//                String tmpName = rs.getString("NAME");
//                String tmpAddress = rs.getString("ADDRESS");
//                String tmpetype = rs.getString("E_TYPE");
//                String tmpeindustry = rs.getString("E_INDUSTRY");
//                Date tmpcheckdate = rs.getDate("CHECK_DATE");
//                list.add(new User(tmpId,tmpName,tmpAddress,tmpetype,tmpeindustry,rs.getString("EMPIRICAL_SCOPE"),tmpcheckdate,
//                        rs.getDate("CREATE_TIME"),rs.getString("LEGAL_PERSON"),rs.getString("REGISTRATION_UNIT"),rs.getString("JURISDICTION_UNIT"),
//                        rs.getString("PHONE_NO"),rs.getString("BAR_ID"),rs.getString("BUILD_ID"),rs.getString("FLOOR_ID"),
//                        rs.getString("ROOM_ID"),rs.getString("BAR_LNG"),rs.getString("BAR_LAT"),rs.getString("BUILD_LNG"),rs.getString("BUILD_LAT"),
//                        rs.getString("ROOM_LNG"),rs.getString("ROOM_LAT")));
//            }
//        }catch(Exception e)
//        {
//            e.printStackTrace();
//        }finally
//        {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }
//}
