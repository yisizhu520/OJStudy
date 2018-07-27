import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Maze {


    public static void main(String[] args) {
        String command = "3 3\n" +
                "0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1";
        Maze maze = Maze.create(command);
        System.out.println("done");
    }

    static class Cell {
        private int row;
        private int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Link {
        private Cell cell1;
        private Cell cell2;

        Link(Cell[] cells) {
            this.cell1 = cells[0];
            this.cell2 = cells[1];
        }
    }

    public static Maze create(String command) {
        Scanner scanner = new Scanner(command);
        Maze maze = new Maze();
        try {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row <= 0 || col <= 0) {
                System.out.println("Invalid number format.");
            }
            scanner.nextLine();
            scanner.useDelimiter(";");
            List<Link> links = new ArrayList<>();
            while (scanner.hasNext()) {
                String linkStr = scanner.next();
                String[] cellStr = linkStr.split(" ");
                if (cellStr.length != 2) {
                    System.out.print("Incorrect command format.");
                    return null;
                }
                Cell[] cells = new Cell[2];
                for (int i = 0; i < cellStr.length; i++) {
                    String[] cellPoint = cellStr[i].split(",");
                    if (cellPoint.length != 2) {
                        System.out.print("Incorrect command format.");
                        return null;
                    }
                    int x = Integer.parseInt(cellPoint[0]);
                    int y = Integer.parseInt(cellPoint[1]);
                    if (x < 0 || x >= row) {
                        System.out.print("Number out of range.");
                        return null;
                    }
                    if (y < 0 || y >= col) {
                        System.out.print("Number out of range.");
                        return null;
                    }
                    Cell cell = new Cell(x, y);
                    cells[i] = cell;
                }
                Link link = new Link(cells);
                links.add(link);
                if (!maze.checkLinksValid(links)) {
                    System.out.print("Maze format error.");
                    return null;
                }
            }
            System.out.println();
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.print("Invalid number format.");
            return null;
        }
        return maze;
    }

    private boolean checkLinksValid(List<Link> links) {
        for (Link link : links) {
            if (!checkCellLinkValid(link.cell1, link.cell2)) {
                return false;
            }
        }
        return true;
    }


    private boolean checkCellLinkValid(Cell cell1, Cell cell2) {
        // cell can only link to cell of four adjacent directions
        if (cell1.row == cell2.row && Math.abs(cell1.col - cell2.col) == 1) {
            return true;
        }
        if (cell1.col == cell2.col && Math.abs(cell1.row - cell2.row) == 1) {
            return true;
        }
        return false;
    }

    public String render() {
        return null;
    }


}
