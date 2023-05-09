import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Program {


            public static void main(String[] args) throws IOException {

                JPanel panel = new JPanel();

                BufferedImage image = ImageIO.read(new File("may.jpg"));
                JLabel label = new JLabel(new ImageIcon(image));

                panel.add(label);

                JFrame.setDefaultLookAndFeelDecorated(true);
                JFrame frame = new JFrame("JPanel Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension picSize = label.getPreferredSize();
                int frameX = 800, frameY = 800;

                frame.setSize(frameX, frameY);

                java.util.Timer timer = new Timer();
                TimerTask tTask = new TimerTask() {
                    int x = label.getX(), y = label.getY();
                    @Override
                    public void run() {
                        x += 100;
                        y += 100;
                        if (x > frameX) {
                            x = 0;
                        }
                        if (y > frameY) {
                            y = 0;
                        }


                        label.setBounds(x, y, picSize.width, picSize.height);
                    }
                };


                frame.add(panel);

                panel.setLayout(null);
                label.setBounds(0, 0, picSize.width,picSize.height);

                timer.schedule(tTask, 1000, 1000);

                frame.setVisible(true);

                System.out.println(label.getX());




            }




        }

