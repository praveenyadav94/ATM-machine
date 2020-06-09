package org.apache.httpcomponents.httpclient;

import javax.swing.JFrame;
import javax.swing.JTextField;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Home extends JFrame {
	private JTextField textFieldMovieName;
	JButton btnFind;
	String mname="";
	JLabel lblPoster;
	private String API="7c01d414";
	private JLabel lblNewLabel;
	private JLabel lblTitle;
	private JLabel lblReleased;
	private JLabel lblGenre;
	private JLabel lblDirector;
	private JLabel lblWriter;
	private JLabel lblActors;
	private JLabel lblBoxoffice;
	private JLabel lblProduction;
	private JLabel lblImdbrating;
	private JLabel lblPlot;
	private JLabel lblLanguage;
	private JLabel lblCountry;
	private JLabel lblAwards;
	
	public Home(String title)
	{
		super(title);
		setForeground(Color.WHITE);
		getContentPane().setBackground(new Color(102, 51, 153));
		setTitle("Filmy Fine Points");
		getContentPane().setLayout(null);
		
		textFieldMovieName = new JTextField();
		textFieldMovieName.setBackground(new Color(147, 112, 219));
		textFieldMovieName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldMovieName.setBounds(14, 100, 447, 50);
		getContentPane().add(textFieldMovieName);
		textFieldMovieName.setColumns(10);
		
		btnFind = new JButton("Find");
		btnFind.setBackground(Color.BLUE);
		btnFind.setForeground(Color.WHITE);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String newStr="";
				mname=textFieldMovieName.getText().trim().toString();
				mname=mname.replace(' ','+');
				System.out.print(mname);
				System.out.println(newStr);
				findDetails(mname);	
			}
			
			private void findDetails(String mname) {
				try 
				{
					String data="";
					URL url=new URL("http://omdbapi.com/?apikey="+API+"&t="+mname);

					try {
						HttpURLConnection conn = (HttpURLConnection)url.openConnection();
						conn.setRequestMethod("GET");
						conn.connect();
						int rscode=conn.getResponseCode();
						System.out.println(rscode);
						if(rscode!=200)
						{
						
							//	System.out.println();
							throw new RuntimeException("CODE:"+rscode);	
						}
						else
						{
							int val=0;
							Scanner sc=new Scanner(url.openStream());
						
							while(sc.hasNext() &&val<100)
							{
								data+=sc.nextLine();	
							}
							
							//progressBar.setVisible(false);
							//System.out.println(data);
							///JSON WORK
							JSONParser parser = new JSONParser();
							try
							{
								JSONObject jsonObject=(JSONObject)parser.parse(data);
								String path = jsonObject.get("Poster").toString();
							    URL urll = new URL(path);
								BufferedImage image = ImageIO.read(urll);
					
								//lblPoster.setText(path);
								lblPoster.setIcon(new ImageIcon(image));
								
								
								lblTitle.setText("Title : "+jsonObject.get("Title").toString());
								lblReleased.setText("Released : "+jsonObject.get("Released").toString());
								lblActors.setText("Actors : "+jsonObject.get("Actors").toString());
								lblDirector.setText("Director : "+jsonObject.get("Director").toString());
								lblGenre.setText("Genre : "+jsonObject.get("Genre").toString());
								lblWriter.setText("Writer : "+jsonObject.get("Writer").toString());
								lblBoxoffice.setText("Boxoffice : "+jsonObject.get("Boxoffice"));
								lblProduction.setText("Production : "+jsonObject.get("Production"));
								lblImdbrating.setText("IMDB Rating : "+jsonObject.get("imdbRating"));
								lblPlot.setText("Plot : "+jsonObject.get("Plot"));
								lblLanguage.setText("Language : "+jsonObject.get("Language"));
								lblCountry.setText("Country : "+jsonObject.get("Country"));
								lblAwards.setText("Awards : "+jsonObject.get("Awards"));
								 
								
							} 
							catch (ParseException e)
							{
								
								e.printStackTrace();
								
							}
								
						}		
					
					} catch (IOException e) {
						
						e.printStackTrace();
						
					}
				
				}
				catch (MalformedURLException e) 
				{
					e.printStackTrace();
					
				}
				
			}
		});
		btnFind.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnFind.setBounds(478, 103, 117, 48);
		getContentPane().add(btnFind);
		
		lblPoster = new JLabel("");
		lblPoster.setBounds(0, 182, 361, 519);
		getContentPane().add(lblPoster);
		
		lblNewLabel = new JLabel("Filmy Fine Points");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 43));
		lblNewLabel.setBounds(513, 10, 419, 84);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 0, 204));
		panel.setBounds(452, 182, 904, 519);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTitle = new JLabel("Title :");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitle.setBounds(10, 45, 941, 32);
		panel.add(lblTitle);
		
		lblReleased = new JLabel("Released : ");
		lblReleased.setForeground(Color.WHITE);
		lblReleased.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReleased.setBounds(10, 87, 951, 32);
		panel.add(lblReleased);
		
		lblGenre = new JLabel("Genre : ");
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenre.setBounds(10, 117, 941, 32);
		panel.add(lblGenre);
		
		lblDirector = new JLabel("Director : ");
		lblDirector.setForeground(Color.WHITE);
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDirector.setBounds(10, 156, 951, 32);
		panel.add(lblDirector);
		
		lblWriter = new JLabel("Writer : ");
		lblWriter.setForeground(Color.WHITE);
		lblWriter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWriter.setBounds(10, 194, 951, 32);
		panel.add(lblWriter);
		
		lblActors = new JLabel("Actors : ");
		lblActors.setForeground(Color.WHITE);
		lblActors.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblActors.setBounds(10, 224, 951, 32);
		panel.add(lblActors);
		
		lblBoxoffice = new JLabel("BoxOffice : ");
		lblBoxoffice.setForeground(Color.WHITE);
		lblBoxoffice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBoxoffice.setBounds(10, 260, 951, 32);
		panel.add(lblBoxoffice);
		
		lblProduction = new JLabel("Production : ");
		lblProduction.setDisplayedMnemonic('a');
		lblProduction.setHorizontalAlignment(SwingConstants.LEFT);
		lblProduction.setForeground(Color.WHITE);
		lblProduction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProduction.setBounds(10, 287, 951, 32);
		panel.add(lblProduction);
		
		lblImdbrating = new JLabel("IMDB Rating : ");
		lblImdbrating.setForeground(Color.WHITE);
		lblImdbrating.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblImdbrating.setBounds(10, 318, 951, 32);
		panel.add(lblImdbrating);
		
		lblPlot = new JLabel("Plot : ");
		lblPlot.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlot.setForeground(Color.WHITE);
		lblPlot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlot.setBounds(10, 348, 951, 55);
		panel.add(lblPlot);
		
		lblLanguage = new JLabel("Language : ");
		lblLanguage.setForeground(Color.WHITE);
		lblLanguage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLanguage.setBounds(10, 462, 951, 32);
		panel.add(lblLanguage);
		
		lblCountry = new JLabel("Country : ");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCountry.setBounds(10, 402, 951, 32);
		panel.add(lblCountry);
		
		lblAwards = new JLabel("Awards : ");
		lblAwards.setForeground(Color.WHITE);
		lblAwards.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAwards.setBounds(10, 431, 951, 32);
		panel.add(lblAwards);
		createUI();
		
		
	}
	public void createUI()
	{
		
		setSize(1353,731);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String s[])
	{
		Home obj = new Home("Home");
	}
}


