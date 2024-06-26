import java.util.*;

public class PenjurusanTPB {

    public static class Mahasiswa {
        private Integer NIM;
        private String Nama;
        private Double IP;
        private Double UKT;
        
        public Mahasiswa(Integer NIM, String nama, Double IP, Double UKT) { 
            this.NIM = NIM;
            this.Nama = nama;
            this.IP = IP;
            this.UKT = UKT;
        }

        public Integer getNIM() { 
            return NIM;
        }
        
        public String getNama() {
            return Nama;
        }

        public Double getIP() {
            return IP;
        }

        public Double getUKT() {
            return UKT;
        }
    }

    private static class MahasiswaComparator implements Comparator<Mahasiswa> {
        /**
         * Membandingkan Mahasiswa dengan urutan sebagai berikut:
         *  1. UKT yang lebih besar akan diprioritaskan.
         *  2. IP yang lebih besar akan diprioritaskan.
         *  3. NIM yang lebih kecil akan diprioritaskan. (NIM dipastikan unik)
         */
        public int compare(Mahasiswa mahasiswa1, Mahasiswa mahasiswa2) {
            if (mahasiswa1.getUKT().compareTo(mahasiswa2.getUKT()) != 0){
                return mahasiswa2.getUKT().compareTo(mahasiswa1.getUKT());
            }
            else if (mahasiswa1.getIP().compareTo(mahasiswa2.getIP()) != 0){
                return mahasiswa2.getIP().compareTo(mahasiswa1.getIP());
            }
            else{
                return mahasiswa1.getNIM().compareTo(mahasiswa2.getNIM());
            }
        }
    }

    /**
     * Menerima List<Mahasiswa> yang tidak terurut
     * Mengembalikan PriorityQueue<Mahasiswa> yang sudah terurut berdasarkan prioritas.
     */
    public static PriorityQueue<Mahasiswa> PembangkitanAntrianPrioritas(List<Mahasiswa> list) {
        PriorityQueue<Mahasiswa> queue = new PriorityQueue<>(new MahasiswaComparator());
        queue.addAll(list);
        return queue;
    }
}