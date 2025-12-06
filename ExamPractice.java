public class ExamPractice {
    public static void main(String[] args){
        //This will be a program where we simulate RAID functionality
    
        //##############################################################
        //RAID 0 - STRIPING EXAMPLE
        //##############################################################


        //let's make an array of bytes
        byte[] data = new byte[16];

        //and two undefined array of bytes to represent different hard drive memories
        byte[] drive1 = new byte[8];
        byte[] drive2 = new byte[8];

        //and then let's use striping to feed the data into the two drives
        for(int i = 0; i < data.length; i++){
            data[i] = (byte)i; //filling the data array with some values
            if(i % 2 == 0){
                drive1[i / 2] = data[i]; //even index goes to drive1
            } else {
                drive2[i / 2] = data[i]; //odd index goes to drive2
            }
        }

        //now let's print out the contents of each drive
        System.out.println("Drive 1 contents:");
        for(byte b : drive1){
            System.out.print(b + " ");
        }

        System.out.println("\nDrive 2 contents:");
        for(byte b : drive2){
            System.out.print(b + " ");
        }

        //##############################################################
        //RAID 1 - MIRRORING EXAMPLE
        //##############################################################

        //and two undefined array of bytes to represent different hard drive memories
        byte[] mirrorDrive1 = new byte[16];
        byte[] mirrorDrive2 = new byte[16];

        //and then let's use mirroring to feed the data into the two drives
        for(int i = 0; i < data.length; i++){
            mirrorDrive1[i] = data[i]; //both drives get the same data
            mirrorDrive2[i] = data[i];
        }

        //now let's print out the contents of each mirrored drive
        System.out.println(); 
        System.out.println("Mirror Drive 1 contents:");

        for(byte b : mirrorDrive1){
            System.out.print(b + " ");
        }

        System.out.println("\nMirror Drive 2 contents:");

        for(byte b : mirrorDrive2){
            System.out.print(b + " ");
        }

        //##############################################################
        //RAID 5 - STRIPING WITH PARITY EXAMPLE
        //##############################################################

        //let's make four undefined array of bytes to represent different hard drive memories
        byte[] raid5Drive1 = new byte[6];
        byte[] raid5Drive2 = new byte[6];
        byte[] raid5Drive3 = new byte[6]; //this will hold parity information
        byte[] raid5Drive4 = new byte[6]; //not used in this example
    }
}
