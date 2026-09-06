class FoodRatings {
    HashMap<String, String> foodCuisine = new HashMap<>();
    HashMap<String, Integer> foodRating = new HashMap<>();
    HashMap<String, PriorityQueue<Food>> cuisineFoods = new HashMap<>();
    class Food {
        String name;
        int rating;
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);
            cuisineFoods.putIfAbsent(
                cuisines[i],
                new PriorityQueue<>((a, b) -> {
                    if (a.rating != b.rating) {
                        return b.rating - a.rating;
                    }
                    return a.name.compareTo(b.name);
                })
            );
            cuisineFoods.get(cuisines[i])
                        .offer(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);
        String cuisine = foodCuisine.get(food);
        cuisineFoods.get(cuisine)
                    .offer(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineFoods.get(cuisine);
        while (true) {
            Food top = pq.peek();
            if (foodRating.get(top.name) == top.rating) {
                return top.name;
            }
            pq.poll();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */