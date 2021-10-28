Firstly open a java code ide then add java class to your project.

Create Jar file In yihs projext my jar File name is "Java_CS".If you use netbeans ide right click project name 
and select "clean and build".after that ide creates dist folder and in this folder you can see .jar extension file.

If you look java source code you can see that this code aims to run smart card with using java smard library and this java
code invoke from c#.For using this project with no chane you have to plug your smart card to your PC otherwise you see 
some java smart card exceptions.

After built java code you can start c# section click "C# code" folder copy "Program.cs" file to your # project when you look at
this code ypu can see this program creates a file which name is "filename.txt" thenn writes the file an APDU(Java manager command)
and runs "Java_CS.jar" file with using the file. If you dont use your c#'s file path you have to write  specify your "Java_CS.jar" file path.

After proper arrangement and run c# code you will see that c# writes "filename.txt" fill and run java code with using your jar file and finally takes console output of your java code.  

This code includes:


=>C# txt file creation

=>Running java source code from C#

=>reading Smart card ATR  

=>sending Smart card apdu  

=>reading java console output from C#
