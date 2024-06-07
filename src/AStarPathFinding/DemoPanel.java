package AStarPathFinding;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import static java.util.Collections.checkedList;
import javax.swing.JPanel;

public class DemoPanel extends JPanel {

    //pengaturan layar
    final int maxCol = 18; //konstanta bernama maxCol dengan tipe data int dengan nilai 18
    final int maxRow = 9; //konstanta bernama maxRow dengan tipe data int dengan nilai 9
    final int nodeSize = 70; // konstanta bernama nodeSize dengan tipe data int dengan nilai 70
    final int screenWidth = nodeSize * maxCol; //konstanta bernama screenWidth dengan tipe data int dan nilainya hasil perkalian antara nilai dari konstanta nodeSize dan maxCol
    final int screenHeight = nodeSize * maxRow; // konstanta bernama screenHeight dengan tipe data int dan nilainya adalah hasil perkalian antara nilai dari konstanta nodeSize dan maxRow

    //node
    Node[][] node = new Node[maxCol][maxRow];//mendeklarasikan sebuah array dua dimensi bernama node dengan tipe data Node. Memiliki ukuran maxCol kolom dan maxRow baris
    Node startNode, goalNode, currentNode; //mendeklarasikan tiga variabel bernama startNode, goalNode, dan currentNode dari tipe data Node
    ArrayList<Node> openList = new ArrayList<>(); //mendeklarasikan sebuah array list bernama openList dengan tipe data Node yang digunakan untuk menyimpan daftar node yang masih terbuka 
    ArrayList<Node> checkedList = new ArrayList<>(); //mendeklarasikan sebuah array list bernama checkList dengan tipe data Node yang digunakan untuk menyimpan daftar node yang telah diperiksa

    //others
    boolean goalReached = false; //variabel bernama goalReached dengan nilai awal false yang digunakan untuk menyimpan status apakah node tujuan telah tercapai atau belum
    int step = 0;//variabel integer bernama step dengan nilai awal 0 yang digunakan untuk menyimpan julah langkah yang telah diambil untuk mencapai node tujuan

