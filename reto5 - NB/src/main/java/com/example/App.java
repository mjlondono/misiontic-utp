package com.example;

import com.example.view.FrmMenu;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        new FrmMenu().setVisible(true);
        
    }
}
