package ramgames.ramrender;

import ramgames.ramrender.listeners.KeyboardController;
import ramgames.ramrender.listeners.MouseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Screen extends JFrame implements Runnable{
    private final Canvas canvas;
    private boolean debug;
    private final List<Layer> layers = new ArrayList<>();
    private final HashMap<String, BufferedImage> imageAtlas = new HashMap<>();
    private boolean running = true;
    private final Dimension size;
    private final int updatesPerSecond;
    private final double updateRate;
    private Dimension screenSize;
    private Color background;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    public Screen(String name, Dimension size, Color backgroundColor, int UPS, boolean focusable, boolean resizable, KeyboardController keyboardController) {
        this.size = size;
        this.updatesPerSecond = UPS;
        this.updateRate = 1d/UPS;
        this.canvas = new Canvas();
        this.background = backgroundColor;
        if(debug) {
            print(PrintType.INFO, String.format("Initial Background Color - (%s,%s,%s)", this.background.getRed(), this.background.getGreen(), this.background.getBlue()));
        }
        this.screenSize = size;
        setTitle(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(resizable);
        canvas.setPreferredSize(size);
        canvas.setFocusable(focusable);
        add(canvas);
        addKeyListener(keyboardController);
        canvas.addMouseListener(new MouseController() {
            @Override
            public void mouseClicked(MouseEvent var1) {
                // TO-DO
            }

            @Override
            public void mouseReleased(MouseEvent var1) {
                // TO-DO
            }

            @Override
            public void mouseEntered(MouseEvent var1) {
                // TO-DO
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                // TO-DO
            }
        });
        pack();
        canvas.createBufferStrategy(3);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public synchronized Dimension getSize() {
        return this.size;
    }
    public synchronized Color getBackgroundColor() {
        return this.background;
    }
    public synchronized void setBackgroundColor(Color background) {
        this.background = background;
        if(debug){
            print(PrintType.INFO, String.format("setting background to (%s,%s,%s)", background.getRed(), background.getGreen(), background.getBlue()));
        }
    }
    public synchronized void AddImageToAtlas(String identifier, BufferedImage image) {
        this.imageAtlas.put(identifier,image);
    }
    public synchronized BufferedImage getImageFromAtlas(String identifier) {
        return this.imageAtlas.get(identifier);
    }

    public synchronized void addLayer(Layer layer) {
        layers.add(layer);
    }
    public synchronized Layer getLayer(int index) {
        return this.layers.get(index);
    }

    public void enableDebugMode() {
        print(PrintType.INFO,"Enabled Debug Mode");
        this.debug = true;
    }

    public synchronized int getUpdatesPerSecond() {
        return this.updatesPerSecond;
    }
    public synchronized void stopRunning() {
        this.running = false;
        if(debug) {
            print(PrintType.INFO,"stopping screen...");
        }

    }

    public synchronized Dimension getScreenSize() {
        return this.screenSize;
    }

    @Override
    public void run() {

        double accumulator = 0;
        long currentTime, lastUpdate  = System.currentTimeMillis();
        while(this.running) {
            //print(ramgames.ramrender.PrintType.INFO,"running");
            currentTime = System.currentTimeMillis();
            double lastRenderInSeconds = (currentTime-lastUpdate) /1000d;
            accumulator += lastRenderInSeconds;
            lastUpdate = currentTime;
            if(accumulator > updateRate) {
                render();
            }
            while(accumulator > updateRate) {
                update();
                accumulator -= updateRate;
            }
        }
        if(debug) {
            print(PrintType.INFO, "instance of screen has ended, terminating thread...");
        }
        dispose();
    }
    public void render() {
        this.canvas.setBackground(this.background);
        this.screenSize = canvas.getSize();
        BufferStrategy strategy = canvas.getBufferStrategy();
        Graphics graphics = strategy.getDrawGraphics();
        graphics.setColor(this.canvas.getBackground());
        graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        layers.forEach(layer -> {
            if (layer.visible) {
                layer.render(this.screenSize, graphics);
            }
        });
        graphics.dispose();
        strategy.show();

    }
    public void update() {
        for(Layer layer: layers) {
            layer.update();
        }
    }
    public void print(PrintType type, String message) {
            System.out.printf("%s{%s} [%s] RamRender - %s\n",type.getCode(),type.getName(),formatter.format(new Date()),message);

    }
}
