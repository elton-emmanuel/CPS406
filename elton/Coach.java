public class Coach
{
  private Session session;
  private String name;
  private int sessionID;
  public Coach(Session s,String n,int id)
  {
   session=s;
   name=n;
   sessionID=id;
    
  }
  public  Session remove(String n)
  {
   session.RemoveMember(n); 
    return session;
  }  
  public Session add(String n)
  {
   //session.AddMember(n); 
   return session;
    
  } 
 
  public int getSessionID()
  {
   return sessionID; 
    
    
  }
  public  Session getSession()
  {
    return session;
  
  }
  public void setSession(Session s)
  {
  session= s;
   
    
  } 
}