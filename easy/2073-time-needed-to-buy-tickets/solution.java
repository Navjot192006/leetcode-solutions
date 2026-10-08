class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> queue = new LinkedList<>();

        // Add all persons to queue
        for (int i = 0; i < tickets.length; i++) {
            queue.add(i);
        }

        int time = 0;

        while (!queue.isEmpty()) {

            int person = queue.poll();

            tickets[person]--;
            time++;

            // Person k bought the last ticket
            if (person == k && tickets[person] == 0) {
                return time;
            }

            // If tickets are still remaining,
            // put the person back in queue
            if (tickets[person] > 0) {
                queue.add(person);
            }
        }

        return time;
    }
}