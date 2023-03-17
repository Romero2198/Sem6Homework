package sem6Homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class waveAlgorithm {
    public static void main(String[] args) {
        int[][] map = {
                {-1,-1,-1,-1,-1,-1,-1,-1},
                {-1, 0, 0, 0,-1, 0, 0,-1},
                {-1, 0,-1, 0, 0, 0, 0,-1},
                {-1, 0,-1, 0, 0,-1, 0,-1},
                {-1, 0,-1, 0,-1, 0,-2,-1},
                {-1, 0,-1, 0, 0, 0,-1,-1},
                {-1, 0, 0, 0, 0, 0, 0,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1},
        };
        printMapConsole(map);
        printMapConsole(searchWay(map, new Point(1, 1, 1)));
    }
    public static void printMapConsole(int[][] map) {
        for(int[] points : map) {
            for(int point : points) {
                StringBuilder sb = new StringBuilder();
                if(point == -1)sb.append("||||");
                else if(point == -2) sb.append("####");
                else if(point == 0) sb.append("    ");
                else if(point > 9) sb.append(" " + point + " ");
                else sb.append("  "+ point + " ");
                System.out.print(sb);
            }
            System.out.println("");
        }
        System.out.println();
    }
    public static int[][] searchWay(int[][] map, Point start) {
        int[][] result = map.clone();
        Deque<Point> buffer = new ArrayDeque<>();
        Point current = new Point(start.X, start.Y, start.number);
        buffer.add(current);
        result[current.Y][current.X] = 1;
        while (true){
            if(result[current.Y - 1][current.X] == 0) {
                result[current.Y - 1][current.X] = current.number + 1;
                buffer.addLast(new Point(current.X, current.Y - 1, current.number + 1));
            } else if (result[current.Y][current.X + 1] == 0) {
                result[current.Y][current.X + 1] = current.number + 1;
                buffer.addLast(new Point(current.X + 1, current.Y, current.number + 1));
            } else if (result[current.Y + 1][current.X] == 0) {
                result[current.Y + 1][current.X] = current.number + 1;
                buffer.addLast(new Point(current.X, current.Y + 1, current.number + 1));
            } else if (result[current.Y][current.X - 1] == 0) {
                result[current.Y][current.X - 1] = current.number + 1;
            } else{
                if (buffer.peek() != null) current = buffer.pop();
                else break;
            }
        }
        return result;
    }
}