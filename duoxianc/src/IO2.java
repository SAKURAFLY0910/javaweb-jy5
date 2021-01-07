import java.io.*;

public class IO2 {
    public static void main(String[] args) throws Exception {
//        OutputStream s=new FileOutputStream("G:\\GT.txt",true);
//       String  v="世界";
//        byte[] bytes = v.getBytes("UTF-8");
//        s.write(bytes);
//        s.flush();
//        s.close();
//        InputStream s=new FileInputStream();
//        File sss= new File("G:\\GT.txt");

//xie
//        OutputStreamWriter ss=new OutputStreamWriter(new FileOutputStream("G:\\GT.txt"),"UTF-8");
////        FileWriter sss=new FileWriter("G:\\GT.txt");
//       ss.write("世界");
//       ss.flush();
//       ss.close();



        //du
         Reader s=new InputStreamReader(new FileInputStream("G:\\GT.txt"),"utf-8");
//         byte ss[]=new  byte[1024];

         int len=0;
         while ((len=s.read())!=-1){
             System.out.println((char)len);
         }
         s.close();



    }
}
