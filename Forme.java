import java.awt.*;

public class Forme
{
  private int nombre;
  private int x;
  private int y;
  private int hauteur;
  private int largeur;
  private boolean cocher;
  private boolean mine;
  private boolean drapeau;

  public Forme(int _nombre, int _x, int _y, int _hauteur , int _largeur)
  {
    nombre = _nombre;
    x=_x;
    y=_y;
    hauteur =_hauteur;
    largeur=_largeur;
    cocher = false;
    mine = false;
    drapeau = false;
  }

  public int getNombre(){return nombre;}
  public void setNombre(int n){nombre = n;}

  public int getX(){return x;}

  public int getY(){return y;}

  public int getHauteur(){return hauteur;}

  public int getLargeur(){return largeur;}

  public boolean getCocher(){return cocher;}
  public void setCocher(boolean c){cocher = c;}

  public boolean getMine(){return mine;}
  public void setMine(boolean m){mine = m;}

  public boolean getDrapeau(){return drapeau;}
  public void setDrapeau(boolean d){drapeau = d;}

  public void affichage()
  {
    System.out.println("Voici mon nombre : " + nombre + " mes coordonnées sont x = " + x + " et en y = "+ y);
  }


}
