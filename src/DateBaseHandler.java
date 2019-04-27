import java.sql.*;

public class DateBaseHandler extends Config {
   static Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://"+ dbHost + ":" + dbPort + "/" + dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        dbConnection = DriverManager.getConnection(connectionString, dbUser,dbPass);


        return dbConnection;
    }

    public void singUpUser(String Name, String UserName, String Partronymic, String Pulpit,
                           String Profession, String Contactt, String Training){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.NAME + "," + Const.USERNAME + "," + Const.PARTRONYMIC +
                "," + Const.PULPIT + "," + Const.PROFESSION + "," + Const.CONTACTT + "," + Const.TRAINING +")" + "VALUES(?,?,?,?,?,?,?)";

        int coun = 0;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(2, UserName);
            preparedStatement.setString(3, Partronymic);
            preparedStatement.setString(4, Pulpit);
            preparedStatement.setString(5,Profession);
            preparedStatement.setString(6, Contactt);
            preparedStatement.setString(7, Training);
            preparedStatement.setString(1, Name);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(coun >=1){
            Contact.SaveMes.setVisible(true);
        }else {

        }
    }
    public ResultSet getUser( String UserName){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERNAME + " = " + "'" + UserName + "'";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery(select);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return resultSet;
    }
    public ResultSet updateUser(String Comments, String UserName){
        String select = "UPDATE " + Const.USER_TABLE + " SET " + Const.COMMENT + " = " +"'" + Comments + ","+ "'" + " WHERE UserName" + " =" + "'" + UserName + "'";
        System.out.println(select);

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.executeUpdate(select);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ResultSet updateDate(String Date, String UserName){
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.GOPARI + " = " +"'" + Date + "/'" + " WHERE UserName" + " =" + "'" + UserName + "'";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.executeUpdate(update);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet seart(String UserName) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERNAME + " like \"" + UserName + "\"";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery(select);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return resultSet;
    }

}
