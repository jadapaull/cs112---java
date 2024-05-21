// to put stuff from txt into the keyboard input 
//  java FileSys < testfile.txt
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class FileSys{
    static class IOE extends IOException {
        IOE() {
            super("Please enter valid name");// gives to IOEException to print this message
        }
    }

    public static String newfile(String filename, node location) { // makes a new file, allows text for content
        node file = new node(filename, "file", location); // creates file with parent current directory
        location.addChild(file); //adds file as child of parent directory
        String scannerread = "";
        // TODO
        Scanner scanner2 = new Scanner(System.in);// makes a scanner that reads from keyboard
        while (scanner2.hasNextLine()) {// while no ~ keep reading
            scannerread = scannerread + scanner2.nextLine();
            if (scannerread.indexOf("~") > -1) {// save it without the ~
                scannerread = scannerread.substring(0, scannerread.indexOf("~"));
                break;
            }
        }
        file.content = scannerread;// adds this to the file content
        return scannerread;
    }

    public static void main(String[] args) {
        node location = new node("/", "directory", null);
        final node root = location;
        Scanner keyboard = new Scanner(System.in); // keyboard input for the user
        System.out.print("jadastestcommandline - % ");
        while (keyboard.hasNextLine()) {
            try {
                String sentence = keyboard.nextLine();// makes it into a sentence
                if (sentence.contains("exit")) {// if it contains exit
                    System.out.println("Goodbye");// says goodbye
                    return;// program closes
                } else if (sentence.startsWith("create")) {// makees a new file 
                    if (sentence.length() > 6 && sentence.contains(".")) {// verifies theres a period for ending TODO check if files will have .suffix

                        System.out.print("jadastestcommandline - % ");
                        String filename = "" + sentence.substring(7);// gets filename
                        String file = newfile(filename, location);// gets contents of the file
                        System.out.print("jadastestcommandline - % ");

                    } else {
                        throw new IOE();// no filename or wrong filename
                    }

                } else if (sentence.contains("rm") && sentence.contains("dir") == false) { // remove file
                    if (sentence.length() > 3) {
                        String filename = "" + sentence.substring(3);// making filename
                        removeFile(filename, location);// calls the remove file function
                        System.out.print("jadastestcommandline - % ");
                    }

                    else {
                        throw new IOE();// no filename
                    }
                } else if (sentence.contains("find")) { // searches for node with given name in working directory or children
                    if (sentence.length() > 5) {// if has anything
                        String filename = "" + sentence.substring(5);// making directory
                        ArrayList<String> paths = findFileOrDir(filename, location, root);
                        int length = paths.size();
                        if (length > 0){
                            int i = 0;
                            while (i < length - 1){
                                System.out.println(paths.get(i));
                                i++;
                            }
                            System.out.print("jadastestcommandline - % ");
                        }
                        else {
                            throw new IOE();
                        }
                    } else {
                        throw new IOE();
                    }
                } else if (sentence.startsWith("rmdir ")) {
                    if (sentence.length() > 6) {
                        removeDirectory(sentence.substring(6), location);
                        System.out.print("jadastestcommandline - % ");
                    } else {
                        throw new IOE();
                    }
                }

                else if (sentence.contains("ls")) {
                    if (sentence.length() == 2) {
                        if (location != null) {
                            location.printChildren();
                            System.out.print("\njadastestcommandline - % ");
                        }
                    } else {
                        throw new IOE();
                    }
                } else if (sentence.startsWith("cd ")) { // change directory. Either to parent (..) or to child
                                                         // directory
                                                         // (given)
                    if (sentence.length() > 3) {
                        if (sentence.contains("..")) { // TODO change this so that it only works when cd ..
                            location = cdParent(location);
                            System.out.print(location.name);
                            // location = location.parent;
                            System.out.print("jadastestcommandline - % ");
                        } else if (sentence.length() > 3 && sentence.contains("..") == false
                                && sentence.contains("/") == false) {
                            String dirname = sentence.substring(3);
                            location = changeDirectory(dirname, location);
                            System.out.print("jadastestcommandline - % ");
                        } else if (sentence.contains("/")) {
                            location = root;
                            System.out.print("jadastestcommandline - % ");
                        }
                    }
                } else if (sentence.startsWith("cat ")) {
                    if (sentence.length() > 4) {
                        String filename = "" + sentence.substring(4);// making filename
                        catFile(filename, location);
                        System.out.print("jadastestcommandline - % ");

                    } else {
                        throw new IOE();// no filename
                    }
                } else if (sentence.startsWith("mkdir ")) { // makes directory. Calls createDir and sends all text after
                                                            // "mkdir " as name
                    if (sentence.length() > 6) {// looks at sentence and makes sure it is over 6
                        location = createDir(sentence.substring(6), location);// creates a directory in the location
                        System.out.print("jadastestcommandline - % ");
                    } else {
                        throw new IOE();
                    }
                } else if (sentence.contains("pwd")) { //prints path to current directory
                    if (sentence.length() == 3) {
                        workingDirectory(location, root);
                        System.out.print("jadastestcommandline - % ");
                    } else {
                        throw new IOE();
                    }
                } else {
                    throw new IOE();
                }

            } catch (IOE ABC) {
                System.out.println(ABC.getMessage());
                System.out.print("jadastestcommandline - % ");
            }
        }
        keyboard.close();

    }

    public static String workingDirectory(node location, node root) { // finds all prints path to current directory
        String currentLevel = location.name; // initialize string with current directory
        while (location != root) { // until at root directory, finds parent & adds it to front of string
            currentLevel = location.parent.name + "/" + currentLevel;
            location = location.parent;
        }
        System.out.println(currentLevel.substring(1)); //fixes extra slashes
        return currentLevel.substring(1);
    }

    public static ArrayList<String> findFileOrDir(String name, node location, node root){ // finds all instances of files or directories with name in working directory or any children 
        ArrayList<String> paths = new ArrayList<String>();// makes a new array list 
        for (node child : location.children){ // for each child checks if name matches
            if (name.equals(child.name)){
                paths.add(workingDirectory(child, root));
            }
            if (child.children != null){ // if not file
                if (child.children.size() > 0){ // check child for the directory 
                    findFileOrDir(name, child, root);// uses recursion
                }
            }
            
        }
        return paths;// returns the array list created
    }

    public static void catFile(String name, node location) {// prints out the file contents
        boolean exists = false;
        for (node child : location.children) {
            if (name.equals(child.name) && child.type.equals("file")) {// if the file name  is correct and it is classified as a file
                exists = true;// change boolean
                child.getContent();// runs basic get content method
            }
        }
        if (exists == false) {
            System.out.println("file doesn't exist");// returns this if does not exist
        }
    }

    public static boolean removeFile(String name, node location) { // removes file from current directory 
        boolean exists = false;
        for (node child : location.children) {
            if (name.equals(child.name) && child.type.equals("file")) { // checks for matches and makes sure type is file
                exists = true;
                location.children.remove(child);// uses the remove helper from the list to remove the child 
                child = null;
                return true;
            }
        }
        System.out.println(exists);
        if (exists == false) { // if no match, prints file doesn't exist
            System.out.println("file doesn't exist");
        }
        return false;
    }

    public static boolean removeDirectory(String name, node location) { // test to see if works, remove print(exists)
                                                                        // when it does
        boolean exists = false;
        for (node child : location.children) {
            if (name.equals(child.name) && child.type.equals("directory")) { // checks for matches and makes sure type is directory
                exists = true;
                location.children.remove(child);// uses the remove helper from the list to remove the child 
                return true;
                // child = null;
            }
        }
        if (exists == false) {
            System.out.println("directory doesn't exist");// if no match, prints directory doesn't exist
        }
        return false;
    }

    public static void createFile(String name, node location) { // makes file in current directory
        location.addChild(new node(name, "file", location));
    }

    public static node createDir(String name, node location) {// makes a new direcotry in the current directory

        if (location == null) {// if there's no root then makes a new directory that is root
            location = new node(name, "directory", location);
        } else {
            location.addChild(new node(name, "directory", location));// if root exists then adds it as a child of current directory
        }
        return location;
    }

    public static node cdParent(node location) {// makes the location parent instead of the child directory it is in 
        return location.parent;
    }

    public static node changeDirectory(String name, node location) {// changing directories
        boolean exists = false;
        for (node child : location.children) {
            if (name.equals(child.name) && child.type.equals("directory")) {// checks that there is a directory witht he name and that has a classification of directory
                location = child;
                exists = true;// changes boolean
                return child;
            }
        }
        if (exists == false) {// if the directory is not found prints it
            System.out.println("Directory does not exist");
        }

        return location; // for changing directory
    }

}

