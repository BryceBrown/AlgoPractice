package com.company.redditdailyprogrammer;

import java.util.Scanner;

/**
 * Created by fatma on 6/2/2017.
 */
public class IPV4Subnet {

    public class IpRange {

        public IpRange(int start, int stop){
            this.start = start;
            this.stop = stop;
        }

        public IpRange(String subnet){

        }

        public int start;
        public int stop;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int subnets = scanner.nextInt();



    }

}
