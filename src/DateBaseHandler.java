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
    public void singUpUser(String surname, String  numberPhone, String  pertronymic, String  name, String profession, String  pulpit,
                           String teacher, String formlesson, String student, String para, String trainingMain, String time){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.NAME + "," + Const.USERNAME + "," + Const.PARTRONYMIC +
                "," + Const.PULPIT + "," + Const.PROFESSION + "," + Const.CONTACTT + "," + Const.PREPOD + "," +
                Const.TRAINING + "," + Const.STUDANT + "," + Const.TRAININGMAIN + "," + Const.PARA + "," + Const.DATE +
                ")" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        int coun = 0;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

                preparedStatement.setString(4,name);
                preparedStatement.setString(1,surname);
                preparedStatement.setString(3,pertronymic);
                preparedStatement.setString(6,pulpit);
                preparedStatement.setString(5,profession);
                preparedStatement.setString(2,numberPhone);
                preparedStatement.setString(7,teacher);
                preparedStatement.setString(8,formlesson);
                preparedStatement.setString(9,student);
                preparedStatement.setString(11,trainingMain);
                preparedStatement.setString(10,para);
                preparedStatement.setString(12,time);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void singUpUserWithPlaceWork(String surname, String  numberPhone, String  pertronymic, String placeWork, String  name, String profession,
                           String trainingMain, String time){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.NAME + "," + Const.USERNAME + "," + Const.PARTRONYMIC + "," +
                Const.PlaceWork + "," + Const.PROFESSION + "," + Const.CONTACTT + "," + Const.TRAININGMAIN + "," + Const.DATE +
                ")" + "VALUES(?,?,?,?,?,?,?,?)";
        int coun = 0;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
                preparedStatement.setString(2,name);
                preparedStatement.setString(4,surname);
                preparedStatement.setString(3,pertronymic);
                preparedStatement.setString(1,profession);
                preparedStatement.setString(6,numberPhone);
                preparedStatement.setString(7,trainingMain);
                preparedStatement.setString(5, placeWork);
                preparedStatement.setString(8,time);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void singUpUserTraining(String surname, String  numberPhone, String  pertronymic, String  name, String profession, String  pulpit,
                            String trainingMain, String time){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.NAME + "," + Const.USERNAME + "," + Const.PARTRONYMIC +
                "," + Const.PULPIT + "," + Const.PROFESSION + "," + Const.CONTACTT + "," + Const.TRAININGMAIN + "," + Const.DATE +
                ")" + "VALUES(?,?,?,?,?,?,?,?)";
        int coun = 0;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

                preparedStatement.setString(4,name);
                preparedStatement.setString(1,surname);
                preparedStatement.setString(3,pertronymic);
                preparedStatement.setString(6,pulpit);
                preparedStatement.setString(5,profession);
                preparedStatement.setString(2,numberPhone);
                preparedStatement.setString(7,trainingMain);
                preparedStatement.setString(8,time);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(String MainName, String name){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + MainName + " = " + "'" + name + "'";
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
    //параметор это по какому столпцу искать
    public ResultSet seart(String UserName, String parametr) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + parametr + " like " + "'"+ UserName +"%"+"'";
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
