package tugas;
import java.util.Arrays;
import java.util.Scanner;

public class FinalProject {
    static double mean (int n, double[] data){
        double jumlah = 0;
        for(int i=0;i<n;i++){
            jumlah += data[i];
        }
        return jumlah / n;
    }
    
    static double median (int n, double[] data){
        java.util.Arrays.sort(data);  
        if (n%2==0){
            return (data[(n/2)-1]+data[n/2])/2.0;
        } else {
            return data [n/2];
        }
    }
    
    static double[] modus(int n, double[] data) {
            double[] hasilModus = new double[n];
            int jumlahModus = 0;
            int maxFrekuensi = 0;

            for (int i = 0; i < n; i++) {
                int frekuensi = 0;
                for (int j = 0; j < n; j++) {
                    if (data[i] == data[j]) {
                        frekuensi++;
                    }
                }

                if (frekuensi > maxFrekuensi) {
                    maxFrekuensi = frekuensi;
                    hasilModus = new double[n];
                    hasilModus[0] = data[i];
                    jumlahModus = 1;
                } else if (frekuensi == maxFrekuensi) {
                    boolean sudahAda = false;
                    for (int k = 0; k < jumlahModus; k++) {
                        if (hasilModus[k] == data[i]) {
                            sudahAda = true;
                            break;
                        }
                    }
                    if (!sudahAda) {
                        hasilModus[jumlahModus] = data[i];
                        jumlahModus++;
                    }
                }
            }

            if (maxFrekuensi == 1) {
                return new double[0];
            }

            double[] finalModus = new double[jumlahModus];
            for (int i = 0; i < jumlahModus; i++) {
                finalModus[i] = hasilModus[i];
            }

            return finalModus;
        }
     
    static double varians (int n, double[] data){
        double mean = mean(n,data);
        double var = 0;
        for (int i=0; i<n; i++){
            var += Math.pow(data[i]- mean,2);
        }
        return var/n;
    }
    
    static double sdev (int n, double[] data){
        return Math.sqrt(varians(n,data));
    }
    
    static double range (int n, double[] data){
        java.util.Arrays.sort(data);  
        return data[n-1]-data[0];
    }
    
    static double kuartil (int k, double[] data){
        java.util.Arrays.sort(data);  
        int n = data.length;
        double pos = (k*n) / 4.0;  
    
        if (pos % 1 == 0) {
            return data[(int)pos - 1];  
        } else {
            int bawah = (int)Math.floor(pos) - 1;
            int atas = (int)Math.ceil(pos) - 1;
            return (data[bawah] + data[atas]) / 2.0;  
        }
    }
    
    static double desil(int d, double[] data) {
        java.util.Arrays.sort(data);  
        int n = data.length;
        double pos = (d*n) / 10.0;  

        if (pos % 1 == 0) {
            return data[(int)pos - 1];  
        } else {
            int bawah = (int)Math.floor(pos) - 1;
            int atas = (int)Math.ceil(pos) - 1;
            return (data[bawah] + data[atas]) / 2.0;  
        }
    }

