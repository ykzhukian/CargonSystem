package asgn2GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import asgn2Codes.ContainerCode;
import asgn2Containers.FreightContainer;
import asgn2Exceptions.ManifestException;
import asgn2Manifests.CargoManifest;

/**
 * The main window for the Cargo Manifest Text application.
 *
 * @author CAB302
 */
public class CargoTextFrame extends JFrame {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private JButton btnLoad;
    private JButton btnUnload;
    private JButton btnFind;
    private JButton btnNewManifest;

    private CargoTextArea canvas;

    private JPanel pnlControls;
    private JPanel pnlDisplay;

    private CargoManifest cargo;

    /**
     * Constructs the GUI.
     *
     * @param title The frame title to use.
     * @throws HeadlessException from JFrame.
     */
    public CargoTextFrame(String frameTitle) throws HeadlessException {
        super(frameTitle);
        constructorHelper();
//        disableButtons();
        setVisible(true);
    }

    /**
     * Initialises the container display area.
     *
     * @param cargo The <code>CargoManifest</code> instance containing necessary state for display.
     */
    private void setCanvas(CargoManifest cargo) {
        if (canvas != null) {
            pnlDisplay.remove(canvas);
        }
        if (cargo == null) {
            disableButtons();
        } else {
            canvas = new CargoTextArea(cargo);
            //implementation here
            canvas.updateDisplay();
            enableButtons();
            pnlDisplay.add(canvas);
        }
        redraw();
    }

    /**
     * Enables buttons for user interaction.
     */
    private void enableButtons() {
    	//implementation here 
    	btnNewManifest.setEnabled(true);
    	btnFind.setEnabled(true);
    	btnLoad.setEnabled(true);
    	btnUnload.setEnabled(true);
    }

    /**
     * Disables buttons from user interaction.
     */
    private void disableButtons() {
    	//implementation here 
//    	btnNewManifest.setEnabled(false);
    	btnFind.setEnabled(false);
    	btnLoad.setEnabled(false);
    	btnUnload.setEnabled(false);
    }

    /**
     * Initialises and lays out GUI components.
     */
    private void constructorHelper() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnLoad = createButton("Load", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runnable doRun = new Runnable() {
                    @Override
                    public void run() {
//                        CargoTextFrame.this.resetCanvas();
                        CargoTextFrame.this.doLoad();
                    }
                };
                SwingUtilities.invokeLater(doRun);
            }
        });
        btnUnload = createButton("Unload", new ActionListener() {
        	//implementation here 
        	@Override
            public void actionPerformed(ActionEvent e) {
                Runnable doRun = new Runnable() {
                    @Override
                    public void run() {
//                        CargoTextFrame.this.resetCanvas();
                        CargoTextFrame.this.doUnload();
                    }
                };
                SwingUtilities.invokeLater(doRun);
            }
        });
        btnFind = createButton("Find", new ActionListener() {
        	//implementation here 
        	@Override
            public void actionPerformed(ActionEvent e) {
                Runnable doRun = new Runnable() {
                    @Override
                    public void run() {
//                        CargoTextFrame.this.resetCanvas();
                        CargoTextFrame.this.doFind();
                    }
                };
                SwingUtilities.invokeLater(doRun);
            }
        });
        btnNewManifest = createButton("New Manifest", new ActionListener() {
        	//implementation here 
        	@Override
            public void actionPerformed(ActionEvent e) {
                Runnable doRun = new Runnable() {
                    @Override
                    public void run() {
//                        CargoTextFrame.this.resetCanvas();
                        setNewManifest();
                    }
                };
                SwingUtilities.invokeLater(doRun);
            }
        });

      //implementation here 
        pnlControls = createControlPanel();
        add(pnlControls, BorderLayout.SOUTH);
        repaint();
    }

    /**
     * Creates a JPanel containing user controls (buttons).
     *
     * @return User control panel.
     */
    private JPanel createControlPanel() {
    	//implementation here 
    	JPanel controls = new JPanel();
    	controls.add(btnNewManifest);
    	controls.add(btnLoad);
    	controls.add(btnUnload);
    	controls.add(btnFind);
    	
    	return controls;
    }

    /**
     * Factory method to create a JButton and add its ActionListener.
     *
     * @param name The text to display and use as the component's name.
     * @param btnListener The ActionListener to add.
     * @return A named JButton with ActionListener added.
     */
    private JButton createButton(String name, ActionListener btnListener) {
        JButton btn = new JButton(name);
        btn.setName(name);
        btn.addActionListener(btnListener);
        return btn;
    }

    /**
     * Initiate the New Manifest dialog which sets the instance of CargoManifest to work with.
     */
    private void setNewManifest() {
		//implementation here 
    	CargoManifest newManifest = ManifestDialog.showDialog(this);
    	cargo = newManifest;
    	if ( cargo.toString() != null ) {
    		enableButtons();
    	}
    	System.out.println(cargo.toString());
    }
    
    /**
     * Turns off container highlighting when an action other than Find is initiated.
     */
    private void resetCanvas() {
    	//implementation here 
    	setCanvas(cargo);
    }

    /**
     * Initiates the Load Container dialog.
     */
    private void doLoad() {
    	//implementation here 
        //Don't forget to redraw
    	FreightContainer newContainer = LoadContainerDialog.showDialog(this);
//    	try {
//			cargo.loadContainer(newContainer);
//		} catch (ManifestException e) {
//			e.printStackTrace();
//		}

//    	System.out.println(newContainer.getCode().toString() + newContainer.getType());
//    	redraw();
    }

    /**
     * Initiates the Unload Container dialog.
     */
    private void doUnload() {
    	//implementation here 
        //Don't forget to redraw
    }

    /**
     * Initiates the Find Container dialog.
     */
    private void doFind() {
    	//implementation here 
    	ContainerCode newContainerCode = ContainerCodeDialog.showDialog(this);
    }

    /**
     * 
     * Updates the display area.
     *
     */
    private void redraw() {
    	//implementation here 
    }
}
