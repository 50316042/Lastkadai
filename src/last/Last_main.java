package last;

import java.sql.ResultSet;
import java.sql.SQLException;

import frame.FrameController;
import frame.FrameView;

public class Last_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int id,year,parcentage;
		 ResultSet rs;
		 MySQL mysql=new MySQL();
		 rs=mysql.selectAll();
	 try {
		while(rs.next()){
			 id=rs.getInt("id");
			 year=rs.getInt("year");
			 parcentage=rs.getInt("parcentage");
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		 
		 FrameController controller = new FrameController();
		 FrameView frame = new FrameView(controller);

		  frame.setBounds(5,5,655,455);
		  frame.setVisible(true);
		  
		 
	}

}
