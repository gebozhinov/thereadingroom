package bg.thereadingroom.web;

import bg.thereadingroom.model.dto.ViewStoreDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreController implements StoreApiDelegate {

    @Override
    public ResponseEntity<ViewStoreDTO> viewStore(Integer id) {

        ViewStoreDTO viewStoreDTO = new ViewStoreDTO();
        viewStoreDTO.setId(id);

        return ResponseEntity.ok(viewStoreDTO);
    }
}
