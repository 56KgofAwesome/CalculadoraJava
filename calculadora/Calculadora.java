package calculadora;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculadora extends JFrame implements MouseListener{        
    
    //Elementos Interfaz
    public JTextField textField = new JTextField(30);
    public JButton btn1 = new JButton("1");  
    public JButton btn2 = new JButton("2");  
    public JButton btn3 = new JButton("3");  
    public JButton btn4 = new JButton("4");  
    public JButton btn5 = new JButton("5"); 
    public JButton btn6 = new JButton("6"); 
    public JButton btn7 = new JButton("7");
    public JButton btn8 = new JButton("8");  
    public JButton btn9 = new JButton("9");  
    public JButton btn0 = new JButton("0");  
    public JButton btnMas = new JButton("+"); 
    public JButton btnMenos = new JButton("-");  
    public JButton btnDiv = new JButton("/");  
    public JButton btnMult = new JButton("*"); 
    public JButton btnClr = new JButton("C");               
    public JButton btnResult = new JButton("=");  
    //Variables 
    public int frstNum;
    public String frstNumS = "";
    public int scndNum;
    public String scndNumS = "";
    public int result;
    public String operacion = "";
    public boolean frstNumDone = false;
    
    public Calculadora(){
        
        //Interfaz
        setTitle("Calculadora");
        setSize(400,455);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
                
        JPanel row2 = new JPanel(new GridLayout(4,4,5,5));
        Dimension wh = new Dimension(80,80);
        //Liteners de Botones                
        btn1.setPreferredSize(wh); btn1.addMouseListener(this);
        btn2.setPreferredSize(wh); btn2.addMouseListener(this);
        btn3.setPreferredSize(wh); btn3.addMouseListener(this);
        btn4.setPreferredSize(wh); btn4.addMouseListener(this);
        btn5.setPreferredSize(wh); btn5.addMouseListener(this);
        btn6.setPreferredSize(wh); btn6.addMouseListener(this);
        btn7.setPreferredSize(wh); btn7.addMouseListener(this);
        btn8.setPreferredSize(wh); btn8.addMouseListener(this);
        btn9.setPreferredSize(wh); btn9.addMouseListener(this);
        btn0.setPreferredSize(wh); btn0.addMouseListener(this);
        btnMas.setPreferredSize(wh); btnMas.addMouseListener(this);
        btnMenos.setPreferredSize(wh); btnMenos.addMouseListener(this);
        btnDiv.setPreferredSize(wh); btnDiv.addMouseListener(this);
        btnMult.setPreferredSize(wh); btnMult.addMouseListener(this);
        btnClr.setPreferredSize(wh); btnClr.addMouseListener(this);
        btnResult.setPreferredSize(wh); btnResult.addMouseListener(this);   
        textField.setPreferredSize(new Dimension(30,50));
                
        row2.add(btn1);
        row2.add(btn2);
        row2.add(btn3);
        row2.add(btnMas);
        row2.add(btn4);
        row2.add(btn5);
        row2.add(btn6);
        row2.add(btnMenos);
        row2.add(btn7);
        row2.add(btn8);
        row2.add(btn9);
        row2.add(btnMult);
        row2.add(btnClr);
        row2.add(btn0);
        row2.add(btnResult);
        row2.add(btnDiv);
                
        getContentPane().add(textField);        
        getContentPane().add(row2);                
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

      
    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj  = e.getSource();
        JButton btn = null;
        btn = (JButton)obj;
        
       if(btn.getText() == "C"){
           clearFields();           
       }
       
       if(btn.getText() == "1" || btn.getText() == "2" || btn.getText() == "3" || btn.getText() == "4" || btn.getText() == "5" || btn.getText() == "6" || btn.getText() == "7" || btn.getText() == "8" || btn.getText() == "9" || btn.getText() == "0"){
           
           if(!frstNumDone){
               asignarPrimerNumero(btn.getText());
           }else{
               asignarSegundoNumero(btn.getText());           
           }                     
       }
       
       if(btn.getText() == "+" || btn.getText() == "-" || btn.getText() == "*" || btn.getText() == "/"){
           frstNumDone = true;
           operacion = btn.getText();
           textField.setText(operacion);
       }
       
       if(btn.getText() == "="){
           mostrarResultado(operacion);           
           frstNumDone = false;
            frstNum = 0;
            frstNumS = "";
            scndNum = 0;
            scndNumS = "";
            result = 0;
       }
        
    }
    //Mostrar Resultado
    public void mostrarResultado(String operacion){
        if(operacion == "+"){
            result = frstNum + scndNum;           
            textField.setText(String.valueOf(result));                      
        }
        if(operacion == "-"){
            result = frstNum - scndNum;           
            textField.setText(String.valueOf(result));                     
        }
        if(operacion == "*"){
            result = frstNum * scndNum;           
            textField.setText(String.valueOf(result));                   
        }
        if(operacion == "/"){
            if(scndNum == 0){
                textField.setText("Error de división entre cero.");                
            }else{
                result = frstNum / scndNum;           
                textField.setText(String.valueOf(result));                
            }                       
        }
    }
    //Asignar Primer Numero
    public void asignarPrimerNumero(String numeroS){
        frstNumS = frstNumS.concat(numeroS);
        textField.setText(frstNumS);        
        frstNum = Integer.parseInt(frstNumS);                       
    }
    //Asignar Segundo Numero
    public void asignarSegundoNumero(String numeroS){
        scndNumS = scndNumS.concat(numeroS);
        textField.setText(scndNumS);        
        scndNum = Integer.parseInt(scndNumS);                
    }
    //Limpia Calculadora
    public void clearFields(){
        frstNumDone = false;
        frstNum = 0;
        frstNumS = "";
        scndNum = 0;
        scndNumS = "";
        result = 0;
        textField.setText("");
    }            

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
    
    public static void main(String[] args) {
                
        Calculadora c = new Calculadora();                       
        // TODO code application logic here
    }
    
    
}
