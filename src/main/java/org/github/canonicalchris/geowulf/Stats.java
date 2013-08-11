/*
 * (C) 2013 by the Geowulf Project
 */
package org.github.canonicalchris.geowulf;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author rck
 * @date August 2013
 */
public class Stats {

    final static public class Entry {

        private Entry(int age, long male, long female) {
            this.age = age;
            this.male = male;
            this.female = female;
        }

        public int age() {
            return age;
        }

        public long male() {
            return male;
        }

        public long female() {
            return female;
        }
        final private int age;
        final private long male;
        final private long female;
    }
    /**
     * the raw interpolated data for the age pyramid
     */
    final static private List<Entry> rawData = Collections.unmodifiableList(Arrays.asList(new Entry[]{new Entry(0, 14302812, 13924439),
        new Entry(1, 13650732, 13349753),
        new Entry(2, 13265305, 12989574),
        new Entry(3, 12984924, 12724805),
        new Entry(4, 12742528, 12494139),
        new Entry(5, 12497677, 12260182),
        new Entry(6, 12271653, 12043148),
        new Entry(7, 12055198, 11835193),
        new Entry(8, 11845672, 11632057),
        new Entry(9, 11611990, 11406098),
        new Entry(10, 11404354, 11207800),
        new Entry(11, 11207329, 11024114),
        new Entry(12, 10967402, 10806485),
        new Entry(13, 10698048, 10569064),
        new Entry(14, 10419804, 10332209),
        new Entry(15, 10138841, 10102519),
        new Entry(16, 9813058, 9835332),
        new Entry(17, 9475211, 9561608),
        new Entry(18, 9168826, 9310510),
        new Entry(19, 8891302, 9080100),
        new Entry(20, 8631635, 8869057),
        new Entry(21, 8384089, 8679297),
        new Entry(22, 8119597, 8458179),
        new Entry(23, 7835225, 8191694),
        new Entry(24, 7557640, 7932177),
        new Entry(25, 7316546, 7697263),
        new Entry(26, 7044459, 7424637),
        new Entry(27, 6787676, 7156252),
        new Entry(28, 6586030, 6930099),
        new Entry(29, 6435155, 6740746),
        new Entry(30, 6279311, 6543696),
        new Entry(31, 6105502, 6325167),
        new Entry(32, 5899898, 6086900),
        new Entry(33, 5669541, 5847756),
        new Entry(34, 5466435, 5651305),
        new Entry(35, 5276850, 5468996),
        new Entry(36, 5129395, 5237992),
        new Entry(37, 4962066, 5062054),
        new Entry(38, 4788627, 4882216),
        new Entry(39, 4574596, 4668650),
        new Entry(40, 4343689, 4437676),
        new Entry(41, 4148977, 4229637),
        new Entry(42, 3963995, 4053945),
        new Entry(43, 3801477, 3897644),
        new Entry(44, 3639270, 3754075),
        new Entry(45, 3485476, 3626562),
        new Entry(46, 3367547, 3545397),
        new Entry(47, 3277021, 3445407),
        new Entry(48, 3175275, 3338857),
        new Entry(49, 3078915, 3230349),
        new Entry(50, 2990034, 3130679),
        new Entry(51, 2847498, 3008399),
        new Entry(52, 2674123, 2867723),
        new Entry(53, 2514143, 2736215),
        new Entry(54, 2354954, 2599381),
        new Entry(55, 2210042, 2469340),
        new Entry(56, 2092067, 2347941),
        new Entry(57, 2007820, 2248503),
        new Entry(58, 1922194, 2138496),
        new Entry(59, 1837823, 2034993),
        new Entry(60, 1753420, 1930482),
        new Entry(61, 1657779, 1828470),
        new Entry(62, 1562544, 1734156),
        new Entry(63, 1467619, 1638868),
        new Entry(64, 1378172, 1549001),
        new Entry(65, 1293482, 1462647),
        new Entry(66, 1214462, 1398883),
        new Entry(67, 1138523, 1318727),
        new Entry(68, 1061304, 1237733),
        new Entry(69, 984549, 1155471),
        new Entry(70, 912197, 1078932),
        new Entry(71, 842664, 1003423),
        new Entry(72, 774144, 929953),
        new Entry(73, 707673, 855887),
        new Entry(74, 642767, 784361),
        new Entry(75, 580964, 713169),
        new Entry(76, 518458, 644635),
        new Entry(77, 461044, 579211),
        new Entry(78, 405366, 515343),
        new Entry(79, 352333, 454514),
        new Entry(80, 302217, 396115),
        new Entry(81, 255225, 340917),
        new Entry(82, 213271, 289774),
        new Entry(83, 175736, 243145),
        new Entry(84, 141819, 200271),
        new Entry(85, 71281, 105508),
        new Entry(86, 71281, 105508),
        new Entry(87, 71281, 105508),
        new Entry(88, 71281, 105508),
        new Entry(89, 71281, 105508),
        new Entry(90, 14119, 23136),
        new Entry(91, 14119, 23136),
        new Entry(92, 14119, 23136),
        new Entry(93, 14119, 23136),
        new Entry(94, 14119, 23136),
        new Entry(95, 1488, 2726),
        new Entry(96, 1488, 2726),
        new Entry(97, 1488, 2726),
        new Entry(98, 1488, 2726),
        new Entry(99, 1488, 2726),
        new Entry(100, 393, 780)
    }));

