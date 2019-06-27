package se418.doubanlite.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import se418.doubanlite.feignclient.model.CatalogItem;

import java.util.List;

@FeignClient(name = "book-catalog-service")
public interface FeignService {

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    List<CatalogItem> getCatalog(@RequestParam("userId") String userId);

}
