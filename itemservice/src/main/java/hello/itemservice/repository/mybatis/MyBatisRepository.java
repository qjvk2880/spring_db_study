package hello.itemservice.repository.mybatis;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.net.FileNameMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MyBatisRepository implements ItemRepository {
    // 자동으로 빈으로 등록된 itemMapper의 구현체를 주입받는다.
    private final ItemMapper itemMapper;

    @Override
    public Item save(Item item) {
        itemMapper.save(item);
        return item;
    }

    @Override
    public void update(Long id, ItemUpdateDto updateParam) {
        itemMapper.update(id,updateParam);
    }

    @Override
    public List<Item> findAll(ItemSearchCond itemSearch) {
        return itemMapper.findAll(itemSearch);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemMapper.findById(id);
    }
}
