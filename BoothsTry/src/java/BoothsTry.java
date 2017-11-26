/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author laxmi
 */
@WebServlet(urlPatterns = {"/BoothsTry"})
public class BoothsTry extends HttpServlet {
    
    public int multiply(int n1, int n2, PrintWriter writer) {
        int q=0,i,j,a,b,temp,x=0,y,c=0;
        int[] A= {0,0,0,0,0,0,0,0},C={0,0,0,0,0,0,0,1},C1={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int[] M= new int[8];
        int[] Q= new int[8];
        int[] temp1= new int[8];
        int[] ans= new int[16];
        int s=0,z=0;
        a=n1;
        b=n2;
        binary(a,M,writer);
        binary(b,Q,writer);
        writer.println("<br><br>----------<br>");
        writer.println("Operations &nbsp&nbsp&nbsp A"
                + "&nbsp&nbsp&nbsp&nbsp&nbsp Q"
                + "&nbsp&nbsp&nbsp&nbsp&nbsp Q'"
                + "&nbsp&nbsp&nbsp&nbsp&nbsp M");
        writer.println("<br><br>INITIAL &nbsp&nbsp&nbsp");
        for (i=0;i<8;i++){
            writer.println(A[i]);
        }
        writer.println("&nbsp");
        for (i=0;i<8;i++){
            writer.println(Q[i]);
        }
        writer.println("&nbsp");
        writer.println(q+"&nbsp");
        for (i=0;i<8;i++){
            writer.println(M[i]);
        }
        writer.println("&nbsp");
        
        for (j=0;j<8;j++){
            
            if ((Q[7]==0) && (q==1)){
                //A=A+M
                writer.println("<br><br>A=A+M &nbsp&nbsp&nbsp");
                add(A,M);
                for (i=0;i<8;i++){
                    writer.println(A[i]);
                }
                writer.println("&nbsp");
                for (i=0;i<8;i++){
                    writer.println(Q[i]);
                }
                writer.println("&nbsp");
                writer.println(q+"&nbsp");
                for (i=0;i<8;i++){
                    writer.println(M[i]);
                }
                writer.println("&nbsp");
        
                
            }
            if ((Q[7]==1) && (q==0)){
                //A=A-M
                writer.println("<br><br>A=A-M&nbsp&nbsp&nbsp");
                for (i=0;i<8;i++){
                    temp1[i] = 1-M[i];
                }add(temp1,C);
                add(A,temp1);
                for (i=0;i<8;i++){
                    writer.println(A[i]);
                }
                writer.println("&nbsp");
                for (i=0;i<8;i++){
                    writer.println(Q[i]);
                }
                writer.println("&nbsp");
                writer.println(q+"&nbsp");
                for (i=0;i<8;i++){
                    writer.println(M[i]);
                }
                writer.println("&nbsp");
        
                
            }
            
          writer.println("<br><br>SHIFT&nbsp&nbsp&nbsp");
          y=A[7];
          q=Q[7];
          rshift(A[0],A);
          rshift(y,Q);
          for (i=0;i<8;i++){
                    writer.println(A[i]);
                }
                writer.println("&nbsp");
                for (i=0;i<8;i++){
                    writer.println(Q[i]);
                }
                writer.println("&nbsp");
                writer.println(q+"&nbsp");
                for (i=0;i<8;i++){
                    writer.println(M[i]);
                }
                writer.println("&nbsp");
          
        }
        writer.println("<br><br>The answer in Binary:");
        for (i=0;i<8;i++){
            ans[i] = A[i];
        }
        for (i=0;i<8;i++){
            ans[i+8] = Q[i];
        }
        for (i=0;i<16;i++){
            writer.println(ans[i]);
        }
        
        if (((a<0)&&(b>0)) || ((a>0)&&(b<0))){
            for (i=0;i<16;i++){
                ans[i] = 1-ans[i];
            }
            for (i=15;i>=0;i--){
                x=ans[i];
                ans[i] = x^c^C1[i];
                if (((x==1)&&(c==1)) ||((c==1)&&(C1[i]==1)) || ((C1[i]==1)&&(x==1)) ){
                    c=1;
                }
                else{
                    c=0;
                }
            }
        }
        
        for (i=15;i>0;i--){
            s=s+((int)Math.pow(2, z)*ans[i]);
            z=z+1;
        }
        if (((a<0)&&(b>0)) || ((a>0)&&(b<0))){
            s=s*-1;
        }
        return s;
        
    }
    
    
    public void binary(int x, int[] arr, PrintWriter writer) {
        int i,p=x;
        int[] c={0,0,0,0,0,0,0,1};
        for (i=0;i<8;i++){
            arr[i] = 0;
        }
        
        if (x<0){
            x=x*-1;
        }
        i=7;
        do{
            arr[i] = x%2;
            x=x/2;
            i--;
        }while(x != 0);
        if (p<0){
            for (i=0;i<8;i++){
                arr[i] = 1-arr[i];
            }
            add(arr,c);
        }
        writer.println("<br><br>Answer in binary:");
        for (i=0;i<8;i++){
            writer.println(arr[i]);
        }
    }

    public void add(int[] a, int[] b) {
        int i;
        int c = 0;
            for (i=7;i>=0;i--){
            int x = a[i];
                a[i] = x^c^b[i];
                if (((x==1)&&(c==1)) ||((c==1)&&(b[i]==1)) || ((b[i]==1)&&(x==1)) ){
                    c=1;
                }
                else{
                    c=0;
                }
            }
    }

    public static void rshift(int x, int[] y) {
        int i;
        for (i=7;i>0;i--){
            y[i] = y[i-1];
        }
        y[0] = x;
    }
    
    public void display(int[] P,char ch,PrintWriter writer){
        for (int i=0;i<P.length;i++){
            if (i==4){
                writer.println("&nbsp &nbsp");
            }
            if (i==8){
                writer.println("&nbsp &nbsp");
            }
            writer.println(P[i]);
        }
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BoothsTry</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BoothsTry at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    public void init(ServletConfig config){
        System.out.println("Servlet initialized");  
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       String Mp = request.getParameter("multiplicand");
       int multiplicand = Integer.parseInt(Mp);
        String Mr = request.getParameter("multiplier");
       int multiplier = Integer.parseInt(Mr);
       PrintWriter writer = response.getWriter();
       BoothsTry bT = new BoothsTry();
       int result = bT.multiply(multiplicand,multiplier,writer);
       writer.println("<br><br>Product is:"+result);
    }
public void destroy(){
        System.out.println("Servlet destroyed");  
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

    

}
