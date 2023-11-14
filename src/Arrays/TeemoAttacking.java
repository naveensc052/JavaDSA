/*
 * Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, 
 * Ashe gets poisoned for a exactly duration seconds. More formally, an attack at second t will 
 * mean Ashe is poisoned during the inclusive time interval [t, t + duration - 1]. 
 * If Teemo attacks again before the poison effect ends, the timer for it is reset, 
 * and the poison effect will end duration seconds after the new attack.
 * You are given a non-decreasing integer array timeSeries, where timeSeries[i] 
 * denotes that Teemo attacks Ashe at second timeSeries[i], and an integer duration.
 * Return the total number of seconds that Ashe is poisoned.
 * */

package Arrays;

class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration <= 0) {
            return 0;
        }
        
        int totalDuration = 0;
        int lastAttackTime = timeSeries[0];
        
        for (int i = 1; i < timeSeries.length; i++) {
            int currentTime = timeSeries[i];
            int poisonDuration = Math.min(duration, currentTime - lastAttackTime);
            
            totalDuration += poisonDuration;
            lastAttackTime = currentTime;
        }

        totalDuration += duration;
        
        return totalDuration;
    }

    public static void main(String[] args) {
        TeemoAttacking solution = new TeemoAttacking();
        int[] timeSeries = {1, 4};
        int duration = 2;
        int result = solution.findPoisonedDuration(timeSeries, duration);
        System.out.println(result);
    }
}
