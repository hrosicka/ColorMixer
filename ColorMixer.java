import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A graphical user interface (GUI) application that allows users to mix colors
 * by adjusting red, green, and blue sliders. The chosen color is displayed on
 * a panel and its RGB code is updated in real-time.
 *
 * @author (Hanka R.)
 */
public class ColorMixer extends JFrame {

    /**
     * The panel where the mixed color is displayed.
     */
    private JPanel colorPanel;

    /**
     * A slider for adjusting the red component of the mixed color.
     */
    private JSlider redSlider;

    /**
     * A slider for adjusting the green component of the mixed color.
     */
    private JSlider greenSlider;

    /**
     * A slider for adjusting the blue component of the mixed color.
     */
    private JSlider blueSlider;

    /**
     * A button that resets the sliders to their default positions (all red, green, and blue set to 0).
     */
    private JButton resetButton;

    /**
     * A label that displays the RGB code of the currently selected color.
     */
    private JLabel colorCodeLabel;

    /**
     * Creates a new ColorMixer instance, initializes its components, and displays the GUI.
     */
    public ColorMixer() {
        super("Color Mixer");

        // Create the color panel and set its background to black
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);
        add(colorPanel, BorderLayout.CENTER);

        // Set preferred height only
        Dimension preferredSize = new Dimension(colorPanel.getPreferredSize().width, 150); // Adjust height value as needed
        colorPanel.setPreferredSize(preferredSize);

        // Create the color code label and set its initial text
        colorCodeLabel = new JLabel("RGB: (0, 0, 0)");
        add(colorCodeLabel, BorderLayout.NORTH);

        // Create the red slider with a range of 0 to 255 and add a change listener
        redSlider = new JSlider(0, 255);
        redSlider.setValue(0); // Set initial value to 0
        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateColor();
            }
        });

        // Create the green slider (similar to red slider)
        greenSlider = new JSlider(0, 255);
        greenSlider.setValue(0); // Set initial value to 0
        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateColor();
            }
        });

        // Create the blue slider (similar to red slider)
        blueSlider = new JSlider(0, 255);
        blueSlider.setValue(0); // Set initial value to 0
        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateColor();
            }
        });

         // Create the reset button and add an action listener
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redSlider.setValue(0);
                greenSlider.setValue(0);
                blueSlider.setValue(0);
                updateColor();
            }
        });

        // Create a panel to hold the controls (sliders and reset button)
        JPanel controlsPanel = new JPanel();
        controlsPanel.add(redSlider);
        controlsPanel.add(greenSlider);
        controlsPanel.add(blueSlider);
        controlsPanel.add(resetButton);
        add(controlsPanel, BorderLayout.SOUTH);

        // Finalize the frame layout and make it visible
        pack();
        setVisible(true);
    }

    /**
     * Updates the color displayed on the panel and the color code label based on the current slider values.
     */
    private void updateColor() {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();

        // Create a new Color object based on the current slider values
        Color color = new Color(red, green, blue);
        colorPanel.setBackground(color);

        // Update the color code label to reflect the changes
        colorCodeLabel.setText("RGB: (" + red + ", " + green + ", " + blue + ")");
    }

    public static void main(String[] args) {
        new ColorMixer();
    }
}
