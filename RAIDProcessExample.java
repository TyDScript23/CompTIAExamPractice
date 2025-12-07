public class RAIDProcessExample {
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
        System.out.println("RAID 0 Drive 1 contents:");
        for(byte b : drive1){
            System.out.print(b + " ");
        }

        System.out.println("\nRAID 0 Drive 2 contents:");
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
        System.out.println(); 
        System.out.println("RAID 1 Drive 1 contents:");

        for(byte b : mirrorDrive1){
            System.out.print(b + " ");
        }

        System.out.println("\nRAID 1 Drive 2 contents:");

        for(byte b : mirrorDrive2){
            System.out.print(b + " ");
        }

        //##############################################################
        //RAID 5 - STRIPING WITH PARITY EXAMPLE
        //##############################################################

        //make a new byte array here for better representation
        byte[] raid5Data = new byte[12];

        //then make four drives to represent the hard drives
        byte[] raid5Drive1 = new byte[4];
        byte[] raid5Drive2 = new byte[4];
        byte[] raid5Drive3 = new byte[4];
        byte[] raid5Drive4 = new byte[4];

        //fill the data array with some values
        for(int i = 0; i < raid5Data.length; i++){
            raid5Data[i] = (byte)(i); //filling the data array with some values
        }

        int dataCounter = 0;
        int parityCatcher = 1; //determine which drive gets the parity byte

        //NOTE: In a real RAID 5 implementation, the parity byte would be calculated based on the data bytes. 
        // The parity byte is represented as -1 for simplicity.

        //now let's use striping with parity to feed the data into the four drives
        //we add four to accomadte the extra parity bytes equal to the number of drives available
        for(int i = 0; i < (raid5Data.length + 4); i++){
            
            int driveIndex = i % 4; //determine which drive to place data
            int dataIndex = i / 4;//determine the index within the drive to place data


            switch(driveIndex){
                case 0:
                    System.out.println("ParityCatcher: " + parityCatcher);
                    if(parityCatcher == 4) {
                        System.out.println("Placing parity on drive 1 at index " + dataIndex);
                        //place the parity at the index
                        raid5Drive1[dataIndex] = (byte)(-1);
                    }
                    else {
                        System.out.println("DataCounter: " + dataCounter);
                        raid5Drive1[dataIndex] = raid5Data[dataCounter];
                        dataCounter++;
                    }
                    break;
                case 1:
                    System.out.println("ParityCatcher: " + parityCatcher);
                    if(parityCatcher == 3) {
                        System.out.println("Placing parity on drive 2 at index " + dataIndex);
                        //place the parity at the index
                        raid5Drive2[dataIndex] = (byte)(-1);
                    }
                    else {
                        System.out.println("DataCounter: " + dataCounter);
                        raid5Drive2[dataIndex] = raid5Data[dataCounter];
                        dataCounter++;
                    }
                    break;
                case 2:
                    System.out.println("ParityCatcher: " + parityCatcher);
                    if(parityCatcher == 2) {
                        System.out.println("Placing parity on drive 3 at index " + dataIndex);
                        //place the parity at the index
                        raid5Drive3[dataIndex] = (byte)(-1);
                    }
                    else {
                        System.out.println("DataCounter: " + dataCounter);
                        raid5Drive3[dataIndex] = raid5Data[dataCounter];
                        dataCounter++;
                    }
                    break;
                case 3:
                    System.out.println("ParityCatcher: " + parityCatcher);
                    if(parityCatcher == 1) {
                        System.out.println("Placing parity at drive 4, index " + dataIndex);
                        //place the parity at the index
                        raid5Drive4[dataIndex] = (byte)(-1);
                    }
                    else {
                        System.out.println("DataCounter: " + dataCounter);
                        raid5Drive4[dataIndex] = raid5Data[dataCounter];
                        dataCounter++;
                    }
                    parityCatcher++;
                    break;
            }
        }

        //now let's print out the contents of each RAID 5 drive
        System.out.println();
        System.out.println();
        System.out.println("RAID 5 Drive 1 contents:");
        for(byte b : raid5Drive1){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 5 Drive 2 contents:");
        for(byte b : raid5Drive2){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 5 Drive 3 contents:");
        for(byte b : raid5Drive3){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 5 Drive 4 contents:");
        for(byte b : raid5Drive4){
            System.out.print(b + " ");
        }

        //##############################################################
        //RAID 6 - STRIPING WITH 2X PARITY EXAMPLE
        //##############################################################

        //here are the 5 hard drives we will be using
        byte[] raid6Drive1 = new byte[4];
        byte[] raid6Drive2 = new byte[4];
        byte[] raid6Drive3 = new byte[4];
        byte[] raid6Drive4 = new byte[4];
        byte[] raid6Drive5 = new byte[4];

        //NOTE: In a real RAID 6 implementation, the parity bytes would be calculated based on the data bytes.
        // The parity bytes are represented as -1 and -2 for simplicity.

        int dataCounter6 = 0;
        int parityCatcher6 = 1; //determine which drive gets the parity byte

        //now let's use striping with double parity to feed the data into the five drives
        for(int i = 0; i < (raid5Data.length + 8); i++){
            
            int driveIndex = i % 5; //determine which drive to place data
            int dataIndex = i / 5;//determine the index within the drive to place data

            switch(driveIndex){
                case 0:
                    if(parityCatcher6 == 4) {
                        //place the parity at the index
                        raid6Drive1[dataIndex] = (byte)(-1) ;
                    }
                    else {
                        raid6Drive1[dataIndex] = raid5Data[dataCounter6];
                        dataCounter6++;
                    }
                    break;
                case 1:
                    if(parityCatcher6 == 3 || parityCatcher6 == 4) {
                        //place the parity at the index
                        raid6Drive2[dataIndex] = (parityCatcher6 == 3) ? (byte)(-1) : (byte)(-2);
                    }
                    else {
                        raid6Drive2[dataIndex] = raid5Data[dataCounter6];
                        dataCounter6++;
                    }
                    break;
                case 2:
                    if(parityCatcher6 == 2 || parityCatcher6 == 3) {
                        //place the parity at the index
                        raid6Drive3[dataIndex] = (parityCatcher6 == 2) ? (byte)(-1) : (byte)(-2);
                    }
                    else {
                        raid6Drive3[dataIndex] = raid5Data[dataCounter6];
                        dataCounter6++;
                    }
                    break;
                case 3:
                    if(parityCatcher6 == 1 || parityCatcher6 == 2) {
                        //place the parity at the index
                        raid6Drive4[dataIndex] = (parityCatcher6 == 1) ? (byte)(-1) : (byte)(-2);
                    }
                    else {
                        raid6Drive4[dataIndex] = raid5Data[dataCounter6];
                        dataCounter6++;
                    }
                    break;
                case 4:
                    if(parityCatcher6 == 1 ) {
                        //place the parity at the index
                        raid6Drive5[dataIndex] = (byte)(-2);
                    }
                    else {
                        raid6Drive5[dataIndex] = raid5Data[dataCounter6];
                        dataCounter6++;
                    }
                    parityCatcher6++;
            }
        }

        //now let's print out the contents of each RAID 6 drive
        System.out.println();
        System.out.println();
        System.out.println("RAID 6 Drive 1 contents:");
        for(byte b : raid6Drive1){
            System.out.print(b + " ");
        }   
        System.out.println("\nRAID 6 Drive 2 contents:");
        for(byte b : raid6Drive2){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 6 Drive 3 contents:");
        for(byte b : raid6Drive3){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 6 Drive 4 contents:");
        for(byte b : raid6Drive4){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 6 Drive 5 contents:");
        for(byte b : raid6Drive5){
            System.out.print(b + " ");
        }

        //##############################################################
        //RAID 10 - STRIPING WITH MIRRORING EXAMPLE
        //##############################################################

        //create the data to be split amongst the drives

        //make four drives to represent the hard drives
        byte[] raid10Drive1 = new byte[4];
        byte[] raid10Drive2 = new byte[4];
        byte[] raid10Drive3 = new byte[4];
        byte[] raid10Drive4 = new byte[4];
        byte[] raid10Drive5 = new byte[4];
        byte[] raid10Drive6 = new byte[4];

        //now let's use striping with mirroring to feed the data into the four drives
        for(int i = 0; i < raid5Data.length; i++){
            int driveIndex = i % 3;
            int dataIndex = i / 3;

            switch(driveIndex){
                case 0:
                    raid10Drive1[dataIndex] = raid5Data[i];
                    raid10Drive2[dataIndex] = raid5Data[i]; //mirror
                    break;
                case 1:
                    raid10Drive3[dataIndex] = raid5Data[i];
                    raid10Drive4[dataIndex] = raid5Data[i]; //mirror
                    break;
                case 2:
                    raid10Drive5[dataIndex] = raid5Data[i];
                    raid10Drive6[dataIndex] = raid5Data[i]; //mirror
                    break;
            }
        }

        //now let's print out the contents of each RAID 10 drive
        System.out.println();
        System.out.println();
        System.out.println("RAID 10 Drive 1 contents:");
        for(byte b : raid10Drive1){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 10 Drive 2 contents:");
        for(byte b : raid10Drive2){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 10 Drive 3 contents:");
        for(byte b : raid10Drive3){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 10 Drive 4 contents:");
        for(byte b : raid10Drive4){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 10 Drive 5 contents:");
        for(byte b : raid10Drive5){
            System.out.print(b + " ");
        }
        System.out.println("\nRAID 10 Drive 6 contents:");
        for(byte b : raid10Drive6){
            System.out.print(b + " ");
        }
    }
}
