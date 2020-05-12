package x.com.java.practice.thread.throttle;

public class UserTask implements Runnable
{
   private String name = null;
 
   public UserTask(String name) {
      this.name = name;
   }
 
   public String getName() {
      return this.name;
   }
 
   @Override
   public void run(){
      try {
         Thread.sleep(10000);
      } catch (InterruptedException e){
         e.printStackTrace();
      }
      System.out.println("Executed : " + name);
   }
}