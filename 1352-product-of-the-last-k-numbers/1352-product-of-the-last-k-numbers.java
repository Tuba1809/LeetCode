class ProductOfNumbers {

    ArrayList<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {

        if (num == 0) {
            // Reset because every product containing 0 is 0
            prefix.clear();
            prefix.add(1);
        } else {
            int last = prefix.get(prefix.size() - 1);
            prefix.add(last * num);
        }
    }

    public int getProduct(int k) {

        // If k is greater than the number of
        // elements since the last zero
        if (k >= prefix.size()) {
            return 0;
        }

        int n = prefix.size();

        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */