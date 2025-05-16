import java.awt.*;
import javax.swing.*;

public class FormSigmaOutput extends JFrame{
    public FormSigmaOutput(String nama, String tanggalLahir, String nomorPendaftaran, String noTelp, String alamat, String email){
        setTitle("Data Mahasiswa Sigma");//ngasih nama title
        setSize(400, 250);//ngeset ukuran page
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//cuma nutup page ini aja, page sebelumnya tetep ada
        getContentPane().setBackground(new Color(39, 84, 138));//ngasih warna

        JTextArea a = new JTextArea();
        a.setEditable(false);//fungsi itu membuat kita gabisa ngedit text yang ada di area a
        a.setFont(new Font("Roboto", Font.PLAIN, 14));//format yang saya gunakan adalah roboto dengan size 14
        a.setForeground(new Color(255, 255, 255));//fungsi yang berguna untuk memberi warna pada text
        a.setBackground(new Color(39, 84, 138));//memberi warna background
        a.setText(
                "Nama: " + nama + "\n" +
                "Tanggal Lahir: " + tanggalLahir + "\n" +
                "Nomor Pendaftaran: " + nomorPendaftaran + "\n" +
                "No. Telp: " + noTelp + "\n" +
                "Alamat: " + alamat + "\n" +
                "E-mail: " + email);//ngasih text
        //Fungsinya buat nampilin teksnya ke dalam frame
        //menambahkan komponen JTextArea (yang bernama a) ke frame, tapi dibungkus pakai JScrollPane.
        //Kenapa pake JScrollPane?
        //Karena JTextArea itu bisa panjang banget isinya. Kalau gak dibungkus JScrollPane, teks yang panjang bakal kehilangan bagian bawahnya—nggak bisa discroll.
        //Dengan JScrollPane, bisa ngescroll ke bawah kalau teksnya lebih banyak dari tinggi frame.
        add(new JScrollPane(a));
    }
    
}