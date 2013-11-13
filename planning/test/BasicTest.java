import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

  
    @Test
    public void connectPersonne()
    {
    	 new Member ("thiebaut","guillaume","durand@ece.fr","chameau89").save();
    	 
    	 assertNotNull(Member.connect("durand@ece.fr","chameau89"));
    	 assertNull(Member.connect("durand@ece.fr","chameau"));
    	 assertNull(Member.connect("pif@ece.fr","chameau89"));
    	
    }
    
   

}
