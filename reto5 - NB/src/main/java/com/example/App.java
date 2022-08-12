package com.example;

import com.example.view.FrmRequerimientos;
import com.example.view.FrmMenu;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        //new FrmRequerimientos().setVisible(true);
        
        new FrmMenu().setVisible(true);
        
        //RequerimientoView vista = new RequerimientoView();
        //vista.setVisible(true);
    }
}
