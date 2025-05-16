import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FormSigma extends JFrame implements ActionListener {
    //JTextField itu fitur agar kita bisa ngasih teks di suatu form
    private JTextField tfNama, tfTanggalLahir, tfNomorPendaftaran, tfNoTelp, tfAlamat, tfEmail;
    //JButton itu fitur untuk membuat tombol yang ada di library java awt
    private JButton btnSubmit;

    public FormSigma() {
        setTitle("Form Pendaftaran Mahasiswa Sigma");//ngeset judul form
        setSize(500, 300);//ngeset ukuran form yang kita pengen, width itu  lebar dan height itu tinggi form
        setLocationRelativeTo(null);//biar klo di run, bakalan muncul di tengah layar kita
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//kalo kita menutup form, program bakalan berhenti
        setLayout(new BorderLayout());//
        getContentPane().setBackground(new Color(39, 84, 138));

        //GridBagLayout itu kayak layout manager yang disediakan di library java awt
        //fungsinya itu biar kita ngga ngeset posisi komponen secara manual (biasanya pake setBounds())
        //jadi saya lebih pilih pake GridBagLayout daripada pake setBounds(), setelah saya searching gitu
        //misal gridx = 0; itu maksudnya kita naruh komponen di kolom paling kiri
        //terus gridy = 0; itu maksudnya kita naruh komponen di baris pertama
        //Anggep aja kita lagi naruh komponen di tabel microsoft word, gampangnya gitu
        //kan ada baris dan kolom
        JPanel panelForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);//jarak tiap komponen 5 pixel
        gbc.fill = GridBagConstraints.HORIZONTAL;//mengisi komponen secara horizontal, jadi lebar komponen akan sesuai dengan lebar form
        panelForm.setBackground(new Color(39, 84, 138));//ngasih warna di background panel form

        JLabel lblNama = new JLabel("Nama Lengkap");
        //Perkiraan lebar (width) kolom dalam satuan columns (berdasarkan font default)
        //Misal font monospace (seperti Courier), 30 karakter = lebar tepat 30 huruf
        tfNama = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelForm.add(lblNama, gbc);
        gbc.gridx = 1; //kolom kanan atau kolom kedua dan seterusnya
        panelForm.add(tfNama, gbc);
        lblNama.setForeground(Color.WHITE);//ngeset warna text jadi warna putih

        JLabel lblTanggalLahir = new JLabel("Tanggal Lahir");
        tfTanggalLahir = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelForm.add(lblTanggalLahir, gbc);
        gbc.gridx = 1; 
        panelForm.add(tfTanggalLahir, gbc);
        lblTanggalLahir.setForeground(Color.WHITE);

        JLabel lblNomorPendaftaran = new JLabel("Nomor Pendaftaran");
        tfNomorPendaftaran = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 2; // baris kedua dan seterusnya
        panelForm.add(lblNomorPendaftaran, gbc);
        gbc.gridx = 1;
        panelForm.add(tfNomorPendaftaran, gbc);
        lblNomorPendaftaran.setForeground(Color.WHITE);

        JLabel lblNoTelp = new JLabel("No. Telp");
        tfNoTelp = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelForm.add(lblNoTelp, gbc);
        gbc.gridx = 1;
        panelForm.add(tfNoTelp, gbc);
        lblNoTelp.setForeground(Color.WHITE);

        JLabel lblAlamat = new JLabel("Alamat");
        tfAlamat = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelForm.add(lblAlamat, gbc);
        gbc.gridx = 1;
        panelForm.add(tfAlamat, gbc);
        lblAlamat.setForeground(Color.WHITE);

        JLabel lblEmail = new JLabel("E-mail");
        tfEmail = new JTextField(30);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelForm.add(lblEmail, gbc);
        gbc.gridx = 1;
        panelForm.add(tfEmail, gbc);
        lblEmail.setForeground(Color.WHITE);

        //bikin tombol yang bernama submit
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);//biar tombol bisa dideteksi pas diklik
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.RIGHT));//tombol tadi diatur jadi di kanan
        panelTombol.setBackground(new Color(39, 84, 138)); 
        btnSubmit.setPreferredSize(new Dimension(80, 25));//mengatur ukuran tombol
        panelTombol.add(btnSubmit);
        
        //memasukkan panel-panel ke main frame
        add(panelTombol, BorderLayout.SOUTH);//terus posisinya di kebawahin, jadi tombol itu ada di pojok kanan bawah
        add(panelForm, BorderLayout.NORTH);//form input di atas
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            //mengambil data dari form yang udah diinputkan
            //kemudian menyimpannya di variabel yang sesuai
            String nama = tfNama.getText();
            String tanggalLahir = tfTanggalLahir.getText();
            String nomorPendaftaran = tfNomorPendaftaran.getText();
            String noTelp = tfNoTelp.getText();
            String alamat = tfAlamat.getText();
            String email = tfEmail.getText();


            //buat ngecek apakah semua field udah diisi
            //jika belom, bakalan muncul error message
            if (nama.isEmpty() || tanggalLahir.isEmpty() || nomorPendaftaran.isEmpty() || noTelp.isEmpty() || alamat.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                //ngecek apakah nama isinya itu bukan huruf ataupun spasi, kalo iya bakalan muncul error message
                if (!nama.matches("[a-zA-Z\\s]+")) {
                    JOptionPane.showMessageDialog(this, "Nama kamu kayak robot ya, nama harus berupa huruf!", "Ninuninu!", JOptionPane.ERROR_MESSAGE);
                    return;//harus pake return, biar programnya ga lanjut ke bawah
                //ngecek agar email itu isisnya harus ada A keong (@)
                } else if (!email.contains("@")) {
                    JOptionPane.showMessageDialog(this, "E-mail kamu harus ada A Keongnya (@) yaa", "Ninuninu!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //ngecek agar no.pendaftaran dan no.telp harus berisi angka
                if (!nomorPendaftaran.trim().matches("\\d+") || !noTelp.trim().matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Nomor Pendaftaran dan Nomor Telpon harus berupa angka Sayang!", "Ninuninu!", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //jika semua pengecekan udah selesai, bakal muncul dialog konfirmasi
                int confirm = JOptionPane.showConfirmDialog(this, "Apakah data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                //jika user pencet ya, maka akan keluar informasi data mahasiswa di page yang baru
                //dengan cara manggil FormSigmaOutput
                //kemudian nampilinnya pake setVisible(true)
                if (confirm == JOptionPane.YES_OPTION) {
                    new FormSigmaOutput(nama, tanggalLahir, nomorPendaftaran, noTelp, alamat, email).setVisible(true);
                }
            }
        }
    }

    public static void main(String[] args) {
        new FormSigma().setVisible(true);//manggil method FormSigma dan nampilin formnya
    }
}
