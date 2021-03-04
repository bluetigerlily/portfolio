import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import com.revature.beans.Events;
import com.revature.beans.Role;
import com.revature.dao.DAOFactory;
import com.revature.dao.hibernate.EventsHibernate;
import com.revature.dao.hibernate.RoleHibernate;
import com.revature.dao.hibernate.UserHibernate;
import com.revature.utils.HibernateUtil;

@TestMethodOrder(OrderAnnotation.class)
class HibernateTest {
	public static UserHibernate uh;
	public static RoleHibernate rh;
	public static EventsHibernate eh;
	public static com.revature.beans.User testUser;
	public static Events testEvents;
	public static Role testRole;

	Events event = event(1, null, null, null, null, "college class", null, 
		1000, "new jersey", 03-03-2021, 03-04-2021, 03-10-2021, 
		"something something something", "false", "true", "false",
		"i didn't feel like it", "yes", null, false, false, false,
		false, false, false, 0);


	@BeforeAll
	static void setUp() throws Exception {
		uh = new UserHibernate();
		rh = new RoleHibernate();
		eh = new EventsHibernate();
		testEvents.getEvents(DAOFactory.getUserDAO().getbyId(1));
		((Session) testUser).update(event(0, null, null, null, null, null, null, 0, null, 0, 0, 0, null, null, null, null, null, null, null, false,
				false, false, false, false, false, 0));
	}

	private static Events event(int i, Object object, Object object2, Object object3, Object object4,
			String string, Object object5, int j, String string2, int k, int l, int m, String string3, String string4,
			String string5, String string6, String string7, String string8, Object object6, boolean b, boolean c,
			boolean d, boolean e, boolean f, boolean g, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	void testDAOFactory() {
		
		DAOFactory df = new DAOFactory();
		
		assertNotNull(df);
		
	}
	@Test
	void testEventsHibernategetbyUserid(int userid) {
		HibernateUtil hu = new HibernateUtil();
		Session s = hu.getSession();
		Boolean b = false;
		Events e = User (1, "haleym", "4271");
		e = s.get(Events.class, userid);
		if(e != null)
		{
			assertTrue(b);
		}
		s.close();
	
	}


	private Events User(int i, String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Role User1(int i, String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Test
	void testRoleHibernatebyUserid(int userid)
	{
		HibernateUtil hu = new HibernateUtil();
		Session s = hu.getSession();
		Boolean b = false;
		Role r = User1 (1, "employee", null);
		r = s.get(Role.class, userid);
		if(r != null)
		{
			assertTrue(b);
		}
		s.close();
		
	}
	@Test
	void testUserHibernatebyUsername(String username)
	{
		HibernateUtil hu = new HibernateUtil();
		Session s = hu.getSession();
		Boolean b = false;
		com.revature.beans.User u = User2(1, "haleym", "4271", "haley", "moses", "vhr825@gmail.com", 1000, 0, "employee", null );
		u = s.get(com.revature.beans.User.class, username);
		if(u != null)
		{
			assertTrue(b);
		}
		s.close();
	}

	private com.revature.beans.User User2(int i, String string, String string2, String string3, String string4, String string5, int j,
			int k, String string6, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	//all my get methods pass testing
	//now to test my update, delete, and add methods
}



