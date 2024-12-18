//(YANUAR ALDA BARAN, 244107060016, 25)

import java.util.Scanner;

public class UAS1C25{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan dua digit terakhir NIM Anda: ");
        int duaDigitTerakhirNIM = sc.nextInt();
        int jumlahTim = (duaDigitTerakhirNIM % 3) + 4;
        
        String[] namaTim = new String[4];
        int[][] skor = new int[4][2];
        int[] totalSkor = new int[4];
        int bonusBuff = 25; 
        
        boolean dataInputted = false;

        int pilihan;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor dan Total Skor");
            System.out.println("3. Tentukan Juara Turnamen");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Masukkan nama tim ke-" + (i + 1) + ": ");
                        namaTim[i] = sc.nextLine();

                        System.out.print("Masukkan skor " + namaTim[i] + " untuk Level 1: ");
                        skor[i][0] = sc.nextInt();

                        System.out.print("Masukkan skor " + namaTim[i] + " untuk Level 2: ");
                        skor[i][1] = sc.nextInt();
                        sc.nextLine(); 

                        
                        totalSkor[i] = skor[i][0] + skor[i][1];

                        if (skor[i][0] > 50 && skor[i][1] > 50) {
                            totalSkor[i] += bonusBuff;
                        }

                        if (totalSkor[i] % 2 == 0) {
                            totalSkor[i] -= 15;
                        }
                    }
                    dataInputted = true;
                    System.out.println("Data skor berhasil dimasukkan!");
                    break;

                case 2:

                    if (!dataInputted) {
                        System.out.println("Data belum dimasukkan. Pilih menu 1 terlebih dahulu.");
                    } else {
                        System.out.println("\nNama Tim\tLevel 1\tLevel 2\tTotal Skor");
                        for (int i = 0; i < 4; i++) {
                            System.out.println(namaTim[i] + "\t\t" + skor[i][0] + "\t" + skor[i][1] + "\t" + totalSkor[i]);
                        }
                    }
                    break;

                case 3:
                    if (!dataInputted) {
                        System.out.println("Data belum dimasukkan. Pilih menu 1 terlebih dahulu.");
                    } else {
                        int maxSkor = totalSkor[0];
                        int indexJuara = 0;
                        boolean seri25 = false;

                        for (int i = 1; i < 4; i++) {
                            if (totalSkor[i] > maxSkor) {
                                maxSkor = totalSkor[i];
                                indexJuara = i;
                                seri25 = false; 
                            } else if (totalSkor[i] == maxSkor) {
                                seri25 = true;
                            }
                        }

                        if (seri25) {
                            int maxLevel2 = skor[0][1];
                            int indexLevel2 = 0;

                            for (int i = 1; i < 4; i++) {
                                if (totalSkor[i] == maxSkor && skor[i][1] > maxLevel2) {
                                    maxLevel2 = skor[i][1];
                                    indexLevel2 = i;
                                }
                            }

                            System.out.println("Selamat kepada Tim berakhir seri" + namaTim[indexLevel2] + " tim terbaik adalah YANUAR!");
                        } else {
                            System.out.println("Selamat kepada Tim " + namaTim[indexJuara] + " yang telah memenangkan kompetisi!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 1-4.");
            }
        } while (pilihan != 4);

        sc.close();
    }
}
