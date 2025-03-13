# TrashpanBot

This is the CS2113 Individual Project from Joel Chin.
It is a Command-Line Interface (CLI) task list tracker based on the Java project _Duke_.

This chatbot's name and personality are based on Raki Kazuki, a Virtual YouTuber formerly from PixelLink.

https://www.pixel-link.com/talent/raki-kazuki

## Setting up in IntelliJ

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open IntelliJ (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
2. Open the project into IntelliJ as follows:
   i. Click `Open`.
   ii. Select the project directory, and click `OK`.
   iii. If there are any further prompts, accept the defaults.
3. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
4. After that, locate the `src/main/java/TrashpanBot.java` file, right-click it, and choose `Run Duke.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
   __________________________________________________

   This bot is based on the personality of Raki Kazuki from PixelLink.

          .##+-                         -####
         ##   .####                  ###   .##
         ##  ##   ###################  ###  ##
         ##  #####                   #####  ##
          ##  ##                        #  ##
          ###                              ###
        ###        -#####      +#####        ###
      ###      -#########      #########+     ###
     ##       ####   ###       ####   ####      ###
   ###        #########          #########       ###
     ###        #####    ######     ###-          ##
       ####                                    ####
          ####                            #####
           ##                             ##

   Raah! I'm TrashpanBot!
   ```

**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.

## Running the .jar file

Prerequisites: JDK 17

1. Download the latest .jar file from Releases.
2. Copy .jar file into any folder. This folder will serve as the home directory for the application.
3. Open Terminal, cd into the home directory and run ```java -jar TrashpanBot.jar```
