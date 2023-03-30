package edu.nyu.cs;

import java.util.Arrays;
import java.util.Random;

/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and must be completed and used as indicated.
 * Create as many additional properties or methods as you want, as long as the given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped {
    private String orientation = "south";
    private int[] location = {10,5};
    private double gas = 100;
    private String name="";

    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */
    public void setOrientation(String orientation) {
       this.orientation = orientation;
        
    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return this.orientation;     
    }

    /**
     * Prints the current location, by default exactly following the format:
     *      Now at 12th St. and 5th Ave, facing South.
     *
     * If the current location is associated with location-based advertising, this method should print exactly following format:
     *      Now at 12th St. and 4th Ave, facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
        int[] location = this.location;
        String orientation = this.getOrientation();
        int st = location[0];
        int ave= location[1];
        String adver = adv();
        if(st==1){
            System.out.println("     Now at "+ st +"st St. and "+ ave +"th Ave, facing "+ orientation + ".  " + adver);
        } 
        else if(st==2){
            System.out.println("     Now at "+ st +"nd St. and "+ ave +"th Ave, facing "+ orientation + ".  " + adver);
        }
        else if(st==3){
            System.out.println("     Now at "+ st +"rd St. and "+ ave +"th Ave, facing "+ orientation + ".  " + adver);
        }
        else{
            System.out.println("     Now at "+ st +"nd St. and "+ ave +"th Ave, facing "+ orientation + ".  " + adver);
        }

    }

    public String adv(){
        String ad="";
        int[] location = this.getLocation();
        int st = location[0];
        int ave = location[1];
        if(st == 79 && ave==8){
            ad="Welcome to the American Museum of Natural History.";
        }
        else if(st==74 && ave==1){
            ad="Welcome to the Memorial Sloan Kettering.";
        }
        else if(st==56 && ave==3){
            ad="Welcome to the Tina's Cuban Cuisine.";
        }
        else if(st==12 && ave==4){
            ad="Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?";
        }
        else if(st==15 && ave==8){
            ad="We have reached Xi'an Famous Foods.  Enjoy your noodles.";
        }
        return ad;
    }

    

    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {
        String orientation1 = this.getOrientation();
        int st = this.getLocation()[0];
        int ave = this.getLocation()[1]; 
        float gasl = this.getGasLevel();
        if(gasl != 0 && st<200 && ave<10){
            if(orientation1.equals("south")){
                this.setOrientation("east");
                ave = ave-1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation1.equals("east")){
                this.setOrientation("north");
                st = st+1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation1.equals("north")){
                this.setOrientation("west");
                ave = ave+1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation1.equals("west")){
                this.setOrientation("south");
                st = st-1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
               
        }
    }
        else if(st==200 && orientation1.equals("east")){
            this.setOrientation("north");
            int[] loc ={st,ave};
            this.setLocation(loc);
        }

        else if(st==200 && orientation1.equals("north")){
            this.setOrientation("west");
            ave=ave+1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
        }

        else if(st==200 && orientation1.equals("south")){
            this.setOrientation("east");
            if(ave !=1){
                ave=ave-1;
            } 
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
        }

        else if(st==200 && orientation1.equals("west")){
            this.setOrientation("south");
            st=st-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
        }
    
        else if(ave==10 && orientation1.equals("north")){
            this.setOrientation("west");
            int[] loc ={st,ave};
            this.setLocation(loc);
    }

        else if(ave==10 && orientation1.equals("south")){
            this.setOrientation("east");
            ave=ave-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }

        else if(ave==10 && orientation1.equals("east")){
            this.setOrientation("north");
            st=st+1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }
        else if(ave==10 && orientation1.equals("west")){
            this.setOrientation("south");
            st=st-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
}

        
    }

    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {
        String orientation2 = this.getOrientation();
        int st = this.getLocation()[0];
        int ave = this.getLocation()[1]; 
        float gasl = this.getGasLevel();
        if(gasl != 0 && st<200 && ave<10){
            if(orientation2.equals("south")){
                this.setOrientation("west");
                ave = ave+1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
        }
                
            else if(orientation2.equals("east")){
                this.setOrientation("south");
                st = st-1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation2.equals("north")){
                this.setOrientation("east");
                ave = ave-1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation2.equals("west")){
                this.setOrientation("north");
                st = st+1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
    }
        else if(st==200 && orientation2.equals("east")){
            this.setOrientation("south");
            st=st-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }

        else if(st==200 && orientation2.equals("north")){
            this.setOrientation("east");
            if(ave!=1){
                ave=ave-1;
            }
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }

        else if(st==200 && orientation2.equals("south")){
            this.setOrientation("west");
            ave=ave+1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }

        else if(st==200 && orientation2.equals("west")){
            this.setOrientation("north");
            int[] loc ={st,ave};
            this.setLocation(loc);
    }
        else if(ave==10 && orientation2.equals("east")){
            this.setOrientation("south");
            st=st-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
}

        else if(ave==10 && orientation2.equals("north")){
            this.setOrientation("east");
            ave=ave-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
}

        else if(ave==10 && orientation2.equals("south")){
            this.setOrientation("west");
            int[] loc ={st,ave};
            this.setLocation(loc);
}

        else if(ave==10 && orientation2.equals("west")){
            this.setOrientation("north");
            st=st+1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
}
    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
        String orientation3 = this.getOrientation();
        int st = this.getLocation()[0];
        int ave = this.getLocation()[1]; 
        float gasl = this.getGasLevel();
        if(gasl != 0 && st<200 && ave<10){
            if(orientation3.equals("south")){
                this.setOrientation("south");
                st = st-1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation3.equals("east")){
                this.setOrientation("east");
                ave = ave-1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation3.equals("north")){
                this.setOrientation("north");
                st = st+1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation3.equals("west")){
                this.setOrientation("west");
                ave = ave+1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
    }
        else if(st==200 && orientation3.equals("north")){
            this.setOrientation("north");
            int[] loc ={st,ave};
            this.setLocation(loc);
        }
        else if(st==200 && orientation3.equals("west")){
            this.setOrientation("west");
            ave=ave+1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }
        else if(st==200 && orientation3.equals("east")){
            this.setOrientation("east");
            ave=ave-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
        }

        else if(st==200 && orientation3.equals("south")){
            this.setOrientation("south");
            st=st-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
        }

        else if(ave==10 && orientation3.equals("north")){
            this.setOrientation("north");
            st=st+1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
        }
        else if(ave==10 && orientation3.equals("west")){
            this.setOrientation("west");
            int[] loc ={st,ave};
            this.setLocation(loc);
    }
        else if(ave==10 && orientation3.equals("east")){
            this.setOrientation("east");
            ave=ave-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
        }

        else if(ave==10 && orientation3.equals("south")){
            this.setOrientation("south");
            st=st-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
        }

    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
        String orientation4 = this.getOrientation();
        int st = this.getLocation()[0];
        int ave = this.getLocation()[1]; 
        float gasl = this.getGasLevel();
        if(gasl != 0 && st<200 && ave<10){
            if(orientation4.equals("south")){
                this.setOrientation("south");
                st = st+1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation4.equals("east")){
                this.setOrientation("east");
                ave = ave+1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation4.equals("north")){
                this.setOrientation("north");
                st = st-1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
            else if(orientation4.equals("west")){
                this.setOrientation("west");
                ave = ave-1;
                int[] loc ={st,ave};
                this.setLocation(loc);
                this.setGasLevel(gasl-5);
                
        }
    }
        else if(st==200 && orientation4.equals("north")){
            this.setOrientation("north");
            st=st-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }
        else if(st==200 && orientation4.equals("west")){
            this.setOrientation("west");
            ave=ave-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
}
        else if(st==200 && orientation4.equals("east")){
            this.setOrientation("east");
            ave=ave+1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }

        else if(st==200 && orientation4.equals("south")){
            this.setOrientation("south");
            int[] loc ={st,ave};
            this.setLocation(loc);
    }

        else if(ave==10 && orientation4.equals("north")){
            this.setOrientation("north");
            st=st-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }
        else if(ave==10 && orientation4.equals("west")){
            this.setOrientation("west");
            ave=ave-1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
}
        else if(ave==10 && orientation4.equals("east")){
            this.setOrientation("east");
            int[] loc ={st,ave};
            this.setLocation(loc);
    }

        else if(ave==10 && orientation4.equals("south")){
            this.setOrientation("south");
            st=st+1;
            int[] loc ={st,ave};
            this.setLocation(loc);
            this.setGasLevel(gasl-5);
    }

    }

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        double percent = this.gas;
        int percent1 = (int)Math.round(percent);
        return percent1;
         
    }

    public void setGasLevel(double gas){
        this.gas = gas;
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We have run out of gas.  Bye bye!
     */
    public void printGasLevel() {
        int gas = this.getGasLevel();
        if(gas == 0){
            System.out.println("      We have run out of gas.  Bye bye!");
        }
        else{
            String strgas=Integer.toString(gas)+"%";
            System.out.println("      The gas tank is currently " + strgas + " full");
        }

    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        this.gas=100;

    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {
        System.exit(0);

    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        int[] loc = this.getLocation();
        int st = loc[0];
        int ave = loc[1];
        int gas = getGasLevel();
        if(gas==0){
            fillGas();
        }
        if(st<15 && ave<8){
            boolean keepgoing = true;
            this.setOrientation("west");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                ave++;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(ave==8){
                    break;
                }
            }
            this.setOrientation("north");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                st++;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(st==15){
                    break;
                }
            }
        }

        else if(st<15 && ave>8){
            boolean keepgoing = true;
            this.setOrientation("east");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                ave=ave-1;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(ave==8){
                    break;
                }
            }
            this.setOrientation("north");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                st++;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(st==15){
                    break;
                }
            }
        }

        else if(st>15 && ave>8){
            boolean keepgoing = true;
            this.setOrientation("east");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                ave=ave-1;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(ave==8){
                    break;
                }
            }
            this.setOrientation("south");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                st=st-1;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(st==15){
                    break;
                }
            }
        }

        else if(st>15 && ave<8){
            boolean keepgoing = true;
            this.setOrientation("west");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                ave++;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(ave==8){
                    break;
                }
            }
            this.setOrientation("south");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                st=st-1;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(st==15){
                    break;
                }
            }
        }

        else if(st==15 && ave<8){
            boolean keepgoing = true;
            this.setOrientation("west");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                ave++;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(ave==8){
                    break;
                }
            }
        }
        
        else if(st==15 && ave>8){
            boolean keepgoing = true;
            this.setOrientation("east");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                ave=ave-1;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(ave==8){
                    break;
                }
            }
        }

        else if(st>15 && ave==8){
            boolean keepgoing = true;
            this.setOrientation("south");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                st=st-1;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(st==15){
                    break;
                }
            }
        }

        else if(st<15 && ave==8){
            boolean keepgoing = true;
            this.setOrientation("north");
            while(keepgoing){
                this.goStraight();
                this.printLocation();
                st++;
                this.setGasLevel(gas-5);
                if(this.getGasLevel()==0){
                    fillGas();
                }
                if(st==15){
                    break;
                }
            }
        }
    }    


        
        



    

    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        String command = "go left, go right, straight on, back up, how we doin' ?, fill it up, park, go to Xi'an Famous Foods";
        return command;
    }

    /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
        this.location = location;

    }

    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {street, avenue}.
     */
    public int[] getLocation() {
        return this.location;
    }

    public void setDrunkLocation(){
        Random ran = new Random();
        setLocation(new int[]{ran.nextInt(200),ran.nextInt(10)});
    }

    public void setMopedName(String name){
        this.name=name;
    }

    public String getMopedName(){
        return this.name;
    }

    public void drunk(){
        Random ran = new Random();
        if(getGasLevel()<10 ){
            fillGas();
        }
        int randomnum = ran.nextInt(4);
        switch(randomnum){
            case 0:
                goLeft();
                break;
            case 1:
                goRight();
                break;
            case 3:
                goStraight();
                break;
            case 4:
                goBackwards();
                break;
        }
        System.out.print(getMopedName()+": ");
        printLocation();
    }

    
}


