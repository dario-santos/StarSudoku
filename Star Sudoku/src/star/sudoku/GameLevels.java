/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.sudoku;

/**
 *
 * @author dario
 */


/*
  Area 1:                  {1,2,3,4,5,6,7,8,9}
  Area 2:                  {1,2,3,4,5,6,7,8,9}
  Area 3:                  {1,2,3,4,5,6,7,8,9}
  Area 4:                  {1,2,3,4,5,6,7,8,9}
  Area 5:                  {1,2,3,4,5,6,7,8,9}
  Area 6:                  {1,2,3,4,5,6,7,8,9}
*/
public class GameLevels 
{        
        public static int[][] getInitialBoard(int index)
        {
            return new int[][]
                {
                    {0,9,0,0,2,0,7,0,1},
                    {1,0,7,0,0,0,0,8,6},
                    {0,0,5,0,2,4,0,0,7},
                    {3,9,5,0,7,0,6,0,8},
                    {3,8,9,0,2,0,4,0,7},
                    {5,0,9,0,7,0,0,4,0}
                };
        }        
        public static int[][] getSolutionBoard(int index)
        {
            return new int[][]
                {
                    {3,9,4,5,2,8,7,6,1},
                    {1,4,7,9,2,5,3,8,6},
                    {3,8,5,6,2,4,1,9,7},
                    {3,9,5,4,7,1,6,2,8},
                    {3,8,9,5,2,6,4,1,7},
                    {5,3,9,8,7,6,1,4,2}
                };
        }
}