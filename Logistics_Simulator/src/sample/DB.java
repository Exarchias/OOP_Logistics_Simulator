package sample;

import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class DB {

    String url = "jdbc:mysql://den1.mysql5.gear.host:3306?user=xtracker&password=Kt4j_?V18w07"; //free and working server
    //String url = "jdbc:mysql://68.66.248.44?user=shoppi68_theApp&password=12345"; //a bad server that I paid a lot to use

    Statement statement;

    //this method establishes a connection between the application and the MySQL db
    public DB() {
        if (DataHolder.dbActivated) {
            try {
                Connection c = (Connection) DriverManager.getConnection(url);
                statement = c.createStatement();
                DataHolder.isConnected = true;
            } catch (SQLException ex) {
                System.out.println("the connection fails" + ex);
                DataHolder.isConnected = false;
            }
        }
    }


    //this method makes the handshake possible between the application and database system to pull req info
    //this method is used for testing the status of the database.
    public void doAHandshake() {
        if (DataHolder.dbActivated) {
            try {
                ResultSet rs = statement.executeQuery("SHOW databases");

                while (rs.next()) {
                    System.out.println(" This database ==> " + rs.getString(1));
                }

                DataHolder.isConnected = true;
            } catch (SQLException ex) {
                System.out.println("Error on executing the handshake");
                DataHolder.isConnected = false;
            }
        }
    }

    //here we enable java to actually execute MySQL statements
    public void loadUsers() throws NoSuchAlgorithmException {
        DataHolder.userPopulate();
        if (DataHolder.dbActivated) {
            try {
                if(DataHolder.isConnected){
                    //this run when thte database is running.
                    statement.executeQuery("USE xtracker");
                    ResultSet rs = statement.executeQuery("SELECT * FROM user");

                    while (rs.next()) {
                        String name = rs.getString(2);
                        String password = rs.getString(3);
                        Account user1 = new Account(name, password);
                        DataHolder.arrayAllUsers.add(user1);
                        DataHolder.testAccount = user1; //this is redundant.
                        System.out.println("The online mode user: " + name + " is loaded to the application");
                    }
                } else {
                    //this runs when the database is down
                    Account firstUser = new Account("testuser", "123456");
                    DataHolder.testAccount = firstUser; //this is reduntnat
                    DataHolder.arrayAllUsers.add(firstUser);
                    System.out.println("Verification: The offline mode User is " + DataHolder.testAccount.getUserName());
                }
                System.out.println("The password is 12345");

            } catch (SQLException ex) {
                System.out.println("error on loading the users");
                DataHolder.isConnected = false;
            }
        }
    }


    //=============== Everything below this line is intended only for future use ===================


//    //adding a new user
//    public void addOneUser(String username, String password, String email, boolean admin) {
//        if (DataHolder.dbActivated) {
//            try {
//                int isAdmin;
//                if (admin) {
//                    isAdmin = 1;
//                } else {
//                    isAdmin = 0;
//                }
//                statement.executeUpdate("USE xtracker");
//                statement.executeUpdate("INSERT INTO user(username, password, email, isAdmin) VALUES ('" + username + "', '" +
//                        password + "', '" + email + "', '" + isAdmin + "')");
//                System.out.println("Not a failure. check the database");
//
//                DataHolder.isConnected = true;
//            } catch (SQLException ex) {
//                System.out.println("error on adding a user:" + ex);
//                DataHolder.isConnected = false;
//            }
//        }
//    }




//    //editing user data
//    public void editOneUser(String username, String password, String email, boolean admin, int userID) {
//        if (DataHolder.dbActivated) {
//            try {
//                int isAdmin;
//                if (admin) {
//                    isAdmin = 1;
//                } else {
//                    isAdmin = 0;
//                }
//                statement.executeUpdate("USE xtracker");
//                //username, password, email, isAdmin
//                statement.executeUpdate("UPDATE user SET username='" + username + "', password='" +
//                        password + "', email='" + email + "', isAdmin='" + isAdmin + "' WHERE userid='" + userID + "'");
//                System.out.println("Not a failure on editing the user. check the database");
//
//                DataHolder.isConnected = true;
//            } catch (SQLException ex) {
//                System.out.println("error on editing the user:" + ex);
//                DataHolder.isConnected = false;
//            }
//        }
//    }



//    //removing user
//    public void deleteOneUser(int userID) {
//        if (DataHolder.dbActivated) {
//            try {
//                int isAdmin;
//
//                statement.executeUpdate("USE xtracker");
//                //username, password, email, isAdmin
//                statement.executeUpdate("DELETE FROM user WHERE userid='" + userID + "'");
//                System.out.println("Not a failure on deleting the user. check the database");
//
//                DataHolder.isConnected = true;
//            } catch (SQLException ex) {
//                System.out.println("error on deleting the user:" + ex);
//                DataHolder.isConnected = false;
//            }
//        }
//    }



//    //sorting/loading last user
//    public int loadLastUserId() {
//        if (DataHolder.dbActivated) {
//            try {
//                statement.executeQuery("USE xtracker");
//                ResultSet rs = statement.executeQuery("SELECT userID FROM user ORDER BY userID DESC LIMIT 1");
//                int lastID = 5000;
//                while (rs.next()) {
//                    lastID = rs.getInt(1);
//                }
//
//                DataHolder.isConnected = true;
//                return lastID;
//
//            } catch (SQLException ex) {
//                System.out.println("error on loading the last userID: " + ex);
//                DataHolder.isConnected = false;
//                return 5000;
//            }
//        } else {
//            return 5000;
//        }
//    }




//    //sorting: change the userID of a user
//    public void userChangeID(int oldUserID, int newUserID) {
//        if (DataHolder.dbActivated) {
//            try {
//
//                statement.executeUpdate("USE xtracker");
//                statement.executeUpdate("UPDATE recipe SET user_userID='" + newUserID + "'  WHERE user_userID='" + oldUserID + "'");
//                System.out.println("Not a failure on changing the userID of a user. check the database");
//
//                DataHolder.isConnected = true;
//            } catch (SQLException ex) {
//                System.out.println("error on changing the userID of a user:" + ex);
//                DataHolder.isConnected = false;
//            }
//        }
//    }

//    //sorting: edit the username of a user.
//    public void userChangeUsername(int userID, String userName) {
//        if (DataHolder.dbActivated) {
//            try {
//
//                statement.executeUpdate("USE xtracker");
//                statement.executeUpdate("UPDATE recipe SET username='" + userName + "'  WHERE user_userID='" + userID + "'");
//                System.out.println("Not a failure on changing the username of a user. check the database");
//
//                DataHolder.isConnected = true;
//            } catch (SQLException ex) {
//                System.out.println("error on changing the username of a user:" + ex);
//                DataHolder.isConnected = false;
//            }
//        }
//    }

//    //sorting: edit the password of a user.
//    public void userChangePassword(int userID, String password) {
//        if (DataHolder.dbActivated) {
//            try {
//
//                statement.executeUpdate("USE xtracker");
//                statement.executeUpdate("UPDATE recipe SET password='" + password + "'  WHERE user_userID='" + userID + "'");
//                System.out.println("Not a failure on changing the password of a user. check the database");
//
//                DataHolder.isConnected = true;
//            } catch (SQLException ex) {
//                System.out.println("error on changing the password of a user:" + ex);
//                DataHolder.isConnected = false;
//            }
//        }
//    }





}
