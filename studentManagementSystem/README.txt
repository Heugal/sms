Stephan Luchanko
Databases Project pt 3
Documentation

This lab features multiple menus, managers, and beans which I have split up into different
packages for conciseness and clarity.
The log in which I used to test the program:
username: yooz
pass: 1234

Once logged in, the main database menu should come up. It features a student search section and 
a student information section. The student information section is populated with data once the
main program is started, so you can filter through the results using the navigation buttons below.
The last few entires have pictures associated with the users. The pictures are scaled down to fit
the window size in the upper right-hand corner. The text body displaying the student information
displays the information using embedded HTML to make the data clearer and can be manipulated 
at a later date. The search function requires one of the following: a student ID, a first name, or 
a last name. If none are present, the search will return all entries in the student table. 

The user history button will bring you to the user history menu. From there, the user can select
a start and end filter date, or neither to select all user history logs. The start date will
return all logs that are >= to the start date inputted. The end date will return all logs that 
are <= to the end date inputted. The dates should be entered in a "DD-Mon-YY" format (e.g. 11-Nov-13)

The delete user menu requires either a student ID or a lastname+firstname. Once provided, the program
will remove the specified user from the students table and their picture if one is present.

The add student menu requires all fields to be filled out in order to be input. The DOB should be entered
in a similar format to the dates for the user histry, namely DD-Mon-YY. The picture can be selected and
supports either .jpg or .png (other file formats may be supported, but I have not tested them yet.)

The edit student menu requires a student ID or firstname+lastname to tell the program which student to
edit. The user must also select either one of the readio buttons to select which field they would like to 
edit, or the picture radio button to change their picture.