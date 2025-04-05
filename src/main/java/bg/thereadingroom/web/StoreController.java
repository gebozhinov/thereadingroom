package bg.thereadingroom.web;

import bg.thereadingroom.model.dto.ViewStoreDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StoreController implements StoreApiDelegate {

    @Override
    public ResponseEntity<ViewStoreDTO> viewStore(Integer id) {

        ViewStoreDTO viewStoreDTO = ViewStoreDTO.builder()
                .setId(id)
                .build();

        return ResponseEntity.ok(viewStoreDTO);
    }
}