    static double persentil(int p, double[] data) {
        java.util.Arrays.sort(data);  
        int n = data.length;
        double pos = (p*n) / 100.0;

        if (pos % 1 == 0) {
            return data[(int)pos - 1];
        } else {
            int lower = (int)Math.floor(pos) - 1;
            int upper = (int)Math.ceil(pos) - 1;
            return (data[lower] + data[upper]) / 2.0;
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n,pilihan,k,d,p;
        
        while (true) {
            System.out.print("Masukkan jumlah data: ");
            if (input.hasNextInt()) { 
                n = input.nextInt();
                if (n > 0) {
                    break; 
                } else {
                    System.out.println("Jumlah data harus lebih besar dari nol.");
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat positif.");
                input.next(); 
            }
        }

        double [] data = new double[n];
        for(int i = 0; i < data.length; i++) {
            System.out.print("Nilai ke-" + (i + 1) + " adalah: ");
            while (!input.hasNextDouble()) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                System.out.print("Nilai ke-" + (i + 1) + " adalah: ");
                input.next(); 
            }
            data[i] = input.nextDouble();
        }
        
        System.out.println("\nPilih perhitungan yang ingin dilakukan:");
            System.out.println("1. Hitung Mean\n2. Hitung Median\n3. Hitung Modus\n4. Hitung Varians\n5. Hitung Standar Deviasi");
            System.out.println("6. Hitung Range\n7. Hitung Kuartil\n8. Hitung Desil\n9. Hitung Persentil\n10. Hitung semua\n0. Keluar");
            
        while (true) {
            System.out.print("\nMasukkan pilihan (0-10): ");
            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                if (pilihan >= 0 && pilihan <= 10) {
                    switch (pilihan) {
                        case 1:
                            System.out.println("Mean: " + mean(n, data));
                            break;
                        case 2:
                            System.out.println("Median: " + median(n, data));
                            break;
                            
                        case 3:
                            double[] hasilModus = modus(n, data); 
                            if (hasilModus.length == 0) {
                                System.out.println("Modus: Tidak ada (semua nilai muncul hanya sekali)");
                            } else {
                                System.out.print("Modus: ");
                                for (double m : hasilModus) { 
                                    System.out.print(m + " ");
                                }
                            }
                            break;
                            
                        case 4:
                            System.out.println("Varians: " + varians(n, data));
                            break;
                        case 5:
                            System.out.println("Standar deviasi: " + sdev(n, data));
                            break;
                        case 6:
                            System.out.println("Range: " + range(n, data));
                            break;
                            
                        case 7:
                            while (true) {
                                System.out.print("Hitung kuartil ke (1, 2, 3, atau 4): ");
                                if (input.hasNextInt()) { 
                                    k = input.nextInt();
                                    if (k >= 1 && k <= 4) break;
                                    else System.out.println("Input tidak valid. Masukkan angka 1, 2, 3, atau 4.");
                                } else {
                                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
                                    input.next(); 
                                }
                            }
                            System.out.println("Kuartil ke-" + k + ": " + kuartil(k, data));
                            break;
                            
                        case 8:
                            while (true) {
                                System.out.print("Hitung desil ke (1 sampai 10): ");
                                if (input.hasNextInt()) { 
                                    d = input.nextInt();
                                    if (d >= 1 && d <= 10) break;
                                    else System.out.println("Input tidak valid. Desil harus antara 1 dan 10.");
                                } else {
                                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
                                    input.next(); 
                                }
                            }
                            System.out.println("Desil ke-" + d + ": " + desil(d, data));
                            break;
                            
                        case 9:
                            while (true) {
                                System.out.print("Hitung persentil ke (1 sampai 100): ");
                                if (input.hasNextInt()) { 
                                    p = input.nextInt();
                                    if (p >= 1 && p <= 100) break;
                                    else System.out.println("Input tidak valid. Persentil harus antara 1 dan 100.");
                                } else {
                                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
                                    input.next(); 
                                }
                            }
                            System.out.println("Persentil ke-" + p + ": " + persentil(p, data));
                            break;
                            
                        case 10:
                            System.out.println("Mean: " + mean(n, data));
                            System.out.println("Median: " + median(n, data));
                            
                            double[] allModus = modus(n, data);
                            if (allModus.length == 0) {
                                System.out.println("Modus: Tidak ada (semua nilai muncul hanya sekali)");
                            } else {
                                System.out.print("Modus: ");
                                for (double m : allModus) {
                                    System.out.print(m + " ");
                                }
                                System.out.println();
                            }
                            
                            System.out.println("Varians: " + varians(n, data));
                            System.out.println("Standar deviasi: " + sdev(n, data));
                            System.out.println("Range: " + range(n, data));
                            
                            while (true) {
                                System.out.print("Hitung kuartil ke (1, 2, 3, atau 4): ");
                                if (input.hasNextInt()) { 
                                    k = input.nextInt();
                                    if (k >= 1 && k <= 4) break;
                                    else System.out.println("Input tidak valid. Masukkan angka 1, 2, 3, atau 4.");
                                } else {
                                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
                                    input.next(); 
                                }
                            }
                            System.out.println("Kuartil ke-" + k + ": " + kuartil(k, data));
                            
                            while (true) {
                                System.out.print("Hitung desil ke (1 sampai 10): ");
                                if (input.hasNextInt()) { 
                                    d = input.nextInt();
                                    if (d >= 1 && d <= 10) break;
                                    else System.out.println("Input tidak valid. Desil harus antara 1 dan 10.");
                                } else {
                                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
                                    input.next(); 
                                }
                            }
                            System.out.println("Desil ke-" + d + ": " + desil(d, data));
                            while (true) {
                                System.out.print("Hitung persentil ke (1 sampai 100): ");
                                if (input.hasNextInt()) { 
                                    p = input.nextInt();
                                    if (p >= 1 && p <= 100) break;
                                    else System.out.println("Input tidak valid. Persentil harus antara 1 dan 100.");
                                } else {
                                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
                                    input.next(); 
                                }
                            }
                            System.out.println("Persentil ke-" + p + ": " + persentil(p, data));
                            break;
                        case 0:
                            System.out.println("Keluar dari program.");
                            return; 
                        default:
                            System.out.println("Pilihan tidak valid.");
                            break;
                    }       
                } else {
                    System.out.println("Input tidak valid. Harap masukkan angka antara 0 dan 9.");
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.next(); 
            }
        }
         
    }
}
