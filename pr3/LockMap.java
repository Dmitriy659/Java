package pr3;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMap<T, E> implements Map<T, E> {
    private static final Lock lock = new ReentrantLock();
    private Map<T, E> map;

    LockMap(Map<T, E> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public E get(Object key) {
        return map.get(key);
    }

    @Override
    public E put(T key, E value) {
        lock.lock();
        var res = map.put(key, value);
        lock.unlock();
        return res;
    }

    @Override
    public E remove(Object key) {
        lock.lock();
        var res = map.remove(key);
        lock.unlock();
        return res;
    }

    @Override
    public void putAll(Map<? extends T, ? extends E> m) {
        lock.lock();
        map.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        map.clear();
        lock.unlock();
    }

    @Override
    public Set<T> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<E> values() {
        return map.values();
    }

    @Override
    public Set<Entry<T, E>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String toString() {
        return "LockMap: " + map;
    }
}
