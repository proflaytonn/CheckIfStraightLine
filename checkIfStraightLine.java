public class checkIfStraightLine {
    public static void main(String[] args) {
        //Leetcode : https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}; //true
//        int[][] coordinates = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}; //false
//        int[][] coordinates = {{2,1},{4,2},{6,3}}; //true
//        int[][] coordinates = {{0,0},{0,1},{0,-1}}; // true
//        int[][] coordinates ={{1,2},{2,3},{3,5}}; //false
//        int[][] coordinates = {{1,1},{2,2},{2,0}};//false
//        int[][] coordinates = {{0,1},{2,4},{3,3}}; //false //2 3 - 1 1
//        int[][] coordinates = {{1,-8},{2,-3},{1,2}}; // false // 1 5 - 1 5

        boolean result = true;
        boolean tegakLurusKeatas = false;
        boolean tegakLurusKesamping = false;

        //double biar kalo pembagian koma" nya beda bisa result = false, kalo gk double akan sama nilainya di int
        double temp1 = 0;
        double temp2 = 0;
        double multiplyX = 0;
        double multiplyY = 0;

        for(int i = 0 ; i < coordinates.length ; i++)
        {

            for(int j = 0 ; j < coordinates[i].length-1 ; j++)
            {
                if(i>0) //cek nya langsung index 2 aja
                {
                    int diff1 = coordinates[i][j] - coordinates[i-1][j];
                    int diff2 = coordinates[i][j+1] - coordinates[i-1][j+1];

                    if(i == 1) //buat cek bentuk garis + 1x aja ceknya di i==1
                    {
                        if (diff1 == 0) {
                            tegakLurusKeatas = true;
                        } else if (diff2 == 0) {
                            tegakLurusKesamping = true;
                        }
                    }
                    //tegak lurus atas
                    if(tegakLurusKeatas)
                    {
                        if(diff1 > 0)
                        {
                            result = false;
                            break;
                        }
                    }
                    //tegak lurus samping
                    else if (tegakLurusKesamping)
                    {
                        if(diff2 > 0)
                        {
                            result = false;
                            break;
                        }
                    }
                    //bukan tegak lurus
                    else
                    {
                        if(i == 1)
                        {
                            temp1 = diff1;
                            temp2 = diff2;
                        }
                        else if(i > 1) {
                            multiplyX = diff1 / temp1;
                            multiplyY = diff2 / temp2;
                            if(multiplyX != multiplyY)
                            {
                                result = false;
                                break;
                            }
                        }
                    }
                }
            }
            if(!result) break;
        }

        System.out.println("tegak lurus keatas : "+tegakLurusKeatas);
        System.out.println("tegak lurus kesamping : "+tegakLurusKesamping);
        System.out.println(result);

    }
}
