# TrashpanBot User Guide

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

TrashpanBot is an interactive task list manager.
It is able to store tasks of various types and has many functions to aid in managing tasks.
It can also save your tasks automatically and reload them.

It is optimised for a Command-Line Interface (CLI).

This bot is based on the personality of [Raki Kazuki](https://www.youtube.com/@RakiKazuki), a Virtual YouTuber formerly from
PixelLink.

## Quick Start

This section will guide you through first-time installation of TrashpanBot.

### 1. Check the Java version on your device
This bot runs on the Java 17 JDK.

To check if you have Java installed on your device, open a Terminal window
and run the command: `java -version`

The output should appear like this:
```
java version "17.0.12" 2024-07-16 LTS
Java(TM) SE Runtime Environment (build 17.0.12+8-LTS-286)
```
Ensure the Java version listed begins with "17".

You may skip step 2 if you have Java 17 installed.

### 2. Install Java 17

If you get an error or see a different version in the previous step,
Java 17 may not be installed.

You may download Java from [here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).

**Installation Instructions:**
- For Windows Users

Any Windows installer will work, but the Windows x64 Installer is recommended for ease of use.

- For Mac Users

The DMG installer is recommended. However, please note down the CPU of your Mac.

Use the macOS x64 DMG Installer if your Mac has an Intel CPU, or the macOS Arm 64 DMG Installer if your Max has an Apple M-series CPU.

- For Linux Users

Check instructions for your distribution as installation may differ between distros.

Generally, use the Debian Package for Debian-based distros (Ubuntu, Linux Mint) and the RPM Package for Red Hat-based distros (Fedora, CentOS).

### 3. Download the latest .jar file of TrashpanBot

Download the latest .jar file release of TrashpanBot [here](https://github.com/HightechTR/ip/releases).

### 4. Place the .jar file in a desired home folder

Move or copy the file to any desired folder on your computer.\
The folder it will be in will serve as the working home folder for TrashpanBot.

### 5. Run the application from the terminal

Right-click an empty space in the home folder and select Open in Terminal.
Alternatively, you may open a Terminal window and `cd` into the home folder.

Run the command `java -jar TrashpanBot.jar` to start the application in the terminal.

You should get this in the output:
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
What can I do for you today?
__________________________________________________
```

When the bot runs for the first time, it will create a `data` folder/directory in the
home folder. This folder contains the save data for TrashpanBot.
Do not modify or delete this folder to prevent loss of save data.

## Features

### \> Notes about the command format

The command format for examples below will be displayed in a format
that resembles this:
```
deadline <description> /by <due>
```
Any component in angle brackets `<>` denote parameters. They must be defined when you run the command.

For example, in the command `todo <description>`, `<description>` is a parameter.
It may be used as `todo Read Book`.

Unless otherwise specified, parameters are accepted simply as strings or plain text with no specific format.

Components with a forward slash `/` separate different parts of some commands.
They must be included as-is when running the command.

For commands that do not take in parameters, such as `list`, any extraneous parameters added to
the command will be ignored.

### \> Notes about Task Types and Format

TrashpanBot can store three types of tasks: `todo`, `deadline` and `event`.

**> Todo Task**

A `todo` is a task that only contains a description. It does not have any date attached to it.\
It is represented in the task list like this:
```
1.[T][ ] Example
```

**> Deadline Task**

A `deadline` is a task that contains a description and a due date.\
It is represented in the task list like this:
```
1.[D][ ] Example (by: 12 June 2025 13:00)
```

**> Event Task**

An `event` is a task that contains a description and two dates, a start and an end date.\
It is represented in the task list like this:
```
1.[E][ ] Example (from: 12 June 2025 13:00 to: 14 June 2025 15:00
```

**> Marked Tasks**

Tasks that are marked as done will have an additional `X` shown in the box next to the type icon:
```
1.[T][X] Example
```


### \> Adding Tasks: `todo`, `deadline` & `event`

**> Todo Task**

This command adds a `todo` task to the list.

**Format**: `todo <description>`

**Parameters**:

`<description>`: Refers to the description of the todo task.

**Example Usage**:\
`todo Play Muse Dash`

```
Okay! I added this to the list:
1.[T][ ] Play Muse Dash
You have 1 task now!
```

**> Deadline Task**

This command adds a `deadline` task to the list.

**Format**: `deadline <description> /by <due>`

**Parameters**:

`<description>`: The description of the deadline task.

`<due>`: Refers to the due date of the deadline task. 

- `<due>` must be in the format `yyyy-mm-dd HH:MM`
- `yyyy` is the year, `mm` is the month, `dd` is the day, `HH:MM` is the time in the 24-hour format.

**Example Usage**:\
`deadline Finish Cover Song /by 2025-09-12 18:30`

```
Okay! I added this to the list:
1.[D][ ] Finish Cover Song (by: 12 Sep 2025 18:30)
You have 1 task now!
```

**> Event Task**

This command adds an `event` task to the list.

**Format**: `event <description> /from <start> /to <end>`

**Parameters**:

`<description>`: The description of the event task.

`<start>`: Refers to the start date of the event task.

`<end>`: Refers to the end date of the event task.

- Both `<start>` and `<end>` must be in the format `yyyy-mm-dd HH:MM` 
- `yyyy` is the year, `mm` is the month, `dd` is the day, `HH:MM` is the time in the 24-hour format.

**Example Usage**:\
`deadline Raki Birthday!! /from 2025-10-24 12:00 /to 2025-10-24 18:00`

```
Okay! I added this to the list:
1.[E][ ] Raki Birthday!! (from: 24 Oct 2025 12:00 to: 24 Oct 2025 18:00)
You have 1 task now!
```

### \> Listing Tasks: `list`

This command lists all the tasks that are in the list.

**Format**: `list`

**Example Usage**:\
`list`

```
Okay, here's your list:
1.[T][ ] Play Muse Dash
2.[D][ ] Finish Cover Song (by: 12 Sep 2025 18:30)
3.[E][ ] Raki Birthday!! (from: 24 Oct 2025 12:00 to: 24 Oct 2025 18:00)
```

If the task list is empty, this message will be shown:
```
Your list is empty! Try adding a task!
```

### \> Finding Tasks: `find`

This command will search for tasks in the list and list them to you.

**Format:** `find <keyword>`

**Parameters:**

`<keyword>`: The keyword to be searched.

**Example Usage:**\
`find book`

For a full task list like this:
```
1.[T][ ] Read book
2.[T][ ] Play Muse Dash
3.[D][ ] Return book (by: 31 Aug 2025 14:00)
```

This will search for the tasks containing the word `book` and list them:
```
Look, here's what I found:
1.[T][ ] Read book
3.[D][ ] Return book (by: 31 Aug 2025 14:00)
```
Note that the index of the tasks listed in this list match that in the full list.
This allows for easy use of the `mark`, `unmark` and `remove` commands (more information below).

If there are no tasks containing the given keyword, this message will be shown:
```
I couldn't find any tasks with that keyword! I hope I didn't lose them...
```

### \> Marking Tasks: `mark` & `unmark`

**> Marking as Done**

This command marks a task as done.

**Format**: `mark <number>`

**Parameters**:

`<number>`: Refers to the index number shown in the displayed list.

- `<number>` must be a whole number, i.e. `1`, `2`, `3`, ...

**Example Usage**:\
`mark 1`

This marks the first task in the full list as done.
```
Yay! I've marked this task as done:
1.[T][X] Play Muse Dash
```

**> Marking as Not Done**

This command marks a task as not done.

**Format**: `unmark <number>`

**Parameters**:

`<number>`: Refers to the index number shown in the displayed list.

- `<number>` must be a whole number, i.e. `1`, `2`, `3`, ...

**Example Usage**:\
`unmark 1`

This marks the first task in the full list as not done.
```
Ganbaraki! I've marked this task as not done:
1.[T][ ] Play Muse Dash
```

### \> Removing Tasks: `remove`

This command removes a specified task from the list.

**Format**: `remove <number>`

**Parameters**:

`<number>`: Refers to the index number shown in the displayed list.

- It must be a positive whole number, i.e. `1`, `2`, `3`, ...

**Example Usage**:\
`remove 1`

This removes the first task in the full list.
```
Okay! I threw this task into the bin:
1.[T][ ] Play Muse Dash
You have 2 tasks now!
```

### \> Listing Commands: `help`

This command lists all the commands you can run.

**Format**: `help`

### \> Exiting the Program: `bye`

This command exits the program.

**Format**: `bye`

### \> Saving the Task List

TrashpanBot automatically saves the task list every time it is changed.\
When the bot starts, it will automatically load data from the save file.

**> Creating a New Save File**

If there is no save file (i.e. when the bot starts for the first time), this message is shown at startup:
```
Uh...I couldn't find a save file...
No worries, I'll create one for you!
```

**> Loading an Existing Save File**

If there is a save file, it will begin loading it and will show this message:
```
Look, I found a save file!
Loading it for you...
```

If the load is successful, it will immediately start the program.

### \> Editing the Save File

TrashpanBot stores its save file in plaintext using a .txt file.\
Advanced users may edit the save file directly.

> [!CAUTION]
> If your edits to the save file makes its format invalid, TrashpanBot will discard
> all data and start from a fresh save file.\
> If this occurs, this message will be shown after loading the save:
> ```
> Eh? Something's wrong with the save file, it's all gibberish!
> Here, I'll create a new one for you.
> ```
> It is recommended to back up the save file before editing it.



## Command Summary
| Action                |                                                     Format & Examples                                                     |
|-----------------------|:-------------------------------------------------------------------------------------------------------------------------:|
| Add Todo Task         |                                    `todo <description>`<br>e.g. `todo Play Muse Dash`                                     |
| Add Deadline Task     |               `deadline <description> /by <due>`<br>e.g. `deadline Finish Cover Song /by 2025-09-12 18:30`                |
| Add Event Task        | `event <description> /from <start> /to <end>`<br>e.g. `event Raki Birthday!! /from 2025-10-24 12:00 /to 2025-10-24 18:00` |
| List Tasks            |                                                          `list`                                                           |
| Find Tasks            |                                           `find <keyword>`<br>e.g. `find book`                                            |
| Mark Task as Done     |                                             `mark <number>`<br>e.g. `mark 1`                                              |
| Mark Task as Not Done |                                           `unmark <number>`<br>e.g. `unmark 1`                                            |
| Remove Task           |                                           `remove <number>`<br>e.g. `remove 1`                                            |
| List Commands         |                                                          `help`                                                           |
| Exit Program          |                                                           `bye`                                                           |
