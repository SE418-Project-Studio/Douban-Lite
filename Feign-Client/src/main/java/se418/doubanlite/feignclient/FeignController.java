package se418.doubanlite.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se418.doubanlite.feignclient.model.CatalogItem;

import java.util.List;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public List<CatalogItem> getCatalog(String userId) {
        System.out.println(userId);
        return feignService.getCatalog(userId);
    }

}
