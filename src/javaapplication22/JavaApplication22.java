/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

/**
 *
 * @author Gabriel
 */
public class JavaApplication22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Query q1 = new Query("consult",new Term[]{new Atom("test.pl")});
        System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
        // TODO code application logic here
        Query q2 = new Query("room",new Term[]{new Atom("bedroom")});
        System.out.println( "Result: " + (q2.hasSolution() ? "True" : "False"));
        
        Variable X = new Variable("X");
        Query q3 = new Query("room",new Term[]{X});
        Map<String,Term> solution;
        //solution = q3.allSolutions();
        //System.out.println( "Result: "+ solution[1].get("X"));
        while(q3.hasMoreSolutions()){
            solution = q3.nextSolution();
            System.out.println( "Result: "+ solution.get("X"));
        }
        */
        Query q1 = new Query("consult",new Term[]{new Atom("Red7.pl")});
        System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
        Variable X = new Variable("X");
        Variable A = new Variable("A");
        Variable B = new Variable("B");
        Query q2 = new Query("deal",new Term[]{X,A,B});
        Map<String,Term>solution;
        solution = q2.oneSolution();
        
        Term termA = solution.get("A");
        ArrayList<Carta> manoA = new ArrayList<>();
        ArrayList<Carta> manoB = new ArrayList<>();
        for(Term one : termA.toTermArray()){   
            Carta carta = new Carta(one.arg(2).toString(),one.arg(1).toString());
            manoA.add(carta);
            //System.out.println(one.arg(2));
            //System.out.println(one.arg(1));
        }
        System.out.println("ManoA");
        for(Carta c : manoA){
            System.out.println(c.getColor());
            System.out.println(c.getNumero());
        }
        
         System.out.println("ManoB");
        Term termB = solution.get("B");
        for(Term one : termB.toTermArray()){   
            Carta carta = new Carta(one.arg(2).toString(),one.arg(1).toString());
            manoB.add(carta);
            //System.out.println(one.arg(2));
            //System.out.println(one.arg(1));
        }
        for(Carta c : manoB){
            System.out.println(c.getColor());
            System.out.println(c.getNumero());
        }
        solution = q2.oneSolution();
        Term termActive = solution.get("A");
        Carta palleteA = new Carta(termActive.toTermArray()[0].arg(2).toString(),termActive.toTermArray()[0].arg(1).toString());
        Term termActiveB = solution.get("B");
        Carta palleteB = new Carta(termActiveB.toTermArray()[0].arg(2).toString(),termActiveB.toTermArray()[0].arg(1).toString());
        /*
        while(q2.hasMoreSolutions()){
            solution = q2.nextSolution();
            solution.get("A");
        }
        */
        new Tablero(manoA,manoB,palleteA,palleteB).setVisible(true);
       
    }
    
}
