import java.util.*;

public class MembershipManagement{
  
  private List<Session> sessions;
  private HashMap<String,int[]> memberPaid;
  private MessageSystem messageSystem;
  //private List<Coach> coaches = new ArrayList<Coach>();
  
  public static void main(String args[]){
    
    List<Session> sessions = new ArrayList<Session>();
    MessageSystem messageSystem = new MessageSystem();
    for (int i = 0; i < 12; i++){
      
      sessions.add(new Session(i));
    }
    //test:How to use MessageSystem
    messageSystem.CreateMessage("Elton","Practice on Thursday Be There or be Square");
    messageSystem.CreateMessage("Elton","Can u Switch Shifts with me");
    messageSystem.CreateMessage("Ahmad","Pay ur Fucking Bills");
    messageSystem.ShowMessages("Elton");
    //end of Test
    
  }
  
  
  
  public ArrayList<String> organizeByPayments(boolean order){
  HashMap<String,int[]> memberPaid = memberPayments();
  
    if (order){
      //look for the highest key (name) of paid, second highest of paid....etc.
      HashMap<String,int[]> tempMap;
      tempMap = memberPaid;
      ArrayList<String> orderedPaid = new ArrayList<String>(); 
      for (int i = 0; i < tempMap.size(); i++){
        int highestVal = -1;
        String highestKey = "";
        
        for (String key : tempMap.keySet()){
          //iterate over key
          //System.out.println(key+" "+mp.get(key));
          if (tempMap.get(key)[1] > highestVal){
            highestVal = tempMap.get(key)[1];
            highestKey = key; //cast to String
          } 
        }
        orderedPaid.add(highestKey);
        tempMap.remove(highestKey);
      }
      return orderedPaid;
    }else{
      //look for the highest value of not paid, second highest of not paid... etc.
      HashMap<String,int[]> tempMap;
      tempMap = memberPaid;
      ArrayList<String> orderedNotPaid = new ArrayList<String>(); 
      for (int i = 0; i < tempMap.size(); i++){
        int highestVal = -1;
        String highestKey = "";
        
        for (String key : tempMap.keySet()){
          //iterate over key
          //System.out.println(key+" "+mp.get(key));
          if (tempMap.get(key)[0] > highestVal){
            highestVal = tempMap.get(key)[0];
            highestKey = key; //cast to String
          } 
        }
        orderedNotPaid.add(highestKey);
        tempMap.remove(highestKey);
      }
      return orderedNotPaid;
    }
    
  }
  
  
    //Helper method
  //Creates a HashMap of members as key and number of payments/missed payments as a value
  //returns the HashMap
  public HashMap<String, int[]> memberPayments(){
       //2d array create
    String[][] temp; 
    //array of 2 integers, paid & not paid
    int[] paidOrNot = {0,0};
    memberPaid = new HashMap<String,int[]>();
    for (int i = 0; i < sessions.size(); i++){
      temp = sessions.get(i).GetMemberReportInfo();
      //loop thru 2d array
      for (int x = 0; x < temp.length; x++){
        if (memberPaid.containsKey(temp[x][0])){
          paidOrNot = memberPaid.get(temp[x][0]);
          if (temp[x][1] == "True"){
            paidOrNot[0]++;
          }
          else{
            paidOrNot[1]++;
          }
          memberPaid.put(temp[x][0], paidOrNot);
        }
        else{
          paidOrNot[0] = 0;
          paidOrNot[1] = 0;
          if (temp[x][1] == "true"){
            paidOrNot[0]++;
          }else{
            paidOrNot[1]++;
          }
          memberPaid.put(temp[x][0], paidOrNot);
        }
      }
    }
    return memberPaid;
  }
  
  
  
  
  
  public void missedPayments(){
    //If the member has not paid more than once, then he will be subject to a penalty fee and possibly exclusion from the group.
    HashMap<String,int[]> members = memberPayments;
    for (String key : members.keySet()){
      if (tempMap.get(key)[1] > 1 /*&&  SOMETHING */ ){
        //create fee
      } 
      //A reminder will be sent for any member who has skipped at least one payment.
      else if (members.get(key)[1] == 1){
        //send reminder
      }
    } 
    //If the member does not skip a payment for 3 months, he will receive a complimentary discount for 10% off for one class.
    
  }
  
  
  private HashMap<String, Integer> UpdatePaymentsDue() {
    String[][] temp;
    
    memberPaid = new HashMap<String, Integer>();
    for (int i = 0; i < sessions.size(); i++){
      temp = sessions.get(i).GetMemberReportInfo();
      
      for (int j = 0; j < temp.length; j++){
        if (!memberPaid.containsKey(temp[j][0])){
          memberPaid.put(temp[j][0], 12 - i);
        }
      }
    }
    
    return  memberPaid;
  }
  
  
  
  public void createMessage(String name,String message)
  {
    messageSystem= new MessageSystem();
    messageSystem.CreateMessage(name,message);
  }
  
}