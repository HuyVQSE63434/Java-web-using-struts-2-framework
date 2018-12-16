/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.registrations;

import huyvq.carts.Carts;
import huyvq.ultis.DBUltilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.naming.NamingException;
/**
 *
 * @author huyvqse63434
 */
public class registrationDAO {

    private int role;
    private String fullname;

    public String getFullname() {
        return fullname;
    }

    public int getRole() {
        return role;
    }

    public boolean login(String userID, String password) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUltilities.getConnection();
            if (conn != null) {
                String sql = "Select * From tbl_User where userID=? and password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setInt(2, Integer.parseInt(password));
                rs = stm.executeQuery();
                boolean test = rs.next();
                if (test) {
                    role = rs.getInt("role");
                    fullname = rs.getString("fullName");
                    return true;
                }
            }
        } catch (NamingException | NumberFormatException | SQLException e) {
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public ArrayList<registrationDTOForMobile> searchMobile(String searchvalue) {
        ArrayList<registrationDTOForMobile> result = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {

            conn = DBUltilities.getConnection();
            if (conn != null) {
                String sql = "select * from tbl_Mobile where mobileId like N'%" + searchvalue + "%'"
                        + " or mobileName like N'%" + searchvalue + "%'";
                stm = conn.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    result.add(new registrationDTOForMobile(rs.getString("mobileId"), rs.getString("description"),
                            rs.getFloat("price"), rs.getString("mobileName"), rs.getInt("yearOfProduction"),
                            rs.getInt("quantity"), rs.getBoolean("notSale")));
                }
            }

        } catch (SQLException | NamingException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return result;
    }

    public ArrayList<registrationDTOForMobile> searchInRange(String begin, String end) {
        ArrayList<registrationDTOForMobile> result = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {

            conn = DBUltilities.getConnection();
            if (conn != null) {
                String sql = "select * from tbl_Mobile where price between " + begin + " and " + end;
                stm = conn.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    if (!rs.getBoolean("notSale")) {
                        result.add(new registrationDTOForMobile(rs.getString("mobileId"), rs.getString("description"),
                                rs.getFloat("price"), rs.getString("mobileName"), rs.getInt("yearOfProduction"),
                                rs.getInt("quantity"), rs.getBoolean("notSale")));
                    }
                }
            }

        } catch (SQLException | NamingException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return result;
    }

    public boolean deleteMobile(String deleteID) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUltilities.getConnection();
            if (conn != null) {

                String sql = "delete from tbl_Mobile where mobileId=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, deleteID);
                int count = stm.executeUpdate();
                if (count > 0) {
                    return true;
                }
            }
        } catch (NamingException | NumberFormatException | SQLException e) {
            return false;
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public boolean updateMobile(String mobileID, String description, String price, String quantity, boolean notsale) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUltilities.getConnection();
            if (conn != null) {

                String sql = "update tbl_Mobile set description=?, price=?, quantity=?,notSale=? where mobileId=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, description);
                stm.setFloat(2, Float.parseFloat(price));
                stm.setInt(3, Integer.parseInt(quantity));
                if (notsale == true) {
                    stm.setInt(4, 1);
                } else {
                    stm.setInt(4, 0);
                }
                stm.setString(5, mobileID);
                int count = stm.executeUpdate();
                if (count > 0) {
                    return true;
                }
            }
        } catch (NamingException | NumberFormatException | SQLException e) {
            return false;
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return false;
    }

    public boolean createNewMobile(String newID, String newDescription, float price, String newName, int yearOfProduction, int quantity, boolean notsale)
            throws SQLException, NamingException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUltilities.getConnection();
            if (conn != null) {
                String sql = "insert into tbl_Mobile values (?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, newID);
                stm.setString(2, newDescription);
                stm.setFloat(3, price);
                stm.setString(4, newName);
                stm.setInt(5, yearOfProduction);
                stm.setInt(6, quantity);
                if (notsale == true) {
                    stm.setInt(7, 1);
                } else {
                    stm.setInt(7, 0);
                }
                int count = stm.executeUpdate();
                if (count > 0) {
                    return true;
                }
            }
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return false;
    }

    public boolean saveCart(Carts carts) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUltilities.getConnection();
            if (conn != null) {
                HashMap<String[], Integer> item = carts.getItems();
                Set<String[]> keys = item.keySet();
                String sql = "delete from tbl_Cart where customerId=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, carts.getCustomerID());
                stm.executeUpdate();
                sql = "insert into tbl_Cart values (?,?,?,?)";
                stm = conn.prepareStatement(sql);
                conn.setAutoCommit(false);
                for (String[] key : keys) {
                    stm.setString(1, carts.getCustomerID());
                    stm.setString(2, key[0]);
                    stm.setString(3, key[1]);
                    stm.setInt(4, item.get(key));
                    stm.addBatch();
                }
                int[] count = stm.executeBatch();
                conn.commit();
                stm.clearBatch();
                if (count.length > 0) {
                    return true;
                }
            }
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return false;
    }

    public Carts uploadCart(String customerId) throws NamingException, SQLException {
        Carts carts = new Carts();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUltilities.getConnection();
            if (conn != null) {
                String sql = "select * from tbl_Cart where customerId=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, customerId);
                rs = stm.executeQuery();
                HashMap<String[], Integer> list = new HashMap<>();
                while (rs.next()) {
                    String proId = rs.getString("productId");
                    String proName = rs.getString("productName");
                    int quan = rs.getInt("quantity");
                    String[] keys = new String[2];
                    keys[0] = proId;
                    keys[1] = proName;
                    list.put(keys, quan);
                }
                carts.setItems(list);
                carts.setCustomerID(customerId);
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
        return carts;
    }
}
