import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
public class Poker{
    static DataInputStream dis;
    static DataOutputStream dos;
    
    private static String read() throws IOException {// reads from the dealer
        return dis.readUTF();
    }
    public static String Bet1(int currentpot, int bettomatch,String holecard,String upcard,String[] playerscards, int betmoney){//int currentpot, int bettomatch,String holecard,String upcard,String[] playerscards
        String bet1="bet:"+bettomatch;
        if (bettomatch > betmoney){
            bet1= "fold";
            return bet1;
        }
        if(holecard.charAt(0)==upcard.charAt(0)){// if i have a pair then up bet to match by 3
            bet1 ="bet:"+(bettomatch+3);
        }
        else {
            int counter =0;
            int foldcount =1;
            while (counter < playerscards.length){
                while (counter < playerscards.length){
                if (playerscards[counter].charAt(0)== upcard.charAt(0)|| playerscards[counter].charAt(0)== holecard.charAt(0)){
                    foldcount++;
                }
                else if (playerscards[counter].charAt(0)!= upcard.charAt(0)|| playerscards[counter].charAt(0)!= holecard.charAt(0)){
                    bet1="bet:"+bettomatch;
                }
                counter++;
            }
            if (foldcount >= 3){
                bet1="fold";
                return bet1;
            }
            else{
                bet1="bet:"+bettomatch;
            }
            if (bettomatch > 30 && upcard.charAt(0) != holecard.charAt(0)){// if the current pot is to high then fold
            bet1="fold";}
        
        }}
        return bet1;
    }
    public static String Bet2(int currentpot, int bettomatch,String holecard,String firstupcard,String secondupcard,String[] playerscards,int betmoney){//int currentpot, int bettomatch,String holecard,String firstupcard,String secondupcard,String[] playerscards
        String bet2="bet:"+bettomatch;
        int playernumbers = (playerscards.length)/2;
        int halfofplayers = playernumbers/2;
        int counter =0;
        int foldcount=0;
        if (bettomatch > betmoney){
            bet2= "fold";
            return bet2;
        }
        if (holecard.charAt(0)==firstupcard.charAt(0)|| firstupcard.charAt(0)==secondupcard.charAt(0)||secondupcard.charAt(0)== holecard.charAt(0)){
            bet2 = "bet:"+(bettomatch+2);
        } 
        if (holecard.charAt(0)!=firstupcard.charAt(0)&& secondupcard.charAt(0)!=holecard.charAt(0)){
            bet2= "bet:"+bettomatch;
            while (counter<halfofplayers){
                if (playerscards[counter].charAt(0)==playerscards[counter+1].charAt(0)){// looking at players cards to see if they match
                    foldcount++;// if match then the fold count goes up 
                    counter =counter+2;// keeps going throught the sequence
                }
                if (playerscards[counter].charAt(0)!= playerscards[counter+1].charAt(0)){// looking at players cards to see if they do not match 
                    counter=counter+2;// keeps going throught the sequence
                }
            }    
            if (foldcount >= 1 ){
                bet2="fold";
                return bet2;
            }
            else {
                bet2="bet:"+bettomatch;
            }
            if (bettomatch > 30 && (firstupcard.charAt(0) != holecard.charAt(0)|| secondupcard.charAt(0)!=firstupcard.charAt(0))){// if the current pot is to high then fold
                bet2="fold";}
            }
    return bet2;
    }
    private static void write(String s) throws IOException{// writes to the dealer
        dos.writeUTF(s);
        dos.flush();
    }
    public static void main(String args[]){
        try{
        String IpAddress = args[0];
        Integer IpPort = Integer.parseInt(args[1]);
        Socket socket= new Socket(IpAddress,IpPort);
        dis= new DataInputStream(socket.getInputStream());
        dos= new DataOutputStream(socket.getOutputStream());
        int betmoney = 500;
        while (betmoney>0) {
            String disread = read();
        if (disread.contains("login")){
            write("jadapaull:JP");// writes back GitHub username and username in game 
        }
        else if (disread.contains("bet1")){// reads to see if it contains bet 1
            String[] bet1dealer = disread.split(":");// turns dealer message to a string
            int lengthtoindex = bet1dealer.length-1;
            betmoney = Integer.parseInt(bet1dealer[1]);// takes bet money left from dealer
            int currentpot = Integer.parseInt(bet1dealer[2]);//takes current pot from dealer 
            int bettomatch = Integer.parseInt(bet1dealer[3]);// takes bet to match from dealer
            String holecard= bet1dealer[4];// takes my unseen card from dealer
            String upcard = bet1dealer[5];// takes my seen card from dealer
            int playercardnumber = 0;// counter for playercard index
            int counter =7;//counter for index for bet1dealer 
            String[] playerscards= new String[(lengthtoindex+1)-7];// makes new string array with length-6
            while (counter <= lengthtoindex){
                playerscards[playercardnumber]= bet1dealer[counter];
                playercardnumber++;
                counter++;
            }    
            String bet1=Bet1(currentpot,bettomatch,holecard,upcard,playerscards,betmoney);//currentpot,bettomatch,holecard,upcard,playerscards
            write(bet1);
        }
        else if (disread.contains("bet2")){// reads to see if it contains bet 2
            String[] bet1dealer = disread.split(":");
            int lengthtoindex = bet1dealer.length-1;
            betmoney = Integer.parseInt(bet1dealer[1]);// takes bet money left from dealer
            int currentpot = Integer.parseInt(bet1dealer[2]);//takes current pot from dealer 
            int bettomatch = Integer.parseInt(bet1dealer[3]);// takes bet to match from dealer
            String holecard= bet1dealer[4];// takes my unseen card from dealer
            String firstupcard = bet1dealer[5];// takes my seen card from dealer
            String secondupcard = bet1dealer[6];//takes my second seen card from dealer 
            int playercardnumber = 0;// counter for playercard index
            int counter =8;//counter for index of bet1dealer
            String[] playerscards= new String[(lengthtoindex+1)-8];// makes new string array with length-7
            while (counter <= lengthtoindex){
                playerscards[playercardnumber]= bet1dealer[counter];
                playercardnumber++;
                counter++;
            }
            String bet2=Bet2(currentpot, bettomatch,holecard,firstupcard,secondupcard,playerscards,betmoney);//currentpot, bettomatch,holecard,firstupcard,secondupcard,playerscards
            write(bet2);
        }
        else if (disread.contains("status")){
            String status = disread;
            System.out.println(status);
        }
        else if(disread.contains("done")){
            String done = disread;
            System.out.println(done);
            betmoney=0;
        }
        }
        socket.close();
    }
    catch (IOException IOE){
        System.out.println("Exception");
        System.out.println(IOE.getMessage());
    }
    }      
    }
