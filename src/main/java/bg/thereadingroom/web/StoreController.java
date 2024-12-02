package bg.thereadingroom.web;

import bg.thereadingroom.web.StoreApi;
import bg.thereadingroom.model.dto.ViewStoreDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/store")
@Tag(name = "Store", description = "Store management APIs")
public class StoreController extends StoreApi {

    @GetMapping
    @Operation(summary = "View store")
    public ViewStoreDTO viewStore(Integer id) {
        return new ViewStoreDTO();
    }
}
