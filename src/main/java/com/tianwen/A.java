package com.tianwen;

/**
 * wangjq
 * 2021年06月21日  21:16
 */
public class A {

    /*private static String uri;
    private static String user;
    private static String password;

    public static void main(String[] args) {
        Connection con=null;
        Statement sqlserver;
        ResultSet rs;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            String uri="jdbc:sqlserver://localhost:1433";
            String user="sa";
            String password="123456";
            e.printStackTrace();
        }
        try {
            con= DriverManager.getConnection(uri,user,password);
        }catch (SQLException e){}
        try{
            sqlserver=con.createStatement();
            rs=sqlserver.executeQuery("Select* FROM commodity");
            while(rs.next()){
                String Cid=rs.getString(1);
                String Cname=rs.getString(2);
                String Cstorage=rs.getString(3);
                String avgPrice=rs.getString(4);
                System.out.printf("%s\t",Cid);
                System.out.printf("%s\t",Cname);
                System.out.printf("%s\t",Cstorage);
                System.out.printf("%s\t",avgPrice);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }


    }*/
}
