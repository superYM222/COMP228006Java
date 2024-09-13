public class Main {
    public static void main(String[] args) {


        Singers singer1 = new Singers();
        System.out.println("Default values: ");
        System.out.println("Singer ID: "+ singer1.getID());
        System.out.println("Singer Name: "+ singer1.getName());
        System.out.println("Singer Address: "+ singer1.getAddress());
        System.out.println("Singer Day of Birth: "+ singer1.getDateOfBirth());
        System.out.println("Singer Number of Albums Published: "+singer1.getNumberOfAlbumsPublished());
        System.out.println();

        singer1.setID(1);
        singer1.setName("John Kim");
        singer1.setAddress("San Francisco, CA");
        singer1.setDateOfBirth("1999-02-19");
        singer1.setNumberOfAlbumsPublished(5);



    System.out.println(singer1);

    }
}
class Singers
{
           private int singerID;
           private String singerName;
           private String singerAddress;
           private String DateOfBirth;
           private int numberOfAlbumsPublished;
           public Singers(){
           }
           public Singers(int singerID)
           {
               this.setID(singerID);
           }
           public Singers(int singerID, String singerName)
           {
               this.setID(singerID);
               this.setName(singerName);

           }
           public Singers(int singerID, String singerName, String singerAddress)
           {
               this.setID(singerID);
               this.setName(singerName);
               this.setAddress(singerAddress);
           }
           public Singers(int singerID, String singerName, String singerAddress, String DateOfBirth)
           {
               this.setID(singerID);
               this.setName(singerName);
               this.setAddress(singerAddress);
               this.setDateOfBirth(DateOfBirth);
           }
           public Singers(int singerID, String singerName, String singerAddress, String DateOfBirth, int numberOfAlbumsPublished)
           {
              this.setID(singerID);
              this.setName(singerName);
              this.setAddress(singerAddress);
              this.setDateOfBirth(DateOfBirth);
              this.setNumberOfAlbumsPublished(numberOfAlbumsPublished);
           }
           public int getID()
           {
               return singerID;
           }
           public String getName()
           {
               return singerName;
           }
           public String getAddress()
           {
               return singerAddress;
           }
           public String getDateOfBirth()
           {
               return DateOfBirth;
           }
           public int getNumberOfAlbumsPublished()
           {
               return numberOfAlbumsPublished;
           }


           public void setID(int singerID)
           {
               this.singerID = singerID;
           }
           public void setName(String singerName)
           {
               this.singerName = singerName;
           }
           public void setAddress(String singerAddress)
           {
               this.singerAddress = singerAddress;
           }
           public void setDateOfBirth(String DateOfBirth)
           {
               this.DateOfBirth = DateOfBirth;
           }
           public void setNumberOfAlbumsPublished(int numberOfAlbumsPublished)
           {
               this.numberOfAlbumsPublished = numberOfAlbumsPublished;
           }

    @Override
    public String toString() {
         return "singerID:" + singerID +"\n"+ "singerName:" +  singerName +"\n"+ "singerAddress:" + singerAddress +"\n"+  "DateOfBirth:"+
                 DateOfBirth +"\n"+  "numberOfAlbumsPublished:" + numberOfAlbumsPublished;
    }
}