    public DemoPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));//digunakan unutk mengatur ukuran panel 
        this.setBackground(Color.black);//digunakan untuk mengatur warna latar belakang panel yang diatur menjadi hitam
        this.setLayout(new GridLayout(maxRow, maxCol));//digunakan unutk mengatur tata letak panel akan diatur menjadi tata letak grid dengan jumlah baris dan kolom
        this.addKeyListener(new KeyHandler(this));//digunakan untuk menangani input keyboard
        this.setFocusable(true);//digunakan untuk mengatur apakah panel dapat menerima fokus keyboard atau tidak

        //tempat node
        int col = 0;//variabel integer bernama col dengan nilai awal 0 untuk menyimpan kolom saat ini
        int row = 0;//variabel integer bernama row dengan nilai awal 0 yang digunakan untuk menyimpan baris saat ini

        while (col < maxCol && row < maxRow) {//digunakan untuk melakukan perulangan selama kolom masih kurang dari jumlah kolom maksimum dan baris masih kurnag dari jumlah baris maksimum
            node[col][row] = new Node(col, row);//digunakan untuk membuat objek Node baru dengan posisi kolom col dan baris row
            this.add(node[col][row]); //digunakan untuk menambahkan objek Node baru ke panel
            col++; //digunakan untuk menambah nilai kolom sebesar 1
            //digunakan untuk mengaturulang nilai kolom menjadi 0 jika kolom telah mencapai batas maksimum. Kolom kemudian akan diganti dengan baris berikutnya
            if (col == maxCol) {
                col = 0; //digunakan untuk mengatur nilai kolom menjadi 0
                row++;
            }
        }

        //set start and goal node
        setStartNode(0, 0);
        setGoalNode(17, 7);

        // place solid node
        setSolidNode(2, 0);
        setSolidNode(3, 0);
        setSolidNode(4, 0);
        setSolidNode(5, 0);
        setSolidNode(6, 0);
        setSolidNode(7, 0);
        setSolidNode(8, 0);
        setSolidNode(9, 0);
        setSolidNode(10, 0);
        setSolidNode(11, 0);
        setSolidNode(12, 0);
        setSolidNode(13, 0);
        setSolidNode(14, 0);
        setSolidNode(15, 0);
        setSolidNode(16, 0);
        setSolidNode(17, 0);
        setSolidNode(4, 1);
        setSolidNode(5, 1);
        setSolidNode(6, 1);
        setSolidNode(7, 1);
        setSolidNode(8, 1);
        setSolidNode(9, 1);
        setSolidNode(10, 1);
        setSolidNode(11, 1);
        setSolidNode(12, 1);
        setSolidNode(13, 1);
        setSolidNode(14, 1);
        setSolidNode(15, 1);
        setSolidNode(16, 1);
        setSolidNode(17, 1);
        setSolidNode(5, 2);
        setSolidNode(6, 2);
        setSolidNode(7, 2);
        setSolidNode(8, 2);
        setSolidNode(9, 2);
        setSolidNode(10, 2);
        setSolidNode(11, 2);
        setSolidNode(12, 2);
        setSolidNode(13, 2);
        setSolidNode(14, 2);
        setSolidNode(15, 2);
        setSolidNode(16, 2);
        setSolidNode(17, 2);
        setSolidNode(9, 3);
        setSolidNode(10, 3);
        setSolidNode(11, 3);
        setSolidNode(12, 3);
        setSolidNode(13, 3);
        setSolidNode(14, 3);
        setSolidNode(15, 3);
        setSolidNode(16, 3);
        setSolidNode(17, 3);
        setSolidNode(0, 4);
        setSolidNode(1, 4);
        setSolidNode(2, 4);
        setSolidNode(3, 4);
        setSolidNode(4, 4);
        setSolidNode(5, 4);
        setSolidNode(13, 4);
        setSolidNode(14, 4);
        setSolidNode(15, 4);
        setSolidNode(16, 4);
        setSolidNode(17, 4);
        setSolidNode(0, 5);
        setSolidNode(1, 5);
        setSolidNode(2, 5);
        setSolidNode(3, 5);
        setSolidNode(4, 5);
        setSolidNode(5, 5);
        setSolidNode(6, 5);
        setSolidNode(11, 5);
        setSolidNode(14, 5);
        setSolidNode(15, 5);
        setSolidNode(16, 5);
        setSolidNode(17, 5);
        setSolidNode(0, 6);
        setSolidNode(1, 6);
        setSolidNode(2, 6);
        setSolidNode(3, 6);
        setSolidNode(4, 6);
        setSolidNode(5, 6);
        setSolidNode(6, 6);
        setSolidNode(7, 6);
        setSolidNode(8, 6);
        setSolidNode(9, 6);
        setSolidNode(16, 6);
        setSolidNode(17, 6);
        setSolidNode(0, 7);
        setSolidNode(1, 7);
        setSolidNode(2, 7);
        setSolidNode(3, 7);
        setSolidNode(4, 7);
        setSolidNode(5, 7);
        setSolidNode(6, 7);
        setSolidNode(7, 7);
        setSolidNode(8, 7);
        setSolidNode(9, 7);
        setSolidNode(10, 7);
        setSolidNode(11, 7);
        setSolidNode(12, 7);
        setSolidNode(13, 7);
        setSolidNode(14, 7);
        setSolidNode(0, 8);
        setSolidNode(1, 8);
        setSolidNode(2, 8);
        setSolidNode(3, 8);
        setSolidNode(4, 8);
        setSolidNode(5, 8);
        setSolidNode(6, 8);
        setSolidNode(7, 8);
        setSolidNode(8, 8);
        setSolidNode(9, 8);
        setSolidNode(10, 8);
        setSolidNode(11, 8);
        setSolidNode(12, 8);
        setSolidNode(13, 8);
        setSolidNode(14, 8);
        setSolidNode(15, 8);
        setSolidNode(16, 8);
        setSolidNode(17, 8);
 
        //set cost
        setCostOnNode();
    }

    private void setStartNode(int col, int row) {
        node[col][row].setAsStart();//digunakan untuk
        startNode = node[col][row];
        currentNode = startNode;
    }

    private void setGoalNode(int col, int row) {
        node[col][row].setAsGoal();
        goalNode = node[col][row];
    }

    private void setSolidNode(int col, int row) {
        node[col][row].setAsSolid();
    }

    private void setCostOnNode() {
        int col = 0;
        int row = 0;

        while (col < maxCol && row < maxRow) {
            getCost(node[col][row]);
            col++;
            if (col == maxCol) {
                col = 0;
                row++;
            }
        }
    }

    private void getCost(Node node) {

        //get G Cost (The distance from the start node)
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;

        //get H Cost )The distace from the goal node)
        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        //get F Cost (The total cost)
        node.fCost = node.gCost + node.hCost;

        //display the cost on node
        if (node != startNode && node != goalNode) {
            node.setText("<html>F: " + node.fCost + "<br>G: " + node.gCost + "</html>");
        }
    }

    public void search() {
        if (goalReached == false && step < 300) {
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);

            //open the up node
            if (row - 1 >= 0) {
                openNode(node[col][row - 1]);
            }
            //open the left node
            if (col - 1 >= 0) {
                openNode(node[col - 1][row]);
            }
            //open the down node
            if (row + 1 < maxRow) {
                openNode(node[col][row + 1]);
            }
            //open the right node
            if (col + 1 < maxCol) {
                openNode(node[col + 1][row]);
            }

            //find the best node
            int bestNodeIndex = 0;
            int bestNodefCost = 999;

            for (int i = 0; i < openList.size(); i++) {

                //check if this node Fcost is better
                if (openList.get(i).fCost < bestNodefCost) {
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                } //if F cost is equal, check the G cost
                else if (openList.get(i).fCost == bestNodefCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;
                    }
                }

            }

            //after the loop, we get the bes node which is our next step
            currentNode = openList.get(bestNodeIndex);
            if (currentNode == goalNode) {
                goalReached = true;
            }
        }
        step++;
    }

    public void autosearch() {
        while (goalReached == false) {
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);

            //open the up node
            if (row - 1 >= 0) {
                openNode(node[col][row - 1]);
            }
            //open the left node
            if (col - 1 >= 0) {
                openNode(node[col - 1][row]);
            }
            //open the down node
            if (row + 1 < maxRow) {
                openNode(node[col][row + 1]);
            }
            //open the right node
            if (col + 1 < maxCol) {
                openNode(node[col + 1][row]);
            }

            //find the best node
            int bestNodeIndex = 0;
            int bestNodefCost = 999;

            for (int i = 0; i < openList.size(); i++) {

                //check if this node Fcost is better
                if (openList.get(i).fCost < bestNodefCost) {
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                } //if F cost is equal, check the G cost
                else if (openList.get(i).fCost == bestNodefCost) {
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost) {
                        bestNodeIndex = i;
                    }
                }

            }

            //after the loop, we get the bes node which is our next step
            currentNode = openList.get(bestNodeIndex);

            if (currentNode == goalNode) {
                goalReached = true;
                trackThePath();
            }
        }
    }

    private void openNode(Node node) {
        if (node.open == false && node.checked == false && node.solid == false) {

            //if the node is not opened yet, add it to the open list
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }

    private void trackThePath() {
        Node current = goalNode;

        while (current != startNode) {

            current = current.parent;

            if (current != startNode) {
                current.setAsPath();
            }
        }
    }

}
