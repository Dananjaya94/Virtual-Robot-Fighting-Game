public class AILoader extends ClassLoader
{
    //This methods gets the class name as parameter and returns a new instance of that class
    public RobotAI loadPlugin(String fname) throws Exception
    {
        try
        {
            Class<?> cls = Class.forName(fname);
            return(RobotAI) cls.newInstance();
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException ex)
        {
            throw new Exception("Could not load "+fname+" : "+ex.getMessage());
        }
    }


    public AILoader loadAI(String fname) throws Exception
    {
        try
        {
            Class<?> cls = Class.forName(fname);
            return (AILoader) cls.newInstance();
        }
        catch(ClassNotFoundException ex)
        {
            throw new Exception("Could not load "+fname+" : "+ex.getMessage());
        }
    }
}