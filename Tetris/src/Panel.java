import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Panel extends JPanel implements ActionListener
{
    private int score;
    private int gg = 0;
    private int multi = 0;
    private int preRandom;
    private int randomise;
    private int rotate = 0;
    private double speed = 1;
    private int[] y = new int[2];
    private int[] x = new int[2];
    private int positionVertical = -3;
    private int positionHorizontal = 3;
    private int[] True = new int[] {1,1,0};
    private Timer delay = new Timer(1000, this);
    private double[][] area = new double[Start.HEIGHT][Start.WIDTH];
    private Image one = Toolkit.getDefaultToolkit().createImage(getClass().getResource("1.png"));
    private Image two = Toolkit.getDefaultToolkit().createImage(getClass().getResource("2.png"));
    private Image three = Toolkit.getDefaultToolkit().createImage(getClass().getResource("3.png"));
    private Image four = Toolkit.getDefaultToolkit().createImage(getClass().getResource("4.png"));
    private Image five = Toolkit.getDefaultToolkit().createImage(getClass().getResource("5.png"));
    private Image six = Toolkit.getDefaultToolkit().createImage(getClass().getResource("6.png"));
    private Image seven = Toolkit.getDefaultToolkit().createImage(getClass().getResource("7.png"));
    private byte[][][][] figures = new byte[][][][] {
             {{{0,0,1,0},{0,0,1,0},{0,0,1,0},{0,0,1,0}}
             ,{
                     {0,0,0,0},
                     {0,1,1,0},
                     {0,1,1,0},
                     {0,0,0,0}}
             ,{{0,0,0,0},{0,0,1,0},{0,0,1,0},{0,0,1,1}}
             ,{{0,0,0,0},{0,0,1,0},{0,0,1,0},{0,1,1,0}}
             ,{{0,0,0,0},{0,1,1,0},{0,0,1,1},{0,0,0,0}}
             ,{{0,0,0,0},{0,0,1,1},{0,1,1,0},{0,0,0,0}}
             ,{{0,0,0,0},{0,0,1,0},{0,1,1,1},{0,0,0,0}}
             },
             {{{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}}
             ,{{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}}
             ,{{0,0,0,0},{0,0,0,0},{0,1,1,1},{0,1,0,0}}
             ,{{0,0,0,0},{0,1,0,0},{0,1,1,1},{0,0,0,0}}
             ,{{0,0,0,0},{0,0,0,1},{0,0,1,1},{0,0,1,0}}
             ,{{0,0,0,0},{0,0,1,0},{0,0,1,1},{0,0,0,1}}
             ,{{0,0,0,0},{0,0,1,0},{0,0,1,1},{0,0,1,0}}
             },
             {{{0,0,1,0},{0,0,1,0},{0,0,1,0},{0,0,1,0}}
             ,{{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}}
             ,{{0,0,0,0},{0,1,1,0},{0,0,1,0},{0,0,1,0}}
             ,{{0,0,0,0},{0,0,1,1},{0,0,1,0},{0,0,1,0}}
             ,{{0,0,0,0},{0,1,1,0},{0,0,1,1},{0,0,0,0}}
             ,{{0,0,0,0},{0,0,1,1},{0,1,1,0},{0,0,0,0}}
             ,{{0,0,0,0},{0,0,0,0},{0,1,1,1},{0,0,1,0}}
             },
             {{{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}}
             ,{{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}}
             ,{{0,0,0,0},{0,0,0,1},{0,1,1,1},{0,0,0,0}}
             ,{{0,0,0,0},{0,0,0,0},{0,1,1,1},{0,0,0,1}}
             ,{{0,0,0,0},{0,0,0,1},{0,0,1,1},{0,0,1,0}}
             ,{{0,0,0,0},{0,0,1,0},{0,0,1,1},{0,0,0,1}}
             ,{{0,0,0,0},{0,0,1,0},{0,1,1,0},{0,0,1,0}}}};
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Start.WIDTH*Start.SCALE+(Start.SCALE*4),Start.HEIGHT*Start.SCALE);
        g.setColor(Color.DARK_GRAY);
        g.drawLine(Start.SCALE*Start.WIDTH,0,Start.SCALE*Start.WIDTH,Start.SCALE*Start.HEIGHT);
        switch (preRandom) {
            case 0:
                g.drawImage(one,(Start.SCALE*Start.WIDTH)+((Start.SCALE*4)/6)-6,10,null);
                break;
            case 1:
                g.drawImage(two,(Start.SCALE*Start.WIDTH)+(((Start.SCALE*4)/8)*3)-6,10,null);
                break;
            case 2:
                g.drawImage(three,(Start.SCALE*Start.WIDTH)+(((Start.SCALE*4)/7)*2)-6,10,null);
                break;
            case 3:
                g.drawImage(four,(Start.SCALE*Start.WIDTH)+(((Start.SCALE*4)/7)*2)-6,10,null);
                break;
            case 4:
                g.drawImage(five,(Start.SCALE*Start.WIDTH)+(((Start.SCALE*4)/7)*2)-6,10,null);
                break;
            case 5:
                g.drawImage(six,(Start.SCALE*Start.WIDTH)+(((Start.SCALE*4)/7)*2)-6,10,null);
                break;
            case 6:
                g.drawImage(seven,(Start.SCALE*Start.WIDTH)+(((Start.SCALE*4)/7)*2)-6,10,null);
                break;
        }
        for (int i = 0; i < 20; i++) {
            int z = 0;
            for (int j = 0; j < 11; j++) {
                if (area[i][j] != 0) {
                    z ++;
                }
                if (i == 0 & z > 0) {
                    for (int and = 0; and < 20; and++) {
                        for (int game = 0; game < 11; game++) {
                            area[and][game] = 0;
                            gg = 1;
                        }
                    }
                }
                if (z == 11) {
                    for (int x = 0; x < 11; x++) {
                        area[i][x] = 0;
                    }
                    switch (multi) {
                        case 0:
                            score += 100;
                            multi++;
                            break;
                        case 1:
                            score += 300;
                            multi++;
                            break;
                        case 2:
                            score += 500;
                            break;
                        case 3:
                            score += 700;
                            break;
                    }
                    for (int h = i; h >= 1; h--) {
                        System.arraycopy(area[h - 1], 0, area[h], 0, 11);
                    }
                }
            }
        }
        for (y[0] = 0; y[0] < 4; y[0]++) {
            for (x[0] = 0; x[0] < 4; x[0]++) {
                switch (randomise) {
                    case 0: g.setColor(Color.CYAN);
                        break;
                    case 1: g.setColor(Color.YELLOW);
                        break;
                    case 2: g.setColor(Color.ORANGE);
                        break;
                    case 3: g.setColor(Color.BLUE);
                        break;
                    case 4: g.setColor(Color.RED);
                        break;
                    case 5: g.setColor(Color.GREEN);
                        break;
                    case 6: g.setColor(Color.MAGENTA);
                        break;
                }
                if (figures[rotate][randomise][y[0]][x[0]] == 1) {
                    g.fillRect((((figures[rotate][randomise][y[0]][x[0]] * x[0])+ positionHorizontal) * Start.SCALE)+1, ((y[0]+positionVertical) * Start.SCALE)+1, Start.SCALE-1, Start.SCALE-1);
                    if (((((figures[rotate][randomise][y[0]][x[0]] * x[0])+ positionHorizontal) * Start.SCALE)+1 > Start.SCALE*Start.WIDTH) || ((y[0]+positionVertical)*Start.SCALE > 0) && True[0] == 0 && ((y[0]+positionVertical)*Start.SCALE == ((int) area[y[0]+positionVertical][x[0]+positionHorizontal])*(y[0]+positionVertical)*Start.SCALE)) {
                        positionHorizontal--;
                        repaint();
                    } else if (((((figures[rotate][randomise][y[0]][x[0]] * x[0])+ positionHorizontal) * Start.SCALE)+1 < 0) || ((y[0]+positionVertical)*Start.SCALE > 0) && True[1] == 0 && ((y[0]+positionVertical)*Start.SCALE == ((int) area[y[0]+positionVertical][x[0]+positionHorizontal])*(y[0]+positionVertical)*Start.SCALE)) {
                        positionHorizontal++;
                        repaint();
                    }
                    if (((y[0]+positionVertical)*Start.SCALE > (Start.SCALE*Start.HEIGHT)-Start.SCALE) || ((y[0]+positionVertical)*Start.SCALE > 0) && True[0] == 1 && True[1] == 1 && ((y[0]+positionVertical)*Start.SCALE == ((int) area[y[0]+positionVertical][x[0]+positionHorizontal])*(y[0]+positionVertical)*Start.SCALE)) {
                        True[2] = 0;
                        switch (randomise) {
                            case 0:
                                if (rotate == 0 | rotate == 2) {
                                    area[positionVertical - 1][positionHorizontal + 2] = 1;
                                    area[positionVertical][positionHorizontal + 2] = 1;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1;
                                    area[positionVertical + 2][positionHorizontal + 2] = 1;
                                } else if (rotate == 1 | rotate == 3) {
                                    area[positionVertical][positionHorizontal] = 1;
                                    area[positionVertical][positionHorizontal + 1] = 1;
                                    area[positionVertical][positionHorizontal + 2] = 1;
                                    area[positionVertical][positionHorizontal + 3] = 1;
                                }
                                break;
                            case 1:
                                area[positionVertical][positionHorizontal + 1] = 1.1;
                                area[positionVertical][positionHorizontal + 2] = 1.1;
                                area[positionVertical + 1][positionHorizontal + 1] = 1.1;
                                area[positionVertical + 1][positionHorizontal + 2] = 1.1;
                                break;
                            case 2:
                                if (rotate == 0) {
                                    area[positionVertical][positionHorizontal + 2] = 1.2;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.2;
                                    area[positionVertical + 2][positionHorizontal + 2] = 1.2;
                                    area[positionVertical + 2][positionHorizontal + 3] = 1.2;
                                } else if (rotate == 1) {
                                    area[positionVertical + 2][positionHorizontal + 1] = 1.2;
                                    area[positionVertical + 1][positionHorizontal + 1] = 1.2;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.2;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.2;
                                } else if (rotate == 2) {
                                    area[positionVertical][positionHorizontal + 2] = 1.2;
                                    area[positionVertical][positionHorizontal + 1] = 1.2;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.2;
                                    area[positionVertical + 2][positionHorizontal + 2] = 1.2;
                                } else {
                                    area[positionVertical][positionHorizontal + 3] = 1.2;
                                    area[positionVertical + 1][positionHorizontal + 1] = 1.2;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.2;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.2;
                                }
                                break;
                            case 3:
                                if (rotate == 0) {
                                    area[positionVertical][positionHorizontal + 2] = 1.3;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.3;
                                    area[positionVertical + 2][positionHorizontal + 1] = 1.3;
                                    area[positionVertical + 2][positionHorizontal + 2] = 1.3;
                                } else if (rotate == 1) {
                                    area[positionVertical][positionHorizontal + 1] = 1.3;
                                    area[positionVertical + 1][positionHorizontal + 1] = 1.3;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.3;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.3;
                                } else if (rotate == 2) {
                                    area[positionVertical][positionHorizontal + 2] = 1.3;
                                    area[positionVertical][positionHorizontal + 3] = 1.3;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.3;
                                    area[positionVertical + 2][positionHorizontal + 2] = 1.3;
                                } else {
                                    area[positionVertical + 1][positionHorizontal + 1] = 1.3;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.3;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.3;
                                    area[positionVertical + 2][positionHorizontal + 3] = 1.3;
                                }
                                break;
                            case 4:
                                if (rotate == 0 | rotate == 2) {
                                    area[positionVertical][positionHorizontal + 1] = 1.4;
                                    area[positionVertical][positionHorizontal + 2] = 1.4;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.4;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.4;
                                } else if (rotate == 1 | rotate == 3) {
                                    area[positionVertical][positionHorizontal + 3] = 1.4;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.4;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.4;
                                    area[positionVertical + 2][positionHorizontal + 2] = 1.4;
                                }
                                break;
                            case 5:
                                if (rotate == 0 | rotate == 2) {
                                    area[positionVertical][positionHorizontal + 2] = 1.5;
                                    area[positionVertical][positionHorizontal + 3] = 1.5;
                                    area[positionVertical + 1][positionHorizontal + 1] = 1.5;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.5;
                                } else if (rotate == 1 | rotate == 3) {
                                    area[positionVertical][positionHorizontal + 2] = 1.5;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.5;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.5;
                                    area[positionVertical + 2][positionHorizontal + 3] = 1.5;
                                }
                                break;
                            case 6:
                                if (rotate == 0) {
                                    area[positionVertical][positionHorizontal + 2] = 1.6;
                                    area[positionVertical + 1][positionHorizontal + 1] = 1.6;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.6;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.6;
                                } else if (rotate == 1) {
                                    area[positionVertical][positionHorizontal + 2] = 1.6;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.6;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.6;
                                    area[positionVertical + 2][positionHorizontal + 2] = 1.6;
                                } else if (rotate == 2) {
                                    area[positionVertical + 1][positionHorizontal + 1] = 1.6;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.6;
                                    area[positionVertical + 1][positionHorizontal + 3] = 1.6;
                                    area[positionVertical + 2][positionHorizontal + 2] = 1.6;
                                } else {
                                    area[positionVertical][positionHorizontal + 2] = 1.6;
                                    area[positionVertical + 1][positionHorizontal + 1] = 1.6;
                                    area[positionVertical + 1][positionHorizontal + 2] = 1.6;
                                    area[positionVertical + 2][positionHorizontal + 2] = 1.6;
                                }
                                break;
                        }
                        randomise = preRandom;
                        preRandom = (int) Math.floor(Math.random()*7);
                        positionHorizontal = 3;
                        positionVertical = -3;
                        repaint();
                    }
                }
            }
        }
        multi = 0;
        for (y[1] = 0; y[1] < 20; y[1]++) {
            for (x[1] =0; x[1] < 11; x[1]++) {
                if (area[y[1]][x[1]] != 0) {
                    if (area[y[1]][x[1]] == 1) g.setColor(Color.CYAN);
                    else if (area[y[1]][x[1]] == 1.1) g.setColor(Color.YELLOW);
                    else if (area[y[1]][x[1]] == 1.2) g.setColor(Color.ORANGE);
                    else if (area[y[1]][x[1]] == 1.3) g.setColor(Color.BLUE);
                    else if (area[y[1]][x[1]] == 1.4) g.setColor(Color.RED);
                    else if (area[y[1]][x[1]] == 1.5) g.setColor(Color.GREEN);
                    else g.setColor(Color.MAGENTA);
                    g.fillRect(((int) area[y[1]][x[1]]*x[1]*Start.SCALE)+1,((int) area[y[1]][x[1]]*y[1]*Start.SCALE)+1,Start.SCALE-1,Start.SCALE-1);
                }
            }
        }
        if (True[2] == 1) {
            if (gg == 0) {
                positionVertical++;
            }
            True[0] = 1;
            True[1] = 1;
            repaint();
        }
        if (preRandom == randomise) {
            preRandom = (int) Math.floor(Math.random()*7);
        }
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score,Start.SCALE*Start.WIDTH+10,89);
    }
    Panel() {
        JOptionPane.showMessageDialog(null,"Нажмите 'Enter', чтобы начать.");
        for (int y = 0; y < Start.HEIGHT; y++) {
            for (int x = 0; x < Start.WIDTH; x++) {
                area[y][x] = 0;
            }
        }
        randomise = (int) Math.floor(Math.random()*7);
        preRandom = (int) Math.floor(Math.random()*7);
        delay.start();

        KeyListener l = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_NUMPAD0 || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    True[2] = 1;
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    positionHorizontal++;
                    True[0] = 0;
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    positionHorizontal--;
                    True[1] = 0;
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (gg == 0) {
                        positionVertical++;
                    }
                    True[0] = 1;
                    True[1] = 1;
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (rotate != 3) {
                        rotate ++;
                    } else rotate = 0;
                    repaint();
                }
            }
        };
        addKeyListener(l);
        setFocusable(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (gg == 1) {
            delay.stop();
            JOptionPane.showMessageDialog(null,score);
            gg = 0;
            score = 0;
            speed = 1;
            delay.start();
        }
        if (True[2] == 0) {
            positionVertical++;
            True[0] = 1;
            True[1] = 1;
            speed += 0.001;
            delay.setDelay((int) (1000 / speed));
            repaint();
        }
    }
}
