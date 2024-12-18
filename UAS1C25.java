//Nama: YANUAR ALDA BARAN
//NIM : 244107060016
//No Absen : 25

import java.util.Scanner;

public class UAS1C25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] namaTim25 = new String[4];
        int[][] skor25 = new int[4][2];
        int[] totalSkor25 = new int[4];
        int bonusBuff25 = 25;

        boolean dataInputted25 = false;

        int pilihan25;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor dan Total Skor");
            System.out.println("3. Tentukan Juara Turnamen");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan25 = sc.nextInt();
            sc.nextLine();

            switch (pilihan25) {
                case 1:
                    for (int i25 = 0; i25 < 4; i25++) {
                        System.out.print("Masukkan nama tim ke-" + (i25 + 1) + ": ");
                        namaTim25[i25] = sc.nextLine();

                        System.out.print("Masukkan skor " + namaTim25[i25] + " untuk Level 1: ");
                        skor25[i25][0] = sc.nextInt();

                        System.out.print("Masukkan skor " + namaTim25[i25] + " untuk Level 2: ");
                        skor25[i25][1] = sc.nextInt();
                        sc.nextLine();

                        totalSkor25[i25] = skor25[i25][0] + skor25[i25][1];

                        if (skor25[i25][0] > 50 && skor25[i25][1] > 50) {
                            totalSkor25[i25] += bonusBuff25;
                        }

                        if (totalSkor25[i25] % 2 == 0) {
                            totalSkor25[i25] -= 15;
                        }
                    }
                    dataInputted25 = true;
                    System.out.println("Data skor berhasil dimasukkan!");
                    break;

                case 2:
                    if (!dataInputted25) {
                        System.out.println("Data belum dimasukkan. Pilih menu 1 terlebih dahulu.");
                    } else {
                        System.out.println("\nNama Tim     Level 1   Level 2   Total Skor");
                        System.out.println("--------------------------------------------");
                        for (int i25 = 0; i25 < 4; i25++) {
                            System.out.printf("%-12s %-9d %-9d %-9d\n", namaTim25[i25], skor25[i25][0], skor25[i25][1], totalSkor25[i25]);
                        }
                    }
                    break;

                case 3:
                    if (!dataInputted25) {
                        System.out.println("Data belum dimasukkan. Pilih menu 1 terlebih dahulu.");
                    } else {
                        int maxSkor25 = totalSkor25[0];
                        int indexJuara25 = 0;
                        boolean seri25 = false;

                        for (int i25 = 1; i25 < 4; i25++) {
                            if (totalSkor25[i25] > maxSkor25) {
                                maxSkor25 = totalSkor25[i25];
                                indexJuara25 = i25;
                                seri25 = false;
                            } else if (totalSkor25[i25] == maxSkor25) {
                                seri25 = true;
                            }
                        }

                        if (seri25) {
                            int maxLeve25 = skor25[0][1];
                            int indexLeve25 = 0;

                            for (int i25 = 1; i25 < 4; i25++) {
                                if (totalSkor25[i25] == maxSkor25 && skor25[i25][1] > maxLeve25) {
                                    maxLeve25 = skor25[i25][1];
                                    indexLeve25 = i25;
                                }
                            }

                            System.out.println("Selamat kepada Tim berakhir seri " + namaTim25[indexLeve25] + " tim terbaik adalah YANUAR!");
                        } else {
                            System.out.println("Selamat kepada Tim " + namaTim25[indexJuara25] + " yang telah memenangkan kompetisi!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    System.out.println("Kode diselesaikan oleh NIM: 244107060016");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 1-4.");
            }
        } while (pilihan25 != 4);

        sc.close();
    }
}
