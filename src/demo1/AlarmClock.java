package demo1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javazoom.jl.player.Player;


public class AlarmClock extends JFrame implements Runnable {
	
	String sound;
	String title;
	String hours;
	String hh;
	String mm;
	FileInputStream fileInputStream;
	BufferedInputStream bufferedInputStream;
	Player player;
	long all;
	String hourAlarm;
	String minuteAlarm;
	

	private JFrame VETTAVALI;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlarmClock window = new AlarmClock();
					window.VETTAVALI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Clock() {
		
		Thread t = new Thread() {
	
			public void run() {
				try {
					for(;;) {
						
						Calendar calendar = new GregorianCalendar();
						int day = calendar.get(Calendar.DAY_OF_MONTH);
						int month = calendar.get(Calendar.MONTH) +1;
						int year = calendar.get(Calendar.YEAR);
						
						int second = calendar.get(Calendar.SECOND);
						int hour = calendar.get(Calendar.HOUR);
						int minute = calendar.get(Calendar.MINUTE);
						lblNewLabel_1.setText("Time " + hour +":" + minute +":" + second + " Date " +year+"/"+month +"/"+day);
						
						sleep(1000);
						
					}
					
					
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		t.start();
	
	}

	/**
	 * Create the application.
	 */
	public AlarmClock() {
		initialize();
		Clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		VETTAVALI = new JFrame();
		VETTAVALI.setBounds(100, 100, 450, 300);
		VETTAVALI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VETTAVALI.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ALARM CLOCK");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(62, 0, 306, 44);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		VETTAVALI.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("jLabel3");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(62, 54, 342, 29);
		VETTAVALI.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Timer");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 137, 64, 44);
		VETTAVALI.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hour");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(110, 110, 45, 20);
		VETTAVALI.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Minute");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(184, 114, 67, 13);
		VETTAVALI.getContentPane().add(lblNewLabel_4);
		
		JComboBox jcomboBox2 = new JComboBox();
		jcomboBox2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jcomboBox2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		jcomboBox2.setBounds(184, 152, 50, 21);
		VETTAVALI.getContentPane().add(jcomboBox2);
		
		JComboBox jcomboBox1 = new JComboBox();
		jcomboBox1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05'", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		jcomboBox1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jcomboBox1.setBounds(110, 152, 50, 21);
		VETTAVALI.getContentPane().add(jcomboBox1);
		
		JLabel lblNewLabel_5 = new JLabel(":");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(165, 155, 19, 13);
		VETTAVALI.getContentPane().add(lblNewLabel_5);
		
		JButton jBRingtone = new JButton("Ringtone");
		jBRingtone.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				chooseSong();
				if(!sound.equals(null)) {
					jBRingtone.setText("Alarm Music:" +title);
				}
				
				lblNewLabel_1.setEnabled(true);
			}
		});
		jBRingtone.setFont(new Font("Tahoma", Font.BOLD, 15));
		jBRingtone.setBounds(10, 207, 103, 21);
		VETTAVALI.getContentPane().add(jBRingtone);
		
		JButton jBListen = new JButton("Listen");
		jBListen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(jBListen.getText().equals("Listen")) {
					startAlarm();
					jBListen.setText("Stop Sound");
					jBSetAlarm.setEnabled(false);
					
				}
				else if(jBListen.getText().equals("Stop Sound")) {
					stopAlarm();
					jBListen.setText("Listen");
					jBListen.setEnabled(true);
				}
			}
		});
		jBListen.setFont(new Font("Tahoma", Font.BOLD, 15));
		jBListen.setBounds(139, 209, 101, 21);
		VETTAVALI.getContentPane().add(jBListen);
		
		JButton jBSetAlarm = new JButton("SetAlarm");
		jBSetAlarm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				hourAlarm =jcomboBox1.getSelectedItem().toString();
				minuteAlarm = jcomboBox2.getSelectedItem().toString();
				if (lblNewLabel_1.getText()!="") {
					String alarmClock = hourAlarm + ":" + minuteAlarm;
				    System.out.println(alarmClock);
				    alarmTime(Integer.valueOf(hourAlarm),Integer.valueOf(minuteAlarm));
					
				}
				else {
					JOptionPane.showMessageDialog(null, "You don't choose alarm music...","Warning",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		jBSetAlarm.setFont(new Font("Tahoma", Font.BOLD, 15));
		jBSetAlarm.setBounds(249, 209, 119, 21);
		VETTAVALI.getContentPane().add(jBSetAlarm);
	}
	
	
	public void chooseSong() {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		int soundINT = jfc.showOpenDialog(null);
		if(soundINT ==JFileChooser.APPROVE_OPTION) {
			File alarmMusic = jfc.getSelectedFile();
			sound=alarmMusic.getAbsolutePath();
			title =jfc.getSelectedFile().getName();
			System.out.println(title);
			
		}
		else if(soundINT ==JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null,"You dont choose alarm music...");
			
		}
		
		
		
	}
	
	public void startAlarm() {
		try {
			fileInputStream = new FileInputStream(sound);
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			player = new Player(bufferedInputStream);
			all = fileInputStream.available();
			new Thread() {
				 
				public void run() {
					try {
						player.play();
					}catch (Exception e) {
						
					}
				}
			}.start();
		}catch (Exception e) {
			
		}
	}
	
	public void alarmTime(final int hour, final int minute) {
		
		Thread t = new Thread() {
			public void run() {
				int time =0;
				while(time ==0) {
					Calendar c = Calendar.getInstance();
					int h = c.get(Calendar.HOUR);
					int m = c.get(Calendar.MINUTE);
					if(hour == h && minute == m) {
						startAlarm();
						JOptionPane.showMessageDialog(null, "ALARM");
						int stop = JOptionPane.showConfirmDialog(null, "STOP ALARM","",JOptionPane.YES_NO_OPTION);
						if (stop ==JOptionPane.YES_OPTION) {
							stopAlarm();
							break;
						}
					
					}
					
				}
			}
		};t.start();
	}
	
	public void stopAlarm() {
		if(player !=null) {
			player.close();
		}
	}


	private javax.swing.JButton jBListen;
	private javax.swing.JButton jBRingtone;
	private javax.swing.JButton jBSetAlarm;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JComboBox<String> jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	String date;
	String day;
	String time;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	private JLabel lblNewLabel_6;

	
	
	public void run() {
		
		while(true) {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
			Date date = c.getTime();
			time = simpleDateFormat.format(date);
	        timeLabel.setText("Current Time: " + time);
	        hours=simpleDateFormat.format(date);
			jLabel3.setText(hours);
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	
	
	
	
	
}
