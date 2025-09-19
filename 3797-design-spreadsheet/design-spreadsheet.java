class Spreadsheet {
    private int[][] matrix;
    public Spreadsheet(int rows) {
        matrix=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1))-1;
        matrix[row][col]=value;
    }
    
    public void resetCell(String cell) {
        int col=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1))-1;
        matrix[row][col]=0;
    }
    
    public int getValue(String formula) {
        formula=formula.substring(1);
        String[] parts=formula.split("\\+");
        return parsePart(parts[0])+parsePart(parts[1]);
    }
    private int parsePart(String part) {
        // If the part starts with a letter, it's a cell reference
        if (Character.isLetter(part.charAt(0))) {
          int col = part.charAt(0) - 'A';
          int row = Integer.parseInt(part.substring(1)) - 1;
           return matrix[row][col];
        }else {
          // Otherwise, it's a number
          return Integer.parseInt(part);
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */