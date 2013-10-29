import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

  
    @Test
    public void connectPersonne()
    {
    	 new Member ("thiebaut","guillaume","thiebaut.guillaume@gmail.com","chameau89").save();
    	 
    	 assertNotNull(Member.connect("thiebaut.guillaume@gmail.com","chameau89"));
    	 assertNull(Member.connect("thiebaut.guillaume@gmail.com","chameau"));
    	 assertNull(Member.connect("guillaume@gmail.com","chameau89"));
    	
    }

}
