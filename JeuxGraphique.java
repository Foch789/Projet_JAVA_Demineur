import javax.swing.*;
import java.awt.*;

public class JeuxGraphique extends JFrame
{

  private ZoneJeux zonejeux;

  public JeuxGraphique()
  {
    super("Fenetre");
    setSize(410,410);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
    //setAlwaysOnTop(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    zonejeux = new ZoneJeux(400,400,40,40,10);
    setContentPane(zonejeux);
    setBackground(Color.WHITE);

    pack();

  }

}