    public interface CountGetter {

        public long getCount(Entry e);
    }
    final static public CountGetter GUY_GETTER = new CountGetter() {
        public long getCount(Entry e) {
            return e.male();
        }
    };
    final static public CountGetter GAL_GETTER = new CountGetter() {
        public long getCount(Entry e) {
            return e.female();
        }
    };

    /**
     * determine the total number of occurrences for one slice of the population
     * @param data List<Entry> list to iterate over
     * @param getter CountGetter the access method
     * @return 
     */
    static private long populationCount(List<Entry> data, CountGetter getter) {
        long curr = 0L;
        for (final Entry e : data) {
            curr += getter.getCount(e);
        }
        return curr;
    }
    
    static private List<Long> cummulativeCounts(List<Entry> data, CountGetter getter) {
        final List<Long> cumul = new ArrayList<Long>(data.size());
        long curr = 0L;
        for (final Entry e : data) {
            curr += getter.getCount(e);
            cumul.add(curr);
        }
        return Collections.unmodifiableList(cumul);
    }
    
    /**
     * base counts
     */
    final static public long ALL_MALES = populationCount(rawData, GUY_GETTER);
    final static public long ALL_FEMALES = populationCount(rawData, GAL_GETTER);
    
    final static public double PERCENTAGE_MALE = ((double)ALL_MALES)/(ALL_MALES + ALL_FEMALES);
    final static public double PERCENTAGE_FEMALE = 1.0d - PERCENTAGE_MALE;
    
    final static public List<Long> CUMUL_MALES = cummulativeCounts(rawData, GUY_GETTER);
    final static public List<Long> CUMUL_FEMALES = cummulativeCounts(rawData, GAL_GETTER);
    
    static public int lifeExpectancy(Random r, long max, List<Long> cumul) {
        long guess = ((long)(max * r.nextDouble()));
        final int index = Collections.binarySearch(cumul, guess);
        if (index > -1) {
          return index;
        } else {
          return Math.abs(1 + index); 
        }
    }
    
    static public boolean isMale(Random r) {
        return (r.nextDouble() <= PERCENTAGE_MALE);
    }
    
    static public int maleLifeExpectancy(Random r) {
        return lifeExpectancy(r, ALL_MALES, CUMUL_MALES);
    }
    
    static public int femaleLifeExpectancy(Random r) {
        return lifeExpectancy(r, ALL_FEMALES, CUMUL_FEMALES);
    }
    
}
