package ramgames.ramrender;

import ramgames.ramrender.listeners.KeyboardController;
import ramgames.ramrender.listeners.MouseController;
import ramgames.ramrender.listeners.MouseEvents;
import ramgames.ramrender.objects.constructors.BoundingBox;
import ramgames.ramrender.objects.constructors.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.*;

public class Screen extends JFrame implements Runnable {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    private final Canvas canvas;
    private final LinkedHashMap<UUID, Layer> layers = new LinkedHashMap<>();
    private final HashMap<String, BufferedImage> imageAtlas = new HashMap<>();
    private final Dimension size;
    private final int updatesPerSecond;
    private final double updateRate;
    private boolean debug;
    private boolean running = true;
    private Dimension screenSize;
    private Color background;

    public Screen(String name, Dimension size, Color backgroundColor, int UPS, boolean focusable, boolean resizable, KeyboardController keyboardController) {
        this.size = size;
        this.updatesPerSecond = UPS;
        this.updateRate = 1d / UPS;
        this.canvas = new Canvas();
        this.background = backgroundColor;
        if (debug) {
            print(PrintType.INFO, String.format("Initial Background Color - (%s,%s,%s)", this.background.getRed(), this.background.getGreen(), this.background.getBlue()));
        }
        this.screenSize = size;
        setTitle(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(resizable);
        canvas.setPreferredSize(size);
        canvas.setFocusable(focusable);
        add(canvas);
        canvas.addKeyListener(keyboardController);
        addKeyListener(keyboardController);
        canvas.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mouseEvent) {
                Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
                for (Layer layer : layersAt(position)) {
                    layer.captureMouseEvent(MouseEvents.WHEEL, mouseEvent, position);
                }
            }
        });
        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
                for (Layer layer : layersAt(position)) {
                    layer.captureMouseEvent(MouseEvents.DRAG, mouseEvent, position);
                }
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
                for (Layer layer : layersAt(position)) {
                    layer.captureMouseEvent(MouseEvents.MOVE, mouseEvent, position);
                }
            }
        });
        canvas.addMouseListener(new MouseController() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
                for (Layer layer : layersAt(position)) {
                    layer.captureMouseEvent(MouseEvents.CLICK, mouseEvent, position);
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                print(PrintType.ERROR, "RE");
                Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
                for (Layer layer : layersAt(position)) {
                    layer.captureMouseEvent(MouseEvents.RELEASE, mouseEvent, position);
                    print(PrintType.INFO, "releasing layer");
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
                for (Layer layer : layersAt(position)) {
                    layer.captureMouseEvent(MouseEvents.ENTER, mouseEvent, position);
                }
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                Position position = new Position(mouseEvent.getX(), mouseEvent.getY());
                for (Layer layer : layersAt(position)) {
                    layer.captureMouseEvent(MouseEvents.EXIT, mouseEvent, position);
                }
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
        if (debug) {
            print(PrintType.INFO, String.format("setting background to (%s,%s,%s)", background.getRed(), background.getGreen(), background.getBlue()));
        }
    }

    public synchronized void AddImageToAtlas(String identifier, BufferedImage image) {
        this.imageAtlas.put(identifier, image);
    }

    public synchronized BufferedImage getImageFromAtlas(String identifier) {
        return this.imageAtlas.get(identifier);
    }

    public synchronized UUID addLayer(Layer layer) {
        UUID uuid = UUID.randomUUID();
        layers.put(uuid, layer);
        return uuid;
    }

    public synchronized Layer getLayer(UUID uuid) {
        return this.layers.get(uuid);
    }

    public void enableDebugMode() {
        print(PrintType.INFO, "Enabled Debug Mode");
        this.debug = true;
    }

    public synchronized int getUpdatesPerSecond() {
        return this.updatesPerSecond;
    }

    public synchronized void halt() {
        this.running = false;
        if (debug) {
            print(PrintType.INFO, "stopping screen...");
        }

    }

    public Set<Layer> layersAt(Position position) {
        Set<Layer> layers1 = new HashSet<>();
        for (Layer layer : layers.values()) {
            if (new BoundingBox(layer.position, new Position(layer.position.getX() + layer.size.getWidth(), layer.position.getY() + layer.size.height)).inBounds(position)) {
                layers1.add(layer);
            }
        }
        return layers1;
    }

    public synchronized Dimension getScreenSize() {
        return this.screenSize;
    }

    @Override
    public void run() {

        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        while (this.running) {
            //print(ramgames.ramrender.PrintType.INFO,"running");
            currentTime = System.currentTimeMillis();
            double lastRenderInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderInSeconds;
            lastUpdate = currentTime;
            if (accumulator > updateRate) {
                render();
            }
            while (accumulator > updateRate) {
                update();
                accumulator -= updateRate;
            }
        }
        if (debug) {
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
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        layers.values().forEach(layer -> {
            layer.render(graphics);
        });
        graphics.dispose();
        strategy.show();

    }

    public void update() {
        for (Layer layer : layers.values()) {
            layer.update();
        }
    }

    public void print(PrintType type, Object message) {
        System.out.printf("%s{%s} [%s] RamRender - %s%s\n", type.getCode(), type.getName(), formatter.format(new Date()), message.toString(), "\u001B[0m");

    }
}
