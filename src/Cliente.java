
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;

import java.util.ArrayList;

import java.util.Scanner;

import javax.swing.*;

public class Cliente extends JFrame {

	Socket s;

	PrintWriter pw;

	String nome;

	Scanner scan;

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	ArrayList<String> lista = new ArrayList<>();
	private int qtProcessador;
	private int qtMemoria;
	// private ArrayList<String> Idcliente = new ArrayList<>();

	private class ouvirServer implements Runnable {

		@Override

		public void run() {

			try {

				String text;

				while ((text = scan.nextLine()) != null) {

					System.out.println(text);
					
					
					String[] msgPartida = text.split(" ");
					lista.add(text);
					qtMemoria = qtMemoria + Integer.parseInt(msgPartida[1]);
					qtProcessador = qtProcessador + Integer.parseInt(msgPartida[2]);

					jTextField3.setText(qtMemoria + "");
					jTextField4.setText(qtProcessador + "");

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

	public Cliente(String nome) {

		super("chat : " + nome);

		this.nome = nome;

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (jTextField1.getText().equals("") && jTextField2.getText().equals("")) {
					System.exit(1);
				}
				pw.println(nome + " " + "-" + jTextField1.getText() + " " + "-" + jTextField2.getText());

				pw.flush();

				System.exit(1);

			}
		});

		confg();

		initComponents();

		setVisible(true);

	}

	private void confg() {

		try {

			s = new Socket("localhost", 5000);

			pw = new PrintWriter(s.getOutputStream());

			scan = new Scanner(s.getInputStream());

			new Thread(new ouvirServer()).start();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		pw.println(nome + " " + jTextField1.getText() + " " + jTextField2.getText());

		pw.flush();

		jTextField1.setEnabled(false);
		jTextField2.setEnabled(false);

		jTextField1.requestFocus();

		jTextField2.requestFocus();

	}

	/*
	 * 
	 * FAZ AQUI EM
	 * 
	 * BAIXO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * !!!!
	 */

	// private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	// try {
	// if (jTextField1.getText().equals("") && jTextField2.getText().equals("")) {
	// s.close();
	// System.exit(1);
	//
	// } else {
	//
	// pw.println(nome + " " + "-" + jTextField1.getText() + " " + "-" +
	// jTextField2.getText());
	//
	// pw.flush();
	//
	// s.close();
	// System.exit(1);
	//
	// }
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextField6 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jPanel2 = new javax.swing.JPanel();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridLayout(2, 2));

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bloqueados"));

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setText("CPU");

		jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel6.setText("Memoria");

