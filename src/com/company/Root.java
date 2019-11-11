package com.company;

import javax.swing.*;
import java.awt.*;

public class Root extends JFrame {
    public Root() throws HeadlessException {
        setTitle("Rotation");
        setBounds(0,0,500,500);
        setLocationRelativeTo(null);

        positionMyComponent();

        setVisible(true);
    }
    public void positionMyComponent(){

        add(new MyGraph());
    }
}
