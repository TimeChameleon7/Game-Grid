class Grid{
    private final int GRIDSIZE = 10;
    final Point point = new Point();
    private boolean border = true;//changing this also flips the color scheme on the grid

    String getGrid(){
        StringBuilder grid = new StringBuilder("<html>");
        for(int y=1;y<=GRIDSIZE;y++){
            for(int x=1;x<=GRIDSIZE;x++) {
                if (border){
                    if (y == point.y && x == point.x) {
                        grid.append('\u25A0');
                    } else {
                        grid.append('\u25A1');
                    }
                }else{
                    if (y == point.y && x == point.x) {
                        grid.append('\u25A1');
                    } else {
                        grid.append('\u25A0');
                    }
                }
            }
            grid.append("<BR>");
        }
        grid.append("</html>");
        return grid.toString();
    }

    /**
     * Flips the boolean border when called
     */
    void toggleBorder(){
        border = !border;
    }

    class Point{
        //(1,1) is the top left corner of the grid
        private int x=1,y=1;

        /**
         * moves the point based on classic WASD controls
         * @param ch character input
         */
        void move(int ch) {
            switch (ch) {
                case 87:
                    if (y > 1) {
                        y--;
                    } else if (!border) {
                        y = GRIDSIZE;
                    }
                    break;
                case 83:
                    if (y < GRIDSIZE) {
                        y++;
                    }else if(!border){
                        y = 1;
                    }
                    break;
                case 65:
                    if (x > 1) {
                        x--;
                    }else if(!border){
                        x = GRIDSIZE;
                    }
                    break;
                case 68:
                    if (x < GRIDSIZE) {
                        x++;
                    }else if(!border){
                        x = 1;
                    }
                    break;
                case 82:
                    x = (int)(Math.random()*10)+1;
                    y = (int)(Math.random()*10)+1;
            }
        }

        String getCoords(){
            return "("+x+","+y+")";
        }
    }
}