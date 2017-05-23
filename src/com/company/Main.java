package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int i = 0;i < cases; i++){
            int contestants = scanner.nextInt();
            if(contestants == 0){
                System.out.println(0);
                continue;
            }

            int[] skillLevels = new int[contestants];
            for(int x = 0; x < skillLevels.length;x++){
                skillLevels[x] = scanner.nextInt();
            }



            //first, sort the list
            Arrays.sort(skillLevels);

            //make a heatmap?
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int x : skillLevels){
                if(map.containsKey(x)){
                    map.put(x, map.get(x) + 1);
                }else{
                    map.put(x, 1);
                }
            }

            //then, loop through the list, and if there is a gap between the current and the previous
            // Or they are the same, make a new team
            int smallestTeam = contestants;
            int teamCount = 1;

            //start at the second to last
            for(int x = skillLevels.length - 2; x >= 0; x--){
                int currentPos = skillLevels[x];

                //Either we have a larger than one gap, or they are 0. Either way, start a new team
                if (skillLevels[x + 1] - currentPos > 1 || skillLevels[x + 1] - currentPos == 0){
                    if(teamCount < smallestTeam){
                        smallestTeam = teamCount;
                    }
                    teamCount = 0;
                }
                teamCount += 1;
            }
            if(teamCount < smallestTeam)
                smallestTeam = teamCount;

            System.out.println(smallestTeam);
        }
    }
}
