

        int temp, i,unsortedValue;

        // insertion
        if (low < x.length) {
            temp = low;
            unsortedValue = x[temp];

            while ( temp > 0 && x[temp-1] > unsortedValue) {


                x[temp] = x[temp-1];


                temp--;

            }

            x[temp] = unsortedValue;
            insertionr(x, low+1);
        } // end if
}// end insertionr


