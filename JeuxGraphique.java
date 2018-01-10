import javax.swing.*;
import java.awt.*;
import java.io.*;

public class JeuxGraphique extends JFrame implements Serializable
{

  static final long serialVersionUID = 43L;
  private ZoneJeux zonejeux;

  public JeuxGraphique()
  {
    super("Fenetre");
    setSize(400,400);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
    //setAlwaysOnTop(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    zonejeux = new ZoneJeux(400,400,40,40,5);
    setContentPane(zonejeux);
    setBackground(Color.WHITE);

    pack();

  }

}