class node {
    node parent;  // parent (above) directory
    String name;  // name of node
    String type;  // file or directory
    String content;  //file only - string of content
    List<node> children;  //directory only - all files and directories directly under node

    public node(String name, String type, node location) { //constructor for node
        this.name = name;
        this.parent = location;
        // this.parent = location;
        if (type == "file") { // if type is file, creates file type
            this.type = "file";
            this.content = ""; // no content to start with
            this.children = null; //no children
        } else { //if type is not file, automatically becomes directory
            this.type = "directory";
            this.children = new ArrayList<>(); //empty ArrayList for children
            this.content = null; //no content
        }
    }

    public void addContent(String content) {// adds content to the file that we created
        this.content += content;
    }

    public void getContent() {//prints out teh content of the file 
        System.out.println(this.content);
    }

    public void addChild(node child) {// adds a child to the current directory
        this.children.add(child);
    }

    public List<node> getChildren() {// returns out the childen of the current locatin that we are in
        return this.children;
    }

    public void printDetails() { //prints the name and type of node, info. Only used for testing
        if (this.type == "file") { //for files, prints content
            System.out.println(this.type + " " + this.name);
            System.out.println("file contains \"" + this.content + "\"");
        } else if (this.type == "directory") { // for directory prints children
            System.out.println(this.type + " " + this.name + " " + "contains");
            for (node child : children) { // prints each child's name
                System.out.println(child.name);
            }
            System.out.println("\n");
        } else { // if not file or directory prints error
            System.out.println("error");
        }
    }

    public void printChildren() { //used for ls. Prints children of current directory, indicates node type
        for (node child : children) {
            if (child.type == "file") {// if the type is a file then prins name of file and tab
                System.out.print(child.name + "     ");
            } else if (child.type == "directory") {// if type is directory then prints name of dir and asterisk and tab
                System.out.print(child.name + " (*)     ");
            } else {// Just in case one slips throught the cracks
                System.out.print("Unidentified type     ");
            }
        }
    }
}