
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class CollectionUtils {


    private CollectionUtils() {
    }


    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> result = new ArrayList<E>();
        for(E e: elements){
            if(filter.test(e)){
                result.add(e);
            }
        }
        return result;
    }


    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for(E e:elements){
            if(predicate.test(e)){
                return true;
            }
        }
        return false;
    }


    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for(E e:elements){
            if (!predicate.test(e)){
                return false;
            }
        }
        return true;
    }


    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        for(E e:elements){
            if(predicate.test(e)) return false;
        }
        return true;
    }


    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        List<R> result=new ArrayList<R>();
        for (T e:elements){
            result .add(mappingFunction.apply(e));
        }
        return result;
    }


    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        if(elements.size()==0) return Optional.empty();
        E result = elements.get(0);
        for(E e:elements){
            result = comparator.compare(result,e)>0 ? result:e;
        }
        return Optional.of(result);
    }


    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        if(elements.size()==0) return Optional.empty();
        E result = elements.get(0);
        for(E e:elements){
            result = comparator.compare(result,e)<0 ? result:e;
        }
        return Optional.of(result);
    }


    public static <E> List<E> distinct(List<E> elements) {
        Set<E> set = new HashSet<E>();
        for(E e:elements){
            set.add(e);
        }
        List<E> result = new ArrayList<E>();
        result.addAll(set);
        return result;
    }


    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
       for(E e:elements){
           consumer.accept(e);
       }
    }


    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        if(elements.size()==0) return Optional.empty();
        E result = elements.get(0);
        for (int i =1;i<elements.size();i++){
            result = accumulator.apply(result,elements.get(i));
        }
        return Optional.of(result);
    }


    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        for(E e: elements){
            seed = accumulator.apply(seed,e);
        }
        return seed;
    }


    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {

        List<E> trueKeyList = new ArrayList<E>();
        List<E> falseKeyList = new ArrayList<E>();
        for(E e:elements){
            if(predicate.test(e)) trueKeyList.add(e);
                else falseKeyList.add(e);
        }
        Map<Boolean,List<E>> result = new HashMap<>();
        result.put(true,trueKeyList);
        result.put(false,falseKeyList);
        return result;
    }


    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        Map<K,List<T>> result = new HashMap<K, List<T>>();
        for(T e:elements) {
            K key = classifier.apply(e);
            if(result.containsKey(key)){
                result.get(key).add(e);
            }
            else{
                List<T> subList = new ArrayList<T>();
                subList.add(e);
                result.put(key,subList);
            }
        }

        return result;
    }


    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {
        Map<K,U> map = new HashMap<K, U>();
        for(T e: elements){
            U value = valueFunction.apply(e);
            K key = keyFunction.apply(e);
            if(map.containsKey(key)){
                map.put(key,mergeFunction.apply(map.get(key),value));
            }else
            map.put(key,value);
        }

        return map;
    }
}
