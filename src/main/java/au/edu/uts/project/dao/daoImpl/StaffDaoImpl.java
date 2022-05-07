package au.edu.uts.project.dao.daoImpl;

import au.edu.uts.project.dao.StaffDao;
import au.edu.uts.project.domain.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {

    // connection object
    private Connection connection = null;
    // database operation object
    private PreparedStatement pst = null;

    public StaffDaoImpl(Connection connection){
        this.connection = connection;
    }

    /**
     * get staff list
     * @return
     * @throws SQLException
     */
    @Override
    public List<Staff> getList() throws SQLException {
        List<Staff> list = new ArrayList<>();
        String sql = "SELECT * FROM staff";
        this.pst = this.connection.prepareStatement(sql);
        ResultSet result = this.pst.executeQuery();
        while(result.next()){
            Staff staff = new Staff();
            staff.setStaffId(result.getInt("staff_id"));
            staff.setStaffFname(result.getString("staff_fname"));
            staff.setStaffLname(result.getString("staff_lname"));
            staff.setEmail(result.getString("email"));
            staff.setPassword(result.getString("password"));
            staff.setDob(result.getString("dob"));
            staff.setGender(result.getString("gender"));
            staff.setStaffStreetno(result.getInt("staff_streetno"));
            staff.setStaffStreetname(result.getString("staff_streetname"));
            staff.setStaffCity(result.getString("staff_city"));
            staff.setStaffZipcode(result.getInt("staff_zipcode"));
            staff.setStaffCountry(result.getString("staff_country"));
            staff.setRoles(result.getString("roles"));
            list.add(staff);
        }
        this.pst.close();
        return list;
    }

    /**
     * add staff info
     * @param staff
     * @return
     */
    @Override
    public int addStaff(Staff staff) throws SQLException {

        String sql = "INSERT INTO Staff (Staff_FName, Staff_LName, Email, Password, DOB, Gender, Staff_streetNo, Staff_streetName, Staff_city, Staff_zipcode, Staff_country, Roles) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, staff.getStaffFname());
        this.pst.setString(2, staff.getStaffLname());
        this.pst.setString(3, staff.getEmail());
        this.pst.setString(4, staff.getPassword());
        this.pst.setString(5, staff.getDob());
        this.pst.setString(6, staff.getGender());
        this.pst.setInt(7, staff.getStaffStreetno());
        this.pst.setString(8, staff.getStaffStreetname());
        this.pst.setString(9, staff.getStaffCity());
        this.pst.setInt(10, staff.getStaffZipcode());
        this.pst.setString(11, staff.getStaffCountry());
        this.pst.setString(12, staff.getRoles());
        int result = this.pst.executeUpdate();
//        System.out.println("the insertion return result is" + result);
        this.pst.close();
        return result;
    }

    /**
     * update staff info
     * @param staff
     * @return
     */
    @Override
    public int updateStaff(Staff staff) {
        return 0;
    }
}
