/*********************
 * Author: Micah L
 * A06 - Face
 * Course: CSIS 1410
 *********************/

//CREATE FACE FEATURES

package a06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Face extends JFrame 
{

	private ArrayList<Image> faces = new ArrayList<Image>();
	private ArrayList<Image> eyes = new ArrayList<Image>();
	private ArrayList<Image> noses = new ArrayList<Image>();
	private ArrayList<Image> mouths = new ArrayList<Image>();

	private int numFace = 0;
	private int numEye = 0;
	private int numNose = 0;
	private int numMouth = 0;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Face frame = new Face();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Face() 
	{
		for (int i = 1; i < 4; i++) 
		{
			faces.add(new ImageIcon(getClass().getResource("/a06/face" + String.valueOf(i) + ".png")).getImage());
			eyes.add(new ImageIcon(getClass().getResource("/a06/eyes" + String.valueOf(i) + ".png")).getImage());
			noses.add(new ImageIcon(getClass().getResource("/a06/nose" + String.valueOf(i) + ".png")).getImage());
			mouths.add(new ImageIcon(getClass().getResource("/a06/mouth" + String.valueOf(i) + ".png")).getImage());

		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel sidePanel = new JPanel();
		sidePanel.setBorder(new EmptyBorder(0, 5, 0, 5));
		contentPane.add(sidePanel, BorderLayout.WEST);
		sidePanel.setLayout(new GridLayout(10, 1, 0, 0));

		JLabel label1 = new JLabel("You Choose...");
		sidePanel.add(label1);
		label1.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox eyeCheckBox = new JCheckBox("Eyes");
		sidePanel.add(eyeCheckBox);

		JCheckBox noseCheckBox = new JCheckBox("Nose");
		sidePanel.add(noseCheckBox);

		JCheckBox mouthCheckBox = new JCheckBox("Mouth");
		sidePanel.add(mouthCheckBox);

		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				if (eyeCheckBox.isSelected()) 
				{
					if (numEye != 2)
						numEye++;
					else 
					{
						numEye = 0;
					}
				}

				if (noseCheckBox.isSelected()) 
				{
					if (numNose != 2) 
					{
						numNose++;
					} else 
					{
						numNose = 0;
					}
				}

				if (mouthCheckBox.isSelected()) 
				{
					if (numMouth != 2) 
					{
						numMouth++;
					} else {
						numMouth = 0;
					}
				}

				if (!(mouthCheckBox.isSelected()) && !(noseCheckBox.isSelected()) && !(eyeCheckBox.isSelected())) 
				{
					if (numFace != 2) 
					{
						numFace++;
					} else 
					{
						numFace = 0;
					}
				}
			}
		});
		sidePanel.add(submitBtn);

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(null);
		mainPanel.setBackground(Color.BLUE);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(0, 1, 0, 0));

		getContentPane().add(new FaceDraw(), BorderLayout.CENTER);

	}

	protected class FaceDraw extends JPanel 
	{
		@Override
		public void paint(Graphics g) 
		{
			super.paint(g);
			g.drawImage(faces.get(numFace), 50, 5, 400, 400, null);
			g.drawImage(eyes.get(numEye), 165, 25, 170, 170, null);
			g.drawImage(noses.get(numNose), 190, 150, 100, 100, null);
			g.drawImage(mouths.get(numMouth), 150, 180, 200, 200, null);
			repaint(); // updates continuously
		}
	}
}