		jButton2.setText("Bloquear");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(53, 53, 53)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jTextField5).addComponent(jLabel5,
														javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
										.addGap(18, 18, 18)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 65,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel6)))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(81, 81, 81)
										.addComponent(jButton2)))
						.addContainerGap(140, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(56, 56, 56)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 31,
												Short.MAX_VALUE)
										.addComponent(jTextField6))
						.addGap(40, 40, 40).addComponent(jButton2).addContainerGap(58, Short.MAX_VALUE)));

		getContentPane().add(jPanel1);

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

		jLabel3.setText("Memoria:");

		jLabel4.setText("CPU:");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(22, 22, 22)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3).addComponent(jLabel4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jTextField3)
								.addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
						.addContainerGap(120, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(52, 52, 52)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3).addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(37, 37, 37)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(111, Short.MAX_VALUE)));

		getContentPane().add(jPanel3);

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Recursos Recebidos"));

		jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel9.setText("CPU");

		jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel10.setText("Mem�ria");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(42, 42, 42)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel9))
						.addGap(41, 41, 41)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel10).addComponent(jTextField8,
										javax.swing.GroupLayout.PREFERRED_SIZE, 71,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(109, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(85, 85, 85)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9).addComponent(jLabel10))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
								.addComponent(jTextField8))
						.addContainerGap(81, Short.MAX_VALUE)));

		getContentPane().add(jPanel2);

		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade"));

		jLabel1.setText("Mem�ria:");

		jLabel2.setText("CPU:");

		jButton1.setText("Enviar");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup().addGap(48, 48, 48)
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1).addComponent(jLabel2))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel4Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jTextField1).addComponent(jTextField2,
												javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
						.addGroup(jPanel4Layout.createSequentialGroup().addGap(113, 113, 113).addComponent(jButton1)))
						.addContainerGap(128, Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(61, 61, 61)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(34, 34, 34)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38).addComponent(jButton1).addContainerGap(44, Short.MAX_VALUE)));

		getContentPane().add(jPanel4);

		pack();
		/*
		 * jPanel1 = new javax.swing.JPanel();
		 * 
		 * jLabel1 = new javax.swing.JLabel();
		 * 
		 * jTextField1 = new javax.swing.JTextField();
		 * 
		 * jLabel2 = new javax.swing.JLabel();
		 * 
		 * jButton1 = new javax.swing.JButton();
		 * 
		 * jTextField2 = new javax.swing.JTextField();
		 * 
		 * jButton2 = new javax.swing.JButton();
		 * 
		 * setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		 * 
		 * jLabel1.setText("Memoria");
		 * 
		 * jLabel2.setText("Processador");
		 * 
		 * jButton1.setText("Enviar");
		 * 
		 * jButton1.addActionListener(new java.awt.event.ActionListener() {
		 * 
		 * public void actionPerformed(java.awt.event.ActionEvent evt) {
		 * 
		 * jButton1ActionPerformed(evt);
		 * 
		 * }
		 * 
		 * });
		 * 
		 * jButton2.addActionListener(new java.awt.event.ActionListener() {
		 * 
		 * public void actionPerformed(java.awt.event.ActionEvent evt) {
		 * 
		 * // jButton2ActionPerformed(evt);
		 * 
		 * }
		 * 
		 * });
		 * 
		 * jButton2.setText("Sair");
		 * 
		 * javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		 * 
		 * jPanel1.setLayout(jPanel1Layout);
		 * 
		 * jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.
		 * swing.GroupLayout.Alignment.LEADING)
		 * 
		 * .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
		 * 
		 * .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		 * 
		 * .addGroup(jPanel1Layout.createSequentialGroup().addGap(71, 71,
		 * 71).addComponent(jButton1))
		 * 
		 * .addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26)
		 * 
		 * .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
		 * .LEADING)
		 * 
		 * .addComponent(jLabel2).addComponent(jLabel1))
		 * 
		 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		 * 
		 * .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
		 * .LEADING)
		 * 
		 * .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
		 * 
		 * javax.swing.GroupLayout.PREFERRED_SIZE)
		 * 
		 * .addComponent(jTextField1))))
		 * 
		 * .addContainerGap(46, Short.MAX_VALUE))
		 * 
		 * .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
		 * 
		 * jPanel1Layout.createSequentialGroup().addGap(0, 0,
		 * Short.MAX_VALUE).addComponent(jButton2,
		 * 
		 * javax.swing.GroupLayout.PREFERRED_SIZE, 63,
		 * javax.swing.GroupLayout.PREFERRED_SIZE)
		 * 
		 * .addContainerGap()));
		 * 
		 * jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.
		 * GroupLayout.Alignment.LEADING)
		 * 
		 * .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().
		 * addComponent(jButton2)
		 * 
		 * .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30,
		 * Short.MAX_VALUE)
		 * 
		 * .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
		 * .BASELINE)
		 * 
		 * .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
		 * 
		 * javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		 * 
		 * .addComponent(jLabel1))
		 * 
		 * .addGap(19, 19, 19)
		 * 
		 * .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
		 * .BASELINE)
		 * 
		 * .addComponent(jLabel2).addComponent(jTextField2,
		 * javax.swing.GroupLayout.PREFERRED_SIZE,
		 * 
		 * javax.swing.GroupLayout.DEFAULT_SIZE,
		 * javax.swing.GroupLayout.PREFERRED_SIZE))
		 * 
		 * .addGap(25, 25, 25).addComponent(jButton1).addGap(26, 26, 26)));
		 * 
		 * javax.swing.GroupLayout layout = new
		 * javax.swing.GroupLayout(getContentPane());
		 * 
		 * getContentPane().setLayout(layout);
		 * 
		 * layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.
		 * Alignment.LEADING).addComponent(
		 * 
		 * jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
		 * javax.swing.GroupLayout.DEFAULT_SIZE,
		 * 
		 * javax.swing.GroupLayout.PREFERRED_SIZE));
		 * 
		 * layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.
		 * Alignment.LEADING).addComponent(
		 * 
		 * jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
		 * javax.swing.GroupLayout.DEFAULT_SIZE,
		 * 
		 * javax.swing.GroupLayout.PREFERRED_SIZE));
		 * 
		 * pack();
		 */
	}

}