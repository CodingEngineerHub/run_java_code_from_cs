using System;
using System.Diagnostics;
using System.IO;
namespace c_sp_java
{using System.Diagnostics;
    using System.Threading;

    class Program
    {
        static void Main(string[] args)
        {
            
            int counter = 0 ;
        
            string path = "filename.txt";
            if (File.Exists(path))
            {
                // Create a file to write to.
                using (StreamWriter sw = File.CreateText(path))
                {
                    sw.WriteLine("00a4000015");
                  
                   
                }
            }


            // Open the file to read from.
            using (StreamReader sr = File.OpenText(path))
            {
                string s = "";
                while ((s = sr.ReadLine()) != null)
                {
                    Console.WriteLine(s);
                }   
            }

            
            
            
            var startInfo = new ProcessStartInfo(@"C:\Program Files\Java\jdk1.8.0_301\bin\java.exe", "-jar java_CS.jar") // proper path to java, main java class, classpath, jvm parameters, etc must be specified or use java -jar jarName.jar if packaged into a single jar
            {
                RedirectStandardError = true,
                RedirectStandardOutput = true,
                UseShellExecute = false


           
            };

            var process = Process.Start(startInfo);

            process.WaitForExit();
            /*
            Console.WriteLine("Captured stderr from java process:");
            Console.WriteLine(process.StandardError.ReadToEnd());
            Console.WriteLine();
            Console.WriteLine("Captured stdout from java process");
            Console.WriteLine(process.StandardOutput.ReadToEnd());
       */
                      
            while (true) {
                Console.WriteLine("operation:" + (++counter));
                if (counter == 6)
                    break;
                Console.WriteLine(process.StandardOutput.ReadLine());
                //BekirTirpan = process.StandardOutput.ReadLine();
                //   Console.WriteLine(BekirTirpan);
                Thread.Sleep(100);
              
               
            }
            
            

                if (File.Exists(path))
                {
                    // Create a file to write to.
                    using (StreamWriter sw = File.CreateText(path))
                    {
                       
                        sw.WriteLine(process.StandardOutput.ReadLine()+" written by c#");

                    }
                }


                // Open the file to read from.
                using (StreamReader sr = File.OpenText(path))
                {
                Console.WriteLine("File is reading from c#");
                string s = "";
                    while ((s = sr.ReadLine()) != null)
                    {
                        Console.WriteLine(s);
                    }
                }
            Console.WriteLine("*******First operation finish*********");

            var startInfo2 = new ProcessStartInfo(@"C:\Program Files\Java\jdk1.8.0_301\bin\java.exe", "-jar java_CS.jar") // proper path to java, main java class, classpath, jvm parameters, etc must be specified or use java -jar jarName.jar if packaged into a single jar
            {
                RedirectStandardError = true,
                RedirectStandardOutput = true,
                UseShellExecute = false


            };
            var process2 = Process.Start(startInfo2);

            process2.WaitForExit();
            counter = 0;
            while (true)
            {
                Console.WriteLine("operation2:" + (++counter));
                if (counter == 2)
                    break;
                Console.WriteLine(process2.StandardOutput.ReadLine());

            }
                                     
            Console.WriteLine(process2.StandardOutput.ReadLine());
            Console.WriteLine(process2.StandardOutput.ReadLine());

        }
    }
}
