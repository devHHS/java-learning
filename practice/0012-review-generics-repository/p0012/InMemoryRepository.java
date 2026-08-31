package p0012;

import java.util.HashMap;
import java.util.Map;

/**
 * 메모리에서 데이터를 저장하고 조회하는 간단한 Repository.
 *
 * <p>
 * T는 저장할 entity의 타입이고,
 * ID는 entity를 식별하기 위한 ID의 타입이다.
 * </p>
 *
 * <p>
 * 예:
 * InMemoryRepository<Member, Long>
 * -> T = Member
 * -> ID = Long
 * -> 내부 저장 구조는 Map<Long, Member>
 * </p>
 *
 * @param <T> 저장할 entity 타입
 * @param <ID> entity의 ID 타입
 */
public class InMemoryRepository<T, ID> {

    /**
     * ID를 key로, entity를 value로 저장한다.
     *
     * <p>
     * 예:
     * InMemoryRepository<Member, Long>인 경우
     * Map<Long, Member>와 같은 구조가 된다.
     * </p>
     */
    private final Map<ID, T> store;

    /**
     * 빈 Repository를 생성한다.
     *
     * <p>
     * 객체가 생성될 때 내부 저장소로 사용할
     * HashMap을 초기화한다.
     * </p>
     */
    public InMemoryRepository() {
        this.store = new HashMap<>();
    }

    /**
     * 전달받은 ID를 key로 entity를 저장한다.
     *
     * <p>
     * 클래스 자체가 이미 {@code <T, ID>}를 가지고 있으므로
     * 메서드 앞에서 {@code <T>}를 다시 선언하지 않는다.
     * </p>
     *
     * @param id entity를 식별하기 위한 ID
     * @param entity 저장할 객체
     * @return 저장한 entity
     */
    public T save(ID id, T entity) {
        store.put(id, entity);
        return entity;
    }

    /**
     * 전달받은 ID에 해당하는 entity를 조회한다.
     *
     * <p>
     * {@link Map#get(Object)}은 해당 key가 존재하지 않으면
     * null을 반환하므로 별도의 예외 처리는 하지 않는다.
     * </p>
     *
     * @param id 조회할 entity의 ID
     * @return 해당 ID의 entity, 존재하지 않으면 null
     */
    public T findById(ID id) {
        return store.get(id);
    }

    /**
     * 전달받은 ID에 해당하는 entity를 삭제한다.
     *
     * <p>
     * 삭제 전에 {@link Map#containsKey(Object)}로
     * 해당 ID가 실제로 존재했는지 확인한다.
     * </p>
     *
     * <p>
     * {@code store.remove(id) != null}을 사용하지 않는 이유는
     * Map의 value가 null일 수도 있기 때문이다.
     * 따라서 key의 존재 여부를 확인하는 것이 더 정확하다.
     * </p>
     *
     * @param id 삭제할 entity의 ID
     * @return 삭제 전에 해당 ID가 존재했다면 true, 아니면 false
     */
    public boolean deleteById(ID id) {
        boolean existed = store.containsKey(id);
        store.remove(id);
        return existed;
    }

    /**
     * 현재 저장된 entity의 개수를 반환한다.
     *
     * @return 현재 저장된 데이터 개수
     */
    public int count() {
        return store.size();
    }
}