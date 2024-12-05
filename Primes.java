public class Primes {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Primes <n>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        if (n < 2) {
            System.out.println("There are no prime numbers less than 2.");
            return;
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
            p++;
        }

        System.out.println("Prime numbers up to " + n + ":");
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                primeCount++;
            }
        }

        double percentage = (primeCount * 100.0) / n;
        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + String.format("%.0f", percentage) + "% are primes)");
    }
}